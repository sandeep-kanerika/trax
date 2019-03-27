package com.trax.ratemaneger.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelFileCreationUtility {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Workbook workbook = new HSSFWorkbook();
		OutputStream outputFile = new FileOutputStream("RateSets_"+LocalDateTime.now().toString().replace(':', '_')+".xlsx");
		
		Sheet sheet1 = workbook.createSheet("Array");

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

		workbook.write(outputFile);
		workbook.close();
		outputFile.close();
		
		System.out.println("Sheets Has been Created successfully");

	}
}