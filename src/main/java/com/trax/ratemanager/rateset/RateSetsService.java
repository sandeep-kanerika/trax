package com.trax.ratemanager.rateset;

import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Optional;

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
import com.trax.ratemanager.ratetable.RateTable;

@Service
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
		RateSet rateSet = rateSetsRepository.getById(rateSetId);

		SXSSFWorkbook workbook = new SXSSFWorkbook();
//		Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Sheet sheet1 = workbook.createSheet("RateSetInfo");

//		int rowCount = 0;
//        int columnCount = 0;
//        Row row = sheet1.createRow(0);
//        Cell cell = row.createCell(columnCount++);
//        cell.setCellValue(rateSet.getId());
//        for (String fieldName : fieldNames) {
//            Cell cell = row.createCell(columnCount++);
//            cell.setCellValue(fieldName);
//        }

		System.out.println("RAteSET :::::" + rateSet);

//		for (int col = 0; col < COLUMNs.length; col++) {
//			Cell cell = headerRow.createCell(col);
//			cell.setCellValue(COLUMNs[col]);
//			cell.setCellStyle(headerCellStyle);
//		}

//		org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
//		headerFont.setBold(true);
//		headerFont.setColor(IndexedColors.BLUE.getIndex());

		List<String> rateSetsfieldNames = getFieldNamesForClass(rateSet.getClass());

//		System.out.println(rateSetsfieldNames);
//		Row row = sheet1.createRow(rowCount++);
		
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		org.apache.poi.ss.usermodel.Font font = workbook.createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		style.setFont(font);
		
		int rowCount = 0;
		int columnCount = 0;
		for (String fieldName : rateSetsfieldNames) {
			Row rows = sheet1.createRow(rowCount++);
			Cell cell = rows.createCell(columnCount);
			cell.setCellValue(fieldName);
			cell.setCellStyle(style);
			
			cell = rows.createCell(columnCount + 1);
			Class<? extends Object> classz = rateSet.getClass();
			Method method = null;
			try {
                method = classz.getMethod("get" + capitalize(fieldName));
            } catch (NoSuchMethodException nme) {
                method = classz.getMethod("get" + fieldName);
            }
			System.out.println(":::::: " + method.getReturnType().getName() + " ::: " + method.getClass().getTypeName()+ " ::: " + method.getReturnType() );
			
			Object value = method.invoke(method.getReturnType(), (Object[]) null);
			
			if (value != null) {
                if (value instanceof String) {
                	System.out.println("Str :::: " + value);
                    cell.setCellValue((String) value);
                } else if (value instanceof Long) {
                    cell.setCellValue((Long) value);
                } else if (value instanceof Integer) {
                    cell.setCellValue((Integer) value);
                } else if (value instanceof Double) {
                    cell.setCellValue((Double) value);
                }
            }
			
		}
//		Row RateSetId = sheet1.createRow(0);
//		Cell cell = RateSetId.createCell(0);
//		cell.setCellValue("RateSetId");
//		cell.setCellStyle(style);
//		cell = RateSetId.createCell(1);
//		cell.setCellValue(rateSet.getId());
//
//		Row BuyerOrgId = sheet1.createRow(1);
//		Cell Buyercell = BuyerOrgId.createCell(0);
//		Buyercell.setCellValue("BuyerOrgId");
//		Buyercell = BuyerOrgId.createCell(1);
//		Buyercell.setCellValue(rateSet.getBuyerOrgId());
//
//		Row SellerOrgId = sheet1.createRow(1);
//		Cell SellerCell = SellerOrgId.createCell(0);
//		SellerCell.setCellValue("SellerOrgId");
//		SellerCell = SellerOrgId.createCell(1);
//		SellerCell.setCellValue(rateSet.getSellerOrgId());

//		for(int i = 0 ; i < rateSet.getTables().size() ; i ++) {
//			Sheet sheet2 = workbook.createSheet(rateSet.getTables().get(i).getName());
//			
//			List<String> fieldNames = getFieldNamesForClass(rateSet.getTables().get(i).getClass());
//            int rowCount = 0;
//            int columnCount = 0;
//            Row row = sheet2.createRow(rowCount++);
//            for (String fieldName : fieldNames) {
//                Cell newCell = row.createCell(columnCount++);
//                newCell.setCellValue(fieldName);
//            }
//		}

//			Row header = sheet2.createRow(0);
//		    header.createCell(0).setCellValue();
//			int rownum = 0;
//			for (String key : keyset) {
//				Row row = sheet2.createRow(rownum++);
//				Object[] objArr = data.get(key);
//				int cellnum = 0;
//				for (Object obj : objArr) {
//					Cell cell = row.createCell(cellnum++);
//					if (obj instanceof String)
//						cell.setCellValue((String) obj);
//					else if (obj instanceof Integer)
//						cell.setCellValue((Integer) obj);
//				}
//		    
//			}

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
	
	//capitalize the first letter of the field name for retriving value of the field later
    private static String capitalize(String s) {
        if (s.length() == 0)
            return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}
