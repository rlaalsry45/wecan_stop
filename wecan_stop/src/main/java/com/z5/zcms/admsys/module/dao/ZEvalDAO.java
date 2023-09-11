package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZEvalVo;

public interface ZEvalDAO {

	public List<ZEvalVo> list(ZEvalVo zEvalVo);
	public void evalWrite(ZEvalVo zEvalVo);
	public int listCount(ZEvalVo zEvalVo);
	public ZEvalVo detail(ZEvalVo zEvalVo);
	public void evalDelete(List<Integer> arrDeleteNo);
	public void evalUseDelete(List<Integer> arrDeleteNo);
	public void update(ZEvalVo zEvalVo);

}