package com.z5.zcms.admsys.notify.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.notify.domain.NotifyVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class NotifyDAOImpl extends EgovComAbstractDAO implements NotifyDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "NotifyDAO.";
	
	@Override
	public void insertNotify(NotifyVO notifyVO) {
		insert(sqlMapNs+"insertNotify",notifyVO);
	}

	@Override
	public List<NotifyVO> getNotifyList(NotifyVO notifyVO) {
		return (List<NotifyVO>)list(sqlMapNs+"getNotifyList",notifyVO);
	}

	@Override
	public void updateNotify(NotifyVO notifyVO) {
		update(sqlMapNs+"updateNotify",notifyVO);
	}

	@Override
	public Integer getNotifyCnt(NotifyVO notifyVO) {
		return (Integer)select(sqlMapNs+"getNotifyCnt",notifyVO);
	}
	
}
