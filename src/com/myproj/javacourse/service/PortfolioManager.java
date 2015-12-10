package com.myproj.javacourse.service;
import java.util.Calendar;
import com.myproj.javacourse.model.Stock;
import com.myproj.javacourse.model.Portfolio;

/**
 * This class represents a portfolio manager that generates a portfolio
 */
public class PortfolioManager {
	
	public Portfolio getPortfolio() {
		Stock stock1, stock2, stock3;
		Portfolio portfolio = new Portfolio("Portfolio #1", 0);
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 10, 15);
		
		stock1 = new Stock ("PIH", 13.1f, 12.4f,cal.getTime());
		stock2 = new Stock ("AAL", 5.78f, 5.5f, cal.getTime());
		stock3 = new Stock ("CAAS", 32.2f, 31.5f, cal.getTime());
		
		portfolio.addStock(stock1);
		portfolio.addStock(stock2);
		portfolio.addStock(stock3);
		
		return portfolio;
	}
	
}
