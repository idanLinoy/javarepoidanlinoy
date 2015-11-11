package com.myproj.javacourse;
import java.io.IOException;
import javax.servlet.http.*;
/**
 * 
 * @author Linoy
 *
 */
@SuppressWarnings("serial")
public class MtaprojlinoyServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, Linoy and Idan");
	}
}