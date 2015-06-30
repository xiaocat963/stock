package com.stock.dao.impl;

import org.springframework.stereotype.Repository;

import com.stock.dao.StockMessageDao;
import com.stock.vo.StockMessage;

@Repository(value="stockMessageDao")
public class StockMessageDaoImpl extends BaseDaoImpl<StockMessage> implements StockMessageDao{

}
