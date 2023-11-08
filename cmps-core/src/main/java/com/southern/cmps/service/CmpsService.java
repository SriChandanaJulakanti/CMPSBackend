package com.southern.cmps.service;

import java.util.Map;

import com.southern.cmps.domain.Concentration;
import com.southern.cmps.domain.Student;
import com.southern.cmps.domain.StudentBalanceSheetInfo;
import com.southern.cmps.service.exception.CmpsException;

public interface CmpsService {

	public Student getStudentDetail(String uNumber) throws CmpsException;
	
	public Map<Integer, Concentration> getConcentrations() throws CmpsException;
	
	public StudentBalanceSheetInfo getStudentBalanceSheetInfo(String uNumber) throws CmpsException;
	
	
}
