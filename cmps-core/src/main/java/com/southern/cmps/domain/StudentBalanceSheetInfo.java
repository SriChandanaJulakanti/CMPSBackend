package com.southern.cmps.domain;

import java.util.Map;

import lombok.Data;

@Data
public class StudentBalanceSheetInfo {

	private String uNumber;
	private String firstName;
	private String lastName;
	private Map<Integer, Concentration> concentrationsInfo;
	
}
