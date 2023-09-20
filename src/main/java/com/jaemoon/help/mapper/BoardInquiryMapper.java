package com.jaemoon.help.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaemoon.help.model.BoardInquiry;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface BoardInquiryMapper {

  public List<BoardInquiry> selectList(Map<String,Object> map);
  public BoardInquiry selectOne(String id);
  
  public int insert(Map<String,Object> map);
  public int update(Map<String,Object> map);
  public void delete(Map<String,Object> map);
  
  public int selectCnt(Map<String,Object> map);
  public boolean selectExist(String userId);
  
}
