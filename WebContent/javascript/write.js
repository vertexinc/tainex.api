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

			setCurrentDoc(data);
			updateEntityandOtherTab(data);
		},
		error : function(err) {
			alert(err.responseText);

		}
	});
}

// data from call back

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
			// table2data = data.tieDocList[0].cbcrTable2List;
			// alert("data.tieDocList[0]" + data.tieDocList[0])

			setCurrentDoc(data.tieDocList[0]);

			updateTab(data);
			updateMsgPane(data);
			createDocs(data); // show the list of docs of the msg

			// determine the currentDoc, as the first in the doc list

			// highlight the current doc row in the doc list table

			// TODO
			// populate entity table of currentDoc, under entity tab
			// populate table1/2/3 of currentDoc

		},
		error : function(err) {
			alert(err.responseText)
		}
	});
});

var updateTab = function(data) {
	$("#currentDocTab").attr("title", data.subject);
	$("#docTagSub").text("(" + data.subject + ")");

	$("#currentEntityTab")
			.attr("title", data.tieDocList[0].reportingEntityCode);
	$("#entityTagSub").text(
			"(" + top8letter(data.tieDocList[0].reportingEntityCode) + ")");

	$("#currentTable1Tab")
			.attr("title", data.tieDocList[0].reportingEntityCode);
	$("#t1TagSub").text(
			"(" + top8letter(data.tieDocList[0].reportingEntityCode) + ")");

	$("#currentTable2Tab")
			.attr("title", data.tieDocList[0].reportingEntityCode);
	$("#t2TagSub").text(
			"(" + top8letter(data.tieDocList[0].reportingEntityCode) + ")");

	$("#currentTable3Tab")
			.attr("title", data.tieDocList[0].reportingEntityCode);
	$("#t3TagSub").text(
			"(" + top8letter(data.tieDocList[0].reportingEntityCode) + ")");
}

var updateEntityandOtherTab = function(data) {
	$("#currentEntityTab").attr("title", data.reportingEntityCode);
	$("#entityTagSub").text("(" + top8letter(data.reportingEntityCode) + ")");

	$("#currentTable1Tab").attr("title", data.reportingEntityCode);
	$("#t1TagSub").text("(" + top8letter(data.reportingEntityCode) + ")");

	$("#currentTable2Tab").attr("title", data.reportingEntityCode);
	$("#t2TagSub").text("(" + top8letter(data.reportingEntityCode) + ")");

	$("#currentTable3Tab").attr("title", data.reportingEntityCode);
	$("#t3TagSub").text("(" + top8letter(data.reportingEntityCode) + ")");
}

var top8letter = function(input) {
	this.input = input;
	if (input.length > 8) {
		input = input.substring(0, 8);
		input = input + '...';
	}
	return input;
}

var updateMsgPane = function(data) {
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

var createDocs = function(data) {

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
			"reportingPeriod" : data.tieDocList[i].reportingPeriod,
			// pass in default highlight
			// first one set to true
			"highLight" : i === 0
		};
		DocArray.push(DocObj);
	}
}

// validate yes or no
var checkYes = function(num) {
	this.num = num;
	if (num == 1) {
		return 'YES';
	} else {
		return ' '
	}
}
/*
 * Entity Table1 Table2 Table3
 */
var EntityArray = [];
var Table1Array = [];
var Table2Array = [];
var Table3Array = [];

var currentDocHeader = {};

var currentEntityCode;

