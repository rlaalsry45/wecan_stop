package com.z5.zcms.admsys.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.board.dao.ZBoardDAO;
import com.z5.zcms.admsys.board.dao.ZBoardGroupDAO;
import com.z5.zcms.admsys.board.domain.ZBoardGroupAdminVo;
import com.z5.zcms.admsys.board.domain.ZBoardGroupMemberVo;
import com.z5.zcms.admsys.board.domain.ZBoardGroupVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class BoardGroupServiceImpl extends AbstractServiceImpl implements BoardGroupService {

	@Autowired
	private ZBoardGroupDAO zBoardGroupDAO;

	@Autowired
	private ZBoardDAO zBoardDAO;

	@Autowired
	private MessageSource messageSource;

	public DataTable boardGroupList(DataTable dt) throws Exception{

		ZBoardGroupVo zBoardGroupVo = (ZBoardGroupVo) dt.getObject("zBoardGroupVo");

		if (zBoardGroupVo.getSdate().isEmpty() && zBoardGroupVo.getEdate().isEmpty()) zBoardGroupVo.setCond1("");
		if (zBoardGroupVo.getKeyword().isEmpty()) zBoardGroupVo.setCond2("");

		zBoardGroupVo.setPageIndex(zBoardGroupVo.getPageIndex()<1 ? 0 : zBoardGroupVo.getPageIndex()-1);

		dt.put("total", zBoardGroupDAO.listCount(zBoardGroupVo));
		dt.put("pageSize", zBoardGroupVo.getPageSize());
		dt.put("pageIndex", zBoardGroupVo.getPageIndex()+1);
		dt.put("pageMax", (int)Math.ceil((double)dt.getInt("total")/zBoardGroupVo.getPageSize()));
		dt.put("list", zBoardGroupDAO.list(zBoardGroupVo));

		return dt;
	}

	public DataTable boardGroupCreate(DataTable dt) throws Exception{

		if (zBoardGroupDAO.boardGroupDupChk(dt.get("groupnm").trim())>0){
			dt.put("Duplicate", messageSource.getMessage("board.dupchk", null, Locale.getDefault()));
		}
		else{
			ZBoardGroupVo zBoardGroupVo = new ZBoardGroupVo();
			zBoardGroupVo.setUserid(((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());
			zBoardGroupVo.setGroupnm(dt.get("groupnm").trim());
			zBoardGroupDAO.boardGroupCreate(zBoardGroupVo);
		}

		return dt;
	}

	public DataTable boardGroupSetView(DataTable dt) throws Exception{

		dt.put("boardGroupInfo", zBoardGroupDAO.getBoardGroupInfo(dt.getInt("groupno")));

		return dt;
	}

	public DataTable boardGroupSet(DataTable dt) throws Exception{

		String[] boardnoArr = {};
		String[] usernoArr = {};

		if (!dt.get("boardnos").isEmpty()) boardnoArr = dt.get("boardnos").split(",");
		if (!dt.get("usernos").isEmpty()) usernoArr = dt.get("usernos").split(",");

		ZBoardGroupVo zBoardGroupVo = new ZBoardGroupVo();
		zBoardGroupVo.setGroupno(dt.getInt("groupno"));
		zBoardGroupVo.setUserid(((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());

		List<ZBoardGroupMemberVo> zBoardGroupMemberVoList = new ArrayList<ZBoardGroupMemberVo>();
		for (String boardno : boardnoArr){
			ZBoardGroupMemberVo zBoardGroupMemberVo = new ZBoardGroupMemberVo();
			zBoardGroupMemberVo.setBoardno(Integer.parseInt(boardno));
			zBoardGroupMemberVoList.add(zBoardGroupMemberVo);
		}
		if (zBoardGroupMemberVoList.size()>0) zBoardGroupVo.setzBoardGroupMemberVo(zBoardGroupMemberVoList);

		List<ZBoardGroupAdminVo> zBoardGroupAdminVoList = new ArrayList<ZBoardGroupAdminVo>();
		for (String userid : usernoArr){
			ZBoardGroupAdminVo zBoardGroupAdminVo = new ZBoardGroupAdminVo();
			zBoardGroupAdminVo.setUserno(Integer.parseInt(zBoardDAO.boardUserno(userid)));
			zBoardGroupAdminVoList.add(zBoardGroupAdminVo);
		}
		if (zBoardGroupAdminVoList.size()>0) zBoardGroupVo.setzBoardGroupAdminVo(zBoardGroupAdminVoList);
		zBoardGroupDAO.boardGroupMemberAdminSet(zBoardGroupVo);

		return dt;
	}

	public DataTable boardGroupMutilDelete(DataTable dt) throws Exception{

		ZBoardGroupVo zBoardGroupVo = new ZBoardGroupVo();
		List<Integer> intList = new ArrayList<Integer>();
		for (String delNo : dt.getValues("groupno")) intList.add(Integer.valueOf(delNo));
		zBoardGroupVo.setArrDeleteNo(intList);
		zBoardGroupDAO.boardGroupMutilDelete(zBoardGroupVo);

		return dt;
	}
}
