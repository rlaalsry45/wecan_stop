package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZSatisfactionResultVo;

public interface ZSatisfactionResultDAO {

	public int listCount(ZSatisfactionResultVo zSatisfactionResultVo);
	public List<ZSatisfactionResultVo> listSubject(ZSatisfactionResultVo zSatisfactionResultVo);
	public void satisfactionResultDelete(List<Integer> arrDeleteNo);
	public void satisfactionResultWrite(ZSatisfactionResultVo zSatisfactionResultVo);
	public void satisfactionResultTotalUpdate(ZSatisfactionResultVo zSatisfactionResultVo);
	
	public void satisfactionResultChangeDelete(ZSatisfactionResultVo zSatisfactionResultVo);
	public void satisfactionResultUpdate(ZSatisfactionResultVo zSatisfactionResultVo);
	
	
}