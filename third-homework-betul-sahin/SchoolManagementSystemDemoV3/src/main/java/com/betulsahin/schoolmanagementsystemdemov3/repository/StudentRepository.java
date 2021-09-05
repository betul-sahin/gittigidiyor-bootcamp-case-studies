package com.betulsahin.schoolmanagementsystemdemov3.repository;

import com.betulsahin.schoolmanagementsystemdemov3.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAllByNameContainingIgnoreCase(String searchWord);

    @Query(nativeQuery = true, value = "SELECT gender AS gender, count(gender) AS count FROM Student GROUP BY gender")
    List<StudentGenderStatistics> findAllByGendersWithGrouping();

    void deleteByName(String name);
}

/*
IgnoreCase - büyük/küçük harfe duyarsız bir arama yapar.
 */