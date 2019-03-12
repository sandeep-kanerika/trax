package com.trax.ratemaneger.utility;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
	@Entity
	@Table
	public class CreatedByUser {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String id;

		private String orgId;
		private String userEmail;
		private String comment;
	}
