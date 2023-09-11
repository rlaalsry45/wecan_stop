package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.module.dao.ZBannerDAO;
import com.z5.zcms.admsys.module.dao.ZBannerHisDAO;
import com.z5.zcms.admsys.module.domain.ZBannerHisVo;
import com.z5.zcms.admsys.module.domain.ZBannerVo;
import com.z5.zcms.admsys.module.domain.ZPBannerVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
@Transactional
public class BannerServiceImpl extends AbstractServiceImpl implements BannerService {

	@Autowired
	private ZBannerDAO zBannerDAO;
	
	@Autowired
	private ZBannerHisDAO zBannerHisDAO;
	
	@Transactional
	public void bannerWrite(ZBannerVo zBannerVo) {
		this.zBannerDAO.bannerWrite(zBannerVo);
	}

	public List<ZBannerVo> getBannerList(ZBannerVo zBannerVo) {
		return this.zBannerDAO.list(zBannerVo);
	}

	public int listCount(ZBannerVo zBannerVo) {
		return this.zBannerDAO.listCount(zBannerVo);
	}

	public List<ZBannerHisVo> getBannerHisList(ZBannerVo zBannerVo) {
		return this.zBannerHisDAO.list(zBannerVo);
	}
	@Transactional
	public void bannerHisDelete(ZBannerHisVo zBannerHisVo) {
		this.zBannerHisDAO.delete(zBannerHisVo);
	}
	
	public Object bannerDetail(Object obj) {

		if (obj instanceof ZBannerHisVo) {
			// 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
			return this.zBannerHisDAO.detail((ZBannerHisVo)obj);
		}
		else {
			return this.zBannerDAO.detail((ZBannerVo)obj);
		}
	}
	@Transactional
	public void bannerDelete(List<Integer> arrDeleteNo) {
		// zBanner table 삭제
		this.zBannerDAO.bannerDelete(arrDeleteNo);
		// zBanneruse table 삭제
		this.zBannerDAO.bannerUseDelete(arrDeleteNo);
		this.zBannerHisDAO.bannerHisDelete(arrDeleteNo);
	}
	@Transactional
	public void bannerEdit(ZBannerVo zBannerVo) {
		if ("1".equals(zBannerVo.getHis())){
			// 새로운 히스토리 입력
			this.zBannerHisDAO.insert(zBannerVo);
		}
		// 수정내용 갱신
		this.zBannerDAO.update(zBannerVo);
	}
	
	public List<ZBannerVo> contsList(List<Integer> arrDeleteNo){
		return zBannerDAO.contsList(arrDeleteNo);
	}
	
	public List<ZPBannerVo> plist(ZPBannerVo zPBannerVo){
		return zBannerDAO.plist(zPBannerVo);
	}
	
	public void pbannerUpdate(ZPBannerVo zPBannerVo){
		this.zBannerDAO.pbannerUpdate(zPBannerVo);
	}
	
}
