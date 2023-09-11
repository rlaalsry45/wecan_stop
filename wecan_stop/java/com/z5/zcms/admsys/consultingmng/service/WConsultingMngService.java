package com.z5.zcms.admsys.consultingmng.service;

import java.util.List;

import org.springframework.ui.Model;

import com.z5.zcms.admsys.consultingmng.domain.WConsultingMngVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;
import com.z5.zcms.util.DataTable;

public interface WConsultingMngService {
	Model index(WConsultingMngVo reqVo, DataTable input, Model model) throws Exception;
	public int registrationConsulting(WConsultingMngVo reqVo) throws Exception;
	public WConsultingMngVo view(int no) throws Exception;
	public List<WConsultingMngVo> getlist(WConsultingMngVo reqVo) throws Exception;
	public Integer listCount(WConsultingMngVo reqVo) throws Exception;
	int deleteRequestByTeacher(WConsultingMngVo reqVo) throws Exception;
	int update(WConsultingMngVo reqVo) throws Exception;
	int delPermanent(WConsultingMngVo reqVo) throws Exception;
	int updDelYn(WConsultingMngVo reqVo) throws Exception;
	Model delIndex(WConsultingMngVo reqVo, DataTable input, Model model) throws Exception;

}
