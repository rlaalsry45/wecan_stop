package com.z5.zcms.admsys.chat.dao;

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
	public void updateChat(ChatVO chatVO) {
		update(sqlMapNs+"updateChat",chatVO);
	}

}
