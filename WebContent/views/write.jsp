
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
<%@page import="com.tie.model.CbcrTable3"%>
<body ng-app="gridapp">

	<%!TieMainPage tieMainPage = TieMainPage.getTieMainPage();%>
	<%!List<TieMsg> msgList = tieMainPage.getMsgList();%>
	<%!List<TieMsgReceiver> tieMsgReceiverList = tieMainPage.getTiemsgReceiverList();%>
	<%!TieMsg currentMsg = tieMainPage.getCurrentMsg();%>
	<%!List<TieDoc> tieDocList = currentMsg.getTieDocList();%>
	<%!TieMsgState tieMsgState = tieMainPage.getTieMsgState();%>
	<%!TieDoc currentTieDoc = tieMainPage.getCurrentTieDoc();%>
	<%!List<TieTaxEntity> taxEntitylist = tieMainPage.getTaxEntitylist();%>
	<div class="panel-container-vertical">
		<div class="panel-top" ng-controller="writeController">
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
							<tr id="currentMsg1" class="clickable-row" ng-click="refData()">
								<th scope="row"><%=tieMainPage.getUsername()%></th>
								<td><%=tieMsg.getSubject()%></td>
								<td><%=tieMsg.getDescription()%></td>
								<td><%=tieMsg.getTimestamp()%></td>
								<td><%=tieMainPage.getTieMsgState().getName()%></td>
								<td class="msgID"><%=tieMsg.getTieMsgId()%></td>

							</tr>
							<%
								}
							%>

						</tbody>
					</table>

				</div>

			</div>

		</div>
		<div class="splitter-horizontal"></div>
		<div class="panel-bottom">
			<div class="container" ng-controller="writeController">
				<div class="scrollbar3" id="style-4">
					<!--  div class="force-overflow3"-->

					<ul class="tab">
						<li><a id="currentMsgTab" class="tablinks"
							onclick="openTag(event, 'Message')" title="This is message pane.">Message</a></li>
						<li><a id="currentDocTab" class="tablinks"
							onclick="openTag(event, 'Docs')"
							title="Current Message:<%=tieMainPage.getCurrentMsg().getSubject()%>">Docs
								</br>
								<h6 id="docTagSub">(no data)</h6>
						</a></li>
						<li><a id="currentEntityTab" class="tablinks"
							onclick="openTag(event, 'Entity')"
							title="Current Doc:<%=tieMainPage.getCurrentTieDoc().getCode()%>">Entity</br>
								<h6 id="entityTagSub">(no data)</h6></a></li>
						<li><a id="currentTable1Tab" class="tablinks"
							onclick="openTag(event, 'Table1')"
							title="Current Doc:<%=tieMainPage.getCurrentTieDoc().getCode()%>">Table1</br>
								<h6 id="t1TagSub">(no data)</h6></a></li>
						<li><a id="currentTable2Tab" class="tablinks"
							onclick="openTag(event, 'Table2')"
							title="Current Doc:<%=tieMainPage.getCurrentTieDoc().getCode()%>">Table2</br>
								<h6 id="t2TagSub">(no data)</h6></a></li>
						<li><a id="currentTable3Tab" class="tablinks"
							onclick="openTag(event, 'Table3')"
							title="Current Doc:<%=tieMainPage.getCurrentTieDoc().getCode()%>">Table3</br>
								<h6 id="t3TagSub">(no data)</h6></a></li>

					</ul>


					<div id="Message" class="tabcontent">
						<div id="currentMsgBody">
							<div class="row">
								<div class="col-md-3">
									<p>
										From:<span id="from"> <%=tieMainPage.getCurrentMsg().getSender().getName()%></span>
									</p>
								</div>


								<div class="col-md-3">
									<p>
										Date: <span id="date"><%=tieMainPage.getCurrentMsg().getTimestamp()%></span>
									</p>
								</div>

								<div class="col-md-3">
									<p>
										Reporting Period: <span id="reportingPeriod"> <%=tieMainPage.getCurrentMsg().getReportingPeriod()%></span>
									</p>
								</div>

								<div class="col-md-3">
									<p>
										Status: <span id=tieMsgState> <%=tieMsgState.getName()%></span>
									</p>
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
												<textarea rows="4" cols="95" id="notes"><%=tieMainPage.getCurrentMsg().getNotes()%></textarea>
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
											<td id="MessageRefId"><%=tieMainPage.getCurrentMsg().getMessageRefId()%></td>
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
											<td id="TransmittingCountry"><%=tieMainPage.getCurrentMsg().getTransmittingCountry()%></td>
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
											<td id="getReportingPeriod"><%=tieMainPage.getCurrentMsg().getReportingPeriod()%></td>
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
											<td id="ReceivingCountry"><%=tieMainPage.getCurrentMsg().getReceivingCountries()%></td>
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
						<!--table class="table">
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
						<%for (TieDoc tieDoc : tieMainPage.getCurrentMsg().getTieDocList()) {%>
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
						<%}%>

					</tbody>
				</table-->
						<div>
							<!-- mySelections:{{mySelections}}
					</br>
					ID : {{rowIndex}}-->
							<div id="grid1" ui-grid="gridOptions" ui-grid-selection
								ui-grid-auto-resize class="grid"></div>

						</div>
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
											<td>
												<!--%=tieMainPage.getCurrentTieDoc().getReportingEntity().getName()%-->{{reportingEntity.reportingEntityName}}
											</td>
										</tr>
										<tr>
											<td>Resident Country:</td>
											<td>
												<!--%=tieMainPage.getCurrentTieDoc().getResCountryCode()%-->{{reportingEntity.resCountryCode}}
											</td>
										</tr>
									</table>
								</div>
								<div class="col-md-3">Currency:</div>
								<div class="col-md-3">
									<!--%=tieMainPage.getCurrentTieDoc().getCurrencyCode()%-->
									{{reportingEntity.currencyCode}}
								</div>
							</div>

							</br>
							<!--table class="table">
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
							<%for (TieTaxEntity taxentity : tieMainPage.getTaxEntitylist()) {%>
							<tr id="currentMsg1">

								<td><%=taxentity.getTaxIdNum()%></td>
								<td><%=taxentity.getName()%></td>
								<td><%=taxentity.getEntityCode()%></td>
								<td>CBCR</td>
								<td><%=taxentity.getIncorpCountryCode()%></td>
								<td><%=taxentity.getResCountryCode()%></td>
								<td><%=taxentity.getIsPermExtabliment()%></td>
							</tr>
							<%}%>
						</tbody>
					</table-->
							<div>
								<div id="grid2" ui-grid="gridOptions2" ui-grid-auto-resize
									class="grid2"></div>
							</div>
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
											style="mso-spacerun: yes">&nbsp; </span>group: <%=tieMainPage.getCurrentTieDoc().getReportingEntity().getName()%>
											<span style="mso-spacerun: yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
									</tr>
									<tr height="30"
										style="mso-height-source: userset; height: 22.5pt">
										<td colspan="11" height="30" class="xl71" width="928"
											style="border-right: .5pt solid black; height: 22.5pt; width: 698pt">Fiscal
											Year Concerned: <%=tieMainPage.getCurrentTieDoc().getReportingPeriod()%><span
											style="mso-spacerun: yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
										</td>
									</tr>



									<!--[endif]-->
								</tbody>
							</table>


						</div>
						<div>
							<div id="grid3" ui-grid="gridOptions3" ui-grid-auto-resize
								class="grid3"></div>
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
											year concerned: <%=tieMainPage.getCurrentTieDoc().getReportingPeriod()%></td>
									</tr>
									<tr height="22" style="height: 16.5pt">
										<td rowspan="2" height="170" class="x0l67" width="84"
											style="height: 127.5pt; width: 63pt">Tax Jurisdiction</td>
										<td rowspan="2" class="x0l67" width="87" style="width: 65pt">Constituent
											Entities resident in the Tax Jurisdiction</td>
										<td rowspan="2" class="x0l67" width="123" style="width: 92pt">Tax
											Jurisdiction of organisation of incorporation if different
											from Tax Jurisdiction of Resident</td>
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

									<!--[endif]-->
								</tbody>
							</table>
							<div>
								<div id="grid4" ui-grid="gridOptions4" ui-grid-auto-resize
									ui-grid-pagination class="grid4"></div>
							</div>
						</div>
						<h6>Please specify the nature if the activity of the
							Consitituent Entity in the "Additional Information" section.</h6>
					</div>
					<div id="Table3" class="tabcontent">

						<h5>Table 3. Additional Information</h5>
						<div id="CurrentTable3Body">
							<table style="width: 100%">

								<tr>

									<th><div id="table3head">
											Name of the MNE group:
											<%=tieMainPage.getCurrentTieDoc().getReportingEntity().getName()%></div>
										<div id="table3head">
											Fiscal year concerned:
											<%=tieMainPage.getCurrentTieDoc().getReportingPeriod()%></div></th>
								</tr>



							</table>
							</br>
							<div>
								<div id="grid5" ui-grid="gridOptions5" ui-grid-auto-resize
									class="grid5"></div>
							</div>
						</div>
					</div>

					<!--  /div-->

				</div>
			</div>
		</div>
	</div>
	<script src="javascript/write.js"></script>
</body>
