package com.jaemoon.shop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaemoon.shop.model.Product;

@Mapper
public interface ProductMapper {

	  public List<Product> selectList(Map<String,Object> map);
	  public Product selectOne(String id);
	  
	  public int insert(Map<String,Object> map);
	  public int update(Map<String,Object> map);
	  public void delete(Map<String,Object> map);
	  
	  public int selectCnt(Map<String,Object> map);
	  public boolean selectExist(String userId);

}