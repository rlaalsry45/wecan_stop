package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZPopupHisVo;
import com.z5.zcms.admsys.module.domain.ZPopupVo;

public interface ZPopupHisDAO {
	public List<ZPopupHisVo> list(ZPopupVo zPopupVo);
	public ZPopupHisVo detail(ZPopupHisVo zPopupHisVo);
	public void insert(ZPopupVo zPopupVo);
	public void delete(ZPopupHisVo zPopupHisVo);
	public void popupHisDelete(List<Integer> arrDeleteNo);
	public Integer attachCount(String popimg_org);
}
