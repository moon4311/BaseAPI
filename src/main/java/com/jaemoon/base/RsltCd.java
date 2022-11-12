package com.jaemoon.base;

public class RsltCd {

	public final static int FAIL = 0;
	public final static int OK = 1;
	
	public final static String getMsg(int cd) {
		switch (cd) {
		case OK:
			return "OK";
		case FAIL:
			return "FAIL";

		default:
			return "UNREGISTED ERROR";
		}
	}
}
