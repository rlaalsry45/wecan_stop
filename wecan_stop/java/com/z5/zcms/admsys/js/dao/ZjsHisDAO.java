package com.z5.zcms.admsys.js.dao;

import java.util.List;
import com.z5.zcms.admsys.js.domain.ZjsHisVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;


public interface ZjsHisDAO {
	public List<ZjsHisVo> getlist(ZjsHisVo vo);
	public String insert(ZjsHisVo vo);
	public ZjsVo selectbypk(ZjsHisVo vo) ;
	public void delete(ZjsHisVo vo);
}
