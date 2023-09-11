package com.z5.zcms.admsys.board.dao;

import java.util.List;

import com.z5.zcms.admsys.board.domain.FrontBoardVo;
import com.z5.zcms.admsys.board.domain.ZBannedVo;
import com.z5.zcms.admsys.board.domain.ZBoardInfoVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.domain.ZCateVo;
import com.z5.zcms.admsys.board.domain.ZFileVo;

public interface FrontBoardDAO {
	public int pwprove(FrontBoardVo frontBoardVo);
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
	
	public int saveBoard(FrontBoardVo frontBoardVo);
	public String deleteAttach(FrontBoardVo frontBoardVo);
	/*approve*/
	public void approve(FrontBoardVo frontBoardVo);
	public List<String> getApp(ZBoardVo zBoardVo);
	/**
	 * MethodName : getBoardRow
	 * ClassName  : FrontBoardDAO
	 * Comment   : 
	 * 작성자    : 김문석
	 * 작성일    : 2014. 1. 20. 오후 4:12:01
	 */
	public FrontBoardVo getBoardRow(FrontBoardVo frontBoardVo);
	
	/*프로시져 board걷어내는 작업===============================================================*/
	public Integer insertBbs(FrontBoardVo frontBoardVo);
	public Integer selectBbsno(String seqname);
	public void updateBbstopno(FrontBoardVo frontBoardVo);
	public void insertBbsFile(ZFileVo file);
	public void updateBbs(FrontBoardVo frontBoardVo);
	public void updateBbsFile(ZFileVo file);
	public FrontBoardVo getBbsparentVO(FrontBoardVo frontBoardVo);
	public void updateBbsstep(FrontBoardVo boardTmp);
	public void insertBbsReply(FrontBoardVo frontBoardVo);
	public Integer getMaxBbsStep(FrontBoardVo frontBoardVo);
	public List<ZFileVo> selectFileList(FrontBoardVo frontBoardVo);
	public void deleteBbs(FrontBoardVo frontBoardVo);
	public void deletetFileList(FrontBoardVo frontBoardVo);
	
	
	public void saveBoardInfo(ZBoardInfoVo zBoardInfoVo);
	public int InfolistCount(ZBoardInfoVo zBoardInfoVo);
	public List<ZBoardInfoVo> InfolistAll(ZBoardInfoVo zBoardInfoVo);
	public List<ZBoardInfoVo> Infolist(ZBoardInfoVo zBoardInfoVo);
	public void deleteBoardInfo(ZBoardInfoVo zBoardInfoVo);

}
