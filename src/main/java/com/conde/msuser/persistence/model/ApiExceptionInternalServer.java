package com.conde.msuser.persistence.model;

import lombok.Builder;
import lombok.Data;

/**
 * Simple dto class.
 *
 * @author Luis Conde
 * @datetime 21 mar. 2023, 14:50:21
 */
@Data
@Builder
public class ApiExceptionInternalServer {
  private String message;
  private String timestamp;
}
