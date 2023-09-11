package com.z5.zcms.admsys.consultingmng.dao;

import java.util.List;

import com.z5.zcms.admsys.consultingmng.domain.WClthisOldVo;
import com.z5.zcms.admsys.consultingmng.domain.WConsultingMngVo;
import com.z5.zcms.admsys.consultingmng.domain.WConsultingOldMngVo;

public interface WConsultingMngDAO {
	public Integer registrationConsulting(WConsultingMngVo reqVo) throws Exception;
	public WConsultingMngVo view(int no) throws Exception;
	public List<WConsultingMngVo> getlist(WConsultingMngVo reqVo) throws Exception;
	public Integer listCount(WConsultingMngVo reqVo) throws Exception;
	int deleteRequestByTeacher(WConsultingMngVo reqVo) throws Exception;
	int update(WConsultingMngVo reqVo) throws Exception;
	int delPermanent(WConsultingMngVo reqVo) throws Exception;
	int updDelYn(WConsultingMngVo reqVo) throws Exception;
	public List<WConsultingMngVo> getDelList(WConsultingMngVo reqVo);
	public Integer delListCount(WConsultingMngVo reqVo);
	
	//구신고서 기록
	public WClthisOldVo view(WClthisOldVo reqVo) throws Exception;
	public List<WClthisOldVo> getlist(WClthisOldVo reqVo) throws Exception;
	public List<WClthisOldVo> getAnswerList_clthisOld(WClthisOldVo reqVo) throws Exception;
	public Integer listCount(WClthisOldVo reqVo) throws Exception;
	
	//구 상담일지
	public List<WConsultingOldMngVo> getlist(WConsultingOldMngVo reqVo) throws Exception;
	public Integer listCount(WConsultingOldMngVo reqVo) throws Exception;
}
