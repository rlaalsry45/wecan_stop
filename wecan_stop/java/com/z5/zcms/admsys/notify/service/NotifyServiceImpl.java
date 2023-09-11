package com.z5.zcms.admsys.notify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.notify.dao.NotifyDAO;
import com.z5.zcms.admsys.notify.domain.NotifyVO;

@Service
public class NotifyServiceImpl implements NotifyService{
	
	@Autowired
    private NotifyDAO notifyDAO;

	@Override
	public void insertNotify(NotifyVO notifyVO) {
		notifyDAO.insertNotify(notifyVO);
	}

	@Override
	public List<NotifyVO> getNotifyList(NotifyVO notifyVO) {
		return notifyDAO.getNotifyList(notifyVO);
	}

	@Override
	public void updateNotify(NotifyVO notifyVO) {
		notifyDAO.updateNotify(notifyVO);
	}

	@Override
	public int getNotifyCnt(NotifyVO notifyVO) {
		return notifyDAO.getNotifyCnt(notifyVO);
	}

	@Override
	public NotifyVO getMaxNotify(NotifyVO notifyVO) {
		return notifyDAO.getMaxNotify(notifyVO);
	}
	
}
