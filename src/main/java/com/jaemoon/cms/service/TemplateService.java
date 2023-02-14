package com.jaemoon.cms.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.jaemoon.base.BaseServiceIf;
import com.jaemoon.base.CmmRslt;
import com.jaemoon.base.ServiceParent;
import com.jaemoon.base.util.FileUtil;
import com.jaemoon.cms.mapper.FileTemplateMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TemplateService extends ServiceParent  implements BaseServiceIf{

	// 수정 1
	private final FileTemplateMapper mapper;

	// 수정 2	
	private final static String PK = "sno";


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
	
	
	public CmmRslt makeVue(Map<String,String> map) {
		FileUtil.writeVue( map.get("path") , map.get("fileNm") , map.get("content") );
		return CmmRslt.getSuccessResult();
	}
	public CmmRslt makeMapper(Map<String,String> map) {
		FileUtil.writeMapper( map.get("path") , map.get("fileNm") , map.get("content") );
		return CmmRslt.getSuccessResult();
	}
	
}
