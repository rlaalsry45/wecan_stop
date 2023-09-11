package com.z5.zcms.frontsys.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.frontsys.mail.dao.MailDAO;
import com.z5.zcms.frontsys.mail.domain.Mail;
import com.z5.zcms.frontsys.mail.domain.MailParticipant;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;


@Service
public class MailServiceImpl extends AbstractServiceImpl implements MailService{
	@Autowired
	private MailDAO mailDAO;
	
	
	@Override
	public  Integer getMailListCount(Mail mail) throws Exception{
		return this.mailDAO.getMailListCount(mail);		
	}
	
	@Override
	public List<Mail> getMailList(Mail mail) throws Exception{
		return this.mailDAO.getMailList(mail);
	}
	
	@Override
	public  Mail getMail(Mail mail) throws Exception{
		return  this.mailDAO.getMail(mail);
	}
	@Override
	public  Mail getMailFront(Mail mail) throws Exception{
		return  this.mailDAO.getMailFront(mail);
	}
	@Override
	public String insertMail(Mail mail) throws Exception{
		return (String)this.mailDAO.insertMail(mail);
	}
	@Override
	public void updateMail(Mail mail) throws Exception{
		this.mailDAO.updateMail(mail);
	}
	@Override
	public void deleteMail(Mail mail) throws Exception{
		this.mailDAO.deleteMail(mail);
	}
	public void deleteMailAll(List<Integer> arrDeleteNo) throws Exception {
		
		if (arrDeleteNo.size()>0){
			this.mailDAO.deleteMailAll(arrDeleteNo);
		}
	}

	@Override
	public int getListCountUserForSearch(ZUserVo zUserVo) throws Exception {
		return this.mailDAO.getListCountUserForSearch(zUserVo);		
	}

	@Override
	public List<ZUserVo> getListUserForSearch(ZUserVo zUserVo) throws Exception {
		return this.mailDAO.getListUserForSearch(zUserVo);
	}

	@Override
	public void inserMailList(Mail mail) throws Exception {
		this.mailDAO.inserMailList(mail);
		
	}
	
	@Override
	public void insertUser(Mail mail) throws Exception {
		this.mailDAO.insertUser(mail);
	}
	@Override
	public void insertGuest(MailParticipant mail) throws Exception {
		this.mailDAO.insertGuest(mail);
	}
	
	@Override
	public List<MailParticipant> getMailParticipantList(Mail mail)	throws Exception {
		return this.mailDAO.getMailParticipantList(mail);
	}

	

	@Override
	public void deleteMailList(Mail mail) throws Exception {
		this.mailDAO.deleteMailList(mail);
		
	}

	
	
}
