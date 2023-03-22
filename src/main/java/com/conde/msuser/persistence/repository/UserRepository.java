package com.conde.msuser.persistence.repository;

import com.conde.msuser.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Simple @Repository class.
 *
 * @author Luis Conde
 * @datetime 21 mar. 2023, 00:58:23
 */
public interface UserRepository extends JpaRepository<User, String> {

}
