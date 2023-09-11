package com.z5.zcms.admsys.chat.service;

import java.util.List;

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
	public void insertChatCounselee(ChatVO chatVO) {
		chatDAO.insertChatCounselee(chatVO);
	}

	@Override
	public void updateChat(ChatVO chatVO) {
		chatDAO.updateChat(chatVO);
	}
	
	@Override
	public void updateChatCounselee(ChatVO chatVO) {
		chatDAO.updateChatCounselee(chatVO);
	}

	@Override
	public List<ChatVO> getChatCounselorTime(ChatVO chatVO) {
		return chatDAO.getChatCounselorTime(chatVO);
	}
	
}
