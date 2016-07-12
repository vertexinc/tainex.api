

<style>
body {
	font-family: "Lato", sans-serif;
}

.up {
	height: 300px;
}

ul.tab {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}
/* Float the list items side by side */
ul.tab li {
	float: left;
}
/* Style the links inside the list items */
ul.tab li a {
	display: inline-block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	transition: 0.3s;
	font-size: 17px;
}
/* Change background color of links on hover */
ul.tab li a:hover {
	background-color: #44c4e7;
}
/* Create an active/current tablink class */
ul.tab li a:focus, .active {
	background-color: #44c4e7;
}
/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}

#Message {
	width: 100%;
}

#leftside {
	float: left;
	padding-left: 10px;
}

#middleside {
	float: right;
	padding-top: 15px;
	padding-right: 50%;
}

#rightside {
	float: right;
	padding-top: 15px;
	padding-right: 30%;
}

#upper {
	height: 260px;
}

#docrow {
	padding-left: 10px;
}

.scrollbar2 {
	margin-left: 0px;
	float: left;
	height: 250px;
	width: 100%;
	overflow-y: scroll;
	margin-bottom: 25px;
}

#rotate {
	/* Rotate div */
	-ms-transform: rotate(270deg); /* IE 9 */
	-webkit-transform: rotate(270deg); /* Chrome, Safari, Opera */
	transform: rotate(270deg);
}

.force-overflow2 {
	min-height: 200px;
}

.scrollbar3 {
	margin-left: 0px;
	float: left;
	height: 400px;
	width: 100%;
	overflow-y: scroll;
	margin-bottom: 25px;
}

.force-overflow3 {
	min-height: 200px;
}

h5 {
	text-align: center;
}

#Table1 {
	text-align: center;
}

#style-4::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
	background-color: #F5F5F5;
}

#style-4::-webkit-scrollbar {
	width: 10px;
	background-color: #F5F5F5;
}

#style-4::-webkit-scrollbar-thumb {
	background-color: #0ae;
	background-image: -webkit-gradient(linear, 0 0, 0 100%, color-stop(.5, rgba(255, 255, 255,
		.2)), color-stop(.5, transparent), to(transparent));
}

#formGroup {
	padding-left: 15px;
	padding-right: 30px;
}

#formGroup #inputarea {
	margin-right: 15px;
}

tr {
	mso-height-source: auto;
}

col {
	mso-width-source: auto;
}

br {
	mso-data-placement: same-cell;
}

.style33 {
	background: #A5A5A5;
	mso-pattern: black none;
	color: white;
	font-size: 11.0pt;
	font-weight: 700;
	font-style: normal;
	text-decoration: none;
	font-family: Calibri, sans-serif;
	mso-font-charset: 0;
	border: 2.0pt double #3F3F3F;
	mso-style-name: "Check Cell";
	mso-style-id: 23;
}

.style0 {
	mso-number-format: General;
	text-align: general;
	vertical-align: bottom;
	white-space: nowrap;
	mso-rotate: 0;
	mso-background-source: auto;
	mso-pattern: auto;
	color: black;
	font-size: 11.0pt;
	font-weight: 400;
	font-style: normal;
	text-decoration: none;
	font-family: Calibri, sans-serif;
	mso-font-charset: 0;
	border: none;
	mso-protection: locked visible;
	mso-style-name: Normal;
	mso-style-id: 0;
}

td {
	mso-style-parent: style0;
	padding-top: 1px;
	padding-right: 1px;
	padding-left: 1px;
	mso-ignore: padding;
	color: black;
	font-size: 11.0pt;
	font-weight: 400;
	font-style: normal;
	text-decoration: none;
	font-family: Calibri, sans-serif;
	mso-font-charset: 0;
	mso-number-format: General;
	text-align: general;
	vertical-align: bottom;
	border: none;
	mso-background-source: auto;
	mso-pattern: auto;
	mso-protection: locked visible;
	white-space: nowrap;
	mso-rotate: 0;
}

