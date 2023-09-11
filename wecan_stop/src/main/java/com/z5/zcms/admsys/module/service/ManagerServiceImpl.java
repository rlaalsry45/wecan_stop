package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.module.dao.ZManagerDAO;
import com.z5.zcms.admsys.module.dao.ZManagerHisDAO;
import com.z5.zcms.admsys.module.domain.ZManagerHisVo;
import com.z5.zcms.admsys.module.domain.ZManagerVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
@Transactional
public class ManagerServiceImpl extends AbstractServiceImpl implements ManagerService {

	@Autowired
	private ZManagerDAO zManagerDAO;
	
	@Autowired
	private ZManagerHisDAO zManagerHisDAO;
	
	@Transactional
	public void managerWrite(ZManagerVo zManagerVo) {
		this.zManagerDAO.managerWrite(zManagerVo);
	}

	public List<ZManagerVo> getManagerList(ZManagerVo zManagerVo) {
		return this.zManagerDAO.list(zManagerVo);
	}

	public int listCount(ZManagerVo zManagerVo) {
		return this.zManagerDAO.listCount(zManagerVo);
	}

	public List<ZManagerHisVo> getManagerHisList(ZManagerVo zManagerVo) {
		return this.zManagerHisDAO.list(zManagerVo);
	}
	@Transactional
	public void managerHisDelete(ZManagerHisVo zManagerHisVo) {
		this.zManagerHisDAO.delete(zManagerHisVo);
	}
	
	public Object managerDetail(Object obj) {

		if (obj instanceof ZManagerHisVo) {
			// 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
			return this.zManagerHisDAO.detail((ZManagerHisVo)obj);
		}
		else {
			return this.zManagerDAO.detail((ZManagerVo)obj);
		}
	}
	@Transactional
	public void managerDelete(List<Integer> arrDeleteNo) {
		// zManager table 삭제
		this.zManagerDAO.managerDelete(arrDeleteNo);
		// zManageruse table 삭제
		this.zManagerDAO.managerUseDelete(arrDeleteNo);
		this.zManagerHisDAO.managerHisDelete(arrDeleteNo);
	}
	@Transactional
	public void managerEdit(ZManagerVo zManagerVo) {
		if ("1".equals(zManagerVo.getHis())){
			// 새로운 히스토리 입력
			this.zManagerHisDAO.insert(zManagerVo);
		}
		// 수정내용 갱신
		this.zManagerDAO.update(zManagerVo);
	}
}
