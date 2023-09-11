package com.z5.zcms.frontsys.mail.dao;

import java.util.List;

import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.frontsys.mail.domain.Mail;
import com.z5.zcms.frontsys.mail.domain.MailParticipant;

public interface MailDAO {
	Mail getMail(Mail mail) throws Exception;
	Mail getMailFront(Mail mail) throws Exception;
	int getMailListCount(Mail mail) throws Exception;
	List<Mail> getMailList(Mail mail) throws Exception;
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
	List<Mail> getListWillSendMail(List<Mail> mailList) throws Exception;
	void updateMailParticipantToSended(MailParticipant mailParticipant) throws Exception;
	void updateMailToSended(Mail mail) throws Exception;
}

