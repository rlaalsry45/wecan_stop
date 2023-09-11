package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZSatisfactionHisVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;

public interface ZSatisfactionHisDAO {
	public List<ZSatisfactionHisVo> list(ZSatisfactionVo zSatisfactionVo);
	public ZSatisfactionHisVo detail(ZSatisfactionHisVo zSatisfactionHisVo);
	public void insert(ZSatisfactionVo zSatisfactionVo);
	public void delete(ZSatisfactionHisVo zSatisfactionHisVo);
	public void satisfactionHisDelete(List<Integer> arrDeleteNo);
}
