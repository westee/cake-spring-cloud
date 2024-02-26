package com.westee.authservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.westee.authservice.entity.Response;
import com.westee.authservice.exceptions.HttpException;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandlingController {
    ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(HttpException.class)
    public @ResponseBody
    Response<?> onError(HttpServletResponse response, HttpException e) {
        response.setStatus(e.getStatusCode());
        return Response.of(e.getMessage(), null);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public @ResponseBody
    Response<?> onMissingRequestHeader(HttpServletResponse response, MissingRequestHeaderException e) {
        return Response.of(e.getMessage(), null);
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<String> handleMultipartException(MultipartException e) throws JsonProcessingException {
        Response<Object> response = Response.of("文件大小超过限制", null);
        String s = objectMapper.writeValueAsString(response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<String> handleAuthException(AuthorizationException ex) throws JsonProcessingException {
        Response<Object> response = Response.of("没有授权进行此操作", null);
        String s = objectMapper.writeValueAsString(response);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(s);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidException(MethodArgumentNotValidException ex) throws JsonProcessingException {
        String msg = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage
        ).collect(Collectors.joining(","));

        Response<Object> response = Response.of(msg, null);
        String s = objectMapper.writeValueAsString(response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
    }
}
