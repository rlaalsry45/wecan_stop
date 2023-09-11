package com.z5.zcms.admsys.events.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.events.domain.Events;
import com.z5.zcms.admsys.events.domain.EventsEntries;
import com.z5.zcms.admsys.events.domain.EventsEntryFee;
import com.z5.zcms.admsys.events.domain.EventsPapers;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class EventsDAOImpl extends EgovComAbstractDAO implements EventsDAO {

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "events.";

	// EVENTS
	@Override
	public String insertEvents(Events vo) throws Exception {
		return (String) insert(sqlMapNs+"insertEvents", vo);
	}
	@Override
	public int getEventsListCount(Events vo) throws Exception {
		return (Integer) super.selectByPk(sqlMapNs+"getEventsListCount",vo);	
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Events> selectEventsList(Events vo) throws Exception {
		return (List<Events>) super.list(sqlMapNs + "selectEventsList", vo);
	}
	@Override
	public Events getEventsInfoById(Events vo) throws Exception {
		return (Events) selectByPk(sqlMapNs + "getEventsInfoById", vo);
	}
	@Override
	public void updateEvents(Events vo) throws Exception {
		update(sqlMapNs+"updateEvents", vo);
	}
	@Override
	public void deleteEvents(Events vo) throws Exception {
		delete(sqlMapNs+"deleteEvents", vo);
	}
	
	// EVENTS_ENTRYFEE
	@Override
	public void insertEventsEntryFee(EventsEntryFee vo) throws Exception {
		insert(sqlMapNs+"insertEventsEntryFee", vo);
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<EventsEntryFee> selectEntryFeeListByFk(EventsEntryFee vo) throws Exception {
		return (List<EventsEntryFee>) super.list(sqlMapNs + "selectEntryFeeListByFk", vo);
	}
	@Override
	public void deleteEventsEntryFee(EventsEntryFee vo) throws Exception {
		delete(sqlMapNs+"deleteEventsEntryFee", vo);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<EventsEntryFee> getEntryFeeSumOfLevel(EventsEntryFee vo) throws Exception {
		return (List<EventsEntryFee>) super.list(sqlMapNs+"getEntryFeeSumOfLevel",vo);	
	}
	
	// EVENTS_ENTRIES
	@Override
	public String insertEventsEntries(EventsEntries vo) throws Exception {
		return (String) insert(sqlMapNs+"insertEventsEntries", vo);
	}
	@Override
	public int getEventsEntriesCountByIdx(EventsEntries vo) throws Exception {
		return (Integer) super.selectByPk(sqlMapNs+"getEventsEntriesCountByIdx",vo);	
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<EventsEntries> selectEventsEntriesListByFk(EventsEntries vo) throws Exception {
		return (List<EventsEntries>) super.list(sqlMapNs + "selectEventsEntriesListByFk", vo);
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<EventsEntries> selectEventsEntryListOfUser(EventsEntries vo) throws Exception {
		return (List<EventsEntries>) super.list(sqlMapNs + "selectEventsEntryListOfUser", vo);
	}
	@Override
	public EventsEntries getEventsEntriesInfoById(EventsEntries vo) throws Exception {
		return (EventsEntries) selectByPk(sqlMapNs + "getEventsEntriesInfoById", vo);
	}
	@Override
	public int getEventsEntryCountOfUser(EventsEntries vo) throws Exception {
		return (Integer) super.selectByPk(sqlMapNs+"getEventsEntryCountOfUser",vo);	
	}
	@Override
	public void updateEventsEntryPaymentInfo(EventsEntries vo) throws Exception {
		update(sqlMapNs+"updateEventsEntryPaymentInfo", vo);
	}

	// EVENTS_PAPERS
	@Override
	public void insertEventsPapers(EventsPapers vo) throws Exception {
		insert(sqlMapNs+"insertEventsPapers", vo);
	}
	
	@Override
	public void updateEventsPapers(EventsPapers vo) throws Exception {
		update(sqlMapNs+"updateEventsPapers", vo);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<EventsPapers> selectPapersListByFk(EventsPapers vo) throws Exception {
		return (List<EventsPapers>) super.list(sqlMapNs + "selectPapersListByFk", vo);
	}

	//delete
	@Transactional
	public void deleteEventsMain(List<Integer> arrDeleteNo) throws Exception{
		delete(sqlMapNs+"deleteMainByFk", arrDeleteNo);
	}
	@Transactional
	public void deleteEventsEntryFeeByFk(List<Integer> arrDeleteNo) throws Exception{
		delete(sqlMapNs+"deleteFeeByFk", arrDeleteNo);
	}
	
	@Transactional
	public void deleteEventsEntriesByFk(List<Integer> arrDeleteNo) throws Exception{
		delete(sqlMapNs+"deleteEntriesByFk", arrDeleteNo);
	}
	
	@Transactional
	public void deleteEventsPapersByFk(List<Integer> arrDeleteNo) throws Exception{
		delete(sqlMapNs+"deletePaperByFk", arrDeleteNo);
	}
	
	@Transactional
	public void deleteEventsEntriesByFk2(List<Integer> arrDeleteNo) throws Exception{
		delete(sqlMapNs+"deleteEntriesByFk2", arrDeleteNo);
	}
	
	@Transactional
	public void deleteEventsPapersByFk2(List<Integer> arrDeleteNo) throws Exception{
		delete(sqlMapNs+"deletePaperByFk2", arrDeleteNo);
	}
	
	
}