package com.icops.DaraManagement.repository;

import com.icops.DaraManagement.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetDao extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
}
