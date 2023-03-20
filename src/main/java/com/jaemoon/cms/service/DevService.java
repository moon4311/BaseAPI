package com.jaemoon.cms.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jaemoon.base.BaseServiceIf;
import com.jaemoon.base.CmmRslt;
import com.jaemoon.base.ServiceParent;
import com.jaemoon.cms.mapper.DevMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DevService extends ServiceParent  implements BaseServiceIf{

	// 수정 1
	private final DevMapper mapper;

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
//		return mapper.selectOne(id);
		return null;
	}
	
	public Object selectOne(Map<String, Object> map) {
		return mapper.selectOne(map);
	}
	
	@Override
	public Object selectList(Map<String, Object> map) {
		return mapper.selectList(map);
	}
	
	@Override
	public CmmRslt upsert(Map<String, Object> map) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		if(isNullPk(map, (String)map.get("PK") )  ) {
			insert(map);
		}else {
			update(map);
		}
		return rslt;
	}
	
}
