package com.southern.cmps.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.southern.cmps.response.CmpsResponse;
import com.southern.cmps.response.CmpsResponse.Status;
import com.southern.cmps.service.CmpsService;
import com.southern.cmps.service.exception.CmpsException;
import com.southern.cmps.service.impl.CmpsServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private CmpsService cmpsServiceImpl;
	
	@RequestMapping(value="/getStudentDetail",
    method=RequestMethod.GET,
    produces="application/json")
	public ResponseEntity<CmpsResponse> getStudentDetail(@RequestParam String uNumber, HttpServletRequest request) throws CmpsException {
		return new ResponseEntity<CmpsResponse>(new CmpsResponse(Status.SUCCESS, null, cmpsServiceImpl.getStudentDetail(uNumber)),HttpStatus.OK);
	}

	@GetMapping("/concentrations")
	public ResponseEntity<CmpsResponse> getConcentrations(HttpServletRequest request) throws CmpsException {
		return new ResponseEntity<CmpsResponse>(new CmpsResponse(Status.SUCCESS, null, cmpsServiceImpl.getConcentrations()),HttpStatus.OK);
	}
	
	@GetMapping("/report-download-url")
	public ResponseEntity<Resource> reportDownloadUrl(HttpServletRequest request) throws Exception {
		return getTestReport(CmpsServiceImpl.writeToFile("student-balance-sheet.ftl", new HashMap<String,String>()));
	}
	
	public ResponseEntity<Resource> getTestReport(Resource labReportResponse) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_PDF_VALUE));
		headers.setContentLength(labReportResponse.contentLength());
		ContentDisposition contentDisposition = ContentDisposition.builder("inline")
		          .filename("Student_BalanceSheet")
		          .build();
		headers.setContentDisposition(contentDisposition);
		return new ResponseEntity<>(labReportResponse, headers, HttpStatus.OK);
	}
	
 }
