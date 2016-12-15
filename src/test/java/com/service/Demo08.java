package com.service;

import javax.annotation.Resource;

import org.testng.annotations.Test;

import com.dto.Finance_db_T_st_settlement_log;
import com.orm.SlogService;

/*
 * mybatis采用数据映射器（MapperFactoryBean）的方式，不用写mybatis映射文件，采用注解方式提供相应的sql语句和输入参数
 * 1、见接口SlogMapper、SlogService、SlogServiceImpl
 * 2、通过MapperScannerConfiguer 扫描来实现 映射器 见sqlSession.xml
 */
public class Demo08 extends BaseCase {
	@Resource
	private SlogService slogService;

	@Test
	public void Test01() {
		Finance_db_T_st_settlement_log log = slogService.selectBlog("595");
		System.out.println(log.getsOperationComment());
		System.out.println(slogService.selectCode("593"));
	}

}
