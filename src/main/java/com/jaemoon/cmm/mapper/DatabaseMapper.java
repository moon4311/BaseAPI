package com.jaemoon.cmm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface DatabaseMapper {

  public List<String> tableList();
  public List<Map<String,Object>> columnList(String table);
  
}
