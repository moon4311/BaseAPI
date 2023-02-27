package com.jaemoon.cntnt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaemoon.cntnt.model.Chart;

@Mapper
public interface ChartMapper {

	  public List<Chart> selectList(Map<String,Object> map);
	  public Chart selectOne(String id);
	  
	  public int insert(Map<String,Object> map);
	  public int update(Map<String,Object> map);
	  public void delete(Map<String,Object> map);
	  
	  public int selectCnt(Map<String,Object> map);
	  public boolean selectExist(String userId);

}