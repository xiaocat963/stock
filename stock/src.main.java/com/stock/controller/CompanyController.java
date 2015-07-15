package com.stock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "/findAllCompany")
	public ModelAndView findAllCompany(CompanyQueryCriteria criteria) {
		
		Map<String,List<Company>> model = new HashMap<String, List<Company>>();
		List<Company> itemLists = new ArrayList<Company>();
		itemLists = (List<Company>)companyService.findAll(criteria);
		model.put("itemList", itemLists);
		return new ModelAndView("/company",model);
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
