package com.wba.leap.lastmile.beans;


import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Component
public class LastMileResponse {
	
	private String rxEstimatedFulfillmenttime;
	
	private Boolean productAvailability;
	
	private List<EligibleLastMile> eligibleLastMile;

	public String getRxEstimatedFulfillmenttime() {
		return rxEstimatedFulfillmenttime;
	}

	public void setRxEstimatedFulfillmenttime(String rxEstimatedFulfillmenttime) {
		this.rxEstimatedFulfillmenttime = rxEstimatedFulfillmenttime;
	}

	public Boolean getProductAvailability() {
		return productAvailability;
	}

	public void setProductAvailability(Boolean productAvailability) {
		this.productAvailability = productAvailability;
	}

	public List<EligibleLastMile> getEligibleLastMile() {
		return eligibleLastMile;
	}

	public void setEligibleLastMileResponses(List<EligibleLastMile> eligibleLastMile) {
		this.eligibleLastMile = eligibleLastMile;
	}
	
	
	
		
}
