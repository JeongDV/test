package com.mycompany.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.biz.board.BoardService;
import com.mycompany.biz.board.BoardVO;
import com.mycompany.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {

	//의존객체주입
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/insertBoard.do")
							//사용자 요청을 지정하는 common객체 돌아오는 파라미터 값을 지정해줌 (session처리도 가능함)
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardService.insertBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
						
		boardService.updateBoard(vo);
		
		//수정 불가한 값은 null로 출력됨
		System.out.println("번호: "+vo.getSeq());
		System.out.println("제목: "+vo.getTitle());
		System.out.println("작성자: "+vo.getWriter());
		System.out.println("내용: "+vo.getContent());
		System.out.println("등록일: "+vo.getRegDate());
		System.out.println("조회수: "+vo.getCnt());
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardService.deleteBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		model.addAttribute("board",boardService.getBoard(vo));
		return "getBoard";	
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		model.addAttribute("boardList",boardService.getBoardList(vo));
		return "getBoardList";

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
