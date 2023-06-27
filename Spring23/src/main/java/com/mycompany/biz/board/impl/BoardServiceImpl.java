package com.mycompany.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.biz.board.BoardService;
import com.mycompany.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	//객체를 자동으로 주입시켜주는 오토와이어 (하려면 boardDAO가 있어야 BoardServiceImpl가 실행됨)
	@Autowired
	private BoardDAOSpring boardDAO;

	public void insertBoard(BoardVO vo) {  
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
}