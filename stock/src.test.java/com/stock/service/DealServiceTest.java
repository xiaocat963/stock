package com.stock.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stock.vo.Deal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DealServiceTest {

	@Resource(name="dealService")
	private DealService dealService;
	
	private Deal deal;
	
	@Before
	public void initDeal(){
		deal = new Deal();
		deal.setCode("张玉凤哈哈");
		deal.setCapitalization(4F);
		deal.setClose(3F);
		deal.setDate(new Date());
		deal.setHigh(5F);
		deal.setLow(2F);
		deal.setOpen(1F);
		deal.setTurnover(0.2F);
		deal.setVolume(2.2F);
	}
	
	@Test
	public void saveTest(){
		dealService.save(deal);
	}
	
	@Test
	public void findByCodeTest(){
		Deal d = dealService.findByCode(deal.getCode()).get(0);
		System.out.println(d);
	}
	
	@Test
	public void deleteTest(){
		Deal d = dealService.findByCode(deal.getCode()).get(0);
		dealService.delete(d);
	}
	
	@Test
	public void findByDateIntervalTest(){
		Deal d = dealService.findByDateInterval(deal.getCode(), new Date(), new Date()).get(0);
		System.out.println(d);
	}
	
	@Test
	public void deleteByIdTest(){
		dealService.delete(new Integer(3));
	}
	
	@Test
	public void findByIdTest(){
		dealService.findById(3);
	}
}
