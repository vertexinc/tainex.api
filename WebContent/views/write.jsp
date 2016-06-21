

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
	background-color: #ddd;
}
/* Create an active/current tablink class */
ul.tab li a:focus, .active {
	background-color: #00cc99;
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
</style>
<body>
	<div class="upper">
		<table class="table table-striped">
			<thead>
				<tr>
					<th><button class="btn btn-primary" type="submit">New</button></th>
					<th>Cbcr</th>

					<th>Description</th>
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
					<th scope="row">1</th>
					<td>cbcr1</td>
					<td>This is cbcr1</td>
				</tr>

				<tr>
					<th scope="row">2</th>
					<td>cbcr2</td>
					<td>This is cbcr2</td>
				</tr>

				<tr>
					<th scope="row">3</th>
					<td>cbcr3</td>
					<td>This is cbcr3</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>cbcr4</td>
					<td>This is cbcr4</td>
				</tr>
			</tbody>
		</table>
		</br> </br>
	</div>
	<div id="lowwer">
		<ul class="tab">
			<li><a href="#/write" class="tablinks"
				onclick="openCity(event, 'Message')">Message</a></li>
			<li><a href="#/write" class="tablinks"
				onclick="openCity(event, 'Docs')">Docs</a></li>
			<li><a href="#/write" " class="tablinks"
				onclick="openCity(event, 'Entity')">Entity</a></li>
			<li><a href="#/write" " class="tablinks"
				onclick="openCity(event, 'Table1')">Table1</a></li>
			<li><a href="#/write" " class="tablinks"
				onclick="openCity(event, 'Table2')">Table2</a></li>
			<li><a href="#/write" " class="tablinks"
				onclick="openCity(event, 'Table3')">Table3</a></li>

		</ul>

		<div id="Message" class="tabcontent">
			<div class="row">
				<div class="col-md-4">
					<h3>Generate Message</h3>

					<form method="POST" action='write' name="frmAddMsg">
						<fieldset class="form-group">


							<textarea class="form-control" id="exampleTextarea" rows="1"
								cols="40"> Description</textarea>

						</fieldset>
						<fieldset class="form-group">


							<textarea class="form-control" id="exampleTextarea" rows="3"
								cols="40">Notes</textarea>

						</fieldset>
						<fieldset class="form-group">
							<label for="exampleInputFile">Attach Tax Doc</label> <input
								type="file" class="form-control-file" id="exampleInputFile">
							<small class="text-muted">Attach cbcr file here!</small>
						</fieldset>

						<a href="#/success" class="btn btn-primary">Send <span
							class="glyphicon glyphicon-user"></span></a>
					</form>
				</div>

				<div class="col-md-4">

					<p>Transmitting Country</p>
					<select ng-model="item.meal" name="">
						<option value="us">US</option>
						<option value="cn">CN</option>
						<option value="sp">SP</option>
					</select>
					<!--  button ng-click="menu.chooseItem(item.meal,item.name)">Select
						Item</button-->
					</br> </br>
					<form role="form">
						<p>Reveiving Countries</p>
						<div class="checkbox">
							<label><input type="checkbox" value="">US</label>
						</div>
						<div class="checkbox">
							<label><input type="checkbox" value="">CN</label>
						</div>
						<div class="checkbox">
							<label><input type="checkbox" value="">SP</label>
						</div>

					</form>
					</br>
					<div id="sendid">
						<p>Sending Entity ID No.</p>
						<textarea class="form-control" id="exampleTextarea" rows="1"
							cols="5"> </textarea>

					</div>
				</div>
				<div class="col-md-4">
					<p>Warning</p>
					<textarea class="form-control" id="exampleTextarea" rows="2"
						cols="10"> </textarea>
					</br>
					<p>Reporting Period</p>
					<div class="timecontainer">
						<div class='col-md-5'>
							<div class="form-group">
								<div class='input-group date' id='datetimepicker6'>
									<input type='text' class="form-control" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>
						<div class='col-md-5'>
							<div class="form-group">
								<div class='input-group date' id='datetimepicker7'>
									<input type='text' class="form-control" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>

		</div>
		<div id="Docs" class="tabcontent">
			<h3>Docs</h3>
			<p>Details of the doc.</p>
		</div>
		<div id="Entity" class="tabcontent">
			<h3>Entity</h3>
			<p>Entity Information</p>
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
    $(function () {
        $('#datetimepicker6').datetimepicker();
        $('#datetimepicker7').datetimepicker({
            useCurrent: false //Important! See issue #1075
        });
        $("#datetimepicker6").on("dp.change", function (e) {
            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker7").on("dp.change", function (e) {
            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
        });
    });
</script>
</body>
</html>