package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZManagerVo;

public interface ZManagerDAO {

	public List<ZManagerVo> list(ZManagerVo zManagerVo);
	public void managerWrite(ZManagerVo zManagerVo);
	public int listCount(ZManagerVo zManagerVo);
	public ZManagerVo detail(ZManagerVo zManagerVo);
	public void managerDelete(List<Integer> arrDeleteNo);
	public void managerUseDelete(List<Integer> arrDeleteNo);
	public void update(ZManagerVo zManagerVo);

}