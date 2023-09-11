package com.z5.zcms.admsys.module.service;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZFormMailHisVo;
import com.z5.zcms.admsys.module.domain.ZFormMailVo;

public interface FormMailService {

	/*ZFormMail Line*/
	public List<ZFormMailVo> getFormMailList(ZFormMailVo zFormMailVo);
	public void formMailWrite(ZFormMailVo zFormMailVo);
	public int listCount(ZFormMailVo zFormMailVo);
	public Object formMailDetail(Object obj);
	public void formMailDelete(List<Integer> arrDeleteNo);
	public void formMailEdit(ZFormMailVo zFormMailVo);
	
	/*ZFormMailHis Line*/
	public List<ZFormMailHisVo> getFormMailHisList(ZFormMailVo zFormMailVo);
	public void formMailHisDelete(ZFormMailHisVo zFormMailHisVo);
}

