package com.conde.msuser.persistence.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Simple dto class.
 *
 * @author Luis Conde
 * @datetime 21 mar. 2023, 11:43:24
 */
@Data
@Builder
public class ApiExceptionResourceNotFound {
  private String message;
  private boolean success;
  private HttpStatus status;
}
