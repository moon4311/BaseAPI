package com.jaemoon.cmm.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jaemoon.base.BaseServiceIf;
import com.jaemoon.base.CmmRslt;
import com.jaemoon.base.ServiceParent;
import com.jaemoon.cmm.mapper.MenuMapper;
import com.jaemoon.cmm.model.Menu;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService extends ServiceParent  implements BaseServiceIf{

	private final MenuMapper mapper;

	private final static String PK = "menuId";


	
	public List<Menu> selectTree(){
		return mapper.selectTree();
	}
	
	
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
