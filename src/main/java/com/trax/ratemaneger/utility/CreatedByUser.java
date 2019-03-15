package com.trax.ratemaneger.utility;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
	@Entity
	@Table
	public class CreatedByUser {

		@Id
		private String id;

		private String orgId;
		private String userEmail;
		private String comment;
	}
