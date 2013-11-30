package com.fixent.sm.server;

import java.util.ArrayList;
import java.util.List;

public class ServerException extends RuntimeException {

	private static final long serialVersionUID = 0x19c52b9L;
	private String errorCode;
	private String errorData[];
	private List errorCodes;
	private List errorDatas;

	public ServerException(String errCode, String errData[], String message) {
		super(message);
		errorCode = errCode;
		errorData = errData;
	}

	public ServerException(String errCode, String errData[], String message,
			Throwable cause) {
		super(message, cause);
		errorCode = errCode;
		errorData = errData;
	}

	public ServerException(List errCodes, List errDatas, String message) {
		super(message);
		errorCodes = errCodes;
		errorDatas = errDatas;
	}

	public ServerException(List errCodes, List errDatas, String message,
			Throwable cause) {
		super(message, cause);
		errorCodes = errCodes;
		errorDatas = errDatas;
	}

	public ServerException(String errCode, String errData[]) {
		errorCode = errCode;
		errorData = errData;
	}

	public ServerException(String errCode, String errData[], Throwable cause) {
		super(cause);
		errorCode = errCode;
		errorData = errData;
	}

	public ServerException(List errCodes, List errDatas) {
		errorCodes = errCodes;
		errorDatas = errDatas;
	}

	public ServerException(List errCodes, List errDatas, Throwable cause) {
		super(cause);
		errorCodes = errCodes;
		errorDatas = errDatas;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errCode) {
		errorCode = errCode;
	}

	public String[] getErrorData() {
		return errorData;
	}

	public List getErrorCodes() {
		return errorCodes;
	}

	public List getErrorDatas() {
		return errorDatas;
	}

	public void setErrorData(String errData[]) {
		errorData = errData;
	}

	public void setErrorCodes(List errCodes) {
		errorCodes = errCodes;
	}

	public void setErrorDatas(List errDatas) {
		errorDatas = errDatas;
	}

	public void addError(String errCode, String errData[]) {
		if (errorCodes == null) {
			errorCodes = new ArrayList(1);
		}
		if (errorDatas == null) {
			errorDatas = new ArrayList(1);
		}
		errorCodes.add(errCode);
		errorDatas.add(errData);
	}

	public void addErrors(List errCodes, List errDatas) {
		if (errorCodes == null) {
			errorCodes = new ArrayList(1);
		}
		if (errorDatas == null) {
			errorDatas = new ArrayList(1);
		}
		errorCodes.addAll(errCodes);
		errorDatas.addAll(errDatas);
	}
}
