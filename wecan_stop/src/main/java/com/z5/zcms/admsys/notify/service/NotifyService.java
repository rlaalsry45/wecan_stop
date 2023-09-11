package com.z5.zcms.admsys.notify.service;

import java.util.List;

import com.z5.zcms.admsys.notify.domain.NotifyVO;

public interface NotifyService {

	public void insertNotify(NotifyVO notifyVO);
	public List<NotifyVO> getNotifyList(NotifyVO notifyVO);
	public void updateNotify(NotifyVO notifyVO);
	public int getNotifyCnt(NotifyVO notifyVO);
}