<style>
body {
	font-family: "Lato", sans-serif;
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
</style>
<body>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>Cbcr</th>

					<th>Description</th>
				</tr>
			</thead>
			<tbody ng-repeat="cbcr in cbcrs">
				<tr>
					<th scope="row">{{cbcr.id}}</th>
					<td>{{cbcr.name}}</td>
					<td>{{cbcr.description}}</td>
				</tr>
			</tbody>
		</table>
		</br> </br>
		

		<ul class="tab">
			<li><a href="#/read" class="tablinks"
				onclick="openCity(event, 'General')">General</a></li>
			<li><a href="#/read" " class="tablinks"
				onclick="openCity(event, 'Entity')">Entity</a></li>
			<li><a href="#/read" " class="tablinks"
				onclick="openCity(event, 'Table1')">Table1</a></li>
			<li><a href="#/read" " class="tablinks"
				onclick="openCity(event, 'Table2')">Table2</a></li>
			<li><a href="#/read" " class="tablinks"
				onclick="openCity(event, 'Table3')">Table3</a></li>

		</ul>

		<div id="General" class="tabcontent">
			<h3>General Informatinal</h3>
			<p>London is the capital city of England.</p>
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

</body>
</html>
