package com.trax.ratemanager.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.amendment.Amendments;
import com.trax.ratemanager.raterow.RateRow;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AmendmentRateRowsWraper {

	private Amendments amendments;
	private RateRow rateRows[];

	public AmendmentRateRowsWraper() {

	}

	public Amendments getAmendments() {
		return amendments;
	}

	public void setAmendments(Amendments amendments) {
		this.amendments = amendments;
	}

	public RateRow[] getRateRows() {
		return rateRows;
	}

	public void setRateRows(RateRow[] rateRows) {
		this.rateRows = rateRows;
	}

}
