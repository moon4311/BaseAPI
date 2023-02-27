package com.jaemoon.cmm.model;

import com.jaemoon.base.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Banner extends BaseModel {
	
	private String bannerSno, bannerNm;
	private String width, height;
	
}
