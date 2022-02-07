package com.sac.di4;

import org.springframework.stereotype.Component;

@Component("myBook")
public class Book {
	private String title;
	private int price;
	private String kind;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", kind=" + kind + "]";
	}
	
}
