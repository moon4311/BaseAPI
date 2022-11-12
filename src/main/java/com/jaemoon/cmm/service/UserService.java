package com.jaemoon.cmm.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jaemoon.base.BaseServiceIf;
import com.jaemoon.base.CmmRslt;
import com.jaemoon.base.ServiceParent;
import com.jaemoon.cmm.mapper.UserMapper;
import com.jaemoon.cmm.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService extends ServiceParent  implements BaseServiceIf{

	// 수정 1
	private final UserMapper mapper;

	// 수정 2	
	private final static String PK = "userNo";


	/**
	 * 중복 확인
	 * @param userId
	 * @return
	 */
	public boolean existChk(String userId) {
		return mapper.selectExist(userId);
	}

	/**
	 * 회원가입
	 * @param map
	 * @return
	 */
	public int join(User user) {
		return insert(toMap(user));
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
	public List<User> selectList(Map<String, Object> map) {
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
