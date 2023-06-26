package com.mycompany.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.biz.board.BoardVO;
import com.mycompany.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		model.addAttribute("board",boardDAO.getBoard(vo));
		return "getBoard.jsp";	
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		model.addAttribute("boardList",boardDAO.getBoard(vo));
		return "getBoardList.jsp";

	}
	
	/* 다 스트링인데 얘네 두개만 모델이라 스트링으로 바꾸고 모델앤뷰를 모델로 변경해주고 애드어트리벗으로 변경해주면됨
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		mav.addObject("board",boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		mav.addObject("boardList",boardDAO.getBoard(vo));
		mav.setViewName("getBoardList.jsp");
		
		return mav;
	}
	 */
}
