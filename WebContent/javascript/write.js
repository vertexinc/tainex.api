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
		$('#currentMsgTab').trigger('click');
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

$(".member tr").click(function() {
	var rowID = $(this).find(".msgID").text();
	// alert("rowID:" + rowID);
	var temp = "action=selectCurrentMsg" + "&msgid=" + rowID;
	$.ajax({
		type : "POST",
		// contentType:"application/json",
		// dataType:'json',
		url : "http://localhost:8080/TIEapp/login",
		data : temp,
		success : function(data) {
			// alert('success'),
			// $("#msgText").text(data);
			// alert(data.sender.name);
			table2data = data.tieDocList[0].cbcrTable2List;
			UpdateTab(data);
			UpdateMsgPane(data);
			CreateDocs(data)
		},
		error : function(err) {
			alert(err.responseText)
		}
	});
});

var UpdateTab = function(data) {
	$("#currentDocTab").attr("title", data.subject);
	$("#currentEntityTab")
			.attr("title", data.tieDocList[0].reportingEntityCode);
	$("#currentTable1Tab")
			.attr("title", data.tieDocList[0].reportingEntityCode);
	$("#currentTable2Tab")
			.attr("title", data.tieDocList[0].reportingEntityCode);
	$("#currentTable3Tab")
			.attr("title", data.tieDocList[0].reportingEntityCode);
}

var UpdateMsgPane = function(data) {
	$("#from").text(data.sender.name);
	$("#date").text(data.timestamp);	
	$("#reportingPeriod").text(data.reportingPeriod);
	$("#tieMsgState").text(data.tieMsgState.code);
	$("#To").attr("placeholder", data.msgReceiverList);
	$("#Subject").attr("placeholder", data.subject);
	$("#notes").text(data.notes);
	$("#Warning").attr("placeholder", data.warning);
	$("#Contact").attr("placeholder", data.contact);
	$("#MessageRefId").text(data.messageRefId);
	$("#TransmittingCountry").text(data.transmittingCountry);
	$("#getReportingPeriod").text(data.reportingPeriod);
	$("#ReceivingCountry").text(data.receivingCountries);
}

var DocArray = [];
// loop through doclist to select out table columns
var CreateDocs = function(data) {
	if (DocArray.length > 0) {
		DocArray = []
	}
	for (var i = 0; i < data.tieDocList.length; i++) {
		var DocObj = {
			"Code" : data.tieDocList[i].code,
			"title" : data.tieDocList[i].name
		};
		DocArray.push(DocObj);
		console.log("current Array: " + DocArray);
		console.log("current Array Obj: " + DocObj.Code + " " + DocObj.title);
		TestCode = DocObj.Code;
	}

}

var fakedata = [ {
	"firstName" : "ax",
	"lastName" : "Carney",
	"company" : "Enormo",
	"employed" : true
}, {
	"firstName" : "Lorraine",
	"lastName" : "Wise",
	"company" : "Comveyer",
	"employed" : false
}, {
	"firstName" : "Nancy",
	"lastName" : "Waters",
	"company" : "Fuelton",
	"employed" : false
} ];