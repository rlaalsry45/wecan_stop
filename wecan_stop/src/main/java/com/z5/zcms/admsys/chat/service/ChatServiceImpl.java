package com.z5.zcms.admsys.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.chat.dao.ChatDAO;
import com.z5.zcms.admsys.chat.domain.ChatVO;

@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
    private ChatDAO chatDAO;

	@Override
	public void insertChat(ChatVO chatVO) {
		chatDAO.insertChat(chatVO);
	}

	@Override
	public void updateChat(ChatVO chatVO) {
		chatDAO.updateChat(chatVO);
	}
	
}
