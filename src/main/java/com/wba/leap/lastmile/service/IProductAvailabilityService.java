package com.wba.leap.lastmile.service;

import java.io.IOException;

import com.wba.leap.lastmile.beans.LastMileRequest;
import com.wba.leap.lastmile.exception.BusinessException;
import com.wba.leap.lastmile.exception.InternalException;

public interface IProductAvailabilityService {
	public Boolean getProductAvailability(LastMileRequest lastMileRequest) throws IOException, BusinessException, InternalException;
}
