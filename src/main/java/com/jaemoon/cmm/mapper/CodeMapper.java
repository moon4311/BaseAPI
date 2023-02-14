package com.jaemoon.cmm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaemoon.cmm.model.Code;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface CodeMapper {

  public List<Code> selectList(Map<String,Object> map);
  public Code selectOne(String id);
  public List<Code> selectOptions(String id);
  
  public int insertGroup(Map<String,Object> map);
  public int insert(Map<String,Object> map);
  public int update(Map<String,Object> map);
  public void delete(Map<String,Object> map);
  
  public int selectCnt(Map<String,Object> map);
  public boolean selectExist(String userId);
  
}
