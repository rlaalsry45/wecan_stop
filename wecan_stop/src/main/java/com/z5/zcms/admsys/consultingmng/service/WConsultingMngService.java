package com.z5.zcms.admsys.consultingmng.service;

import java.util.List;

import org.springframework.ui.Model;

import com.z5.zcms.admsys.consultingmng.domain.WClthisOldVo;
import com.z5.zcms.admsys.consultingmng.domain.WConsultingOldMngVo;
import com.z5.zcms.admsys.consultingmng.domain.WConsultingMngVo;
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
	public List<WConsultingMngVo> consultingExcel(WConsultingMngVo reqVo) throws Exception;
	public List<WConsultingMngVo> delListExcel(WConsultingMngVo reqVo) throws Exception;
	
	Model index_clthisOld(WClthisOldVo reqVo, DataTable input, Model model) throws Exception;
	public WClthisOldVo view_clthisOld(WClthisOldVo reqVo) throws Exception;
	public List<WClthisOldVo> answerList_clthisOld(WClthisOldVo reqVo) throws Exception;
	public List<WClthisOldVo> clthisOldExcel(WClthisOldVo reqVo) throws Exception;
	
	Model index_old(WConsultingOldMngVo reqVo, DataTable input, Model model) throws Exception;
	public List<WConsultingOldMngVo> consultingOldExcel(WConsultingOldMngVo reqVo) throws Exception;
}