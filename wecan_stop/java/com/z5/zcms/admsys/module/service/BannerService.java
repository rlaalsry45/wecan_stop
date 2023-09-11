package com.z5.zcms.admsys.module.service;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZBannerHisVo;
import com.z5.zcms.admsys.module.domain.ZBannerVo;
import com.z5.zcms.admsys.module.domain.ZPBannerVo;

public interface BannerService {

	/*ZBanner Line*/
	public List<ZBannerVo> getBannerList(ZBannerVo zBannerVo);
	public void bannerWrite(ZBannerVo zBannerVo);
	public int listCount(ZBannerVo zBannerVo);
	public Object bannerDetail(Object obj);
	public void bannerDelete(List<Integer> arrDeleteNo);
	public void bannerEdit(ZBannerVo zBannerVo);
	public List<ZBannerVo> contsList(List<Integer> arrDeleteNo);
	
	/*ZBannerHis Line*/
	public List<ZBannerHisVo> getBannerHisList(ZBannerVo zBannerVo);
	public void bannerHisDelete(ZBannerHisVo zBannerHisVo);
	
	/*pbanner */
	public List<ZPBannerVo> plist(ZPBannerVo zPBannerVo);
	public void pbannerUpdate(ZPBannerVo zPBannerVo);
	
	
}

