package com.z5.zcms.admsys.notify.dao;

import java.util.List;

import com.z5.zcms.admsys.notify.domain.NotifyVO;

public interface NotifyDAO {

	public void insertNotify(NotifyVO notifyVO);
	public List<NotifyVO> getNotifyList(NotifyVO notifyVO);
	public void updateNotify(NotifyVO notifyVO);
	public Integer getNotifyCnt(NotifyVO notifyVO);
	public NotifyVO getMaxNotify(NotifyVO notifyVO);
}
