package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.module.dao.ZEvalDAO;
import com.z5.zcms.admsys.module.dao.ZEvalHisDAO;
import com.z5.zcms.admsys.module.domain.ZEvalHisVo;
import com.z5.zcms.admsys.module.domain.ZEvalVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
@Transactional
public class EvalServiceImpl extends AbstractServiceImpl implements EvalService {

	@Autowired
	private ZEvalDAO zEvalDAO;
	
	@Autowired
	private ZEvalHisDAO zEvalHisDAO;
	
	@Transactional
	public void evalWrite(ZEvalVo zEvalVo) {
		this.zEvalDAO.evalWrite(zEvalVo);
	}

	public List<ZEvalVo> getEvalList(ZEvalVo zEvalVo) {
		return this.zEvalDAO.list(zEvalVo);
	}

	public int listCount(ZEvalVo zEvalVo) {
		return this.zEvalDAO.listCount(zEvalVo);
	}

	public List<ZEvalHisVo> getEvalHisList(ZEvalVo zEvalVo) {
		return this.zEvalHisDAO.list(zEvalVo);
	}
	@Transactional
	public void evalHisDelete(ZEvalHisVo zEvalHisVo) {
		this.zEvalHisDAO.delete(zEvalHisVo);
	}
	
	public Object evalDetail(Object obj) {

		if (obj instanceof ZEvalHisVo) {
			// 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
			return this.zEvalHisDAO.detail((ZEvalHisVo)obj);
		}
		else {
			return this.zEvalDAO.detail((ZEvalVo)obj);
		}
	}
	@Transactional
	public void evalDelete(List<Integer> arrDeleteNo) {
		// zEval table 삭제
		this.zEvalDAO.evalDelete(arrDeleteNo);
		// zEvaluse table 삭제
		this.zEvalDAO.evalUseDelete(arrDeleteNo);
		this.zEvalHisDAO.evalHisDelete(arrDeleteNo);
	}
	@Transactional
	public void evalEdit(ZEvalVo zEvalVo) {
		if ("1".equals(zEvalVo.getHis())){
			// 새로운 히스토리 입력
			this.zEvalHisDAO.insert(zEvalVo);
		}
		// 수정내용 갱신
		this.zEvalDAO.update(zEvalVo);
	}
}
