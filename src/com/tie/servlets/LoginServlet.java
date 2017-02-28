/**
 * 
 */
/**
 * @author awang
 *
 */
package com.tie.servlets;

//1 log4j
//2 move big blocks into separate method, leave only one line for each swith statement
//3 move currenmt msg determination into attchment doc func
//try(  xx)if(curMsg == null){throw new RunTimeException(the exception messags)}
//try(  yy){throw new RunTimeException(the exception messags)}
//try(  zz)..
//catch(exception){ do the response to front end}

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.tie.app.TieController;
import com.tie.app.TieSecurityManager;
import com.tie.app.TieSessionController;
import com.tie.dao.TieAppDao;
import com.tie.dao.TiePersister;
import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.ui.Header;
import com.tie.ui.Param;
import com.tie.ui.ServletError;
import com.tie.ui.TieMainPage;
import com.tie.dao.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// TODO: rewrite doPost for switch
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		HttpSession session = request.getSession(false);
		System.out.println("SessionId is : " + session.getId());
		PrintWriter out = response.getWriter();
		// Get TieSessionController from the httpsession
		TieSessionController sessionController = (TieSessionController) session
				.getAttribute(TieSessionController.sesssionControllerName);
		// System.out.println(sessionController);

		// Get username and pwd from the session
		String username = request.getParameter("username");
		String password = request.getParameter("userpass");

		// ---- determine action to take after user logged in ------

		// If user has already loggin in
		if (sessionController != null) {

			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String json = "";
			if (br != null) {
				json = br.readLine();
			}

			ObjectMapper mapper = new ObjectMapper();
			Param param = mapper.readValue(json, Param.class);

			String action = param.getAction();
			int messageId = param.getMessageId();
			int docId = param.getDocId();
			String docString = param.getDocString();
			String detachDocIdList = param.getDocIdListString();

			System.out.println("param.getAction: " + param.getAction());

			if (action.equals("initPage")) {

				initPage(request, response, sessionController);

			} else if (action.equals("selectCurrentMsg")) {

				selectCurrentMsg(request, response, sessionController, messageId);

			} else if (action.equals("selectCurrentDoc")) {

				selectCurrentDoc(request, response, sessionController, docId);

			} else if (action.equals("save")) {

				saveCurrentMessage(request, response, sessionController, param.getTieMsg());

			} else if (action.equals("saveDoc")) {
				try {
					saveDoc(request, response, sessionController, docString);
				} catch (Exception e) {
					ServletError servletError = new ServletError();
					servletError.setErrorName("Error!");
					String errorMsg = e.getMessage();
					servletError.setErrorDescription(" Got Exception : " + errorMsg);
					ObjectMapper ma = new ObjectMapper();
					String servletErrorJson = ma.writeValueAsString(servletError);
					response.setContentType("text/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(servletErrorJson);
				}

			} else if (action.equals("detachDoc")) {

				detachDoc(request, response, sessionController, Arrays.asList(detachDocIdList.split(",")), messageId);

			} else if (action.equals("deleteMsg")) {

				deleteMsg(request, response, sessionController,
						TieMainPage.getTieMainPage().getCurrentMsg().getTieMsgId());

			} else if (action.equals("reset")) {

				reset(request, response, sessionController);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("dist/index.html");
				rd.forward(request, response);
			}

		} else {
			authenticateUser(request, response, sessionController, session, username, password, out);
		} // end if sessionController !=null else

		out.flush();
		out.close();
	}// end doPost(..)

	private void authenticateUser(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController, HttpSession session, String username, String password,
			PrintWriter out) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			 * Handle the login event for the user for the first time All data
			 * on the main page is populated in the mainPage object of the
			 * session controller.
			 */
			sessionController.handleLogin(username);

			RequestDispatcher rd = request.getRequestDispatcher("dist/index.html");

			rd.include(request, response);
		} else {
			out.print("<p style=\"color:red; text-align: center; \">Sorry username or password error</p>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}

	private void saveDoc(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController, String docString) throws IOException {
		// TODO Auto-generated method stub

		TieMsg currentMsg = TieMainPage.getTieMainPage().getCurrentMsg();

		try {
			attachDoc(request, response, sessionController, docString, currentMsg);
		} catch (Exception e) {

			String errorMsg = e.getMessage();
			String errorDescription = "Failed to attach this Document! " + errorMsg;
			throw new RuntimeException(errorDescription);
		}

	}

	// upon composing new, set current msg and current doc as null
	private void reset(HttpServletRequest request, HttpServletResponse response, TieSessionController sessionController)
			throws IOException {
		// TODO Auto-generated method stub

		TieMainPage retval = null;
		sessionController.handleMsgList();
		TieMainPage.getTieMainPage().setCurrentMsg(null);
		TieMainPage.getTieMainPage().setCurrentTieDoc(null);
		retval = TieMainPage.getTieMainPage();

		ObjectMapper ma = new ObjectMapper();
		String saveMsgReturnJson = ma.writeValueAsString(retval);

		System.out.println("saveMsgReturnJson" + saveMsgReturnJson);

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(saveMsgReturnJson);
	}

	private void deleteMsg(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController, int messageId) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (TieMainPage.getTieMainPage().getCurrentMsg() == null) {
			sessionController.resetMsg();
		} else {
			sessionController.handleDeleteMsg(messageId);
		}
		try {
			initPage(request, response, sessionController);
		} catch (Exception e) {
			throw new RuntimeException("Failed to refresh page!");
		}
	}

	private void detachDoc(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController, List<String> docIdListArray, int messageId)
			throws ServletException, IOException {

		sessionController.handleDetachDoc(docIdListArray);

		ObjectMapper ma = new ObjectMapper();

		TieMainPage retval = null;
		retval = TieMainPage.getTieMainPage();
		ObjectMapper msgMap = new ObjectMapper();

		String detachedReturnJson = msgMap.writeValueAsString(retval);
		// System.out.println("tieMsgReturnJson : " + savedReturnJson);

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(detachedReturnJson);

	}

	private void attachDoc(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController, String docString, TieMsg tieMsg)
			throws IOException, NumberFormatException, ParseException {
		// TODO Auto-generated method stub
		if (tieMsg == null) {
			throw new RuntimeException("[Current Message is null], please save the message first");
		}
		String sessionId = request.getSession().getId();
		// TieMainPage retval = null;
		TieDoc parsedDoc = null;
		try {
			parsedDoc = sessionController.handleAttachDoc(docString, tieMsg, sessionId);
		} catch (Exception e) {
			throw new RuntimeException("[Failed to parse the doc], please check the format of the doc");
		}

		// retval = TieMainPage.getTieMainPage();

		ObjectMapper ma = new ObjectMapper();
		String saveDocReturnJson = ma.writeValueAsString(parsedDoc);

		TieMainPage retval = null;
		retval = TieMainPage.getTieMainPage();
		ObjectMapper msgMap = new ObjectMapper();

		String savedReturnJson = msgMap.writeValueAsString(retval);
		// System.out.println("tieMsgReturnJson : " + savedReturnJson);

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(savedReturnJson);

	}// end attachDoc(.....)

	// Return saved message back in JSON format
	private void saveCurrentMessage(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController, TieMsg tieMsg) throws IOException {
		// TODO Auto-generated method stub
		String sessionId = request.getSession().getId();
		TieMsg returnSavedTieMsg = sessionController.handleSaveMessage(tieMsg, sessionId);

		int returnSavedTieMsgId = returnSavedTieMsg.getTieMsgId();
		returnSavedTieMsg = sessionController.handleUserAndState(returnSavedTieMsgId);
		TieMainPage retval = null;
		sessionController.handleMsgList();
		retval = TieMainPage.getTieMainPage();
		retval.setCurrentMsg(returnSavedTieMsg);
		// retval.setCurrentMsg(returnSavedTieMsg);
		// retval.setCurrentTieDoc(null);

		ObjectMapper ma = new ObjectMapper();
		String saveMsgReturnJson = ma.writeValueAsString(retval);

		System.out.println("saveMsgReturnJson" + saveMsgReturnJson);

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(saveMsgReturnJson);
	}// end saveCurrentMessage(....)

	// Return the whole TIEapp json when init
	// Customize init json to front end
	private void initPage(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Header header = sessionController.initMainPage();
		ObjectMapper ma = new ObjectMapper();

		// SimpleModule module = new SimpleModule();
		// module.addSerializer(Header.class, new InitSerializer());
		// ma.registerModule(module);
		ObjectMapper ma2 = new ObjectMapper();
		TieMainPage retval = null;
		retval = TieMainPage.getTieMainPage();
		String tieJson = ma2.writeValueAsString(retval);
		String headerjson = ma.writeValueAsString(header);
		// String serialized = ma.writeValueAsString(header);
		System.out.println("init json string: " + tieJson);
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(tieJson);
	}// end initPage (...)

	/**
	 * Prepare Ajax response to the select current msg request
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectCurrentMsg(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController, int messageId) throws ServletException, IOException {
		// int msgid = 0;
		// // if( id==null ) id =0;
		// if (request.getParameter("msgid") == null) {
		// msgid = 0;
		// } else {
		// msgid = Integer.parseInt(request.getParameter("msgid"));
		//
		// }
		// String contextPath = request.getContextPath();

		// -------Temp code, will clean later
		// TiePersister persister =
		// TieController.getController().getPersister();
		System.out.println("Current Msg Id" + messageId);
		TieMsg msg = sessionController.handleSelectCurrentMsg(messageId);
		// sessionController.handleSelectCurrentMsg(msgid);
		// persister.getTieMsgDao().findTieMsgByTieMsgId(msgid);
		// System.out.println("MSG pojo :" + msg.toString());

		TieMainPage retval = null;
		retval = TieMainPage.getTieMainPage();

		ObjectMapper ma = new ObjectMapper();
		String tieJson = ma.writeValueAsString(retval);
		String msgjson = ma.writeValueAsString(msg);
		System.out.println("msgJSON" + msgjson);

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(tieJson);

		// System.out.println(msgjson);

	}// end selectCurrentMsg(....)

	public void selectCurrentDoc(HttpServletRequest request, HttpServletResponse response,
			TieSessionController sessionController, int docId) throws ServletException, IOException {
		// int tieDocId = 0;
		//
		// if (request.getParameter("tieDocId") == null) {
		// tieDocId = 0;
		// } else {
		// tieDocId = Integer.parseInt(request.getParameter("tieDocId"));
		// }
		TieDoc tieDoc = sessionController.handleSelectCurrentDoc(docId);

		ObjectMapper ma = new ObjectMapper();
		String docjson = ma.writeValueAsString(tieDoc);

		TieMainPage retval = null;
		retval = TieMainPage.getTieMainPage();

		String tieJson = ma.writeValueAsString(retval);
		System.out.println("DocJSON" + docjson);

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(tieJson);
	}// end selectCurrentDoc(....)
		// public static String getStackTrace(final Throwable throwable) {
		// final StringWriter sw = new StringWriter();
		// final PrintWriter pw = new PrintWriter(sw, true);
		// throwable.printStackTrace(pw);
		// return sw.getBuffer().toString();
		// }

}// end class LoginService
