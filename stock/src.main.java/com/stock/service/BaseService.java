package com.stock.service;

import java.io.Serializable;
import java.util.List;

import com.stock.vo.QueryCriteria;

public interface BaseService<T> {
	
	public void save(T entiry);
	public void update(T entity);
	public void delete(T entity);
	public void delete(Serializable id);
	public T findById(Serializable id);
	public List<T> findAll(QueryCriteria criteria);
	public int findCountAll(QueryCriteria criteria);
	public List<T> findAllByPage(int pageNo, int pageSize, QueryCriteria criteria);

}
