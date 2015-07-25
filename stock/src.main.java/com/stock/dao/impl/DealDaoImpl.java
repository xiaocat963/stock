package com.stock.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.stock.dao.DealDao;
import com.stock.vo.Deal;
import com.stock.vo.DealQueryCriteria;

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
		return this.findByHQL(hql, code,start,end);
	}

	@Override
	public List<Deal> findByCodeAndDate(String code, Date date) {
		String hql = "from Deal where code = ? and DATE_FORMAT(date,'%Y-%m-%d') = DATE_FORMAT(?,'%Y-%m-%d')";
		return this.findByHQL(hql, code, date);
	}

	public static void main(String[] args) {
		String hql = "from Deal";
		DealDaoImpl daoImpl = new DealDaoImpl();
		DealQueryCriteria criteria = new DealQueryCriteria();
		criteria.setCode("988734");
		criteria.setStartDate("2015-09-09");
		try {
			System.out.println(daoImpl.createSql(hql, criteria));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
