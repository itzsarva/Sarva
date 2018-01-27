package com.sarva.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorContent {

	private int statusCode;
	private String message;
	private String help;

	public ErrorContent() {

	}

	public ErrorContent(int statusCode, String message, String help) {
		this.statusCode = statusCode;
		this.message = message;
		this.help = help;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

}
