package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Teacher;
import net.javaguides.springboot.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		this.teacherRepository.save(teacher);
	}

	public Teacher getTeachersById(long teacher_id) {
		Optional<Teacher> optional = teacherRepository.findById(teacher_id);
		Teacher teacher = null;
		if (optional.isPresent()) {
			 teacher  = optional.get();
		} else {
			throw new RuntimeException(" Teacher not found for id :: " + teacher_id);
		}
		return  teacher;
	}

	@Override
	public void deleteTeachersById(long teacher_id) {
		this.teacherRepository.deleteById(teacher_id);
	}

	@Override
	public List<Teacher> findTeacher(String keyword) {
		
		return this.teacherRepository.findTeacher(keyword);
	}
	


//
//	public Page<Teacher> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
//		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
//			Sort.by(sortField).descending();
//		
//		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
//		return this.teacherRepository.findAll(pageable);
//		
		
	
}
