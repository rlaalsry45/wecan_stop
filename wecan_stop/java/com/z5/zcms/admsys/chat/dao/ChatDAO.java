package com.z5.zcms.admsys.chat.dao;

import java.util.List;

import com.z5.zcms.admsys.chat.domain.ChatVO;

public interface ChatDAO {

	public void insertChat(ChatVO chatVO);
	public void insertChatCounselee(ChatVO chatVO);
	public void updateChat(ChatVO chatVO);
	public void updateChatCounselee(ChatVO chatVO);
	public List<ChatVO> getChatCounselorTime(ChatVO chatVO);
	public List<ChatVO> getList(ChatVO chatVO);
}
