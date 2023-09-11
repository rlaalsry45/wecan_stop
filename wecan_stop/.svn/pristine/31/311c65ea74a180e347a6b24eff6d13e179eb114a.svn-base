package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZMemberUseVo;
import com.z5.zcms.admsys.module.domain.ZMemberVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZMemberDAOImpl extends EgovComAbstractDAO implements ZMemberDAO {

	//@Autowired
	//private ZMemberVo zMemberVo;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZMember.";

	public void memberWrite(ZMemberVo zMemberVo) {
		insert(sqlMapNs + "memberWrite", zMemberVo);
	}

	@SuppressWarnings("unchecked")
	public List<ZMemberVo> list(ZMemberVo zMemberVo) {
		return (List<ZMemberVo>) list(sqlMapNs + "list", zMemberVo);
	}

	public int listCount(ZMemberVo zMemberVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", zMemberVo);
	}

	public ZMemberVo detail(ZMemberVo zMemberVo) {
		return (ZMemberVo)selectByPk(sqlMapNs + "getDetailInfo", zMemberVo);
	}

	public void memberDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "memberDelete", arrDeleteNo);
	}

	public void memberUseDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "memberUseDelete", arrDeleteNo);
	}

	public void update(ZMemberVo zMemberVo)
	{
		update(sqlMapNs + "update", zMemberVo);
	}
	
	public ZMemberUseVo getRowBySitenoFromZMemberUse(ZMemberUseVo vo) {
		return (ZMemberUseVo)selectByPk(sqlMapNs + "getRowBySitenoFromZMemberUse", vo);
		
	}

}