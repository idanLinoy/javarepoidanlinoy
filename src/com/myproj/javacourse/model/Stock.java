package com.myproj.javacourse.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class represents a stock in the stock market
 * @authors Linoy&Idan
 */
public class Stock {
	
	private final static int BUY = 0;
	private final static int  SELL = 1;
	private final static int REMOVE = 2;
	private final static int HOLD = 3;
	
	private final String symbol;
	private float ask;
	private float bid;
	private int recommendation;
	private int stockQuantity;
	
	private Date date;
	SimpleDateFormat dateFormater = new SimpleDateFormat("MM/dd/yyyy");
	
	/**
	 * This constructor creates a stock instance
	 * @param symbol
	 * @param ask
	 * @param bid
	 * @param date
	 */
	public Stock(String symbol, float ask, float bid, Date date){
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = date;
	}
	
	/**
	 * Overloading of stack instance
	 * @param symbol
	 * @param ask
	 * @param bid
	 */
	public Stock(String symbol, float ask, float bid){
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
	}
	
	/**
	 * 
	 * Copy constructor for stock
	 */
	public Stock(Stock stock){	
	this(stock.getSymbol(), stock.getAsk(), stock.getBid());
	this.date = new Date (stock.getDate().getTime());
	}
		
	public String getSymbol() {
		return symbol;
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
	
	/**
	 * This method returns a String of stock's details
	 */
	public String getHtmlDescription(){
		String date = this.dateFormater.format(this.date);
		String stockDetails = "<b>Stock symbol:</b>  " + this.symbol + " <b>Ask:</b>  " + this.ask + " <b>Bid:</b>  " + this.bid + " <b>Date:</b>  " + date;
		return stockDetails;
	}
}
