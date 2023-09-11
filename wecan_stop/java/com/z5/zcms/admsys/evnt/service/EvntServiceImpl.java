package com.z5.zcms.admsys.evnt.service;

import com.z5.zcms.admsys.evnt.dao.EvntDAO;
import com.z5.zcms.admsys.evnt.domain.EvntPartcptHistVO;
import com.z5.zcms.admsys.evnt.domain.EvntReqInputCfgVO;
import com.z5.zcms.admsys.evnt.domain.EvntReqNotCfgVO;
import com.z5.zcms.admsys.evnt.domain.EvntVO;
import com.z5.zcms.frontsys.archv.dao.ArchvDAO;
import com.z5.zcms.frontsys.archv.domain.ArchvFile;
import com.z5.zcms.frontsys.archv.domain.ArchvFileVO;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Transactional
@Service
public class EvntServiceImpl extends AbstractServiceImpl implements EvntService{

    @Autowired
    private EvntDAO evntDAO;

	@Autowired
	ArchvDAO archvDAO;

    public String insert(EvntVO vo) throws Exception {
    	//log.debug(vo.toString());
    	evntDAO.insert(vo);
    	return evntDAO.getCurrval();
    }


    public void update(EvntVO vo) throws Exception {
    	try{
	    	//req_input update
	    	EvntReqInputCfgVO evntReqInputCfgVO = vo.getEvntReqInputCfgVO();
	    	if(evntReqInputCfgVO.getReq_no() == null || evntReqInputCfgVO.getReq_no().equals("")){
	    		evntDAO.insertEvntReqInputCfg(evntReqInputCfgVO);
	    	}else{
	    		evntDAO.updateEvntReqInputCfg(evntReqInputCfgVO);
	    	}

	    	//evnt update
	    	evntDAO.update(vo);

	    	if(vo.getEvnt_use_yn() == 1){
		    	//not list get
		    	List<EvntReqNotCfgVO> evntReqNotCfgVO = vo.getNotlist();
		    	//evnt_not_cfg delete
		    	evntDAO.deleteEvntReqNotCfgByEvntNo(vo.getEvnt_no());
		    	//evnt_not_cfg insert
		    	for(int i=0;evntReqNotCfgVO.size() > i;i++){
		    		evntDAO.insertEvntReqNotCfg(evntReqNotCfgVO.get(i));
		    	}
	    	}

	    	//evntFile
	    	this.evntDAO.insertEvntFile(vo.getFilelist());

    	}catch(Exception e){
    		e.printStackTrace();
    	}


    }

    public void delete(List<Integer> arrDeleteNo) throws Exception {
    	evntDAO.delete(arrDeleteNo);
    }

