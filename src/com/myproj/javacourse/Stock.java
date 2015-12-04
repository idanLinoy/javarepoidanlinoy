package com.myproj.javacourse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
	
	private final static int BUY = 0;
	private final static int  SELL = 1;
	private final static int REMOVE = 2;
	private final static int HOLD = 3;
	
	private String symbol;
	private float ask;
	private float bid;
	private int recommendation;
	private int stockQuantity;
	
	private Date date;
	SimpleDateFormat dateFormater = new SimpleDateFormat("MM/dd/yyyy");
	
	public Stock(String symbol, float ask, float bid, Date date) {
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = date;
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
		String date = this.dateFormater.format(this.date);
		String stockDetails = "<b>Stock symbol:</b>  " + this.symbol + " <b>Ask:</b>  " + this.ask + " <b>Bid:</b>  " + this.bid + " <b>Date:</b>  " + date;
		return stockDetails;
	}
}
