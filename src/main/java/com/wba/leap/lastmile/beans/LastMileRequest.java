package com.wba.leap.lastmile.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"customerId",
	"storeNumber",
	"rxInfo"
})
public class LastMileRequest {
	
	@JsonProperty("customerId")
	private String customerId;
	
	@JsonProperty("storeNumber")
	private Long storeNumber;
	
	@JsonProperty("rxInfo")
	private List<RxInfo> rxInfo;
	
	public Long getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(Long storeNumber) {
		this.storeNumber = storeNumber;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public List<RxInfo> getRxInfo() {
		return rxInfo;
	}
	public void setRxInfo(List<RxInfo> rxInfo) {
		this.rxInfo = rxInfo;
	}

}
