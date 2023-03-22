package com.conde.msuser.exception;

/**
 * Simple RuntimeException class.
 *
 * @author Luis Conde
 * @datetime 21 mar. 2023, 14:45:46
 */
public class InternalServerException extends RuntimeException {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = 4053227993966756625L;

  public InternalServerException() {
    super("Internal Server Error.");
  }

  public InternalServerException(String message) {
    super(message);
  }

  
}
