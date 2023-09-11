package com.z5.zcms.admsys.lastestboard.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.lastestboard.domain.ZLastestBoardVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZLastestBoardDAOImpl extends EgovComAbstractDAO implements ZLastestBoardDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZLastestBoard.";
	
    @SuppressWarnings("unchecked")
	public List<ZLastestBoardVo> getListLastestBoard(ZLastestBoardVo vo) {
		return (List<ZLastestBoardVo>) super.list(sqlMapNs+"boardlist", vo);
    }

	@Override
	public String selectSkin(ZLastestBoardVo vo) {
		// TODO Auto-generated method stub
		return (String)super.selectByPk(sqlMapNs+"selectSkin",vo);
	}

	@Override
	public Integer selectMenuno(ZLastestBoardVo vo) {
		// TODO Auto-generated method stub
		return (Integer)super.selectByPk(sqlMapNs+"selectMenuno",vo);
	}
}
