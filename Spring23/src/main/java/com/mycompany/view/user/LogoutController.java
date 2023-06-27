package com.mycompany.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.biz.user.UserVO;
import com.mycompany.biz.user.impl.UserDAO;

@Controller
public class LogoutController{

	@RequestMapping("/logout.do")
	public String logout(UserVO vo, UserDAO userDAO, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:login.jsp";
	}

}
