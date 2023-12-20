package com.springmvc.vo;

public class Criteria {

	private int currentPage; 	  	// 현재 페이지의 번호
	private int postsPerPage; 		// 한 페이지당 표시할 글 개수

	public Criteria() {
		this.currentPage = 1;
		this.postsPerPage = 10;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage <= 0) {
			this.currentPage = 1;
		} else {
			this.currentPage = currentPage;
		}
	}

	public int getPostsPerPage() {
		return postsPerPage;
	}

	public void setPostsPerPage(int postsPerPage) {
		if (postsPerPage <= 0 || postsPerPage > 100) {
			this.postsPerPage = 10;
		} else {
			this.postsPerPage = postsPerPage;
		}
	}

	public int getPageStart() {
		return (this.currentPage - 1) * postsPerPage;
	}
	
	@Override
	public String toString() {
		return "Criteria [currentPage=" + currentPage + ", postsPerPage=" + postsPerPage + "]";
	}

}