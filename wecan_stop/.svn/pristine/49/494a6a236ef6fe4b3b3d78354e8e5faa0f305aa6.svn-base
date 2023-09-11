package com.z5.zcms.security.SSO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.security.SSO.dao.GinueSSODAO;
import com.z5.zcms.security.SSO.domain.GinueSSOVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class GinueSSOServiceImpl extends AbstractServiceImpl implements GinueSSOService{

	@Autowired
	private GinueSSODAO ginueSSODAO;

	@Override
	public GinueSSOVO getUserInfoKF(GinueSSOVO ginueSSOVO) throws Exception {
		return (GinueSSOVO)this.ginueSSODAO.getUserInfoKF(ginueSSOVO);
	}
	
	@Override
	public GinueSSOVO getAdminInfoForGinue(GinueSSOVO ginueSSOVO) throws Exception {
		return (GinueSSOVO)this.ginueSSODAO.getAdminInfoForGinue(ginueSSOVO);
	}

	@Override
	public void insertSSOUser(GinueSSOVO ginueSSOVO) throws Exception {
		this.ginueSSODAO.insertSSOUser(ginueSSOVO);
	}
	@Override
	public void insertSSOAuthority(GinueSSOVO ginueSSOVO) throws Exception {
		this.ginueSSODAO.insertSSOAuthority(ginueSSOVO);
	}

	@Override
	public GinueSSOVO getUserInfoUserSSO(GinueSSOVO ginueSSOVO) throws Exception {
		return (GinueSSOVO)this.ginueSSODAO.getUserInfoUserSSO(ginueSSOVO);
	}

	@Override
	public void updateSSOPassword(GinueSSOVO ginueSSOVO) throws Exception {
		this.ginueSSODAO.updateSSOPassword(ginueSSOVO);
	}

	@Override
	public void updateSSOPasswordNull(GinueSSOVO ginueSSOVO) throws Exception{
		this.ginueSSODAO.updateSSOPasswordNull(ginueSSOVO);
		
	}

	
	/**
	 * 관리자인지 아닌지를 체크해서 insert 및 update를 실시
	 * 관리자일 경우 zuser update, authorities insert
	 * 비관리자일경우 zuser, authorities insert
	 */
	@Override
	public void checkAdminAndInsertOrUpdateZUserAndAuthrority (
			GinueSSOVO ginueSSOVO) throws Exception{
		
		//관리자로 등록되어 있는지를 체크
		if(null != this.ginueSSODAO.getAdminInfoForGinue(ginueSSOVO)){
			//관리자로 등록되어 있다면 
			//1.해당관리자의 비밀번호tmp를 업데이트
			this.ginueSSODAO.updateSSOPassword(ginueSSOVO);
			//2.authority에 ginue권한 추가
			this.ginueSSODAO.insertSSOAuthority(ginueSSOVO);
			
		}else{
			//관리자로 등록되어 있지않다면
			//1.zuser에 user로 등록
			this.ginueSSODAO.insertSSOUser(ginueSSOVO);
			//2.authority에 ginue권한 추가
			this.ginueSSODAO.insertSSOAuthority(ginueSSOVO);
		}
		
	}

	@Override
	public void deleteSSOAuthority(GinueSSOVO ginueSSOVO) throws Exception {
		this.ginueSSODAO.deleteSSOAuthority(ginueSSOVO);
		
	}

	@Override
	public void deleteSSOUser(GinueSSOVO ginueSSOVO) throws Exception {
		this.ginueSSODAO.deleteSSOUser(ginueSSOVO);
		
	}
}


