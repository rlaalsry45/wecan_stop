package com.z5.zcms.frontsys.mail.service;

import java.util.List;

import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.frontsys.mail.domain.Mail;
import com.z5.zcms.frontsys.mail.domain.MailParticipant;


public interface MailService {
	
	Integer getMailListCount(Mail mail) throws Exception;
	List<Mail> getMailList(Mail mail) throws Exception;
	
	Mail getMail(Mail mail) throws Exception;
	Mail getMailFront(Mail mail) throws Exception;
	String insertMail(Mail mail) throws Exception;
	void updateMail(Mail mail) throws Exception;
	void deleteMail(Mail mail) throws Exception;
	void deleteMailAll(List<Integer> arrDeleteNo) throws Exception;
	int getListCountUserForSearch(ZUserVo zUserVo) throws Exception;
	List<ZUserVo> getListUserForSearch(ZUserVo zUserVo) throws Exception;
	void inserMailList(Mail mail) throws Exception;
	void insertUser(Mail mail) throws Exception;
	void insertGuest(MailParticipant mail) throws Exception;
	List<MailParticipant> getMailParticipantList(Mail mail) throws Exception;
	void deleteMailList(Mail mail) throws Exception;

}
