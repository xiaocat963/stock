package com.stock.dao;


import java.util.List;

import com.stock.vo.Company;

public interface CompanyDao extends BaseDao<Company> {
	
	public int findCountByNameAndCode(String code, String name);
	
	public List<Company> findAll();
	
	public int findCountAll();
	
	public List<Company> findAllByPage(int pageNo, int pageSize);

}
