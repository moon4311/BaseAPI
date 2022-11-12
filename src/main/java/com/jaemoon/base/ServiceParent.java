package com.jaemoon.base;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public abstract class ServiceParent extends RsltCd {

	public final static ObjectMapper om = new ObjectMapper();
	
	public static Map<String,Object> toMap(Object ob) {
		return om.convertValue(ob, Map.class);
	}
	
	public static <T> T toObj(Map<String,Object> map, Class s) {
		return (T) om.convertValue(map, s);
	}
	
	public static boolean isNullPk(Map<String,Object> map, String pk) {
		String val = (String)map.get(pk);
		return val==null || val.equals("");
		
	}
}
