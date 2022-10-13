package kr.ac.kopo.gameshop.pager;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int page = 1;
	private int perPage = 10;
	private float total;
	final int perGroup = 5;
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}	
	
	public int getPrev() {
		return page <= perGroup ? 1 : ((page - 1) / perGroup) * perGroup;
	}
	
	public int getNext() {
		int next = (((page - 1) / perGroup) + 1) * perGroup + 1;
		
		int last = getLast();
		
		return next < last ? next : last;		
	}
	
	public int getLast() {
		return (int) Math.ceil(total / perPage);
	}
	
	public List<Integer> getList() {
		List<Integer> list = new ArrayList<Integer>();

		int startPage = ((page - 1) / perGroup) * perGroup + 1;
		
		for(int count=startPage; count < (startPage + perGroup) && count <= getLast(); count++)
			list.add(count);
		
		if(list.isEmpty())
			list.add(1);
		
		return list;
	}
	
	public int getOffset() {
		return (page - 1) * perPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

}