.xl65 {
	mso-style-parent: style0;
	border: .5pt solid windowtext;
}

.xl66 {
	mso-style-parent: style0;
	text-align: center;
	vertical-align: middle;
	border: .5pt solid windowtext;
	white-space: normal;
}

.xl67 {
	mso-style-parent: style0;
	border: .5pt solid windowtext;
	white-space: normal;
}

.xl68 {
	mso-style-parent: style0;
	text-align: center;
	border-top: .5pt solid windowtext;
	border-right: none;
	border-bottom: none;
	border-left: none;
	white-space: normal;
}

.xl69 {
	mso-style-parent: style0;
	text-align: center;
	border-top: .5pt solid windowtext;
	border-right: none;
	border-bottom: none;
	border-left: .5pt solid windowtext;
	white-space: normal;
}

.xl70 {
	mso-style-parent: style0;
	text-align: center;
	border-top: .5pt solid windowtext;
	border-right: .5pt solid windowtext;
	border-bottom: none;
	border-left: none;
	white-space: normal;
}

.xl71 {
	mso-style-parent: style0;
	text-align: center;
	vertical-align: top;
	border-top: none;
	border-right: none;
	border-bottom: .5pt solid windowtext;
	border-left: .5pt solid windowtext;
	white-space: normal;
}

.xl72 {
	mso-style-parent: style0;
	text-align: center;
	vertical-align: top;
	border-top: none;
	border-right: none;
	border-bottom: .5pt solid windowtext;
	border-left: none;
	white-space: normal;
}

.xl73 {
	mso-style-parent: style0;
	text-align: center;
	vertical-align: top;
	border-top: none;
	border-right: .5pt solid windowtext;
	border-bottom: .5pt solid windowtext;
	border-left: none;
	white-space: normal;
}

.xl74 {
	mso-style-parent: style0;
	border-top: none;
	border-right: .5pt solid windowtext;
	border-bottom: .5pt solid windowtext;
	border-left: .5pt solid windowtext;
	white-space: normal;
}

.xl75 {
	mso-style-parent: style0;
	border-top: none;
	border-right: .5pt solid windowtext;
	border-bottom: .5pt solid windowtext;
	border-left: .5pt solid windowtext;
}

.xl76 {
	mso-style-parent: style33;
	color: white;
	font-weight: 700;
	text-align: center;
	vertical-align: middle;
	border: .5pt solid windowtext;
	background: #A5A5A5;
	mso-pattern: black none;
	white-space: normal;
}

.x0l65 {
	mso-style-parent: style0;
	border: .5pt solid windowtext;
	white-space: normal;
}

.x0l66 {
	mso-style-parent: style0;
	text-align: left;
	vertical-align: middle;
	border: .5pt solid windowtext;
}

.x0l67 {
	mso-style-parent: style0;
	border: .5pt solid windowtext;
}

.x0l68 {
	mso-style-parent: style0;
	text-align: center;
	border-top: .5pt solid windowtext;
	border-right: none;
	border-bottom: none;
	border-left: .5pt solid windowtext;
	white-space: normal;
}

.x0l69 {
	mso-style-parent: style0;
	text-align: center;
	border-top: .5pt solid windowtext;
	border-right: none;
	border-bottom: none;
	border-left: none;
	white-space: normal;
}

.x0l70 {
	mso-style-parent: style0;
	text-align: center;
	border-top: .5pt solid windowtext;
	border-right: .5pt solid windowtext;
	border-bottom: none;
	border-left: none;
	white-space: normal;
}

.x0l71 {
	mso-style-parent: style0;
	text-align: center;
	vertical-align: top;
	border-top: none;
	border-right: none;
	border-bottom: .5pt solid windowtext;
	border-left: .5pt solid windowtext;
	white-space: normal;
}

