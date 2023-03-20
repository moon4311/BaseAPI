package com.jaemoon.cms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DevMapper {

	  public List<Map<String,Object>> selectList(Map<String,Object> map);
//	  public Map<String,Object> selectOne(String id);
	  public Map<String,Object> selectOne(Map<String,Object> map);
	  
	  public int insert(Map<String,Object> map);
	  public int update(Map<String,Object> map);
	  public void delete(Map<String,Object> map);
	  
	  public int selectCnt(Map<String,Object> map);
	  public boolean selectExist(String userId);

}