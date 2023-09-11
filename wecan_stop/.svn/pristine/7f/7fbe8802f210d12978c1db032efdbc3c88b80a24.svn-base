package com.z5.zcms.admsys.board.service;

import java.util.List;

import com.z5.zcms.admsys.board.domain.FrontBoardVo;
import com.z5.zcms.admsys.board.domain.ZBannedVo;
import com.z5.zcms.admsys.board.domain.ZBoardInfoVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.domain.ZCateVo;
import com.z5.zcms.admsys.board.domain.ZFileVo;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;

public interface FrontBoardService {
	/* list */
	public ZBoardVo config(ZBoardVo zBoardVo);

	public List<ZBoardVo> getAllBoard(ZBoardVo zBoardVo);

	public List<FrontBoardVo> listNotice(ZBoardVo zBoardVo);

	public List<FrontBoardVo> listAll(ZBoardVo zBoardVo);

	public int noticeCount(ZBoardVo zBoardVo);

	public int listCount(ZBoardVo zBoardVo);

	public List<FrontBoardVo> list(ZBoardVo zBoardVo);

	public List<ZCateVo> cateListAll(ZBoardVo zBoardVo);

	public FrontBoardVo secrect(FrontBoardVo frontBoardVo);

	public List<ZCateVo> cateTopList(ZBoardVo zBoardVo);

	public List<ZCateVo> cateSubList(FrontBoardVo frontBoardVo);

	public int cateDepth(ZBoardVo zBoardVo);

	/* view */
	public FrontBoardVo view(FrontBoardVo frontBoardVo);

	public List<FrontBoardVo> comment(FrontBoardVo frontBoardVo);

	public List<ZFileVo> attaches(FrontBoardVo frontBoardVo);

	public ZBannedVo bandWord();

	public void writeComment(FrontBoardVo frontBoardVo);

	public List<ZFileVo> delete(FrontBoardVo frontBoardVo);

	public ZFileVo attach(FrontBoardVo frontBoardVo);

	public void deleteComment(FrontBoardVo frontBoardVo);

	public FrontBoardVo pwComment(FrontBoardVo frontBoardVo);

	public List<ZCateVo> cateList(FrontBoardVo frontBoardVo);

	/* write */
	public int saveBoard(FrontBoardVo frontBoardVo);

	public String deleteAttach(FrontBoardVo frontBoardVo);

	/* approve */
	public void approve(FrontBoardVo frontBoardVo);

	public List<String> getApp(ZBoardVo zBoardVo);

	public FrontBoardVo getBoardRow(FrontBoardVo frontBoardVo);

	/* 프로시져 걷어내는 작업 */
	public int saveBoardNew(FrontBoardVo frontBoardVo);

	public List<ZFileVo> deleteNew(FrontBoardVo frontBoardVo);

	public void saveBoardInfo(ZBoardInfoVo zBoardInfoVo);

	public int InfolistCount(ZBoardInfoVo zBoardInfoVo);

	public List<ZBoardInfoVo> InfolistAll(ZBoardInfoVo zBoardInfoVo);

	public List<ZBoardInfoVo> Infolist(ZBoardInfoVo zBoardInfoVo);

	public void deleteBoardInfo(ZBoardInfoVo zBoardInfoVo);

	public int pwprove(FrontBoardVo frontBoardVo);

	public List<FrontApplicationVo> retrieveApplicationList(FrontApplicationVo reqVo);
}
