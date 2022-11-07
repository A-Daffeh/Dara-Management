package com.icops.DaraManagement.repository;

import com.icops.DaraManagement.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenDao extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
