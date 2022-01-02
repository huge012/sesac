package kr.co.mlec.login.vo;

public class LoginVO {
	private String id;
	private String pass;
	private String reg_date;
	
	public LoginVO()
	{
		super();
	}
	
	public LoginVO(String id, String pass, String reg_date) {
		super();
		this.id = id;
		this.pass = pass;
		this.reg_date = reg_date;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", pass=" + pass + ", reg_date=" + reg_date + "]";
	}
	
}
