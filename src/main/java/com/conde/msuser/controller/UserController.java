package com.conde.msuser.controller;

import com.conde.msuser.exception.InternalServerException;
import com.conde.msuser.persistence.entity.User;
import com.conde.msuser.persistence.model.UserDto;
import com.conde.msuser.service.impl.UserService;
import com.conde.msuser.util.Constans;
import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple @RestController class.
 *
 * @author Luis Conde
 * @datetime 21 mar. 2023, 12:11:28
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

  private final UserService service;

  /**
   * method that saves a user.
   *
   * @param userDto from UserDto
   * @return ResponseEntity from User
   */
  @PostMapping
  public ResponseEntity<User> save(@RequestBody UserDto userDto) {
    User user;
    try {
      user = service.save(userDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(user);

    } catch (Exception e) {
      e.printStackTrace();
      throw new InternalServerException(Constans.SERVER_SAY + e.getMessage());
    }
  }

  /**
   * method that find a user by Id.
   *
   * @param id like String
   * @return ResponseEntity from User
   */
  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable String id) {
    User user;
    try {
      user = service.findById(id);
      return ResponseEntity.ok(user);

    } catch (Exception e) {
      e.printStackTrace();
      throw new InternalServerException(Constans.SERVER_SAY + e.getMessage());
    }
  }

  /**
   * method that find all users.
   *
   * @return ResponseEntity from User
   */
  @GetMapping()
  public ResponseEntity<List<User>> findAll() {
    List<User> user;
    try {
      user = service.findAll();
      return ResponseEntity.ok(user);

    } catch (Exception e) {
      e.printStackTrace();
      throw new InternalServerException(Constans.SERVER_SAY + e.getMessage());
    }
  }

  /**
   * method that delete a user by Id.
   *
   * @param id like String
   * @return ResponseEntity with boolean class
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable String id) {
    try {
      return ResponseEntity.ok(service.delete(id));
    } catch (SQLException e) {
      e.printStackTrace();
      throw new InternalServerException(Constans.SERVER_SAY + e.getMessage());
    }
  }

}
