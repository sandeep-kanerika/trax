package com.trax.ratemaneger.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.trax.ratemanager.amendment.Amendment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class UserAuditor {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String orgId;
	private String userEmail;
	private String comment;

	@OneToMany(targetEntity = Amendment.class, mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JoinColumn(name = "createdById")
	private List<UserAuditor> createdBy;

	@OneToMany(targetEntity = Amendment.class, mappedBy = "lastUpdatedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JoinColumn(name = "lastModifiedById")
	private List<UserAuditor> lastModifiedBy;

}
