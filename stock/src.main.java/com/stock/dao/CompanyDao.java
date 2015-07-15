package com.stock.dao;


import java.util.List;

import com.stock.vo.Company;

public interface CompanyDao extends BaseDao<Company> {
	
	public int findCountByNameAndCode(String code, String name);
	
	public List<Company> findByCode(String code);
	
	public List<Company> findByName(String name);
	
	public void batchDelete(Integer[] ids);

}
