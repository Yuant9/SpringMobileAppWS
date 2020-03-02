package com.spring.app.ws.response;

public enum ErrorMessage {
	MISSING_REQUIRED_FILED("Missing required filed."),
	RECORD_ALREADY_EXISTS("Record already exists."),
	INTERNAL_SERVER_ERROR("Internal server error."),
	NO_RECORD_FOUND("No record found."),
	AUTHENTICATION_FAILED("Authentication failed."),
	COULD_NOT_UPDATE_RECORD("Could not update record"),
	COUNT_NOT_DELETE_RECORD("Could not delete record"),
	EMAIL_ADDRESS_NOT_VERIFIED("Email address mot verified.");
	
	
	private String errorMessage;
	
	ErrorMessage(String errorMesage){
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
}
