package com.z5.zcms.admsys.common.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.common.domain.FileInfoVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class CommonFileDAOImpl extends EgovComAbstractDAO implements CommonFileDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "CommonFile.";
	
	@Override
	public Integer registrationFileInfo(FileInfoVo fileVo) {
		return (Integer)insert(sqlMapNs+"registrationFileInfo",fileVo);
	}

	@Override
	public String retrieveFileNameByNO(int no) {
		return (String)select(sqlMapNs+"retrieveFileNameByNO", no);
	}

	@Override
	public void deleteFileIno(int no) {
		delete(sqlMapNs+"deleteFileIno", no);		
	}

	@Override
	public int retrieveFileCountByNO(FileInfoVo fileVo) {
		return (int)select(sqlMapNs+"retrieveFileCountByNO", fileVo);
	}

	@Override
	public void updateFileInfo(FileInfoVo fileVo) {
		update(sqlMapNs+"updateFileInfo", fileVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileInfoVo> retrieveFilListByMenuNo(FileInfoVo fileVo) {
		return (List<FileInfoVo>)list(sqlMapNs+"retrieveFilListByMenuNo", fileVo);
	}
}
