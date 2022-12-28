package com.jaemoon.cmm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaemoon.cmm.model.AuthGrant;
import com.jaemoon.cmm.model.Menu;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface AuthGrantMapper {

  public List<AuthGrant> selectTree();
  public List<AuthGrant> selectList(Map<String,Object> map);
  public Menu selectOne(String id);
  
  public int insert(Map<String,Object> map);
  public int update(Map<String,Object> map);
  public void delete(Map<String,Object> map);
  
  public int selectCnt(Map<String,Object> map);
  public boolean selectExist(String userId);
  
}
