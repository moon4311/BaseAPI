package com.jaemoon.cmm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaemoon.cmm.model.AttachFile;

@Mapper
public interface AttachFileMapper {

	  public List<AttachFile> selectList(Map<String,Object> map);
	  public AttachFile selectOne(String id);
	  
	  public String getSeq();
	  public int insert(Map<String,Object> map);
	  public int update(Map<String,Object> map);
	  public void delete(Map<String,Object> map);
	  
	  public int selectCnt(Map<String,Object> map);
	  public boolean selectExist(String userId);

}