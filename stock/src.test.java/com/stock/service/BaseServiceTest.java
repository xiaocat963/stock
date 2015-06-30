package com.stock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/src/main/webapp/WEB-INF/spring/applicationContext.xml")
public class BaseServiceTest {

	@Autowired
	private BaseService service;
	
	@Test
	public void saveTest(){
		System.out.println(service.toString());
	}
}
