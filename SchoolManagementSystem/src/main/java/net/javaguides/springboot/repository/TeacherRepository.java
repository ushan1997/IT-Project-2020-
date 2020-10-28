package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import net.javaguides.springboot.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	 @Query(value="select * from teacher tea where tea.teacher_name like %:keyword%",nativeQuery=true)
	 List <Teacher> findTeacher(@Param("keyword") String keyword);
}
