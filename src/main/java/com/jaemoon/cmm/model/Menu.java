package com.jaemoon.cmm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {

	private String menuId, name, upperMenuId, path,component, useYn;
	private int level, sort;
}
