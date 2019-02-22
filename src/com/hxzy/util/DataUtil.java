package com.hxzy.util;

public class DataUtil {
	
	public static final int SUCCESS = 1;  //成功
	public static final int FAIL = 2;  //失败
	
	private int code;//状态码
	private String msg;//信息
	private Object data;//返回的数据
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
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
	public DataUtil(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public DataUtil(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public DataUtil() {
		super();
	}
}
