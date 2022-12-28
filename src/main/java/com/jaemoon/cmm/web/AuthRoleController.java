package com.jaemoon.cmm.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaemoon.base.CmmRslt;
import com.jaemoon.cmm.service.AuthRoleService;

@RestController
@RequestMapping("/authRole")
public class AuthRoleController {

	@Resource
	private AuthRoleService service;
	
	@GetMapping("/list")
	public CmmRslt getList(@RequestParam Map<String,Object> map) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( service.selectList(map));
		return rslt;
	}
	
	@GetMapping("/info/{id}")
	public CmmRslt getInfo(@PathVariable(name = "id") String id) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( service.selectOne(id) );
		return rslt;
	}
	@PostMapping("/info")
	public CmmRslt insert(@RequestBody Map<String,Object> map) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( service.insert(map) );
		return rslt;
	}
	
	@PutMapping("/info")
	public CmmRslt update(@RequestBody Map<String,Object> map) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( service.update(map) );
		return rslt;
	}
	
	@DeleteMapping("/info")
	public CmmRslt delete(@RequestBody Map<String,Object> map) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( service.delete(map) );
		return rslt;
	}
}
