package com.user.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.exception.UserException;

import lombok.extern.java.Log;

@RestControllerAdvice
@Log
public class UserAdviceController {
	
	private static final String CODE = "code";
	private static final String STATUS = "status";
	private static final String TIMESTAMP = "timestamp";
	private static final String STATUSMESSAGE = "statusMessage";

	@ExceptionHandler(UserException.class)
    public ResponseEntity<Object> exception02(
    		Exception ex) {
		log.log(Level.SEVERE,ex.getMessage(), ex);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(CODE, HttpStatus.UNAUTHORIZED.value());
        body.put(STATUS, false);
        body.put(TIMESTAMP,LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        body.put(STATUSMESSAGE, "Unauthorized");
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
	
}
