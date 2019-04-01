package com.trax.ratemanager.rateset;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;

@Service
public class RateSetsService
/* extends AbstractJpaService<RateSet> */ {

	@Autowired
	private RateSetRepository rateSetsRepository;

	public RateSet create(RateSet rateSet)
	{
		System.out.println("trying to store rateSets:::");
		return rateSetsRepository.save(rateSet);
	}

	public RateSet update(RateSet _rateSets)
	{
		Optional<RateSet> rateSet = rateSetsRepository.findById(_rateSets.getId());
		if (rateSet.isPresent()) return rateSetsRepository.save(rateSet.get());
		else
		{
			throw new ResourceNotFoundException("RateSets Id Doesn't Exists !");
		}
	}

	public RateSet delete(RateSet rateSets)
	{
		rateSetsRepository.delete(rateSets);
		return rateSets;
	}

	public List<RateSet> search(RateSet rateSets)
	{
		return rateSetsRepository.findAll();
	}

	public RateSet getById(String id)
	{
		return rateSetsRepository.getById(id);
	}

	public RateSet getByIdAndTableId(String id, String tableId)
	{
		return rateSetsRepository.getByIdAndTableId(id, tableId);
	}

	public List<RateSet> findAll()
	{
		return rateSetsRepository.findAll();
	}

	public ByteArrayInputStream getRateSetInExcelFormat(String rateSetId) throws IOException
	{
		Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Sheet sheet1 = workbook.createSheet("RateSetInfo");
  
		//for()
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[]{"ID", "NAME", "LASTNAME"});
		data.put("2", new Object[]{1, "Pankaj", "Kumar"});
		data.put("3", new Object[]{2, "Prakashni", "Yadav"});
		data.put("4", new Object[]{3, "Ayan", "Mondal"});
		data.put("5", new Object[]{4, "Virat", "kohli"});

		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset)
		{
			Row row = sheet1.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr)
			{
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String) cell.setCellValue((String) obj);
				else if (obj instanceof Integer) cell.setCellValue((Integer) obj);
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
