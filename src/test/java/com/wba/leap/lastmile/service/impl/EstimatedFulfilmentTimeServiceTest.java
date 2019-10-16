package com.wba.leap.lastmile.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wba.leap.lastmile.beans.LastMileRequest;
import com.wba.leap.lastmile.beans.RxInfo;
import com.wba.leap.lastmile.client.LastMileClient;
import com.wba.leap.lastmile.config.LastMileConfig;
import com.wba.leap.lastmile.exception.BusinessException;
import com.wba.leap.lastmile.exception.InternalException;

@RunWith(MockitoJUnitRunner.class)
public class EstimatedFulfilmentTimeServiceTest {

	@InjectMocks
	EstimatedFulfilmentTimeService eftsMock;

	@Mock
	ObjectMapper objMapper;

	@Mock
	LastMileClient lastMileClient;

	@Mock
	LastMileConfig config;
	
	@Mock
	ObjectNode mockJsonNode;

	@Test
	public void getFulfillmentTimeTest() throws IOException, BusinessException, InternalException {
		String expected="2019-10-14T18:00:00.000";
		LastMileRequest lastMileRequest = new LastMileRequest();
		lastMileRequest.setCustomerId("10002");
		lastMileRequest.setStoreNumber(5387l);
		RxInfo rxInfo = new RxInfo();
		rxInfo.setProductId(3l);
		rxInfo.setRxNumber("1234569");
		List<RxInfo> rxInfoList = new ArrayList<>();
		rxInfoList.add(rxInfo);
		lastMileRequest.setRxInfo(rxInfoList);
		
		Mockito.when(config.getFulfillmentTimeUrl()).thenReturn("");
		Mockito.when(lastMileClient.get(Mockito.any(),Mockito.any())).thenReturn(new ResponseEntity<String>("", HttpStatus.OK));
		Mockito.when(objMapper.readTree(Mockito.anyString())).thenReturn(mockJsonNode);
		Mockito.when(mockJsonNode.get(Mockito.anyString())).thenReturn(mockJsonNode);
		Mockito.when(mockJsonNode.asText()).thenReturn("2019-10-14T18:00:00.000");
		String estimatedFulfilmentTime=eftsMock.getFulfillmentTime(lastMileRequest);
		Assert.assertEquals(expected, estimatedFulfilmentTime);

	}

}
