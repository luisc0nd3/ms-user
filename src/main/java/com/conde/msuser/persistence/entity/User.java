package com.conde.msuser.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Simple @Entity class.
 *
 * @author Luis Conde
 * @datetime 21 mar. 2023, 01:00:09
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_user")
public class User {
  
  @Id
  @Column(name = "col_id")
  private String userId;
  
  @Column(name = "col_name", length = 20)
  private String name;
  
  @Column(name = "col_last_name", length = 20)
  private String lastName;
  
  @Column(name = "col_emial", length = 50)
  private String email;
  
  @Column(name = "col_note", length = 100)
  private String note;
  
  @Column(name = "col_creation_date", length = 30)
  private String creationDate;
  
}
