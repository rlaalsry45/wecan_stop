package com.z5.zcms.admsys.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.events.domain.Events;
import com.z5.zcms.admsys.events.domain.EventsEntryFee;
import com.z5.zcms.admsys.events.domain.EventsEntries;
import com.z5.zcms.admsys.events.domain.EventsPapers;
import com.z5.zcms.admsys.events.dao.EventsDAO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class EventsServiceImpl  extends AbstractServiceImpl implements EventsService {

	@Autowired
	private EventsDAO eventsDAO;
	
	// EVENTS
	@Override
	public String insertEvents(Events vo) throws Exception {
		return (String)this.eventsDAO.insertEvents(vo);
	}
	@Override
	public Integer getEventsListCount(Events vo) throws Exception {
		return this.eventsDAO.getEventsListCount(vo);
	}
	@Override
	public List<Events> selectEventsList(Events vo) throws Exception {
		return this.eventsDAO.selectEventsList(vo);
	}
	@Override
	public Events getEventsInfoById(Events vo) throws Exception {
		return this.eventsDAO.getEventsInfoById(vo);
	}
	@Override
	public void updateEvents(Events vo) throws Exception {
		this.eventsDAO.updateEvents(vo);
	}
	@Override
	public void deleteEvents(Events vo) throws Exception {
		this.eventsDAO.deleteEvents(vo);
	}
	
	// EVENTS_ENTRYFEE
	@Override
	public void insertEventsEntryFee(EventsEntryFee vo) throws Exception {
		this.eventsDAO.insertEventsEntryFee(vo);
	}
	@Override
	public List<EventsEntryFee> selectEntryFeeListByFk(EventsEntryFee vo) throws Exception {
		return this.eventsDAO.selectEntryFeeListByFk(vo);
	}
	@Override
	public void deleteEventsEntryFee(EventsEntryFee vo) throws Exception {
		this.eventsDAO.deleteEventsEntryFee(vo);
	}
	@Override
	public List<EventsEntryFee> getEntryFeeSumOfLevel(EventsEntryFee vo) throws Exception {
		return this.eventsDAO.getEntryFeeSumOfLevel(vo);
	}
	
	// EVENTS_ENTRIES
	@Override
	public String insertEventsEntries(EventsEntries vo) throws Exception {
		return (String)this.eventsDAO.insertEventsEntries(vo);
	}
	@Override
	public Integer getEventsEntriesCountByIdx(EventsEntries vo) throws Exception {
		return this.eventsDAO.getEventsEntriesCountByIdx(vo);
	}
	@Override
	public List<EventsEntries> selectEventsEntriesListByFk(EventsEntries vo) throws Exception {
		return this.eventsDAO.selectEventsEntriesListByFk(vo);
	}
	@Override
	public List<EventsEntries> selectEventsEntryListOfUser(EventsEntries vo) throws Exception {
		return this.eventsDAO.selectEventsEntryListOfUser(vo);
	}
	@Override
	public EventsEntries getEventsEntriesInfoById(EventsEntries vo) throws Exception {
		return this.eventsDAO.getEventsEntriesInfoById(vo);
	}
	@Override
	public int getEventsEntryCountOfUser(EventsEntries vo) throws Exception {
		return this.eventsDAO.getEventsEntryCountOfUser(vo);
	}
	@Override
	public void updateEventsEntryPaymentInfo(EventsEntries vo) throws Exception {
		this.eventsDAO.updateEventsEntryPaymentInfo(vo);
	}

	// EVENTS_PAPERS
	@Override
	public void insertEventsPapers(EventsPapers vo) throws Exception {
		this.eventsDAO.insertEventsPapers(vo);
	}
	
	@Override
	public void updateEventsPapers(EventsPapers vo) throws Exception {
		this.eventsDAO.updateEventsPapers(vo);
	}
	
	@Override
	public List<EventsPapers> selectPapersListByFk(EventsPapers vo) throws Exception {
		return this.eventsDAO.selectPapersListByFk(vo);
	}
	
	//delete 
	public void deleteEventsMain(List<Integer> arrDeleteNo) throws Exception {
		if (arrDeleteNo.size()>0){
			this.eventsDAO.deleteEventsMain(arrDeleteNo);
		}
	}
	
	public void deleteEventsEntryFeeByFk(List<Integer> arrDeleteNo) throws Exception {
		if (arrDeleteNo.size()>0){
			this.eventsDAO.deleteEventsEntryFeeByFk(arrDeleteNo);
		}
	}
	
	public void deleteEventsEntriesByFk(List<Integer> arrDeleteNo) throws Exception {
		if (arrDeleteNo.size()>0){
			this.eventsDAO.deleteEventsEntriesByFk(arrDeleteNo);
		}
	}
	
	public void deleteEventsPapersByFk(List<Integer> arrDeleteNo) throws Exception {
		if (arrDeleteNo.size()>0){
			this.eventsDAO.deleteEventsPapersByFk(arrDeleteNo);
		}
	}
	
	public void deleteEventsEntriesByFk2(List<Integer> arrDeleteNo) throws Exception {
		if (arrDeleteNo.size()>0){
			this.eventsDAO.deleteEventsEntriesByFk2(arrDeleteNo);
		}
	}
	
	public void deleteEventsPapersByFk2(List<Integer> arrDeleteNo) throws Exception {
		if (arrDeleteNo.size()>0){
			this.eventsDAO.deleteEventsPapersByFk2(arrDeleteNo);
		}
	}

}