// this data is passing in doc data from parent data
setCurrentDoc = function(docData) {
	// this.docId = docId;

	// set the doc table header value
	currentDocHeader.reportingEntityCode = docData.reportingEntityCode;
	currentDocHeader.reportingEntityName = docData.reportingEntity.name;
	currentDocHeader.currencyCode = docData.currencyCode;
	currentDocHeader.resCountryCode = docData.resCountryCode;

	console.log('data.reportingEntityCode -- >' + currentDocHeader);

	if (EntityArray.length > 0) {
		EntityArray = []
	}

	// generate TaxEntity
	// var currentDocData = msgData.tieDocList[docId];
	console.log("setCurrentDoc Start, currentDocData : "
			+ JSON.stringify(docData));
	console.log("setCurrentDoc End");
	for (var i = 0; i < docData.taxEntityList.length; i++) {
		var EntityObj = {
			"TIN" : docData.taxEntityList[i].taxIdNum,
			"Name" : docData.taxEntityList[i].name,
			"EntityCode" : docData.taxEntityList[i].entityCode,
			"DocType" : "CBCR",
			"IncorporationCountry" : docData.taxEntityList[i].reportingEntityCode,
			"ResidentCountry" : docData.taxEntityList[i].incorpCountryCode,
			"IsPE" : checkYes(docData.taxEntityList[i].isPermExtabliment),
			"Address" : docData.taxEntityList[i].addrStreet,
			"MainEntity" : docData.reportingEntityCode
		};

		EntityArray.push(EntityObj);

		console.log("EntityObj Numbher is : " + EntityObj.TIN);
	}

	for (var i = 0; i < docData.cbcrTable1List.length; i++) {
		var Table1Obj = {
			"TaxJurisdiction" : docData.cbcrTable1List[i].taxJurisdiction,
			"UnrelatedParty" : docData.cbcrTable1List[i].revenueUnrelatedParty,
			"RelatedParty" : docData.cbcrTable1List[i].revenueRelatedParty,
			"Total" : docData.cbcrTable1List[i].revenueTotal,
			"ProfitBeforeIncomeTax" : docData.cbcrTable1List[i].plBeforeIncomeTax,
			"IncomeTaxPaid " : docData.cbcrTable1List[i].incomeTaxPaid,
			"IncomeTaxAccrued" : docData.cbcrTable1List[i].incomeTaxAccrued,
			"StatedCaptial" : docData.cbcrTable1List[i].statedCapital,
			"AccumulatedEarnings" : docData.cbcrTable1List[i].accumulatedEarnings,
			"NumberofEmployees" : docData.cbcrTable1List[i].numberOfEmployees,
			"TangibleAssetsotherthanCashandCashEquivalents" : docData.cbcrTable1List[i].tangibleAssetsNonCash

		};
		Table1Array.push(Table1Obj);
	}

	for (var i = 0; i < docData.cbcrTable2List.length; i++) {
		var Table2Obj = {
			"taxJurisdiction" : docData.cbcrTable2List[i].taxJurisdiction,
			"entityCode" : docData.cbcrTable2List[i].entityCode,
			"taxJurisOfIncorporation" : docData.cbcrTable2List[i].taxJurisOfIncorporation,
			"mainBusRAndD" : checkYes(docData.cbcrTable2List[i].mainBusRAndD),
			"mainBusHoldingIp" : checkYes(docData.cbcrTable2List[i].mainBusHoldingIp),
			"mainBusPurchasing " : checkYes(docData.cbcrTable2List[i].mainBusPurchasing),
			"mainBusMfctOrPrdn" : checkYes(docData.cbcrTable2List[i].mainBusMfctOrPrdn),
			"mainBusSaleMktDistr" : checkYes(docData.cbcrTable2List[i].mainBusSaleMktDistr),
			"mainBusAdminMgmtSupportSvc" : checkYes(docData.cbcrTable2List[i].mainBusAdminMgmtSupportSvc),
			"mainBusProvSvcToUnrelatedParti" : checkYes(docData.cbcrTable2List[i].mainBusProvSvcToUnrelatedParti),
			"mainBusInternalGroupFinance" : checkYes(docData.cbcrTable2List[i].mainBusInternalGroupFinance),
			"mainBusRegulatedFinSvc" : checkYes(docData.cbcrTable2List[i].mainBusRegulatedFinSvc),
			"mainBusInsurance" : checkYes(docData.cbcrTable2List[i].mainBusInsurance),
			"mainBusHoldingEquityInstrument" : checkYes(docData.cbcrTable2List[i].mainBusHoldingEquityInstrument),
			"mainBusDormant" : checkYes(docData.cbcrTable2List[i].mainBusDormant),
			"mainBusOther" : checkYes(docData.cbcrTable2List[i].mainBusOther)

		};
		Table2Array.push(Table2Obj);
	}

	for (var i = 0; i < docData.cbcrTable3List.length; i++) {
		var Table3Obj = {
			"additionalInfo" : docData.cbcrTable3List[i].additionalInfo
		};
		Table3Array.push(Table3Obj);
	}

}
// resize upper and lower
$(".panel-left").resizable({
	handleSelector : ".splitter",
	resizeHeight : false
});

$(".panel-top").resizable({
	handleSelector : ".splitter-horizontal",
	resizeWidth : false
});
