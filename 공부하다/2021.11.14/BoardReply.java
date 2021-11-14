package com.sample.vo;

import java.util.Date;

public class BoardReply {

	private int replayNo;
	private String replayWriter;
	private String replayContent;
	private Date replayCreatedDate;
	private Board board;
	
	public BoardReply () {}

	public int getReplayNo() {
		return replayNo;
	}

	public void setReplayNo(int replayNo) {
		this.replayNo = replayNo;
	}

	public String getReplayWriter() {
		return replayWriter;
	}

	public void setReplayWriter(String replayWriter) {
		this.replayWriter = replayWriter;
	}

	public String getReplayContent() {
		return replayContent;
	}

	public void setReplayContent(String replayContent) {
		this.replayContent = replayContent;
	}

	public Date getReplayCreatedDate() {
		return replayCreatedDate;
	}

	public void setReplayCreatedDate(Date replayCreatedDate) {
		this.replayCreatedDate = replayCreatedDate;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "BoardReply [replayNo=" + replayNo + ", replayWriter=" + replayWriter + ", replayContent="
				+ replayContent + ", replayCreatedDate=" + replayCreatedDate + ", board=" + board + "]";
	}
	
	
}
