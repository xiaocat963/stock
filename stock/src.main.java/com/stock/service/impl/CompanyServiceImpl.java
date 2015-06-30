package com.stock.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.CompanyDao;
import com.stock.service.CompanyService;
import com.stock.vo.Company;

@Service("companyService")
@Transactional
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService{
	
	private CompanyDao companyDao;
	@Resource(name = "companyDao")
	public void setBaseDao(CompanyDao companyDao) {
		super.setBaseDao(companyDao);
		this.companyDao = companyDao;
	}

//	@Override
//	public void save(Company company){
//		
//		List<Company> result = companyDao.findByName(company.getName());
//		
//		if(result == null || result.size() == 0){
//			
//			companyDao.save(company);
//		}
//	}

	@Override
	public int findCountByCodeAndName(String code, String name) {
		
		return companyDao.findCountByNameAndCode(code, name);
	}

	@Override
	public List<Company> findAll() {
		
		List<Company> result = companyDao.findAll();
		return result;
	}

	@Override
	public int findCountAll() {
		
		return companyDao.findCountAll();
	}

	@Override
	public List<Company> findAllByPage(int pageNo, int pageSize) {
		
		return companyDao.findAllByPage(pageNo, pageSize);
	}
}
