package com.conde.msuser.persistence.model;

import lombok.Builder;
import lombok.Data;

/**
 * Simple dto class.
 *
 * @author Luis Conde
 * @datetime 21 mar. 2023, 01:32:32
 */
@Data
@Builder
public class UserDto {
  private String name;
  private String lastName;
  private String email;
  private String note;
}
