
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@page import="com.tie.app.TieController"%>
<%@page import="com.tie.app.TieSessionController"%>
<%@page import="com.tie.ui.TieMainPage"%>
<%@page import="com.tie.model.TieMsg"%>

<body>

	<%!TieMainPage tieMainPage = TieMainPage.getTieMainPage();%>
	<%!List<TieMsg> msgList = tieMainPage.getMsgList();%>

	<div id="upper">
		<div class="scrollbar2" id="style-4">
			<div class="force-overflow2">
				<table class="table">
					<thead>
						<tr>
							<th>User</th>
							<th>Subject</th>
							<th>Description</th>
							<th>Date</th>
						</tr>
					</thead>


					<tbody>
						<%
							for (TieMsg tieMsg : msgList) {
						%>
						<tr bgcolor="#ff4d4d">
							<th scope="row"><%=tieMainPage.getUsername()%></th>
							<td><%=tieMsg.getSubject()%></td>
							<td><%=tieMsg.getDescription()%></td>
							<td><%=tieMsg.getTimestamp()%></td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div style="border: 1px solid #000"></div>
	<div class="container">
		<div class="scrollbar3" id="style-4">
			<!--  div class="force-overflow3"-->

			<ul class="tab">
				<li><a id="current" class="tablinks"
					onclick="openCity(event, 'Message')">Message</a></li>
				<li><a class="tablinks" onclick="openCity(event, 'Docs')">Docs</a></li>
				<li><a class="tablinks" onclick="openCity(event, 'Entity')">Entity</a></li>
				<li><a class="tablinks" onclick="openCity(event, 'Table1')">Table1</a></li>
				<li><a class="tablinks" onclick="openCity(event, 'Table2')">Table2</a></li>
				<li><a class="tablinks" onclick="openCity(event, 'Table3')">Table3</a></li>

			</ul>


			<div id="Message" class="tabcontent">
				<div class="row">
					<div class="col-md-3">
						<p>From: marisol@gmail.com</p>
					</div>


					<div class="col-md-3">
						<p>Date: 2016-08-04T13:23:21</p>
					</div>

					<div class="col-md-3">
						<p>Reporting Period: 2014-12-31</p>
					</div>

					<div class="col-md-3">
						<p>Status: Viewed</p>
					</div>
				</div>

				<div class="row">
					<div id="formGroup">
						<form>
							<div class="form-group row">
								<label for="To" class="col-sm-2 form-control-label">To:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="To"
										placeholder="xyz@DE;uvx@US">
								</div>
							</div>
							<div class="form-group row">
								<label for="Subject" class="col-sm-2 form-control-label">Subject:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="Subject"
										placeholder="CBCR">
								</div>
							</div>
							<div class="form-group row">
								<label for="Notes" class="col-sm-2 form-control-label">Notes:</label>
								<div class="col-sm-10">
									<textarea rows="4" cols="127">Sending the CBCR doc of Industry Co to Germany tax authority.</textarea>
								</div>
							</div>
							<div class="form-group row">
								<label for="Warning" class="col-sm-2 form-control-label">Warning:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="Warning"
										placeholder="">
								</div>
							</div>
							<div class="form-group row">
								<label for="Contact" class="col-sm-2 form-control-label">Contact:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="Contact"
										placeholder="">
								</div>
							</div>
						</form>

					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<table style="width: 100%">
							<tr>
								<th>OECD Message Ref ID:</th>
								<td>MX-2018-1</td>
							</tr>
							<tr>
								<th>OECD Message Type:</th>
								<td><select class="form-control" id="sel1">
										<option>CbC</option>
										<option>Other</option>
								</select></td>
							</tr>
							<tr>
								<th>Sending Country:</th>
								<td>MX</td>
							</tr>
							<tr>
								<th>Language:</th>
								<td><select class="form-control" id="sel1">
										<option>EN</option>
										<option>ES</option>
								</select></td>
							</tr>
						</table>
					</div>
					<div class="col-md-6">
						<table style="width: 100%">
							<tr>
								<th>Reporting Period:</th>
								<td><select class="form-control" id="sel1">
										<option>2018</option>
										<option>2017</option>
										<option>2016</option>
								</select></td>
							</tr>

							<tr>
								<th>OECD Message Type Indic:</th>
								<td><select class="form-control" id="sel1">
										<option>CBC401</option>
										<option>CBC402</option>
										<option>CBC403</option>
								</select></td>
							</tr>

							<tr>
								<th>Receiving Country:</th>
								<td>DE,US</td>
							</tr>
						</table>
					</div>
				</div>

			</div>
			<div id="Docs" class="tabcontent">
				<div class="row">
					<div class="col-md-6">Tax Documents In Message:</div>
					<div id="docbuttons" class="col-md-6">
						<button type="button" class="btn btn-info">Attach Tax
							Data File</button>
						<button type="button" class="btn btn-info">Detach From
							Msg...</button>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>Code</th>
							<th>Title</th>
							<th>Doc Type</th>
							<th>Reporting Entity</th>
							<th>Currency</th>
							<th>Resident Country</th>
							<th>Accounting Standard</th>
							<th>Reporting Period</th>
						</tr>
					</thead>
					<tbody>
						<tr bgcolor="#ff4d4d">
							<td>CBCR_IndustryCo</td>
							<td>To Share CBCR Report of Industry Co</td>
							<td>CBCR</td>
							<td>IndustryCo</td>
							<td>MXN</td>
							<td>MX</td>
							<td>MX GAAP</td>
							<td>2014-12-31</td>
						</tr>
						<!--tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>CBCR</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>CBCR</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>CBCR</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>CBCR</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>CBCR</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr-->
					</tbody>
				</table>
			</div>
			<div id="Entity" class="tabcontent">
				<div class="row" id="docrow">
					<h3>&nbsp;&nbsp; Entities in CBCR Doc:</h3>
				</div>
				<div class="row">
					<div class="col-md-6">

						<table style="width: 100%">
							<tr>
								<td>Reporting Entity:</td>
								<td>INDUSTRYCO CORPORATION INC</td>
							</tr>
							<tr>
								<td>Resident Country:</td>
								<td>MX</td>
							</tr>
						</table>
					</div>
					<div class="col-md-3">Currency:</div>
					<div class="col-md-3">MXN</div>
				</div>

				</br>
				<table class="table">
					<thead>
						<tr>
							<th>TIN</th>
							<th>Name</th>
							<th>Entity Code</th>
							<th>Doc Type</th>
							<th>Incorporation Country</th>
							<th>Resident Country</th>
							<th>Is PE?</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>10001</td>
							<td>GLOBAL SALESCO</td>
							<td>GLOBAL SALESCO</td>
							<td>CBCR</td>
							<td>CA</td>
							<td>CA</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10002</td>
							<td>CHINA MANUFACTURING CO</td>
							<td>CHINA MANUFACTURING CO</td>
							<td>CBCR</td>
							<td>CN</td>
							<td>CN</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10003</td>
							<td>German HoldCo GmbH</td>
							<td>German HoldCo GmbH</td>
							<td>CBCR</td>
							<td>DE</td>
							<td>DE</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10004</td>
							<td>Germany SubAssembly GmbH</td>
							<td>Germany SubAssembly GmbH</td>
							<td>CBCR</td>
							<td>DE</td>
							<td>DE</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10005</td>
							<td>FINANCECO, LTD.</td>
							<td>FINANCECO, LTD.</td>
							<td>CBCR</td>
							<td>GB</td>
							<td>GB</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10006</td>
							<td>APAC SALES CORPORATION</td>
							<td>APAC SALES CORPORATION</td>
							<td>CBCR</td>
							<td>HK</td>
							<td>HK</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10007</td>
							<td>Irish IPCo, Ltd</td>
							<td>Irish IPCo, Ltd</td>
							<td>CBCR</td>
							<td>IE</td>
							<td>IE</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10008</td>
							<td>India IT Ltd 1</td>
							<td>India IT Ltd 1</td>
							<td>CBCR</td>
							<td>IN</td>
							<td>IN</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10009</td>
							<td>India IT Ltd 2</td>
							<td>India IT Ltd 2</td>
							<td>CBCR</td>
							<td>IN</td>
							<td>IN</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10010</td>
							<td>SHARED SERVICES OPERATIONS LTD</td>
							<td>SHARED SERVICES OPERATIONS LTD</td>
							<td>CBCR</td>
							<td>PH</td>
							<td>PH</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10011</td>
							<td>AMERICAS SALES LLC</td>
							<td>AMERICAS SALES LLC</td>
							<td>CBCR</td>
							<td>US</td>
							<td>US</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10012</td>
							<td>GLOBAL SALESCO</td>
							<td>GLOBAL SALESCO</td>
							<td>CBCR</td>
							<td>US</td>
							<td>US</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr bgcolor="#FF7F50">
							<td>10013</td>
							<td>INDUSTRYCO CORPORATION INC</td>
							<td>IndustryCo</td>
							<td>CBCR</td>
							<td>US</td>
							<td>US</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10014</td>
							<td>ICI ELIM</td>
							<td>ICI ELIM</td>
							<td>CBCR</td>
							<td>US</td>
							<td>US</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10015</td>
							<td>LEASECO LLC</td>
							<td>LEASECO LLC</td>
							<td>CBCR</td>
							<td>US</td>
							<td>US</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10016</td>
							<td>MANUFACTURING CORPORATION INC</td>
							<td>MANUFACTURING CORPORATION INC</td>
							<td>CBCR</td>
							<td>US</td>
							<td>US</td>
							<td>NO</td>
							<td></td>
						</tr>
						<tr>
							<td>10017</td>
							<td>US DISTRIBUTION OPERATIONS</td>
							<td>US DISTRIBUTION OPERATIONS</td>
							<td>CBCR</td>
							<td>US</td>
							<td>US</td>
							<td>NO</td>
							<td></td>
						</tr>

					</tbody>
				</table>

			</div>
			<div id="Table1" class="tabcontent">
				<h5>Table 1. Overview of allocation of income, taxes and
					business activities by tax jurisdiction</h5>
				<table border="0" cellpadding="0" cellspacing="0" width="1000"
					style="border-collapse: collapse; table-layout: fixed; width: 900pt">
					<colgroup>
						<col width="106"
							style="mso-width-source: userset; mso-width-alt: 3876; width: 80pt">
						<col width="100"
							style="mso-width-source: userset; mso-width-alt: 3657; width: 75pt">
						<col width="88"
							style="mso-width-source: userset; mso-width-alt: 3218; width: 66pt">
						<col width="83"
							style="mso-width-source: userset; mso-width-alt: 3035; width: 62pt">
						<col width="82"
							style="mso-width-source: userset; mso-width-alt: 2998; width: 62pt">
						<col width="86"
							style="mso-width-source: userset; mso-width-alt: 3145; width: 65pt">
						<col width="74"
							style="mso-width-source: userset; mso-width-alt: 2706; width: 56pt">
						<col width="64" style="width: 48pt">
						<col width="84"
							style="mso-width-source: userset; mso-width-alt: 3072; width: 63pt">
						<col width="86"
							style="mso-width-source: userset; mso-width-alt: 3145; width: 65pt">
						<col width="75"
							style="mso-width-source: userset; mso-width-alt: 2742; width: 56pt">
					</colgroup>
					<tbody>
						<tr height="33"
							style="mso-height-source: userset; height: 24.75pt">
							<td colspan="11" height="33" class="xl69" width="928"
								style="border-right: .5pt solid black; height: 24.75pt; width: 698pt">Name<span
								style="mso-spacerun: yes">&nbsp; </span>of<span
								style="mso-spacerun: yes">&nbsp; </span>the<span
								style="mso-spacerun: yes">&nbsp; </span>MNE<span
								style="mso-spacerun: yes">&nbsp; </span>group: INDUSTRYCO
								CORPORATION INC<span style="mso-spacerun: yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
						</tr>
						<tr height="30" style="mso-height-source: userset; height: 22.5pt">
							<td colspan="11" height="30" class="xl71" width="928"
								style="border-right: .5pt solid black; height: 22.5pt; width: 698pt">Fiscal
								Year Concerned: 2014-12-31<span style="mso-spacerun: yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							</td>
						</tr>
						<tr height="34" style="mso-height-source: userset; height: 25.5pt">
							<td rowspan="2" height="121" class="xl76" width="106"
								style="height: 90.75pt; border-top: none; width: 80pt">Tax
								Jurisdiction</td>
							<!-- 271 -->
							<td colspan="3" class="xl76" width="300"
								style="border-left: none; width: 242pt">Revenues</td>
							<td rowspan="2" class="xl76" width="82"
								style="border-top: none; width: 62pt">
								<meta charset="utf-8"> <span
								style="white-space: pre-wrap">Profit (Loss) Before Income
									Tax</span>
							</td>
							<td rowspan="2" class="xl76" width="86"
								style="border-top: none; width: 65pt">Income Tax Paid (on
								cash basis)</td>
							<td rowspan="2" class="xl76" width="74"
								style="border-top: none; width: 56pt">Income Tax Accrued -
								Current Year</td>
							<td rowspan="2" class="xl76" width="64"
								style="border-top: none; width: 48pt">Stated Captial</td>
							<td rowspan="2" class="xl76" width="84"
								style="border-top: none; width: 63pt">Accumulated Earnings</td>
							<td rowspan="2" class="xl76" width="86"
								style="border-top: none; width: 65pt">Number of Employees</td>
							<td rowspan="2" class="xl76" width="75"
								style="border-top: none; width: 56pt">Tangible Assets other
								than Cash and Cash Equivalents</td>
						</tr>
						<tr height="87"
							style="mso-height-source: userset; height: 65.25pt">
							<td height="87" class="xl76" width="100"
								style="height: 65.25pt; border-top: none; border-left: none; width: 80pt">Unrelated
								Party</td>
							<td class="xl76" width="88"
								style="border-top: none; border-left: none; width: 82pt">Related
								Party</td>
							<td class="xl76" width="83"
								style="border-top: none; border-left: none; width: 80pt">Total</td>
						</tr>
						<!-- Table 1 table content here -->

						<tr height="30" style="mso-height-source: userset; height: 22.5pt">
							<td height="30" class="xl74" width="106"
								style="height: 22.5pt; width: 80pt">CA</td>
							<td class="xl74" width="100"
								style="border-left: none; width: 75pt">15,867,463,982</td>
							<td class="xl74" width="88"
								style="border-left: none; width: 66pt">-13,132,307,714</td>
							<td class="xl74" width="83"
								style="border-left: none; width: 62pt">2,735,156,268</td>
							<td class="xl74" width="82"
								style="border-left: none; width: 62pt">1,195,464,032</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">247,461,055</td>
							<td class="xl74" width="74"
								style="border-left: none; width: 56pt">215,183,526</td>
							<td class="xl74" width="64"
								style="border-left: none; width: 48pt">26,317,705</td>
							<td class="xl74" width="84"
								style="border-left: none; width: 63pt">1,255,227,943</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">51</td>
							<td class="xl75" style="border-left: none">1,691,169</td>
						</tr>

						<tr height="30" style="mso-height-source: userset; height: 22.5pt">
							<td height="30" class="xl74" width="106"
								style="height: 22.5pt; width: 80pt">CN</td>
							<td class="xl74" width="100"
								style="border-left: none; width: 75pt">-338,019,516</td>
							<td class="xl74" width="88"
								style="border-left: none; width: 66pt">524,772,210</td>
							<td class="xl74" width="83"
								style="border-left: none; width: 62pt">186,752,694</td>
							<td class="xl74" width="82"
								style="border-left: none; width: 62pt">65,472,636</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">18,695,711</td>
							<td class="xl74" width="74"
								style="border-left: none; width: 56pt">16,257,140</td>
							<td class="xl74" width="64"
								style="border-left: none; width: 48pt">4,386,284</td>
							<td class="xl74" width="84"
								style="border-left: none; width: 63pt">76,761,958</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">160</td>
							<td class="xl75" style="border-left: none">6,800,642</td>
						</tr>
						<tr height="30" style="mso-height-source: userset; height: 22.5pt">
							<td height="30" class="xl74" width="106"
								style="height: 22.5pt; width: 80pt">DE</td>
							<td class="xl74" width="100"
								style="border-left: none; width: 75pt">30,829,468</td>
							<td class="xl74" width="88"
								style="border-left: none; width: 66pt">0</td>
							<td class="xl74" width="83"
								style="border-left: none; width: 62pt">30,829,468</td>
							<td class="xl74" width="82"
								style="border-left: none; width: 62pt">25,501,050</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">8,665,895</td>
							<td class="xl74" width="74"
								style="border-left: none; width: 56pt">7,535,560</td>
							<td class="xl74" width="64"
								style="border-left: none; width: 48pt">50,000</td>
							<td class="xl74" width="84"
								style="border-left: none; width: 63pt">60,980,690</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">29</td>
							<td class="xl75" style="border-left: none">970,603</td>
						</tr>
						<tr height="30" style="mso-height-source: userset; height: 22.5pt">
							<td height="30" class="xl74" width="106"
								style="height: 22.5pt; width: 80pt">GB</td>
							<td class="xl74" width="100"
								style="border-left: none; width: 75pt">0</td>
							<td class="xl74" width="88"
								style="border-left: none; width: 66pt">0</td>
							<td class="xl74" width="83"
								style="border-left: none; width: 62pt">0</td>
							<td class="xl74" width="82"
								style="border-left: none; width: 62pt">1,199,997</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">227,700</td>
							<td class="xl74" width="74"
								style="border-left: none; width: 56pt">198,000</td>
							<td class="xl74" width="64"
								style="border-left: none; width: 48pt">0</td>
							<td class="xl74" width="84"
								style="border-left: none; width: 63pt">1,199,997</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">19</td>
							<td class="xl75" style="border-left: none">74,141</td>
						</tr>
						<tr height="30" style="mso-height-source: userset; height: 22.5pt">
							<td height="30" class="xl74" width="106"
								style="height: 22.5pt; width: 80pt">HK</td>
							<td class="xl74" width="100"
								style="border-left: none; width: 75pt">0</td>
							<td class="xl74" width="88"
								style="border-left: none; width: 66pt">3,260,826,946</td>
							<td class="xl74" width="83"
								style="border-left: none; width: 62pt">3,260,826,946</td>
							<td class="xl74" width="82"
								style="border-left: none; width: 62pt">3,616,571</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">1,413,664</td>
							<td class="xl74" width="74"
								style="border-left: none; width: 56pt">1,229,272</td>
							<td class="xl74" width="64"
								style="border-left: none; width: 48pt">74,500</td>
							<td class="xl74" width="84"
								style="border-left: none; width: 63pt">4,770,738</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">19</td>
							<td class="xl75" style="border-left: none">245,053</td>
						</tr>
						<tr height="30" style="mso-height-source: userset; height: 22.5pt">
							<td height="30" class="xl74" width="106"
								style="height: 22.5pt; width: 80pt">IE</td>
							<td class="xl74" width="100"
								style="border-left: none; width: 75pt">0</td>
							<td class="xl74" width="88"
								style="border-left: none; width: 66pt">1,851,334,928</td>
							<td class="xl74" width="83"
								style="border-left: none; width: 62pt">1,851,334,928</td>
							<td class="xl74" width="82"
								style="border-left: none; width: 62pt">1,840,169,029</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">264,524,298</td>
							<td class="xl74" width="74"
								style="border-left: none; width: 56pt">230,021,129</td>
							<td class="xl74" width="64"
								style="border-left: none; width: 48pt">78,000</td>
							<td class="xl74" width="84"
								style="border-left: none; width: 63pt">2,175,257,925</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">5</td>
							<td class="xl75" style="border-left: none">1,852,842</td>
						</tr>
						<tr height="30" style="mso-height-source: userset; height: 22.5pt">
							<td height="30" class="xl74" width="106"
								style="height: 22.5pt; width: 80pt">IN</td>
							<td class="xl74" width="100"
								style="border-left: none; width: 75pt">0</td>
							<td class="xl74" width="88"
								style="border-left: none; width: 66pt">11,414,668</td>
							<td class="xl74" width="83"
								style="border-left: none; width: 62pt">11,414,668</td>
							<td class="xl74" width="82"
								style="border-left: none; width: 62pt">808,857</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">279,056</td>
							<td class="xl74" width="74"
								style="border-left: none; width: 56pt">242,657</td>
							<td class="xl74" width="64"
								style="border-left: none; width: 48pt">135,000</td>
							<td class="xl74" width="84"
								style="border-left: none; width: 63pt">3,363,607</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">42</td>
							<td class="xl75" style="border-left: none">277,926</td>
						</tr>
						<tr height="30" style="mso-height-source: userset; height: 22.5pt">
							<td height="30" class="xl74" width="106"
								style="height: 22.5pt; width: 80pt">PH</td>
							<td class="xl74" width="100"
								style="border-left: none; width: 75pt">155,139,268</td>
							<td class="xl74" width="88"
								style="border-left: none; width: 66pt">-53,153,539</td>
							<td class="xl74" width="83"
								style="border-left: none; width: 62pt">101,985,729</td>
							<td class="xl74" width="82"
								style="border-left: none; width: 62pt">-65,405</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">280,698</td>
							<td class="xl74" width="74"
								style="border-left: none; width: 56pt">244,086</td>
							<td class="xl74" width="64"
								style="border-left: none; width: 48pt">10,965,711</td>
							<td class="xl74" width="84"
								style="border-left: none; width: 63pt">23,986,587</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">24</td>
							<td class="xl75" style="border-left: none">1,901,688</td>
						</tr>
						<tr height="30" style="mso-height-source: userset; height: 22.5pt">
							<td height="30" class="xl74" width="106"
								style="height: 22.5pt; width: 80pt">US</td>
							<td class="xl74" width="100"
								style="border-left: none; width: 75pt">-4,950,867,513</td>
							<td class="xl74" width="88"
								style="border-left: none; width: 66pt">12,512,601,336</td>
							<td class="xl74" width="83"
								style="border-left: none; width: 62pt">7,561,733,823</td>
							<td class="xl74" width="82"
								style="border-left: none; width: 62pt">3,049,029,992</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">1,747,074,909</td>
							<td class="xl74" width="74"
								style="border-left: none; width: 56pt">1,519,195,572</td>
							<td class="xl74" width="64"
								style="border-left: none; width: 48pt">476,634,632</td>
							<td class="xl74" width="84"
								style="border-left: none; width: 63pt">2,943,421,169</td>
							<td class="xl74" width="86"
								style="border-left: none; width: 65pt">584</td>
							<td class="xl75" style="border-left: none">160,435,377</td>
						</tr>

						<!--[if supportMisalignedColumns]-->
						<tr height="0" style="display: none">
							<td width="106" style="width: 80pt"></td>
							<td width="100" style="width: 75pt"></td>
							<td width="88" style="width: 66pt"></td>
							<td width="83" style="width: 62pt"></td>
							<td width="82" style="width: 62pt"></td>
							<td width="86" style="width: 65pt"></td>
							<td width="74" style="width: 56pt"></td>
							<td width="64" style="width: 48pt"></td>
							<td width="84" style="width: 63pt"></td>
							<td width="86" style="width: 65pt"></td>
							<td width="75" style="width: 56pt"></td>
						</tr>

						<!--[endif]-->
					</tbody>
				</table>

			</div>
			<div id="Table2" class="tabcontent">
				<h5>Table 2. List of all the Constituent Entities of the MNE
					group included in each aggregation per tax jurisdiction</h5>
				<table border="0" cellpadding="0" cellspacing="0" width="1424"
					style="border-collapse: collapse; table-layout: fixed; width: 1500pt">
					<colgroup>
						<col width="84"
							style="mso-width-source: userset; mso-width-alt: 3072; width: 63pt">
						<col width="87"
							style="mso-width-source: userset; mso-width-alt: 3181; width: 165pt">
						<col width="123"
							style="mso-width-source: userset; mso-width-alt: 4498; width: 92pt">
						<col width="95"
							style="mso-width-source: userset; mso-width-alt: 3474; width: 71pt">
						<col width="90"
							style="mso-width-source: userset; mso-width-alt: 3291; width: 68pt">
						<col width="92"
							style="mso-width-source: userset; mso-width-alt: 3364; width: 69pt">
						<col width="105"
							style="mso-width-source: userset; mso-width-alt: 3840; width: 79pt">
						<col width="117"
							style="mso-width-source: userset; mso-width-alt: 4278; width: 88pt">
						<col width="106"
							style="mso-width-source: userset; mso-width-alt: 3876; width: 80pt">
						<col width="91"
							style="mso-width-source: userset; mso-width-alt: 3328; width: 68pt">
						<col width="64" style="width: 48pt">
						<col width="81"
							style="mso-width-source: userset; mso-width-alt: 2962; width: 61pt">
						<col width="74"
							style="mso-width-source: userset; mso-width-alt: 2706; width: 56pt">
						<col width="87"
							style="mso-width-source: userset; mso-width-alt: 3181; width: 65pt">
						<col width="64" span="2" style="width: 48pt">
					</colgroup>
					<tbody>
						<tr height="20" style="height: 15.0pt">
							<td colspan="16" height="20" class="x0l72" width="1424"
								style="border-right: .5pt solid black; height: 15.0pt; width: 1069pt">Name
								of the MNE group: INDUSTRYCO CORPORATION INC</td>
						</tr>
						<tr height="21" style="height: 15.75pt">
							<td colspan="16" height="21" class="x0l69" width="1424"
								style="border-right: .5pt solid black; height: 15.75pt; width: 1069pt">Fiscal
								year concerned: 2014-12-31</td>
						</tr>
						<tr height="22" style="height: 16.5pt">
							<td rowspan="2" height="170" class="x0l67" width="84"
								style="height: 127.5pt; width: 63pt">Tax Jurisdiction</td>
							<td rowspan="2" class="x0l67" width="87" style="width: 65pt">Constituent
								Entities resident in the Tax Jurisdiction</td>
							<td rowspan="2" class="x0l67" width="123" style="width: 92pt">Tax
								Jurisdiction of organisation of incorporation if different from
								Tax Jurisdiction of Resident</td>
							<td colspan="13" class="x0l67" width="1130"
								style="border-left: none; width: 849pt">Main business
								activity(ies)</td>
						</tr>
						<tr height="148"
							style="mso-height-source: userset; height: 111.0pt">
							<td height="148" class="x0l67" width="95"
								style="height: 111.0pt; border-top: none; border-left: none; width: 71pt">Research
								and Development</td>
							<td class="x0l67" width="90"
								style="border-top: none; border-left: none; width: 68pt">Holding
								or Managing intellectual Property</td>
							<td class="x0l67" width="92"
								style="border-top: none; border-left: none; width: 69pt">Purchase
								or Procurement</td>
							<td class="x0l67" width="105"
								style="border-top: none; border-left: none; width: 79pt">Manufacturing
								or Production</td>
							<td class="x0l67" width="117"
								style="border-top: none; border-left: none; width: 88pt">Sales,
								Marketing or Distribution</td>
							<td class="x0l67" width="106"
								style="border-top: none; border-left: none; width: 80pt">Administrative,
								Management or Support Services</td>
							<td class="x0l67" width="91"
								style="border-top: none; border-left: none; width: 68pt">Provision
								of Services to unrelated parties</td>
							<td class="x0l67" width="64"
								style="border-top: none; border-left: none; width: 48pt">Internal
								Group Finance</td>
							<td class="x0l67" width="81"
								style="border-top: none; border-left: none; width: 61pt">Regulated
								Financial Services</td>
							<td class="x0l67" width="74"
								style="border-top: none; border-left: none; width: 56pt">Insurance</td>
							<td class="x0l67" width="87"
								style="border-top: none; border-left: none; width: 65pt">Holding
								shares or other equity instruments</td>
							<td class="x0l67" width="64"
								style="border-top: none; border-left: none; width: 48pt">Dormant</td>
							<td class="x0l67" width="64"
								style="border-top: none; border-left: none; width: 48pt">Other2</td>
						</tr>
						<!-- Table 2 number content from 2nd column here -->
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">CA</td>
							<td class="x0l65" style="border-left: none">GLOBAL SALESCO</td>
							<td class="x0l66" style="border-left: none">CA</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">x</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>

						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">CN</td>
							<td class="x0l65" style="border-left: none">CHINA
								MANUFACTURING CO</td>
							<td class="x0l66" style="border-left: none">CN</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">x</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">DE</td>
							<td class="x0l65" style="border-left: none">German HoldCo
								GmbH</td>
							<td class="x0l66" style="border-left: none">DE</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">x</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">DE</td>
							<td class="x0l65" style="border-left: none">Germany
								SubAssembly GmbH</td>
							<td class="x0l66" style="border-left: none">DE</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">x</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">GB</td>
							<td class="x0l65" style="border-left: none">FINANCECO, LTD.</td>
							<td class="x0l66" style="border-left: none">GB</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">x</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">HK</td>
							<td class="x0l65" style="border-left: none">APAC SALES
								CORPORATION</td>
							<td class="x0l66" style="border-left: none">HK</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">IE</td>
							<td class="x0l65" style="border-left: none">Irish IPCo, Ltd</td>
							<td class="x0l66" style="border-left: none">IE</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">IN</td>
							<td class="x0l65" style="border-left: none">India IT Ltd 1</td>
							<td class="x0l66" style="border-left: none">IN</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">IN</td>
							<td class="x0l65" style="border-left: none">India IT Ltd 2</td>
							<td class="x0l66" style="border-left: none">IN</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">PH</td>
							<td class="x0l65" style="border-left: none">SHARED SERVICES
								OPERATIONS LTD</td>
							<td class="x0l66" style="border-left: none">PH</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">x</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">US</td>
							<td class="x0l65" style="border-left: none">AMERICAS SALES
								LLC</td>
							<td class="x0l66" style="border-left: none">US</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">US</td>
							<td class="x0l65" style="border-left: none">GLOBAL SALESCO</td>
							<td class="x0l66" style="border-left: none">US</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">x</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">US</td>
							<td class="x0l65" style="border-left: none">IndustryCo</td>
							<td class="x0l66" style="border-left: none">US</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">US</td>
							<td class="x0l65" style="border-left: none">ICI ELIM</td>
							<td class="x0l66" style="border-left: none">US</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">x</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">US</td>
							<td class="x0l65" style="border-left: none">LEASECO LLC</td>
							<td class="x0l66" style="border-left: none">US</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">x</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">uS</td>
							<td class="x0l65" style="border-left: none">MANUFACTURING
								CORPORATION INC</td>
							<td class="x0l66" style="border-left: none">US</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">x</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<tr>
						<tr height="21" style="height: 15.75pt">
							<td class="x0l65" style="border-left: none">US</td>
							<td class="x0l65" style="border-left: none">US DISTRIBUTION
								OPERATIONS</td>
							<td class="x0l66" style="border-left: none">US</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">1</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
							<td class="x0l66" style="border-left: none">&nbsp;</td>
						</tr>
						<!--[if supportMisalignedColumns]-->
						<tr height="0" style="display: none">
							<td width="84" style="width: 63pt"></td>
							<td width="87" style="width: 65pt"></td>
							<td width="123" style="width: 92pt"></td>
							<td width="95" style="width: 71pt"></td>
							<td width="90" style="width: 68pt"></td>
							<td width="92" style="width: 69pt"></td>
							<td width="105" style="width: 79pt"></td>
							<td width="117" style="width: 88pt"></td>
							<td width="106" style="width: 80pt"></td>
							<td width="91" style="width: 68pt"></td>
							<td width="64" style="width: 48pt"></td>
							<td width="81" style="width: 61pt"></td>
							<td width="74" style="width: 56pt"></td>
							<td width="87" style="width: 65pt"></td>
							<td width="64" style="width: 48pt"></td>
							<td width="64" style="width: 48pt"></td>
						</tr>
						<!--[endif]-->
					</tbody>
				</table>
				<h6>Please specify the nature if the activity of the
					Consitituent Entity in the "Additional Information" section.</h6>
			</div>
			<div id="Table3" class="tabcontent">
				<h5>Table 3. Additional Information</h5>

				<table style="width: 100%">

					<tr>

						<th><div id="table3head">Name of the MNE group:
								INDUSTRYCO CORPORATION INC</div>
							<div id="table3head">Fiscal year concerned: 2014-12-31</div></th>
					</tr>

					<tr>

						<td class="x00l66" rows="4" cols="280" id="To"></td>

					</tr>

				</table>
			</div>

			<!--  /div-->
		</div>
	</div>
	<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}

		$("document").ready(function() {
			setTimeout(function() {
				$('#current').trigger('click');
			}, 10);
			openCity(event, "Message");
		});
	</script>
</body>
