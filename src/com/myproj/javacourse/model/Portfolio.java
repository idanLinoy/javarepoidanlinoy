package com.myproj.javacourse.model;
import com.myproj.javacourse.model.Stock;

/**
 * This class represents a portfolio that consists several stocks
 * @authors Linoy&Idan
 *
 */
public class Portfolio {

	final static int MAX_PORTFOLIO_SIZE = 5;
	
	String title;
	private int portfolioSize = 0;
	
	Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	
	/**
	 * This constructor creates a portfolio instance
	 * @param title
	 * @param portfolioSize
	 */
	public Portfolio (String title, int portfolioSize){
		this.title = title;
		this.portfolioSize = portfolioSize;
	}	
	
	/**
	 * Copy constructor to portfolio instance
	 * @param portfolio
	 */
	public Portfolio (Portfolio portfolio){
		this(portfolio.getTitle(), portfolio.getPortfolioSize());
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		for (int i=0 ; i < portfolioSize ; i++){
			this.stocks[i] = new Stock(portfolio.stocks[i]);
		}
	}
	
	/**
	 * Empty constructor of portfolio
	 */
	public Portfolio() {
		this.title = null;
		this.portfolioSize = 0;
		Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	/**
	 * This method adds stock to a portfolio 
	 */
	public void addStock(Stock stock){
		stocks[portfolioSize] = stock;
		portfolioSize++;
	}
	
	/**
	 * This method removes the first stock in a portfolio
	 */
	public void removeFirstStock(Portfolio portfolio){
		for(int i = 0 ; i < portfolioSize-1 ; i++)
		{
			this.stocks[i] = this.stocks[i+1];
		}
		portfolioSize--;
	}
	
	/**
	 * This method returns a String containing details about stocks in specific portfolio
	 */
	public String getHtmlString(){
		
		this.title = "<h1>" +this.title+ "</h1>";
		String stocksDetails[] = new String[portfolioSize];
		String result = "";
		
		for (int i = 0 ; i < portfolioSize ; i++){
			
			stocksDetails[i] = (this.stocks[i]).getHtmlDescription();
			result += stocksDetails[i] + "<br>" ;
		}

		return this.title + result;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	public Stock[] getStocks(){
		return this.stocks;
	}
}
