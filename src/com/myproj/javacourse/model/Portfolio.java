package com.myproj.javacourse.model;

import com.myproj.javacourse.model.Stock;
import java.lang.Math.*;

/**
 * This class represents a portfolio that consists several stocks
 * 
 * @authors Linoy&Idan
 *
 */
public class Portfolio {

	// Members
	final static int MAX_PORTFOLIO_SIZE = 5;

	public enum ALGO_RECOMMENDATION {
		BUY, SELL, REMOVE, HOLD;
	}

	String title;
	private int portfolioSize = 0;

	private float balance;

	Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];

	// Constructors
	/**
	 * This constructor creates a portfolio instance
	 * 
	 * @param title
	 * @param portfolioSize
	 */
	public Portfolio(String title, int portfolioSize) {
		this.title = title;
		this.portfolioSize = portfolioSize;
	}

	/**
	 * Copy constructor to portfolio instance
	 * 
	 * @param portfolio
	 */
	public Portfolio(Portfolio portfolio) {
		this(portfolio.getTitle(), portfolio.getPortfolioSize());
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		for (int i = 0; i < portfolioSize; i++) {
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

	// Methods
	/**
	 * This method adds stock to a portfolio
	 */
	public void addStock(Stock stock) {
		boolean canBeAdded = true;
		for (int i = 0; i < this.portfolioSize; i++) {
			if (this.stocks[i].getSymbol() == stock.getSymbol()) {
				System.out.println("The stock already exists in this porfolio");
				canBeAdded = false;
				break;
			} else if (this.portfolioSize == MAX_PORTFOLIO_SIZE) {
				System.out.println("This portfolio can only hold "
						+ MAX_PORTFOLIO_SIZE + " stocks");
				canBeAdded = false;
			}	
		}
		if (canBeAdded == true){
			this.stocks[this.portfolioSize] = stock;
			this.portfolioSize++;
		}
	}

	public boolean removeStock(String stockSymbol) {
		boolean canBeRemoved ;
		int toRemoveIndex = 0;
		
		canBeRemoved = sellStock(stockSymbol, -1);
		
		if (canBeRemoved == true) {
			for (int i = 0 ; i < portfolioSize ; i++){
				if (this.stocks[i].getSymbol() == stockSymbol) {
					toRemoveIndex = i;
				}
			}
			
			if (toRemoveIndex == this.portfolioSize-1) {
				this.portfolioSize--;
			}
			else {
				for (int j = toRemoveIndex; j < (this.portfolioSize - 1); j++) {
				this.stocks[j] = this.stocks[j + 1];
				}
				this.portfolioSize--;
			}
		}
		
		return canBeRemoved;
	}

	public boolean sellStock(String symbol, int quantity) {
		boolean canBeSold = false;
		float amount;

		if (quantity < -1) {
			System.out.println("ERROR! Invalid operation");
		} 
		else {
			for (int i = 0; i < this.portfolioSize; i++) {
				if (this.stocks[i].getSymbol() == symbol) {

					if (quantity == -1) {
						amount = this.stocks[i].getStockQuantity() * this.stocks[i].getBid();
						updateBalance(amount);
						this.stocks[i].setStockQuantity(0);
						canBeSold = true;
					}
					else {
						if (quantity > this.stocks[i].getStockQuantity()) {
							System.out.println("Not enough stocks to sell");
						} 
						else {
							amount = quantity * this.stocks[i].getBid();
							updateBalance(amount);
							this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity() - quantity);
							canBeSold = true;
						}
					}
				}
			}
		}
		return canBeSold;
	}
	
	public boolean buyStock(Stock stock, int quantity){
		boolean canBeBought = true;
		boolean isStockFound = false;
		int addQuantity;
		
		for (int i = 0 ; i < this.portfolioSize ; i++) {
			if (stock.getSymbol() == this.stocks[i].getSymbol()) {
				isStockFound = true;
			}
		}
		
		if (isStockFound == false){
			addStock(stock);
		}
		
		for (int i = 0 ; i < this.portfolioSize ; i++) {
			if (stock.getSymbol() == this.stocks[i].getSymbol()) {
				isStockFound = true;
				if (quantity == -1) {
					addQuantity = (int)(balance/this.stocks[i].getAsk());
					this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity() + addQuantity);
					updateBalance(-(addQuantity*this.stocks[i].getAsk()));
				}
				else if (quantity*this.stocks[i].getAsk() > balance){
					System.out.println("Not enough balance to complete purchase.");
					canBeBought = false;
				}
				else {
					this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity() + quantity);
					updateBalance(-(quantity*this.stocks[i].getAsk()));
				}
			}
		}
		
		return canBeBought;
	}
	
	public float getStocksValue (){
		float totalValue = 0;
		
		for (int i = 0 ; i < this.portfolioSize ; i++) {
			totalValue += (this.stocks[i].getBid()* this.stocks[i].getStockQuantity());
		}
		
		return totalValue;
	}
	
	public float getTotalValue() {
		float totalValueAndBalance = 0;
		
		totalValueAndBalance += (this.getStocksValue() + this.getBalance());
		
		return totalValueAndBalance;
	}

	/**
	 * This method removes the first stock in a portfolio
	 */
	public void removeFirstStock(Portfolio portfolio) {
		for (int i = 0; i < portfolioSize - 1; i++) {
			this.stocks[i] = this.stocks[i + 1];
		}
		portfolioSize--;
	}

	public void updateBalance(float amount) {
		if ((amount < 0) && (Math.abs(amount)) > this.balance) {
			System.out.println("ERROR! The requested amount cannot be withdrawed. The availible balance is "+ this.balance);
		} else {
			this.balance += amount;
		}
	}

	/**
	 * This method returns a String containing details about stocks in specific
	 * portfolio
	 */
	public String getHtmlString() {

		this.title = "<h1>" + this.title + "</h1>";
		String stocksDetails[] = new String[portfolioSize];
		String result = "";

		for (int i = 0; i < portfolioSize; i++) {

			stocksDetails[i] = (this.stocks[i]).getHtmlDescription();
			result += stocksDetails[i] + "<br>";
		}
		
		result += "<br>" + "<b> Total Portfolio Value: </b>" + this.getTotalValue() + "$,  <b> Total Stocks value: </b>" + this.getStocksValue() + "$, <b> Balance: </b>" + this.getBalance() + "$";


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

	public Stock[] getStocks() {
		return this.stocks;
	}

	public float getBalance() {
		return balance;
	}
}
