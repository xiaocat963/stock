package com.stock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stock.service.CompanyService;
import com.stock.vo.Company;
import com.stock.vo.CompanyQueryCriteria;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	//分页大小
	private static final int PAGE_SIZE = 15;
	
	@RequestMapping(value = "/findAllCompany")
	public String findAllCompany(Model model,CompanyQueryCriteria criteria, Integer pageNo) {
		
		List<Company> itemLists = new ArrayList<Company>();
		pageNo = pageNo == null ? 1 : pageNo;
		itemLists = (List<Company>)companyService.findAllByPage(pageNo, PAGE_SIZE, criteria);
		int totalItem = companyService.findCountAll(criteria);
		int totalPage = totalItem / PAGE_SIZE;
		totalPage = totalItem % PAGE_SIZE == 0 ? totalPage : totalPage + 1 ;
		model.addAttribute("totalItem", totalItem);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("itemList", itemLists);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("criteria", criteria);
		return "company";
	}
	@RequestMapping(value = "/addCompany")
	@ResponseBody
	public Map<String, Integer> addCompany(Company company){
		
		Map<String, Integer> result =new HashMap<String, Integer>();
		int recordCount = companyService.findCountByCodeAndName(company.getCode(), company.getName());
		if(recordCount > 0){
			result.put("code", 100);
		}else{
			try{
				companyService.save(company);
				result.put("code", 200);
			}catch(Exception e){
				result.put("code", 0);
			}
		}
		return result;
	}
	@RequestMapping(value = "/deleteCompany")
	@ResponseBody
	public Map<String, Integer> deleteCompany(String companyId) {
		
		Map<String, Integer> result = new HashMap<String, Integer>();
		try{
			companyService.delete(Integer.parseInt(companyId));
			result.put("code", 200);
		}catch(Exception e){
			result.put("code", 0);
		}
		return result;
	}
	@RequestMapping(value = "/editCompany")
	@ResponseBody
	public Map<String, Integer> editCompany(Company company) {
		
		Company companyResult;
		Map<String, Integer> result = new HashMap<String, Integer>();
		companyResult = companyService.findByCode(company.getCode());
		if(companyResult != null && companyResult.getCompanyId() != company.getCompanyId()){
			result.put("code", 100);
		}else{
			try{
				companyService.update(company);
				result.put("code", 200);
			}catch(Exception e){
				result.put("code", 0);
			}
		}
		return result;
	}
	
	@RequestMapping(value="batchDelete")
	@ResponseBody
	public Map<String,Integer> batchDelete(String idsStr){
		Map<String, Integer> result = new HashMap<String, Integer>();
		String[] idArray = idsStr.split(",");
		Integer[] ids = new Integer[idArray.length];
		for(int i = 0; i < ids.length; i++){
			ids[i] = Integer.parseInt(idArray[i]);
		}
		try{
			companyService.deleteBatch(ids);
			result.put("code", 200);
		}catch(Exception e){
			result.put("code", 0);
		}
		return result;
	}
}
