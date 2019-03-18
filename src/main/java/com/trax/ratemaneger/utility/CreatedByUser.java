package com.trax.ratemaneger.utility;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CreatedByUser {

	@Id
	private String id;

	private String orgId;
	private String userEmail;
	private String comment;
}
