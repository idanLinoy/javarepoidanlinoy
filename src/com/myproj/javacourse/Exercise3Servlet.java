package com.myproj.javacourse;

import java.io.IOException;
import javax.servlet.http.*;
import com.myproj.javacourse.MathEx3;
/**
 * 
 * @author Linoy
 *
 */
@SuppressWarnings("serial")
public class Exercise3Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		MathEx3 mathEx3 = new MathEx3();
		String resultStr = mathEx3.getResults();
		resp.getWriter().println(resultStr);

	}
}