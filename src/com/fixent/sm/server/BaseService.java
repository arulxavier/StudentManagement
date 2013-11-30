package com.fixent.sm.server;

public class BaseService {

	public void handleServiceException(Throwable th, String errorCode, String errorData[]) {
		
		if (th instanceof ServerException) {
			
			((ServerException) th).addError(errorCode, errorData);
			throw (ServerException) th;
		} else {
			throw new ServerException(errorCode, null, th);
		}
	}

}
