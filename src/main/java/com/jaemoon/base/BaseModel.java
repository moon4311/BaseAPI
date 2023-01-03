package com.jaemoon.base;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {

	private String useYn;
	private Date registDt, updateDt;
	private String registId, updateId;
	
}
