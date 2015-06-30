package com.stock.dao.impl;


import java.util.List;

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
	public List<Company> findAll() {
		
		String hql = "from Company";
		
		return (List<Company>)this.findByHQL(hql);
	}

	@Override
	public int findCountAll() {
		
		String hql = "select count(*) from Company";
		return findCountByHQL(hql);
	}

	@Override
	public List<Company> findAllByPage(int pageNo, int pageSize) {
		
		String hql = "from Company";
		return findPageByHQL(hql, pageNo, pageSize);
	}
	
}
