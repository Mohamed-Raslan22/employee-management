package com.employee.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RequestResponseLog")
public class RequestResponseLog {
    @Id
	@Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name ="REQUEST_ID")
    private String requestId;
    
	@Column(name="REQUEST_URL")
    private String requestUrl;
	
	@Column(name="HTTP_METHOD")
    private String httpMethod;
		
	@Column(name="CLASS_METHOD")
    private String classMethod;
	
    
	@Column(name="RESPONSE")
    private String response;
	
	@Column(name = "STORED_DATE")
	private String date;

	public Long getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RequestResponseLog [id=" + id + ", requestId=" + requestId + ", requestUrl=" + requestUrl
				+ ", httpMethod=" + httpMethod + ", classMethod=" + classMethod + ", response=" + response + ", date="
				+ date + "]";
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getClassMethod() {
		return classMethod;
	}

	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	
    
}