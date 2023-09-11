package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;

public interface ZLayerPopupDAO {

	public List<ZLayerPopupVo> list(ZLayerPopupVo zLayerPopupVo);
	public void popupWrite(ZLayerPopupVo zLayerPopupVo);
	public int listCount(ZLayerPopupVo zLayerPopupVo);
	public ZLayerPopupVo detail(ZLayerPopupVo zLayerPopupVo);
	public void popupDelete(List<Integer> arrDeleteNo);
	public void popupUseDelete(List<Integer> arrDeleteNo);
	public void update(ZLayerPopupVo zLayerPopupVo);
	public void updateAttach(ZLayerPopupVo zLayerPopupVo);

}