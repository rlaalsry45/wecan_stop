package com.z5.zcms.frontsys.archv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.frontsys.archv.dao.ArchvDAO;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import com.z5.zcms.frontsys.archv.domain.ArchvFile;
import com.z5.zcms.frontsys.archv.domain.ArchvMenunoPath;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
@Transactional
public class ArchvFrontServiceImpl extends AbstractServiceImpl implements ArchvFrontService{

	@Autowired
	ArchvDAO archvDAO;
	
	@Override
	public ArchvVO getArchv(ArchvVO archvVO) throws Exception {
		this.archvDAO.addCount(archvVO);//count+1
		ArchvVO rtVO = this.archvDAO.getArchv(archvVO);//getArchv
		List<ArchvFile> filelist = this.archvDAO.getFileList(archvVO);//getFile
		rtVO.setFilelist(filelist);
		return rtVO;
	}

	@Override
	public List<ArchvVO> getArchvList(ArchvVO archvVO) throws Exception {
		return this.archvDAO.getArchvList(archvVO);
	}

	@Override
	public ArchvVO getListCount(ArchvVO archvVO) throws Exception {
		return this.archvDAO.getListCount(archvVO);
	}

	@Override
	public ArchvVO getArchvListWithPreNext(ArchvVO archvVO)	throws Exception {
		//count+1
		this.archvDAO.addCount(archvVO);
		//getArchv
		ArchvVO rtVO = this.archvDAO.getArchvListWithPreNext(archvVO); 
		//filelist get
		List<ArchvFile> filelist = null;
		filelist = this.archvDAO.getFileList(archvVO);
		if(filelist != null){
			rtVO.setFilelist(filelist);
		}
		
		//ZMENU_TITLE_PATH get
		List<ArchvMenunoPath> archvMenunoPathList = this.archvDAO.getLinkMenunoList(archvVO);
		if(archvMenunoPathList.size() > 0){
			rtVO.setArchvMenunoPathList(archvMenunoPathList);
		}
		
		
		return rtVO;
		
	}

	@Override
	public String getOrgFilename(String filename) throws Exception {
		return this.archvDAO.getOrgFilename(filename);
	}

	@Override
	public List<ArchvCatgryVO> getLnbCatgryList(ArchvCatgryVO archvCatgryVO) throws Exception{
		return this.archvDAO.getLnbCatgryList(archvCatgryVO);
	}

	@Override
	public String getArchvCatgryNameListByPath(ArchvVO vo) throws Exception {
		return this.archvDAO.getArchvCatgryNameListByPath(vo);
	}

	@Override
	public String getContsByArchv_no(String archv_no) throws Exception{
		return this.archvDAO.getContsByArchv_no(archv_no);
	}


}
