package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer>{

	@Query(value ="select * from exam_marks where exam_id like %:keyword%",nativeQuery=true)
	List <Marks> findByKeyword(@Param("keyword") String keyword);
	
	@Query(value ="select exam_id from exams",nativeQuery=true)
	List <String> AllExamsId();
	
	@Query(value ="select student_id from student",nativeQuery=true)
	List <String> AllStudentId();
	
	@Query(value ="select exam_id from exams where exam_name=:keyword",nativeQuery=true)
	int convertExamNameToId(@Param("keyword") String keyword);
	

	
}
