package com.stock.dao;

import java.io.Serializable;
import java.util.List;

import com.stock.vo.QueryCriteria;

public interface BaseDao<T> {
	
	public void save(T entity);
	public void update(T entity);
	public void delete(Serializable id);
	public void delete(T entity);
	public T findById(Serializable id);
	public List<T> findByHQL(String hql, Object...params);
	public int findCountByHQL(String hql, Object... params);
	public List<T> findPageByHQL(String hql, int pageNo, int pageSize, Object... params);
	public void saveOrUpdate(T entity);
	public List<T> findAll(QueryCriteria criteria);
	public int findCountAll(QueryCriteria criteria);
	public List<T> findAllByPage(int pageNo, int pageSize, QueryCriteria criteria);
}
