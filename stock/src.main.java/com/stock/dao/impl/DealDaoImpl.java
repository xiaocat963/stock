package com.stock.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.stock.dao.DealDao;
import com.stock.vo.Deal;

@Repository("dealDaoImpl")
public class DealDaoImpl extends BaseDaoImpl<Deal> implements DealDao{

	@Override
	public List<Deal> findByCode(String code) {
		String hql = "from Deal where code = ?";
		return this.findByHQL(hql, code);
	}

	@Override
	public List<Deal> findByDateInterval(String code, Date start, Date end) {
		String hql = "from Deal where code = ? and DATE_FORMAT(date,'%Y-%m-%d') >= DATE_FORMAT(?,'%Y-%m-%d') and  DATE_FORMAT(date,'%Y-%m-%d') <= DATE_FORMAT(?,'%Y-%m-%d')";
		//String hql = "from Deal where code = ? and date >= ? and date <= ?";
		return this.findByHQL(hql, code,start,end);
	}

	@Override
	public List<Deal> findByCodeAndDate(String code, Date date) {
		String hql = "from Deal where code = ? and DATE_FORMAT(date,'%Y-%m-%d') = DATE_FORMAT(?,'%Y-%m-%d')";
		return this.findByHQL(hql, code, date);
	}

	
}
