package com.z5.zcms.admsys.chat.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.chat.domain.ChatVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ChatDAOImpl extends EgovComAbstractDAO implements ChatDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ChatDAO.";
	
	@Override
	public void insertChat(ChatVO chatVO) {
		insert(sqlMapNs+"insertChat",chatVO);
	}
	
	@Override
	public void insertChatCounselee(ChatVO chatVO) {
		insert(sqlMapNs+"insertChatCounselee",chatVO);
	}

	@Override
	public void updateChat(ChatVO chatVO) {
		update(sqlMapNs+"updateChat",chatVO);
	}

	@Override
	public void updateChatCounselee(ChatVO chatVO) {
		update(sqlMapNs+"updateChatCounselee",chatVO);
	}
	
	@Override
	public List<ChatVO> getChatCounselorTime(ChatVO chatVO) {
		return (List<ChatVO>)list(sqlMapNs+"getChatCounselorTime",chatVO);
	}

	@Override
	public List<ChatVO> getList(ChatVO chatVO) {
		return (List<ChatVO>)list(sqlMapNs+"getList",chatVO);
	}

}
