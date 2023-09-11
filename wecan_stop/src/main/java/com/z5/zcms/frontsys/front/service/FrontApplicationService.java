package com.z5.zcms.frontsys.front.service;

import java.util.List;

import org.springframework.ui.Model;

import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;
import com.z5.zcms.frontsys.front.domain.GovInfoVo;
import com.z5.zcms.util.DataTable;

public interface FrontApplicationService {
	public int registrationApplication(FrontApplicationVo reqVo);
	public Model retrieveApplicationList(FrontApplicationVo reqVo, DataTable input, Model model);
	public FrontApplicationVo applicationView(FrontApplicationVo reqVo);
	public List<GovInfoVo> srchGovList(GovInfoVo vo);
	public int editApplicationInfo(FrontApplicationVo reqVo);
	public List<FrontApplicationVo> excelList(FrontApplicationVo reqVo);	
}
