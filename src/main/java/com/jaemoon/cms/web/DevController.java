
package com.jaemoon.cms.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaemoon.base.CmmRslt;
import com.jaemoon.cms.service.DevService;

@RestController
@RequestMapping("/dev")
public class DevController {

	@Resource
	private DevService service;
	
	@GetMapping("/{tblNm}/list")
	public CmmRslt getList(@RequestParam Map<String,Object> map, @PathVariable(name="tblNm")  String tblNm) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		map.put("tblNm", tblNm);
		
		List<String> whereList = new ArrayList<String>();
		map.entrySet().forEach(
				o-> {
					if(!o.getKey().equals("tblNm") ) {
						whereList.add(o.getKey()+"='"+o.getValue()+"'");
					}
				}
		);
		map.put("whereList", whereList);
		rslt.setData( service.selectList(map));
		return rslt;
	}
	
	@GetMapping("/{tblNm}/info")
	public CmmRslt getInfo(@PathVariable(name="tblNm") String tblNm, @RequestParam Map<String,Object> map ) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		map.put("tblNm", tblNm);
		
		String pk = map.keySet().iterator().next();
		map.put("PK", pk );
		map.put("PK_VALUE", map.get(pk));
		
		rslt.setData( service.selectOne(map) );
		return rslt;
	}
	
	@PostMapping("/{tblNm}/save")
	public CmmRslt save(@RequestBody Map<String,Object> map , @PathVariable(name="tblNm")  String tblNm) {
		List<String> keyList = new ArrayList<String>();
		List<Object> valueList = new ArrayList<Object>();
		
		map.entrySet().forEach(
				o-> {
					if(!o.getKey().equals("PK") && !o.getKey().equals( map.get("PK") )  ) {
						keyList.add(o.getKey());
						valueList.add(o.getValue());
					}
				}
		);
		map.put("tblNm", tblNm);
		map.put("keyList", keyList);
		map.put("valueList", valueList);
		
		return service.upsert(map) ;
	}
	

	
	@PostMapping("/{tblNm}/info")
	public CmmRslt insert(@RequestBody Map<String,Object> map , @PathVariable(name="tblNm")  String tblNm) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( service.insert(map) );
		return rslt;
	}
	
	@PutMapping("/{tblNm}/info")
	public CmmRslt update(@RequestBody Map<String,Object> map , @PathVariable(name="tblNm")  String tblNm) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( service.update(map) );
		return rslt;
	}
	
	@PostMapping("/{tblNm}/del")
	public CmmRslt delete(@RequestBody Map<String,Object> map , @PathVariable(name="tblNm")  String tblNm) {
		CmmRslt rslt = CmmRslt.getSuccessResult();
		rslt.setData( service.delete(map) );
		return rslt;
	}
}
