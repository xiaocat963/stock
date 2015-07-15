package com.stock.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.stock.dao.DealDao;
import com.stock.service.DealService;
import com.stock.service.SpiderService;
import com.stock.vo.Company;
import com.stock.vo.Deal;

@Service("spiderServiceHistoryImpl")
public class SpiderServiceHistoryImpl implements SpiderService{

	@Resource(name="dealService")
	private DealService dealService;

	@Override
	public String getPageStr(String companyCode) {
		String Url = "http://money.finance.sina.com.cn/corp/go.php/vMS_MarketHistory/stockid/@code.phtml";
		Url = Url.replace("@code", companyCode);
		Document doc = null;
		
		try {
			doc = Jsoup.connect(Url).get();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		if(doc == null)
			return null;	
		System.out.println(doc.toString());
		return doc.toString();
	}

	@Override
	public List<Deal> pageAnalyser(String strHtml, Company company) {
		if(strHtml == null)
			return null;
		Document doc = Jsoup.parse(strHtml);
		
		List<Deal> dealList = new ArrayList<Deal>();
		
		Element dealElement =  doc.getElementById("FundHoldSharesTable");
		if(dealElement == null)
			return null;
		Element tbodyElement = dealElement.select("tbody").first();
		System.out.println(tbodyElement.text());
		
		for(int i=1;i < tbodyElement.childNodeSize() / 2;i++)
		{
			Element elementItem = tbodyElement.child(i);
			Deal deal = new Deal();
			
			String dateStr = elementItem.child(0).text();
			String openPrize = elementItem.child(1).text();
			String highPrize = elementItem.child(2).text();
			String closePrize = elementItem.child(3).text();
			String lowPrize = elementItem.child(4).text();
			String dealCount = elementItem.child(5).text();
			String dealAmount = elementItem.child(6).text();

			System.out.println(Float.parseFloat(openPrize)+","+Float.parseFloat(highPrize)+","+Float.parseFloat(closePrize)+","+Float.parseFloat(lowPrize)+","+lowPrize);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date utilDate= null;
			try {
				utilDate = formatter.parse(dateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(utilDate == null)
				return null;
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			deal.setDate(sqlDate);
			deal.setOpen(Float.parseFloat(openPrize));
			deal.setHigh(Float.parseFloat(highPrize));
			deal.setClose(Float.parseFloat(closePrize));
			deal.setLow(Float.parseFloat(lowPrize));
			deal.setVolume(Float.parseFloat(dealCount));
			deal.setTurnover(Float.parseFloat(dealAmount));
			deal.setCode(company.getCode());
			
			dealList.add(deal);
		}
		
		
		return dealList;
	}

	@Override
	public boolean getDealMessage(Company company) {
		String strHtml = getPageStr(company.getCode());
		
		List<Deal> dealList = pageAnalyser(strHtml,company);
		if(dealList == null)
			return false;
		
		for(Deal deal : dealList)
		{
			if(deal != null)
				dealService.addDeal(deal);
		}
		
		return false;
	}
	
}
