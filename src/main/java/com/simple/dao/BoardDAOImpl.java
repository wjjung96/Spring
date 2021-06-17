package com.simple.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.command.BoardVO;


@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	
	ArrayList<BoardVO> list = new ArrayList<>();
	
	@Override
	public void boardRegist(BoardVO vo) {
		list.add(vo);//등록.
	}

	@Override
	public ArrayList<BoardVO> getList() {
		//DB처리...
		return list;
	}

	@Override
	public void boardDelete(int num) {
		
		list.remove(num);
	}

}
