package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.module.dao.ZEventDAO;
import com.z5.zcms.admsys.module.dao.ZEventHisDAO;
import com.z5.zcms.admsys.module.domain.ZEventHisVo;
import com.z5.zcms.admsys.module.domain.ZEventVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
@Transactional
public class EventServiceImpl extends AbstractServiceImpl implements EventService {

	@Autowired
	private ZEventDAO zEventDAO;
	
	@Autowired
	private ZEventHisDAO zEventHisDAO;
	
	@Transactional
	public void eventWrite(ZEventVo zEventVo) {
		this.zEventDAO.eventWrite(zEventVo);
	}

	public List<ZEventVo> getEventList(ZEventVo zEventVo) {
		return this.zEventDAO.list(zEventVo);
	}

	public int listCount(ZEventVo zEventVo) {
		return this.zEventDAO.listCount(zEventVo);
	}

	public List<ZEventHisVo> getEventHisList(ZEventVo zEventVo) {
		return this.zEventHisDAO.list(zEventVo);
	}
	@Transactional
	public void eventHisDelete(ZEventHisVo zEventHisVo) {
		this.zEventHisDAO.delete(zEventHisVo);
	}
	
	public Object eventDetail(Object obj) {

		if (obj instanceof ZEventHisVo) {
			// 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
			return this.zEventHisDAO.detail((ZEventHisVo)obj);
		}
		else {
			return this.zEventDAO.detail((ZEventVo)obj);
		}
	}
	@Transactional
	public void eventDelete(List<Integer> arrDeleteNo) {
		// zEvent table 삭제
		this.zEventDAO.eventDelete(arrDeleteNo);
		// zEventuse table 삭제
		this.zEventDAO.eventUseDelete(arrDeleteNo);
		this.zEventHisDAO.eventHisDelete(arrDeleteNo);
	}
	@Transactional
	public void eventEdit(ZEventVo zEventVo) {
		if ("1".equals(zEventVo.getHis())){
			// 새로운 히스토리 입력
			this.zEventHisDAO.insert(zEventVo);
		}
		// 수정내용 갱신
		this.zEventDAO.update(zEventVo);
	}
}
