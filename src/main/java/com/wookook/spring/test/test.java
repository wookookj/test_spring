package com.wookook.spring.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class test {

	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/file/hello.jsp";
	}
	
	@RequestMapping("/hi")
	public String hi(@RequestParam String str) {
		System.out.println(str);
		return "/WEB-INF/file/hello.jsp";
	}
}
