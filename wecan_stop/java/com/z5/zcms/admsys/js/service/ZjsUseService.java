package com.z5.zcms.admsys.js.service;

import java.util.List;

import com.z5.zcms.admsys.js.domain.ZjsUseVo;


public interface ZjsUseService {
		void delete(List<Integer> arrDeleteNo) throws Exception;
		public Integer listCount(ZjsUseVo vo);
		void insert(ZjsUseVo vo) throws Exception;
}
