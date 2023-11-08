package com.southern.cmps.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Course {

	private String courseId;
	private String courseName;
	private Integer concentrationCode;
	private Integer hours;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
}
