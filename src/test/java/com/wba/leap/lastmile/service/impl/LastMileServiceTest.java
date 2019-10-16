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

import com.wba.leap.lastmile.beans.EligibleLastMile;
import com.wba.leap.lastmile.beans.LastMileRequest;
import com.wba.leap.lastmile.beans.LastMileResponse;
import com.wba.leap.lastmile.beans.RxInfo;
import com.wba.leap.lastmile.exception.BusinessException;
import com.wba.leap.lastmile.exception.InternalException;
import com.wba.leap.lastmile.service.IEligibleLastMileService;
import com.wba.leap.lastmile.service.IEstimatedFulfilmentTimeService;
import com.wba.leap.lastmile.service.IProductAvailabilityService;

@RunWith(MockitoJUnitRunner.class)
public class LastMileServiceTest {

	@InjectMocks
	LastMileService lastMileServiceMock;

	@Mock
	LastMileResponse lastMileResponse;
	
	@Mock
	IEligibleLastMileService eligibleLastMileService;
	
	@Mock
	IEstimatedFulfilmentTimeService estimatedFulfilmentTimeService;
	
	@Mock
	IProductAvailabilityService productAvailabilityService;

	@Test
	public void getLastMileTest() throws IOException, BusinessException, InternalException {
		List<EligibleLastMile> eligibleLastMileList = new ArrayList<>();
		EligibleLastMile eligibleLastMile = new EligibleLastMile();
		eligibleLastMile.setEligibilityIndicator(true);
		eligibleLastMile.setEligibleLastMile("asd");
		eligibleLastMile.setEligibleLastMileCode("123");
		eligibleLastMileList.add(eligibleLastMile);
		
		LastMileRequest lastMileRequest = new LastMileRequest();
		lastMileRequest.setCustomerId("10002");
		lastMileRequest.setStoreNumber(5387l);
		RxInfo rxInfo = new RxInfo();
		rxInfo.setProductId(3l);
		rxInfo.setRxNumber("1234569");
		List<RxInfo> rxInfoList = new ArrayList<>();
		rxInfoList.add(rxInfo);
		lastMileRequest.setRxInfo(rxInfoList);
		
		Mockito.when(eligibleLastMileService.getEligibleLastMile(Mockito.any())).thenReturn(eligibleLastMileList);
		Mockito.when(estimatedFulfilmentTimeService.getFulfillmentTime(Mockito.any())).thenReturn("");
		Mockito.when(productAvailabilityService.getProductAvailability(Mockito.any())).thenReturn(true);
		LastMileResponse lastMileResponse=lastMileServiceMock.getLastMile(lastMileRequest);
		Assert.assertNotNull(lastMileResponse);
	}

}
