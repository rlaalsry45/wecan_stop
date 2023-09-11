package com.z5.zcms.admsys.board.dao;

import java.util.List;
import java.util.Map;

import com.z5.zcms.admsys.board.domain.ZCateVo;

public interface ZCateDAO {
	public List<ZCateVo> boardCateList(int boardno) throws Exception;
	public int boardCateWrite(ZCateVo zCateVo) throws Exception;
	public void boardCateUpdate(ZCateVo zCateVoForcate) throws Exception;
	public void boardCateDelete(ZCateVo vo) throws Exception;
	public void boardCateClear(int boardno) throws Exception;
	public void boardCateORder(Map<String, String> map) throws Exception;
	//public void boardCateUseyn(Map<String, String> map) throws Exception;
}