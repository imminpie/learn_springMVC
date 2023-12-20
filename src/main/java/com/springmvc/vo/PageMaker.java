package com.springmvc.vo;

public class PageMaker {

	private Criteria criteria;
	private int displayPageNum = 10; 		// 하단에 표시할 페이지 번호의 개수
	private int totalPosts; 			    // 모든 글 개수
	private int startPage; 				    // 시작 페이지 번호
	private int endPage; 				    // 끝 페이지 번호
	private boolean prev; 				    // 이전으로 가는 화살표 표시 여부
	private boolean next; 				    // 다음으로 가는 화살표 표시 여부
	
	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalPosts() {
		return totalPosts;
	}

	public void setTotalPosts(int totalPosts) {
		this.totalPosts = totalPosts;
		calcData();
	}

	private void calcData() {

		endPage = (int) (Math.ceil(criteria.getCurrentPage() / (double) displayPageNum) * displayPageNum);

		startPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(totalPosts / (double) criteria.getPostsPerPage()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = startPage == 1 ? false : true;
		next = endPage * criteria.getPostsPerPage() >= totalPosts ? false : true;

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

}
