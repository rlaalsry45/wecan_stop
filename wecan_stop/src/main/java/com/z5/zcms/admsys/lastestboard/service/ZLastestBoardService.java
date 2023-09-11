package com.z5.zcms.admsys.lastestboard.service;

import java.util.List;

import com.z5.zcms.admsys.lastestboard.domain.ZLastestBoardVo;

public interface ZLastestBoardService {
	List<ZLastestBoardVo> getListLastestBoard(ZLastestBoardVo vo);

	Integer selectMenuno(ZLastestBoardVo zLastestBoardVo);

	String selectSkin(ZLastestBoardVo zLastestBoardVo);
}
