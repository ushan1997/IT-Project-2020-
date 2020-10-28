package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.ExtraCurricular;
import net.javaguides.springboot.repository.ExtraCurricularRepository;



@Service
public class ExtraCurricularServiceImpl implements  ExtraCurricularService{
    
	@Autowired
	private ExtraCurricularRepository extraCurricularRepository;
	
	
	public List<ExtraCurricular> getAllExtraCurricular() {
		
		return extraCurricularRepository.findAll();
		
	}


	public void saveDetails(ExtraCurricular extraCurricular) {
		
		this.extraCurricularRepository.save( extraCurricular);
		
	}

    //update
	
	public ExtraCurricular getStudentById(long extracurricular_id) {
	
		Optional<ExtraCurricular> optional = extraCurricularRepository.findById(extracurricular_id);
		
		ExtraCurricular extraCurricular = null;
		
		if(optional.isPresent()) {
			
			extraCurricular = optional.get();
		}else
			
		{
			
			throw new RuntimeException("student not fount for id :: " + extracurricular_id);
		}
		
		
		return extraCurricular;
		}


	@Override
	public void deleteStudentById(long extracurricular_id) {
		
		this.extraCurricularRepository.deleteById(extracurricular_id);
		
	}


	@Override
	public List<ExtraCurricular> findByKeyword(String keyword) {
		
		return extraCurricularRepository.findByKeyword(keyword);
		
	}

	

	
}
