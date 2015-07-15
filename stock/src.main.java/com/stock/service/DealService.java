package com.stock.service;

import java.util.Date;
import java.util.List;

import com.stock.vo.Deal;
import com.stock.vo.QueryCriteria;

public interface DealService extends BaseService<Deal>{

	public List<Deal> findByCode(String code);
	
	public List<Deal> findByDateInterval(String code, Date start, Date end);
	
	public void addDeal(Deal deal);

	public List<Deal> findAll(QueryCriteria criteria);
	
	public int findCountAll(QueryCriteria criteria);
	
	public List<Deal> findAllByPage(int pageNo, int pageSize, QueryCriteria criteria);
}
