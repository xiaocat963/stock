package com.stock.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stock.service.CompanyService;
import com.stock.utils.FileUtil;
import com.stock.vo.Company;

@Controller
public class ImportController {

	@Resource(name="companyService")
	private CompanyService companyService;
	
	/*@Resource(name="companyImportService")
	private CompanyImportService cis;*/
	
	/*@RequestMapping("/importCompany")
	public String importCompany(MultipartFile file){
		try {
			cis.setInputStream(file.getInputStream());
			cis.process();
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "fail";
	}*/
	
	@RequestMapping("/importCompany")
	public String importCompany(@RequestParam("file") MultipartFile mfile){
		try {
			String[][] result = FileUtil.getData(mfile.getInputStream(), 1);
			if(result != null){
				for(int i = 0; i < result.length; i++){
					Company company = new Company();
					company.setCode(result[i][0]);
					company.setName(result[i][1]);
					companyService.save(company);
				}
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
	@RequestMapping("/toUpload")
	public String toUpload(){
		return "upload";
	}
	
	@RequestMapping("/userSave")
	public  @ResponseBody Map<String,String> ajaxDemo(String name, Integer age, String gender){
		System.out.println(name + "|" + age + "|" + gender);
		Map<String,String> map = new HashMap<String,String>();
		map.put("info", "success");
		return map;
	}
}
