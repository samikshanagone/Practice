package com.orosift.userservice.Util;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseData {

	private int code;
	private Object dataObject;

	public static ResponseData create(int code, Object dataObject) {
		return new ResponseData(code, dataObject);
	}

	public static ResponseData create(int code) {
		return new ResponseData(code, null);
	}

}