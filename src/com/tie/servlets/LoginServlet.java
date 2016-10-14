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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tie.app.TieController;
import com.tie.app.TieSecurityManager;
import com.tie.app.TieSessionController;
import com.tie.dao.TieAppDao;
import com.tie.dao.TiePersister;
import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.dao.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// TODO: rewrite doPost for switch
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		// Get TieSessionController from the httpsession
		TieSessionController sessionController = (TieSessionController) session
				.getAttribute(TieSessionController.sesssionControllerName);
		// System.out.println(sessionController);

		// Get username and pwd from the session
		String username = request.getParameter("username");
		String password = request.getParameter("userpass");

		// ---- determine action to take after user logged in ------
		String action;
		if (request.getParameter("action") == null) {
			action = "";
		} else {
			action = request.getParameter("action");
		}

		// If user has already loggin in
		if (sessionController != null) {
			// switch logic based on action value
			if (action.equals("selectCurrentMsg")) {
				selectCurrentMsg(request, response, sessionController);
			} else if (action.equals("selectCurrentDoc")) {
				selectCurrentDoc(request, response, sessionController);
			} else {
				//RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("index1.html");
				rd.forward(request, response);
			} // end switch on action

		} else {

			// TieController tieController = new TieController();
			// user touch for the first time
			TieSecurityManager securityManager = TieController.getController().getSecurityManager();
			if (securityManager.authentiate(username, password)) {
				sessionController = new TieSessionController();
				String code = username;
				// String code =
				// TieController.getController().getPersister().getTieUserDao().findTieUserByName(username).getCode();
				sessionController.setUserCode(code);
				session.setAttribute(code, username);
				// TieController.getController().getPersister().getLoginDao().setUsername(username);

				// Save the session controller, since the user is authenticated
				session.setAttribute(TieSessionController.sesssionControllerName, sessionController);

				/*
				 * Handle the login event for the user for the first time All
				 * data on the main page is populated in the mainPage object of
				 * the session controller.
				 */
				sessionController.handleLogin(username);
				/*
				 * Put logic here?
				 */
				//RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("index1.html");
				rd.include(request, response);
			} else {
				out.print("<p style=\"color:red; text-align: center; \">Sorry username or password error</p>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			} // end if securityMgr.authenticate() else
		} // end if sessionController !=null else

		out.flush();
		out.close();
	}// end doPost(..)

	/**
	 * Prepare Ajax response to the select current msg request
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectCurrentMsg(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController) throws ServletException, IOException {
		int msgid = 0;
		// if( id==null ) id =0;
		if (request.getParameter("msgid") == null) {
			msgid = 0;
		} else {
			msgid = Integer.parseInt(request.getParameter("msgid"));

		}
		String contextPath = request.getContextPath();

		// -------Temp code, will clean later
		// TiePersister persister =
		// TieController.getController().getPersister();
		TieMsg msg = sessionController.handleSelectCurrentMsg(msgid);
		// sessionController.handleSelectCurrentMsg(msgid);
		// persister.getTieMsgDao().findTieMsgByTieMsgId(msgid);
		// System.out.println("MSG pojo :" + msg.toString());

		ObjectMapper ma = new ObjectMapper();
		String msgjson = ma.writeValueAsString(msg);
		System.out.println(msgjson);

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(msgjson);

		// System.out.println(msgjson);

	}// end selectCurrentMsg

	public void selectCurrentDoc(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController) throws ServletException, IOException {
		int tieDocId = 0;
	
		if (request.getParameter("tieDocId") == null) {
			tieDocId = 0;
		} else {
			tieDocId = Integer.parseInt(request.getParameter("tieDocId"));
		}
		TieDoc tieDoc = sessionController.handleSelectCurrentDoc(tieDocId);

		ObjectMapper ma = new ObjectMapper();
		String docjson = ma.writeValueAsString(tieDoc);
		System.out.println("DocJSON" + docjson);

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(docjson);
	}// end
		// selectCurrentDoc

}// end class LoginService
