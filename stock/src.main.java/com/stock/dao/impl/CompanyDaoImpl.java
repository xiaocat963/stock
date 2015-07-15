package com.stock.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.stock.dao.CompanyDao;
import com.stock.vo.Company;

@Repository(value = "companyDao")
public class CompanyDaoImpl extends BaseDaoImpl<Company> implements CompanyDao {

	@Override
	public int findCountByNameAndCode(String code, String name) {
		
		String hql = "select count(*) from Company where code = ? and name = ?";
		
		return this.findCountByHQL(hql, code, name);
		
	}

	@Override
	public List<Company> findByCode(String code) {
		
		String hql = "from Company where code = ?";
		return (List<Company>)this.findByHQL(hql,code);
	}

	@Override
	public List<Company> findByName(String name) {
		
		String hql = "from Company where name like ?";
		return (List<Company>)this.findByHQL(hql,"%"+name+"%");
	}

	@Override
	public void batchDelete(Integer[] ids) {
		String hql = "delete from Company where companyid in (:ids)";
		Query query = this.getSession().createQuery(hql);
		query.setParameterList("ids", ids);
		query.executeUpdate();
	}
	
}
