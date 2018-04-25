package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.HomeworkDeleting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeworkDeletingRepository extends JpaRepository<HomeworkDeleting,Integer> {
    @Query(value = "SELECT id,pics FROM homework WHERE TIMESTAMPDIFF(DAY,date,CURRENT_TIMESTAMP) >=7",nativeQuery = true)
    List<HomeworkDeleting> findTimeoutList();

    @Modifying
    @Query(value = "DELETE FROM homework WHERE TIMESTAMPDIFF(DAY,date,CURRENT_TIMESTAMP) >=7",nativeQuery = true)
    void deleteTimeoutList();
}
