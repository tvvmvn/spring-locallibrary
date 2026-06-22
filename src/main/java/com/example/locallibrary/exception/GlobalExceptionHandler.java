package com.example.locallibrary.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String resourceNotFoundHandler(IllegalArgumentException e, Model model) {

    logger.error("잘못된 요청 발생! ", e);

    model.addAttribute("status", HttpStatus.BAD_REQUEST.value());
    model.addAttribute("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
    model.addAttribute("message", e.getMessage());

    return "error";
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleAllException(Exception e, Model model) {

    logger.error("서버 오류 발생! ", e);
    
    model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    model.addAttribute("error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    model.addAttribute("message", "나중에 다시 시도하세요.");
    
    return "error"; 
  }
}
