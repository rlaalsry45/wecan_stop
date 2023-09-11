package com.z5.zcms.frontsys.front.dao;

import java.util.List;

import com.z5.zcms.frontsys.front.domain.FrontLatestBoardVo;

public interface FrontLastestBoardDAO {
	public List<FrontLatestBoardVo> getListLastestBoard(FrontLatestBoardVo lastestBoardVo);

	public String selectSkin(FrontLatestBoardVo lastestBoardVo);

	public Integer selectMenuno(FrontLatestBoardVo lastestBoardVo);

	public String selectCateyn(FrontLatestBoardVo lastestBoardVo);

	public List<FrontLatestBoardVo> getLastestAlumniNews(FrontLatestBoardVo lastestBoardVo);

	public List<FrontLatestBoardVo> getLastestCarendar(FrontLatestBoardVo lastestBoardVo);

	public Integer getCalendarMenuno(FrontLatestBoardVo lastestBoardVo);
}
