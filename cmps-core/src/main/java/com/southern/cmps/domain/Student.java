package com.southern.cmps.domain;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Student {

	private String uNumber;
	private String firstName;
	private String lastName;
	private List<CourseDetail> courses;
	private Map<Integer,CourseDetail> coursesMap;
	private String gender;
	private String emailId;
	private String advisor;
	private String createdBy;
	private String dateCreated;
	
}
