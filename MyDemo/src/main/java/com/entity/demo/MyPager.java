package com.entity.demo;

import java.util.ArrayList;
import java.util.List;

public class MyPager<T> {

	/* 数据列表 */
	private List<T> list;
	
	/* 数据总数 */
	private int toalSize;

	public MyPager() {
		super();
		this.list = new ArrayList<T>();
		this.toalSize = 0;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getToalSize() {
		return toalSize;
	}
	public void setToalSize(int toalSize) {
		this.toalSize = toalSize;
	}
}
