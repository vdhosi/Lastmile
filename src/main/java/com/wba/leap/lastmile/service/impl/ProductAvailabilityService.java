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
import com.wba.leap.lastmile.beans.RxInfo;
import com.wba.leap.lastmile.client.LastMileClient;
import com.wba.leap.lastmile.config.LastMileConfig;
import com.wba.leap.lastmile.exception.BusinessException;
import com.wba.leap.lastmile.exception.InternalException;
import com.wba.leap.lastmile.service.IProductAvailabilityService;

@Service
public class ProductAvailabilityService implements IProductAvailabilityService{
	@Autowired
	LastMileClient lastMileClient;

	@Autowired
	LastMileConfig config;

	@Autowired
	ObjectMapper objMapper;
	
	private static String PRODUCTID="productId";
	private static String STORENUMBER="storeNumber";
	
	public Boolean getProductAvailability(LastMileRequest lastMileRequest) throws IOException, BusinessException, InternalException {
		Map<String, String> params = new HashMap<String, String>();
		for (RxInfo rxInfo : lastMileRequest.getRxInfo()) {
			params.put(PRODUCTID, rxInfo.getProductId().toString());
			params.put(STORENUMBER, lastMileRequest.getStoreNumber().toString());
			ResponseEntity<String> lastMileResponseEntity = lastMileClient.get(config.getProductAvailabilityUrl(),
					params);
			JsonNode actualObj = objMapper.readTree(lastMileResponseEntity.getBody());
			int prodQty = actualObj.get("qtyAvailable").asInt();
			if (prodQty==0) {
				return false;
			}
		}
		return true;
	}
}
