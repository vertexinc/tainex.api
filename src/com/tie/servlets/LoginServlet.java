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
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tie.app.TieController;
import com.tie.app.TieSecurityManager;
import com.tie.app.TieSessionController;
import com.tie.dao.TieAppDao;
import com.tie.dao.TiePersister;
import com.tie.dao.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/*
	 * public void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * response.setContentType("text/html"); PrintWriter out =
	 * response.getWriter();
	 * 
	 * String n = request.getParameter("username"); // they are variables in //
	 * JSP String p = request.getParameter("userpass"); // they are variables in
	 * // JSP TieAppDao appdao = new TieAppDao(); // String x =
	 * appdao.appname(); String x = null;
	 * 
	 * // TieController tieController = new TieController(); //
	 * tieController.getPersister(); x =
	 * TieController.getController().getPersister().getTieAppDao().
	 * findTieAppById(1).getName();
	 * 
	 * // watch the session here, put it to session controllerj HttpSession
	 * session = request.getSession(false); if (session != null) {
	 * session.setAttribute("user", n); session.setAttribute("appname", x); }
	 */
	/* Session value */
	// String s =
	// ((com.tie.app.TieSessionController)session.getAttribute("name")).getMainPage().getUsername();
	// get the HttpSession session = ...

	// get TieSessionController from the http session
	// TieSessionController sessionController = (TieSessionController)
	// session.get property by user name( userName )

	// if sessionController != null // it means user has already logged in,
	// do nothing, return the same page
	// else, //the user is touch the page for the first time
	// {
	// TieSecurityManager securityManager =
	// TieController.getController().getSecurityManager();
	// put validate logic to security manager class

	// If user is authentiocated
	// Create a new session controller and put int session
	// sessionController = new TieSessionController();
	// sessionController.setUserCode( userName );
	// httpSession.put( userName, sessionController );
	// else // user is not authenticated
	// redisplay login page

	// }

	/*
	 * LoginDao loginDao = new LoginDao();
	 * 
	 * if(loginDao.validate(n,p)) { RequestDispatcher rd =
	 * request.getRequestDispatcher("welcome.jsp");
	 * 
	 * rd.forward(request, response); }else { out.print(
	 * "<p style=\"color:red; text-align: center; \">Sorry username or password error</p>"
	 * );
	 * 
	 * RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	 * rd.include(request, response); }
	 * 
	 * out.close(); }
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		// Get username and pwd from the session
		String username = request.getParameter("username");
		String password = request.getParameter("userpass");
		PrintWriter out = response.getWriter();
		// Get TieSessionController from the httpsession
		TieSessionController sessionController = (TieSessionController)session
				.getAttribute(TieSessionController.sesssionControllerName);

		// If user has already loggin in
		if (sessionController != null) {
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		} else {
			//TieController tieController = new TieController();
			// user touch for the first time
			TieSecurityManager securityManager = TieController.getController().getSecurityManager();
			if (securityManager.authentiate(username, password)) {
				sessionController = new TieSessionController();
				String code = username;
				//String code = TieController.getController().getPersister().getTieUserDao().findTieUserByName(username).getCode();
				sessionController.setUserCode(code);
				session.setAttribute(code, username);
				//TieController.getController().getPersister().getLoginDao().setUsername(username);
				/*
				 * Handle the login event for the user for the first time All
				 * data on the main page is populated in the mainPage object of
				 * the session controller.
				 */
				sessionController.handleLogin("Adam16");
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.include(request, response);
			} else {
				out.print("<p style=\"color:red; text-align: center; \">Sorry username or password error</p>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		}
		out.close();
	}
}
