package com.fixent.sm.server;

public enum ErrorCode {
	
	CAN_NOT_FETCH_SUBJECT_CATEGORIES("ERR.001"),
	
	SUBJECT_CATEGORY_NAME_SHOULD_NOT_EMPTY("ERR.003"),
	
	CAN_NOT_FETCH_SUBJECTS("ERR.002");
	
	 private final  String _errorCode;

	    private ErrorCode(String code) {
	        _errorCode = code;
	    }

	    @Override
	    public String toString() {

	        return _errorCode;
	    }

}
