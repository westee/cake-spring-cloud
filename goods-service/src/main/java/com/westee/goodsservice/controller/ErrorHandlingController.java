package com.westee.goodsservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.westee.common.entity.Response;
import com.westee.common.exception.HttpException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandlingController {
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(HttpException.class)
    public @ResponseBody
    Response<?> onError(HttpServletResponse response, HttpException e) {
        response.setStatus(e.getStatusCode());
        return Response.of(e.getMessage(), null);
    }

    /**
     * 处理上传文件大小报错
     * @param e    文件上传报错
     * @return     ResponseEntity的报错信息
     * @throws JsonProcessingException  objectMapper的可能报错
     */
    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<String> handleMultipartException(MultipartException e) throws JsonProcessingException {
        Response<Object> response = Response.of("文件大小超过限制", null);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
    }

    /**
     * 处理spring validation的验证报错
     * @param ex   exception
     * @return     ResponseEntity的报错信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidException(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage
        ).collect(Collectors.joining(","));

        Response<Object> response = Response.of(msg, null);
        String s = null;
        try {
            s = objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            throw HttpException.badRequest("序列化validation的报错信息失败，请联系admin");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
    }

}