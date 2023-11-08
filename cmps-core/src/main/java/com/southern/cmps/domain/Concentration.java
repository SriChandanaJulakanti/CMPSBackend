package com.southern.cmps.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.Data;


@Data
public class Concentration {

	private Integer concentrationCode;
	private String name;
	private Map<Integer, Course> courses;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
}
