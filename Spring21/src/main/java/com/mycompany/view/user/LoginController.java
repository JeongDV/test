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

		vo.setId("admin");
		vo.setPassword("1234");
		
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
		if(userDAO.getUser(vo) != null) {
			session.setAttribute("userName", userDAO.getUser(vo).getName());
			return "getBoardList.do";
		}
		else {
			return "login.jsp";
		}
	}
}














