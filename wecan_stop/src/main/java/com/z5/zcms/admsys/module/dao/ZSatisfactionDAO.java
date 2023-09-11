package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;

public interface ZSatisfactionDAO {

	public List<ZSatisfactionVo> list(ZSatisfactionVo zSatisfactionVo);
	public void satisfactionWrite(ZSatisfactionVo zSatisfactionVo);
	public int listCount(ZSatisfactionVo zSatisfactionVo);
	public ZSatisfactionVo detail(ZSatisfactionVo zSatisfactionVo);
	public void satisfactionDelete(List<Integer> arrDeleteNo);
	public void satisfactionUseDelete(List<Integer> arrDeleteNo);
	public void update(ZSatisfactionVo zSatisfactionVo);
	public ZSatisfactionVo latestSatisfaction(ZSatisfactionVo zSatisfactionVo);

	public String getSatisfactionIdSeq();
	public ZSatisfactionVo getSatisfactionIdList(ZSatisfactionVo zSatisfactionVo);
}