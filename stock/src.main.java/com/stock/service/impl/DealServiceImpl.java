package com.stock.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stock.dao.BaseDao;
import com.stock.dao.DealDao;
import com.stock.service.DealService;
import com.stock.vo.Deal;
import com.stock.vo.StockMessage;

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
		List<Deal> dealList = dealDao.findByCodeAndDate(deal.getCode(), deal.getDate());
		for(Deal d : dealList){
			dealDao.delete(d);
		}
		dealDao.save(deal);
	}

}
