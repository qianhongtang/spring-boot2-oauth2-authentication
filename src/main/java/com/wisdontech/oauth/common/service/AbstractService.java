package com.wisdontech.oauth.common.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.google.common.collect.Iterables;
import com.wisdontech.oauth.common.repository.BaseRepository;

/**
 * 基础service 类
 * 
 * @author wenchongyang
 *
 * @param <T>
 * @param <ID>
 * @param <R>
 */
@SuppressWarnings("unchecked")
public abstract class AbstractService<T, ID extends Serializable, R extends BaseRepository<T, ID>> {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	protected R repository;

	public T getOne(ID id) {
		if (id == null) {
			return null;
		}
		return repository.getOne(id);
	}

	public Page<T> findAll(Pageable pageable) {
		if (pageable == null) {
			return null;
		}
		return repository.findAll(pageable);
	}

	public T save(T entity) {
		if (entity == null) {
			return null;
		}
		return repository.save(entity);
	}

	public boolean exists(Example<T> example) {
		if (example == null) {
			return false;
		}
		return repository.exists(example);
	}

	public long count() {
		return repository.count();
	}

	public void delete(ID... ids) {
		if (ArrayUtils.isEmpty(ids)) {
			return;
		}
		delete(Arrays.asList(ids));
	}

	public void delete(List<ID> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return;
		}
		ids.forEach(id -> repository.deleteById(id));
	}

	public void delete(T entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<T> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Optional<T> findOne(Specification<T> spec) {
		if (spec == null) {
			return null;
		}
		return repository.findOne(spec);
	}

	public List<T> findAll(Specification<T> spec) {
		if (spec == null) {
			return new ArrayList<>();
		}
		return repository.findAll(spec);
	}

	public Page<T> findAll(Specification<T> spec, Pageable pageable) {
		if (spec == null) {
			return null;
		}
		return repository.findAll(spec, pageable);
	}

	public List<T> findAll(Specification<T> spec, Sort sort) {
		if (spec == null) {
			return new ArrayList<>();
		}
		return repository.findAll(spec, sort);
	}

	public long count(Specification<T> spec) {
		if (spec == null) {
			return -1;
		}
		return repository.count(spec);
	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public List<T> findAll(Sort sort) {
		if (sort == null) {
			return new ArrayList<>();
		}
		return repository.findAll(sort);
	}

	public List<T> findAllById(Iterable<ID> ids) {
		if (Iterables.isEmpty(ids)) {
			return new ArrayList<>();
		}
		return repository.findAllById(ids);
	}

	public List<T> findAll(Example<T> example) {
		if (example == null) {
			return new ArrayList<>();
		}
		return repository.findAll(example);
	}

	public List<T> saveAll(Iterable<T> entities) {
		if (Iterables.isEmpty(entities)) {
			return new ArrayList<>();
		}
		return repository.saveAll(entities);
	}

	public void flush() {
		repository.flush();
	}

	public T saveAndFlush(T entity) {
		if (entity == null) {
			return null;
		}
		return repository.saveAndFlush(entity);
	}

	public void deleteInBatch(Iterable<T> entities) {
		repository.deleteInBatch(entities);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public List<T> findAll(Example<T> example, Sort sort) {
		if (example == null || sort == null) {
			return new ArrayList<>();
		}
		return repository.findAll(example, sort);
	}

}
