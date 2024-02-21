package com.employee.management.dto;

import java.time.LocalDateTime;

public class SuccessResponse extends ErrorResponse implements ResponseE{ 

	public SuccessResponse(int status, String message, LocalDateTime dateTime) {
		super(status, message, dateTime);
		// TODO Auto-generated constructor stub
	}

}
