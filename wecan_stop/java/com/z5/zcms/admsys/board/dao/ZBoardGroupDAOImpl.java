package com.z5.zcms.admsys.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.board.domain.ZBoardGroupAdminVo;
import com.z5.zcms.admsys.board.domain.ZBoardGroupMemberVo;
import com.z5.zcms.admsys.board.domain.ZBoardGroupVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZBoardGroupDAOImpl extends EgovComAbstractDAO implements ZBoardGroupDAO {

	private final String sqlMapNs = "ZBoardGroup.";
	
	public int listCount(ZBoardGroupVo zBoardGroupVo) throws Exception{
		return (Integer) selectByPk(sqlMapNs + "listCount", zBoardGroupVo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZBoardGroupVo> list(ZBoardGroupVo zBoardGroupVo) throws Exception{
		return (List<ZBoardGroupVo>) listWithPaging(sqlMapNs + "list", zBoardGroupVo, zBoardGroupVo.getPageIndex(), zBoardGroupVo.getPageSize());
	}

	public int boardGroupDupChk(String groupnm) throws Exception{
		return (Integer) selectByPk(sqlMapNs + "boardGroupDupChk", groupnm);
	}
	
	public void boardGroupCreate(ZBoardGroupVo zBoardGroupVo) throws Exception{
		insert(sqlMapNs + "boardGroupCreate", zBoardGroupVo);
	}
	
	public ZBoardGroupVo getBoardGroupInfo(int groupno) throws Exception{
		return (ZBoardGroupVo) selectByPk(sqlMapNs + "getBoardGroupInfo", groupno);
	}
	
	@Transactional
	public void boardGroupMemberAdminSet(ZBoardGroupVo zBoardGroupVo) throws Exception{ 
		if (null!=zBoardGroupVo.getzBoardGroupMemberVo()){
			
			List<ZBoardGroupMemberVo> authlist = zBoardGroupVo.getzBoardGroupMemberVo();
			
			for (int i = 0; i < authlist.size(); i++) {
				zBoardGroupVo.setzBoardGMVo(authlist.get(i));
				update(sqlMapNs + "boardGroupMemberSet", zBoardGroupVo);
			}
			
			//getSqlMapClient().queryForObject(sqlMapNs + "boardGroupMemberSet", zBoardGroupVo);
			
		}
		if (null!=zBoardGroupVo.getzBoardGroupAdminVo()){
			
			
			List<ZBoardGroupAdminVo> authlist = zBoardGroupVo.getzBoardGroupAdminVo();
			
			for (int i = 0; i < authlist.size(); i++) {
				zBoardGroupVo.setzBoardGAVo(authlist.get(i));
				update(sqlMapNs + "boardGroupAdminSet", zBoardGroupVo);
			}
			
			//getSqlMapClient().queryForObject(sqlMapNs + "boardGroupAdminSet", zBoardGroupVo);
			
		}
		delete(sqlMapNs + "boardGroupMemberOmitDelete", zBoardGroupVo);
		delete(sqlMapNs + "boardGroupAdminOmitDelete", zBoardGroupVo);
	}

	public void boardGroupMutilDelete(ZBoardGroupVo zBoardGroupVo) throws Exception{
		delete(sqlMapNs + "boardGroupMutilDelete", zBoardGroupVo);
		
	}
	
	public int boardGroupAdminCount(String adminno) throws Exception{
		return (Integer)selectByPk(sqlMapNs + "boardGroupAdminCount", adminno);
	}
}