    public EvntVO selectbypk(EvntVO vo) throws Exception {
    	EvntVO resultVO = evntDAO.selectbypk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

	public Integer listCount(EvntVO vo)  throws Exception{
		return this.evntDAO.listCount(vo);
	}

	public List<EvntVO> getList(EvntVO vo)  throws Exception{
		return this.evntDAO.getlist(vo);
	}

	public List<EvntVO> getListAll(EvntVO vo)  throws Exception{
		return this.evntDAO.getlistAll(vo);
	}

	@Override
	public EvntVO getEvnt(EvntVO evntVO, boolean addCount_yn) throws Exception {
		//addCount
		String evnt_no = evntVO.getEvnt_no();
		if(addCount_yn)
			this.evntDAO.addCount(evnt_no);//count+1

		EvntVO vo = this.evntDAO.getEvnt(evntVO);

		//filelist get

		if(vo != null){
			List<ArchvFile> filelist = this.evntDAO.getFilelist(evnt_no);
			vo.setFilelist(filelist);

			//notlist get
			List<EvntReqNotCfgVO> notlist = this.evntDAO.getNotlist(evnt_no);
			vo.setNotlist(notlist);

			//reqinput get
			EvntReqInputCfgVO  evntReqInputCfgVO = new EvntReqInputCfgVO();
			evntReqInputCfgVO.setEvnt_no(evnt_no);
			evntReqInputCfgVO =	this.evntDAO.getEvntReqInputCfg(evntReqInputCfgVO);
			vo.setEvntReqInputCfgVO(evntReqInputCfgVO);
		}
		return vo;

	}


	@Override
	public EvntReqInputCfgVO getEvntReqInputCfg(EvntReqInputCfgVO evntReqInputCfgVO) throws Exception {

		EvntReqInputCfgVO vo =	this.evntDAO.getEvntReqInputCfg(evntReqInputCfgVO);
		List<EvntReqNotCfgVO> evntReqNotCfg = this.evntDAO.getEvntReqNotCfg(vo.getEvnt_no());
		vo.setEvntReqNotCfg(evntReqNotCfg);
		return vo;
	}


	@Override
	public void addPartcptHist(EvntPartcptHistVO evntPartcptHistVO)throws Exception {
		evntDAO.addPartcptHist(evntPartcptHistVO);

		//evntFile - user
		if(evntPartcptHistVO.getFilelist() !=null){
			this.evntDAO.insertEvntFile(evntPartcptHistVO.getFilelist());
		}

	}


	@Override
	public List<ArchvFile> getFilelist(String evnt_no) {
		return this.evntDAO.getFilelist(evnt_no);
	}


	@Override
	public int delEvntFile(int file_no) throws Exception {
		// Archv File 삭제
		ArchvFileVO file	= this.evntDAO.getFileOne(file_no);
		if (file == null) return 0;

		File doc			= null;
		String file_name	= file.getRealname();

		doc = new File(EgovProperties.getPathProperty("Globals.archive.docs") + file_name);
		if (doc.exists()) doc.delete();

		return this.archvDAO.delArchvFile(file_no);
	}


	@Override
	public List<EvntPartcptHistVO> getPartcptlist(String evnt_no) throws Exception {
		return this.evntDAO.getPartcptlist(evnt_no);
	}


	@Override
	public List<EvntPartcptHistVO> getPrwinnerlist(String evnt_no) throws Exception{
		return this.evntDAO.getPrwinnerlist(evnt_no);
	}


	@Override
	public void delNotCfgByPk(String not_cfg_no) throws Exception{
		this.evntDAO.delNotCfgByPk(not_cfg_no);

	}


	@Override
	public boolean isOverApplicantLimit(String not_cfg_no) {
		int notApplicantLimit = this.evntDAO.getNotApplicantLimit(not_cfg_no);
		int applicantCount = this.evntDAO.getApplicantCount(not_cfg_no);
		if(notApplicantLimit !=0){
			if(notApplicantLimit < applicantCount){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}


	@Override
	public List<EvntVO> getListForBanner(EvntVO evntVO) {
		return this.evntDAO.getListForBanner(evntVO);
	}


	@Override
	public List<EvntVO> lnbList(EvntVO evntVO) {
		return this.evntDAO.lnbList(evntVO);
	}


	@Override
	public List<EvntVO> lnbList2(EvntVO evntVO) {
		return this.evntDAO.lnbList2(evntVO);
	}


	@Override
	public Integer lnbListCount(EvntVO evntVO) {
		return this.evntDAO.lnbListCount(evntVO);
	}


	@Override
	public EvntVO getEvntG(EvntVO evntVO) throws Exception {
		return this.evntDAO.getEvntG(evntVO);
	}


	@Override
	public void updateG(EvntVO evntVO) {
		evntDAO.updateG(evntVO);

	}


	@Override
	public void insertG(EvntVO evntVO) throws Exception {
    	this.evntDAO.insertG(evntVO);
	}


	@Override
	public void deleteg(List<Integer> arrDeleteNo) {
    	evntDAO.deleteg(arrDeleteNo);
	}


}
