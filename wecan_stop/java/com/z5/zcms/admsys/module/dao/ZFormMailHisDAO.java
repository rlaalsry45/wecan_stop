package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZFormMailHisVo;
import com.z5.zcms.admsys.module.domain.ZFormMailVo;

public interface ZFormMailHisDAO {
	public List<ZFormMailHisVo> list(ZFormMailVo zFormMailVo);
	public ZFormMailHisVo detail(ZFormMailHisVo zFormMailHisVo);
	public void insert(ZFormMailVo zFormMailVo);
	public void delete(ZFormMailHisVo zFormMailHisVo);
	public void formMailHisDelete(List<Integer> arrDeleteNo);
}
