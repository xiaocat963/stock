package com.stock.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.stock.dao.DealDao;
import com.stock.service.DealService;
import com.stock.vo.Deal;
import com.stock.vo.QueryCriteria;

@Service("dealService")
public class DealServiceImpl extends BaseServiceImpl<Deal> implements DealService{

	
	private DealDao dealDao;
	@Resource(name="dealDaoImpl")
	public void setBaseDao(DealDao dealDao) {
		super.setBaseDao(dealDao);
		this.dealDao = dealDao;
	}
	
	@Override
	public List<Deal> findByCode(String code) {
		return dealDao.findByCode(code);
	}

	@Override
	public List<Deal> findByDateInterval(String code, Date start, Date end) {
		return dealDao.findByDateInterval(code, start, end);
	}

	/**
	 * 插入之前先删除当天之前的交易记录
	 */
	@Override
	public void addDeal(Deal deal) {
		List<Deal> result = dealDao.findByCodeAndDate(deal.getCode(), deal.getDate());
		Deal d = result.isEmpty() ? null :  result.get(0);
		if(d != null){
			Integer dealId = d.getDealId();
			BeanUtils.copyProperties(deal, d, Deal.class);
			d.setDealId(dealId);
		}else{
			dealDao.save(deal);
		}
	}

	@Override
	public List<Deal> findAll(QueryCriteria criteria) {
		return dealDao.findAll(criteria);
	}

	@Override
	public int findCountAll(QueryCriteria criteria) {
		return dealDao.findCountAll(criteria);
	}

	@Override
	public List<Deal> findAllByPage(int pageNo, int pageSize, QueryCriteria criteria) {
		return dealDao.findAllByPage(pageNo, pageSize, criteria);
	}

}
