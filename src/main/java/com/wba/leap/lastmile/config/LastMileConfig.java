package com.wba.leap.lastmile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
	@PropertySource("classpath:LastMile.properties")
})
public class LastMileConfig{
	@Value( "${lastMile.eligibleLastMileUrl}" )
	private String eligibleLastMileUrl;
	@Value( "${lastMile.fulfillmentTimeUrl}" )
	private String fulfillmentTimeUrl;
	@Value( "${lastMile.productAvailabilityUrl}" )
	private String productAvailabilityUrl;	
	@Value( "${lastMile.connectionTimeout}" )
	private String connectionTimeout;
	@Value( "${lastMile.requestTimeout}" )
	private String requestTimeOut;
	@Value( "${lastMile.httpHeader.Content-Type}" )
	private String contentType;
	@Value( "${lastMile.httpHeader.Accept}" )
	private String accept;
	@Value( "${lastMile.httpHeader.Method}" )
	private String method;
	@Value( "${lastMile.httpHeader.subscriptionKey}" )
	private String subscriptionKey;
	
	public String getFulfillmentTimeUrl() {
		return fulfillmentTimeUrl;
	}
	public void setFulfillmentTimeUrl(String fulfillmentTimeUrl) {
		this.fulfillmentTimeUrl = fulfillmentTimeUrl;
	}
	public String getProductAvailabilityUrl() {
		return productAvailabilityUrl;
	}
	public void setProductAvailabilityUrl(String productAvailabilityUrl) {
		this.productAvailabilityUrl = productAvailabilityUrl;
	}
	public String getEligibleLastMileUrl() {
		return eligibleLastMileUrl;
	}
	public void setEligibleLastMileUrl(String eligibleLastMileUrl) {
		this.eligibleLastMileUrl = eligibleLastMileUrl;
	}
	public String getConnectionTimeOut() {
		return connectionTimeout;
	}
	public void setConnectionTimeOut(String connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	public String getRequestTimeOut() {
		return requestTimeOut;
	}
	public void setRequestTimeOut(String requestTimeOut) {
		this.requestTimeOut = requestTimeOut;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getSubscriptionKey() {
		return subscriptionKey;
	}
	public void setSubscriptionKey(String subscriptionKey) {
		this.subscriptionKey = subscriptionKey;
	}
	
}
