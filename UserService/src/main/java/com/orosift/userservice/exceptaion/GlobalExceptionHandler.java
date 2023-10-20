package com.orosift.userservice.exceptaion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.orosift.userservice.Util.ResponseData;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseData> handleNotFoundException() {
		ResponseData responseData = ResponseData.create(0);
		return ResponseEntity.ok(responseData);
	}
}