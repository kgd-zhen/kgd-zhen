package com.kgd.zhen.bean;

public class zhen_userBean {
	
	public String name;
	public String eName;
	public String pwd;
	public String phone;
	public String email;
	public String address;
	public String company;
	public String qq;
	public String note;
	public String reserve;
	
	@Override
	public String toString() {
		return "zhen_userBean: name="+name+",eName="+eName+",pwd="+pwd+",phone="+phone
				+",email="+email+",address="+address+",company="+company+",qq="+qq
				+",note="+note+",reserve="+reserve;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	
}
