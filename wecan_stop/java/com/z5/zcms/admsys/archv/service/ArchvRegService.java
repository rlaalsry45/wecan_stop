package com.z5.zcms.admsys.archv.service;

import java.util.List;

import com.z5.zcms.frontsys.archv.domain.ArchvFile;
import com.z5.zcms.frontsys.archv.domain.ArchvOpt;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;

public interface ArchvRegService {

	public List<ArchvOpt> getArchvOpt() throws Exception;
	public String create(ArchvVO archvVO) throws Exception;
	public void delete(String archv_no) throws Exception;
	public List<ArchvVO> getArchvList4Admin(ArchvVO archvVO) throws Exception;
	public int getTotalAdmin(ArchvVO archvVO) throws Exception;
	public ArchvVO getDetail4Admin(int archv_no) throws Exception;
	public List<ArchvFile> getFileList(ArchvVO archvVO) throws Exception;
	public int delArchvFile(int file_no) throws Exception;
	public void addArchvoNo2Menu(ArchvVO archvVO) throws Exception;
	public List<ArchvVO> getRltd(int archv_no) throws Exception;
	public int delRltd(int menuno) throws Exception;
	public void delArchvFiles(int archv_no) throws Exception;
	public void insertArchvComment(ArchvVO archvVO) throws Exception;
	public List<ArchvVO> getArchvComment(int archv_no) throws Exception;
	public void updateHits(int archv_no) throws Exception;
	public void deleteArchvComment(int comment_no) throws Exception;
}