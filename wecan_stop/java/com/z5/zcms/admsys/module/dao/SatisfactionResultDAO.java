package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.SatisfactionResultVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionResultVo;

public interface SatisfactionResultDAO {

	public int listCount(SatisfactionResultVo satisfactionResultVo);
	public List<SatisfactionResultVo> listSubject(SatisfactionResultVo satisfactionResultVo);
	public void satisfactionResultDelete(List<Integer> arrDeleteNo);
	public void satisfactionResultWrite(SatisfactionResultVo satisfactionResultVo);
	public void satisfactionResultTotalUpdate(SatisfactionResultVo satisfactionResultVo);
	
	public void satisfactionResultChangeDelete(SatisfactionResultVo satisfactionResultVo);
	public void satisfactionResultUpdate(SatisfactionResultVo satisfactionResultVo);
	
	public int getResultCnt(SatisfactionResultVo satisfactionResultVo);
	public List<SatisfactionResultVo> getAnswerList(SatisfactionResultVo satisfactionResultVo);
	public SatisfactionResultVo getAsknoCnt(SatisfactionResultVo satisfactionResultVo);
	public int listCount2(SatisfactionResultVo satisfactionResultVo);
	public List<SatisfactionResultVo> getList2(SatisfactionResultVo satisfactionResultVo);
}