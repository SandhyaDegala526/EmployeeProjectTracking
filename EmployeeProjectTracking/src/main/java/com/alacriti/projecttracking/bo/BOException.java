package com.alacriti.projecttracking.bo;

import com.alacriti.projecttracking.constants.ErrorConstants;
import com.alacriti.projecttracking.exception.BaseException;

public class BOException extends BaseException {

	private static final long serialVersionUID = 1L;

	public BOException() {
	}

	public BOException(String msg, Throwable th, String errorCode) {
		super(msg, th, errorCode);
	}

	public BOException(Throwable th, String errorCode) {
		this(null, th, errorCode);
	}

	public BOException(String msg, Throwable th) {

		this(msg, th, ErrorConstants.ERR_GENERIC_DAO);
	}

	public BOException(Throwable th) {
		this(null, th, ErrorConstants.ERR_GENERIC_DAO);
	}

	public BOException(String msg, String errorCode) {
		this(msg, null, errorCode);
	}

	public BOException(String msg) {
		this(msg, null, ErrorConstants.ERR_GENERIC_DAO);
	}
}
