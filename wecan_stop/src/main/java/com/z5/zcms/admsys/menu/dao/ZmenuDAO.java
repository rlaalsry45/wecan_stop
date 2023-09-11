package com.z5.zcms.admsys.menu.dao;

import java.util.List;

import com.z5.zcms.admsys.menu.domain.ZmenuVo;

public interface ZmenuDAO {
	public String insert(ZmenuVo vo);
    public void update(ZmenuVo vo);
    public void updateMenuStep(ZmenuVo vo);
    public void updateApply1(ZmenuVo vo);
    public void updateApply2(ZmenuVo vo);
    public void delete(List<Integer> arrDeleteNo);
    public void deleteMenuWithSiteno(ZmenuVo vo);
    public ZmenuVo selectbypk(ZmenuVo vo);
    public Integer getMenulevel(ZmenuVo vo);
    public Integer getMenuparentno(ZmenuVo vo);
    public ZmenuVo selectbySitenoAndMenuno(ZmenuVo vo);
    public ZmenuVo selectbySitenoAndMenunoForCheck(ZmenuVo vo);
    public Integer getMaxmenustepBySitenoAndMenutopno(ZmenuVo vo);
    public Integer getMaxmenustepBySitenoAndMenutopnoAndParentno(ZmenuVo vo);
	public Integer getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(ZmenuVo vo);
	public Integer listCount(ZmenuVo vo);
	public Integer getMaxmenunoBySiteno(int siteno);
	public List<ZmenuVo> selectbysiteno(ZmenuVo vo);
	public List<ZmenuVo> getlist(ZmenuVo vo);
	public List<ZmenuVo> getlistdepth(ZmenuVo vo);
	public List<ZmenuVo> getlistAll(ZmenuVo vo);
	public List<Integer> getMenunoList(ZmenuVo vo );
	public List<Integer> getMenunoListBySitenoAndMenutopnoAndMenulevel(ZmenuVo vo );
	public Integer getMaxmenuStepBySitenoAndMenutopnoAndMenulevelAndMenustep(ZmenuVo vo );
	public List<Integer> getMenunoListBySitenoAndMenutopnoAndMenulevelAndMenustep(ZmenuVo vo );
	public List<Integer> getMenunoListBySitenoAndMenutopnoAndMenulevelAndMenustepAndMenustepMax(ZmenuVo vo );
	public ZmenuVo selectListFromZsiteBySiteno(ZmenuVo vo);
	public List<ZmenuVo> selectSublistFromZmenuBySiteno(ZmenuVo vo);
	public ZmenuVo getMenuValue(ZmenuVo vo);
	public String getTitlePath(int menuno) throws Exception;
	public ZmenuVo selectbySitenoAndMenunoForServiceImpl(ZmenuVo subconts);
	
	/*프로시져 걷어내는 작업=================================================================*/
	public ZmenuVo menuInfo(ZmenuVo vo);
	public int updateMenu(ZmenuVo vo);
	public int updateMenuTopno(ZmenuVo vo);
	public ZmenuVo getMenuStep(ZmenuVo vo);
	public List<ZmenuVo> menuNoList(ZmenuVo vo);
}
