package com.stock.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stock.vo.StockMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StockMessageServiceTest {

	@Autowired
	private StockMessageService service;
	
	@Test
	public void saveTest(){
		System.out.println(service);
		StockMessage sm = new StockMessage();
		sm.setStockId(2);
		sm.setStockName("bibo");
		sm.setCreateTime(new Date());
		service.save(sm);
	}
	
	@Test
	public void test(){
		System.out.println("hahah");
	}
	
	@Test
	public void findByIdTest(){
		int id = 3;
		StockMessage objStockMessage = service.findById(id);
		System.out.println(objStockMessage.getStockName());
	}
	
	@Test
	public void updateTest(){
		StockMessage sm = new StockMessage();
		sm.setStockId(1);
		sm.setStockName("zhangyufeng");
		sm.setCreateTime(new Date());
		service.update(sm);
	}
	
	@Test
	public void deleteTest(){
		service.delete(3);
	}
	
}
