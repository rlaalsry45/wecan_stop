package com.z5.zcms.admsys.tpl.service;

import java.util.List;

import com.z5.zcms.admsys.tpl.domain.ZtplVo;



public interface ZtplService {
	
    void insert(ZtplVo vo) throws Exception;
    void update(ZtplVo vo) throws Exception;
    void delete(List<Integer> arrDeleteTplNo) throws Exception;
    ZtplVo selectbypk(ZtplVo vo) throws Exception;
    public Integer listCount(ZtplVo vo);
	List<ZtplVo> getList(ZtplVo vo);
	List<ZtplVo> getListAll(ZtplVo vo);
	ZtplVo selectbyTitleAndPosition(ZtplVo ztplVo);
    
}
