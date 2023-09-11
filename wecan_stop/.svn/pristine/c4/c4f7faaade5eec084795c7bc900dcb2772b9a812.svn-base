package com.z5.zcms.admsys.lastestboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.lastestboard.dao.ZLastestBoardDAO;
import com.z5.zcms.admsys.lastestboard.domain.ZLastestBoardVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZLastestBoardServiceImpl extends AbstractServiceImpl implements ZLastestBoardService{
	
	@Autowired
	private ZLastestBoardDAO zLastestBoardDAO;

	public List<ZLastestBoardVo> getListLastestBoard(ZLastestBoardVo vo) {
		return this.zLastestBoardDAO.getListLastestBoard(vo);
	}

	@Override
	public Integer selectMenuno(ZLastestBoardVo vo) {
		// TODO Auto-generated method stub
		return (Integer)this.zLastestBoardDAO.selectMenuno(vo);
	}

	@Override
	public String selectSkin(ZLastestBoardVo vo) {
		// TODO Auto-generated method stub
		return this.zLastestBoardDAO.selectSkin(vo);
	}
}
