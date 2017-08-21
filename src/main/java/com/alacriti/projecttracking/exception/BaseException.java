package com.alacriti.projecttracking.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import com.alacriti.projecttracking.constants.Constants;
import com.alacriti.projecttracking.constants.ErrorConstants;
import com.alacriti.projecttracking.util.StringUtil;

public class BaseException extends Exception {

	private static final long serialVersionUID = -9152390369438386303L;
	protected Throwable m_innerException;
	protected String m_message = Constants.EMPTY_STRING;
	protected String m_errorCode = ErrorConstants.ERR_GENERIC;

	protected BaseException() {
	}

	public BaseException(String msg, Throwable th, String errorCode) {
		super(StringUtil.noNullTrim(msg), th);
		setErrorCode(errorCode);
	}

	public String getErrorCode() {
		return m_errorCode;
	}

	@Override
	public String getMessage() {
		return m_message;
	}

	public Throwable getThrowable() {
		return getCause();
	}

	protected void setErrorCode(String errorCode) {
		m_errorCode = StringUtil.noNullTrim(errorCode);
	}

	public String returnStackTrace() {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		this.printStackTrace(printWriter);
		return result.toString();
	}
}
