package com.z5.zcms.frontsys.front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.frontsys.front.dao.FrontLastestBoardDAO;
import com.z5.zcms.frontsys.front.domain.FrontLatestBoardVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class FrontLastestBoardServiceImpl extends AbstractServiceImpl implements FrontLatestBoardService{
	
	@Autowired
	private FrontLastestBoardDAO frontLastestBoardDAO;

	public List<FrontLatestBoardVo> getListLastestBoard(FrontLatestBoardVo lastestBoardVo) {
		return this.frontLastestBoardDAO.getListLastestBoard(lastestBoardVo);
	}

	@Override
	public Integer selectMenuno(FrontLatestBoardVo lastestBoardVo) {
		// TODO Auto-generated method stub
		return (Integer)this.frontLastestBoardDAO.selectMenuno(lastestBoardVo);
	}

	@Override
	public String selectSkin(FrontLatestBoardVo lastestBoardVo) {
		// TODO Auto-generated method stub
		return this.frontLastestBoardDAO.selectSkin(lastestBoardVo);
	}

	@Override
	public String selectCateyn(FrontLatestBoardVo lastestBoardVo) {
		// TODO Auto-generated method stub
		return this.frontLastestBoardDAO.selectCateyn(lastestBoardVo);
	}

	@Override
	public List<FrontLatestBoardVo> getLastestAlumniNews(FrontLatestBoardVo lastestBoardVo) {
		return this.frontLastestBoardDAO.getLastestAlumniNews(lastestBoardVo);
	}

	@Override
	public List<FrontLatestBoardVo> getLastestCarendar(FrontLatestBoardVo lastestBoardVo) {
		return this.frontLastestBoardDAO.getLastestCarendar(lastestBoardVo);
	}

	@Override
	public Integer getCalendarMenuno(FrontLatestBoardVo lastestBoardVo) {
		return (Integer)this.frontLastestBoardDAO.getCalendarMenuno(lastestBoardVo);
	}
}
