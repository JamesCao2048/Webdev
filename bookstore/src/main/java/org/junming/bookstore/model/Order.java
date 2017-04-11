package org.junming.bookstore.model;

import java.sql.Timestamp;
import java.util.*;

public class Order {
	private Integer oid;
	private String uid;
	private Timestamp time;
	private Integer toPrice;
    private List<Book> books;

	public Order() {
		books = new ArrayList<Book>();
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer id) {
		this.oid = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Integer getToPrice() {
		return toPrice;
	}

	public void setToPrice(Integer toPrice) {
		this.toPrice = toPrice;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Integer getBookSize(){
		return books.size();
	}

	public int calToPeice(){
		int result = 0;
		for(Book b:books)
			result+=b.getPrice();
		return result;
	}
	public String toString(){
		return "oid: "+oid+" uid: "+uid+" time: "+time+" toprice: "+toPrice+" books:"+books.toString();
	}
}
