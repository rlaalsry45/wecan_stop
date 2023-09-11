package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.ui.Model;

import com.z5.zcms.admsys.cyberCounsel.domain.WChatOldVo;
import com.z5.zcms.admsys.module.domain.SatisfactionHisVo;
import com.z5.zcms.admsys.module.domain.SatisfactionResultVo;
import com.z5.zcms.admsys.module.domain.SatisfactionVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionHisVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionResultVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;
import com.z5.zcms.util.DataTable;

public interface SatisfactionService {

	/*ZSatisfaction Line*/
	public List<ZSatisfactionVo> getSatisfactionList(ZSatisfactionVo zSatisfactionVo);
	public void satisfactionWrite(ZSatisfactionVo zSatisfactionVo);
	public int listCount(ZSatisfactionVo zSatisfactionVo);
	public Object satisfactionDetail(Object obj);
	public void satisfactionDelete(List<Integer> arrDeleteNo);
	public void satisfactionEdit(ZSatisfactionVo zSatisfactionVo);
	
	/*ZSatisfactionHis Line*/
	public List<ZSatisfactionHisVo> getSatisfactionHisList(ZSatisfactionVo zSatisfactionVo);
	public void satisfactionHisDelete(ZSatisfactionHisVo zSatisfactionVo);
	
	/*ZSatisfactionResult Line*/
	public Integer listCount(ZSatisfactionResultVo zSatisfactionResultVo);
	public List<ZSatisfactionResultVo> listSubject(ZSatisfactionResultVo zSatisfactionResultVo);
	public Model satisfactionResultWrite(Model model, DataTable input);
	
	public void satisfactionResultChangeDelete(ZSatisfactionResultVo zSatisfactionResultVo);
	public void satisfactionResultUpdate(ZSatisfactionResultVo zSatisfactionResultVo);
	
	public ZSatisfactionVo latestSatisfaction(ZSatisfactionVo zSatisfactionVo);
	
	public String getSatisfactionIdSeq();
	
	/*Satisfaction Line*/
	public List<SatisfactionVo> getCSatisfactionList(SatisfactionVo satisfactionVo);
	public void cSatisfactionWrite(SatisfactionVo satisfactionVo);
	public int listCount(SatisfactionVo satisfactionVo);
	public Object cSatisfactionDetail(Object obj);
	public void cSatisfactionDelete(List<Integer> arrDeleteNo);
	public void cSatisfactionEdit(SatisfactionVo satisfactionVo);
	
	/*SatisfactionHis Line*/
	public List<SatisfactionHisVo> getCSatisfactionHisList(SatisfactionVo satisfactionVo);
	public void cSatisfactionHisDelete(SatisfactionHisVo satisfactionVo);
	
	/*SatisfactionResult Line*/
	public Integer listCount(SatisfactionResultVo satisfactionResultVo);
	public List<SatisfactionResultVo> listSubject(SatisfactionResultVo satisfactionResultVo);
	public Model cSatisfactionResultWrite(Model model, DataTable input);
	
	public void cSatisfactionResultChangeDelete(SatisfactionResultVo satisfactionResultVo);
	public void cSatisfactionResultUpdate(SatisfactionResultVo satisfactionResultVo);
	
	public SatisfactionVo latestCSatisfaction(SatisfactionVo satisfactionVo);
	
	public ZSatisfactionVo getSatisfactionIdList(ZSatisfactionVo zSatisfactionVo);
	
	public Integer getResultCnt(SatisfactionResultVo satisfactionResultVo);
	public List<SatisfactionResultVo> getAnswerList(SatisfactionResultVo satisfactionResultVo);
	public SatisfactionResultVo getAsknoCnt(SatisfactionResultVo satisfactionResultVo);
	Model index_satisfaction(SatisfactionResultVo satisfactionResultVo, DataTable input, Model model) throws Exception;    
	public List<SatisfactionResultVo> satisfaction_excel(SatisfactionResultVo satisfactionResultVo);
}

