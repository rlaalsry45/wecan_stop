package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.module.dao.ZMemberDAO;
import com.z5.zcms.admsys.module.dao.ZMemberHisDAO;
import com.z5.zcms.admsys.module.domain.ZMemberHisVo;
import com.z5.zcms.admsys.module.domain.ZMemberUseVo;
import com.z5.zcms.admsys.module.domain.ZMemberVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
@Transactional
public class MemberServiceImpl extends AbstractServiceImpl implements MemberService {

	@Autowired
	private ZMemberDAO zMemberDAO;
	
	@Autowired
	private ZMemberHisDAO zMemberHisDAO;
	
	@Transactional
	public void memberWrite(ZMemberVo zMemberVo) {
		this.zMemberDAO.memberWrite(zMemberVo);
	}

	public List<ZMemberVo> getMemberList(ZMemberVo zMemberVo) {
		return this.zMemberDAO.list(zMemberVo);
	}

	public int listCount(ZMemberVo zMemberVo) {
		return this.zMemberDAO.listCount(zMemberVo);
	}

	public List<ZMemberHisVo> getMemberHisList(ZMemberVo zMemberVo) {
		return this.zMemberHisDAO.list(zMemberVo);
	}
	@Transactional
	public void memberHisDelete(ZMemberHisVo zMemberHisVo) {
		this.zMemberHisDAO.delete(zMemberHisVo);
	}
	
	public Object memberDetail(Object obj) {

		if (obj instanceof ZMemberHisVo) {
			// 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
			return this.zMemberHisDAO.detail((ZMemberHisVo)obj);
		}
		else {
			return this.zMemberDAO.detail((ZMemberVo)obj);
		}
	}
	@Transactional
	public void memberDelete(List<Integer> arrDeleteNo) {
		// zMember table 삭제
		this.zMemberDAO.memberDelete(arrDeleteNo);
		// zMemberuse table 삭제
		this.zMemberDAO.memberUseDelete(arrDeleteNo);
		this.zMemberHisDAO.memberHisDelete(arrDeleteNo);
	}
	@Transactional
	public void memberEdit(ZMemberVo zMemberVo) {
		if ("1".equals(zMemberVo.getHis())){
			// 새로운 히스토리 입력
			this.zMemberHisDAO.insert(zMemberVo);
		}
		// 수정내용 갱신
		this.zMemberDAO.update(zMemberVo);
	}
	
	public ZMemberUseVo getRowBySitenoFromZMemberUse(ZMemberUseVo vo){
		return this.zMemberDAO.getRowBySitenoFromZMemberUse(vo);
	}
}
