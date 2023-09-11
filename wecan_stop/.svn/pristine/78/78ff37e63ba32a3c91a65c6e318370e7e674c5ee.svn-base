package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZMemberUseVo;
import com.z5.zcms.admsys.module.domain.ZMemberVo;

public interface ZMemberDAO {

	public List<ZMemberVo> list(ZMemberVo zMemberVo);
	public void memberWrite(ZMemberVo zMemberVo);
	public int listCount(ZMemberVo zMemberVo);
	public ZMemberVo detail(ZMemberVo zMemberVo);
	public void memberDelete(List<Integer> arrDeleteNo);
	public void memberUseDelete(List<Integer> arrDeleteNo);
	public void update(ZMemberVo zMemberVo);

	public ZMemberUseVo getRowBySitenoFromZMemberUse(ZMemberUseVo vo);
}