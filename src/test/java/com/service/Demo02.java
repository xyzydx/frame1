package com.service;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * mybatis
 */
public class Demo02 {
	public static void main(String[] args) throws Exception {
		//mybatis鐨勯厤缃枃浠�
		String resource = "mybatis.xml";
	    //浣跨敤绫诲姞杞藉櫒鍔犺浇mybatis鐨勯厤缃枃浠讹紙瀹冧篃鍔犺浇鍏宠仈鐨勬槧灏勬枃浠讹級
	    InputStream is = Demo02.class.getClassLoader().getResourceAsStream(resource);
	    //鏋勫缓sqlSession鐨勫伐鍘�
	    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	    //浣跨敤MyBatis鎻愪緵鐨凴esources绫诲姞杞絤ybatis鐨勯厤缃枃浠讹紙瀹冧篃鍔犺浇鍏宠仈鐨勬槧灏勬枃浠讹級
	    //Reader reader = Resources.getResourceAsReader(resource); 
	    //鏋勫缓sqlSession鐨勫伐鍘�
	    //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	    //鍒涘缓鑳芥墽琛屾槧灏勬枃浠朵腑sql鐨剆qlSession
	    SqlSession session = sessionFactory.openSession();
		String name = session.selectOne("xg.t_crm_xg_order_iAsyncFlag", "1359755");
		System.out.println(name);
		session.close();
	}
}
