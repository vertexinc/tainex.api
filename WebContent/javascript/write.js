/**
 * 
 */
function openTag(evt, cityName) {
	var i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
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
	openTag(event, "Message");
});


$("tr").click(function() {
	$(this).parent().children().removeClass("selected");
	$(this).addClass("selected");
});

$("#msgText").click(function() {

	alert("hi");
});

$(".member tr").click(function() {
	var rowID = $(this).find(".msgID").text();
	//alert("rowID:" + rowID);
	var temp = "action=selectCurrentMsg" + "&msgid=" + rowID;
	$.ajax({
		type : "POST",
		//contentType:"application/json",
		//dataType:'json',
		url : "http://localhost:8080/TIEapp/login",
		data : temp,
		success : function(data) {
			// alert('success'),
			// $("#msgText").text(data);
			alert(data.tieMsgId);
		},
		error : function(err) {
			alert(err.responseText)
		}
	});
});