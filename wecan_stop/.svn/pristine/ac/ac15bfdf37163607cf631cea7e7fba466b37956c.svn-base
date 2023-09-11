package com.z5.zcms.admsys.events.dao;

import java.util.List;

import com.z5.zcms.admsys.events.domain.Events;
import com.z5.zcms.admsys.events.domain.EventsEntryFee;
import com.z5.zcms.admsys.events.domain.EventsEntries;
import com.z5.zcms.admsys.events.domain.EventsPapers;

public interface EventsDAO {

	// EVENTS
	public String insertEvents(Events vo) throws Exception;
	public int getEventsListCount(Events vo) throws Exception;
	public List<Events> selectEventsList(Events vo) throws Exception;
	public Events getEventsInfoById(Events vo) throws Exception;
	public void updateEvents(Events vo) throws Exception;
	public void deleteEvents(Events vo) throws Exception;

	// EVENTS_ENTRYFEE
	public void insertEventsEntryFee(EventsEntryFee vo) throws Exception;
	public List<EventsEntryFee> selectEntryFeeListByFk(EventsEntryFee vo) throws Exception;
	public void deleteEventsEntryFee(EventsEntryFee vo) throws Exception;
	public List<EventsEntryFee> getEntryFeeSumOfLevel(EventsEntryFee vo) throws Exception;

	// EVENTS_ENTRIES
	public String insertEventsEntries(EventsEntries vo) throws Exception;
	public int getEventsEntriesCountByIdx(EventsEntries vo) throws Exception;
	public List<EventsEntries> selectEventsEntriesListByFk(EventsEntries vo) throws Exception;
	public List<EventsEntries> selectEventsEntryListOfUser(EventsEntries vo) throws Exception;
	public EventsEntries getEventsEntriesInfoById(EventsEntries vo) throws Exception;
	public int getEventsEntryCountOfUser(EventsEntries vo) throws Exception;
	public void updateEventsEntryPaymentInfo(EventsEntries vo) throws Exception;

	// EVENTS_PAPERS
	public void insertEventsPapers(EventsPapers vo) throws Exception;
	public void updateEventsPapers(EventsPapers vo) throws Exception;
	public List<EventsPapers> selectPapersListByFk(EventsPapers vo) throws Exception;

	//delete
	public void deleteEventsMain(List<Integer> arrDeleteNo) throws Exception;
	public void deleteEventsEntryFeeByFk(List<Integer> arrDeleteNo) throws Exception;
	public void deleteEventsEntriesByFk(List<Integer> arrDeleteNo) throws Exception;
	public void deleteEventsPapersByFk(List<Integer> arrDeleteNo) throws Exception;
	
	//entry delete
	public void deleteEventsEntriesByFk2(List<Integer> arrDeleteNo) throws Exception;
	public void deleteEventsPapersByFk2(List<Integer> arrDeleteNo) throws Exception;
}
