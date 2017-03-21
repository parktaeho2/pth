package org.com.vo;

public class Criteria {
	private int page; //현재 조회하는 페이지 번호
	private int perPageNum; //한페이지당 출력하는 데이터의 개수

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		// TODO Auto-generated constructor stub
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
  //pageNum이 일정 수 이상일경우를 대비한 제약
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	public int getPage() {
		return page;
	}

	// method for MyBatis SQL Mapper -
	public int getPageStart() {

		return (this.page - 1) * perPageNum;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

}
