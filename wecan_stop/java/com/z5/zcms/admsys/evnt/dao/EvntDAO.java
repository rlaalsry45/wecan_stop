package com.z5.zcms.admsys.evnt.dao;

import java.util.List;


import com.z5.zcms.admsys.evnt.domain.EvntPartcptHistVO;
import com.z5.zcms.admsys.evnt.domain.EvntReqInputCfgVO;
import com.z5.zcms.admsys.evnt.domain.EvntReqNotCfg;
import com.z5.zcms.admsys.evnt.domain.EvntReqNotCfgVO;
import com.z5.zcms.admsys.evnt.domain.EvntVO;
import com.z5.zcms.frontsys.archv.domain.ArchvFile;
import com.z5.zcms.frontsys.archv.domain.ArchvFileVO;


public interface EvntDAO {
	public void insert(EvntVO vo);
	public String getCurrval();
    public void update(EvntVO vo);
    public void delete(List<Integer> arrDeleteNo) ;
    public EvntVO selectbypk(EvntVO vo) ;
	public Integer listCount(EvntVO vo);
	public List<EvntVO> getlist(EvntVO vo);
	public List<EvntVO> getlistAll(EvntVO vo);
	public EvntVO getEvnt(EvntVO vo);
	public List<ArchvFile> getFilelist(String evnt_no);
	public void addCount(String evnt_no);
	public EvntReqInputCfgVO getEvntReqInputCfg(EvntReqInputCfgVO evntReqInputCfgVO);
	public List<EvntReqNotCfgVO> getEvntReqNotCfg(String evnt_no);
	public void addPartcptHist(EvntPartcptHistVO evntPartcptHistVO);
	public List<EvntReqNotCfgVO> getNotlist(String evnt_no);
	public EvntReqInputCfgVO getReqinput(String evnt_no);
	public void updateEvntReqInputCfg(EvntReqInputCfgVO evntReqInputCfgVO);
	public void insertEvntReqInputCfg(EvntReqInputCfgVO evntReqInputCfgVO);
	public void deleteEvntReqNotCfgByEvntNo(String evnt_no);
	public void insertEvntReqNotCfg(EvntReqNotCfgVO evntReqNotCfgVO); 
	
	public ArchvFileVO getFileOne(int file_no) throws Exception;
	public List<EvntPartcptHistVO> getPartcptlist(String evnt_no);
	public List<EvntPartcptHistVO> getPrwinnerlist(String evnt_no);
	public void insertEvntFile(List<ArchvFile> filelist);
	public void delNotCfgByPk(String not_cfg_no) throws Exception;
	public int getNotApplicantLimit(String not_cfg_no);
	public int getApplicantCount(String not_cfg_no);
	public List<EvntVO> getListForBanner(EvntVO evntVO);
	public List<EvntVO> lnbList(EvntVO evntVO);;
	public List<EvntVO> lnbList2(EvntVO evntVO);
	public Integer lnbListCount(EvntVO evntVO);
	public EvntVO getEvntG(EvntVO evntVO);
	public void updateG(EvntVO evntVO);
	public void insertG(EvntVO evntVO);
	public void deleteg(List<Integer> arrDeleteNo);
	
	
	
}
