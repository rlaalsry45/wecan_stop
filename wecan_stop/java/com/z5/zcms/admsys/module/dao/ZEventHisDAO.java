package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZEventHisVo;
import com.z5.zcms.admsys.module.domain.ZEventVo;

public interface ZEventHisDAO {
	public List<ZEventHisVo> list(ZEventVo zEventVo);
	public ZEventHisVo detail(ZEventHisVo zEventHisVo);
	public void insert(ZEventVo zEventVo);
	public void delete(ZEventHisVo zEventHisVo);
	public void eventHisDelete(List<Integer> arrDeleteNo);
}
