package com.z5.zcms.admsys.ftp.dao;

import java.util.List;

import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.ftp.domain.AccessAuthorityVo;
import com.z5.zcms.admsys.ftp.domain.AccessLogVo;
import com.z5.zcms.admsys.ftp.domain.DownloadLogVo;

public interface FtpDAO {

	
	// 접속기록조회
    public Integer listCount(AccessLogVo reqVo);
    public List<AccessLogVo> getList(AccessLogVo reqVo);
    public String registration(AccessLogVo reqVo);
    
    // 다운로드이력로그조회
    public Integer listCount(DownloadLogVo reqVo);
    public List<DownloadLogVo> getList(DownloadLogVo reqVo);
    public String registration(DownloadLogVo reqVo);
    
    // 접근권한관리조회
    public Integer listCount(AccessAuthorityVo reqVo);
    public List<AccessAuthorityVo> getList(AccessAuthorityVo reqVo);
    public AccessAuthorityVo view(AccessAuthorityVo reqVo); 
    public Integer registration(AccessAuthorityVo reqVo);
    public void update(AccessAuthorityVo reqVo);
    public List<AccessAuthorityVo> getUrlList(AccessAuthorityVo reqVo);
    public void permissionRegistration(AccessAuthorityVo reqVo);
    public void permissionDeletion(AccessAuthorityVo reqVo);
    public Integer permissionCount(AccessAuthorityVo reqVo);
    public List<AccessAuthorityVo> getPermission(AccessAuthorityVo reqVo);
}
