package com.ramana.pojo;

public class HelloWorld {
	
	private String strHelloWorld;
	
	
	public HelloWorld (String strHelloWorld) {
		this.strHelloWorld = strHelloWorld;
	}


	public void setStrHelloWorld(String strHelloWorld) {
		this.strHelloWorld = strHelloWorld;
	}

	

	public String getStrHelloWorld() {
		return strHelloWorld;
	}


	@Override
	public String toString() {
		return "HelloWorld [strHelloWorld=" + strHelloWorld + "]";
	}
	
	

}
