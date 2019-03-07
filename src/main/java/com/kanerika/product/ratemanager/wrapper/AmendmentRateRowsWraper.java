package com.kanerika.product.ratemanager.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kanerika.product.ratemanager.amendment.Amendments;
import com.kanerika.product.ratemanager.raterow.RateRows;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AmendmentRateRowsWraper {

	private Amendments amendments;
	private RateRows rateRows[];

	public AmendmentRateRowsWraper() {

	}

	public Amendments getAmendments() {
		return amendments;
	}

	public void setAmendments(Amendments amendments) {
		this.amendments = amendments;
	}

	public RateRows[] getRateRows() {
		return rateRows;
	}

	public void setRateRows(RateRows[] rateRows) {
		this.rateRows = rateRows;
	}

}
