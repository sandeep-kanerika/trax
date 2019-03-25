package com.trax.ratemanager.ratetable;

public class RateTableConverter {
	
	public static RateTable convertToRateTable(RateTableVo rateTableVo) throws Exception {
		RateTable rateTable = null;
		if(rateTableVo != null) {
			rateTable = new RateTable();
			System.out.println("existing id:::" + rateTableVo.getId());

			rateTable.setId(rateTableVo.getId());
			rateTable.setCreatorOrgId(rateTableVo.getCreatorOrgId());
			rateTable.setName(rateTableVo.getName());
			rateTable.setDateCreated(rateTableVo.getDateCreated());
			rateTable.setTableGroup(rateTableVo.getTableGroup());
			rateTable.setTableType(rateTableVo.getTableType());
			rateTable.setColumnHash(rateTableVo.getColumnHash());
			rateTable.setColumns(rateTableVo.getColumns());
			
			return rateTable;
		}else {
			throw new Exception("Problem with input");
		}
		
	}
}
