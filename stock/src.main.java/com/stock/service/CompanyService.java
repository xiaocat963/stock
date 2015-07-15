package com.stock.service;


import java.util.List;

import com.stock.vo.Company;

public interface CompanyService extends BaseService<Company>{
	 
	public int findCountByCodeAndName(String code, String name);
	
	public Company findByCode(String code);
	
	public List<Company> findByName(String name);
	
	public void deleteBatch(Integer[] ids);
}
