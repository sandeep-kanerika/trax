package com.trax.ratemanager.utility;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class LastModifiedByUser {
	@Id
	private String id;

	private String userName;

	@Email
	private String emailId;

	private String comment;
}
