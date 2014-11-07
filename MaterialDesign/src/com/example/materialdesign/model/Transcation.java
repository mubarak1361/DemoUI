package com.example.materialdesign.model;

public class Transcation {

	private String name;
	private String amount;
	private String date;
	
	public Transcation(String date,String name,String price){
		this.date = date;
		this.name = name;
		this.amount =  price;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(String price){
		this.amount =  price;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPrice(){
		return this.amount;
	}
}
