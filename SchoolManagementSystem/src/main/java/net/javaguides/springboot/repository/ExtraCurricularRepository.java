package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.model.ExtraCurricular;


@Repository
public interface ExtraCurricularRepository extends JpaRepository<ExtraCurricular, Long> {

	@Query(value="select *  from extracurricular where activity_name like %:keyword%",nativeQuery=true)
	public List <ExtraCurricular>  findByKeyword(@Param("keyword") String keyword);
	

}
