package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.model.Teacher;

public interface TeacherService {
	List<Teacher> getAllTeachers();
	void saveTeacher(Teacher teacher);
	Teacher getTeachersById(long teacher_id);
	void deleteTeachersById(long teacher_id);
	//Page<Teacher> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	List <Teacher> findTeacher(String keyword);
}
