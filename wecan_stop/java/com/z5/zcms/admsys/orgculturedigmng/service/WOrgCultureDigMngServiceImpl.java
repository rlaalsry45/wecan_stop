package com.z5.zcms.admsys.orgculturedigmng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.z5.zcms.admsys.orgculturedigmng.dao.WOrgCultureDigMngDAO;
import com.z5.zcms.admsys.orgculturedigmng.dao.ZOrgCultureDigMngDAO;
import com.z5.zcms.admsys.orgculturedigmng.domain.CommInfoVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ConInfoRelActionVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
public class WOrgCultureDigMngServiceImpl extends EgovAbstractServiceImpl implements WOrgCultureDigMngService {

	@Autowired
	private WOrgCultureDigMngDAO wOrgCultureDigMngDAO;
	
	@Autowired
	private ZOrgCultureDigMngDAO zOrgCultureDigMngDAO;
	
	@Override
	public int registration(WOrgCultureDigMngVo reqVo) throws Exception {
		return (int)this.wOrgCultureDigMngDAO.registration(reqVo);
	}

	@Override
	public Model index(WOrgCultureDigMngVo reqVo, DataTable input, Model model) throws Exception  {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        int total = this.wOrgCultureDigMngDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WOrgCultureDigMngVo> list = this.wOrgCultureDigMngDAO.getlist(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public WOrgCultureDigMngVo view(WOrgCultureDigMngVo reqVo) throws Exception {
		return this.wOrgCultureDigMngDAO.view(reqVo);
	}

	@Override
	public int actionUpdate(WOrgCultureDigMngVo reqVo) throws Exception {
		return this.wOrgCultureDigMngDAO.actionUpdate(reqVo);
	}

	@Override 
	public int deleteRequestByTeacher(WOrgCultureDigMngVo reqVo) throws Exception {
		return this.wOrgCultureDigMngDAO.deleteRequestByTeacher(reqVo);
	}

	@Override
	public int delPermanent(WOrgCultureDigMngVo reqVo) throws Exception {
		return this.wOrgCultureDigMngDAO.delPermanent(reqVo);
	}

	@Override
	public int updDelYn(WOrgCultureDigMngVo reqVo) throws Exception {
		return this.wOrgCultureDigMngDAO.updDelYn(reqVo);
	}

	@Override
	public Model delIndex(WOrgCultureDigMngVo reqVo, DataTable input, Model model) throws Exception {
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
        
        int total = this.wOrgCultureDigMngDAO.delListCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WOrgCultureDigMngVo> list = this.wOrgCultureDigMngDAO.getDelList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public List<WCounselorVo> getCommList(WCounselorVo wCounselorVo) {
		return zOrgCultureDigMngDAO.getList(wCounselorVo);
	}

	@Override
	public List<ManagerListVo> managerList() {
		return wOrgCultureDigMngDAO.managerList();
	}

	@Override
	public Integer insertRelManager(WOrgCultureDigMngVo reqVo) {
		return wOrgCultureDigMngDAO.insertRelManager(reqVo);
	}

	@Override
	public List<ManagerListVo> retrieveManagerListByConsultIngActionNO(String consulting_action_no) {
		return wOrgCultureDigMngDAO.retrieveManagerListByConsultIngActionNO(consulting_action_no);
	}

	@Override
	public int deleteRelManagerByConsultingActionNO(String consulting_action_no) {
		return wOrgCultureDigMngDAO.deleteRelManagerByConsultingActionNO(consulting_action_no);
	}

	@Override
	public void insertRelComissioner(WOrgCultureDigMngVo reqVo) {
		wOrgCultureDigMngDAO.insertRelComissioner(reqVo);
	}

	@Override
	public List<CommInfoVo> retrieveCommissionoerList(String consulting_action_no) {
		return wOrgCultureDigMngDAO.retrieveCommissionoerList(consulting_action_no);
	}

	@Override
	public int deleteRelCommissionerByConsultingActionNO(String consulting_action_no) {
		return wOrgCultureDigMngDAO.deleteRelCommissionerByConsultingActionNO(consulting_action_no);
	}

	@Override
	public void insertRelAcWithCon(WOrgCultureDigMngVo reqVo) {
		wOrgCultureDigMngDAO.insertRelAcWithCon(reqVo);
	}

	@Override
	public List<ConInfoRelActionVo> retrieveRelConList(String consulting_action_no) {
		return wOrgCultureDigMngDAO.retrieveRelConList(consulting_action_no);
	}

	@Override
	public void deleteRelConsultingByConsultingActionNO(String consulting_action_no) {
		wOrgCultureDigMngDAO.deleteRelConsultingByConsultingActionNO(consulting_action_no);
	}

}
