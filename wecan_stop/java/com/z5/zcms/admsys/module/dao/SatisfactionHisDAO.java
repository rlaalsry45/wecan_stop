package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.SatisfactionVo;
import com.z5.zcms.admsys.module.domain.SatisfactionHisVo;

public interface SatisfactionHisDAO {
	public List<SatisfactionHisVo> list(SatisfactionVo satisfactionVo);
	public SatisfactionHisVo detail(SatisfactionHisVo satisfactionHisVo);
	public void insert(SatisfactionVo satisfactionVo);
	public void delete(SatisfactionHisVo satisfactionHisVo);
	public void satisfactionHisDelete(List<Integer> arrDeleteNo);
}
