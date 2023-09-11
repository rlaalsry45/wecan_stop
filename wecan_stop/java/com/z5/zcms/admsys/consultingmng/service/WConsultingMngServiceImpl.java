package com.z5.zcms.admsys.consultingmng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.z5.zcms.admsys.consultingmng.dao.WConsultingMngDAO;
import com.z5.zcms.admsys.consultingmng.domain.WConsultingMngVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
public class WConsultingMngServiceImpl extends EgovAbstractServiceImpl implements WConsultingMngService {

	@Autowired
	private WConsultingMngDAO wConsultingMngDAO;

	@Override
	public Model index(WConsultingMngVo reqVo, DataTable input, Model model) throws Exception {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        int total = this.wConsultingMngDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WConsultingMngVo> list = this.wConsultingMngDAO.getlist(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}
	
	@Override
	public int registrationConsulting(WConsultingMngVo reqVo) throws Exception{
		return wConsultingMngDAO.registrationConsulting(reqVo);
	}

	@Override
	public WConsultingMngVo view(int no) throws Exception {
		return wConsultingMngDAO.view(no);
	}

	@Override
	public List<WConsultingMngVo> getlist(WConsultingMngVo reqVo) throws Exception {
		return wConsultingMngDAO.getlist(reqVo);
	}

	@Override
	public Integer listCount(WConsultingMngVo reqVo) throws Exception {
		return wConsultingMngDAO.listCount(reqVo);
	}

	@Override
	public int deleteRequestByTeacher(WConsultingMngVo reqVo) throws Exception {
		return wConsultingMngDAO.deleteRequestByTeacher(reqVo);
	}

	@Override
	public int update(WConsultingMngVo reqVo) throws Exception {
		return wConsultingMngDAO.update(reqVo);
	}

	@Override
	public int delPermanent(WConsultingMngVo reqVo) throws Exception {
		return wConsultingMngDAO.delPermanent(reqVo);
	}

	@Override
	public int updDelYn(WConsultingMngVo reqVo) throws Exception {
		return wConsultingMngDAO.updDelYn(reqVo);
	}

	@Override
	public Model delIndex(WConsultingMngVo reqVo, DataTable input, Model model) throws Exception {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        if (!StringUtil.isEmpty(input.get("sdate"))
        		&& !StringUtil.isEmpty(input.get("edate"))) {
        	reqVo.setCond1(input.get("cond1"));
        	reqVo.setSdate(input.get("sdate").replaceAll("-", ""));
        	reqVo.setEdate(input.get("edate").replaceAll("-", ""));
        }
        
        if (!StringUtil.isEmpty(input.get("keyword"))) {
        	reqVo.setCond2(input.get("cond2"));
        	reqVo.setKeyword(input.get("keyword"));
        }
        
        int total = this.wConsultingMngDAO.delListCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WConsultingMngVo> list = this.wConsultingMngDAO.getDelList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}
}
