package com.stock.vo;

import java.io.Serializable;
import java.util.Date;


public class StockMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3383472784190200685L;
	/**
	 * ��Ʊ����Ϣ
	 */
	private int stockId;
	private String stockName;
	private Date createTime;
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
