package com.myproj.javacourse.model;
import com.myproj.javacourse.Stock;

public class Portfolio {

	String title;
	private int portfolioSize = 0;
	final static int MAX_PORTFOLIO_SIZE = 5;
	Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	
	public void addStock(Stock stock){
		stocks[portfolioSize] = stock;
		portfolioSize++;
	}
	
	public Stock[] getStocks(){
		return this.stocks;
	}
	
	public String getHtmlString(){
		
		this.title = "<h1> Linoy and Idan's portfolio </h1>";
		String stocksDetails[] = new String[portfolioSize];
		String result = "";
		
		for (int i = 0 ; i < portfolioSize ; i++){
			
			stocksDetails[i] = (this.stocks[i]).getHtmlDescription();
			result += stocksDetails[i] + "<br>" ;
		}

		return this.title + "<br>" + result;
	}
}
