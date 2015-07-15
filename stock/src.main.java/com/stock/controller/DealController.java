package com.stock.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.service.DealService;

@Controller
@RequestMapping("/deal")
public class DealController {

	@Resource(name="dealService")
	private DealService dealService;
	public String dealList(Model model){
		//dealService.
		return "deal";
	}
}
