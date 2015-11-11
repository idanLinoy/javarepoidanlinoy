package com.myproj.javacourse;
import java.io.IOException;
import javax.servlet.http.*;
/**
 * 
 * @author Linoy
 *
 */
@SuppressWarnings("serial")
public class MathServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("1 + 1 = " + (1+1));
	}
}