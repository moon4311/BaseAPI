package com.jaemoon.cntnt.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jaemoon.base.BaseServiceIf;
import com.jaemoon.base.CmmRslt;
import com.jaemoon.base.ServiceParent;
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
	
	public CmmRslt upsert(List<MultipartFile> fileList,  Map<String, Object> map) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		
		String seq = fileMapper.getSeq();
		
		AttachFile dto = new AttachFile();
		dto.setFileSno(seq);
		
		
		//TODO 첨부파일 인서트, 파일 생성
		fileList.forEach( file ->{
			dto.setFileNo(seq);
			dto.setFileNm(file.getName());
			dto.setFileOriginNm(file.getOriginalFilename());
			dto.setFileSize(file.getSize());
			System.err.println(dto);
			File upload = new File("fileName.txt");
			try {
				file.transferTo(upload);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		//TODO 배너 입력
		
		return rslt;
	}
	
}
