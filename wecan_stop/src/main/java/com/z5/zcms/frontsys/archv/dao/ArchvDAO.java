package com.z5.zcms.frontsys.archv.dao;

import java.util.List;

import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import com.z5.zcms.frontsys.archv.domain.ArchvFile;
import com.z5.zcms.frontsys.archv.domain.ArchvFileVO;
import com.z5.zcms.frontsys.archv.domain.ArchvMenunoPath;
import com.z5.zcms.frontsys.archv.domain.ArchvRltdVO;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;

public interface ArchvDAO {

	public ArchvVO getArchv(ArchvVO archvVO) throws Exception;
	public List<ArchvVO> getArchvList(ArchvVO archvVO) throws Exception;
	public List<ArchvVO> getArchvList4Admin(ArchvVO archvVO) throws Exception;
	public ArchvVO getListCount(ArchvVO archvVO);
	public ArchvVO getArchvListWithPreNext(ArchvVO archvVO);
	public void addCount(ArchvVO archvVO);
	public List<ArchvFile> getFileList(ArchvVO archvVO);
	public int getTotalAdmin(ArchvVO archvVO) throws Exception;
	public String insertArchv(ArchvVO archvVO) throws Exception;
	public void insertArchvConts(ArchvVO archvVO) throws Exception;
	public void insertArchvFile(ArchvVO archvVO) throws Exception;
	public void insertArchvAprov(ArchvVO archvVO) throws Exception;
	public void insertArchvEvntPeriod(ArchvVO archvVO) throws Exception;
	public void updateArchv(ArchvVO archvVO) throws Exception;
	public void updateArchvConts(ArchvVO archvVO) throws Exception;
	public void updateArchvAprov(ArchvVO archvVO) throws Exception;
	public void updateArchvEvntPeriod(ArchvVO archvVO) throws Exception;
	public ArchvVO getDetail4Admin(int archv_no) throws Exception;
	public String getOrgFilename(String filename) throws Exception;
	public List<ArchvCatgryVO> getLnbCatgryList(ArchvCatgryVO archvCatgryVO) throws Exception;
	public int delArchvFile(int file_no) throws Exception;
	public ArchvFileVO getFileOne(int file_no) throws Exception;
	public String getArchvCatgryNameListByPath(ArchvVO vo) throws Exception;
	public void delArchv(int archv_no) throws Exception;
	public String getContsByArchv_no(String archv_no) throws Exception;
	public void addArchvoNo2Menu(ArchvVO archvVO) throws Exception;
	public List<ArchvVO> getRltd(int archv_no) throws Exception;
	public int delRltd(int menuno) throws Exception;
	public List<ArchvRltdVO> getRltdByMenunoAndSiteno(ArchvRltdVO archvRltdVO) throws Exception;
	public List<ArchvMenunoPath> getLinkMenunoList(ArchvVO archvVO);
	public void delRltdInMenu(String rltd_no);
	public void addRltdInMenu(ArchvRltdVO insertVO);
	public void delRltdListInMenu(ArchvRltdVO rltdVO);
	public void insertArchvComment(ArchvVO archvVO) throws Exception;
	public List<ArchvVO> getArchvComment(int archv_no) throws Exception;
	public void deleteArchvComment(int comment_no) throws Exception;
}
