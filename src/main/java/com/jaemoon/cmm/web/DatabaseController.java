package com.jaemoon.cmm.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaemoon.base.CmmRslt;
import com.jaemoon.cmm.mapper.DatabaseMapper;

@RestController
@RequestMapping("/db")
public class DatabaseController {

	@Resource
	private DatabaseMapper mapper;
	
	@GetMapping("/table")
	public CmmRslt getTables() {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( mapper.tableList());
		return rslt;
	}
	
	@GetMapping("/column")
	public CmmRslt getColumns(@RequestParam String table) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( mapper.columnList(table));
		return rslt;
	}
	
}
