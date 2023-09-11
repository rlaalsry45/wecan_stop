package com.z5.zcms.frontsys.front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.z5.zcms.frontsys.front.dao.FrontApplicationDAO;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;
import com.z5.zcms.frontsys.front.domain.GovInfoVo;
import com.z5.zcms.util.DataTable;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
public class FrontApplicationServiceImple extends EgovAbstractServiceImpl implements FrontApplicationService {


	@Autowired
	private FrontApplicationDAO frontApplicationDAO;

	@Override
	public int registrationApplication(FrontApplicationVo reqVo) {
		return frontApplicationDAO.registrationApplication(reqVo);
	}

	@Override
	public Model retrieveApplicationList(FrontApplicationVo reqVo, DataTable input, Model model) {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        int total = this.frontApplicationDAO.retrieveApplicationTotalCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<FrontApplicationVo> list = this.frontApplicationDAO.retrieveApplicationList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public FrontApplicationVo applicationView(FrontApplicationVo reqVo) {
		return frontApplicationDAO.applicationView(reqVo);
	}

	@Override
	public List<GovInfoVo> srchGovList(GovInfoVo vo) {
		return frontApplicationDAO.srchGovList(vo);
	}

	@Override
	public int editApplicationInfo(FrontApplicationVo reqVo) {
		return frontApplicationDAO.editApplicationInfo(reqVo);
	}

	@Override
	public List<FrontApplicationVo> excelList(FrontApplicationVo reqVo) {
        reqVo.setM(0);
        reqVo.setN(99999999);
        
        List<FrontApplicationVo> list = this.frontApplicationDAO.retrieveApplicationList(reqVo);

		return list;
	}
}