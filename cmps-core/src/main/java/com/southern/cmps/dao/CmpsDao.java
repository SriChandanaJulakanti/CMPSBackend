package com.southern.cmps.dao;

import java.util.Map;

import com.southern.cmps.domain.Concentration;
import com.southern.cmps.domain.Student;

public interface CmpsDao {
	
	public Map<Integer, Concentration> getConcentrations();

	Student getStudentDetail(String uNumber);

}
