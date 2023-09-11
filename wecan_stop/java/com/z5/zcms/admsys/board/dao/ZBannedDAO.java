package com.z5.zcms.admsys.board.dao;

import com.z5.zcms.admsys.board.domain.ZBannedVo;

public interface ZBannedDAO {
	public ZBannedVo detail(ZBannedVo zBannedVo);
	public void insert(ZBannedVo zBannedVo);
}
