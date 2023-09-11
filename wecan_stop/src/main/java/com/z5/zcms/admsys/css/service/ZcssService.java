package com.z5.zcms.admsys.css.service;

import java.util.List;

import com.z5.zcms.admsys.css.domain.ZcssVo;

public interface ZcssService {

	void insert(ZcssVo vo) throws Exception;
    void update(ZcssVo vo) throws Exception;
    void delete(List<Integer> arrDeleteNo) throws Exception;
    ZcssVo selectbypk(ZcssVo vo) throws Exception;
    public Integer listCount(ZcssVo vo);
	List<ZcssVo> getList(ZcssVo vo);
	List<ZcssVo> getListAll(ZcssVo vo);
	List<ZcssVo> getListAllForUpdate(ZcssVo zcssVo) throws Exception;
}
