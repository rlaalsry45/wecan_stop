package com.z5.zcms.admsys.module.service;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZPopupHisVo;
import com.z5.zcms.admsys.module.domain.ZPopupVo;

public interface PopupService {

	/*ZPopup Line*/
	public List<ZPopupVo> getPopupList(ZPopupVo zPopupVo);
	public void popupWrite(ZPopupVo zPopupVo);
	public int listCount(ZPopupVo zPopupVo);
	public Object popupDetail(Object obj);
	public void popupDelete(List<Integer> arrDeleteNo);
	public void popupEdit(ZPopupVo zPopupVo);
	public void updateAttach(ZPopupVo zPopupVo);
	
	/*ZPopupHis Line*/
	public List<ZPopupHisVo> getPopupHisList(ZPopupVo zPopupVo);
	public void popupHisDelete(ZPopupHisVo zPopupHisVo);
	public Integer attachCount(String popupimg_org);
}

