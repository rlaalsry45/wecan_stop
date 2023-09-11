package com.z5.zcms.admsys.board.service;

import com.z5.zcms.util.DataTable;

public interface BoardGroupService {
	public DataTable boardGroupList(DataTable dt) throws Exception;
	public DataTable boardGroupCreate(DataTable dt) throws Exception;
	public DataTable boardGroupSetView(DataTable dt) throws Exception;
	public DataTable boardGroupSet(DataTable dt) throws Exception;
	public DataTable boardGroupMutilDelete(DataTable dt) throws Exception;
}
