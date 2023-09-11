package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZPopupVo;

public interface ZPopupDAO {

	public List<ZPopupVo> list(ZPopupVo zPopupVo);
	public void popupWrite(ZPopupVo zPopupVo);
	public int listCount(ZPopupVo zPopupVo);
	public ZPopupVo detail(ZPopupVo zPopupVo);
	public void popupDelete(List<Integer> arrDeleteNo);
	public void popupUseDelete(List<Integer> arrDeleteNo);
	public void update(ZPopupVo zPopupVo);
	public void updateAttach(ZPopupVo zPopupVo);

}