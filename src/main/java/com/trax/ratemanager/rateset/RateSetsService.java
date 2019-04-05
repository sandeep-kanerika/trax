package com.trax.ratemanager.rateset;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.spring.web.json.Json;

@Service
@Slf4j
public class RateSetsService
/* extends AbstractJpaService<RateSet> */ {

	@Autowired
	private RateSetRepository rateSetsRepository;

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

		RateSet rateSetJson = rateSetsRepository.getById(rateSetId);

		SXSSFWorkbook workbook = new SXSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Sheet sheet1 = workbook.createSheet("RateSetInfo");

		System.out.println("RAteSET :::::" + rateSetJson);
		
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		org.apache.poi.ss.usermodel.Font font = workbook.createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		style.setFont(font);

		int rowCount = 0;
		
		Row rowsId = sheet1.createRow(rowCount++);
		Cell cellId = rowsId.createCell(0);
		cellId.setCellValue("RateSetId");
		cellId.setCellStyle(style);
		cellId = rowsId.createCell(1);
		cellId.setCellValue(rateSetJson.getId());

		Row rowsBuyerId = sheet1.createRow(rowCount++);
		Cell cellBuyerId = rowsBuyerId.createCell(0);
		cellBuyerId.setCellValue("BuyerOrgId");
		cellBuyerId.setCellStyle(style);
		cellBuyerId = rowsBuyerId.createCell(1);
		cellBuyerId.setCellValue(rateSetJson.getBuyerOrgId());

		/*
		 * int rowCount = 0; int columnCount = 0; for (String fieldName :
		 * rateSetsfieldNames) { Row rows = sheet1.createRow(rowCount++); Cell cell =
		 * rows.createCell(columnCount); cell.setCellValue(fieldName);
		 * cell.setCellStyle(style);
		 * 
		 * cell = rows.createCell(columnCount + 1); cell.setCellValue(fieldName);
		 * 
		 * }
		 */
		
		/*
		 * Row RateSetId = sheet1.createRow(0); Cell cell = RateSetId.createCell(0);
		 * cell.setCellValue("RateSetId"); cell.setCellStyle(style); cell =
		 * RateSetId.createCell(1); cell.setCellValue(rateSet.getId());
		 * 
		 * Row BuyerOrgId = sheet1.createRow(1); Cell Buyercell =
		 * BuyerOrgId.createCell(0); Buyercell.setCellValue("BuyerOrgId"); Buyercell =
		 * BuyerOrgId.createCell(1); Buyercell.setCellValue(rateSet.getBuyerOrgId());
		 * 
		 * Row SellerOrgId = sheet1.createRow(1); Cell SellerCell =
		 * SellerOrgId.createCell(0); SellerCell.setCellValue("SellerOrgId"); SellerCell
		 * = SellerOrgId.createCell(1);
		 * SellerCell.setCellValue(rateSet.getSellerOrgId());
		 */

		/*
		 * for(int i = 0 ; i < rateSet.getTables().size() ; i ++) { Sheet sheet2 =
		 * workbook.createSheet(rateSet.getTables().get(i).getName());
		 * 
		 * List<String> fieldNames =
		 * getFieldNamesForClass(rateSet.getTables().get(i).getClass()); int rowCount =
		 * 0; int columnCount = 0; Row row = sheet2.createRow(rowCount++); for (String
		 * fieldName : fieldNames) { Cell newCell = row.createCell(columnCount++);
		 * newCell.setCellValue(fieldName); } }
		 */

		/*
		 * Row header = sheet2.createRow(0); header.createCell(0).setCellValue(); int
		 * rownum = 0; for (String key : keyset) { Row row = sheet2.createRow(rownum++);
		 * Object[] objArr = data.get(key); int cellnum = 0; for (Object obj : objArr) {
		 * Cell cell = row.createCell(cellnum++); if (obj instanceof String)
		 * cell.setCellValue((String) obj); else if (obj instanceof Integer)
		 * cell.setCellValue((Integer) obj); }
		 * 
		 * }
		 */

		/*
		 * for (int col = 0; col < COLUMNs.length; col++) { Cell cell =
		 * headerRow.createCell(col); cell.setCellValue(COLUMNs[col]);
		 * cell.setCellStyle(headerCellStyle); }
		 * 
		 * org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		 * headerFont.setBold(true); headerFont.setColor(IndexedColors.BLUE.getIndex());
		 */

//		List<String> rateSetsfieldNames = getFieldNamesForClass(rateSetJson.getClass());
//
//		System.out.println(rateSetsfieldNames);
//
//		for (String fieldName : rateSetsfieldNames) {
//			Row rows = sheet1.createRow(rowCount++);
//			Cell cell = rows.createCell(columnCount);
//			cell.setCellValue(fieldName);
//			cell.setCellStyle(style);
//
//			cell = rows.createCell(columnCount + 1);
////			cell.setCellValue(rateSetJson.get+capitalize(fieldName)+());
//		}
//		Row row = sheet1.createRow(rowCount++);

		/*
		 * Class<? extends Object> classz = rateSetJson.getClass(); for (String
		 * fieldName : rateSetsfieldNames) { System.out.println("clazzzzyy ::::: " +
		 * classz.getMethod("get" + capitalize(fieldName)) + " ::::: ");
		 * 
		 * 
		 * Method method = null; try { method = classz.getMethod("get" +
		 * capitalize(fieldName));
		 * 
		 * System.out.println(":::::: " + method.getReturnType().getName() + " ::: " +
		 * method.getClass().getTypeName() + " ::: " + method.getName());
		 * 
		 * } catch (NoSuchMethodException nme) { method = classz.getMethod("get" +
		 * fieldName); } }
		 */

		// end

		workbook.write(out);
//		workbook.close();

		System.out.println("Sheets Has been Created successfully");
		return new ByteArrayInputStream(out.toByteArray());

	}

	// retrieve field names from a POJO class
	private static List<String> getFieldNamesForClass(Class<?> clazz) throws Exception {
		List<String> fieldNames = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fieldNames.add(fields[i].getName());
		}
		return fieldNames;
	}

	// capitalize the first letter of the field name for retriving value of the
	// field later
	private static String capitalize(String s) {
		if (s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public ByteArrayInputStream getRateSetAndTableInExcelFormat(String rateSetId, String tableId) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Sheet sheet1 = workbook.createSheet("RateSetInfo");

		// for()
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
		data.put("2", new Object[] { 1, "Pankaj", "Kumar" });
		data.put("3", new Object[] { 2, "Prakashni", "Yadav" });
		data.put("4", new Object[] { 3, "Ayan", "Mondal" });
		data.put("5", new Object[] { 4, "Virat", "kohli" });

		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet1.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}

		Sheet sheet2 = workbook.createSheet("String");
		Sheet sheet3 = workbook.createSheet("LinkedList");
		Sheet sheet4 = workbook.createSheet("Tree");
		Sheet sheet5 = workbook.createSheet("Dynamic Programing");
		Sheet sheet6 = workbook.createSheet("Puzzles");

		workbook.write(out);
		workbook.close();

		System.out.println("Sheets Has been Created successfully");
		return new ByteArrayInputStream(out.toByteArray());

	}
}
