package com.stock.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.service.CompanyService;
import com.stock.service.DataService;
import com.stock.service.SpiderService;
import com.stock.vo.Company;

@Controller
public class EchartDataController {
	@Resource(name="dataService")
	private DataService dataService;
	
	@Resource(name="companyService")
	private CompanyService companyService;
	
	@Resource(name="spiderServiceDailyImpl")
	private SpiderService spiderServiceDaily;
	
	@Resource(name="spiderServiceHistoryImpl")
	private SpiderService spiderServiceHistory;
	
	@RequestMapping("/echartData")
	public void getData(HttpServletRequest request, HttpServletResponse response){
		String dealCode = request.getParameter("dealCode");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
			
		try {
			response.getWriter().print(dataService.getData1(dealCode, startDate, endDate));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
//		List<Company> companyList = companyService.findAll();
//		for(int i = 1;i<companyList.size() ; i++)
//		{
//			spiderServiceDaily.getDealMessage(companyList.get(i));
//		}
		
	}

}
