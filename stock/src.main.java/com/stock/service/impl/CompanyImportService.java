package com.stock.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stock.dao.BaseDao;
import com.stock.vo.Company;


@Service("companyImportService")
public class CompanyImportService extends AbstractImportService{
	
	@Resource(name="companyDao")
	public void setBaseDao(BaseDao baseDao){
		super.setBaseDao(baseDao);
	}
	
	
	/*
	 * 数据格式 code|name|status
	 */
	@Override
	public Object handler(String strLine) {
		String[] strs = strLine.split("|");
		Company company = new Company();
		company.setCode(strs[0]);
		company.setName(strs[1]);
		company.setStatus(Integer.parseInt(strs[2]));
		return company;
	}
}
