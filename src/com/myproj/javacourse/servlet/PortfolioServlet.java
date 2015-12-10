package com.myproj.javacourse.servlet;
import java.io.IOException;
import javax.servlet.http.*;
import com.myproj.javacourse.model.Portfolio;
import com.myproj.javacourse.service.PortfolioManager;

/**
 * 
 * @authors Linoy&Idan
 *
 */
@SuppressWarnings("serial")

public class PortfolioServlet extends HttpServlet {		
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio portfolio1 = portfolioManager.getPortfolio();
		Portfolio portfolio2 = new Portfolio(portfolio1);
		
		portfolio2.setTitle("Portfolio #2");
		resp.getWriter().println(portfolio1.getHtmlString() + "<br>" + portfolio2.getHtmlString());
		
		portfolio1.removeFirstStock(portfolio1);
		resp.getWriter().println(portfolio1.getHtmlString() + "<br>" + portfolio2.getHtmlString());
		
		(portfolio2.getStocks())[(portfolio2.getPortfolioSize())-1].setBid(55.55f);
		resp.getWriter().println(portfolio1.getHtmlString() + "<br>" + portfolio2.getHtmlString());
		
	}
	
}