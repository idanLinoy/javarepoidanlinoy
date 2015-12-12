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
		
		resp.getWriter().println(portfolio1.getHtmlString());
	}
	
}