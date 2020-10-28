package net.javaguides.springboot.service;


import java.util.List;

import net.javaguides.springboot.model.Pricewinner;
import net.javaguides.springboot.model.SportEvent;



public interface EventService {
	
	//Sport Events
	List<SportEvent> getAllSportEvents(String keyword);
	
	void saveSportEvent(SportEvent sportevent);
	
	SportEvent getSportEventById(long id);
	
	void deleteSportEventById(long id);
	
	
	//price winners List 22222
	
	List<Pricewinner> getAllPricewinners();
	
	void savePricewinner(Pricewinner pricewinner);
	
	void deletePricewinnerById(long id);
	
	List<Pricewinner> getAllPricewinnersByKey(Integer pricekey);
	


}
