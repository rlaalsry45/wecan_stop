package com.z5.zcms.admsys.authority.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.z5.zcms.admsys.authority.dao.ZAuthorityDAO;
import com.z5.zcms.admsys.authority.domain.ZAuthHierachyVO;
import com.z5.zcms.admsys.authority.domain.ZAuthorities;
import com.z5.zcms.admsys.authority.domain.ZAuthoritiesVO;
import com.z5.zcms.admsys.user.domain.ZUserVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;


@Transactional
@Service
public class ZAuthorityServiceImpl  extends AbstractServiceImpl implements ZAuthorityService{
	@Autowired
    private ZAuthorityDAO zAuthorityDAO;

	@Override
	public List<ZAuthHierachyVO> getList(ZAuthHierachyVO zAuthHierachyVO) {
		return this.zAuthorityDAO.getList(zAuthHierachyVO);
	}

	@Override
	public List<ZAuthoritiesVO> getAuthoritiesByUserid(ZAuthoritiesVO zAuthoritiesVO) {
		return this.zAuthorityDAO.getAuthoritiesByUserid(zAuthoritiesVO);
	}

	/**
	 * (non-Javadoc)
	 * 김문석
	 * @see com.z5.zcms.admsys.authority.service.ZAuthorityService#setAuthorities(java.lang.String, java.lang.String[], boolean)
	 * 기존의 관리자에게 권한을 부여하거나 새로운 관리자를 등록하면서 권한을 부여한다.
	 * isAddAdmin :true-> 기존관리자 권한 관리
	 *            :false -> 새로운 관리자에게 권한등록(기존권한이 없기 때문에 기존 권한삭제 로직을 실시하지 않는다)
	 */
	@Override
	public void setAuthorities(String userid, String[] authno, boolean isChangeAuth) {
		//권한 삭제
		if(isChangeAuth){
			//this.zAuthorityDAO.deleteAuthorites(userid);
		}
		
		//권한 입력
		if(authno !=null){//권한을 모두 삭제했을 경우 입력할 필요가 없다.
			ZAuthoritiesVO vo = new ZAuthoritiesVO();
			vo.setUserid(userid);
			for(int i=0;authno.length>i;i++){
				vo.setAuthno(authno[i]);
				this.zAuthorityDAO.addAuthories(vo);
			}
		}
		
		
	}

	@Override
	public void addZauthorities(ZUserVo zUserVo) {
		this.zAuthorityDAO.addZauthorities(zUserVo);	
	}

}