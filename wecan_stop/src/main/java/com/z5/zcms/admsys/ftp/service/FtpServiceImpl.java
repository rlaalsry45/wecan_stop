package com.z5.zcms.admsys.ftp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.z5.zcms.admsys.ftp.dao.FtpDAO;
import com.z5.zcms.admsys.ftp.domain.AccessAuthorityVo;
import com.z5.zcms.admsys.ftp.domain.AccessLogVo;
import com.z5.zcms.admsys.ftp.domain.DownloadLogVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service
@Transactional
public class FtpServiceImpl extends AbstractServiceImpl implements FtpService {

    @Autowired
    private FtpDAO ftpDAO;

	// 접속기록조회
	@Override
	public Model index_accessLog(AccessLogVo reqVo, DataTable input, Model model) throws Exception {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;

        reqVo.setM(m);
        reqVo.setN(n);
        
        if (!StringUtil.isEmpty(input.get("sdate"))
        		&& !StringUtil.isEmpty(input.get("edate"))) {
        	reqVo.setSdate(input.get("sdate").replaceAll("-", ""));
        	reqVo.setEdate(input.get("edate").replaceAll("-", ""));
        }
        
        int total = this.ftpDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        List<AccessLogVo> list = this.ftpDAO.getList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public void registration_accessLog(AccessLogVo reqVo) throws Exception {
		this.ftpDAO.registration(reqVo);
	}
	
    // 다운로드이력로그조회
	@Override
	public Model index_downloadLog(DownloadLogVo reqVo, DataTable input, Model model) throws Exception {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;

        reqVo.setM(m);
        reqVo.setN(n);
        
        if (!StringUtil.isEmpty(input.get("sdate"))
        		&& !StringUtil.isEmpty(input.get("edate"))) {
        	reqVo.setSdate(input.get("sdate").replaceAll("-", ""));
        	reqVo.setEdate(input.get("edate").replaceAll("-", ""));
        }
        
        int total = this.ftpDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        List<DownloadLogVo> list = this.ftpDAO.getList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public void registration_downloadLog(DownloadLogVo reqVo) throws Exception {
		this.ftpDAO.registration(reqVo);
	}

	@Override
	public Model index_accessAuthority(AccessAuthorityVo reqVo, DataTable input, Model model) throws Exception {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;

        reqVo.setM(m);
        reqVo.setN(n);
        
        if (!StringUtil.isEmpty(input.get("sdate"))
        		&& !StringUtil.isEmpty(input.get("edate"))) {
        	reqVo.setSdate(input.get("sdate").replaceAll("-", ""));
        	reqVo.setEdate(input.get("edate").replaceAll("-", ""));
        }
        
        int total = this.ftpDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        List<AccessAuthorityVo> list = this.ftpDAO.getList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public AccessAuthorityVo view_accessAuthority(AccessAuthorityVo reqVo) throws Exception {
		return this.ftpDAO.view(reqVo);
	}
	
	@Override
	public int registration_accessAuthority(AccessAuthorityVo reqVo) throws Exception {
		return this.ftpDAO.registration(reqVo);
	}
	
	@Override
	public void update_accessAuthority(AccessAuthorityVo reqVo) throws Exception {
		this.ftpDAO.update(reqVo);
	}
	
	@Override
	public List<AccessAuthorityVo> view_accessAuthorityUrl(AccessAuthorityVo reqVo) throws Exception {
		return this.ftpDAO.getUrlList(reqVo);
	}

	@Override
	public void registration_permission_accessAuthority(AccessAuthorityVo reqVo) throws Exception {
		this.ftpDAO.permissionRegistration(reqVo);
	}
	
	@Override
	public void deletion_permission_accessAuthority(AccessAuthorityVo reqVo) throws Exception {
		this.ftpDAO.permissionDeletion(reqVo);
	}
	
	@Override
	public int permission_count(AccessAuthorityVo reqVo) throws Exception {
		return this.ftpDAO.permissionCount(reqVo);
	}
	
	@Override
	public List<AccessLogVo> accessLog_excel(AccessLogVo reqVo) throws Exception {
		reqVo.setM(0);
        reqVo.setN(99999999);
        
        if (!StringUtil.isEmpty(reqVo.getSdate())
        		&& !StringUtil.isEmpty(reqVo.getEdate())) {
        	reqVo.setSdate(reqVo.getSdate().replaceAll("-", ""));
        	reqVo.setEdate(reqVo.getEdate().replaceAll("-", ""));
        }
        
        return this.ftpDAO.getList(reqVo);
	}	
	
	@Override
	public List<DownloadLogVo> downloadLog_excel(DownloadLogVo reqVo) throws Exception {
		reqVo.setM(0);
        reqVo.setN(99999999);
        
        if (!StringUtil.isEmpty(reqVo.getSdate())
        		&& !StringUtil.isEmpty(reqVo.getEdate())) {
        	reqVo.setSdate(reqVo.getSdate().replaceAll("-", ""));
        	reqVo.setEdate(reqVo.getEdate().replaceAll("-", ""));
        }
        
        return this.ftpDAO.getList(reqVo);
	}

	@Override
	public List<AccessAuthorityVo> permission(AccessAuthorityVo reqVo) throws Exception {
		return this.ftpDAO.getPermission(reqVo);
	}

	@Override
	public List<EgovMap> authority_excel(AccessAuthorityVo reqVo) throws Exception {
		reqVo.setM(0);
        reqVo.setN(99999999);
		
		if (!StringUtil.isEmpty(reqVo.getSdate())
        		&& !StringUtil.isEmpty(reqVo.getEdate())) {
        	reqVo.setSdate(reqVo.getSdate().replaceAll("-", ""));
        	reqVo.setEdate(reqVo.getEdate().replaceAll("-", ""));
        }
		
		return this.ftpDAO.authority_excel(reqVo);
	}
	
}
