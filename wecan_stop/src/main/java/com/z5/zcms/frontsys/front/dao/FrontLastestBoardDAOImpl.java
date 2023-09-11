package com.z5.zcms.frontsys.front.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.frontsys.front.domain.FrontLatestBoardVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class FrontLastestBoardDAOImpl extends EgovComAbstractDAO implements FrontLastestBoardDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "FrontLastestBoard.";
	
    @SuppressWarnings("unchecked")
	public List<FrontLatestBoardVo> getListLastestBoard(FrontLatestBoardVo lastestBoardVo) {
		return (List<FrontLatestBoardVo>) super.list(sqlMapNs+"boardlist", lastestBoardVo);
    }

	@Override
	public String selectSkin(FrontLatestBoardVo lastestBoardVo) {
		// TODO Auto-generated method stub
		return (String)super.selectByPk(sqlMapNs+"selectSkin",lastestBoardVo);
	}

	@Override
	public Integer selectMenuno(FrontLatestBoardVo lastestBoardVo) {
		// TODO Auto-generated method stub
		return (Integer)super.selectByPk(sqlMapNs+"selectMenuno",lastestBoardVo);
	}

	@Override
	public String selectCateyn(FrontLatestBoardVo lastestBoardVo) {
		// TODO Auto-generated method stub
		return (String)super.selectByPk(sqlMapNs+"selectCateyn",lastestBoardVo);
	}

	@Override
	public List<FrontLatestBoardVo> getLastestAlumniNews(FrontLatestBoardVo lastestBoardVo) {
		return (List<FrontLatestBoardVo>) super.list(sqlMapNs+"getLastestAlumniNews", lastestBoardVo);
	}

	@Override
	public List<FrontLatestBoardVo> getLastestCarendar(FrontLatestBoardVo lastestBoardVo) {
		return (List<FrontLatestBoardVo>) super.list(sqlMapNs+"getLastestCarendar", lastestBoardVo);
	}

	@Override
	public Integer getCalendarMenuno(FrontLatestBoardVo lastestBoardVo) {
		return (Integer)super.selectByPk(sqlMapNs+"getCalendarMenuno",lastestBoardVo);
	}
}
