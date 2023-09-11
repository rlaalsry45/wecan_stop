package com.z5.zcms.admsys.ftp.service;

import java.util.List;

import org.springframework.ui.Model;

import com.z5.zcms.admsys.ftp.domain.AccessAuthorityVo;
import com.z5.zcms.admsys.ftp.domain.AccessLogVo;
import com.z5.zcms.admsys.ftp.domain.DownloadLogVo;
import com.z5.zcms.util.DataTable;

import egovframework.rte.psl.dataaccess.util.EgovMap;

//@Service superbolt
public interface FtpService {
	
	// 접속기록조회
	Model index_accessLog(AccessLogVo reqVo, DataTable input, Model model) throws Exception;
	public void registration_accessLog(AccessLogVo reqVo) throws Exception;
		
	// 다운로드이력로그조회
	Model index_downloadLog(DownloadLogVo reqVo, DataTable input, Model model) throws Exception;
	public void registration_downloadLog(DownloadLogVo reqVo) throws Exception;
	
	// 접근권한관리조회
	Model index_accessAuthority(AccessAuthorityVo reqVo, DataTable input, Model model) throws Exception;
	public AccessAuthorityVo view_accessAuthority(AccessAuthorityVo reqVo) throws Exception;
	public int registration_accessAuthority(AccessAuthorityVo reqVo) throws Exception;
	public void update_accessAuthority(AccessAuthorityVo reqVo) throws Exception;
	public List<AccessAuthorityVo> view_accessAuthorityUrl(AccessAuthorityVo reqVo) throws Exception;
	public void registration_permission_accessAuthority(AccessAuthorityVo reqVo) throws Exception;
	public void deletion_permission_accessAuthority(AccessAuthorityVo reqVo) throws Exception;
	public int permission_count(AccessAuthorityVo reqVo) throws Exception;
	public List<AccessAuthorityVo> permission(AccessAuthorityVo reqVo) throws Exception;
	
	public List<AccessLogVo> accessLog_excel(AccessLogVo reqVo) throws Exception;
	public List<DownloadLogVo> downloadLog_excel(DownloadLogVo reqVo) throws Exception;
	public List<EgovMap> authority_excel(AccessAuthorityVo reqVo) throws Exception;

}