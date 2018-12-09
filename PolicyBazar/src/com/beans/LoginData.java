package com.beans;

public class LoginData {
	
	String userName, passWord;
	
	public LoginData()
	{
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public LoginData(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	
	
	
	

}
