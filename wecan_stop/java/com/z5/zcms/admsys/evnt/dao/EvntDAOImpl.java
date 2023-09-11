package com.z5.zcms.admsys.evnt.dao;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.evnt.domain.EvntPartcptHistVO;
import com.z5.zcms.admsys.evnt.domain.EvntReqInputCfgVO;
import com.z5.zcms.admsys.evnt.domain.EvntReqNotCfg;
import com.z5.zcms.admsys.evnt.domain.EvntReqNotCfgVO;
import com.z5.zcms.admsys.evnt.domain.EvntVO;
import com.z5.zcms.frontsys.archv.domain.ArchvFile;
import com.z5.zcms.frontsys.archv.domain.ArchvFileVO;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class EvntDAOImpl extends EgovComAbstractDAO implements EvntDAO{

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "EvntDAO.";
	
    public void insert(EvntVO vo) {
        insert(sqlMapNs+"write", vo);
    }
    
    public String getCurrval(){
    	return (String) super.getSqlMapClientTemplate().queryForObject(sqlMapNs+"getCurrval");
    }
    
	public Integer listCount(EvntVO vo) {
		return (Integer) super.selectByPk(sqlMapNs+"listCount",vo);
	}
	
    public void delete(List<Integer> arrDeleteNo){
        delete(sqlMapNs+"delete", arrDeleteNo);
    }
	
    public EvntVO selectbypk(EvntVO vo){
        return (EvntVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo); 
        		
    }
    
    public void update(EvntVO vo){
        update(sqlMapNs+"update", vo);
    }
    
    @SuppressWarnings("unchecked")
	public List<EvntVO> getlist(EvntVO vo) {
		return (List<EvntVO>) super.list(sqlMapNs+"list", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<EvntVO> getlistAll(EvntVO vo) {
		return (List<EvntVO>) super.list(sqlMapNs+"listAll", vo);
	}

	@Override
	public EvntVO getEvnt(EvntVO vo) {
		return (EvntVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getEvnt", vo); 
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvFile> getFilelist(String evnt_no) {
		return (List<ArchvFile>) super.list(sqlMapNs + "getFilelist", evnt_no);
	}

	@Override
	public void addCount(String evnt_no) {
		this.update(sqlMapNs + "addCount", evnt_no);
		
	}

	@Override
	public EvntReqInputCfgVO getEvntReqInputCfg(EvntReqInputCfgVO evntReqInputCfgVO) {
		return (EvntReqInputCfgVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getEvntReqInputCfg", evntReqInputCfgVO); 
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EvntReqNotCfgVO> getEvntReqNotCfg(String evnt_no) {
		return (List<EvntReqNotCfgVO>) super.list(sqlMapNs + "getEvntReqNotCfg", evnt_no);
	}

	@Override
	public void addPartcptHist(EvntPartcptHistVO evntPartcptHistVO) {
		insert(sqlMapNs+"addPartcptHist", evntPartcptHistVO);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EvntReqNotCfgVO> getNotlist(String evnt_no) {
		return (List<EvntReqNotCfgVO>) super.list(sqlMapNs+"getNotlist", evnt_no);
	}

	@Override
	public EvntReqInputCfgVO getReqinput(String evnt_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEvntReqInputCfg(EvntReqInputCfgVO evntReqInputCfgVO) {
		update(sqlMapNs+"updateEvntReqInputCfg", evntReqInputCfgVO);
		
	}
	@Override
	public void insertEvntReqInputCfg(EvntReqInputCfgVO evntReqInputCfgVO) {
		insert(sqlMapNs+"insertEvntReqInputCfg", evntReqInputCfgVO);
	}

	@Override
	public void deleteEvntReqNotCfgByEvntNo(String evnt_no) {
		delete(sqlMapNs+"deleteEvntReqNotCfgByEvntNo", evnt_no);
		
	}

	@Override
	public void insertEvntReqNotCfg(EvntReqNotCfgVO evntReqNotCfgVO) {
		insert(sqlMapNs+"insertEvntReqNotCfg", evntReqNotCfgVO);
		
	}
	
	@Override
	public ArchvFileVO getFileOne(int file_no) throws Exception {
		return (ArchvFileVO) this.getSqlMapClientTemplate().queryForObject(sqlMapNs + "getFileOne", file_no);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EvntPartcptHistVO> getPartcptlist(String evnt_no) {
		return (List<EvntPartcptHistVO>) super.list(sqlMapNs+"getPartcptlist", evnt_no);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EvntPartcptHistVO> getPrwinnerlist(String evnt_no) {
		return (List<EvntPartcptHistVO>) super.list(sqlMapNs+"getPrwinnerlist", evnt_no);
	}

	@Override
	public void insertEvntFile(List<ArchvFile> file) {
		if (file.size() != 0) {

			ArchvFile archvFile = null;

			for (int i = 0; i != file.size(); ++i) {
				archvFile = file.get(i);
				if (archvFile != null)
					this.getSqlMapClientTemplate().insert(sqlMapNs + "insertEvntFile", archvFile);
			}
		}
		
	}
	
	@Override
	public void delNotCfgByPk(String not_cfg_no) {
		this.getSqlMapClientTemplate().delete(sqlMapNs + "delNotCfgByPk", not_cfg_no);
	}

	@Override
	public int getNotApplicantLimit(String not_cfg_no) {
		return (Integer) super.selectByPk(sqlMapNs+"getNotApplicantLimit",not_cfg_no);
	}

	@Override
	public int getApplicantCount(String not_cfg_no) {
		return (Integer) super.selectByPk(sqlMapNs+"getApplicantCount",not_cfg_no);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EvntVO> getListForBanner(EvntVO evntVO) {
		return (List<EvntVO>) super.list(sqlMapNs+"getListForBanner", evntVO);
	}

	@Override
	public List<EvntVO> lnbList(EvntVO evntVO) {
		return (List<EvntVO>) super.list(sqlMapNs+"lnbList", evntVO);
	}

	@Override
	public List<EvntVO> lnbList2(EvntVO evntVO) {
		return (List<EvntVO>) super.list(sqlMapNs+"lnbList2", evntVO);
	}

	@Override
	public Integer lnbListCount(EvntVO evntVO) {
		return (Integer) super.selectByPk(sqlMapNs+"lnbListCount",evntVO);
	}

	@Override
	public EvntVO getEvntG(EvntVO evntVO) {
		return (EvntVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getEvntG", evntVO); 
	}

	@Override
	public void updateG(EvntVO evntVO) {
		update(sqlMapNs + "updateG", evntVO);
	}

	@Override
	public void insertG(EvntVO evntVO) {
		insert(sqlMapNs + "insertG", evntVO);
		
	}

	@Override
	public void deleteg(List<Integer> arrDeleteNo) {
        delete(sqlMapNs+"deleteg", arrDeleteNo);
	}


}
