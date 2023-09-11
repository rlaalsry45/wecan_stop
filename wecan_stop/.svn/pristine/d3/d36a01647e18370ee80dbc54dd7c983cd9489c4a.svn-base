package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZBannerVo;
import com.z5.zcms.admsys.module.domain.ZPBannerVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZBannerDAOImpl extends EgovComAbstractDAO implements ZBannerDAO {

	//@Autowired
	//private ZBannerVo zBannerVo;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZBanner.";

	public void  bannerWrite(ZBannerVo zBannerVo) {
		insert(sqlMapNs + "bannerWrite", zBannerVo);
	}

	@SuppressWarnings("unchecked")
	public List<ZBannerVo> list(ZBannerVo zBannerVo) {
		return (List<ZBannerVo>) list(sqlMapNs + "list", zBannerVo);
	}

	public int listCount(ZBannerVo zBannerVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", zBannerVo);
	}

	public ZBannerVo detail(ZBannerVo zBannerVo) {
		return (ZBannerVo)selectByPk(sqlMapNs + "getDetailInfo", zBannerVo);
	}

	public void  bannerDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "bannerDelete", arrDeleteNo);
	}

	public void  bannerUseDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "bannerUseDelete", arrDeleteNo);
	}

	public ZBannerVo getBanner() {
		return new ZBannerVo();
	}

	public void update(ZBannerVo zBannerVo)
	{
		update(sqlMapNs + "update", zBannerVo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZBannerVo> contsList(List<Integer> arrDeleteNo){
		return (List<ZBannerVo>) list(sqlMapNs + "contsList", arrDeleteNo);
	}

	@SuppressWarnings("unchecked")
	public List<ZPBannerVo> plist(ZPBannerVo zPBannerVo){
		return (List<ZPBannerVo>) list(sqlMapNs + "plist", zPBannerVo);
	}
	
	public void pbannerUpdate(ZPBannerVo zBannerVo)
	{
		update(sqlMapNs + "pbannerUpdate", zBannerVo);
	}

}