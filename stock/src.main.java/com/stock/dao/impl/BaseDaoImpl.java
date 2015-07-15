package com.stock.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;





import com.stock.dao.BaseDao;
import com.stock.utils.GenericsUtils;
import com.stock.vo.QueryCriteria;

@SuppressWarnings("unchecked")
@Repository(value = "baseDao")
public class BaseDaoImpl<T> implements BaseDao<T>{

	private Class<T> clazz;
	private String classSimpleName;
	public BaseDaoImpl(){
		clazz = (Class<T>)GenericsUtils.getSuperClassGenricType(this.getClass(), 0);
		classSimpleName = clazz.getSimpleName();
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
		Session session = this.getSession();
		session.delete(this.findById(id));
		session.flush();
	}

	@Override
	public void delete(T entity) {
		Session session = this.getSession();
		session.delete(entity);
		session.flush();
	};
	
	@Override
	public T findById(Serializable id) {
		return (T)this.getSession().get(this.clazz, id);
	}

	@Override
	public List<T> findByHQL(String hql, Object... params) {
		Query query = createQuery(hql, params);
		return query.list();
	}
	@Override
	public int findCountByHQL(String hql, Object... params) {
		Query query = createQuery(hql, params);
		return Integer.parseInt(String.valueOf(query.uniqueResult()));
	}
	@Override
	public List<T> findPageByHQL(String hql, int pageNo, int pageSize, Object... params) {
		Query query = createQuery(hql, params);
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	private Query createQuery(String hql, Object... params){
		Query query = this.getSession().createQuery(hql);
		for(int i = 0; params != null && i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		return query;
	}
	
	@Override
	public void saveOrUpdate(T entity) {
		this.getSession().saveOrUpdate(entity);
	}
	
	protected String createSql(String hql, QueryCriteria criteria) throws Exception{
		if(criteria != null){
			StringBuffer sb =  new StringBuffer(hql);
			if(hql.indexOf("where") == -1){
				sb.append(" where");
			}
			Field[] fields = criteria.getClass().getDeclaredFields();
			for(Field field : fields){
				field.setAccessible(true);
				String name = field.getName();
				Object value = field.get(criteria);
				if(value != null){
					if(name.endsWith("startDate")){
						sb.append(" DATE_FORMAT(date,'%Y-%m-%d') >='" + value + "' and");
					}else if(name.endsWith("endDate")){
						sb.append(" DATE_FORMAT(date,'%Y-%m-%d') <='" + value + "' and");
					}else{
						sb.append(" " + name + "=" + value + " and");
					}
				}
			}
			return sb.substring(0, sb.lastIndexOf("and"));
		}else{
			return hql;
		}
	}
	@Override
	public List<T> findAll(QueryCriteria criteria) {
		String hql = "from " + classSimpleName;
		try {
			hql = createSql(hql, criteria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findByHQL(hql);
	}
	@Override
	public int findCountAll(QueryCriteria criteria) {
		String hql = "select count(*) from " + classSimpleName;
		try {
			hql = createSql(hql, criteria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findCountByHQL(hql);
	}
	@Override
	public List<T> findAllByPage(int pageNo, int pageSize,
			QueryCriteria criteria) {
		String hql = "from " + classSimpleName;
		try {
			hql = createSql(hql, criteria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findPageByHQL(hql, pageNo, pageSize);
	}
}