.x0l72 {
	mso-style-parent: style0;
	text-align: center;
	vertical-align: top;
	border-top: none;
	border-right: none;
	border-bottom: .5pt solid windowtext;
	border-left: none;
	white-space: normal;
}

.x0l73 {
	mso-style-parent: style0;
	text-align: center;
	vertical-align: top;
	border-top: none;
	border-right: .5pt solid windowtext;
	border-bottom: .5pt solid windowtext;
	border-left: none;
	white-space: normal;
}

.x0l74 {
	mso-style-parent: style33;
	color: white;
	font-weight: 700;
	text-align: center;
	vertical-align: middle;
	border: 2.0pt double #3F3F3F;
	background: #A5A5A5;
	mso-pattern: black none;
	white-space: normal;
}

.x0l75 {
	mso-style-parent: style33;
	color: white;
	font-weight: 700;
	text-align: center;
	border: 2.0pt double #3F3F3F;
	background: #A5A5A5;
	mso-pattern: black none;
	white-space: normal;
	mso-rotate: 90;
}

.x0l76 {
	mso-style-parent: style0;
	text-align: left;
	vertical-align: middle;
	white-space: normal;
}
</style>
<body>
	<div id="upper">
		<div class="scrollbar2" id="style-4">
			<div class="force-overflow2">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>User</th>
							<th>Subject</th>

							<th>Description</th>
							<th>Date</th>
						</tr>
					</thead>
					<!--  tbody ng-repeat="cbcr in cbcrs">
				<tr>
					<th scope="row">{{cbcr.id}}</th>
					<td>{{cbcr.name}}</td>
					<td>{{cbcr.description}}</td>
				</tr>
			</tbody>
		</table-->

					<tbody>
						<tr>
							<th scope="row">John</th>
							<td>cbcr1</td>
							<td>This is cbcr1This is cbcr1This is cbcr1This is cbcr1This
								is cbcr1This is cbcr1</td>
							<td>2015-12-12</td>
						</tr>

						<tr>
							<th scope="row">Adam</th>
							<td>cbcr2</td>
							<td>This is cbcr2</td>
							<td>2015-12-12</td>
						</tr>

						<tr>
							<th scope="row">Lucy</th>
							<td>cbcr3</td>
							<td>This is cbcr3</td>
							<td>2015-12-12</td>
						</tr>
						<tr>
							<th scope="row">Kate</th>
							<td>cbcr4</td>
							<td>This is cbcr4</td>
							<td>2015-12-12</td>
						</tr>
						<tr>
							<th scope="row">Liu</th>
							<td>cbcr1</td>
							<td>This is cbcr1This is cbcr1This is cbcr1This is cbcr1This
								is cbcr1This is cbcr1</td>
							<td>2015-12-12</td>
						</tr>
						<tr>
							<th scope="row">Taylor</th>
							<td>cbcr1</td>
							<td>This is cbcr1This is cbcr1This is cbcr1This is cbcr1This
								is cbcr1This is cbcr1</td>
							<td>2015-12-12</td>
						</tr>
						<tr>
							<th scope="row">Ben</th>
							<td>cbcr1</td>
							<td>This is cbcr1This is cbcr1This is cbcr1This is cbcr1This
								is cbcr1This is cbcr1</td>
							<td>2015-12-12</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div id="lowwer">
		<div class="scrollbar3" id="style-4">
			<div class="force-overflow3">

				<ul class="tab">
					<li><a href="#/write" class="tablinks"
						onclick="openCity(event, 'Message')">Message</a></li>
					<li><a href="#/write" class="tablinks"
						onclick="openCity(event, 'Docs')">Docs</a></li>
					<li><a href="#/write" class="tablinks"
						onclick="openCity(event, 'Entity')">Entity</a></li>
					<li><a href="#/write" class="tablinks"
						onclick="openCity(event, 'Table1')">Table1</a></li>
					<li><a href="#/write " class="tablinks"
						onclick="openCity(event, 'Table2')">Table2</a></li>
					<li><a href="#/write " class="tablinks"
						onclick="openCity(event, 'Table3')">Table3</a></li>

				</ul>

				<div id="Message" class="tabcontent">
					<div class="row">
						<div class="col-md-4">
							<p>From: abc@MX</p>
						</div>


						<div class="col-md-4">
							<p>Date: Jan 11,2018</p>
						</div>

						<div class="col-md-4">
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
											placeholder="">
									</div>
								</div>
								<div class="form-group row">
									<label for="Notes" class="col-sm-2 form-control-label">Notes:</label>
									<div class="col-sm-10">
										<textarea rows="4" cols="127"></textarea>
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
											<option>SP</option>
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
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Code</th>
								<th>Title</th>
								<th>Doc Type</th>
								<th>Reporting Entity</th>
								<th>Currency</th>
								<th>Resident Country</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>Excel</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>Excel</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>Excel</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>Excel</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>Excel</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr>
							<tr>
								<td>code123</td>
								<td>Doc1</td>
								<td>Excel</td>
								<td>Reporting1212</td>
								<td>US Dollar</td>
								<td>USA</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="Entity" class="tabcontent">
					<div class="row" id="docrow">
						<h3>Entities in CBCR Doc:</h3>
					</div>
					<div class="row">
						<div class="col-md-6">

							<table style="width: 100%">
								<tr>
									<td>Reporting Entity:</td>
									<td>Sample Corp</td>
								</tr>
								<tr>
									<td>Resident Country:</td>
									<td>MX</td>
								</tr>
							</table>
						</div>
						<div class="col-md-3">Currency:</div>
						<div class="col-md-3">MXP</div>
					</div>

					</br>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>TIN</th>
								<th>Name</th>
								<th>Doc Type</th>
								<th>Incorporation Country</th>
								<th>Resident Country</th>
								<th>Is PE?</th>
								<th>Address</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>TIN1</td>
								<td>Sample</td>
								<td>Excel</td>
								<td>USA</td>
								<td>USA</td>
								<td>YES</td>
								<td>342 South AVE</td>
							</tr>
							<tr>
								<td>TIN1</td>
								<td>Sample</td>
								<td>Excel</td>
								<td>USA</td>
								<td>USA</td>
								<td>YES</td>
								<td>342 South AVE</td>
							</tr>
							<tr>
								<td>TIN1</td>
								<td>Sample</td>
								<td>Excel</td>
								<td>USA</td>
								<td>USA</td>
								<td>YES</td>
								<td>342 South AVE</td>
							</tr>
							<tr>
								<td>TIN1</td>
								<td>Sample</td>
								<td>Excel</td>
								<td>USA</td>
								<td>USA</td>
								<td>YES</td>
								<td>342 South AVE</td>
							</tr>
							<tr>
								<td>TIN1</td>
								<td>Sample</td>
								<td>Excel</td>
								<td>USA</td>
								<td>USA</td>
								<td>YES</td>
								<td>342 South AVE</td>
							</tr>
							<tr>
								<td>TIN1</td>
								<td>Sample</td>
								<td>Excel</td>
								<td>USA</td>
								<td>USA</td>
								<td>YES</td>
								<td>342 South AVE</td>
							</tr>
							<tr>
								<td>TIN1</td>
								<td>Sample</td>
								<td>Excel</td>
								<td>USA</td>
								<td>USA</td>
								<td>YES</td>
								<td>342 South AVE</td>
							</tr>
							<tr>
								<td>TIN1</td>
								<td>Sample</td>
								<td>Excel</td>
								<td>USA</td>
								<td>USA</td>
								<td>YES</td>
								<td>342 South AVE</td>
							</tr>
						</tbody>
					</table>

				</div>
				<div id="Table1" class="tabcontent">
					<h5>Table 1. Overview of allocation of income, taxes and
						business activities by tax jurisdiction</h5>
					<table border="0" cellpadding="0" cellspacing="0" width="928"
						style="border-collapse: collapse; table-layout: fixed; width: 698pt">
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
									style="mso-spacerun: yes">&nbsp; </span>group:<span
									style="mso-spacerun: yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
							</tr>
							<tr height="30"
								style="mso-height-source: userset; height: 22.5pt">
								<td colspan="11" height="30" class="xl71" width="928"
									style="border-right: .5pt solid black; height: 22.5pt; width: 698pt">Fiscal
									Year Concerned:<span style="mso-spacerun: yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								</td>
							</tr>
							<tr height="34"
								style="mso-height-source: userset; height: 25.5pt">
								<td rowspan="2" height="121" class="xl76" width="106"
									style="height: 90.75pt; border-top: none; width: 80pt">Tax
									Jurisdiction</td>
								<td colspan="3" class="xl76" width="271"
									style="border-left: none; width: 203pt">Revenues</td>
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
									style="height: 65.25pt; border-top: none; border-left: none; width: 75pt">Unrelated
									Party</td>
								<td class="xl76" width="88"
									style="border-top: none; border-left: none; width: 66pt">Related
									Party</td>
								<td class="xl76" width="83"
									style="border-top: none; border-left: none; width: 62pt">Total</td>
							</tr>
							<tr height="30"
								style="mso-height-source: userset; height: 22.5pt">
								<td height="30" class="xl74" width="106"
									style="height: 22.5pt; width: 80pt">&nbsp;</td>
								<td class="xl74" width="100"
									style="border-left: none; width: 75pt">&nbsp;</td>
								<td class="xl74" width="88"
									style="border-left: none; width: 66pt">&nbsp;</td>
								<td class="xl74" width="83"
									style="border-left: none; width: 62pt">&nbsp;</td>
								<td class="xl74" width="82"
									style="border-left: none; width: 62pt">&nbsp;</td>
								<td class="xl74" width="86"
									style="border-left: none; width: 65pt">&nbsp;</td>
								<td class="xl74" width="74"
									style="border-left: none; width: 56pt">&nbsp;</td>
								<td class="xl74" width="64"
									style="border-left: none; width: 48pt">&nbsp;</td>
								<td class="xl74" width="84"
									style="border-left: none; width: 63pt">&nbsp;</td>
								<td class="xl74" width="86"
									style="border-left: none; width: 65pt">&nbsp;</td>
								<td class="xl75" style="border-left: none">&nbsp;</td>
							</tr>
							<tr height="31"
								style="mso-height-source: userset; height: 23.25pt">
								<td height="31" class="xl67" width="106"
									style="height: 23.25pt; border-top: none; width: 80pt">&nbsp;</td>
								<td class="xl67" width="100"
									style="border-top: none; border-left: none; width: 75pt">&nbsp;</td>
								<td class="xl67" width="88"
									style="border-top: none; border-left: none; width: 66pt">&nbsp;</td>
								<td class="xl67" width="83"
									style="border-top: none; border-left: none; width: 62pt">&nbsp;</td>
								<td class="xl67" width="82"
									style="border-top: none; border-left: none; width: 62pt">&nbsp;</td>
								<td class="xl67" width="86"
									style="border-top: none; border-left: none; width: 65pt">&nbsp;</td>
								<td class="xl67" width="74"
									style="border-top: none; border-left: none; width: 56pt">&nbsp;</td>
								<td class="xl67" width="64"
									style="border-top: none; border-left: none; width: 48pt">&nbsp;</td>
								<td class="xl67" width="84"
									style="border-top: none; border-left: none; width: 63pt">&nbsp;</td>
								<td class="xl67" width="86"
									style="border-top: none; border-left: none; width: 65pt">&nbsp;</td>
								<td class="xl65" style="border-top: none; border-left: none">&nbsp;</td>
							</tr>
							<tr height="32"
								style="mso-height-source: userset; height: 24.0pt">
								<td height="32" class="xl67" width="106"
									style="height: 24.0pt; border-top: none; width: 80pt">&nbsp;</td>
								<td class="xl67" width="100"
									style="border-top: none; border-left: none; width: 75pt">&nbsp;</td>
								<td class="xl67" width="88"
									style="border-top: none; border-left: none; width: 66pt">&nbsp;</td>
								<td class="xl67" width="83"
									style="border-top: none; border-left: none; width: 62pt">&nbsp;</td>
								<td class="xl67" width="82"
									style="border-top: none; border-left: none; width: 62pt">&nbsp;</td>
								<td class="xl67" width="86"
									style="border-top: none; border-left: none; width: 65pt">&nbsp;</td>
								<td class="xl67" width="74"
									style="border-top: none; border-left: none; width: 56pt">&nbsp;</td>
								<td class="xl67" width="64"
									style="border-top: none; border-left: none; width: 48pt">&nbsp;</td>
								<td class="xl67" width="84"
									style="border-top: none; border-left: none; width: 63pt">&nbsp;</td>
								<td class="xl67" width="86"
									style="border-top: none; border-left: none; width: 65pt">&nbsp;</td>
								<td class="xl65" style="border-top: none; border-left: none">&nbsp;</td>
							</tr>
							<tr height="32"
								style="mso-height-source: userset; height: 24.0pt">
								<td height="32" class="xl67" width="106"
									style="height: 24.0pt; border-top: none; width: 80pt">&nbsp;</td>
								<td class="xl67" width="100"
									style="border-top: none; border-left: none; width: 75pt">&nbsp;</td>
								<td class="xl67" width="88"
									style="border-top: none; border-left: none; width: 66pt">&nbsp;</td>
								<td class="xl67" width="83"
									style="border-top: none; border-left: none; width: 62pt">&nbsp;</td>
								<td class="xl67" width="82"
									style="border-top: none; border-left: none; width: 62pt">&nbsp;</td>
								<td class="xl67" width="86"
									style="border-top: none; border-left: none; width: 65pt">&nbsp;</td>
								<td class="xl67" width="74"
									style="border-top: none; border-left: none; width: 56pt">&nbsp;</td>
								<td class="xl67" width="64"
									style="border-top: none; border-left: none; width: 48pt">&nbsp;</td>
								<td class="xl67" width="84"
									style="border-top: none; border-left: none; width: 63pt">&nbsp;</td>
								<td class="xl67" width="86"
									style="border-top: none; border-left: none; width: 65pt">&nbsp;</td>
								<td class="xl65" style="border-top: none; border-left: none">&nbsp;</td>
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
					<h3>Table2</h3>
					<table border="0" cellpadding="0" cellspacing="0" width="1115"
						style="border-collapse: collapse; table-layout: fixed; width: 837pt">
						<colgroup>
							<col width="84"
								style="mso-width-source: userset; mso-width-alt: 3072; width: 63pt">
							<col width="81"
								style="mso-width-source: userset; mso-width-alt: 2962; width: 61pt">
							<col width="118"
								style="mso-width-source: userset; mso-width-alt: 4315; width: 89pt">
							<col width="64" span="13" style="width: 48pt">
						</colgroup>
						<tbody>
							<tr height="20" style="height: 15.0pt">
								<td colspan="16" height="20" class="x0l68" width="1115"
									style="border-right: .5pt solid black; height: 15.0pt; width: 837pt">Name
									of the MNE group:</td>
							</tr>
							<tr height="21" style="height: 15.75pt">
								<td colspan="16" height="21" class="x0l71" width="1115"
									style="border-right: .5pt solid black; height: 15.75pt; width: 837pt">Fiscal
									year concerned:</td>
							</tr>
							<tr height="22" style="height: 16.5pt">
								<td rowspan="2" height="159" class="x0l74" width="84"
									style="height: 119.25pt; width: 63pt">Tax Jurisdiction</td>
								<td rowspan="2" class="x0l74" width="81" style="width: 61pt">Constituent
									Entities resident in the Tax Jurisdiction</td>
								<td rowspan="2" class="x0l74" width="118" style="width: 89pt">Tax
									Jurisdiction of organisation of incorporation if different from
									Tax Jurisdiction of Resident</td>
								<td colspan="13" class="x0l74" width="832"
									style="border-left: none; width: 624pt">Main business
									activity(ies)</td>
							</tr>
							<tr height="137"
								style="mso-height-source: userset; height: 102.75pt">
								<td height="137" class="x0l75" width="64"
									style="height: 102.75pt; border-top: none; border-left: none; width: 48pt"><div id = "vertical">Research
									and Development</div></td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Holding
									or Managing intellectual Property</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Purchase
									or Procurement</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Manufacturing
									or Production</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Sales,
									Marketing or Distribution</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Administrative,
									Management or Support Services</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Provision
									of Services to unrelated parties</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Internal
									Group Finance</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Regulated
									Financial Services</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Insurance</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Holding
									shares or other equity instruments</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Dormant</td>
								<td class="x0l75" width="64"
									style="border-top: none; border-left: none; width: 48pt">Other2</td>
							</tr>
							<tr height="21" style="height: 15.75pt">
								<td rowspan="3" height="61" class="x0l65" width="84"
									style="height: 45.75pt; width: 63pt">&nbsp;</td>
								<td class="x0l66" style="border-left: none">1</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-left: none">&nbsp;</td>
							</tr>
							<tr height="20" style="height: 15.0pt">
								<td height="20" class="x0l66"
									style="height: 15.0pt; border-top: none; border-left: none">2</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
							</tr>
							<tr height="20" style="height: 15.0pt">
								<td height="20" class="x0l66"
									style="height: 15.0pt; border-top: none; border-left: none">3</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
							</tr>
							<tr height="20" style="height: 15.0pt">
								<td rowspan="3" height="60" class="x0l65" width="84"
									style="height: 45.0pt; border-top: none; width: 63pt">&nbsp;</td>
								<td class="x0l66" style="border-top: none; border-left: none">1</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
							</tr>
							<tr height="20" style="height: 15.0pt">
								<td height="20" class="x0l66"
									style="height: 15.0pt; border-top: none; border-left: none">2</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
							</tr>
							<tr height="20" style="height: 15.0pt">
								<td height="20" class="x0l66"
									style="height: 15.0pt; border-top: none; border-left: none">3</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
								<td class="x0l67" style="border-top: none; border-left: none">&nbsp;</td>
							</tr>
							<tr height="20" style="height: 15.0pt">
								<td height="20" colspan="16"
									style="height: 15.0pt; mso-ignore: colspan"></td>
							</tr>

							<!--[if supportMisalignedColumns]-->
							<tr height="0" style="display: none">
								<td width="84" style="width: 63pt"></td>
								<td width="81" style="width: 61pt"></td>
								<td width="118" style="width: 89pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
								<td width="64" style="width: 48pt"></td>
							</tr>
							<!--[endif]-->
						</tbody>
					</table>
				</div>
				<div id="Table3" class="tabcontent">
					<h3>Table3</h3>

				</div>
			</div>
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
	</script>
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker6').datetimepicker();
			$('#datetimepicker7').datetimepicker({
				useCurrent : false
			//Important! See issue #1075
			});
			$("#datetimepicker6").on("dp.change", function(e) {
				$('#datetimepicker7').data("DateTimePicker").minDate(e.date);
			});
			$("#datetimepicker7").on("dp.change", function(e) {
				$('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
			});
		});
	</script>
</body>
</html>