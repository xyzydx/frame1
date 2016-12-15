package com.jdbc;

public interface BaseDao {
	public <T> T queryForObject(String statementName, Object parameter);
}
