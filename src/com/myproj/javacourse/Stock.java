package com.myproj.javacourse;

import java.util.Date;

public class Stock {
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	
	public Stock(String symbol, float ask, float bid, int creationDay, int  creationMonth, int creationYear){
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;	
		this.date = new Date(creationYear, creationMonth, creationDay );
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	public String getHtmlDescription(){
		String date = this.date.getMonth() + "/" + this.date.getDate() + "/" + this.date.getYear();
		String stockDetails = "<b>Stock symbol:</b>  " + this.symbol + " <b>Ask:</b>  " + this.ask + " <b>Bid:</b>  " + this.bid + " <b>Date:</b>  " + date;
		return stockDetails;
	}
}
