package com.sample.form;

public class Criteria {

	private String opt;
	private String value;
	
	public Criteria() {}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Criteria [opt=" + opt + ", value=" + value + "]";
	}
	
	
}
