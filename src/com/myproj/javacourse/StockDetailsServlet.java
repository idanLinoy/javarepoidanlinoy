package com.myproj.javacourse;
import java.io.IOException;
import javax.servlet.http.*;
import com.myproj.javacourse.Stock;
/**
 * 
 * @author Linoy
 *
 */
@SuppressWarnings("serial")

public class StockDetailsServlet extends HttpServlet {		
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Stock stock1, stock2, stock3;
		String details1, details2, details3;
		
		stock1 = new Stock ("PIH", 13.1f, 12.4f, 15, 11, 2014);
		stock2 = new Stock ("AAL", 5.78f, 5.5f, 15, 11, 2014);
		stock3 = new Stock ("CAAS", 32.2f, 31.5f, 15, 11, 2014);
		
		details1 = stock1.getHtmlDescription();
		details2 = stock2.getHtmlDescription();
		details3 = stock3.getHtmlDescription();
		
		resp.setContentType("text/html");
		resp.getWriter().println(details1 + "<br>" + details2 + "<br>" + details3);
	}
	
}