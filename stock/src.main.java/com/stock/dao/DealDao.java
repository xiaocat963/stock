package com.stock.dao;

import java.util.Date;
import java.util.List;

import com.stock.vo.Deal;

public interface DealDao extends BaseDao<Deal>{

	public List<Deal> findByCode(String code);
	
	public List<Deal> findByDateInterval(String code, Date start, Date end);
	
	public List<Deal> findByCodeAndDate(String code, Date date);
	
}
