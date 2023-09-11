package com.z5.zcms.admsys.authority.dao;

import java.util.List;

import com.z5.zcms.admsys.authority.domain.ZAuthHierachyVO;
import com.z5.zcms.admsys.authority.domain.ZAuthoritiesVO;
import com.z5.zcms.admsys.user.domain.ZUserVo;

public interface ZAuthorityDAO {

	public List<ZAuthHierachyVO> getList(ZAuthHierachyVO ZAuthHierachyVO);
	public List<ZAuthoritiesVO> getAuthoritiesByUserid(ZAuthoritiesVO zAuthoritiesVO);
	public void deleteAuthorites(String userid);
	public void addAuthories(ZAuthoritiesVO vo);
	
	public void addZuth_emp(ZUserVo zUserVo);
	public void addZauthorities(ZUserVo zUserVo);
	
	public void deleteAuth_emp(List<Integer> arrDeleteNo);
	
	

}
