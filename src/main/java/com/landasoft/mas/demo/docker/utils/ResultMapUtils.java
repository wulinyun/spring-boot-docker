package com.landasoft.mas.demo.docker.utils;

import java.util.HashMap;
/**
 * 返回结果集工具
 * @author wulinyun
 * 2018年7月23日下午5:35:14
 */
public class ResultMapUtils {
	
	private Integer code=200;
	private String  msg="成功";
	private Object  data = new HashMap<String,Object>();
	
	public ResultMapUtils(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public ResultMapUtils(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ResultMapUtils(Object data) {
		super();
		this.data = data;
	}
	
	public ResultMapUtils() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
