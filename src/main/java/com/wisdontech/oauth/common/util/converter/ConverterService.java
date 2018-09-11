/*
 * Project Name: wxpay
 * File Name: ConverterService.java
 * Class Name: ConverterService
 *
 * Copyright 2015 kandinfo Software Inc
 *
 * 
 *
 * http://www.tangqh.com
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wisdontech.oauth.common.util.converter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.wisdontech.oauth.common.util.ApplicationContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;
import org.springframework.util.CollectionUtils;

/**
 * Class Name: ConverterService Description: provides a conversion utility in
 * converting between PO and DTO back and forth.
 * 
 * @author SC
 * 
 */
public final class ConverterService {

	private static final Map<String, BeanCopier> CACHED_COPIER_MAP = new ConcurrentHashMap<String, BeanCopier>();
	private static final Map<String, ObjectConverter> CACHED_CUSTOM_CONVERTER_MAP = new ConcurrentHashMap<String, ObjectConverter>();
	private static final String PO = "Po";
	private static final String DTO = "Dto";
	private static final Logger LOGGER = LoggerFactory.getLogger(ConverterService.class);

	private ConverterService() {

	}

	/**
	 * @Author Wql
	 * @Description 获取属性值为null的属性名
	 * @Date 2018/7/26 18:59
	 * @Param [source]
	 * @return java.lang.String[]
	 **/
	public static String[] getNullPropertyNames (Object source) {
		return getPropertyNames(source,false);
	}

	/**
	 * @Author Wql
	 * @Description 获取属性值不为null的属性名
	 * @Date 2018/7/26 19:00
	 * @Param [source]
	 * @return java.lang.String[]
	 **/
	public static String[] getNonNullPropertyNames (Object source) {
		return getPropertyNames(source,true);
	}

	private static String[] getPropertyNames (Object source,boolean nullFlag) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for(java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (!nullFlag && (srcValue == null)) emptyNames.add(pd.getName());
			if (nullFlag && (srcValue != null)) emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	public static <S, F> List<F> convert(List<S> sourceList, Class<F> targetClass) {
		List<F> list = new ArrayList<>();
		if (CollectionUtils.isEmpty(sourceList)) {
			return list;
		}
		sourceList.forEach(s -> list.add(convert(s, targetClass)));
		return list;
	}


	/** Overloaded methods */
	public static <S, F> F convert(S source, Class<F> targetClass) {
		return convert(source, targetClass, new DeepConverter(), null);
	}

	public static <S, F> F convert(S source, F target) {
		return convert(source, target, new DeepConverter(), null);
	}

	public static <S, F> F convert(S source, Class<F> targetClass,
			Class<? extends ObjectConverter> customConverterClass) {
		return convert(source, targetClass, new DeepConverter(), customConverterClass);
	}

	/** Private methods */

	private static <S, F> void copy(S source, F target, Converter converter,
			Class<? extends ObjectConverter> customConverterClass) {
		ObjectConverter customConverter = getCustomConverterInstance(customConverterClass);
		if (customConverter != null) {
			if (target.getClass().getName().endsWith(PO) || target.getClass().getName().endsWith(DTO)) {
				customConverter.convertFromDomain(source, target);
			} else if (source.getClass().getName().endsWith(PO) || source.getClass().getName().endsWith(DTO)) {
				customConverter.convertToDomain(source, target);
			}
		} else {
			BeanCopier beanCopier = getBeanCopierInstance(source, target.getClass(), converter);
			beanCopier.copy(source, target, converter);
		}
	}

	private static <S, F> BeanCopier getBeanCopierInstance(S source, Class<F> targetClass, Converter converter) {
		String key = source.getClass().getName() + "#" + targetClass.getName();
		BeanCopier beanCopier = CACHED_COPIER_MAP.get(key);
		if (beanCopier == null) {
			synchronized (CACHED_COPIER_MAP) {
				beanCopier = TypeAwareBeanCopier.instantiate(source.getClass(), targetClass, converter != null);
				CACHED_COPIER_MAP.put(key, beanCopier);
			}
		}
		return beanCopier;
	}

	private static ObjectConverter getCustomConverterInstance(Class<? extends ObjectConverter> customConverterClass) {
		if (customConverterClass == null) {
			return null;
		}
		String key = customConverterClass.getName();
		ObjectConverter converter = CACHED_CUSTOM_CONVERTER_MAP.get(key);
		if (converter == null) {
			synchronized (CACHED_CUSTOM_CONVERTER_MAP) {
				try {
					converter = ApplicationContextUtil.getBean(customConverterClass);
				} catch (BeansException e) {
					LOGGER.info(customConverterClass.getName() + " is not a component, need new instance.");
				}
				if (converter == null) {
					try {
						converter = customConverterClass.newInstance();
						CACHED_CUSTOM_CONVERTER_MAP.put(key, converter);
					} catch (InstantiationException | IllegalAccessException e) {
						return null;
					}
				}
			}
		}
		return converter;
	}

	/**
	 * Description: this method will be removed.
	 * 
	 * @param source
	 * @param targetClass
	 * @param converter
	 * @param customConverterClass
	 * @return
	 */
	private static <S, F> F convert(S source, Class<F> targetClass, Converter converter,
			Class<? extends ObjectConverter> customConverterClass) {
		if (source == null || targetClass == null) {
			return null;
		}
		try {
			F target = targetClass.newInstance();
			copy(source, target, converter, customConverterClass);
			return target;
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}

	public static <S, F> F convert(S source, F target, Converter converter,
			Class<? extends ObjectConverter> customConverterClass) {
		if (source == null || target == null) {
			return null;
		}
		copy(source, target, converter, customConverterClass);
		return target;
	}

}
