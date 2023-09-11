package com.z5.zcms.admsys.auth.service;

import com.z5.zcms.admsys.auth.dao.AuthAdminDAO;
import com.z5.zcms.admsys.auth.domain.Auth;
import com.z5.zcms.admsys.auth.domain.AuthAdminVo;
import com.z5.zcms.admsys.auth.domain.UserOtpVo;
import com.z5.zcms.util.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AuthAdminServiceImpl implements AuthAdminService {

    @Autowired
    private AuthAdminDAO authAdminDAO;

    public List<AuthAdminVo> authAdminUrlList() {
        return authAdminDAO.authAdminUrlList();
    }

    public List<AuthAdminVo> authAdminList(AuthAdminVo authAdminVo) {
        return authAdminDAO.authAdminList(authAdminVo);
    }

    @Transactional
    public void authAdminEdit(List<AuthAdminVo> authAdminList) {
        authAdminDAO.authAdminEdit(authAdminList);
    }

    public void authAdminWrite(AuthAdminVo authAdminVo) {
        authAdminDAO.authAdminWrite(authAdminVo);
    }

    public void authAdminUrlDelete(List<String> map) {
        authAdminDAO.authAdminUrlDelete(map);
    }

    public void authAdminDel() {
        authAdminDAO.authAdminDel();
    }

    public void authAdminDelete(Auth auth) {
        authAdminDAO.authAdminDelete(auth);
    }

    public List<String> authSubUrlList(Auth auth) {
        return authAdminDAO.authSubUrlList(auth);
    }

    public void authAdminMutiDelete(Auth auth) {
        authAdminDAO.authAdminMutiDelete(auth);
    }

    public void orderChange(DataTable input) {
        authAdminDAO.orderChange(input);
    }

	public String findOneUserOtpKey(String userId) {
		return authAdminDAO.findOneUserOtpKey(userId);
	}

	public void insertUserOtpKey(UserOtpVo userOtpVo) {
		authAdminDAO.insertUserOtpKey(userOtpVo);
	}
}
