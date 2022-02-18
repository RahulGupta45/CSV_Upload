package com.project.csvupload.controller;

public class ResponseMessage {

	private String message;
	private String fileUri;

	public ResponseMessage(String message, String fileUri) {
		this.message = message;
		this.fileUri = fileUri;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFileUri() {
		return fileUri;
	}

	public void setFiledUri(String fileUri) {
		this.fileUri = fileUri;
	}

}
