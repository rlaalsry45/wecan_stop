package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.module.dao.ZLayerPopupDAO;
import com.z5.zcms.admsys.module.dao.ZLayerPopupHisDAO;
import com.z5.zcms.admsys.module.domain.ZLayerPopupHisVo;
import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class LayerPopupServiceImpl extends AbstractServiceImpl implements LayerPopupService {

	@Autowired
	private ZLayerPopupDAO zLayerPopupDAO;
	
	@Autowired
	private ZLayerPopupHisDAO zLayerPopupHisDAO;
	
	@Transactional
	public void popupWrite(ZLayerPopupVo zLayerPopupVo) {
		this.zLayerPopupDAO.popupWrite(zLayerPopupVo);
	}

	public List<ZLayerPopupVo> getPopupList(ZLayerPopupVo zLayerPopupVo) {
		return this.zLayerPopupDAO.list(zLayerPopupVo);
	}

	public int listCount(ZLayerPopupVo zLayerPopupVo) {
		return this.zLayerPopupDAO.listCount(zLayerPopupVo);
	}
	
	public Integer attachCount(String popupimg_org) {
		return this.zLayerPopupHisDAO.attachCount(popupimg_org);
	}
	@Transactional
	public void updateAttach(ZLayerPopupVo zLayerPopupVo){
		this.zLayerPopupDAO.updateAttach(zLayerPopupVo);
	}

	public List<ZLayerPopupHisVo> getPopupHisList(ZLayerPopupVo zLayerPopupVo) {
		return this.zLayerPopupHisDAO.list(zLayerPopupVo);
	}
	@Transactional
	public void popupHisDelete(ZLayerPopupHisVo zLayerPopupHisVo) {
		this.zLayerPopupHisDAO.delete(zLayerPopupHisVo);
	}
	
	public Object popupDetail(Object obj) {

		if (obj instanceof ZLayerPopupHisVo) {
			// 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
			return this.zLayerPopupHisDAO.detail((ZLayerPopupHisVo)obj);
		}
		else {
			return this.zLayerPopupDAO.detail((ZLayerPopupVo)obj);
		}
	}
	@Transactional
	public void popupDelete(List<Integer> arrDeleteNo) {
		// zLayerPopup table 삭제
		this.zLayerPopupDAO.popupDelete(arrDeleteNo);
		// zLayerPopupuse table 삭제
		this.zLayerPopupDAO.popupUseDelete(arrDeleteNo);
		// zLayerPopuphis table 삭제
		this.zLayerPopupHisDAO.popupHisDelete(arrDeleteNo);
	}
	@Transactional
	public void popupEdit(ZLayerPopupVo zLayerPopupVo) {
		if ("1".equals(zLayerPopupVo.getHis())){
			// 새로운 히스토리 입력
			this.zLayerPopupHisDAO.insert(zLayerPopupVo);
		}
		// 수정내용 갱신
		this.zLayerPopupDAO.update(zLayerPopupVo);
	}
}
