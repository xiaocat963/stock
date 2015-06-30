package com.stock.service;


import java.util.List;

import com.stock.vo.Company;

public interface CompanyService extends BaseService<Company>{
	 
	public int findCountByCodeAndName(String code, String name);
	
	public List<Company> findAll();
	
	public int findCountAll();
	
	public List<Company> findAllByPage(int pageNo, int pageSize);
}
