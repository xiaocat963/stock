package com.stock.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.BaseDao;
import com.stock.service.BaseService;
import com.stock.vo.QueryCriteria;

@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Resource(name = "baseDao")
	private BaseDao<T> baseDao;
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(T entiry) {
		baseDao.save(entiry);
		
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {
		baseDao.delete(id);
	}

	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	@Override
	public T findById(Serializable id) {
		return baseDao.findById(id);
	}

	@Override
	public List<T> findAll(QueryCriteria criteria) {
		return baseDao.findAll(criteria);
	}

	@Override
	public int findCountAll(QueryCriteria criteria) {
		return baseDao.findCountAll(criteria);
	}

	@Override
	public List<T> findAllByPage(int pageNo, int pageSize,
			QueryCriteria criteria) {
		return baseDao.findAllByPage(pageNo, pageSize, criteria);
	}
}
