package com.tie.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieTaxEntity;

public class TaxDocParser {
	TieDoc attachedDoc = new TieDoc();

	// the main function of the parser. The input objects are not changed.
	// The caller may then choose to add doc to the msg object outside the
	// parser
	public TieDoc parse(String docText, TieMsg tieMsg) {
		List<String> headerData = new ArrayList<String>();
		List<String> entityData = new ArrayList<String>();
		List<String> table1Data = new ArrayList<String>();
		List<String> table2Data = new ArrayList<String>();
		List<String> table3Data = new ArrayList<String>();
		String currentTarget = "";

		Scanner scanner = new Scanner(docText);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println("-> " + line);
			// remove leading space
			String trimedLine = line.replaceAll("^\\s+", "");

			// extract CBCR_Header
			if (trimedLine.substring(0, 11).equals("CBCR_Header")) {
				System.out.println("====CBCR_Header Detected====");
				headerData.add(trimedLine);
				currentTarget = "CBCR_Header";
			}

			// extract CBCR_Entity
			if (trimedLine.substring(0, 11).equals("CBCR_Entity")) {
				System.out.println("====CBCR_Entity Detected====");
				entityData.add(trimedLine);
				currentTarget = "CBCR_Entity";
			}
			// extract CBCR_Table1
			if (trimedLine.substring(0, 11).equals("CBCR_Table1")) {
				System.out.println("====CBCR_Table1 Detected====");
				table1Data.add(trimedLine);
				currentTarget = "CBCR_Table1";
			}
			// extract CBCR_Table2
			if (trimedLine.substring(0, 11).equals("CBCR_Table2")) {
				System.out.println("====CBCR_Table2 Detected====");
				table2Data.add(trimedLine);
				currentTarget = "CBCR_Table2";
			}
			// extract CBCR_Table3
			if (trimedLine.substring(0, 11).equals("CBCR_Table3")) {
				System.out.println("====CBCR_Table3 Detected====");
				table3Data.add(trimedLine);
				currentTarget = "CBCR_Table3";
			}
			// extract targetData
			if (trimedLine.charAt(0) == ',' && trimedLine.charAt(1) != ',') {
				System.out.println("====data Detected====");
				if (currentTarget == "CBCR_Header") {
					headerData.add(trimedLine);
				}
				if (currentTarget == "CBCR_Entity") {
					entityData.add(trimedLine);
				}
				if (currentTarget == "CBCR_Table1") {
					table1Data.add(trimedLine);
				}
				if (currentTarget == "CBCR_Table2") {
					table2Data.add(trimedLine);
				}
				if (currentTarget == "CBCR_Table3") {
					table3Data.add(trimedLine);
				}
			}

		}
		scanner.close();
		// assign extracted data to each target
		handleCBCRHeaderData(headerData, attachedDoc);
		handleCBCREntityData(entityData, attachedDoc);
		handleCBCRTable1Data(table1Data, attachedDoc);
		handleCBCRTable2Data(table2Data, attachedDoc);
		handleCBCRTable3Data(table3Data, attachedDoc);

		System.out.println(attachedDoc.toString());
		return attachedDoc;
	}// end method parse()

	private void handleCBCRHeaderData(List<String> inputData, TieDoc attachedDoc) {
		if (inputData.get(1) != null) {
			String[] headerDataList = inputData.get(1).split(",");
			attachedDoc.setName(headerDataList[1]);
			attachedDoc.setCode(headerDataList[2]);
			attachedDoc.setDescription(headerDataList[3]);
			attachedDoc.setReportingEntityCode(headerDataList[4]);
			attachedDoc.setCurrencyCode(headerDataList[5]);
			attachedDoc.setResCountryCode(headerDataList[6]);
		}

	}// end method handleExtractedData(..)

	private void handleCBCREntityData(List<String> inputData, TieDoc attachedDoc) {
		List<TieTaxEntity> tieTaxEntityList = new ArrayList<TieTaxEntity>();
		int dataSize = inputData.size();
		for (int i = 1; i < dataSize; i++) {
			TieTaxEntity tieTaxEntity = new TieTaxEntity();
			String[] tieTaxEntityRecordDataList = inputData.get(i).split(",");
			tieTaxEntity.setName(tieTaxEntityRecordDataList[1]);
			tieTaxEntity.setEntityCode(tieTaxEntityRecordDataList[2]);
			tieTaxEntity.setDescription(tieTaxEntityRecordDataList[3]);
			tieTaxEntity.setTaxIdNum(tieTaxEntityRecordDataList[4]);
			tieTaxEntity.setIncorpCountryCode(tieTaxEntityRecordDataList[5]);
			tieTaxEntity.setOtherEntityInfo(tieTaxEntityRecordDataList[6]);
			tieTaxEntity.setResCountryCode(tieTaxEntityRecordDataList[7]);
			tieTaxEntity.setIdNum(tieTaxEntityRecordDataList[8]);
			tieTaxEntity.setIsPermExtabliment(Integer.parseInt(tieTaxEntityRecordDataList[9]));
			tieTaxEntity.setAddrLegalType(tieTaxEntityRecordDataList[10]);
			tieTaxEntity.setAddrCountryCode(tieTaxEntityRecordDataList[11]);
			tieTaxEntity.setAddrFreeText(tieTaxEntityRecordDataList[12]);
			tieTaxEntity.setAddrStreet(tieTaxEntityRecordDataList[13]);
			tieTaxEntity.setAddrBuildingIdentifier(tieTaxEntityRecordDataList[14]);
			tieTaxEntity.setAddrSuiteIdentifier(tieTaxEntityRecordDataList[15]);
			tieTaxEntity.setAddrFloorIdentifier(tieTaxEntityRecordDataList[16]);
			tieTaxEntity.setAddrPOB(tieTaxEntityRecordDataList[17]);
			//addrPostCode
			//addrCity
			//addrCountrySubentity
			tieTaxEntityList.add(tieTaxEntity);
		}
		
		attachedDoc.setTaxEntityList(tieTaxEntityList);
	}// end method handleCBCREntityData(..)

	private void handleCBCRTable1Data(List<String> inputData, TieDoc attachedDoc) {

	}// end method handleCBCRTable1Data(..)

	private void handleCBCRTable2Data(List<String> inputData, TieDoc attachedDoc) {

	}// end method handleCBCRTable2Data(..)

	private void handleCBCRTable3Data(List<String> inputData, TieDoc attachedDoc) {

	}// end method handleCBCRTable3Data(..)
}// end class TaxMsgParser
