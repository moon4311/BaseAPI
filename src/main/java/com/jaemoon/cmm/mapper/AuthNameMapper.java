package com.jaemoon.cmm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaemoon.cmm.model.AuthName;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface AuthNameMapper {

  public List<AuthName> selectList(Map<String,Object> map);
  public AuthName selectOne(String id);
  
  public int insert(Map<String,Object> map);
  public int update(Map<String,Object> map);
  public void delete(Map<String,Object> map);
  
  public int selectCnt(Map<String,Object> map);
  public boolean selectExist(String userId);
  
}
