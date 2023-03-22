package com.conde.msuser.service.impl;

import com.conde.msuser.exception.InternalServerException;
import com.conde.msuser.exception.ResourceNotFoundException;
import com.conde.msuser.persistence.entity.User;
import com.conde.msuser.persistence.model.UserDto;
import com.conde.msuser.persistence.repository.UserRepository;
import com.conde.msuser.service.BaseService;
import com.conde.msuser.util.DateUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Simple @Configuration class.
 *
 * @author Luis Conde
 * @datetime 21 mar. 2023, 01:19:20
 */
@RequiredArgsConstructor
@Log4j2
@Service
public class UserService implements BaseService<User, UserDto> {

  private final UserRepository repository;

  @Override
  public List<User> findAll() throws SQLException {
    return repository.findAll();
  }

  @Override
  public User findById(String id) throws SQLException {
    if (id.isBlank()) {
      throw new ResourceNotFoundException(
          "The user id does not comply with the established format");
    }

    return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User Not Found With ID: " + id));
  }

  @Override
  public User save(UserDto userDto) throws SQLException {
    log.info("===== Start save method. =====");

    try {
      User userEntity = User.builder().userId(UUID.randomUUID().toString())
          .creationDate(DateUtil.getDateNow()).email(userDto.getEmail())
          .lastName(userDto.getLastName()).name(userDto.getName()).note(userDto.getNote()).build();

      log.info("===== Save entity... =====");
      return repository.save(userEntity);
    } catch (Exception e) {
      throw new InternalServerException(e.getMessage());
    }

  }

  @Override
  public boolean delete(String id) throws SQLException {
    log.info("===== Start delete method. =====");

    if (id == null || id.isBlank()) {
      throw new ResourceNotFoundException("User Not Found With ID: " + id);
    }

    repository.deleteById(id);
    log.info("===== Delete entity... =====");
    return true;
  }

}
