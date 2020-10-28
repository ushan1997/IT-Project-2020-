package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.SportEvent;



@Repository
public interface EventRepository extends JpaRepository<SportEvent, Long> {
	
	@Query("Select e FROM SportEvent e WHERE e.ename LIKE %?1%")
	public List<SportEvent> findAll(String keyword);
	


}
