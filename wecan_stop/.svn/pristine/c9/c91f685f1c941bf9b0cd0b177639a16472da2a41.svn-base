package com.z5.zcms.admsys.board.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.board.domain.ZBoardAuthAdminVo;
import com.z5.zcms.admsys.board.domain.ZBoardAuthVo;
import com.z5.zcms.admsys.board.domain.ZBoardGroupVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZBoardDAOImpl extends EgovComAbstractDAO implements ZBoardDAO {

	private final String sqlMapNs = "ZBoard.";

	@SuppressWarnings("unchecked")
	public List<ZBoardVo> list(ZBoardVo zBoardVo) throws Exception{
		return (List<ZBoardVo>) listWithPaging(sqlMapNs + "list", zBoardVo, zBoardVo.getPageIndex(), zBoardVo.getPageSize());
	}
	
	@SuppressWarnings("unchecked")
	public List<ZBoardVo> listAll() throws Exception{
		return (List<ZBoardVo>) list(sqlMapNs + "listAll", null);
	}

	public int listCount(ZBoardVo zBoardVo) throws Exception{
		return (Integer) selectByPk(sqlMapNs + "listCount", zBoardVo);
	}
	
	public ZBoardVo boardDetail(int boardno) throws Exception{
		return (ZBoardVo)selectByPk(sqlMapNs + "boardDetail", boardno);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZBoardGroupVo> getBoardGrouplist(int boardno) throws Exception{
		return (List<ZBoardGroupVo>) list(sqlMapNs + "getBoardGrouplist", boardno);
	}
	
	public int boardAdminBoard(ZBoardAuthAdminVo zBoardAuthAdminVo) throws Exception{
		return (Integer)selectByPk(sqlMapNs + "boardAdminBoard", zBoardAuthAdminVo);
	}
	
	public int boardTableSeq(HashMap<String, Object> hs) throws Exception{
		
		String tblname = (String)selectByPk(sqlMapNs + "boardTableSeq", hs.get("skintype"));
		
		if(tblname == null) return 100;
		else{
			
			String org_tblname = hs.get("skintype").equals("1") ? "ZBOARDPHOTOGALLERY" : "ZBOARDCOMMON";
			
			tblname = tblname.toUpperCase().replace(org_tblname, "");
			
			return Integer.parseInt(tblname)+1;
		}
//		getSqlMapClient().queryForObject(sqlMapNs + "boardTableSeq", hs.get("skintype"));
		
//		return Integer.parseInt(hs.get("seq").toString());
	}
	
	public void boardTableCreate(String tblname) throws Exception{
//		getSqlMapClient().queryForObject(sqlMapNs + "boardTableCreate", tblname);
		update(sqlMapNs + "boardTableCreate1", tblname);
		update(sqlMapNs + "boardTableCreate2", tblname);
	}
	
	@Transactional
	public void boardCreate(ZBoardVo zBoardVo) throws Exception{
		zBoardVo.setBoardno((Integer) insert(sqlMapNs + "boardCreate", zBoardVo));
		if (zBoardVo.getGroupno()>0) insert(sqlMapNs + "boardGroupInsert", zBoardVo);
		
		List<ZBoardAuthVo> authlist = zBoardVo.getAuthlist();
		
		for (int i = 0; i < authlist.size(); i++) {
			zBoardVo.setAuthVo(authlist.get(i));
			update(sqlMapNs + "boardAuthSet", zBoardVo);
		}
		
		
		if (null!=zBoardVo.getAdminlist()) getSqlMapClient().queryForObject(sqlMapNs + "boardAdminSet", zBoardVo);
	}
	
	@Transactional
	public void boardUpdate(ZBoardVo zBoardVo) throws Exception{
		update(sqlMapNs + "boardUpdate", zBoardVo);
		
		
		if (zBoardVo.getGroupno_dest() != null){
			
			for (int i = 0; i < zBoardVo.getGroupno_dest().length; i++) {
				zBoardVo.setGroupno(Integer.parseInt(zBoardVo.getGroupno_dest()[i]));
				update(sqlMapNs + "boardGroupUpdate", zBoardVo);
			}
			
			
		}
		/*else{
			if (zBoardVo.getGroupno_org()>0) delete(sqlMapNs + "boardGroupDelete", zBoardVo);
		}*/
		
		delete(sqlMapNs + "boardGroupDelete", zBoardVo);
		
		
		List<ZBoardAuthVo> authlist = zBoardVo.getAuthlist();
		for (int i = 0; i < authlist.size(); i++) {
			zBoardVo.setAuthVo(authlist.get(i));
			update(sqlMapNs + "boardAuthSet", zBoardVo);
		}
		
		if (!zBoardVo.getAdminlist().isEmpty()) getSqlMapClient().queryForObject(sqlMapNs + "boardAdminSet", zBoardVo);
		delete(sqlMapNs + "boardAdminOmitDelete", zBoardVo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZBoardAuthAdminVo> boardAdminList() throws Exception{
		return (List<ZBoardAuthAdminVo>) list(sqlMapNs + "boardAdminList", null);
	}
	
	public int boardDupCheck(String tblname) throws Exception{
		return (Integer) selectByPk(sqlMapNs + "boardDupCheck", tblname);
	}
	
	public void boardTableDrop(String tblname) throws Exception{
		delete(sqlMapNs + "boardTableDrop2", tblname);
	}

	@Transactional
	public void boardDelete(List<Integer> arrDeleteNo) throws Exception{
		delete(sqlMapNs + "boardDelete", arrDeleteNo);
	}
	
	public String boardTableName(int boardno) throws Exception{
		return (String)selectByPk(sqlMapNs + "boardTableName", boardno);
	}
	
	@Transactional
	public void boardCopy(ZBoardVo zBoardVo) throws Exception{
		zBoardVo.setBoardno((Integer) insert(sqlMapNs + "boardCopy", zBoardVo));
		insert(sqlMapNs + "boardGroupCopy", zBoardVo);
		insert(sqlMapNs + "boardAuthCopy", zBoardVo);
		insert(sqlMapNs + "boardAdminCopy", zBoardVo);
		insert(sqlMapNs + "boardCateCopy", zBoardVo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZBoardGroupVo> boardGroupSel(String adminno) throws Exception{
		return (List<ZBoardGroupVo>) list(sqlMapNs + "boardGroupSel", adminno);
	}
	
	public int boardTitleDupChk(ZBoardVo zBoardVo) throws Exception{
		return (Integer) selectByPk(sqlMapNs + "boardTitleDupChk", zBoardVo);
	}
	
	public int boardPostsAuthChk(ZBoardVo zBoardVo) throws Exception{
		return (Integer) selectByPk(sqlMapNs + "boardPostsAuthChk", zBoardVo);
	}
	
	public int boardUseSite(int boardno) throws Exception{
		return (Integer) selectByPk(sqlMapNs + "boardUseSite", boardno);
	}
	
	public String boardUserno(String userid) throws Exception{
		return (String) selectByPk(sqlMapNs + "boardUserno", userid);
	}
	
	public String boardUserid(String userno) throws Exception{
		return (String) selectByPk(sqlMapNs + "boardUserid", userno);
	}
}