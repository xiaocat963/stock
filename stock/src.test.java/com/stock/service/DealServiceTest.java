package com.stock.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stock.vo.Deal;
import com.stock.vo.DealQueryCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DealServiceTest {

	@Resource(name="dealService")
	private DealService dealService;
	
	private Deal deal;
	private DealQueryCriteria criteria; 
	
	@Before
	public void initDeal(){
		deal = new Deal();
		deal.setCode("600004");
		deal.setCapitalization(4F);
		deal.setClose(3F);
		deal.setDate(new Date());
		deal.setHigh(5F);
		deal.setLow(2F);
		deal.setOpen(1F);
		deal.setTurnover(0.2F);
		deal.setVolume(2.2F);
		
		criteria = new DealQueryCriteria();
		criteria.setCode("600004");
		criteria.setStartDate("2015-02-01");
		criteria.setEndDate("2015-09-01");
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
		dealService.delete(20);
	}
	
	@Test
	public void findByIdTest(){
		dealService.findById(3);
	}
	
	@Test 
	public void addDealTest(){
		deal = new Deal();
		deal.setCode("600004");
		deal.setDate(new Date());
		deal.setOpen(199);
		dealService.addDeal(deal);
	}

	@Test
	public void findAllTest(){
		List<Deal> list = dealService.findAll(criteria);
		int count = dealService.findCountAll(criteria);
		Assert.assertNotNull(list);
		Assert.assertEquals(count, list.size());
		System.out.println(list.size());
	}
	
	@Test
	public void findAllByPageTest(){
		List<Deal> list = dealService.findAllByPage(1, 5, criteria);
		Assert.assertNotNull(list);
		Assert.assertEquals(1, list.size());
		System.out.println(list.size());
	}
}
