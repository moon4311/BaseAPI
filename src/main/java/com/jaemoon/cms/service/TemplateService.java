package com.jaemoon.cms.service;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.jaemoon.base.BaseServiceIf;
import com.jaemoon.base.CmmRslt;
import com.jaemoon.base.ServiceParent;
import com.jaemoon.cms.FileUtil;
import com.jaemoon.cms.mapper.VueTemplateMapper;
import com.jaemoon.cms.model.VueTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TemplateService extends ServiceParent  implements BaseServiceIf{

	// 수정 1
	private final VueTemplateMapper mapper;

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
	
	
	public CmmRslt make(Map<String,String> map) {
//		before
/*		템플릿 내용 조회
		String sno = map.get("sno");
		가공
		String content = ((VueTemplate)selectOne(sno)).getContent();
		for (Entry<String, String> set : map.entrySet() ) {
			content = content.replace( "#{"+set.getKey()+"}", set.getValue() );
		}
		FileUtil.writeVue( map.get("path") , map.get("fileNm") , map.get("content") );
*/
		
//		 after
		FileUtil.writeVue( map.get("path") , map.get("fileNm") , map.get("content") );
		return CmmRslt.getSuccessResult();
	}
	
}
