package com.icops.DaraManagement.repository;

import com.icops.DaraManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long> {
}
