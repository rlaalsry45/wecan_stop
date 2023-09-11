package com.z5.zcms.admsys.module.service;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZRegMngVo;

public interface RegMngService {

	public void write(ZRegMngVo zRegMngVo);
	public List<ZRegMngVo> list(ZRegMngVo zRegMngVo);
	public int listCount(ZRegMngVo zRegMngVo);
	public ZRegMngVo detail(ZRegMngVo zRegMngVo);
	public void delete(List<Integer> arrDeleteNo);
}

