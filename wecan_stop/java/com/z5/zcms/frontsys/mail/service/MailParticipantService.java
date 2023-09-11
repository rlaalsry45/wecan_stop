package com.z5.zcms.frontsys.mail.service;

import java.util.List;

import com.z5.zcms.frontsys.mail.domain.MailParticipant;


public interface MailParticipantService {
	MailParticipant getMailParticipant(MailParticipant mailParticipant) throws Exception;
	Integer getMailParticipantListCount(MailParticipant mailParticipant) throws Exception;
	List<MailParticipant> getMailParticipantList(MailParticipant mailParticipant) throws Exception;
	String insertMailParticipant(MailParticipant mailParticipant) throws Exception;
	void updateMailParticipant(MailParticipant mailParticipant) throws Exception;
	void deleteMailParticipant(MailParticipant mailParticipant) throws Exception;
	void deleteMailParticipantAll(List<Integer> arrDeleteNo) throws Exception;
	void deleteMailParticipantAllByFk(List<Integer> arrDeleteNo) throws Exception;
}
