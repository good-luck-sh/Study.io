package com.sample.board.vo;

/**
 * 게시글 추천 정보를 표현하는 객체다
 * @author lee_e
 *
 */
public class BoardLiker {

	private int boardNo;
	private int userNo;
	
	public BoardLiker() {}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
}
