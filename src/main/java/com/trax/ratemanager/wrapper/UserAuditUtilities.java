package com.trax.ratemanager.wrapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.trax.ratemanager.amendment.Amendments;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuditUtilities {

	private CreatedByUser createByUser;
	private LastModifiedByUser lastModifiedByUser;

}

@Data
@Entity
@Table
class CreatedByUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@OneToOne(mappedBy = "address")
	private Amendments library;

	private String orgId;
	private String userEmail;
	private String comment;
}

@Data
@Entity
@Table
class LastModifiedByUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@OneToOne(mappedBy = "address")
	private Amendments library;

	private String orgId;
	private String userEmail;
	private String comment;
}
