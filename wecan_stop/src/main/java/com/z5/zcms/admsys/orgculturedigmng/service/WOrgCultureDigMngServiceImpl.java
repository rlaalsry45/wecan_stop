package com.z5.zcms.admsys.orgculturedigmng.service;

import static com.z5.zcms.util.ZPrint.print;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.z5.zcms.admsys.orgculturedigmng.dao.WOrgCultureDigMngDAO;
import com.z5.zcms.admsys.orgculturedigmng.dao.ZOrgCultureDigMngDAO;
import com.z5.zcms.admsys.orgculturedigmng.domain.AppActionMergeVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.CommInfoVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ConInfoRelActionVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldApplicationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldDeclarationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import com.z5.zcms.frontsys.front.domain.FrontAppSearchVo;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;
import com.z5.zcms.frontsys.front.domain.GovInfoVo;
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
	public int registration(AppActionMergeVo reqVo) throws Exception {
		print("IS IN PROCESS ?"+reqVo);
		return (int)this.wOrgCultureDigMngDAO.registration(reqVo);
	}

	@Override
	public Model index(AppActionMergeVo reqVo, DataTable input, Model model) throws Exception  {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        // 접수신청서 내용 검색 관련, 접수 관련 검색조건이 선택되었는지 확인후, 플래그를 준후 쿼리단에서 조인 여부를 이 플래그로 추가한다.
        FrontAppSearchVo chkApp = new FrontAppSearchVo();
        BeanUtils.copyProperties(chkApp, reqVo);
        
        String joinYn = "N";
        
        try {
            Object obj = chkApp;

            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
				Object value = field.get(obj);
				//System.out.println("bbfield : "+field.getName()+" | value : " + value);
				if (value instanceof String ) {
					if ( StringUtils.isNotBlank(value.toString())) {
						//System.out.println("aafield : "+field.getName()+" | value : " + value);
						joinYn = "Y";
						break;	
					}					
				} else {
					if ( value != null ) {
						if ( value instanceof Integer ) {
							//System.out.println("ccfield : "+field.getName()+" | value : " + value);
							if ( Integer.valueOf(value.toString()) > 0 ) {
								joinYn = "Y";
								break;			
							}
							
						}
						
					}
				}
				
				//System.out.println("field : "+field.getName()+" | value : " value);
            }
	    }catch (Exception e) {
            e.printStackTrace();
		}
        
         reqVo.setJoinYn(joinYn);
        
        int total = this.wOrgCultureDigMngDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<AppActionMergeVo> list = this.wOrgCultureDigMngDAO.getlist(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}
	
	@Override
	public Model adminIndex(AppActionMergeVo reqVo, Model model) throws Exception  {
        reqVo.setJoinYn("N");
        List<AppActionMergeVo> list = this.wOrgCultureDigMngDAO.getlist(reqVo);
        
        model.addAttribute("list", list);     
		return model;
	}

	
	@Override
	public Model linkPopIndex(WCounselorVo reqVo, DataTable input, Model model) throws Exception  {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        reqVo.setCounselNum(input.get("cn",""));
        
        int total = this.wOrgCultureDigMngDAO.linkPopCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WCounselorVo> list = this.wOrgCultureDigMngDAO.linkPopIndex(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}
	@Override
	public AppActionMergeVo view(AppActionMergeVo reqVo) throws Exception {
		return this.wOrgCultureDigMngDAO.view(reqVo);
	}

	@Override
	public int actionUpdate(AppActionMergeVo reqVo) throws Exception {
		return this.wOrgCultureDigMngDAO.actionUpdate(reqVo);
	}

	@Override 
	public int deleteRequestByTeacher(AppActionMergeVo reqVo) throws Exception {
		return this.wOrgCultureDigMngDAO.deleteRequestByTeacher(reqVo);
	}

	@Override
	public int delPermanent(AppActionMergeVo reqVo) throws Exception {
		return this.wOrgCultureDigMngDAO.delPermanent(reqVo);
	}

	@Override
	public int updDelYn(AppActionMergeVo reqVo) throws Exception {
		return this.wOrgCultureDigMngDAO.updDelYn(reqVo);
	}

	@Override
	public Model delIndex(AppActionMergeVo reqVo, DataTable input, Model model) throws Exception {
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
        
        List<AppActionMergeVo> list = this.wOrgCultureDigMngDAO.getDelList(reqVo);
        
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
	public Integer insertRelManager(AppActionMergeVo reqVo) {
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
	public void insertRelComissioner(AppActionMergeVo reqVo) {
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
	public void insertRelAcWithCon(AppActionMergeVo reqVo) {
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

	@Override
	public int applicationStepChange(FrontApplicationVo vo) {
		return wOrgCultureDigMngDAO.applicationStepChange(vo);
	}
// from z
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
	public List<WOrganizationVo> getOrgCodeList(WOrganizationVo reqVo) throws Exception {
		return this.zOrgCultureDigMngDAO.getOrgCodeList(reqVo);
	}
	
	@Override
	public void orgUpdUse(WOrganizationVo reqVo) throws Exception {
		this.zOrgCultureDigMngDAO.orgUpdUse(reqVo);
	}

	@Override
	public String getOrgIdSeq() {
		return this.zOrgCultureDigMngDAO.getOrgIdSeq();
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
	public void orgUpdate(WOrganizationVo reqVo) throws Exception {
		this.zOrgCultureDigMngDAO.orgUpdate(reqVo);
	}
	
	//index -> commIndex
	@Override
	public Model commIndex(WCounselorVo reqVo, DataTable input, Model model) throws Exception  {
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
	
	//registration -> commRegistration
	@Override
	public int commRegistration(WCounselorVo reqVo) throws Exception {
		return this.zOrgCultureDigMngDAO.registration(reqVo);
	}
	
	@Override
	public WCounselorVo commView(WCounselorVo reqVo) throws Exception {
		return this.zOrgCultureDigMngDAO.view(reqVo);
	}
	
	@Override
	public void commUpdate(WCounselorVo reqVo) throws Exception {
		this.zOrgCultureDigMngDAO.actionUpdate(reqVo);
	}
	
	@Override 
	public void commDelete(WCounselorVo reqVo) throws Exception {
		this.zOrgCultureDigMngDAO.delete(reqVo);
	}

	@Override
	public boolean checkCurStat(FrontApplicationVo vo) {
		return wOrgCultureDigMngDAO.checkCurStat(vo) != 0;
	}

	@Override
	public void registrationAppHistory(FrontApplicationVo vo) {
		wOrgCultureDigMngDAO.registrationAppHistory(vo);
	}

	@Override
	public Model secheduleIndex(AppActionMergeVo reqVo, DataTable input, Model model) throws Exception {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        
        List<AppActionMergeVo> list = this.wOrgCultureDigMngDAO.getScheduleList(reqVo);
        
        //int total = this.wOrgCultureDigMngDAO.listCount(reqVo);
        int total = 0;
        
        if ( list.size() > 0 ) {
        	total = list.get(0).getTotalCount();
        }
        
        //int total = this.wOrgCultureDigMngDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public List<AppActionMergeVo> indexExcel(AppActionMergeVo reqVo) throws Exception {
        reqVo.setM(0);
        reqVo.setN(99999999);
        
		return this.wOrgCultureDigMngDAO.getlist(reqVo);
	}	
	
	@Override
	public List<AppActionMergeVo> delIndexExcel(AppActionMergeVo reqVo) throws Exception {
        reqVo.setM(0);
        reqVo.setN(99999999);
        
		return this.wOrgCultureDigMngDAO.getDelList(reqVo);
	}
	
	@Override
	public List<WOrganizationVo> orgIndexExcel(WOrganizationVo reqVo) throws Exception {
        reqVo.setM(0);
        reqVo.setN(99999999);
        
		return this.zOrgCultureDigMngDAO.getOrgList(reqVo);
	}

	@Override
	public List<WCounselorVo> commIndexExcel(WCounselorVo reqVo) throws Exception {
		reqVo.setM(0);
        reqVo.setN(99999999);
        
        return this.zOrgCultureDigMngDAO.getList(reqVo);
	}

	@Override
	public void privOrgRegistration(GovInfoVo vo) throws Exception {
		zOrgCultureDigMngDAO.privOrgRegistration(vo);
	}

	@Override
	public String getOrgPrivSeq() throws Exception {
		return zOrgCultureDigMngDAO.getOrgPrivSeq();
	}

	@Override
	public List<WOrganizationVo> srchGovIdList(WOrganizationVo reqVo) throws Exception {
		return this.zOrgCultureDigMngDAO.srchGovIdList(reqVo);
	}

	@Override
	public List<WOrgCultureDigMngVo> srchConsultingList(WOrgCultureDigMngVo reqVo) throws Exception {
		return this.zOrgCultureDigMngDAO.srchConsultingList(reqVo);
	}

	@Override
	public List<AppActionMergeVo> secheduleIndexExcel(AppActionMergeVo reqVo) throws Exception {
		 reqVo.setM(0);
	     reqVo.setN(99999999);
	        
	     return this.wOrgCultureDigMngDAO.getScheduleList(reqVo);
	}

	@Override
	public Model caoaIndex(WConsultingActionOldApplicationVo reqVo, DataTable input, Model model) throws Exception {
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
        
        List<WConsultingActionOldApplicationVo> list = this.zOrgCultureDigMngDAO.getList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public Model caodIndex(WConsultingActionOldDeclarationVo reqVo, DataTable input, Model model) throws Exception {
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
        
        List<WConsultingActionOldDeclarationVo> list = this.zOrgCultureDigMngDAO.getList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public List<WConsultingActionOldApplicationVo> caoaIndexExcel(WConsultingActionOldApplicationVo reqVo) throws Exception{
		reqVo.setM(0);
	    reqVo.setN(99999999);
	    
	    if (!StringUtil.isEmpty(reqVo.getSdate())
        		&& !StringUtil.isEmpty(reqVo.getEdate())) {
        	reqVo.setSdate(reqVo.getSdate().replaceAll("-", ""));
        	reqVo.setEdate(reqVo.getEdate().replaceAll("-", ""));
        }
	    
		return this.zOrgCultureDigMngDAO.getList(reqVo);
	}

	@Override
	public List<WConsultingActionOldDeclarationVo> caodIndexExcel(WConsultingActionOldDeclarationVo reqVo) throws Exception{
		reqVo.setM(0);
	    reqVo.setN(99999999);
	    
	    if (!StringUtil.isEmpty(reqVo.getSdate())
        		&& !StringUtil.isEmpty(reqVo.getEdate())) {
        	reqVo.setSdate(reqVo.getSdate().replaceAll("-", ""));
        	reqVo.setEdate(reqVo.getEdate().replaceAll("-", ""));
        }
	    
		return this.zOrgCultureDigMngDAO.getList(reqVo);
	}

	@Override
	public String validation(String data) throws Exception {
		
		String result = (String)zOrgCultureDigMngDAO.validation(data);
		
		return result;
	}
	
}