package com.jaemoon.cmm.service;

import java.util.Map;

import com.jaemoon.base.BaseServiceIf;
import com.jaemoon.base.CmmRslt;
import com.jaemoon.base.ServiceParent;
import com.jaemoon.cmm.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

//@Service
@RequiredArgsConstructor
public class SampleService extends ServiceParent  implements BaseServiceIf{

	// 수정 1
	private final UserMapper mapper;

	// 수정 2	
	private final static String PK = "tablePk";


	@Override
	public int insert(Map<String, Object> map) {
		mapper.insert(map);
		return OK;
	}

	@Override
	public int update(Map<String, Object> map) {
		mapper.update(map);
		return OK;
	}

	@Override
	public int delete(Map<String, Object> map) {
		mapper.delete(map);
		return OK;
	}

	@Override
	public Object selectOne(String id) {
		return mapper.selectOne(id);
	}

	@Override
	public Object selectList(Map<String, Object> map) {
		return mapper.selectList(map);
	}
	
	@Override
	public CmmRslt upsert(Map<String, Object> map) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		if(isNullPk(map,PK)  ) {
			insert(map);
		}else {
			update(map);
		}
		
		return rslt;
	}
	

	
}
