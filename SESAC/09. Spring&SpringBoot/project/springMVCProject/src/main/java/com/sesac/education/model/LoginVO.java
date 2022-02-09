package com.sesac.education.model;

public class LoginVO {

	private String id;
	private String name;
	private String pw;
	private String eId;
	private String eDomain;
	private String tel1;
	private String tel2;
	private String tel3;
	private String post;
	private String bAddr;
	private String dAddr;
	private String type;
	private String regDate;
	
	public LoginVO() {
	}

	public LoginVO(String id, String name, String pw, String eId, String eDomain, String tel1, String tel2,
			String tel3, String post, String bAddr, String dAddr) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.eId = eId;
		this.eDomain = eDomain;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.post = post;
		this.bAddr = bAddr;
		this.dAddr = dAddr;
	}

	public LoginVO(String id, String name, String pw, String eId, String eDomain, String tel1, String tel2,
			String tel3, String post, String bAddr, String dAddr, String type, String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.eId = eId;
		this.eDomain = eDomain;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.post = post;
		this.bAddr = bAddr;
		this.dAddr = dAddr;
		this.type = type;
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String geteDomain() {
		return eDomain;
	}

	public void seteDomain(String eDomain) {
		this.eDomain = eDomain;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getbAddr() {
		return bAddr;
	}

	public void setbAddr(String bAddr) {
		this.bAddr = bAddr;
	}

	public String getdAddr() {
		return dAddr;
	}

	public void setdAddr(String dAddr) {
		this.dAddr = dAddr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", name=" + name + ", pw=" + pw + ", eId=" + eId + ", eDomain=" + eDomain
				+ ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3 + ", post=" + post + ", bAddr=" + bAddr
				+ ", dAddr=" + dAddr + ", type=" + type + ", regDate=" + regDate + "]";
	}
	
	
}
