package com.z5.zcms.frontsys.archv.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import com.z5.zcms.frontsys.archv.domain.ArchvFile;
import com.z5.zcms.frontsys.archv.domain.ArchvFileVO;
import com.z5.zcms.frontsys.archv.domain.ArchvMenunoPath;
import com.z5.zcms.frontsys.archv.domain.ArchvRltdVO;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ArchvDAOImpl extends EgovComAbstractDAO implements ArchvDAO{

	private final String sqlNS ="Archv.";

	@Override
	public ArchvVO getArchv(ArchvVO archvVO) throws Exception {
		return (ArchvVO) this.getSqlMapClientTemplate().queryForObject(sqlNS + "getArchv", archvVO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvVO> getArchvList(ArchvVO archvVO) throws Exception {
		return (List<ArchvVO>) super.list(sqlNS + "list", archvVO);
	}

	@Override
	public ArchvVO getListCount(ArchvVO archvVO) {
		return (ArchvVO) this.getSqlMapClientTemplate().queryForObject(sqlNS+"listCount",archvVO);

	}

	@Override
	public ArchvVO getArchvListWithPreNext(ArchvVO archvVO) {
		return (ArchvVO) this.getSqlMapClientTemplate().queryForObject(sqlNS + "getArchvListWithPreNext", archvVO);
	}

	@Override
	public void addCount(ArchvVO archvVO) {
		this.update(sqlNS + "addCount", archvVO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvFile> getFileList(ArchvVO archvVO) {
		return (List<ArchvFile>) super.list(sqlNS + "getFileList", archvVO);
	}

	@Override
	public String insertArchv(ArchvVO archvVO) {
		this.getSqlMapClientTemplate().insert(sqlNS + "insertArchv", archvVO);
		return archvVO.getArchv_no();
	}

	@Override
	public void insertArchvConts(ArchvVO archvVO) {
		this.getSqlMapClientTemplate().insert(sqlNS + "insertArchvConts", archvVO);
	}

	@Override
	public void insertArchvFile(ArchvVO archvVO) {
		List<ArchvFile> file = archvVO.getFilelist();
		if (file.size() != 0) {

			ArchvFile archvFile = null;

			for (int i = 0; i != file.size(); ++i) {
				archvFile = file.get(i);
				if (archvFile != null)
					archvFile.setArchv_no(archvVO.getArchv_no());
					this.getSqlMapClientTemplate().insert(sqlNS + "insertArchvFile", archvFile);
			}
		}
	}

	@Override
	public void insertArchvAprov(ArchvVO archvVO) {
		this.getSqlMapClientTemplate().insert(sqlNS + "insertArchvAprov", archvVO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvVO> getArchvList4Admin(ArchvVO archvVO) throws Exception {
		return this.getSqlMapClientTemplate().queryForList(sqlNS + "listAdmin", archvVO);	// archv_admin.xml
	}

	@Override
	public int getTotalAdmin(ArchvVO archvVO) throws Exception {
		return (Integer) this.getSqlMapClientTemplate().queryForObject(sqlNS + "getTotalAdmin", archvVO);
	}

	@Override
	public String getOrgFilename(String filename) throws Exception {
		return (String) this.getSqlMapClientTemplate().queryForObject(sqlNS + "getOrgFilename", filename);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvCatgryVO> getLnbCatgryList(ArchvCatgryVO archvCatgryVO) throws Exception{
		return (List<ArchvCatgryVO>) super.list(sqlNS + "getLnbCatgryList", archvCatgryVO);
	}

	@Override
	public ArchvVO getDetail4Admin(int archv_no) throws Exception {
		return (ArchvVO) this.getSqlMapClientTemplate().queryForObject(sqlNS + "getDetail4Admin", archv_no);
	}

	@Override
	public int delArchvFile(int file_no) throws Exception {
		return this.getSqlMapClientTemplate().delete(sqlNS + "delArchvFile", file_no);
	}

	@Override
	public ArchvFileVO getFileOne(int file_no) throws Exception {
		return (ArchvFileVO) this.getSqlMapClientTemplate().queryForObject(sqlNS + "getFileOne", file_no);
	}

	@Override
	public void updateArchv(ArchvVO archvVO) throws Exception {
		this.getSqlMapClientTemplate().insert(sqlNS + "updateArchv", archvVO);

	}

	@Override
	public void updateArchvConts(ArchvVO archvVO) throws Exception {
		this.getSqlMapClientTemplate().insert(sqlNS + "updateArchvConts", archvVO);

	}

	@Override
	public void updateArchvAprov(ArchvVO archvVO) throws Exception {
		// TODO Auto-generated method stub

	}
	@Override
	public String getArchvCatgryNameListByPath(ArchvVO vo) throws Exception {
		return (String) this.getSqlMapClientTemplate().queryForObject(sqlNS + "getArchvCatgryNameListByPath", vo);
	}

	@Override
	public String getContsByArchv_no(String archv_no) throws Exception{
		return (String) this.getSqlMapClientTemplate().queryForObject(sqlNS + "getContsByArchv_no", archv_no);
	}

	@Override
	public void delArchv(int archv_no) throws Exception {
		this.getSqlMapClientTemplate().delete(sqlNS + "delArchv", 			archv_no);
		this.getSqlMapClientTemplate().delete(sqlNS + "delArchvConts", 		archv_no);
		this.getSqlMapClientTemplate().delete(sqlNS + "delArchvFiles",		archv_no);
		this.getSqlMapClientTemplate().delete(sqlNS + "delArchvAprov", 		archv_no);
		this.getSqlMapClientTemplate().delete(sqlNS + "delArchvEvntPeriod", archv_no);
		this.getSqlMapClientTemplate().delete(sqlNS + "delArchvComment", 	archv_no);
	}

	@Override
	public void addArchvoNo2Menu(ArchvVO archvVO) throws Exception {
		this.getSqlMapClientTemplate().insert(sqlNS + "addArchvoNo2Menu", archvVO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvVO> getRltd(int archv_no) throws Exception {
		return this.getSqlMapClientTemplate().queryForList(sqlNS + "getRltd", archv_no);
	}

	@Override
	public int delRltd(int menuno) throws Exception {
		return this.getSqlMapClientTemplate().delete(sqlNS + "delRltd", menuno);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvRltdVO> getRltdByMenunoAndSiteno(ArchvRltdVO archvRltdVO) throws Exception{
		return this.getSqlMapClientTemplate().queryForList(sqlNS + "getRltdByMenunoAndSiteno", archvRltdVO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvMenunoPath> getLinkMenunoList(ArchvVO archvVO) {
		return (List<ArchvMenunoPath>) super.list(sqlNS + "getLinkMenunoList", archvVO);
	}

	@Override
	public void delRltdInMenu(String rltd_no) {
		this.getSqlMapClientTemplate().delete(sqlNS + "delRltdInMenu", rltd_no);
	}

	@Override
	public void addRltdInMenu(ArchvRltdVO archvRltdVO) {
		this.getSqlMapClientTemplate().insert(sqlNS + "addRltdInMenu", archvRltdVO);
	}

	@Override
	public void delRltdListInMenu(ArchvRltdVO rltdVO) {
		this.getSqlMapClientTemplate().delete(sqlNS + "delRltdListInMenu", rltdVO);
	}

	@Override
	public void insertArchvEvntPeriod(ArchvVO archvVO) throws Exception {
		this.getSqlMapClientTemplate().insert(sqlNS + "insertArchvEvntPeriod", archvVO);
	}

	@Override
	public void updateArchvEvntPeriod(ArchvVO archvVO) throws Exception {
		this.getSqlMapClientTemplate().update(sqlNS + "updateArchvEvntPeriod", archvVO);
	}
	
	@Override
	public void delArchvFiles(int archv_no) throws Exception {
		this.getSqlMapClientTemplate().delete(sqlNS + "delArchvFiles",		archv_no);
	}

	@Override
	public void insertArchvComment(ArchvVO archvVO) throws Exception {
		this.getSqlMapClientTemplate().insert(sqlNS + "insertArchvComment", archvVO);
	}

	@Override
	public List<ArchvVO> getArchvComment(int archv_no) throws Exception {
		return (List<ArchvVO>) super.list(sqlNS + "getArchvComment", archv_no);
	}

	@Override
	public void updateHits(int archv_no) throws Exception {
		this.getSqlMapClientTemplate().update(sqlNS + "updateHits", archv_no);
	}
	
	@Override
	public void deleteArchvComment(int comment_no) throws Exception {
		this.getSqlMapClientTemplate().delete(sqlNS + "delArchvComment2", comment_no);
	}
	
}