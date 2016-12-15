package com.service;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/*
 * testng+spring+mybatis结合
 */
@ContextConfiguration(locations = { "classpath:Application.xml" })
public class Demo04 extends AbstractTestNGSpringContextTests {
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	@Resource
	private User user;
	@Test
	public void main() {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			String name = session.selectOne("xg.t_crm_xg_order_iAsyncFlag", "1359756");
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		user.showName("heihe");
	}

	@Test
	public void m2() {
		System.out.println("this is test method 2======");
	}
}
