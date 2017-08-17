package com.alacriti.projecttracking.datasource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.alacriti.projecttracking.util.ExceptionUtil;


public final class MySqlDataSource {

	private static MySqlDataSource ms_this = null;
	private static DataSource dbSource = null;

	private MySqlDataSource() {
		init();
	}

	protected void init() {
		initialize();
	}

	public static MySqlDataSource getInstance() {
		synchronized (MySqlDataSource.class) {
			if (ms_this == null) {
				synchronized (MySqlDataSource.class) {
					ms_this = new MySqlDataSource();
				}
			}
		}

		return ms_this;
	}

	protected void initialize() {
		try {
			if (dbSource == null) {
				System.out.println("DataSource  looking up URL " + "java:jboss/datasources/TRAINEE");
				InitialContext aInitialContext = new InitialContext();
				dbSource = (DataSource) aInitialContext.lookup("java:jboss/datasources/TRAINEE");

				System.out.println("DataSource dbSource was null and was successfully setup by looking up URL "
						+ "java:jboss/datasources/TRAINEE");
			}
		} catch (NamingException e) {
			System.out.println("NamingException in initialize " + e);
		} catch (Exception e) {
			System.out.println("Exception in initialize " +  e);
		}
	}

	public Connection getConnection() {
		try {
			Connection dbCon = dbSource.getConnection();
			dbCon.setAutoCommit(false);
			return dbCon;
		} catch (Exception e) {
			System.out.println("Exception in getConnection " +  e);
		}
		return null;
	}

	private static final Map<String, String> openConnIdMap = new HashMap<String, String>();
	private static final boolean isConneLeakChkEnabled = true;// connLog.isInfoEnabled();
	private static final Object connLeakVarlock = new Object();

	static class Handler implements InvocationHandler {

		Connection conn;
		String id;

		public Handler(Connection conn) {
			this.conn = conn;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			try {
				if (method.getName().equalsIgnoreCase("close")) {
					synchronized (connLeakVarlock) {
						totalClosedConnCnt--;
						connOpenedNow--;
						openConnIdMap.remove(this.getId());
						String localStackTrace = ExceptionUtil
								.getStackTrace(new Exception("No Problem in this exception.")).replaceAll("\\n", "");
						if (localStackTrace.length() > 500) {
							localStackTrace = localStackTrace.substring(0, 499);
						}
						System.out.println("::Connection returned:" + totalOpenConnCnt + "::" + (-totalClosedConnCnt) + ">"
								+ connOpenedNow + ":\n" + localStackTrace);

					}
				}
				return method.invoke(conn, args);
			} catch (InvocationTargetException e) {

				System.out.println("InvocationTargetException in invoke " +  e);

				throw e.getTargetException();
			}
		}
	}

	private static int totalOpenConnCnt = 0;
	private static int totalClosedConnCnt = 0;
	private static int connOpenedNow = 0;

	public static void printConnectionLeakTrace() {

		if (openConnIdMap.size() > 0) {
			for (Map.Entry<String, String> entry : openConnIdMap.entrySet()) {
				System.out.println(
						"No Problem in this exception. ConnId:" + entry.getKey() + " :: Trace :" + entry.getValue());
			}
		}
		System.out.println("printConnectionLeakTrace(): End");

	}
}

