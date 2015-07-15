package com.stock.vo;

import java.util.Date;


public class Deal {
	
	private Integer dealId;
	
	private String code;
	
	private float open;
	
	private float close;
	
	private float high;
	
	private float low;
	
	private float volume;
	
	private float turnover;
	
	private float capitalization;
	
	private Date date;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getOpen() {
		return open;
	}

	public void setOpen(float open) {
		this.open = open;
	}

	public float getClose() {
		return close;
	}

	public void setClose(float close) {
		this.close = close;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getLow() {
		return low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getTurnover() {
		return turnover;
	}

	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}

	public float getCapitalization() {
		return capitalization;
	}

	public void setCapitalization(float capitalization) {
		this.capitalization = capitalization;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	@Override
	public String toString() {
		return "Deal [dealId=" + dealId + ", code=" + code + ", open=" + open
				+ ", close=" + close + ", high=" + high + ", low=" + low
				+ ", volume=" + volume + ", turnover=" + turnover
				+ ", capitalization=" + capitalization + ", date=" + date + "]";
	}
	
	
	
}
