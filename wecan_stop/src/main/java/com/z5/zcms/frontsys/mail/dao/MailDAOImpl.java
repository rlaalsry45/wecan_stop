package com.z5.zcms.frontsys.mail.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.frontsys.mail.domain.Mail;
import com.z5.zcms.frontsys.mail.domain.MailParticipant;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class MailDAOImpl extends EgovComAbstractDAO implements MailDAO{
		private final String sqlMapNs = "Mail.";

		@Override
		public Mail getMail(Mail mail) throws Exception{
			return (Mail) this.getSqlMapClientTemplate().queryForObject(sqlMapNs + "detail", mail);
		}
		@Override
		public Mail getMailFront(Mail mail) throws Exception{
			return (Mail) this.getSqlMapClientTemplate().queryForObject(sqlMapNs + "detailForFront", mail);
		}
		@Override
		public int getMailListCount(Mail mail) throws Exception{
			return (Integer) super.selectByPk(sqlMapNs+"listCount",mail);	
		}
		@Override
		@SuppressWarnings("unchecked")	
		public List<Mail> getMailList(Mail mail) throws Exception{
			return (List<Mail>) super.list(sqlMapNs + "list", mail);
		}
		@Override
		public String insertMail(Mail mail) throws Exception{
			return (String) insert(sqlMapNs+"insert", mail);
		}
		@Override
		public void updateMail(Mail mail) throws Exception{
			update(sqlMapNs+"update", mail);
		}
		public void deleteMail(Mail mail) throws Exception{
			delete(sqlMapNs+"delete", mail);
		}
		@Transactional
		public void deleteMailAll(List<Integer> arrDeleteNo) throws Exception{
			delete(sqlMapNs+"deleteAll", arrDeleteNo);
		}
		@Override
		public int getListCountUserForSearch(ZUserVo zUserVo) throws Exception {
			return (Integer) super.selectByPk(sqlMapNs+"getListCountUserForSearch",zUserVo);
		}
		@Override
		@SuppressWarnings("unchecked")
		public List<ZUserVo> getListUserForSearch(ZUserVo zUserVo) throws Exception {
			return (List<ZUserVo>) super.list(sqlMapNs + "getListUserForSearch", zUserVo);
		}
		@Override
		public void inserMailList(Mail mail) throws Exception {
			insert(sqlMapNs+"inserMailList", mail);
		}
		@Override
		public void insertUser(Mail mail) throws Exception {
			insert(sqlMapNs+"insertUser", mail);
		}
		@Override
		public void insertGuest(MailParticipant mail) throws Exception {
			insert(sqlMapNs+"insertGuest", mail);
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public List<MailParticipant> getMailParticipantList(Mail mail) throws Exception {
			return (List<MailParticipant>) super.list(sqlMapNs + "getMailParticipantList", mail);
		}
		@Override
		public void deleteMailList(Mail mail) throws Exception {
			delete(sqlMapNs+"deleteMailList", mail);
			
		}
		@Override
		@SuppressWarnings("unchecked")
		public List<Mail> getListWillSendMail(List<Mail> mailList)	throws Exception {
			return (List<Mail>) super.list(sqlMapNs + "getListWillSendMail", mailList);
		}
		@Override
		public void updateMailParticipantToSended(MailParticipant mailParticipant) throws Exception {
			update(sqlMapNs+"updateMailParticipantToSended", mailParticipant);
		}
		@Override
		public void updateMailToSended(Mail mail) throws Exception {
			update(sqlMapNs+"updateMailToSended", mail);
		}
		
		
		
	}
