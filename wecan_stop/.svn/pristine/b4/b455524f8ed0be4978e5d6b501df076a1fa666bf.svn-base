package com.z5.zcms.admsys.module.service;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZMemberHisVo;
import com.z5.zcms.admsys.module.domain.ZMemberUseVo;
import com.z5.zcms.admsys.module.domain.ZMemberVo;

public interface MemberService {

	/*ZMember Line*/
	public List<ZMemberVo> getMemberList(ZMemberVo zMemberVo);
	public void memberWrite(ZMemberVo zMemberVo);
	public int listCount(ZMemberVo zMemberVo);
	public Object memberDetail(Object obj);
	public void memberDelete(List<Integer> arrDeleteNo);
	public void memberEdit(ZMemberVo zMemberVo);
	
	/*ZMemberHis Line*/
	public List<ZMemberHisVo> getMemberHisList(ZMemberVo zMemberVo);
	public void memberHisDelete(ZMemberHisVo zMemberHisVo);
	
	/*ZMemberUse Line*/
	public ZMemberUseVo getRowBySitenoFromZMemberUse(ZMemberUseVo vo);
}

