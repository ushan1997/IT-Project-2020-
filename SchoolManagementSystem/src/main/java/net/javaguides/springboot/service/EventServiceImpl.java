package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Pricewinner;
import net.javaguides.springboot.model.SportEvent;
import net.javaguides.springboot.repository.EventRepository;
import net.javaguides.springboot.repository.PricewinnerRepository;


@Service
public class EventServiceImpl implements EventService{
	
	//Sport Events
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private PricewinnerRepository PricewinnerRepository;

	
	@Override
	public List <SportEvent> getAllSportEvents(String keyword) {
		if(keyword!=null) {
			return eventRepository.findAll(keyword);
		}
		
		return eventRepository.findAll();
	}

	@Override
	public void saveSportEvent(SportEvent sportevent) {
		this.eventRepository.save(sportevent);
		
	}

	@Override
	public SportEvent getSportEventById(long id) {
		Optional<SportEvent> optional = eventRepository.findById(id);
		SportEvent sportevent = null;
		if(optional.isPresent()) {
			sportevent = optional.get();
		} else {
			
			throw new RuntimeException("Sport Event Not Found for ID :: " + id);
		}
		
		return sportevent;
	}

	@Override
	public void deleteSportEventById(long id) {
		this.eventRepository.deleteById(id);
		
	}

	
    /**                    Price Winners                */
	
	@Override
	public List<Pricewinner> getAllPricewinners() {
		return PricewinnerRepository.findAll();
		
	}

	@Override
	public void savePricewinner(Pricewinner pricewinner) {
		this.PricewinnerRepository.save(pricewinner);
		
	}

	@Override
	public void deletePricewinnerById(long id) {
		this.PricewinnerRepository.deleteById(id);
		
	}

	@Override
	public List<Pricewinner> getAllPricewinnersByKey(Integer pricekey) {
		if(pricekey!=null) {
			return PricewinnerRepository.findAll(pricekey);
		}
		return PricewinnerRepository.findAll();
	}

	
}
