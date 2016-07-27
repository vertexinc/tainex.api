/**
 * 
 */
/**
 * @author awang
 *
 */
package com.tie.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tie.app.TieController;
import com.tie.dao.AppDao;
import com.tie.dao.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("username"); // they are variables in
														// JSP
		String p = request.getParameter("userpass"); // they are variables in
														// JSP
		AppDao appdao = new AppDao();
		String x = appdao.appname();

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute("tie", n);
			session.setAttribute("name", x);
		}

		//get the HttpSession session = ...
		
		// get TieSessionController from the http session
		// TieSessionController sessionController = (TieSessionController) session.get property by user name( userName )
		
		// if sessionController != null // it means user has already logged in, do nothing, return the same page
		// else, //the user is touch the page for the first time
		//{
			//TieSecurityManager securityManager = TieController.getController().getSecurityManager();
			//put validate logic to security manager class
		
			//If user is authentiocated
				//Create a new session controller and put int session
		 		// sessionController = new TieSessionController();
				// sessionController.setUserCode( userName );
		  		// httpSession.put( userName, sessionController );
			//else  // user is not authenticated
				// redisplay login page
		
		//}
		
		
		if (LoginDao.validate(n, p)) {
			
			
			
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");

			rd.forward(request, response);
		} else {
			out.print("<p style=\"color:red; text-align: center; \">Sorry username or password error</p>");

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}

		out.close();
	}
}
