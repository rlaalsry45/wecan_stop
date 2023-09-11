package com.z5.zcms.admsys.ftp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.ftp.domain.AccessAuthorityVo;
import com.z5.zcms.admsys.ftp.domain.AccessLogVo;
import com.z5.zcms.admsys.ftp.domain.DownloadLogVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Repository
public class FtpDAOImpl extends EgovComAbstractDAO implements FtpDAO {

	private final String sqlMapNs_accessLog = "accessLog.";
    private final String sqlMapNs_downloadLog = "downloadLog.";
    private final String sqlMapNs_accessAuthority = "accessAuthority.";
    
    Logger log = Logger.getLogger(this.getClass());

    @Override
	public Integer listCount(AccessLogVo reqVo) {
    	return (Integer) select(sqlMapNs_accessLog + "listCount", reqVo);
	}

    @SuppressWarnings("unchecked")
	public List<AccessLogVo> getList(AccessLogVo reqVo) {
    	return (List<AccessLogVo>) super.list(sqlMapNs_accessLog + "getList", reqVo);
	}

	@Override
	public String registration(AccessLogVo reqVo) {
		return (String)super.insert(sqlMapNs_accessLog + "actionRegistration", reqVo);
	}
	
	@Override
	public Integer listCount(DownloadLogVo reqVo) {
		return (Integer) select(sqlMapNs_downloadLog + "listCount", reqVo);
	}

	@SuppressWarnings("unchecked")
	public List<DownloadLogVo> getList(DownloadLogVo reqVo) {
		return (List<DownloadLogVo>) super.list(sqlMapNs_downloadLog + "getList", reqVo);
	}

	@Override
	public String registration(DownloadLogVo reqVo) {
		return (String)super.insert(sqlMapNs_downloadLog + "actionRegistration", reqVo);
	}

	@Override
	public Integer listCount(AccessAuthorityVo reqVo) {
		return (Integer) select(sqlMapNs_accessAuthority + "listCount", reqVo);
	}

	@SuppressWarnings("unchecked")
	public List<AccessAuthorityVo> getList(AccessAuthorityVo reqVo) {
		return (List<AccessAuthorityVo>) super.list(sqlMapNs_accessAuthority + "getList", reqVo);
	}

	@Override
	public AccessAuthorityVo view(AccessAuthorityVo reqVo) {
		return (AccessAuthorityVo)super.select(sqlMapNs_accessAuthority + "view", reqVo);
	}
	
	@Override
	public Integer registration(AccessAuthorityVo reqVo) {
		return (Integer)super.insert(sqlMapNs_accessAuthority + "actionRegistration", reqVo);
	}

	@Override
	public void update(AccessAuthorityVo reqVo) {
		super.update(sqlMapNs_accessAuthority + "actionUpdate", reqVo);
	}

	@SuppressWarnings("unchecked")
	public List<AccessAuthorityVo> getUrlList(AccessAuthorityVo reqVo) {
		return (List<AccessAuthorityVo>) super.list(sqlMapNs_accessAuthority + "getUrlList", reqVo);
	}

	@Override
	public void permissionRegistration(AccessAuthorityVo reqVo) {
		super.insert(sqlMapNs_accessAuthority + "actionPermissionRegistration", reqVo);
	}

	@Override
	public void permissionDeletion(AccessAuthorityVo reqVo) {
		super.delete(sqlMapNs_accessAuthority + "actionPermissionDeletion", reqVo);
	}

	@Override
	public Integer permissionCount(AccessAuthorityVo reqVo) {
		return (Integer) select(sqlMapNs_accessAuthority + "permissionCount", reqVo);
	}

	@SuppressWarnings("unchecked")
	public List<AccessAuthorityVo> getPermission(AccessAuthorityVo reqVo) {
    	return (List<AccessAuthorityVo>) super.list(sqlMapNs_accessAuthority + "getPermission", reqVo);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EgovMap> authority_excel(AccessAuthorityVo reqVo) {
		return (List<EgovMap>) super.list(sqlMapNs_accessAuthority + "authority_excel", reqVo);
	}

}
