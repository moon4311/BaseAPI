package com.jaemoon.base;

import java.util.Map;

public interface BaseServiceIf {

	// 입력
	public int insert(Map<String, Object> map);
	// 수정
	public int update(Map<String, Object> map);
	// 삭제
	public int delete(Map<String, Object> map);

	// 조회
	public Object selectOne(String id);
	public Object selectList(Map<String, Object> map);
	
	public CmmRslt upsert(Map<String, Object> map);
}
