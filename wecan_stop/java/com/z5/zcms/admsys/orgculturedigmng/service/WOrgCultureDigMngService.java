package com.z5.zcms.admsys.orgculturedigmng.service;

import java.util.List;

import org.springframework.ui.Model;

import com.z5.zcms.admsys.orgculturedigmng.domain.CommInfoVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ConInfoRelActionVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;
import com.z5.zcms.util.DataTable;

public interface WOrgCultureDigMngService {
	Model index(WOrgCultureDigMngVo reqVo, DataTable input, Model model) throws Exception;
	int registration(WOrgCultureDigMngVo reqVo) throws Exception;
	WOrgCultureDigMngVo view(WOrgCultureDigMngVo reqVo) throws Exception;
	int actionUpdate(WOrgCultureDigMngVo reqVo) throws Exception;
	int deleteRequestByTeacher(WOrgCultureDigMngVo reqVo) throws Exception;
	int delPermanent(WOrgCultureDigMngVo reqVo) throws Exception;
	int updDelYn(WOrgCultureDigMngVo reqVo) throws Exception;
	Model delIndex(WOrgCultureDigMngVo reqVo, DataTable input, Model model) throws Exception;
	List<WCounselorVo> getCommList(WCounselorVo wCounselorVo);
	public List<ManagerListVo> managerList();
	public Integer insertRelManager(WOrgCultureDigMngVo reqVo);
	public List<ManagerListVo> retrieveManagerListByConsultIngActionNO(String consulting_action_no);
	public int deleteRelManagerByConsultingActionNO(String consulting_action_no);
	public void insertRelComissioner(WOrgCultureDigMngVo reqVo);
	public List<CommInfoVo> retrieveCommissionoerList(String consulting_action_no);
	public int deleteRelCommissionerByConsultingActionNO(String consulting_action_no);
	public void insertRelAcWithCon(WOrgCultureDigMngVo reqVo);
	public List<ConInfoRelActionVo> retrieveRelConList(String consulting_action_no);
	public void deleteRelConsultingByConsultingActionNO(String consulting_action_no);
}
