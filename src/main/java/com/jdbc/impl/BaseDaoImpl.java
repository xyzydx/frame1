package com.jdbc.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdbc.BaseDao;

//@Service
public class BaseDaoImpl implements BaseDao {
	@Autowired
	private SqlSession session;

	public <T> T queryForObject(String statementName, Object parameter) {
		return (T) session.selectOne(statementName, parameter);
	}

}
