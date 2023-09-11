package com.z5.zcms.admsys.evnt.service;

import java.util.List;


import com.z5.zcms.admsys.evnt.domain.EvntPartcptHistVO;
import com.z5.zcms.admsys.evnt.domain.EvntReqInputCfgVO;
import com.z5.zcms.admsys.evnt.domain.EvntVO;
import com.z5.zcms.frontsys.archv.domain.ArchvFile;

public interface EvntService {
	String insert(EvntVO vo) throws Exception;
    void update(EvntVO vo) throws Exception;
    void delete(List<Integer> arrDeleteNo) throws Exception;
    EvntVO selectbypk(EvntVO vo) throws Exception;
    public Integer listCount(EvntVO vo) throws Exception;
	List<EvntVO> getList(EvntVO vo) throws Exception;
	List<EvntVO> getListAll(EvntVO vo) throws Exception;
	EvntVO getEvnt(EvntVO vo,boolean addCount_yn) throws Exception;
	EvntReqInputCfgVO getEvntReqInputCfg(EvntReqInputCfgVO evntReqInputCfgVO) throws Exception;
	void addPartcptHist(EvntPartcptHistVO evntPartcptHistVO) throws Exception;
	List<ArchvFile> getFilelist(String evnt_no) throws Exception;
	int delEvntFile(int file_no) throws Exception;
	List<EvntPartcptHistVO> getPartcptlist(String evnt_no) throws Exception;
	List<EvntPartcptHistVO> getPrwinnerlist(String evnt_no) throws Exception;
	void delNotCfgByPk(String not_cfg_no) throws Exception;
	boolean isOverApplicantLimit(String parameter);
	List<EvntVO> getListForBanner(EvntVO evntVO);
	List<EvntVO> lnbList(EvntVO evntVO);
	List<EvntVO> lnbList2(EvntVO evntVO);
	public Integer lnbListCount(EvntVO evntVO);
	EvntVO getEvntG(EvntVO evntVO) throws Exception;
	void updateG(EvntVO evntVO);
	void insertG(EvntVO evntVO) throws Exception;
	void deleteg(List<Integer> arrDeleteNo);

}
