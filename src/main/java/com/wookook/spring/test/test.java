package com.wookook.spring.test;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wookook.spring.repository.DataDAO;
import com.wookook.spring.vo.BookVO;

@Controller
public class test {
	
	@Autowired
	private DataDAO datadao; // 의존성 주입
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/file/hello.jsp";
	}
	
	@RequestMapping("/hi")
	public String hi(@RequestParam String str) {
		System.out.println(str);
		return "/WEB-INF/file/hello.jsp";
	}
	
	@RequestMapping("/booklist")
	public String list(Model model) {
		try {
			List<BookVO> list = datadao.getList();
			model.addAttribute("getlist",list);
		} catch (SQLException e) {
		}
		return "/WEB-INF/file/Book_db_select_result.jsp";
	}
	
}
