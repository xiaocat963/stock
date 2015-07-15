package com.stock.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stock.service.DataService;
import com.stock.service.DealService;
import com.stock.vo.Deal;

@Service("dataService")
public class DataServiceImpl implements DataService{
	@Resource(name="dealService")
	private DealService dealService;
	
	@Override
	public String getData1(String dealCode, String startDate, String endDate) {
		String dateString = "\"date\":[";
		String dealString = "\"dealPrize\":[";
		String averageStr = "\"average\":[";
		String historyAveStr = "\"history\":[";
		float averagePrize;
		float haveragePrize;
		float sumAmount=0;
		float sumCount=0;
		
		if(dealCode.trim() == "" || dealCode == null)
			return null;
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
		java.util.Date dateStart = null;
		java.util.Date dateEnd = null;
		try {
			dateStart = format1.parse(startDate);
			dateEnd = format1.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDateStart = new java.sql.Date(dateStart.getTime());
		java.sql.Date sqlDateEnd = new java.sql.Date(dateEnd.getTime());
		List<Deal> dealList = dealService.findByDateInterval(dealCode, sqlDateStart, sqlDateEnd);
		if(dealList.size() == 0)
		{
			return null;
		}
		//out.println("{"+"stockName:\"" +dealList.get(0).getStock().getName()+"\","+"result:[");
		for(Deal deal : dealList)
		{
			averagePrize = deal.getTurnover()/deal.getVolume();
			sumAmount += deal.getTurnover();
			sumCount += deal.getVolume();
			haveragePrize = sumAmount / (float)sumCount;
			dateString += ("\""+deal.getDate() + "\",");
			dealString += ("["+deal.getOpen()+","+deal.getClose()+","+deal.getHigh()+","+deal.getLow()+"],");
			averageStr += (averagePrize + ",");
			historyAveStr += (haveragePrize + ",");
		}
		dateString = dateString.substring(0, dateString.length()-1);
		dateString += "]";
		dealString = dealString.substring(0,dealString.length()-1);
		dealString += "]";
		averageStr = averageStr.substring(0,averageStr.length()-1);
		averageStr += "]";
		historyAveStr = historyAveStr.substring(0,historyAveStr.length()-1);
		historyAveStr += "]";
		return "{"+"\"stockName\":\"" +dealList.get(0).getCode()+"\","+dateString+","+dealString+","+averageStr+","+historyAveStr+"}";
	}

	@Override
	public String getData2(String dealCode, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
