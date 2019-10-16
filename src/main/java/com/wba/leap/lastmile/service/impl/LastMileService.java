package com.wba.leap.lastmile.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wba.leap.lastmile.beans.EligibleLastMile;
import com.wba.leap.lastmile.beans.LastMileRequest;
import com.wba.leap.lastmile.beans.LastMileResponse;
import com.wba.leap.lastmile.client.LastMileClient;
import com.wba.leap.lastmile.config.LastMileConfig;
import com.wba.leap.lastmile.exception.BusinessException;
import com.wba.leap.lastmile.exception.InternalException;
import com.wba.leap.lastmile.service.IEligibleLastMileService;
import com.wba.leap.lastmile.service.IEstimatedFulfilmentTimeService;
import com.wba.leap.lastmile.service.ILastMileService;
import com.wba.leap.lastmile.service.IProductAvailabilityService;


@Component
public class LastMileService implements ILastMileService {

	Logger logger = LogManager.getLogger(LastMileService.class);

	@Autowired
	LastMileClient lastMileClient;

	@Autowired
	LastMileConfig config;

	@Autowired
	ObjectMapper objMapper;
	
	@Autowired
	LastMileResponse lastMileResponse;
	
	@Autowired
	IEligibleLastMileService eligibleLastMileService;
	
	@Autowired
	IEstimatedFulfilmentTimeService estimatedFulfilmentTimeService;
	
	@Autowired
	IProductAvailabilityService productAvailabilityService;

	@Override
	public LastMileResponse getLastMile(LastMileRequest lastMileRequest) throws IOException, BusinessException, InternalException {
		List<EligibleLastMile> eligibleLastMileResponse=eligibleLastMileService.getEligibleLastMile(lastMileRequest);	
		lastMileResponse.setEligibleLastMileResponses(eligibleLastMileResponse);
		lastMileResponse.setRxEstimatedFulfillmenttime(estimatedFulfilmentTimeService.getFulfillmentTime(lastMileRequest));
		lastMileResponse.setProductAvailability(productAvailabilityService.getProductAvailability(lastMileRequest));
		return lastMileResponse;
	}
}
