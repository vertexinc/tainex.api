

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

#docrow{
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
					<div class="row" id="docrow"><h3>Entities in CBCR Doc:</h3></div>
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
						<h3>Table1</h3>
						<p>Table1 Info</p>
					</div>
					<div id="Table2" class="tabcontent">
						<h3>Table2</h3>
						<p>Table2 Info.</p>
					</div>
					<div id="Table3" class="tabcontent">
						<h3>Table3</h3>
						<p>Table3 Info.</p>
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
				$("#datetimepicker6").on(
						"dp.change",
						function(e) {
							$('#datetimepicker7').data("DateTimePicker")
									.minDate(e.date);
						});
				$("#datetimepicker7").on(
						"dp.change",
						function(e) {
							$('#datetimepicker6').data("DateTimePicker")
									.maxDate(e.date);
						});
			});
		</script>
</body>
</html>