package com.wisdontech.oauth.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * 
 * @author qianhongtang
 *
 * @param <T>
 * @param <ID>
 * @param <R>
 */
@SuppressWarnings("unchecked")
public interface Service<T, ID extends Serializable> {

	public T getOne(ID id);

	public Page<T> findAll(Pageable pageable);

	public T save(T entity);

	public boolean exists(Example<T> example);

	public long count();

	public void delete(ID... ids);

	public void delete(List<ID> ids);

	public void delete(T entity);

	public void deleteAll(Iterable<T> entities);

	public void deleteAll();

	public Optional<T> findOne(Specification<T> spec);

	public List<T> findAll(Specification<T> spec);

	public Page<T> findAll(Specification<T> spec, Pageable pageable);

	public List<T> findAll(Specification<T> spec, Sort sort);

	public long count(Specification<T> spec);

	public List<T> findAll();

	public List<T> findAll(Sort sort);

	public List<T> findAllById(Iterable<ID> ids);

	public List<T> findAll(Example<T> example);

	public List<T> saveAll(Iterable<T> entities);

	public void flush();

	public T saveAndFlush(T entity);

	public void deleteInBatch(Iterable<T> entities);

	public void deleteAllInBatch();

	public List<T> findAll(Example<T> example, Sort sort);
}
