package com.alacriti.projecttracking.bo;

import java.sql.Connection;

public class BaseBO {
	private Connection conn = null;

	public BaseBO() {
	}

	public BaseBO(Connection connection) {
		this.conn = connection;
	}

	public Connection getConnection() {
		return conn;
	}

	public void setConnection(Connection connection) {
		this.conn = connection;
	}
}
