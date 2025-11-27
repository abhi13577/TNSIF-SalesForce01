package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customers {
	private int custId;
	private String custname;
	private String coursename;
	
	@Autowired
	private Technologies techdetail;
	
	@Autowired
	private Zomato zoo;
	
	@Autowired
	private Cricket c;
	
	@Autowired
	private IPL i;
	
	public Technologies getTechdetail() {
		return techdetail;
	}
	public void setTechdetail(Technologies techdetail) {
		this.techdetail = techdetail;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	
	
	public void display() {
		
		
		System.out.println("Object created succesfully");
		
		techdetail.tech();
		
		zoo.Food();
		
		c.score();
		
		i.Updates();
	}


}
