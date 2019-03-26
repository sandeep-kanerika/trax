package com.trax.ratemanager.ratetable;

import java.util.ArrayList;
import java.util.List;

import com.trax.ratemanager.ratecolumn.RateColumn;
import com.trax.ratemanager.ratecolumn.RateColumnConverter;
import com.trax.ratemanager.ratecolumn.RateColumnVo;

public class RateTableConverter {

	public static RateTable convertToRateTable(RateTableVo rateTableVo) throws Exception {
		RateTable rateTable = null;
		if (rateTableVo != null) {
			rateTable = new RateTable();
			System.out.println("existing id:::" + rateTableVo.getId());

			rateTable.setId(rateTableVo.getId());
			rateTable.setCreatorOrgId(rateTableVo.getCreatorOrgId());
			rateTable.setName(rateTableVo.getName());
			rateTable.setDateCreated(rateTableVo.getDateCreated());
			rateTable.setTableGroup(rateTableVo.getTableGroup());
			rateTable.setTableType(rateTableVo.getTableType());
			
			rateTable.setColumnHash(rateTableVo.getColumnHash());
			List<RateColumnVo> rtVos = rateTableVo.getColumns();
			List<RateColumn> columns = new ArrayList<RateColumn>();
			for (RateColumnVo vos : rtVos) {
				RateColumn column = RateColumnConverter.convertToRateColumn(vos);
				System.out.println("---column---" + column);
				column.setRateTableId(rateTable.getId());
				columns.add(column);
			}
			rateTable.setColumns(columns);

			return rateTable;
		} else 
		{
			throw new Exception("Problem with input");
		}

	}
}
