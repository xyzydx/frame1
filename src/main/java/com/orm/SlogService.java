package com.orm;

import com.dto.Finance_db_T_st_settlement_log;

public interface SlogService {
	public Finance_db_T_st_settlement_log selectBlog(String iAutoID);

	public String selectCode(String iAutoID);

	public int deleteBlog(String iAutoID);

	public int insertBlog(String iAutoID, String content, String owner);

	public int updateBlog(Finance_db_T_st_settlement_log log);
}
