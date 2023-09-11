package com.z5.zcms.admsys.module.service;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZEventHisVo;
import com.z5.zcms.admsys.module.domain.ZEventVo;

public interface EventService {

	/*ZEvent Line*/
	public List<ZEventVo> getEventList(ZEventVo zEventVo);
	public void eventWrite(ZEventVo zEventVo);
	public int listCount(ZEventVo zEventVo);
	public Object eventDetail(Object obj);
	public void eventDelete(List<Integer> arrDeleteNo);
	public void eventEdit(ZEventVo zEventVo);
	
	/*ZEventHis Line*/
	public List<ZEventHisVo> getEventHisList(ZEventVo zEventVo);
	public void eventHisDelete(ZEventHisVo zEventHisVo);
}

