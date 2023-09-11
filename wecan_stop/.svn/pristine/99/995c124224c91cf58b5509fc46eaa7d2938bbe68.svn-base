package com.z5.zcms.admsys.authority.service;

import java.util.List;

import com.z5.zcms.admsys.authority.domain.ZAuthHierachyVO;
import com.z5.zcms.admsys.authority.domain.ZAuthoritiesVO;
import com.z5.zcms.admsys.user.domain.ZUserVo;

public interface ZAuthorityService {

	List<ZAuthHierachyVO> getList(ZAuthHierachyVO zAuthHierachyVO) ;
	List<ZAuthoritiesVO> getAuthoritiesByUserid(ZAuthoritiesVO zAuthoritiesVO);
	void setAuthorities(String userid, String[] authno, boolean isChangeAuth);
	
	public void addZauthorities(ZUserVo zUserVo);
}
