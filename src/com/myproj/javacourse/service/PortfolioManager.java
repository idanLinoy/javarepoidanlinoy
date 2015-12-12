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
		Portfolio myPortfolio = new Portfolio("Exercise 7 portfolio", 0);
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 11, 15);
		
		stock1 = new Stock ("PIH", 10.0f, 8.5f,cal.getTime());
		stock2 = new Stock ("AAL", 30.0f, 25.5f, cal.getTime());
		stock3 = new Stock ("CAAS", 20.0f, 15.5f, cal.getTime());
		
		myPortfolio.addStock(stock1);
		myPortfolio.addStock(stock2);
		myPortfolio.addStock(stock3);
		
		myPortfolio.updateBalance(10000f);
		
		myPortfolio.buyStock(stock1, 20);
		myPortfolio.buyStock(stock2, 30);
		myPortfolio.buyStock(stock3, 40);
		
		myPortfolio.sellStock("AAL", -1);
		
		myPortfolio.removeStock("CAAS");
		return myPortfolio;
	}
	
}
