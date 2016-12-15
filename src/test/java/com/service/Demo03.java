package com.service;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.dto.Finance_db_T_st_settlement_log;

/*
 * spring+mybatis
 */
public class Demo03 {
	private SqlSessionFactory sqlSessionFactory;
	@Test
	public void main() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
		sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
		SqlSession session = sqlSessionFactory.openSession();
		String name = session.selectOne("xg.t_crm_xg_order_iAsyncFlag", "1359755");
		System.out.println(name);
		
		int offset = 2; // 要略过的记录的数量
		int limit = 3; // 要返回结果的数量
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<Object, Object> map = session.selectMap("xg.t_st_settlement_log", null, "iAutoID", rowBounds);
		for (Entry<Object, Object> e : map.entrySet()) {
			System.out.println(e.getKey() + "||" + ((Finance_db_T_st_settlement_log) e.getValue()).getsOperationComment());
		}
		System.out.println(map.size());
		session.close();
	}
}
