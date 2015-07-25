package com.stock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.service.DealService;
import com.stock.vo.Deal;
import com.stock.vo.DealQueryCriteria;

@Controller
@RequestMapping("/deal")
public class DealController {

	@Resource(name="dealService")
	private DealService dealService;
	//分页大小
	private static final int PAGE_SIZE = 15;
	
	@RequestMapping(value = "/findAllDeal")
	public String dealList(Model model, DealQueryCriteria criteria, Integer pageNo){
		List<Deal> itemLists = new ArrayList<Deal>();
		pageNo = pageNo == null ? 1 : pageNo;
		itemLists = (List<Deal>)dealService.findAllByPage(pageNo, PAGE_SIZE, criteria);
		int totalItem = dealService.findCountAll(criteria);
		int totalPage = totalItem / PAGE_SIZE;
		totalPage = totalItem % PAGE_SIZE == 0 ? totalPage : totalPage + 1 ;
		model.addAttribute("totalItem", totalItem);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("itemList", itemLists);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("criteria", criteria);
		return "deal";
	}
	@RequestMapping(value = "/httpClientPost")
	public String httpClientPost(String name, String password){
		System.out.println(name + password);
		return "upload";
	}
}
