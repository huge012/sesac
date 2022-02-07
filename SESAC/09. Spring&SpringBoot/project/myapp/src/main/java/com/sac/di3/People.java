package com.sac.di3;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class People {
	String name;
	String phone;
	Car car;
	List<String> major;
	List<License> licenses; // setter로 추가할 예정
	Map<String, Book> books;
	Set<String> friend;
	Properties myprofile;
	
	public People() {
		System.out.println("People default 생성자");
	}
	
	public People(String name, String phone, Car car) {
		System.out.println("People arg3 생성자");
		this.name = name;
		this.phone = phone;
		this.car = car;
	}
	
	
	public People(String name, String phone, Car car, List<String> major) {
		System.out.println("People arg4 생성자");
		this.name = name;
		this.phone = phone;
		this.car = car;
		this.major = major;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public List<String> getMajor() {
		return major;
	}
	public void setMajor(List<String> major) {
		this.major = major;
	}

	public List<License> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<License> licenses) {
		this.licenses = licenses;
	}

	public Map<String, Book> getBooks() {
		return books;
	}

	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}
	
	public Set<String> getFriend() {
		return friend;
	}

	public void setFriend(Set<String> friend) {
		this.friend = friend;
	}

	public Properties getMyprofile() {
		return myprofile;
	}

	public void setMyprofile(Properties myprofile) {
		this.myprofile = myprofile;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", phone=" + phone + ", car=" + car + ", major=" + major + ", licenses="
				+ licenses + ", books=" + books + ", friend=" + friend + ", myprofile=" + myprofile + "]";
	}

	

	
}
