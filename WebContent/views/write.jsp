
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@page import="com.tie.app.TieController"%>
<%@page import="com.tie.app.TieSessionController"%>
<%@page import="com.tie.ui.TieMainPage"%>
<%@page import="com.tie.model.TieMsg"%>
<%@page import="com.tie.model.TieDoc"%>
<%@page import="com.tie.model.TieMsgReceiver"%>
<%@page import="com.tie.model.TieMsgState"%>
<%@page import="com.tie.model.TieTaxEntity"%>
<%@page import="com.tie.model.CbcrTable1"%>
<%@page import="com.tie.model.CbcrTable2"%>

<body>

	<%!TieMainPage tieMainPage = TieMainPage.getTieMainPage();%>
	<%!List<TieMsg> msgList = tieMainPage.getMsgList();%>
	<%!List<TieMsgReceiver> tieMsgReceiverList = tieMainPage.getTiemsgReceiverList();%>
	<%!TieMsg currentMsg = tieMainPage.getCurrentMsg();%>
	<%!List<TieDoc> tieDocList = currentMsg.getTieDocList();%>
	<%!TieMsgState tieMsgState = tieMainPage.getTieMsgState();%>
	<%!TieDoc currentTieDoc = tieMainPage.getCurrentTieDoc();%>
	<%!List<TieTaxEntity> taxEntitylist = tieMainPage.getTaxEntitylist();%>
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
							<th>Status</th>
						</tr>
					</thead>


					<tbody class="member">
						<!-- Generate auto increment td id later -->
						<%
							for (TieMsg tieMsg : tieMainPage.getMsgList()) {
						%>
						<tr id="currentMsg1">
							<th scope="row"><%=tieMainPage.getUsername()%></th>
							<td><%=tieMsg.getSubject()%></td>
							<td><%=tieMsg.getDescription()%></td>
							<td><%=tieMsg.getTimestamp()%></td>
							<td><%=tieMainPage.getTieMsgState().getName()%></td>
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
				<li><a id="currentTab" class="tablinks"
					onclick="openCity(event, 'Message')">Message</a></li>
				<li><a class="tablinks" onclick="openCity(event, 'Docs')">Docs</a></li>
				<li><a class="tablinks" onclick="openCity(event, 'Entity')">Entity</a></li>
				<li><a class="tablinks" onclick="openCity(event, 'Table1')">Table1</a></li>
				<li><a class="tablinks" onclick="openCity(event, 'Table2')">Table2</a></li>
				<li><a class="tablinks" onclick="openCity(event, 'Table3')">Table3</a></li>

			</ul>


			<div id="Message" class="tabcontent">
				<div id="currentMsgBody">
					<div class="row">
						<div class="col-md-3">
							<p>
								From:
								<%=tieMainPage.getCurrentMsg().getSender().getName()%></p>
						</div>


						<div class="col-md-3">
							<p>
								Date:
								<%=tieMainPage.getCurrentMsg().getTimestamp()%></p>
						</div>

						<div class="col-md-3">
							<p>
								Reporting Period:
								<%=tieMainPage.getCurrentMsg().getReportingPeriod()%></p>
						</div>

						<div class="col-md-3">
							<p>
								Status:
								<%=tieMsgState.getName()%></p>
						</div>
					</div>

					<div class="row">
						<div id="formGroup">
							<form>
								<div class="form-group row">
									<label for="To" class="col-sm-2 form-control-label">To:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="To"
											placeholder="<%=tieMainPage.getToListString()%>">
									</div>

								</div>



								<div class="form-group row">
									<label for="Subject" class="col-sm-2 form-control-label">Subject:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="Subject"
											placeholder="<%=tieMainPage.getCurrentMsg().getDescription()%>">
									</div>
								</div>
								<div class="form-group row">
									<label for="Notes" class="col-sm-2 form-control-label">Notes:</label>
									<div class="col-sm-10">
										<textarea rows="4" cols="95"><%=tieMainPage.getCurrentMsg().getNotes()%></textarea>
									</div>
								</div>
								<div class="form-group row">
									<label for="Warning" class="col-sm-2 form-control-label">Warning:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="Warning"
											placeholder="<%=tieMainPage.getCurrentMsg().getWarning()%>">
									</div>
								</div>
								<div class="form-group row">
									<label for="Contact" class="col-sm-2 form-control-label">Contact:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="Contact"
											placeholder="<%=tieMainPage.getCurrentMsg().getContact()%>">
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
									<td><%=tieMainPage.getCurrentMsg().getMessageRefId()%></td>
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
									<td><%=tieMainPage.getCurrentMsg().getTransmittingCountry()%></td>
								</tr>
								<tr>
									<th>Language:</th>
									<td><select class="form-control" id="sel1">
											<option>EN</option>
											<option>ES</option>
											<option>CN</option>
									</select></td>
								</tr>
							</table>
						</div>
						<div class="col-md-6">
							<table style="width: 100%">
								<tr>
									<th>Reporting Period:</th>
									<td><%=tieMainPage.getCurrentMsg().getReportingPeriod()%></td>
								</tr>

								<tr>
									<th>OECD Message Type Indic:</th>
									<td><select class="form-control" id="sel1">
											<%
												for (String OECDIndi : tieMainPage.getCurrentMsg().messageTypeIndi) {
											%>
											<option><%=OECDIndi%></option>
											<%
												}
											%>
									</select></td>
								</tr>


								<tr>
									<th>Receiving Country:</th>
									<td><%=tieMainPage.getCurrentMsg().getReceivingCountries()%></td>
								</tr>
							</table>
						</div>
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
					<tbody id="currentDocBody">
						<%
							for (TieDoc tieDoc : tieMainPage.getCurrentMsg().getTieDocList()) {
						%>
						<tr id="currentDoc1">
							<td><%=tieDoc.getCode()%>
							</th>
							<td><%=tieDoc.getName()%></td>
							<td>CBCR</td>
							<td><%=tieDoc.getReportingEntityCode()%></td>
							<td><%=tieDoc.getCurrencyCode()%></td>
							<td><%=tieDoc.getResCountryCode()%></td>
							<td><%=tieDoc.getAccountingStandard()%></td>
							<td><%=tieDoc.getReportingPeriod()%></td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
			<div id="Entity" class="tabcontent">
				<div class="row" id="docrow">
					<h3>&nbsp;&nbsp; Entities in CBCR Doc:</h3>
				</div>
				<div id="currentEntityBody">
					<div class="row">
						<div class="col-md-6">

							<table style="width: 100%">
								<tr>
									<td>Reporting Entity:</td>
									<td><%=tieMainPage.getCurrentTieDoc().getReportingEntity().getName() %></td>
								</tr>
								<tr>
									<td>Resident Country:</td>
									<td><%=tieMainPage.getCurrentTieDoc().getResCountryCode()%></td>
								</tr>
							</table>
						</div>
						<div class="col-md-3">Currency:</div>
						<div class="col-md-3"><%=tieMainPage.getCurrentTieDoc().getCurrencyCode()%></div>
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
							<%
								for (TieTaxEntity taxentity : tieMainPage.getTaxEntitylist()) {
							%>
							<tr id="currentMsg1">

								<td><%=taxentity.getTaxIdNum()%></td>
								<td><%=taxentity.getName()%></td>
								<td><%=taxentity.getEntityCode()%></td>
								<td>CBCR</td>
								<td><%=taxentity.getIncorpCountryCode()%></td>
								<td><%=taxentity.getResCountryCode()%></td>
								<td><%=taxentity.getIsPermExtabliment()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<div id="Table1" class="tabcontent">
				<h5>Table 1. Overview of allocation of income, taxes and
					business activities by tax jurisdiction</h5>
				<div id="currentTable1Body">
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
									style="mso-spacerun: yes">&nbsp; </span>group: <%=tieMainPage.getCurrentTieDoc().getReportingEntity().getName() %>
									<span style="mso-spacerun: yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
							</tr>
							<tr height="30"
								style="mso-height-source: userset; height: 22.5pt">
								<td colspan="11" height="30" class="xl71" width="928"
									style="border-right: .5pt solid black; height: 22.5pt; width: 698pt">Fiscal
									Year Concerned: <%=tieMainPage.getCurrentTieDoc().getReportingPeriod() %><span style="mso-spacerun: yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								</td>
							</tr>

							<tr height="34"
								style="mso-height-source: userset; height: 25.5pt">
								<td rowspan="2" height="121" class="xl76" width="106"
									style="height: 90.75pt; border-top: none; width: 80pt">Tax
									Jurisdiction</td>
								<!-- 271 -->
								<td colspan="3" class="xl76" width="300"
									style="border-left: none; width: 242pt">Revenues</td>
								<td rowspan="2" class="xl76" width="82"
									style="border-top: none; width: 62pt">
									<meta charset="utf-8"> <span
									style="white-space: pre-wrap">Profit (Loss) Before
										Income Tax</span>
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
									style="border-top: none; width: 56pt">Tangible Assets
									other than Cash and Cash Equivalents</td>
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
							<%
								for (CbcrTable1 cbcrTable1 : tieMainPage.getCurrentTieDoc().getCbcrTable1List()) {
							%>
							<tr height="30"
								style="mso-height-source: userset; height: 22.5pt">
								<td height="30" class="xl74" width="106"
									style="height: 22.5pt; width: 80pt"><%=cbcrTable1.getTaxJurisdiction()%></td>
								<td class="xl74" width="100"
									style="border-left: none; width: 75pt"><%=cbcrTable1.getRevenueUnrelatedParty()%></td>
								<td class="xl74" width="88"
									style="border-left: none; width: 66pt">-<%=cbcrTable1.getRevenueRelatedParty()%></td>
								<td class="xl74" width="83"
									style="border-left: none; width: 62pt"><%=cbcrTable1.getRevenueTotal()%></td>
								<td class="xl74" width="82"
									style="border-left: none; width: 62pt"><%=cbcrTable1.getPlBeforeIncomeTax()%></td>
								<td class="xl74" width="86"
									style="border-left: none; width: 65pt"><%=cbcrTable1.getIncomeTaxPaid()%></td>
								<td class="xl74" width="74"
									style="border-left: none; width: 56pt"><%=cbcrTable1.getIncomeTaxAccrued()%></td>
								<td class="xl74" width="64"
									style="border-left: none; width: 53pt"><%=cbcrTable1.getStatedCapital()%></td>
								<td class="xl74" width="84"
									style="border-left: none; width: 63pt"><%=cbcrTable1.getAccumulatedEarnings()%></td>
								<td class="xl74" width="86"
									style="border-left: none; width: 65pt"><%=cbcrTable1.getNumberOfEmployees()%></td>
								<td class="xl75" style="border-left: none"><%=cbcrTable1.getTangibleAssetsNonCash()%></td>
							</tr>
							<%
								}
							%>


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
			</div>
			<div id="Table2" class="tabcontent">
				<h5>Table 2. List of all the Constituent Entities of the MNE
					group included in each aggregation per tax jurisdiction</h5>
				<div id="currentTable2Body">
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
									of the MNE group: <%=tieMainPage.getCurrentTieDoc().getReportingEntity().getName()%></td>
							</tr>
							<tr height="21" style="height: 15.75pt">
								<td colspan="16" height="21" class="x0l69" width="1424"
									style="border-right: .5pt solid black; height: 15.75pt; width: 1069pt">Fiscal
									year concerned: <%=tieMainPage.getCurrentTieDoc().getReportingPeriod() %></td>
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
							<%
								for (CbcrTable2 cbcrTable2 : tieMainPage.getCurrentTieDoc().getCbcrTable2List()) {
							%>
							<tr height="30"
								style="mso-height-source: userset; height: 22.5pt">
								<td height="30" class="xl74" width="106"
									style="height: 22.5pt; width: 80pt"><%=cbcrTable2.getTaxJurisdiction()%></td>
								<td class="xl74" width="100"
									style="border-left: none; width: 200pt"><%=cbcrTable2.getEntityCode()%></td>
								<td class="xl74" width="88"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getTaxJurisdiction()%></td>
								<td class="xl74" width="83"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusRAndD()%></td>
								<td class="xl74" width="82"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusHoldingIp()%></td>
								<td class="xl74" width="86"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusPurchasing()%></td>
								<td class="xl74" width="74"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusMfctOrPrdn()%></td>
								<td class="xl74" width="64"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusSaleMktDistr()%></td>
								<td class="xl74" width="84"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusAdminMgmtSupportSvc()%></td>
								<td class="xl74" width="86"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusProvSvcToUnrelatedParti()%></td>
								<td class="xl74" width="86"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusInternalGroupFinance()%></td>
								<td class="xl74" width="86"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusRegulatedFinSvc()%></td>
								<td class="xl74" width="86"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusInsurance()%></td>
								<td class="xl74" width="86"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusHoldingEquityInstrument()%></td>
								<td class="xl74" width="86"
									style="border-left: none; width: 80pt"><%=cbcrTable2.getMainBusDormant()%></td>
								<td class="xl75" style="border-left: none"><%=cbcrTable2.getMainBusOther()%></td>
							</tr>
							<%
								}
							%>
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
				</div>
				<h6>Please specify the nature if the activity of the
					Consitituent Entity in the "Additional Information" section.</h6>
			</div>
			<div id="Table3" class="tabcontent">

				<h5>Table 3. Additional Information</h5>
				<div id="CurrentTable3Body">
					<table style="width: 100%">

						<tr>

							<th><div id="table3head">Name of the MNE group:
									<%=tieMainPage.getCurrentTieDoc().getReportingEntity().getName()%></div>
								<div id="table3head">Fiscal year concerned: <%=tieMainPage.getCurrentTieDoc().getReportingPeriod() %></div></th>
						</tr>

						<tr>

							<td class="x00l66" rows="4" cols="280" id="To">
							<%=tieMainPage.getTable3String() %>
							</td>

						</tr>

					</table>
				</div>
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
				$('#currentTab').trigger('click');
			}, 10);
			setTimeout(function() {
				$('#currentDoc1').trigger('click');
			}, 10);
			setTimeout(function() {
				$('#currentMsg1').trigger('click');
			}, 10);
			openCity(event, "Message");
		});

		$("tr").click(function() {
			$(this).parent().children().removeClass("selected");
			$(this).addClass("selected");
		});

		$("#currentMsg2").click(function() {
			$("#currentMsgBody").hide();
			$("#currentDocBody").hide();
			$("#currentEntityBody").hide();
			$("#currentTable1Body").hide();
			$("#currentTable2Body").hide();
			$("#currentTable3Body").hide();
		});
		$("#currentMsg3").click(function() {
			$("#currentMsgBody").hide();
			$("#currentDocBody").hide();
			$("#currentEntityBody").hide();
			$("#currentTable1Body").hide();
			$("#currentTable2Body").hide();
			$("#currentTable3Body").hide();
		});

		$("#currentMsg1").click(function() {
			$("#currentMsgBody").show();
			$("#currentDocBody").show();
			$("#currentEntityBody").show();
			$("#currentTable1Body").show();
			$("#currentTable2Body").show();
			$("#currentTable3Body").show();

		});
		$("#currentDoc1").click(function() {
			$("#currentMsgBody").show();
			$("#currentDocBody").show();
			$("#currentEntityBody").show();
			$("#currentTable1Body").show();
			$("#currentTable2Body").show();
			$("#currentTable3Body").show();

		});
		$("#currentDoc2").click(function() {
			$("#currentEntityBody").hide();
			$("#currentTable1Body").hide();
			$("#currentTable2Body").hide();
			$("#currentTable3Body").hide();

		});
	</script>
</body>
