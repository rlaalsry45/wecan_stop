package com.z5.zcms.frontsys.front.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.css.domain.ZcssVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.frontsys.front.domain.MenuScoreVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class FrontDAOImpl extends EgovComAbstractDAO implements FrontDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zserviceDAO.";
	
	public ZsiteVo selectZsiteBySitedomain(ZsiteVo vo){
        return (ZsiteVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectZsiteBySitedomain", vo); 
    }

	@SuppressWarnings("unchecked")
	public List<ZcssVo> getListZcssByCssno(ZcssVo vo) {
		return (List<ZcssVo>) super.list(sqlMapNs+"getListZcssByCssno", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZjsVo> getListZjsByJsno(ZjsVo vo) {
		return (List<ZjsVo>) super.list(sqlMapNs+"getListZjsByJsno", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZtplVo> getListZtplByTplno(ZtplVo vo) {
		return (List<ZtplVo>) super.list(sqlMapNs+"getListZtplByTplno", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZmenuVo> getTitleListFromZmenuBySitenoAndMenuno(ZmenuVo vo) {
		return (List<ZmenuVo>) super.list(sqlMapNs+"getTitleListFromZmenuBySitenoAndMenuno", vo);
	}

	@Override
	public void insertMenuScore(MenuScoreVO vo) {
		
		super.insert(sqlMapNs+"insertMenuScore",vo);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ZmenuVo> getlist(ZmenuVo zmenuVo) {
		return (List<ZmenuVo>) super.list(sqlMapNs+"getlist", zmenuVo);
	}

	/**
	 * MethodName : checkMenuScoreDouble
	 * ClassName  : FrontDAO
	 * Comment   : 한페이지에 이미 동일ip로 만족도 조사가 되어있는지 체크
	 * 작성자    : 김문석
	 * 작성일    : 2014. 1. 6. 오전 11:34:02
	 * @see com.z5.zcms.frontsys.front.dao.FrontDAO#checkMenuScoreDouble(com.z5.zcms.frontsys.front.domain.MenuScoreVO)
	 */
	@Override
	public int checkMenuScoreDouble(MenuScoreVO vo) {
		return (Integer) super.selectByPk(sqlMapNs + "checkMenuScoreDouble", vo);
	}
	
	@Override
	public MenuScoreVO getMenuScoreEVT(MenuScoreVO vo) {
		return (MenuScoreVO) super.selectByPk(sqlMapNs + "getMenuScoreEVT", vo);
	}

	@Override
	public String getMenuTitle(ZmenuVo subconts) throws Exception {
		return (String) super.selectByPk(sqlMapNs + "getMenuTitle", subconts);
	}

}
