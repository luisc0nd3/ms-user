package com.conde.msuser.exception;

import com.conde.msuser.persistence.model.ApiExceptionInternalServer;
import com.conde.msuser.persistence.model.ApiExceptionResourceNotFound;
import com.conde.msuser.util.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Simple @RestControllerAdvice class.
 *
 * @author Luis Conde
 * @datetime 21 mar. 2023, 11:47:14
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * method that handles exception ResourceNotFoundException.
   *
   * @param exception from ResourceNotFoundException
   * @return ResponseEntity from ApiResponse
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiExceptionResourceNotFound> handlerResourceNotFoundException(
      ResourceNotFoundException exception) {

    return new ResponseEntity<>(ApiExceptionResourceNotFound.builder().success(true)
        .status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build(),
        HttpStatus.NOT_FOUND);
  }

  /**
   * method that handles exception ResourceNotFoundException.
   *
   * @param exception from ResourceNotFoundException
   * @return ResponseEntity from ApiResponse
   */
  @ExceptionHandler(InternalServerException.class)
  public ResponseEntity<ApiExceptionInternalServer> handlerInternalServerException(
      InternalServerException exception) {

    return new ResponseEntity<>(ApiExceptionInternalServer.builder().message(exception.getMessage())
        .timestamp(DateUtil.getDateNow()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
