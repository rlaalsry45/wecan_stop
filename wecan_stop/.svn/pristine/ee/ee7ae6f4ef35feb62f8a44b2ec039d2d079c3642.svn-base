package com.z5.zcms.frontsys.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.frontsys.mail.dao.MailParticipantDAO;
import com.z5.zcms.frontsys.mail.domain.MailParticipant;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
@Service
public class MailParticipantServiceImpl extends AbstractServiceImpl implements MailParticipantService{
	@Autowired
	private MailParticipantDAO mailParticipantDAO;
	
	@Override
	public  MailParticipant getMailParticipant(MailParticipant mailParticipant) throws Exception{
		return  this.mailParticipantDAO.getMailParticipant(mailParticipant);
	}
	
	@Override
	public  Integer getMailParticipantListCount(MailParticipant mailParticipant) throws Exception{
		return this.mailParticipantDAO.getMailParticipantListCount(mailParticipant);		
	}
	
	@Override
	public List<MailParticipant> getMailParticipantList(MailParticipant mailParticipant) throws Exception{
		return this.mailParticipantDAO.getMailParticipantList(mailParticipant);
	}
	@Override
	public String insertMailParticipant(MailParticipant mailParticipant) throws Exception{
		return (String) this.mailParticipantDAO.insertMailParticipant(mailParticipant);
	}
	@Override
	public void updateMailParticipant(MailParticipant mailParticipant) throws Exception{
		this.mailParticipantDAO.updateMailParticipant(mailParticipant);
	}
	@Override
	public void deleteMailParticipant(MailParticipant mailParticipant) throws Exception{
		this.mailParticipantDAO.deleteMailParticipant(mailParticipant);
	}
	public void deleteMailParticipantAll(List<Integer> arrDeleteNo) throws Exception {
		
		if (arrDeleteNo.size()>0){
			this.mailParticipantDAO.deleteMailParticipantAll(arrDeleteNo);
		}
	}
	public void deleteMailParticipantAllByFk(List<Integer> arrDeleteNo) throws Exception{
		if (arrDeleteNo.size()>0){
			this.mailParticipantDAO.deleteMailParticipantAllByFk(arrDeleteNo);
		}
	}
}
