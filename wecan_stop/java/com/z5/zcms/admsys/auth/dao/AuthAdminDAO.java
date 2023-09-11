package com.z5.zcms.admsys.auth.dao;

import java.util.List;
import java.util.Map;

import com.z5.zcms.admsys.auth.domain.Auth;
import com.z5.zcms.admsys.auth.domain.AuthAdminVo;
import com.z5.zcms.admsys.auth.domain.UserOtpVo;
import com.z5.zcms.util.DataTable;

public interface AuthAdminDAO {
	public List<AuthAdminVo> authAdminUrlList();
	public List<AuthAdminVo> authAdminList(AuthAdminVo authAdminVo);
	public void authAdminEdit(List<AuthAdminVo> authAdminList);
	public void authAdminWrite(AuthAdminVo authAdminVo);
	public void authAdminUrlDelete(List<String> map);
	public void authAdminDel();
	public void authAdminDelete(Auth auth);
	public List<String> authSubUrlList(Auth auth);
	public void authAdminMutiDelete(Auth auth);
	public void orderChange(DataTable input);
	
	public String findOneUserOtpKey(String userId);
	public void insertUserOtpKey(UserOtpVo userOtpVo);
}