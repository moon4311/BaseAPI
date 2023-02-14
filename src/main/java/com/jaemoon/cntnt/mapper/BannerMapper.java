package com.jaemoon.cntnt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaemoon.cmm.model.Banner;

@Mapper
public interface BannerMapper {

	  public List<Banner> selectList(Map<String,Object> map);
	  public Banner selectOne(String id);
	  
	  public int insert(Map<String,Object> map);
	  public int update(Map<String,Object> map);
	  public void delete(Map<String,Object> map);
	  
	  public int selectCnt(Map<String,Object> map);
	  public boolean selectExist(String userId);

}