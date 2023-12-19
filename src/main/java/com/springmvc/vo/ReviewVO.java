package com.springmvc.vo;

public class ReviewVO {

	private int bookId;
	private String email;
	private String comment;
	private String createDate;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "ReviewVO [bookId=" + bookId + ", email=" + email + ", comment=" + comment + ", createDate=" + createDate
				+ "]";
	}

}
