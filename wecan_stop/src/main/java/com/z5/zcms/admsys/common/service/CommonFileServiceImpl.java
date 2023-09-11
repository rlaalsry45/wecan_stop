package com.z5.zcms.admsys.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.common.dao.CommonFileDAO;
import com.z5.zcms.admsys.common.domain.FileInfoVo;

@Service
public class CommonFileServiceImpl implements CommonFileService{
	
	@Autowired
    private CommonFileDAO commonFileDAO;

	@Override
	public Integer registrationFileInfo(FileInfoVo fileVo) {
		return commonFileDAO.registrationFileInfo(fileVo);
	}

	@Override
	public String retrieveFileNameByNO(int no) {
		return commonFileDAO.retrieveFileNameByNO(no);
	}

	@Override
	public void deleteFileIno(int no) {
		commonFileDAO.deleteFileIno(no);
	}

	@Override
	public int retrieveFileCountByNO(FileInfoVo fileVo) {
		return commonFileDAO.retrieveFileCountByNO(fileVo);
	}

	@Override
	public void updateFileInfo(FileInfoVo fileVo) {
		commonFileDAO.updateFileInfo(fileVo);
	}

	@Override
	public List<FileInfoVo> retrieveFilListByMenuNo(FileInfoVo fileVo) {
		return commonFileDAO.retrieveFilListByMenuNo(fileVo);
	}
}