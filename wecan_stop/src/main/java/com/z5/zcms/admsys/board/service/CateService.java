package com.z5.zcms.admsys.board.service;

import com.z5.zcms.util.DataTable;

public interface CateService {
	public DataTable boardCateList(DataTable dt) throws Exception;
	public DataTable boardCateSet(DataTable dt) throws Exception;
}