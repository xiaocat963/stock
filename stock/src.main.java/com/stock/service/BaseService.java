package com.stock.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	
	public void save(T entiry);
	public void update(T entity);
	public void delete(T entity);
	public void delete(Serializable id);
	public T findById(Serializable id);
//	public List<T> findByHQL(String hql, Object... params);

}
