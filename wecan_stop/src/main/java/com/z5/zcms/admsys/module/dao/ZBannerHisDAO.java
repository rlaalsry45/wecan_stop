package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZBannerHisVo;
import com.z5.zcms.admsys.module.domain.ZBannerVo;

public interface ZBannerHisDAO {
	public List<ZBannerHisVo> list(ZBannerVo zBannerVo);
	public ZBannerHisVo detail(ZBannerHisVo zBannerHisVo);
	public void insert(ZBannerVo zBannerVo);
	public void delete(ZBannerHisVo zBannerHisVo);
	public void bannerHisDelete(List<Integer> arrDeleteNo);
}
