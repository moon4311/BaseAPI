package com.jaemoon.cntnt.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jaemoon.base.BaseServiceIf;
import com.jaemoon.base.CmmRslt;
import com.jaemoon.base.ServiceParent;
import com.jaemoon.base.util.FileUtil;
import com.jaemoon.cmm.mapper.AttachFileMapper;
import com.jaemoon.cmm.model.AttachFile;
import com.jaemoon.cntnt.mapper.BannerMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BannerService extends ServiceParent  implements BaseServiceIf{

	// 수정 1
	private final BannerMapper mapper;

	private final AttachFileMapper fileMapper;

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
	
	@Transactional
	public CmmRslt upsert(List<MultipartFile> fileList,  Map<String, Object> map) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		
		String seq = fileMapper.getSeq();
		map.put("fileSno", seq);
		//배너 입력
		mapper.insert(map);
		
		AttachFile dto = new AttachFile();
		dto.setFileSno(seq);
		dto.setFolderNm("banner");
		AtomicInteger indexHolder = new AtomicInteger();
		fileList.forEach( file ->{
			
			String oNm = file.getOriginalFilename();
			dto.setFileNo( indexHolder.getAndIncrement()  );
			dto.setFileOriginNm(oNm);
			dto.setFileExt(oNm.substring(oNm.lastIndexOf(".")+1));
			dto.setFileSize(file.getSize());
			//파일 생성
			FileUtil.uploadFile(dto, file  );
			//첨부파일 입력
			fileMapper.insert(dto);
		});
		
		return rslt;
	}
	
}
