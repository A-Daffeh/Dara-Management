package com.icops.DaraManagement.repository;

import com.icops.DaraManagement.model.Parent;
import com.icops.DaraManagement.model.Student;
import com.icops.DaraManagement.model.enums.Gender;
import com.icops.DaraManagement.model.enums.RecitationLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParentDao extends JpaRepository<Parent, Long> {

    @Query(value = "Select pd.* from person_details pd join student_parents sp on pd.id=sp.parents_id join student s on s.id = sp.kids_id where s.id:=id", nativeQuery = true)
    List<Parent> findByStudent(@Param("id")Long id);

    @Query(value="Select pd.id from person_details pd join student s on pd.id = s.id where last_name:=lastName", nativeQuery = true)
    Long findStudentIdByLastname(@Param("lastName") String lastName);
    List<Parent> findByGender(Gender gender);

}
