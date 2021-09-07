package com.wookook.spring.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wookook.spring.repository.DataDAO;
import com.wookook.spring.vo.BookVO;

@Controller
public class Contr {
	
	@Autowired
	private DataDAO datadao; // 의존성 주입 -> 제어의 역전 (IOC)
	
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
		List<BookVO> list = datadao.getList();
		model.addAttribute("getlist",list);
		return "/WEB-INF/file/Book_db_select_result.jsp";
	}
	
	@RequestMapping("/bookinput_page")
	public String inputpage() {
		return "/WEB-INF/file/Book_input.jsp";
	}
	
	@RequestMapping(value="/bookinput", method=RequestMethod.POST)
	public String input(@ModelAttribute BookVO Bvo) {
		boolean flag = datadao.insertList(Bvo);
			if(flag == true ) {
				System.out.println("DB_insert 성공");
			}
		return "booklist";
	}
	
	@RequestMapping("/bookdelete")
	public String delte(@RequestParam int bookid) {
		boolean flag = datadao.deleteList(bookid);
			if(flag == true ) {
				System.out.println("DB_delete 성공");
			}
		return "booklist";
	}
	
}
