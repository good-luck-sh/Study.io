package com.sample.board.vo;

public class Pagination {
	
	private int rowsPerPage = 5;
	private int pagesPerBlock = 5;
	private int currentPageNo;
	private int totalRecords;

	private int totalPages;
	private int totalBlocks;
	private int currentBlock;
	private int beginPage;
	private int endPage;
	private int begin;
	private int end;
	
	public Pagination(String pageNo, int totalRecords) {
		this.totalPages = (int)(Math.ceil((double)totalRecords/rowsPerPage));
		totalBlocks = (int)(Math.ceil((double)totalPages/pagesPerBlock));
		
		currentPageNo = 1;
		try {
			currentPageNo = Integer.parseInt(pageNo);
		} catch(NumberFormatException e) {}
		
		if(currentPageNo <= 0 ) {
			currentPageNo = 1;
		}
		if(currentPageNo > totalPages) {
			currentPageNo = totalPages;
		}
		
		begin = (currentPageNo - 1) * rowsPerPage + 1;
		end = currentPageNo*rowsPerPage;
		
		currentBlock =  (int)(Math.ceil((double)currentPageNo/pagesPerBlock));
		beginPage = (currentBlock - 1)*pagesPerBlock + 1;
		end = currentBlock*pagesPerBlock;
		if(currentBlock == totalBlocks) {
			endPage = totalPages;
		}
		
		
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getPagesPerBlock() {
		return pagesPerBlock;
	}

	public void setPagesPerBlock(int pagesPerBlock) {
		this.pagesPerBlock = pagesPerBlock;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalBlocks() {
		return totalBlocks;
	}

	public void setTotalBlocks(int totalBlocks) {
		this.totalBlocks = totalBlocks;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
