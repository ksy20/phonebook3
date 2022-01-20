package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value = "/phone")
public class PhoneController {
	
	@RequestMapping(value = "/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String WriteForm() {
		System.out.println("PhoneController > writeForm");
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
//	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
//	public String Write(@RequestParam("name") String name ,
//						@RequestParam("hp") String hp, 
//						@RequestParam("company") String company) {
//		System.out.println("PhoneController > write");
//		System.out.println(name);
//		System.out.println(hp);
//		System.out.println(company);
	
	
//	    //저장
//		PersonVo personVo = new PersonVo(name,hp, company);
//		PhoneDao phoneDao = new PhoneDao();
//		phoneDao.personInsert(personVo);
//		
//		//리다이렉트
//		return "";
//	}
	
	
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String Write(@ModelAttribute PersonVo personVo) {
		
		System.out.println(personVo);

		//저장		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController > list");
		
		//다오에서 리스트 가져오기
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		
		System.out.println(personList.toString());
		
		//컨트롤러 --> DS에 데이터를 보낸다
		model.addAttribute("personList", personList);
		
		//jsp정보 리턴
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
	public String test(@RequestParam(value= "name") String name,
						@RequestParam(value= "age", required = false, defaultValue = "-1") int age) {
		
		System.out.println(name);
		System.out.println(age);
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	@RequestMapping(value = "/view", method = {RequestMethod.GET, RequestMethod.POST})
	public String view(@RequestParam(value= "no") int no) {
		
		System.out.println(no + "번글 가져오기");
		
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	@RequestMapping(value = "/{no}/{num/view}", method = {RequestMethod.GET, RequestMethod.POST})
	public String view11(@PathVariable("no") int no, @PathVariable("num") int num) {
		
		System.out.println(no + "번글 가져오기");
		
		
		return "/WEB-INF/views/writeForm.jsp";
	}

}
