package com.z5.zcms.admsys.authority.dao;

import java.util.List;

import com.z5.zcms.admsys.authority.domain.ZAuthHierachyVO;

public interface ZAuthHierachyDAO {

	public Integer authListCount(ZAuthHierachyVO zAuthHierachyVO);

	public List<ZAuthHierachyVO> getAuthList(ZAuthHierachyVO zAuthHierachyVO);

	public void authInsert(ZAuthHierachyVO zAuthHierachyVO);

	public void deleteAuth(List<Integer> authno) throws Exception;

	public List<ZAuthHierachyVO> delCheck(List<Integer> authno);

	public Integer authduplicationch(ZAuthHierachyVO zAuthHierachyVO);
}
