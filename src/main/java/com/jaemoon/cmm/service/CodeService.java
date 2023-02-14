package com.jaemoon.cmm.service;

import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.jaemoon.base.BaseServiceIf;
import com.jaemoon.base.CmmRslt;
import com.jaemoon.base.ServiceParent;
import com.jaemoon.cmm.mapper.CodeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeService extends ServiceParent  implements BaseServiceIf{

	// 수정 1
	private final CodeMapper mapper;

	// 수정 2	
	private final static String PK = "groupCd";


	@Override
	public int insert(Map<String, Object> map) {
		mapper.insert(map);
		return OK;
	}
	
	public int insertGroup(Map<String, Object> map) {
		mapper.insertGroup(map);
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
	
	public Object selectOptions(String id) {
		return mapper.selectOptions(id);
	}
	
	@Override
	public CmmRslt upsert(Map<String, Object> map) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		try {
			insert(map);
		}catch(DuplicateKeyException e) {
			update(map);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rslt;
	}
	

	
}
