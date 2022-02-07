package com.sac.di3;

/* JavaBeans
 * 	default 생성자
 * 	getter / setter
 *  (toString은 선택사항)
 */
public class License {
	private String title;
	private int year;

	// default 생성자 제공
	
	// getter, setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	// toString
	@Override
	public String toString() {
		return "License [title=" + title + ", year=" + year + "]";
	}
	
	
	
}
