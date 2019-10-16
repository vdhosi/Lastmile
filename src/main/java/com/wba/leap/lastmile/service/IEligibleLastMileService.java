package com.wba.leap.lastmile.service;

import java.io.IOException;
import java.util.List;

import com.wba.leap.lastmile.beans.EligibleLastMile;
import com.wba.leap.lastmile.beans.LastMileRequest;
import com.wba.leap.lastmile.exception.BusinessException;
import com.wba.leap.lastmile.exception.InternalException;

public interface IEligibleLastMileService {
	public List<EligibleLastMile> getEligibleLastMile(LastMileRequest lastMileRequest) throws IOException, BusinessException, InternalException;
}
