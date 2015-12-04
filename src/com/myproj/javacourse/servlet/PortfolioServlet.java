package com.myproj.javacourse.servlet;
import java.io.IOException;

import javax.servlet.http.*;

import com.myproj.javacourse.model.Portfolio;
import com.myproj.javacourse.service.PortfolioManager;
/**
 * 
 * @author Linoy
 *
 */
@SuppressWarnings("serial")

public class PortfolioServlet extends HttpServlet {		
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio portfolio = portfolioManager.getPortfolio();
		resp.getWriter().println(portfolio.getHtmlString());
	}
	
}