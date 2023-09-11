package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.module.dao.ZPopupDAO;
import com.z5.zcms.admsys.module.dao.ZPopupHisDAO;
import com.z5.zcms.admsys.module.domain.ZPopupHisVo;
import com.z5.zcms.admsys.module.domain.ZPopupVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class PopupServiceImpl extends AbstractServiceImpl implements PopupService {

	@Autowired
	private ZPopupDAO zPopupDAO;
	
	@Autowired
	private ZPopupHisDAO zPopupHisDAO;
	
	@Transactional
	public void popupWrite(ZPopupVo zPopupVo) {
		this.zPopupDAO.popupWrite(zPopupVo);
	}

	public List<ZPopupVo> getPopupList(ZPopupVo zPopupVo) {
		return this.zPopupDAO.list(zPopupVo);
	}

	public int listCount(ZPopupVo zPopupVo) {
		return this.zPopupDAO.listCount(zPopupVo);
	}
	
	public Integer attachCount(String popupimg_org) {
		return this.zPopupHisDAO.attachCount(popupimg_org);
	}
	@Transactional
	public void updateAttach(ZPopupVo zPopupVo){
		this.zPopupDAO.updateAttach(zPopupVo);
	}

	public List<ZPopupHisVo> getPopupHisList(ZPopupVo zPopupVo) {
		return this.zPopupHisDAO.list(zPopupVo);
	}
	@Transactional
	public void popupHisDelete(ZPopupHisVo zPopupHisVo) {
		this.zPopupHisDAO.delete(zPopupHisVo);
	}
	
	public Object popupDetail(Object obj) {

		if (obj instanceof ZPopupHisVo) {
			// 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
			return this.zPopupHisDAO.detail((ZPopupHisVo)obj);
		}
		else {
			return this.zPopupDAO.detail((ZPopupVo)obj);
		}
	}
	@Transactional
	public void popupDelete(List<Integer> arrDeleteNo) {
		// zPopup table 삭제
		this.zPopupDAO.popupDelete(arrDeleteNo);
		// zPopupuse table 삭제
		this.zPopupDAO.popupUseDelete(arrDeleteNo);
		// zPopuphis table 삭제
		this.zPopupHisDAO.popupHisDelete(arrDeleteNo);
	}
	@Transactional
	public void popupEdit(ZPopupVo zPopupVo) {
		if ("1".equals(zPopupVo.getHis())){
			// 새로운 히스토리 입력
			this.zPopupHisDAO.insert(zPopupVo);
		}
		// 수정내용 갱신
		this.zPopupDAO.update(zPopupVo);
	}
}
