package com.z5.zcms.frontsys.mail.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.frontsys.mail.domain.MailParticipant;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class MailParticipantDAOImpl extends EgovComAbstractDAO implements MailParticipantDAO{
	private final String sqlMapNs = "MailParticipant.";

	@Override
	public MailParticipant getMailParticipant(MailParticipant mailParticipant) throws Exception{
		return (MailParticipant) this.getSqlMapClientTemplate().queryForObject(sqlMapNs + "detail", mailParticipant);
	}
	
	@Override
	public int getMailParticipantListCount(MailParticipant mailParticipant) throws Exception{
		return (Integer) super.selectByPk(sqlMapNs+"listCount",mailParticipant);	
	}
	@Override
	@SuppressWarnings("unchecked")	
	public List<MailParticipant> getMailParticipantList(MailParticipant mailParticipant) throws Exception{
		return (List<MailParticipant>) super.list(sqlMapNs + "list", mailParticipant);
	}
	@Override
	public String insertMailParticipant(MailParticipant mailParticipant) throws Exception{
		return (String) insert(sqlMapNs+"insert", mailParticipant);
	}
	@Override
	public void updateMailParticipant(MailParticipant mailParticipant) throws Exception{
		update(sqlMapNs+"update", mailParticipant);
	}
	public void deleteMailParticipant(MailParticipant mailParticipant) throws Exception{
		delete(sqlMapNs+"delete", mailParticipant);
	}
	@Transactional
	public void deleteMailParticipantAll(List<Integer> arrDeleteNo) throws Exception{
		delete(sqlMapNs+"deleteAll", arrDeleteNo);
	}
	@Transactional
	public void deleteMailParticipantAllByFk(List<Integer> arrDeleteNo) throws Exception{
		delete(sqlMapNs+"deleteAllByFk", arrDeleteNo);
	}
}
