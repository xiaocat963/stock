package com.stock.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.stock.dao.CompanyDao;
import com.stock.dao.DealDao;
import com.stock.service.SpiderService;
import com.stock.vo.Company;
import com.stock.vo.Deal;

public class SpiderServiceDailyImpl implements SpiderService {
	String url = "http://hq.sinajs.cn/list=sh";

	private DealDao dealDao;
	@Resource(name = "dealDao")
	@Override
	public String getPageStr(String companyCode) {
		String urlStr = url + companyCode;
		HttpClient client = new HttpClient();  
        StringBuilder sb = new StringBuilder();  
        InputStream ins = null;  
        // Create a method instance.  
        GetMethod method = new GetMethod(urlStr);  
        // Provide custom retry handler is necessary  
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,  
                new DefaultHttpMethodRetryHandler(3, false));  
        try {  
            // Execute the method.  
            int statusCode = client.executeMethod(method);  
            System.out.println(statusCode);  
            if (statusCode == HttpStatus.SC_OK) {  
                ins = method.getResponseBodyAsStream();  
                byte[] b = new byte[1024];  
                int r_len = 0;  
                while ((r_len = ins.read(b)) > 0) {  
                    sb.append(new String(b, 0, r_len, method  
                            .getResponseCharSet()));  
                }  
            } else {  
                System.err.println("Response Code: " + statusCode);  
            }  
        } catch (HttpException e) {  
            System.err.println("Fatal protocol violation: " + e.getMessage());  
        } catch (IOException e) {  
            System.err.println("Fatal transport error: " + e.getMessage());  
        } finally {  
            method.releaseConnection();  
            if (ins != null) {  
                try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}  
            }  
        }  
        System.out.println(sb.toString());
        return sb.toString();
	}

	@Override
	public List<Deal> pageAnalyser(String strHtml, Company company) {
		List<Deal> dealList = new ArrayList<Deal>();
		String htmlStr = strHtml;
		System.out.println( htmlStr +"");
		
		int index = htmlStr.indexOf("\"");
		htmlStr = htmlStr.substring(index);
		String[] prizeStr = htmlStr.split(",");
		
		if(prizeStr.length <= 1)
			return dealList;
		
		Deal deal = new Deal();
				
		deal.setCode(company.getCode());
		deal.setOpen(Float.parseFloat(prizeStr[1]));
		deal.setClose(Float.parseFloat(prizeStr[3]));
		deal.setHigh(Float.parseFloat(prizeStr[4]));
		deal.setLow(Float.parseFloat(prizeStr[5]));
		deal.setVolume(Float.parseFloat(prizeStr[8]));
		deal.setTurnover(Float.parseFloat(prizeStr[9]));
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate= null;
		try {
			utilDate = formatter.parse(prizeStr[prizeStr.length-3]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(utilDate == null)
			return null;
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		deal.setDate(sqlDate);
		
		dealList.add(deal);
		return dealList;
	}

	@Override
	public boolean getDealMessage(Company company) {
		String strHtml = getPageStr(company.getCode());
		if(strHtml == null)
			return false;
		
		List<Deal> dealList = pageAnalyser(strHtml,company);
		for(Deal deal: dealList)
		{
			if(deal != null)
				dealDao.save(deal);
		}
		return true;
	}

}
