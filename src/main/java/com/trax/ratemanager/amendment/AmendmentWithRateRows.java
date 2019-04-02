package com.trax.ratemanager.amendment;

import java.util.List;

import com.trax.ratemanager.raterow.RateRowVo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmendmentWithRateRows
{

	private Amendment amendment;
	private List<RateRowVo> rateRows;

}