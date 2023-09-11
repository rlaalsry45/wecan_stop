package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZLayerPopupHisVo;
import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;

public interface ZLayerPopupHisDAO {
	public List<ZLayerPopupHisVo> list(ZLayerPopupVo zLayerPopupVo);
	public ZLayerPopupHisVo detail(ZLayerPopupHisVo zLayerPopupHisVo);
	public void insert(ZLayerPopupVo zLayerPopupVo);
	public void delete(ZLayerPopupHisVo zLayerPopupHisVo);
	public void popupHisDelete(List<Integer> arrDeleteNo);
	public Integer attachCount(String popimg_org);
}
