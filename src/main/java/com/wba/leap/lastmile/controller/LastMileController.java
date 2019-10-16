package com.wba.leap.lastmile.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wba.leap.lastmile.beans.LastMileRequest;
import com.wba.leap.lastmile.beans.LastMileResponse;
import com.wba.leap.lastmile.exception.BusinessException;
import com.wba.leap.lastmile.exception.InternalException;
import com.wba.leap.lastmile.service.ILastMileService;

@RestController
public class LastMileController {

	@Autowired
	ILastMileService lastMileService;
	@Autowired
	LastMileResponse lastMileResponse;

	Logger logger = LogManager.getLogger(LastMileController.class);

	@PostMapping(value = "/rx/v1/lastmile",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getEligibleLastMile(@RequestHeader(value = "Channel") String channel,
			@RequestHeader(value = "MessageId", required = false) String messageId,
			@RequestHeader(value = "accessToken") String accessToken,
			@Valid @RequestBody LastMileRequest lastMileRequest) throws InternalException, BusinessException, IOException {
		
		ObjectMapper jsonMapperObj = new ObjectMapper();
		String reqObject;
		try {
			reqObject = jsonMapperObj.writeValueAsString(lastMileRequest);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new InternalException("301:Login Request Tranformation Error:LEAP API");
		}
		if(reqObject!=null) {
			lastMileResponse=lastMileService.getLastMile(lastMileRequest);
			
		}
		return new ResponseEntity<>(lastMileResponse,HttpStatus.OK);
	}
}
