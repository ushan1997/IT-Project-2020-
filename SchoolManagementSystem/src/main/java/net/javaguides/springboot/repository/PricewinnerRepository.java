package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.Pricewinner;



public interface PricewinnerRepository extends JpaRepository<Pricewinner, Long> {

	@Query(nativeQuery = true, value = "select distinct e.exam_name,em.exam_id,em.student_id,em.marks,e.subject\r\n" + 
			"from exam_marks em,exams e\r\n" + 
			"where em.exam_id LIKE %?1% and e.exam_id LIKE %?1% and em.marks = (select max(em.marks)\r\n" + 
			"													from exam_marks em,exams e\r\n" + 
			"													where em.exam_id LIKE %?1% )" )
	List<Pricewinner> findAll(Integer pricekey);

}
