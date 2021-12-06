package com.pageMarker.model;

public class PageMaker {

	private Criteria cri; // page , perPageNum 을 가지고 있
	
	private int totalCount; // 전체 게시글의 수
	private int startPage;  // 게시글 번호에 따른 (보여지는) 페이지의 시작 번호
	private int endPage;    // 게시글번호에 따른 (보여지는) 페이지의 끝 번호
	private boolean prev;	// 이전 버튼을 누를수 있는경우 없는 경우 분류를 위함
	private boolean next;
	
	private int displayPageNum = 10; // 화면 하단에 보여지는 페이지의 개수
	private int tempEndPage;
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData(); // 전체 필드 변수들 세팅 : 전체 게시글 수의 세터 가 호출 될때 전체 세팅 되도록 함
	}
	
	private void calcData() { // 전체 필드 변수 값들을 계산하는 메서드
		
		
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int)(Math.ceil(totalCount / (double) cri.getPerPageNum()));
		this.tempEndPage = tempEndPage;
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;// 1페이지면 이전 버튼 누를수 없게 false
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTempEndPage() {
		return tempEndPage;
	}

	public void setTempEndPage(int tempEndPage) {
		this.tempEndPage = tempEndPage;
	}

	public int getTotalCount() {
		return totalCount;
	}
	
	
}
