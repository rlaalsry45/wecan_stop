package com.z5.zcms.frontsys.mail.dao;

import java.util.List;

import com.z5.zcms.frontsys.mail.domain.MailParticipant;

public interface MailParticipantDAO {
	MailParticipant getMailParticipant(MailParticipant mailParticipant) throws Exception;
	int getMailParticipantListCount(MailParticipant mailParticipant) throws Exception;
	List<MailParticipant> getMailParticipantList(MailParticipant mailParticipant) throws Exception;
	String insertMailParticipant(MailParticipant mailParticipant) throws Exception;
	void updateMailParticipant(MailParticipant mailParticipant) throws Exception;
	void deleteMailParticipant(MailParticipant mailParticipant) throws Exception;
	void deleteMailParticipantAll(List<Integer> arrDeleteNo) throws Exception;
	void deleteMailParticipantAllByFk(List<Integer> arrDeleteNo) throws Exception;
}
