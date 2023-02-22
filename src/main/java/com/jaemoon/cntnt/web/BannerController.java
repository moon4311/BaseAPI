
package com.jaemoon.cntnt.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartRequest;

import com.jaemoon.base.CmmRslt;
import com.jaemoon.cntnt.service.BannerService;

@RestController
@RequestMapping("/banner")
public class BannerController {

	@Resource
	private BannerService service;
	
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
	
	@PostMapping("/save")
//	public CmmRslt save(@RequestBody Map<String,Object> map) {
	public CmmRslt save(MultipartRequest multipart, HttpServletRequest req) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("bannerNm", req.getParameter("bannerNm"));
		map.put("width", req.getParameter("width"));
		map.put("height", req.getParameter("height"));
		map.put("startDt", req.getParameter("startDt"));
		map.put("endDt", req.getParameter("endDt"));
		map.put("useYn", req.getParameter("useYn"));
		
		service.upsert( multipart.getFiles("files") , map );
		
//		rslt.setData( service.upsert(map) );
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
	
	@PostMapping("/del")
	public CmmRslt delete(@RequestBody Map<String,Object> map) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( service.delete(map) );
		return rslt;
	}
}
