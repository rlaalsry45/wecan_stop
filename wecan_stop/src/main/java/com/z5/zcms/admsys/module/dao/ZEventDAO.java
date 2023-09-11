package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZEventVo;

public interface ZEventDAO {

	public List<ZEventVo> list(ZEventVo zEventVo);
	public void eventWrite(ZEventVo zEventVo);
	public int listCount(ZEventVo zEventVo);
	public ZEventVo detail(ZEventVo zEventVo);
	public void eventDelete(List<Integer> arrDeleteNo);
	public void eventUseDelete(List<Integer> arrDeleteNo);
	public void update(ZEventVo zEventVo);

}