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

//data from call back


$("p").click(function(){
	$.ajax({

        url : "http://localhost:8080/TIEapp/login",
        dataType : 'json',
        error : function() {

            alert("Error Occured");
        },
        success : function(data) {
          alert(data.subject)

        }
    });
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
			//table2data = data.tieDocList[0].cbcrTable2List;
			msgData = data;
			updateTab(data);
			updateMsgPane(data);
			createDocs(data); //show the list of docs of the msg
			
			//determine the currentDoc, as the first in the doc list
			setCurrentDoc(0);
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

var updateTab = function(data) {
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

 setCurrentDoc = function(docId) {
	this.docId = docId;
	if (EntityArray.length > 0) {
		EntityArray = []
	}
	
	//generate TaxEntity
	var currentDocData = msgData.tieDocList[docId];
	console.log("setCurrentDoc Start, currentDocData : " + JSON.stringify(currentDocData));
	console.log("setCurrentDoc End"	);
	for (var i = 0; i < currentDocData.taxEntityList.length; i++) {
		var EntityObj = {
			"TIN" : currentDocData.taxEntityList[i].taxIdNum,
			"Name" : currentDocData.taxEntityList[i].name,
			"EntityCode" : currentDocData.taxEntityList[i].entityCode,
			"DocType" : "CBCR",
			"IncorporationCountry" : currentDocData.taxEntityList[i].reportingEntityCode,
			"ResidentCountry" : currentDocData.taxEntityList[i].incorpCountryCode,
			"IsPE" : currentDocData.taxEntityList[i].isPermExtabliment,
			"Address" : currentDocData.taxEntityList[i].addrStreet
		};
		var Table1Obj = {
				"TaxJurisdiction" : currentDocData.cbcrTable1List[i].taxJurisdiction,
				"UnrelatedParty" : currentDocData.cbcrTable1List[i].revenueUnrelatedParty,
				"RelatedParty" : currentDocData.cbcrTable1List[i].revenueRelatedParty,
				"Total" : currentDocData.cbcrTable1List[i].revenueTotal,
				"ProfitBeforeIncomeTax" : currentDocData.cbcrTable1List[i].plBeforeIncomeTax,
				"IncomeTaxPaid " : currentDocData.cbcrTable1List[i].incomeTaxPaid,
				"IncomeTaxAccrued" : currentDocData.cbcrTable1List[i].incomeTaxAccrued,
				"StatedCaptial" : currentDocData.cbcrTable1List[i].statedCapital,
				"AccumulatedEarnings" : currentDocData.cbcrTable1List[i].accumulatedEarnings,
				"NumberofEmployees" : currentDocData.cbcrTable1List[i].numberOfEmployees,
				"TangibleAssetsotherthanCashandCashEquivalents" : currentDocData.cbcrTable1List[i].tangibleAssetsNonCash
				
			};
		EntityArray.push(EntityObj);
		Table1Array.push(Table1Obj);
		console.log("EntityObj Numbher is : " + EntityObj.TIN	);
	}
}	

