package com.icops.DaraManagement.repository;

import com.icops.DaraManagement.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentDao extends JpaRepository<Parent, Long> {
}
