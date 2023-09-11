package com.z5.zcms.admsys.module.service;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZLayerPopupHisVo;
import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;

public interface LayerPopupService {

	/*ZLayerPopup Line*/
	public List<ZLayerPopupVo> getPopupList(ZLayerPopupVo zLayerPopupVo);
	public void popupWrite(ZLayerPopupVo zLayerPopupVo);
	public int listCount(ZLayerPopupVo zLayerPopupVo);
	public Object popupDetail(Object obj);
	public void popupDelete(List<Integer> arrDeleteNo);
	public void popupEdit(ZLayerPopupVo zLayerPopupVo);
	public void updateAttach(ZLayerPopupVo zLayerPopupVo);
	
	/*ZLayerPopupHis Line*/
	public List<ZLayerPopupHisVo> getPopupHisList(ZLayerPopupVo zLayerPopupVo);
	public void popupHisDelete(ZLayerPopupHisVo zLayerPopupHisVo);
	public Integer attachCount(String popupimg_org);
}

