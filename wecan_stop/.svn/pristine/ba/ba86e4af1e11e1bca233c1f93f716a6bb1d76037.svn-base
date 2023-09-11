package com.z5.zcms.util.parsingjsp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.css.domain.ZcssVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import com.z5.zcms.admsys.main.domain.ZmainVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class JspTemplateMakerBatchDAO extends EgovComAbstractDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@SuppressWarnings("unchecked")
	public List<ZtplVo> getlistAll(ZtplVo vo){
		return (List<ZtplVo>) super.list("ztplDAO.listAll", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZmainVo> getlistAll(ZmainVo vo){
		return (List<ZmainVo>) super.list("zmainDAO.listAll", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZmenuVo> getlistAll(ZmenuVo vo){
		return (List<ZmenuVo>) super.list("zmenuDAO.listAll", vo);
	}

	@SuppressWarnings("unchecked")
	public List<ZcssVo> getlistAll(ZcssVo vo) {
		return (List<ZcssVo>) super.list("zcssDAO.listAll", vo);
	}

	@SuppressWarnings("unchecked")
	public List<ZjsVo> getlistAll(ZjsVo vo) {
		return (List<ZjsVo>) super.list("zjsDAO.listAll", vo);
	}

}
