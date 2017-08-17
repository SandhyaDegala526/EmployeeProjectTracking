package com.alacriti.projecttracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseDAO {
	public Long auditEventTransactiondId;
	public int auditEventId;
	private Connection conn;

	public BaseDAO() {

	}

	public BaseDAO(Connection _connection) {
		this.conn = _connection;

	}

	public Connection getConnection() {
		return conn;
	}

	public void setConnection(Connection connection) {
		this.conn = connection;
	}

	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("Exception in close " +  e);
			}
		}
	}

	public void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				System.out.println("Exception in close " +  e);
			}
		}
	}

	public void close(PreparedStatement stmt, ResultSet rs) {
		close(stmt);
		close(rs);

	}

	protected PreparedStatement getPreparedStatement(Connection connection, String sqlCmd) throws SQLException {


		try {

			return connection.prepareStatement(sqlCmd);
		} catch (SQLException e) {
			System.out.println("SQLException in getPreparedStatement " +  e);
			throw e;
		}
	}

	protected PreparedStatement getPreparedStatementReturnPK(Connection connection, String sqlCmd) throws SQLException {

		try {

			return connection.prepareStatement(sqlCmd, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			System.out.println("Exception in getPreparedStatementReturnPK " +  e);
			throw e;
		}
	}

	protected ResultSet executeQuery(PreparedStatement ps) throws SQLException {

		try {

			return ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("SQLException in executeQuery " +  e);
			throw e;
		}
	}

	protected int executeUpdate(PreparedStatement ps) throws SQLException {

		try {

			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException in executeUpdate " +  e);
			throw e;
		} finally {
			close(ps);
		}
	}

		
}
