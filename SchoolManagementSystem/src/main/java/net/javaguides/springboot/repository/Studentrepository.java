package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Student;


@Repository
public interface Studentrepository extends JpaRepository<Student , Integer>{

	@Query(value="select * from student s where s.name like %:keyword% ", nativeQuery=true)
	List <Student> findByKeyword(@Param("keyword") String keyword);
	
	
}
