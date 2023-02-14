package com.jaemoon.cmm.model;

import com.jaemoon.base.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttachFile extends BaseModel{

	private String fileSno, fileNo;
	private String fileOriginNm;
	private String folderNm, fileNm, fileExt;
	private long fileSize;
	
}
