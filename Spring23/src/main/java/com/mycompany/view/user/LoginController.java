package com.mycompany.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.biz.user.UserVO;
import com.mycompany.biz.user.impl.UserDAO;

@Controller
public class LoginController{

	/*
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {

		if(userDAO.getUser(vo) != null) {
			return "redirect:getBoardList.do";
		}else {
			return "login.jsp";
		}	
	}*/
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(UserVO vo) {
		// ${userVO.id}, userVO.password 첫글자는 소문자로 해야 스프링컨테이너가 자동으로 객체로 저장해준다.(꺼내볼땐 el로)

		//vo.setId("admin");
		//vo.setPassword("1234");
		
		return "redirect:login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
		if(userDAO.getUser(vo) != null) {
			session.setAttribute("userName", userDAO.getUser(vo).getName());
			return "redirect:getBoardList.do";
		}
		else {
			return "redirect:login.jsp";
		}
	}
}














