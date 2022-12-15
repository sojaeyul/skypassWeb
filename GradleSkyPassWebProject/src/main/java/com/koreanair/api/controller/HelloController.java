package com.koreanair.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.koreanair.api.dto.ProductDto;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String Hello(Model model){
    	System.out.println("aaaaaaaaaaaaaaaaa");
        model.addAttribute("data","hello!!");
        return "hello";
    }
    
    
    @GetMapping("hello2")
    public String Hello2(Model model){
    	
        model.addAttribute("data","hello2!!");
        return "hello2";
    }
    
    //@RequestMapping(value = "/thymeleaf/iteration", method = { RequestMethod.POST, RequestMethod.GET })
    @GetMapping("/thymeleaf/iteration")
    public String Thymeleaf(Model model){
    	List<ProductDto> productList = new ArrayList<>();
    	
    	productList.add(ProductDto.builder().seq(1).name("사과").price(1000).quantity(10).build());
    	productList.add(ProductDto.builder().seq(2).name("배").price(2000).quantity(16).build());
    	productList.add(ProductDto.builder().seq(3).name("초콜릿").price(3000).quantity(3).build());
    	productList.add(ProductDto.builder().seq(4).name("치킨").price(4000).quantity(1).build());

    	model.addAttribute("productList",productList);
    	return "iteration";
    }
}