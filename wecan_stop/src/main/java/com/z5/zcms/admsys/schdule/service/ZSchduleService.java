package com.z5.zcms.admsys.schdule.service;

import java.util.List;


import java.util.Map;

import com.z5.zcms.admsys.schdule.domain.ZSchduleVO;

import egovframework.com.cmm.ComDefaultVO;

public interface ZSchduleService {

	/**
	 * 메인페이지/부서일정관리조회 
	 * @param map
	 * @return List
	 * @throws Exception
	 */
	public List selectSchdulManageMainList(Map map) throws Exception;
	
	/**
	 * 부서일정 목록을 조회한다.
	 * @param map
	 * @return List
	 * @throws Exception
	 */
	public List selectSchdulManageRetrieve(Map map) throws Exception;
	
	/**
	 * 부서일정 목록을 VO(model)형식으로 조회한다. 
	 * @param deptSchdulManageVO
	 * @return List
	 * @throws Exception
	 */
	public ZSchduleVO selectSchdulManageDetailVO(ZSchduleVO deptSchdulManageVO) throws Exception;

	/**
	 * 부서일정 목록을 조회한다. 
	 * @param searchVO
	 * @return List
	 * @throws Exception
	 */
	public List selectSchdulManageList(ComDefaultVO searchVO) throws Exception;
	
	/**
	 *  부서일정를(을) 상세조회 한다.
	 * @param deptSchdulManageVO
	 * @return List
	 * @throws Exception
	 */
	public List selectSchdulManageDetail(ZSchduleVO deptSchdulManageVO) throws Exception;
	
	/**
	 * 부서일정를(을) 목록 전체 건수를(을) 조회한다.
	 * @param searchVO
	 * @return int
	 * @throws Exception
	 */
	public int selectSchdulManageListCnt(ComDefaultVO searchVO) throws Exception;
	
	/**
	 * 부서일정을 등록한다.
	 * @param deptSchdulManageVO
	 * @throws Exception
	 */
	void  insertSchdulManage(ZSchduleVO deptSchdulManageVO) throws Exception;
	
	/**
	 * 부서일정를(을) 수정한다.
	 * @param deptSchdulManageVO
	 * @throws Exception
	 */
	void  updateSchdulManage(ZSchduleVO deptSchdulManageVO) throws Exception;
	
	/**
	 * 부서일정를(을) 삭제한다.
	 * @param deptSchdulManageVO
	 * @throws Exception
	 */
	void  deleteSchdulManage(ZSchduleVO deptSchdulManageVO) throws Exception;
}
