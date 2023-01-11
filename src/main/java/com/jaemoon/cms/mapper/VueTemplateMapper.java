package com.jaemoon.cms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaemoon.cms.model.VueTemplate;

@Mapper
public interface VueTemplateMapper {

	  public List<VueTemplate> selectList(Map<String,Object> map);
	  public VueTemplate selectOne(String id);
	  
	  public int insert(Map<String,Object> map);
	  public int update(Map<String,Object> map);
	  public void delete(Map<String,Object> map);
	  
	  public int selectCnt(Map<String,Object> map);
	  public boolean selectExist(String userId);

}