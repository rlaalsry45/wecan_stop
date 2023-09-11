package com.z5.zcms.admsys.authority.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.authority.domain.ZAuthHierachyVO;
import com.z5.zcms.admsys.authority.domain.ZAuthoritiesVO;
import com.z5.zcms.admsys.user.domain.ZUserVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class zAuthorityDAOImpl  extends EgovComAbstractDAO implements ZAuthorityDAO{

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZAuthority.";
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ZAuthHierachyVO> getList(ZAuthHierachyVO ZAuthHierachyVO) {
		return (List<com.z5.zcms.admsys.authority.domain.ZAuthHierachyVO>) super.list(sqlMapNs+"getList", ZAuthHierachyVO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ZAuthoritiesVO> getAuthoritiesByUserid(ZAuthoritiesVO zAuthoritiesVO) {
		return (List<ZAuthoritiesVO>) super.list(sqlMapNs+"getAuthoritiesByUserid", zAuthoritiesVO);
	}

	@Override
	public void deleteAuthorites(String userid) {
		delete(sqlMapNs+"deleteAuthorites", userid);
	}

	@Override
	public void addAuthories(ZAuthoritiesVO vo) {
		insert(sqlMapNs+"addAuthories", vo);
	}

	@Override
	public void addZuth_emp(ZUserVo zUserVo) {
		insert(sqlMapNs + "addZuth_emp",  zUserVo);
		
	}
	@Override
	public void addZauthorities(ZUserVo zUserVo) {
		insert(sqlMapNs + "addZauthorities",  zUserVo);
		
	}	
	
	public void deleteAuth_emp(List<Integer> arrDeleteNo){
        delete(sqlMapNs+"deleteAuth_emp", arrDeleteNo);
    }

}
