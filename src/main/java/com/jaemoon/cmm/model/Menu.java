package com.jaemoon.cmm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {

	private String menuId, menuNm, upperMenuId, url, useYn;
	private int level, sort;
}
