package com.z5.zcms.admsys.events.service;

import java.util.List;

import com.z5.zcms.admsys.events.domain.Events;
import com.z5.zcms.admsys.events.domain.EventsEntryFee;
import com.z5.zcms.admsys.events.domain.EventsEntries;
import com.z5.zcms.admsys.events.domain.EventsPapers;

public interface EventsService {

	// EVENTS
	String insertEvents(Events vo) throws Exception;
	Integer getEventsListCount(Events vo) throws Exception;
	List<Events> selectEventsList(Events vo) throws Exception;
	Events getEventsInfoById(Events vo) throws Exception;
	void updateEvents(Events vo) throws Exception;
	void deleteEvents(Events vo) throws Exception;

	// EVENTS_ENTRYFEE
	void insertEventsEntryFee(EventsEntryFee vo) throws Exception;
	List<EventsEntryFee> selectEntryFeeListByFk(EventsEntryFee vo) throws Exception;
	void deleteEventsEntryFee(EventsEntryFee vo) throws Exception;
	List<EventsEntryFee> getEntryFeeSumOfLevel(EventsEntryFee vo) throws Exception;
	
	// EVENTS_ENTRIES
	String insertEventsEntries(EventsEntries vo) throws Exception;
	Integer getEventsEntriesCountByIdx(EventsEntries vo) throws Exception;
	List<EventsEntries> selectEventsEntriesListByFk(EventsEntries vo) throws Exception;
	List<EventsEntries> selectEventsEntryListOfUser(EventsEntries vo) throws Exception;
	EventsEntries getEventsEntriesInfoById(EventsEntries vo) throws Exception;
	int getEventsEntryCountOfUser(EventsEntries vo) throws Exception;
	void updateEventsEntryPaymentInfo(EventsEntries vo) throws Exception;
	
	// EVENTS_PAPERS
	void insertEventsPapers(EventsPapers vo) throws Exception;
	void updateEventsPapers(EventsPapers vo) throws Exception;
	List<EventsPapers> selectPapersListByFk(EventsPapers vo) throws Exception;
	
	//delete
	void deleteEventsMain(List<Integer> arrDeleteNo) throws Exception;
	void deleteEventsEntryFeeByFk(List<Integer> arrDeleteNo) throws Exception;
	void deleteEventsEntriesByFk(List<Integer> arrDeleteNo) throws Exception;
	void deleteEventsPapersByFk(List<Integer> arrDeleteNo) throws Exception;
	
	//entry delete
	void deleteEventsEntriesByFk2(List<Integer> arrDeleteNo) throws Exception;
	void deleteEventsPapersByFk2(List<Integer> arrDeleteNo) throws Exception;
	
}
