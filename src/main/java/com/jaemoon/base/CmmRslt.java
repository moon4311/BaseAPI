package com.jaemoon.base;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CmmRslt extends RsltCd {

	   // 응답 성공여부 : true/false
    private boolean success;

    // 응답 코드 번호 : > 0 정상, < 0 비정상
    private int code;

    // 응답 메시지
    private String msg;
    
    private Object data;

    public void setCode(int cd) {
    	success = (cd == OK);
    	code = cd;
    }
    
    // 에러 메시지
//    private List<FieldErrorDetail> errors = new ArrayList<>();
    
    
 // 실패 결과만 처리하는 메소드
    public static CmmRslt getFailResult(int code, String msg ) {
        CmmRslt result = new CmmRslt();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    
    // 성공 결과만 처리하는 메소드
    public static CmmRslt getSuccessResult() {
        CmmRslt result = new CmmRslt();
        result.setSuccessResult();
        return result;
    }
    
    public void setFailResult(int code, String msg ) {
    	this.success = false;
    	this.code = code;
    	this.msg = msg;
    }
    // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
    protected void setSuccessResult() {
        this.success = true;
    	this.code = OK;
    	this.msg = getMsg(OK);
    }
}
