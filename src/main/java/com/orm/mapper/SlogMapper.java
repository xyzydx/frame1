package com.orm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dto.Finance_db_T_st_settlement_log;

/**
 * 数据映射器SlogMapper
 */
public interface SlogMapper {
	/*
	 * 1、方法中的@Param("") 可用可不用； 2、使用了多个参数的时候，可以用@Param注解给参数设置名字以区分不同参数，xml文件中sql语句的参数类型为map，通过参数名访问参数对象的属性。如@Param(record),
	 * 可用#{record.id}访问。还可以指定类型，如#{record.id,jdbcType=INTEGER}。
	 */
	@Select("SELECT * FROM  finance_db.t_st_settlement_log  WHERE iAutoID = #{iAutoID}")
	Finance_db_T_st_settlement_log selectBlog(@Param("iAutoID") String iAutoID);

	@Select("select sSettlementCode from finance_db.t_st_settlement_log where iAutoID=#{iAutoID}")
	String selectCode(String iAutoID);

	@Delete("delete from t_st_settlement_log where iAutoID=#{iAutoID}")
	int deleteBlog(@Param("iAutoID") String iAutoID);

	@Insert("insert into t_st_settlement_log (iAutoID,content,owner)  values(#{iAutoID},#{content},#{owner})")
	int insertBlog(@Param("iAutoID") String iAutoID, @Param("content") String content, @Param("owner") String owner);

	@Update("update t_st_settlement_log set content=#{content} ,owner=#{owner}  where iAutoID=#{iAutoID}")
	int updateBlog(Finance_db_T_st_settlement_log log);
}
