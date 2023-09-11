package com.z5.zcms.admsys.orgculturedigmng.service;

import java.util.List;

import org.springframework.ui.Model;

import com.z5.zcms.admsys.orgculturedigmng.domain.AppActionMergeVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.CommInfoVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ConInfoRelActionVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldApplicationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldDeclarationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;
import com.z5.zcms.frontsys.front.domain.GovInfoVo;
import com.z5.zcms.util.DataTable;

public interface WOrgCultureDigMngService {
	Model index(AppActionMergeVo reqVo, DataTable input, Model model) throws Exception;
	Model adminIndex(AppActionMergeVo reqVo, Model model) throws Exception;
	Model linkPopIndex(WCounselorVo reqVo, DataTable input, Model model) throws Exception;
	int registration(AppActionMergeVo reqVo) throws Exception;
	AppActionMergeVo view(AppActionMergeVo reqVo) throws Exception;
	int actionUpdate(AppActionMergeVo reqVo) throws Exception;
	int deleteRequestByTeacher(AppActionMergeVo reqVo) throws Exception;
	int delPermanent(AppActionMergeVo reqVo) throws Exception;
	int updDelYn(AppActionMergeVo reqVo) throws Exception;
	Model delIndex(AppActionMergeVo reqVo, DataTable input, Model model) throws Exception;
	List<WCounselorVo> getCommList(WCounselorVo wCounselorVo);
	public List<ManagerListVo> managerList();
	public Integer insertRelManager(AppActionMergeVo reqVo);
	public List<ManagerListVo> retrieveManagerListByConsultIngActionNO(String consulting_action_no);
	public int deleteRelManagerByConsultingActionNO(String consulting_action_no);
	public void insertRelComissioner(AppActionMergeVo reqVo);
	public List<CommInfoVo> retrieveCommissionoerList(String consulting_action_no);
	public int deleteRelCommissionerByConsultingActionNO(String consulting_action_no);
	public void insertRelAcWithCon(AppActionMergeVo reqVo);
	public List<ConInfoRelActionVo> retrieveRelConList(String consulting_action_no);
	public void deleteRelConsultingByConsultingActionNO(String consulting_action_no);
	public int applicationStepChange(FrontApplicationVo vo);
	public boolean checkCurStat(FrontApplicationVo vo);
	public void registrationAppHistory(FrontApplicationVo vo);
	public Model secheduleIndex(AppActionMergeVo reqVo, DataTable input, Model model) throws Exception;
	public List<AppActionMergeVo> indexExcel(AppActionMergeVo reqVo) throws Exception;
	public List<AppActionMergeVo> delIndexExcel(AppActionMergeVo reqVo) throws Exception;
	public List<WOrganizationVo> orgIndexExcel(WOrganizationVo reqVo) throws Exception;
	public List<WCounselorVo> commIndexExcel(WCounselorVo reqVo) throws Exception;
	public List<AppActionMergeVo> secheduleIndexExcel(AppActionMergeVo reqVo) throws Exception;
	public void privOrgRegistration(GovInfoVo vo) throws Exception;
	public String getOrgPrivSeq() throws Exception;
	public List<WOrganizationVo> srchGovIdList(WOrganizationVo reqVo) throws Exception;
	public List<WOrgCultureDigMngVo> srchConsultingList(WOrgCultureDigMngVo reqVo) throws Exception;
	
	//from z
	Model orgIndex(WOrganizationVo reqVo, DataTable input, Model model) throws Exception;
	public void orgUpdUse(WOrganizationVo reqVo) throws Exception;
	public String getOrgIdSeq();
	public void orgRegistration(WOrganizationVo reqVo) throws Exception;
	public WOrganizationVo orgView(WOrganizationVo reqVo) throws Exception;
	public void orgUpdate(WOrganizationVo reqVo) throws Exception;
	Model commIndex(WCounselorVo reqVo, DataTable input, Model model) throws Exception;//index -> commIndex
	public int commRegistration(WCounselorVo reqVo) throws Exception;  //registration -> commRegistration
	public WCounselorVo commView(WCounselorVo reqVo) throws Exception;//view -> commView
	void commUpdate(WCounselorVo reqVo) throws Exception;//actionUpdate -> commUpdate
	void commDelete(WCounselorVo reqVo) throws Exception;//delete -> commDelete

	Model caoaIndex(WConsultingActionOldApplicationVo reqVo, DataTable input, Model model) throws Exception;
	Model caodIndex(WConsultingActionOldDeclarationVo reqVo, DataTable input, Model model) throws Exception;
	public List<WConsultingActionOldApplicationVo> caoaIndexExcel(WConsultingActionOldApplicationVo reqVo) throws Exception;
	public List<WConsultingActionOldDeclarationVo> caodIndexExcel(WConsultingActionOldDeclarationVo reqVo) throws Exception;
	List<WOrganizationVo> getOrgCodeList(WOrganizationVo reqVo) throws Exception;
	
	String validation(String data) throws Exception;
}
