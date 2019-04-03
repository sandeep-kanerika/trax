package com.trax.ratemanager.rateset;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.ratecolumn.RateColumn;
import com.trax.ratemanager.raterow.RateRow;
import com.trax.ratemanager.ratetable.RateTable;

@Service
public class RateSetsService/* extends AbstractJpaService<RateSet> */ {

	@Autowired
	private RateSetRepository rateSetsRepository;

	public RateSet findRateSetByCondition(String orgId, String status, String name, String pageToken, String sortBy,
			String limit) {
		System.out.println("trying to store rateSets:::");
		// return
		// rateSetsRepository.customRateFinder(status,name,pageToken,sortBy,limit);
		return null;
	}

	public RateSet create(RateSet rateSet) {
		System.out.println("trying to store rateSets:::");
		return rateSetsRepository.save(rateSet);
	}

	public RateSet update(RateSet _rateSets) {
		Optional<RateSet> rateSet = rateSetsRepository.findById(_rateSets.getId());
		if (rateSet.isPresent())
			return rateSetsRepository.save(rateSet.get());
		else {
			throw new ResourceNotFoundException("RateSets Id Doesn't Exists !");
		}
	}

	public RateSet delete(RateSet rateSets) {
		rateSetsRepository.delete(rateSets);
		return rateSets;
	}

	public List<RateSet> search(RateSet rateSets) {
		return rateSetsRepository.findAll();
	}

	public RateSet getById(String id) {
		return rateSetsRepository.getById(id);
	}

	public RateSet getByIdAndTableId(String id, String tableId) {
		return rateSetsRepository.getByIdAndTableId(id, tableId);
	}

	public List<RateSet> findAll() {
		return rateSetsRepository.findAll();
	}

	public ByteArrayInputStream getRateSetInExcelFormat(String rateSetId) throws Exception {

		System.out.println("RateSetsService.getRateSetInExcelFormat()................");
		RateSet rateSet = rateSetsRepository.getById(rateSetId);
		if (rateSet == null) {
			throw new ResourceNotFoundException("RateSet not found ...");
		}
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		// Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Sheet rateSetInfoSheet = workbook.createSheet("RateSetInfo");

		HashMap<String, String> rateSheetMap = new HashMap<String, String>();

		rateSheetMap.put("RateSetId", rateSet.getId());
		rateSheetMap.put("BuyerOrgId", rateSet.getBuyerOrgId());
		rateSheetMap.put("SellerOrgId", rateSet.getSellerOrgId());
		rateSheetMap.put("RateSetName", rateSet.getName());
		rateSheetMap.put("BuyerOrgName", rateSet.getBuyerOrgName());
		rateSheetMap.put("SellerOrgName", rateSet.getSellerOrgName());
		rateSheetMap.put("Mode", rateSet.getMode());
		rateSheetMap.put("Region", rateSet.getRegion());
		rateSheetMap.put("EffectiveDate", rateSet.getEffectiveDateFrom() + "");
		rateSheetMap.put("ExpirationDate", rateSet.getEarliestExpirationDate());

		System.out.println("Ratesheet map :" + rateSheetMap);
		int count = 0;

		CellStyle keyFieldStyle = workbook.createCellStyle();
		keyFieldStyle.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
		keyFieldStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		Font font = workbook.createFont();
		font.setColor(IndexedColors.BLACK.getIndex());
		keyFieldStyle.setFont(font);

		// using for-each loop for iteration over Map.entrySet()
		for (Map.Entry<String, String> entry : rateSheetMap.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			Row row = rateSetInfoSheet.createRow(count);
			Cell keyCell = row.createCell(0);
			keyCell.setCellStyle(keyFieldStyle);
			keyCell.setCellValue(entry.getKey());
			Cell valueCell = row.createCell(1);
			valueCell.setCellValue(entry.getValue() + "");
			count++;
		}

		List<RateTable> tables = rateSet.getTables();

		for (RateTable table : tables) {

			String sheetName = table.getName();
            if(workbook.getSheet(sheetName)!=null);
             sheetName = sheetName+"_"+table.getId();
			Sheet sheet = workbook.createSheet(sheetName);
			List<RateRow> rateRows = table.getRateRows();
			List<RateColumn> columns = table.getColumns();
			Row headerRow = sheet.createRow(0);
			int headerColumn = 0;
			for (RateColumn column : columns) {
				String columnName = column.getName();
				Cell headerCell = headerRow.createCell(headerColumn++);
				headerCell.setCellStyle(keyFieldStyle);
				headerCell.setCellValue(columnName);
			}

		}

		workbook.write(out);
		workbook.close();

		System.out.println("Sheets Has been Created successfully");
		return new ByteArrayInputStream(out.toByteArray());

	}
}
