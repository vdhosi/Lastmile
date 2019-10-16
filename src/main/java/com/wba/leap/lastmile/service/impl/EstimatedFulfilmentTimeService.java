package com.wba.leap.lastmile.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wba.leap.lastmile.beans.LastMileRequest;
import com.wba.leap.lastmile.client.LastMileClient;
import com.wba.leap.lastmile.config.LastMileConfig;
import com.wba.leap.lastmile.exception.BusinessException;
import com.wba.leap.lastmile.exception.InternalException;
import com.wba.leap.lastmile.service.IEstimatedFulfilmentTimeService;


@Service
public class EstimatedFulfilmentTimeService implements IEstimatedFulfilmentTimeService{
	
	@Autowired
	ObjectMapper objMapper;
	
	@Autowired
	LastMileClient lastMileClient;

	@Autowired
	LastMileConfig config;
	
	private static String CUSTOMERID="customerId";
	private static String RXNUMBER="rxNumber";
	private static String STORENUMBER="storeNumber";

	public String getFulfillmentTime(LastMileRequest lastMileRequest) throws IOException, BusinessException, InternalException { 
		Map<String, String> params = new HashMap<String, String>();
		params.put(CUSTOMERID, lastMileRequest.getCustomerId().toString());
		params.put(RXNUMBER, lastMileRequest.getRxInfo().get(0).getRxNumber());
		params.put(STORENUMBER, lastMileRequest.getStoreNumber().toString());
		ResponseEntity<String> lastMileResponseEntity = lastMileClient.get(config.getFulfillmentTimeUrl(),params);
		JsonNode actualObj = objMapper.readTree(lastMileResponseEntity.getBody());
		String estimatedFulfilmentTime=actualObj.get("estimatedFulfilmentTime").asText();
		return estimatedFulfilmentTime;
	}
	
}
