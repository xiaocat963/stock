package com.stock.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.CompanyDao;
import com.stock.service.CompanyService;
import com.stock.vo.Company;
import com.stock.vo.QueryCriteria;

@Service("companyService")
@Transactional
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService{
	
	private CompanyDao companyDao;
	@Resource(name = "companyDao")
	public void setBaseDao(CompanyDao companyDao) {
		super.setBaseDao(companyDao);
		this.companyDao = companyDao;
	}

	@Override
	public int findCountByCodeAndName(String code, String name) {
		
		return companyDao.findCountByNameAndCode(code, name);
	}

	@Override
	public Company findByCode(String code) {
		
		List<Company> result = new ArrayList<Company>();
		result = companyDao.findByCode(code);
		Company company;
		if(result == null){
			company = null;
		}else{
			company = (Company)result.get(0);
		}

		return company;
	}

	@Override
	public List<Company> findByName(String name) {
		
		return companyDao.findByName(name);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		companyDao.batchDelete(ids);
	}
}
