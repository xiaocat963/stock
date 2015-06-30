package com.stock.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stock.vo.Company;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CompanyServiceTest {
	
	@Autowired
	CompanyService companyService;
	@Test
	public void saveTest(){
		
		Company company = new Company();
		company.setCode("11112");
		company.setName("工商银行");
		company.setStatus(1);
		companyService.save(company);
	}
	
	@Test
	public void updateTest(){
		
		Company company = new Company();
		company.setCompanyId(8);
		company.setCode("11112");
		company.setName("农业银行");
		company.setStatus(1);
		companyService.update(company);
	}
	
	@Test
	public void deleteTest(){
		
		Company company = new Company();
		company.setCompanyId(8);
		company.setCode("11112");
		company.setName("农业银行");
		company.setStatus(1);
		companyService.delete(company);
	}
	
	@Test
	public void deleteTest1(){
		
		companyService.delete(6);
	}
	
	@Test
	public void findByIdTest(){
		
		int id = 4;
		Company company = companyService.findById(id);
		System.out.println(company.getName());
	}
	
	@Test
	public void findByCodeAndNameTest(){
		
		int result = companyService.findCountByCodeAndName("11113","中国银行");
		System.out.println(result);
	}
	
	@Test
	public void findAllTest(){
		
		List<Company> result = companyService.findAll();
		System.out.println(result.size());
	}
	
	@Test
	public void findCountAllTest(){
		
		int result = companyService.findCountAll();
		System.out.println(result);
	}
	
	@Test
	public void findAllByPageTest(){
		
		List<Company> result = companyService.findAllByPage(2, 5);
		
		System.out.println(result.get(4).getName());
	}

}
