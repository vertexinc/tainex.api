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

var postDoc = function(tieDocId) {
	var temp = "action=selectCurrentDoc" + "&tieDocId=" + tieDocId;
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/TIEapp/login",
		data : temp,
		success : function(data) {
			// alert('success'),
			// $("#msgText").text(data);
			//alert(data.taxEntityList[0].name);
			CreateOtherTables(data);
		},
		error : function(err) {
			alert(err.responseText);
			
		}
	});
}

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
			CreateDocs(data) //show the list of docs of the msg
			
			//determine the currentDoc, as the first in the doc list
			//highlight the current doc row in the doc list table
			
			//TODO
			//populate entity table of currentDoc, under entity tab
			//populate table1/2/3 of currentDoc
			
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
// data: Message Object
var CreateDocs = function(data) {
	if (DocArray.length > 0) {
		DocArray = []
	}
	for (var i = 0; i < data.tieDocList.length; i++) {
		var DocObj = {
			"id" : data.tieDocList[i].tieDocId,
			"code" : data.tieDocList[i].code,
			"title" : data.tieDocList[i].name,
			"docType" : data.tieDocList[i].tieDocTypeId,
			"reportingEntity" : data.tieDocList[i].reportingEntityCode,
			"currency" : data.tieDocList[i].currencyCode,
			"residentCountry" : data.tieDocList[i].resCountryCode,
			"accountingStandard" : data.tieDocList[i].accountingStandard,
			"reportingPeriod" : data.tieDocList[i].reportingPeriod
		};
		DocArray.push(DocObj);
	}
}
/*
 * Entity Table1 Table2 Table3
 */
var EntityArray = [];
var Table1Array = [];
var Table2Array = [];
var Table3Array = [];

var CreateOtherTables = function(data) {
	if (DocArray.length > 0) {
		DocArray = []
	}
	console.log("data.taxEntityList[i].taxIdNum : Start" );
	for (var i = 0; i < data.taxEntityList.length; i++) {
		var EntityObj = {
			"TIN" : data.taxEntityList[i].taxIdNum,
			"Name" : data.taxEntityList[i].name,
			"EntityCode" : data.taxEntityList[i].entityCode,
			"DocType" : "CBCR",
			"IncorporationCountry" : data.taxEntityList[i].reportingEntityCode,
			"ResidentCountry" : data.taxEntityList[i].incorpCountryCode,
			"IsPE" : data.taxEntityList[i].isPermExtabliment,
			"Address" : data.taxEntityList[i].addrStreet
		};
		EntityArray.push(EntityObj);
		console.log("data.taxEntityList[i].taxIdNum : " + data.taxEntityList[i].taxIdNum);
	}
}	
