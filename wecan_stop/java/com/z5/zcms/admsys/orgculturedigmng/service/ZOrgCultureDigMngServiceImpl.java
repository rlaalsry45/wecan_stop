package com.z5.zcms.admsys.orgculturedigmng.service;

import com.z5.zcms.admsys.orgculturedigmng.dao.ZOrgCultureDigMngDAO;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
/*import com.z5.zcms.admsys.user.dao.ZUserHisDAO;
import com.z5.zcms.admsys.module.domain.ZUserHisVo;*/

@Service
@Transactional
public class ZOrgCultureDigMngServiceImpl extends AbstractServiceImpl implements ZOrgCultureDigMngService {

    @Autowired
    private ZOrgCultureDigMngDAO zOrgCultureDigMngDAO;

    public List<WCounselorVo> getList(WCounselorVo wCounselorVo) {
            return this.zOrgCultureDigMngDAO.getList(wCounselorVo);
    }
    
	@Override
	public void registration(WCounselorVo reqVo) throws Exception {
		this.zOrgCultureDigMngDAO.registration(reqVo);
	}    
	
	@Override
	public WCounselorVo view(WCounselorVo reqVo) throws Exception {
		return this.zOrgCultureDigMngDAO.view(reqVo);
	}	
	
	@Override
	public void actionUpdate(WCounselorVo reqVo) throws Exception {
		this.zOrgCultureDigMngDAO.actionUpdate(reqVo);
	}	
	
	@Override 
	public void delete(WCounselorVo reqVo) throws Exception {
		this.zOrgCultureDigMngDAO.delete(reqVo);
	}	

	@Override
	public Model index(WCounselorVo reqVo, DataTable input, Model model) throws Exception  {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        int total = this.zOrgCultureDigMngDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WCounselorVo> list = this.zOrgCultureDigMngDAO.getList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public List<WOrganizationVo> getOrgList(WOrganizationVo wOrganizationVo) {
		 return this.zOrgCultureDigMngDAO.getOrgList(wOrganizationVo);
	}

	@Override
	public void orgRegistration(WOrganizationVo reqVo) throws Exception {
		this.zOrgCultureDigMngDAO.orgRegistration(reqVo);
	}

	@Override
	public WOrganizationVo orgView(WOrganizationVo reqVo) throws Exception {
		return this.zOrgCultureDigMngDAO.orgView(reqVo);
	}	
	
	@Override
	public void orgUpdUse(WOrganizationVo reqVo) throws Exception {
		this.zOrgCultureDigMngDAO.orgUpdUse(reqVo);
	}
	
	@Override
	public Model orgIndex(WOrganizationVo reqVo, DataTable input, Model model) throws Exception  {
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
        
        int total = this.zOrgCultureDigMngDAO.orgListCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WOrganizationVo> list = this.zOrgCultureDigMngDAO.getOrgList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public String getOrgIdSeq() {
		return this.zOrgCultureDigMngDAO.getOrgIdSeq();
	}

	@Override
	public void orgUpdate(WOrganizationVo reqVo) throws Exception {
		this.zOrgCultureDigMngDAO.orgUpdate(reqVo);
	}
	
}
