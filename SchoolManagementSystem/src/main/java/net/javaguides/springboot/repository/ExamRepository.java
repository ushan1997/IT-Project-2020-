package net.javaguides.springboot.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer>{

	@Query(value = "select * from exams e where e.subject like %:keyword% or e.exam_name like %:keyword%",nativeQuery=true)
	List <Exam> findByKeyword(@Param("keyword") String keyword);
	
	
	@Query(value ="select teacher_id from teacher tea where tea.teacher_name like %:name%",nativeQuery=true)
	int convertNametoId(@Param("name") String name);
	
	@Query(value ="select teacher_name from teacher",nativeQuery=true)
	List <String> AllTeachersNames();
	
}
