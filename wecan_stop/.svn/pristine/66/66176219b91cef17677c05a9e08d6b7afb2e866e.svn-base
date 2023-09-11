package com.z5.zcms.admsys.menu.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.menu.domain.ZmenuVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZmenuDAOImpl extends EgovComAbstractDAO implements ZmenuDAO {

	Logger log = Logger.getLogger(this.getClass());

	private final String sqlMapNs = "zmenuDAO.";

    public String insert(ZmenuVo vo) {
        return (String)insert(sqlMapNs+"write", vo);
    }

	public Integer listCount(ZmenuVo vo) {
		return (Integer) super.selectByPk(sqlMapNs+"listCount",vo);
	}

    public void delete(List<Integer> arrDeleteNo){
        delete(sqlMapNs+"delete", arrDeleteNo);
    }

	public void deleteMenuWithSiteno(ZmenuVo vo) {
		delete(sqlMapNs+"deleteMenuWithSiteno", vo);
	}

    public ZmenuVo selectbypk(ZmenuVo vo){
        return (ZmenuVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo);
    }

    public ZmenuVo selectbySitenoAndMenuno(ZmenuVo vo){
        return (ZmenuVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbySitenoAndMenuno", vo);
    }
    public ZmenuVo selectbySitenoAndMenunoForCheck(ZmenuVo vo){
    	return (ZmenuVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbySitenoAndMenunoForCheck", vo);
    }

    public Integer getMaxmenustepBySitenoAndMenutopno(ZmenuVo vo){
    	return (Integer)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getMaxmenustepBySitenoAndMenutopno", vo);
    }

    public Integer getMaxmenustepBySitenoAndMenutopnoAndParentno(ZmenuVo vo){
    	return (Integer)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getMaxmenustepBySitenoAndMenutopnoAndParentno", vo);
    }

    public Integer getMenulevel(ZmenuVo vo){
        return (Integer)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getMenulevel", vo);

    }

    public Integer getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(ZmenuVo vo){
    	return (Integer)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getMenulevel", vo);
    }

    public Integer getMenuparentno(ZmenuVo vo){
    	return (Integer) super.selectByPk(sqlMapNs+"getMenuparentno",vo);
    }

    public Integer getMaxmenunoBySiteno(int siteno){
    	return (Integer) super.selectByPk(sqlMapNs+"getMaxmenunoBySiteno",siteno);
    }

    public void update(ZmenuVo vo){
        update(sqlMapNs+"update", vo);
    }
    public void updateMenuStep(ZmenuVo vo){
    	update(sqlMapNs+"updateMenuStep", vo);
    }

    public void updateApply1(ZmenuVo vo){
        update(sqlMapNs+"updateApply1", vo);
    }

    public void updateApply2(ZmenuVo vo){
        update(sqlMapNs+"updateApply2", vo);
    }

    @SuppressWarnings("unchecked")
    public List<ZmenuVo> selectbysiteno(ZmenuVo vo){
        return (List<ZmenuVo>) super.list(sqlMapNs+"selectbysiteno", vo);
    }

    @SuppressWarnings("unchecked")
	public List<ZmenuVo> getlist(ZmenuVo vo) {
		return (List<ZmenuVo>) super.list(sqlMapNs+"list", vo);
	}
    @SuppressWarnings("unchecked")
    public List<ZmenuVo> getlistdepth(ZmenuVo vo) {
    	return (List<ZmenuVo>) super.list(sqlMapNs+"listdepth", vo);
    }

	@SuppressWarnings("unchecked")
	public List<ZmenuVo> getlistAll(ZmenuVo vo) {
		return (List<ZmenuVo>) super.list(sqlMapNs+"listAll", vo);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getMenunoList(ZmenuVo vo) {
		return (List<Integer>) super.list(sqlMapNs+"getMenunoList", vo);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getMenunoListBySitenoAndMenutopnoAndMenulevel(ZmenuVo vo) {
		return (List<Integer>) super.list(sqlMapNs+"getMenunoListBySitenoAndMenutopnoAndMenulevel", vo);
	}

	public Integer getMaxmenuStepBySitenoAndMenutopnoAndMenulevelAndMenustep(ZmenuVo vo) {
		return (Integer)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getMaxmenuStepBySitenoAndMenutopnoAndMenulevelAndMenustep", vo);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getMenunoListBySitenoAndMenutopnoAndMenulevelAndMenustep(ZmenuVo vo) {
		return (List<Integer>) super.list(sqlMapNs+"getMenunoListBySitenoAndMenutopnoAndMenulevelAndMenustep", vo);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getMenunoListBySitenoAndMenutopnoAndMenulevelAndMenustepAndMenustepMax(ZmenuVo vo) {
		return (List<Integer>) super.list(sqlMapNs+"getMenunoListBySitenoAndMenutopnoAndMenulevelAndMenustepAndMenustepMax", vo);
	}

	public ZmenuVo selectListFromZsiteBySiteno(ZmenuVo vo){
		return (ZmenuVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectListFromZsiteBySiteno", vo);
    }

	@SuppressWarnings("unchecked")
	public List<ZmenuVo> selectSublistFromZmenuBySiteno(ZmenuVo vo){
		return (List<ZmenuVo>) super.list(sqlMapNs+"selectSublistFromZmenuBySiteno", vo);
	}

	public ZmenuVo getMenuValue(ZmenuVo vo){
		return (ZmenuVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getMenuValue", vo);
	}

	@Override
	public String getTitlePath(int menuno) throws Exception {
		return (String) this.getSqlMapClientTemplate().queryForObject(sqlMapNs+ "getTitlePath", menuno);
	}

	@Override
	public ZmenuVo selectbySitenoAndMenunoForServiceImpl(ZmenuVo subconts) {
		return (ZmenuVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbySitenoAndMenunoForServiceImpl", subconts);
	}
	
	/*프로시져 걷어내는 작업=================================================================*/
	
	@Override
	public ZmenuVo menuInfo(ZmenuVo vo){
		return (ZmenuVo) selectByPk(sqlMapNs + "menuInfo", vo);
	}
	
	@Transactional
	public int updateMenu(ZmenuVo vo){
		return update(sqlMapNs + "updateMenu", vo);
	}
	
	@Transactional
	public int updateMenuTopno(ZmenuVo vo){
		return update(sqlMapNs + "updateMenuTopno", vo);
	}
	
	@Override
	public ZmenuVo getMenuStep(ZmenuVo vo){
		return (ZmenuVo) selectByPk(sqlMapNs + "getMenuStep", vo);
	}
	
	@Override
	public List<ZmenuVo> menuNoList(ZmenuVo vo){
		return (List<ZmenuVo>) list(sqlMapNs+"menuNoList", vo);
	}
}
