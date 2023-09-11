package com.z5.zcms.admsys.css.dao;

import java.util.List;
import com.z5.zcms.admsys.css.domain.ZcssHisVo;
import com.z5.zcms.admsys.css.domain.ZcssVo;


public interface ZcssHisDAO {
	public List<ZcssHisVo> getlist(ZcssHisVo vo);
	public String insert(ZcssHisVo vo);
	public ZcssVo selectbypk(ZcssHisVo vo) ;
	public void delete(ZcssHisVo vo);
}
