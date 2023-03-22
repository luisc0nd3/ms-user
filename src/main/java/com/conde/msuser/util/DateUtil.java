package com.conde.msuser.util;

import com.conde.msuser.exception.InternalServerException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Simple util class.
 *
 * @author Luis Conde
 * @datetime 21 mar. 2023, 17:44:48
 */
public class DateUtil {

  private DateUtil() {
    throw new InternalServerException("Do not instantiate.");
  }

  /**
   * method that generates the current date with format.
   *
   * @return a date with format 2021-03-24T16:44:39.083+08:00
   */
  public static String getDateNow() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    return simpleDateFormat.format(timestamp);
  }
}
