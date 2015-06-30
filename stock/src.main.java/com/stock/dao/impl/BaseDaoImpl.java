package com.stock.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;




import com.stock.dao.BaseDao;
import com.stock.utils.GenericsUtils;

@SuppressWarnings("unchecked")
@Repository(value = "baseDao")
public class BaseDaoImpl<T> implements BaseDao<T>{

	private Class<T> clazz;
	public BaseDaoImpl(){
//		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
//		clazz = (Class<T>)type.getActualTypeArguments()[0];
		clazz = (Class<T>)GenericsUtils.getSuperClassGenricType(this.getClass(), 0);
		System.out.println("当前执行类名------------------"+clazz.getName());
	}
	@Resource
	private SessionFactory sessionFactory;
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public void save(T entity) {
		this.getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		this.getSession().update(entity);
	}

	@Override
	public void delete(Serializable id) {
		this.getSession().delete(this.findById(id));
	}

	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	};
	
	@Override
	public T findById(Serializable id) {
		return (T)this.getSession().get(this.clazz, id);
	}

	@Override
	public List<T> findByHQL(String hql, Object... params) {
		Query query = this.getSession().createQuery(hql);
		for(int i = 0; params != null && i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		return query.list();
	}
	@Override
	public int findCountByHQL(String hql, Object... params) {
		Query query = this.getSession().createQuery(hql);
		for(int i = 0; params != null && i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		return Integer.parseInt(String.valueOf(query.uniqueResult()));
	}
	@Override
	public List<T> findPageByHQL(String hql, int pageNo, int pageSize, Object... params) {
		
		Query query = this.getSession().createQuery(hql);
		for(int i = 0; params != null && i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
}
