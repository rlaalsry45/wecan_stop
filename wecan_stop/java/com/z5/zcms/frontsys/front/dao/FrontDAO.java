package com.z5.zcms.frontsys.front.dao;

import java.util.List;

import com.z5.zcms.admsys.css.domain.ZcssVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.frontsys.front.domain.MenuScoreVO;

public interface FrontDAO {
    public ZsiteVo selectZsiteBySitedomain(ZsiteVo vo);

    public List<ZcssVo> getListZcssByCssno(ZcssVo vo);

    public List<ZjsVo> getListZjsByJsno(ZjsVo vo);

    public List<ZtplVo> getListZtplByTplno(ZtplVo vo);

    public List<ZmenuVo> getTitleListFromZmenuBySitenoAndMenuno(ZmenuVo vo);

    /*public String insert(ZcssVo vo);
    public void update(ZcssVo vo);
    public void delete(List<Integer> arrDeleteNo) ;
    public Integer listCount(ZcssVo vo);
    public List<ZcssVo> getlist(ZcssVo vo);
    public List<ZcssVo> getlistAll(ZcssVo vo);*/
    public void insertMenuScore(MenuScoreVO vo);

    public List<ZmenuVo> getlist(ZmenuVo zmenuVo);

    public MenuScoreVO getMenuScoreEVT(MenuScoreVO vo);
    
    public int checkMenuScoreDouble(MenuScoreVO vo);

    public String getMenuTitle(ZmenuVo subconts) throws Exception;
}
