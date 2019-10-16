package com.wba.leap.lastmile.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wba.leap.lastmile.beans.EligibleLastMile;
import com.wba.leap.lastmile.beans.LastMileRequest;
import com.wba.leap.lastmile.client.LastMileClient;
import com.wba.leap.lastmile.config.LastMileConfig;
import com.wba.leap.lastmile.exception.BusinessException;
import com.wba.leap.lastmile.exception.InternalException;
import com.wba.leap.lastmile.service.IEligibleLastMileService;

@Service
public class EligibleLastMileService implements IEligibleLastMileService{
	
	@Autowired
	LastMileClient lastMileClient;
	
	@Autowired
	LastMileConfig config;

	@Autowired
	ObjectMapper objMapper;
	
	public List<EligibleLastMile> getEligibleLastMile(LastMileRequest lastMileRequest) throws IOException, BusinessException, InternalException{
		ResponseEntity<String> lastMileResponseEntity = lastMileClient.post(config.getEligibleLastMileUrl(),
				lastMileRequest);
		List<EligibleLastMile>	lastMileResponse=Arrays.asList(objMapper.readValue(lastMileResponseEntity.getBody(), EligibleLastMile[].class));
        return lastMileResponse;
	}

}
