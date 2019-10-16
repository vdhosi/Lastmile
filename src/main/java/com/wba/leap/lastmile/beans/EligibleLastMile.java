package com.wba.leap.lastmile.beans;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"eligibleLastMile",
	"eligibilityIndicator"	
})
@Component
public class EligibleLastMile {
	@JsonProperty("eligibleLastMile")
	private String eligibleLastMile;
	@JsonProperty("eligibilityIndicator")
	private Boolean eligibilityIndicator;
	@JsonProperty("eligibleLastMileCode")
	private String eligibleLastMileCode;
	
	
	public String getEligibleLastMileCode() {
		return eligibleLastMileCode;
	}
	public void setEligibleLastMileCode(String eligibleLastMileCode) {
		this.eligibleLastMileCode = eligibleLastMileCode;
	}
	public String getEligibleLastMile() {
		return eligibleLastMile;
	}
	public void setEligibleLastMile(String eligibleLastMile) {
		this.eligibleLastMile = eligibleLastMile;
	}
	public Boolean getEligibilityIndicator() {
		return eligibilityIndicator;
	}
	public void setEligibilityIndicator(Boolean eligibilityIndicator) {
		this.eligibilityIndicator = eligibilityIndicator;
	}
	
	
		
}
