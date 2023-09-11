package com.z5.zcms.frontsys.front.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z5.zcms.admsys.css.domain.ZcssVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;

public interface FrontMainService {

	ZsiteVo selectZsiteBySitedomain(ZsiteVo vo) throws Exception;
	List<ZcssVo> getListZcssByCssno(ZcssVo vo);
	List<ZjsVo> getListZjsByJsno(ZjsVo vo);
	List<ZtplVo> getListZtplByTplno(ZtplVo vo);
	List<ZmenuVo> getTitleListFromZmenuBySitenoAndMenuno(ZmenuVo vo);
	/*void insert(ZcssVo vo) throws Exception;
    void update(ZcssVo vo) throws Exception;
    void delete(List<Integer> arrDeleteNo) throws Exception;
    public Integer listCount(ZcssVo vo);
	List<ZcssVo> getList(ZcssVo vo);
	List<ZcssVo> getListAll(ZcssVo vo);*/
	String frontView(HttpServletRequest request,
			HttpServletResponse response, String siteDivision) throws Exception;

}
