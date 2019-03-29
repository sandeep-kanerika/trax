package com.trax.ratemanager.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.amendment.Amendment;
import com.trax.ratemanager.raterow.RateRow;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AmendmentRateRowsWraper
{

	private Amendment amendments;
	private RateRow rateRows[];

	public AmendmentRateRowsWraper()
	{

	}

	public Amendment getAmendments()
	{
		return amendments;
	}

	public void setAmendments(Amendment amendments)
	{
		this.amendments = amendments;
	}

	public RateRow[] getRateRows()
	{
		return rateRows;
	}

	public void setRateRows(RateRow[] rateRows)
	{
		this.rateRows = rateRows;
	}

}
