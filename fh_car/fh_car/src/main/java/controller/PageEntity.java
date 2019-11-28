package controller;

import java.util.ArrayList;
import java.util.List;

public class PageEntity<T> {
	private int pageNum=1;
	private int pageSize=3;
	private long totalPage;
	private long totalCount;
	private int start;
	private List<T> list = new ArrayList<T>();
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		this.totalPage=this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public PageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageEntity(int pageNum, int pageSize, long totalPage,
			long totalCount, int start, List<T> list) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.start = start;
		this.list = list;
	}
	
	public PageEntity(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.start= (pageNum-1)*pageSize;
	} 
	
	

}
