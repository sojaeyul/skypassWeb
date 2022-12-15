package com.koreanair.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.koreanair.api.service.MybaService;

@RestController
public class MvcTestController {

	@Autowired
	MybaService service;
	
	@RequestMapping("/myba")
	public ModelAndView myba() {
		ModelAndView mv = new ModelAndView();
		int totSize = service.totSize("");
		
		mv.addObject("totSize", totSize);
		mv.setViewName("myba_result");
		return mv;
	}
}