package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.SatisfactionVo;

public interface SatisfactionDAO {

	public List<SatisfactionVo> list(SatisfactionVo satisfactionVo);
	public void satisfactionWrite(SatisfactionVo satisfactionVo);
	public int listCount(SatisfactionVo satisfactionVo);
	public SatisfactionVo detail(SatisfactionVo satisfactionVo);
	public void satisfactionDelete(List<Integer> arrDeleteNo);
	public void satisfactionUseDelete(List<Integer> arrDeleteNo);
	public void update(SatisfactionVo satisfactionVo);
	public SatisfactionVo latestSatisfaction(SatisfactionVo satisfactionVo);
	
}