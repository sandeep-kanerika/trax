package com.trax.ratemanager.rateset.definition;

public class RateSetDefinitionConverter {

	public static RateSetDefinition convertToRateSetDefinition(RateSetDefinitionVo rateSetDefinitionVo) throws Exception {
		RateSetDefinition rateSetDefinition = null;
		if (rateSetDefinitionVo != null) {
			rateSetDefinition = new RateSetDefinition();
			System.out.println("existing id:::" + rateSetDefinitionVo.getId());

			rateSetDefinition.setId(rateSetDefinitionVo.getId());
			rateSetDefinition.setStatus(rateSetDefinitionVo.getStatus());
			rateSetDefinition.setCreatorOrgId(rateSetDefinitionVo.getCreatorOrgId());
			rateSetDefinition.setRegion(rateSetDefinitionVo.getRegion());
			rateSetDefinition.setMode(rateSetDefinitionVo.getMode());
			rateSetDefinition.setName(rateSetDefinitionVo.getName());
			rateSetDefinition.setDateCreated(rateSetDefinitionVo.getDateCreated());
			rateSetDefinition.setDateUpdated(rateSetDefinitionVo.getDateUpdated());
			rateSetDefinition.setTableHash(rateSetDefinitionVo.getTableHash());
			rateSetDefinition.setTables(rateSetDefinitionVo.getTables());

			return rateSetDefinition;

		}
		else 
		{
			throw new Exception("Problem with input");
		}

	}

	public static RateSetDefinitionVo convertToRateSetDefinitionVo(RateSetDefinition rateSetDefinition) 
	{
		String id = rateSetDefinition.getId();
		 RateSetDefinitionVo rateSetDefinitionVo = new RateSetDefinitionVo();
		 rateSetDefinitionVo.setId(id);
		return rateSetDefinitionVo;
	}

}