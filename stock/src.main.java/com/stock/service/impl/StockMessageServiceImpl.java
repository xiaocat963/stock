package com.stock.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.BaseDao;
import com.stock.service.StockMessageService;
import com.stock.vo.StockMessage;

@Service("stockMessageService")
@Transactional
public class StockMessageServiceImpl extends BaseServiceImpl<StockMessage> implements StockMessageService {

	@Resource(name = "stockMessageDao")
	public void setBaseDao(BaseDao<StockMessage> baseDao) {
		super.setBaseDao(baseDao);
	}
}
