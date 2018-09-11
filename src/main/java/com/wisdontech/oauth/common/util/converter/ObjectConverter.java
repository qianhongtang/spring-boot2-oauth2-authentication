/*
 * Project Name: wxpay
 * File Name: ObjectConverter.java
 * Class Name: ObjectConverter
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

/**
 * Class Name: ObjectConverter
 * 
 * @author SC
 * 
 * @param <F>
 * @param <T>
 */
public interface ObjectConverter {

	/**
	 * Description: convert from domain to dto
	 *
	 * @param domain
	 * @param target
	 */
	<S, F> void convertFromDomain(S source, F target);

	/**
	 * Description: convert from dto to domain
	 *
	 * @param source
	 * @param domain
	 */
	<S, F> void convertToDomain(S source, F target);

}
