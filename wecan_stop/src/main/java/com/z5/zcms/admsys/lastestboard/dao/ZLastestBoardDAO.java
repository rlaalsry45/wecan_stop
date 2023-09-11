package com.z5.zcms.admsys.lastestboard.dao;

import java.util.List;

import com.z5.zcms.admsys.lastestboard.domain.ZLastestBoardVo;

public interface ZLastestBoardDAO {
	public List<ZLastestBoardVo> getListLastestBoard(ZLastestBoardVo vo);

	public String selectSkin(ZLastestBoardVo vo);

	public Integer selectMenuno(ZLastestBoardVo vo);
}
