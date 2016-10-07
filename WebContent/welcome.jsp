<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.tie.app.TieController"%>
<%@page import="com.tie.app.TieSessionController"%>
<%@page import="com.tie.ui.TieMainPage"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="theLocale"
	value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${theLocale}" />
<fmt:setBundle basename="com.tie.i18n.resources.mylabels" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="label.Welcome" />, <%=tieMainPage.getUsername()%>
	!</title>


<script src="bower_components/jquery/dist/jquery.js"></script>
<script src="bower_components/jquery-resizable/dist/jquery-resizable.min.js"></script>
<link rel="stylesheet"
	href="bower_components/bootstrap/dist/css/bootstrap.css">
<script src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script src="javascript/angular.min.js"></script>
<script src="javascript/angular-route.js"></script>
<script src="bower_components/angular-animate/angular-animate.min.js"></script>
<script src="bower_components/angular-touch/angular-touch.min.js"></script>
<script src="bower_components/angular-ui-grid/ui-grid.js"></script>
<link rel="stylesheet"
	href="bower_components/angular-ui-grid/ui-grid.min.css">
<script src="javascript/app.js"></script>


<script src="javascript/controllers/main.js"></script>
<script src="javascript/controllers/writeController.js"></script>
<script src="javascript/service/cbcrs.js"></script>
<script src="javascript/collapse.js"></script>

<!--script src="javascript/angular-ui-router.min.js"></script-->

<link rel="stylesheet" href="css/app.css" />
</head>

