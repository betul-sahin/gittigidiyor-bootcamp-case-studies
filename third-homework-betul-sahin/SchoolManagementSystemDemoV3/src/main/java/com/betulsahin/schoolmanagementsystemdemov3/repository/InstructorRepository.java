package com.betulsahin.schoolmanagementsystemdemov3.repository;

import com.betulsahin.schoolmanagementsystemdemov3.entity.Instructor;
import com.betulsahin.schoolmanagementsystemdemov3.entity.PermanentInstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    List<Instructor> findAllByNameContainingIgnoreCase(String searchWord);

    // Top 3 salaries for PermanentInstructor
    // LIMIT 3 calismadigi icin native query e cevirdim.
    @Query(nativeQuery = true,
           value="SELECT ins.name, perm.salary FROM Instructor ins inner join PermanentInstructor perm on ins.id=perm.id ORDER BY 2 DESC LIMIT 3")
    List<?> findAllTop3BySalaryGreaterThan();

    void deleteByName(String name);
}