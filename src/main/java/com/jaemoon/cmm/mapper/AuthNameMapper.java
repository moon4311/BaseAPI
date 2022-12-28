package com.jaemoon.cmm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaemoon.cmm.model.AuthName;
import com.jaemoon.cmm.model.Menu;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface AuthNameMapper {

  public List<AuthName> selectTree();
  public List<AuthName> selectList(Map<String,Object> map);
  public Menu selectOne(String id);
  
  public int insert(Map<String,Object> map);
  public int update(Map<String,Object> map);
  public void delete(Map<String,Object> map);
  
  public int selectCnt(Map<String,Object> map);
  public boolean selectExist(String userId);
  
}