<body ng-app="tieappApp">

	<%!String appName = TieMainPage.getTieMainPage().getAppName();%>
	<%!String userName = TieMainPage.getTieMainPage().getUsername();%>
	<%!TieMainPage tieMainPage = TieMainPage.getTieMainPage();%>
	<div class="container">
		<aside class="sidebar">
			<h2 class="logo">
				<a href="#/write">TIE<strong>app</strong></a> <span>
					<h6>
						<fmt:message key="label.For" />
						<%=tieMainPage.getAppName()%>
						<!--  %=session.getAttribute("tieapp")% -->
						<!--%=((com.tie.app.TieSessionController)session.getAttribute("appname")).getMainPage().getAppName()%-->

					</h6>
				</span>
			</h2>

			<nav class="main-nav">
				<div class="scrollbar" id="style-5">
					<div class="force-overflow">
						<div id="inbox">
							<ul>
								<li><button type="button" class="btn btn-primary btn-md">
										<fmt:message key="label.ComposeNewTaxMsg" />
									</button></li>
							</ul>
						</div>
						<div id="inbox">
							<ul>

								<li><button type="button" class="btn btn-primary btn-md">
										<fmt:message key="label.Inbox" />
									</button></li>


								<li><button type="button" class="btn btn-primary btn-md">
										<fmt:message key="label.Sent" />
									</button></li>


								<li><button type="button" class="btn btn-primary btn-md">
										<fmt:message key="label.Draft" />
									</button></li>

							</ul>
						</div>
						<div id="collapser">
							<button type="button" class="btn btn-primary btn-md">
								<fmt:message key="label.SearchBy" />
								... &nbsp; &nbsp; &nbsp; <span
									class="glyphicon glyphicon-search"></span>
							</button>
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a
								data-toggle="collapse" data-parent="#collapser"
								href="#collapseQuote"> <span
								class="toggle-icon glyphicon glyphicon-chevron-down"></span>
							</a>

							<div id="collapseQuote" class="collapse">
								<div id="searchby">





									<table style="width: 100%">
										<tr>
											<th>Doc Type:</th>
											<td><select class="form-control" id="sel1">
													<option>CBCR</option>
													<option>Other</option>
											</select></td>
										</tr>
										<tr>
											<th>From User:</th>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="5"><%=tieMainPage.getSelectionCriteria().getFromUser()%></textarea></td>
										</tr>
										<tr>
											<th>From Country:</th>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="5"><%=tieMainPage.getSelectionCriteria().getFromCountry()%></textarea></td>
										</tr>
										<tr>
											<th>To user:</th>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="5"><%=tieMainPage.getSelectionCriteria().getToUser()%></textarea></td>
										</tr>
										<tr>
											<th>To Country:</th>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="5"><%=tieMainPage.getSelectionCriteria().getToCountry()%></textarea></td>
										</tr>
										<tr>
											<th>From Date:</th>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="5"><%=tieMainPage.getSelectionCriteria().getFromDate()%></textarea></td>
										</tr>
										<tr>
											<th>To Date:</th>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="5"><%=tieMainPage.getSelectionCriteria().getToDate()%></textarea></td>
										</tr>
									</table>
								</div>
								<div id="mnc">
									<p>MNC:</p>
									<table style="width: 100%">

										<tr>
											<th>Name:</th>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="5"><%=tieMainPage.getSelectionCriteria().getName()%></textarea></td>
										</tr>
										<tr>
											<th>Country:</th>
											<td><select class="form-control" id="sel1">
													<option><%=tieMainPage.getSelectionCriteria().getCountry()%></option>
													<option>MX</option>
											</select></td>
										</tr>
										<tr>
											<th>From Year:</th>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="5"><%=tieMainPage.getSelectionCriteria().getFromYear()%></textarea></td>
										</tr>
										<tr>
											<th>To Year:</th>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="5"><%=tieMainPage.getSelectionCriteria().getToYear()%></textarea></td>
										</tr>
										<tr>
											<th>Main Business:</th>
											<td><select class="form-control" id="sel1">
													<option><%=tieMainPage.getSelectionCriteria().getMainBusiness()%></option>
													<option>Education</option>
													<option>Health Care</option>
											</select></td>
										</tr>


									</table>
									<table>
										<tr>
											<th>Key Metric</th>

											<td class="ax">Between</td>
										</tr>
										<tr>
											<th>Revenue Rel:</th>

											<td class="ex"><textarea class="form-control"
													id="exampleTextarea" rows="1" cols="3"></textarea></td>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="3"></textarea></td>
										</tr>

										<tr>
											<th>Revenue Unrel:</th>

											<td class="ex"><textarea class="form-control"
													id="exampleTextarea" rows="1" cols="2"></textarea></td>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="2"></textarea></td>
										</tr>
										<tr>
											<th>Total Revenue:</th>

											<td class="ex"><textarea class="form-control"
													id="exampleTextarea" rows="1" cols="2"></textarea></td>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="2"></textarea></td>
										</tr>
										<tr>
											<th>Tax Accrual:</th>

											<td class="ex"><textarea class="form-control"
													id="exampleTextarea" rows="1" cols="2"></textarea></td>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="2"></textarea></td>
										</tr>
										<tr>
											<th>Tax Paid:</th>

											<td class="ex"><textarea class="form-control"
													id="exampleTextarea" rows="1" cols="2"></textarea></td>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="2"></textarea></td>
										</tr>
										<tr>
											<th>Num of Emp.:</th>

											<td class="ex"><textarea class="form-control"
													id="exampleTextarea" rows="1" cols="2"></textarea></td>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="2"></textarea></td>
										</tr>
										<tr>
											<th>Capital:</th>

											<td class="ex"><textarea class="form-control"
													id="exampleTextarea" rows="1" cols="2"></textarea></td>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="2"></textarea></td>
										</tr>
										<tr>
											<th>Accu Earnings:</th>

											<td class="ex"><textarea class="form-control"
													id="exampleTextarea" rows="1" cols="2"></textarea></td>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="2"></textarea></td>
										</tr>
										<tr>
											<th>Assets:</th>

											<td class="ex"><textarea class="form-control"
													id="exampleTextarea" rows="1" cols="2"></textarea></td>
											<td><textarea class="form-control" id="exampleTextarea"
													rows="1" cols="2"></textarea></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>

			</nav>
		</aside>
		<div class="main">

			<header class="header">

				<!-- div class="headercenter">
					<a href="https://www.vertexinc.com/training"
						class="btn btn-primary" role="button">Training</a>
				</div>
				<div class="nav-right">


					<ul>
						<div>

							<li><a><label for="sel1">Language</label></a></li>

							<li><select class="form-control" id="sel1">
									<option>EN</option>
									<option>SP</option>
									<option>CN</option>

							</select></li>
						</div>
						<div>
							<li><a> Welcome, <%=tieMainPage.getUsername()%> !
							</a>&nbsp;&nbsp;&nbsp;<a href="LogoutServlet">Log Out</a></li>

						</div>
					</ul>
				</div-->
				<div class="col-sm-4"></div>
				<div class="col-sm-4">

					<div id="training">
						<a href="#/training" class="btn btn-primary" role="button"><fmt:message
								key="label.Training" /></a>
					</div>

				</div>
				<div class="col-sm-4">
					<ul>
						<div>

							<li><a href="welcome.jsp?theLocale=en_US"><fmt:message
										key="label.Language" /></label></a></li>

							<li><select class="form-control" id="sel1"
								onchange="location = this.value;">
									<option value="welcome.jsp?theLocale=en_US">EN</option>
									<option value="welcome.jsp?theLocale=es_ES">ES</option>
									<option value="welcome.jsp?theLocale=zh_CN">CN</option>

							</select></li>

						</div>
						<div>
							<li><a> <fmt:message key="label.Welcome" />, <%=tieMainPage.getUsername()%>
									!
							</a>&nbsp;&nbsp;&nbsp;<a href="LogoutServlet"><u><fmt:message
											key="label.LogOut" /></u></a></li>

						</div>
					</ul>
				</div>
			</header>

			<!--  div  class="container"-->
			<!--div ng-include="'views/main.html'" ng-controller="MainCtrl"></div-->
			<div class="table">

				<div ng-view></div>
			</div>
			<!--  /div-->


		</div>

	</div>
	<div class="footer">
		<div class="container">
			<p>Copy Right @</p>
		</div>
	</div>


</body>
</html>
