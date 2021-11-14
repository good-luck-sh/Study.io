package com.sample.vo;

import java.util.Date;

public class Board {

	private int boardNo;
	private String boradTitle;
	private String boardWrite;
	private int boradView;
	private int boardLike;
	private String boardContent;
	private String boardDelete;
	private Date boardCreatedDate;
	
	public Board () {}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoradTitle() {
		return boradTitle;
	}

	public void setBoradTitle(String boradTitle) {
		this.boradTitle = boradTitle;
	}

	public String getBoardWrite() {
		return boardWrite;
	}

	public void setBoardWrite(String boardWrite) {
		this.boardWrite = boardWrite;
	}

	public int getBoradView() {
		return boradView;
	}

	public void setBoradView(int boradView) {
		this.boradView = boradView;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDelete() {
		return boardDelete;
	}

	public void setBoardDelete(String boardDelete) {
		this.boardDelete = boardDelete;
	}


	public Date getBoardCreatedDate() {
		return boardCreatedDate;
	}

	public void setBoardCreatedDate(Date boardCreatedDate) {
		this.boardCreatedDate = boardCreatedDate;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boradTitle=" + boradTitle + ", boardWrite=" + boardWrite
				+ ", boradView=" + boradView + ", boardLike=" + boardLike + ", boardContent=" + boardContent
				+ ", boardDelete=" + boardDelete + ", boardCreated=" + boardCreatedDate + "]";
	}
	
	
}
