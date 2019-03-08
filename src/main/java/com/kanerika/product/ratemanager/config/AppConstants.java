package com.kanerika.product.ratemanager.config;

public class AppConstants {

	// Date and time format constants
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-mm-dd HH:MM:ss";
	public static final String DEFAULT_DATE_FORMAT = "yyyy-mm-dd";

	// Rate status constants
	public static final int RATESTATUS_REJECTED = 3;
	public static final int RATESTATUS_APPROVED = 2;
	public static final int RATESTATUS_PENDING = 1;
	public static final int RATESTATUS_DRAFT = 0;

	// Amendments constants
	public static final int AMENDMENT_DRAFT = 0;
	public static final int AMENDMENT_PENDING = 1;
	public static final int AMENDMENT_APPROVED = 2;
	public static final int AMENDMENT_REJECTED = 3;

	// Amendments Type
	public static final int AMENDMENT_TYPE_ADD = 0;
	public static final int AMENDMENT_TYPE_UPDATE = 1;
	public static final int AMENDMENT_TYPE_CORRECT = 2;

	// Amentments Actions
	public static final int AMENDMENT_ACTION_REJECTED = 3;
	public static final int AMENDMENT_ACTION_EDIT = 2;
	public static final int AMENDMENT_ACTION_CANCEL = 1;
	public static final int AMENDMENT_ACTION_APPROVED = 0;

	// Amendments History Action
	public static final int AMENDMENT_HISTORY_ACTION_DRAFT = 0;
	public static final int AMENDMENT_HISTORY_ACTION_SUBMISSION = 1;
	public static final int AMENDMENT_HISTORY_ACTION_FINAL_APPROVAL = 2;
	public static final int AMENDMENT_HISTORY_ACTION_REJECTION = 3;
	public static final int AMENDMENT_HISTORY_ACTION_FIRST_APPROVAL = 4;
	public static final int AMENDMENT_HISTORY_ACTION_NEXT_APPROVAL = 5;
	public static final int AMENDMENT_HISTORY_ACTION_RESUBMISSION = 6;

}
