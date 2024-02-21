package com.employee.management.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorResponse implements ResponseE {
	private int status;
	private String message;
	private String dateTime;

	public ErrorResponse(int status, String message, LocalDateTime dateTime) {
		this.status = status;
		this.message = message;
        this.dateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return dateTime;
	}

	public void setTimestamp(String timestamp) {
		this.dateTime = timestamp;
	}

}