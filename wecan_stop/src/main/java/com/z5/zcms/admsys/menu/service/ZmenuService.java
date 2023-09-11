package com.z5.zcms.admsys.menu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.util.DataTable;

public interface ZmenuService {

	/*void insert(ZmenuVo vo) throws Exception;
    void update(ZmenuVo vo) throws Exception;
    void updateMenuStep(ZmenuVo vo) throws Exception;
    void updateApply1(ZmenuVo vo) throws Exception;
    void updateApply2(ZmenuVo vo) throws Exception;
    void delete(List<Integer> arrDeleteNo) throws Exception;
    void deleteMenuWithSiteno(ZmenuVo vo);
    ZmenuVo selectbypk(ZmenuVo vo) throws Exception;
    Integer getMenuparentno(ZmenuVo vo) throws Exception;
    ZmenuVo selectbySitenoAndMenuno(ZmenuVo vo) throws Exception;
    Integer getMenulevel(ZmenuVo vo) throws Exception;
    Integer getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(ZmenuVo vo) throws Exception;
    Integer getMaxmenunoBySiteno(int siteno) throws Exception;
    public Integer listCount(ZmenuVo vo) throws Exception;
    List<ZmenuVo> selectbysiteno(ZmenuVo vo) throws Exception;
	List<ZmenuVo> getList(ZmenuVo vo) throws Exception;
	List<ZmenuVo> getListdepth(ZmenuVo vo) throws Exception;
	List<ZmenuVo> getListAll(ZmenuVo vo) throws Exception;*/

	ZmenuVo selectbySitenoAndMenuno(ZmenuVo vo) throws Exception;
	String delete(int siteno, String[] tmp);
	Model insert(DataTable input, Model model, HttpServletRequest request);
	Model update(DataTable input, Model model, HttpServletRequest request);
	String preview(DataTable input, Model model, HttpServletRequest request,HttpServletResponse response);
	Model updateView(DataTable input, Model model);
	Model insertView(DataTable input, Model model);
	Model index(ZsiteVo zsiteVo, DataTable input, Model model);
	void orderChange(DataTable input, ZmenuVo zmenuVo);
	Model listView(DataTable input, Model model);
	Model menuPopup(int siteno, Model model) throws Exception;
	String getTitlePath(int menuno) throws Exception;
}
