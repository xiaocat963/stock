package com.stock.service;

import java.util.List;

import com.stock.vo.Company;
import com.stock.vo.Deal;

public interface SpiderService {
	public String getPageStr(String companyCode);
	public List<Deal> pageAnalyser(String strHtml,Company company);
	public boolean getDealMessage(Company company);
}
