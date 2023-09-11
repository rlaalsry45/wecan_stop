package com.z5.zcms.admsys.archv.service;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.frontsys.archv.dao.ArchvDAO;
import com.z5.zcms.frontsys.archv.dao.ArchvOptDAO;
import com.z5.zcms.frontsys.archv.domain.ArchvFile;
import com.z5.zcms.frontsys.archv.domain.ArchvFileVO;
import com.z5.zcms.frontsys.archv.domain.ArchvOpt;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
@Transactional
public class ArchvRegServiceImpl extends EgovAbstractServiceImpl implements ArchvRegService {

	@Autowired
	ArchvOptDAO archvOptDAO;

	@Autowired
	ArchvDAO archvDAO;

	@Override
	public List<ArchvOpt> getArchvOpt() throws Exception {
		return this.archvOptDAO.list();
	}

	@Override
	public String create(ArchvVO archvVO) throws Exception {

		String archv_no="";
		if (archvVO.getArchv_no() == null) {
			archv_no=this.archvDAO.insertArchv(archvVO);
			this.archvDAO.insertArchvConts(archvVO);
			//this.archvDAO.insertArchvAprov(archvVO); //결제관련 임시로 막아둠
			if ("1".equals(archvVO.getOpt_no()))  { // 행사일 경우 행사기간 입력
				this.archvDAO.insertArchvEvntPeriod(archvVO);
			}
		}
		else {
			this.archvDAO.updateArchv(archvVO);
			this.archvDAO.updateArchvConts(archvVO);
//			this.archvDAO.updateArchvAprov(archvVO); // 등록자를 갱신하지 않음
			if ("1".equals(archvVO.getOpt_no()))  { // 행사일 경우 행사기간 갱신
				this.archvDAO.updateArchvEvntPeriod(archvVO);
			}
		}
		/*
		 * 동영상을 제외하고 파일업로드를 실행
		 * 파일은 갱신이 아닌 항상 신규 insert라서 update 와 함께 사용함
		 * */
		if (archvVO.getOpt_no() != null && archvVO.getOpt_no() != "")	{
			switch (Integer.valueOf(archvVO.getOpt_no())) {
				case 7 :
						break;
//				case 8 :
//					break;
				default:
					this.archvDAO.insertArchvFile(archvVO);
					break;
			}
		}
		return archv_no;
	}

	@Override
	public void delete(String archv_no) throws Exception {

		// 파일삭제
		ArchvVO archvVO = new ArchvVO();
		archvVO.setArchv_no(archv_no);

		int file_no = 0;
		ArchvFile archvFile = null;
		List<ArchvFile> files = this.archvDAO.getFileList(archvVO);

		for (int i = 0; i != files.size(); ++i) {
			archvFile = files.get(i);
			file_no = Integer.valueOf(archvFile.getFile_no());
			this.delArchvFile(file_no);
		}

		// 디비삭제
		this.archvDAO.delArchv(Integer.valueOf(archv_no));

	}

	@Override
	public List<ArchvVO> getArchvList4Admin(ArchvVO archvVO) throws Exception {
		return this.archvDAO.getArchvList4Admin(archvVO);
	}

	@Override
	public int getTotalAdmin(ArchvVO archvVO) throws Exception {
		return this.archvDAO.getTotalAdmin(archvVO);
	}

	@Override
	public ArchvVO getDetail4Admin(int archv_no) throws Exception {
		return this.archvDAO.getDetail4Admin(archv_no);
	}

	@Override
	public List<ArchvFile> getFileList(ArchvVO archvVO) throws Exception {
		return this.archvDAO.getFileList(archvVO);
	}

	@Override
	public int delArchvFile(int file_no) throws Exception {

		// Archv File 삭제
		ArchvFileVO file	= this.archvDAO.getFileOne(file_no);
		if (file == null) return 0;

		int opt_no			= Integer.valueOf(file.getOpt_no()).intValue();
		File org			= null;
		File doc			= null;
		File thbnail		= null;
		File detail			= null;
		String file_name	= file.getRealname();

		/*1, 2, 3, 4, 6, 8 : org (원본) 와 thbnail 삭제
		5 : 문서에서 삭제
		6 : 디테일도 삭제*/

		if (opt_no == 5) { // 문서삭제
			doc = new File(EgovProperties.getPathProperty("Globals.archive.docs") + file_name);
			if (doc.exists()) doc.delete();
		}

		if (ArrayUtils.contains(new int[]{1, 2, 3, 4, 6, 8}, opt_no)) {

			// org 삭제
			org = new File(EgovProperties.getPathProperty("Globals.archive.image.org") + file_name);
			if (org.exists()) org.delete();

			// thbnail 삭제
			thbnail = new File(EgovProperties.getPathProperty("Globals.archive.image.thumbnail") + file_name);
			if (thbnail.exists()) thbnail.delete();

			 // 사진 detail 삭제
			if (opt_no == 6) {
				detail = new File(EgovProperties.getPathProperty("Globals.archive.image.detail") + file_name);
				if (detail.exists()) detail.delete();
			}
		}

		return this.archvDAO.delArchvFile(file_no);
	}

	@Override
	public void addArchvoNo2Menu(ArchvVO archvVO) throws Exception {
		this.archvDAO.addArchvoNo2Menu(archvVO);
	}

	@Override
	public List<ArchvVO> getRltd(int archv_no) throws Exception {
		return this.archvDAO.getRltd(archv_no);
	}

	@Override
	public int delRltd(int menuno) throws Exception {
		return this.archvDAO.delRltd(menuno);
	}

	@Override
	public ArchvFileVO getFileInfoForDownload(int file_no) throws Exception {		
		return this.archvDAO.getFileOne(file_no);
	}
	
	@Override
	public void insertArchvComment(ArchvVO archvVO) throws Exception {
		this.archvDAO.insertArchvComment(archvVO);
		
	}

	@Override
	public List<ArchvVO> getArchvComment(int archv_no) throws Exception {
		return (List<ArchvVO>)this.archvDAO.getArchvComment(archv_no);
	}
	@Override
	public void deleteArchvComment(int comment_no) throws Exception {
		this.archvDAO.deleteArchvComment(comment_no);
	}

}
