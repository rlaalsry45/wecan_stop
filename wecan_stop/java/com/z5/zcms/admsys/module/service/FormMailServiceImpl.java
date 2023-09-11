package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.module.dao.ZFormMailDAO;
import com.z5.zcms.admsys.module.dao.ZFormMailHisDAO;
import com.z5.zcms.admsys.module.domain.ZFormMailHisVo;
import com.z5.zcms.admsys.module.domain.ZFormMailVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
@Transactional
public class FormMailServiceImpl extends AbstractServiceImpl implements FormMailService {

	@Autowired
	private ZFormMailDAO zFormMailDAO;
	
	@Autowired
	private ZFormMailHisDAO zFormMailHisDAO;
	
	@Transactional
	public void formMailWrite(ZFormMailVo zFormMailVo) {
		this.zFormMailDAO.formMailWrite(zFormMailVo);
	}

	public List<ZFormMailVo> getFormMailList(ZFormMailVo zFormMailVo) {
		return this.zFormMailDAO.list(zFormMailVo);
	}

	public int listCount(ZFormMailVo zFormMailVo) {
		return this.zFormMailDAO.listCount(zFormMailVo);
	}

	public List<ZFormMailHisVo> getFormMailHisList(ZFormMailVo zFormMailVo) {
		return this.zFormMailHisDAO.list(zFormMailVo);
	}
	@Transactional
	public void formMailHisDelete(ZFormMailHisVo zFormMailHisVo) {
		this.zFormMailHisDAO.delete(zFormMailHisVo);
	}
	
	public Object formMailDetail(Object obj) {

		if (obj instanceof ZFormMailHisVo) {
			// 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
			return this.zFormMailHisDAO.detail((ZFormMailHisVo)obj);
		}
		else {
			return this.zFormMailDAO.detail((ZFormMailVo)obj);
		}
	}
	@Transactional
	public void formMailDelete(List<Integer> arrDeleteNo) {
		// zFormMail table 삭제
		this.zFormMailDAO.formMailDelete(arrDeleteNo);
		// zFormMailuse table 삭제
		this.zFormMailDAO.formMailUseDelete(arrDeleteNo);
		this.zFormMailHisDAO.formMailHisDelete(arrDeleteNo);
	}
	@Transactional
	public void formMailEdit(ZFormMailVo zFormMailVo) {
		if ("1".equals(zFormMailVo.getHis())){
			// 새로운 히스토리 입력
			this.zFormMailHisDAO.insert(zFormMailVo);
		}
		// 수정내용 갱신
		this.zFormMailDAO.update(zFormMailVo);
	}
}
