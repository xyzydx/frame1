package com.orm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dto.Finance_db_T_st_settlement_log;
import com.orm.SlogService;
import com.orm.mapper.SlogMapper;

public class SlogServiceImpl implements SlogService {
	// 自动注入，这里注入的就是MapperScannerConfiguer 扫描并注册的spring的bean
	@Autowired
	private SlogMapper slogMapper;

	public SlogMapper getSlogMapper() {
		return slogMapper;
	}

	public void setSlogMapper(SlogMapper slogMapper) {
		this.slogMapper = slogMapper;
	}

	public Finance_db_T_st_settlement_log selectBlog(String iAutoID) {
		return slogMapper.selectBlog(iAutoID);
	}

	public String selectCode(String iAutoID) {
		return slogMapper.selectCode(iAutoID);
	}

	public int deleteBlog(String iAutoID) {
		return slogMapper.deleteBlog(iAutoID);
	}

	public int insertBlog(String iAutoID, String content, String owner) {
		return slogMapper.insertBlog(iAutoID, content, owner);
	}

	public int updateBlog(Finance_db_T_st_settlement_log log) {
		return slogMapper.updateBlog(log);
	}

}
