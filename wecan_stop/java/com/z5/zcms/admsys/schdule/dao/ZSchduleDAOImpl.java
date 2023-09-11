package com.z5.zcms.admsys.schdule.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.schdule.domain.ZSchduleVO;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZSchduleDAOImpl extends EgovComAbstractDAO   {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZSchduleDAO.";
	
	
    /**
	 * 부서일정 목록을 Map(map)형식으로 조회한다. 
	 * @param Map(map) - 조회할 정보가 담긴 VO
	 * @return List
	 * @exception Exception
	 */
	public List selectSchdulManageMainList(Map map) throws Exception{
		 return  (List)super.list(sqlMapNs+"selectSchdulManageMainList", map);
	}
	
    /**
	 * 부서일정 목록을 Map(map)형식으로 조회한다. 
	 * @param Map(map) - 조회할 정보가 담긴 VO
	 * @return List
	 * @exception Exception
	 */
	public List selectSchdulManageRetrieve(Map vo) throws Exception{
		 return  (List)super.list(sqlMapNs+"selectSchdulManageRetrieve", vo);
	}
	
	
    /**
	 * 부서일정 목록을 VO(model)형식으로 조회한다. 
	 * @param deptSchdulManageVO - 조회할 정보가 담긴 VO
	 * @return ZSchduleVO
	 * @exception Exception
	 */
	public ZSchduleVO selectSchdulManageDetailVO(ZSchduleVO deptSchdulManageVO) throws Exception{
		return (ZSchduleVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectSchdulManageDetailVO", deptSchdulManageVO);
	}
	
    /**
	 * 부서일정 목록을 조회한다. 
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return List
	 * @exception Exception
	 */
	public List selectSchdulManageList(ComDefaultVO searchVO) throws Exception{
		return (List)super.list(sqlMapNs+"selectSchdulManage", searchVO);
	}
	
    /**
	 * 부서일정를(을) 상세조회 한다.
	 * @param deptSchdulManageVO - 부서일정 정보 담김 VO
	 * @return List
	 * @exception Exception
	 */
	public List selectSchdulManageDetail(ZSchduleVO deptSchdulManageVO) throws Exception{
		return (List)super.list(sqlMapNs+"selectSchdulManageDetail", deptSchdulManageVO);
	}

    /**
	 * 부서일정를(을) 목록 전체 건수를(을) 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return int
	 * @exception Exception
	 */
	public int selectSchdulManageListCnt(ComDefaultVO searchVO) throws Exception{
		return (Integer)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectSchdulManageCnt", searchVO);
	}
	
    /**
	 * 부서일정를(을) 등록한다.
	 * @param qdeptSchdulManageVO - 부서일정 정보 담김 VO
	 * @exception Exception
	 */
	public void insertSchdulManage(ZSchduleVO deptSchdulManageVO) throws Exception{
		insert(sqlMapNs+"insertSchdulManage", deptSchdulManageVO);
	}

    /**
	 * 부서일정를(을) 수정한다.
	 * @param deptSchdulManageVO - 부서일정 정보 담김 VO 
	 * @exception Exception
	 */
	public void updateSchdulManage(ZSchduleVO deptSchdulManageVO) throws Exception{
		insert(sqlMapNs+"updateSchdulManage", deptSchdulManageVO);
	}
	
    /**
	 * 부서일정를(을) 삭제한다.
	 * @param deptSchdulManageVO - 부서일정 정보 담김 VO
	 * @exception Exception
	 */ 
	public void deleteSchdulManage(ZSchduleVO deptSchdulManageVO) throws Exception{
		 
		delete(sqlMapNs+"deleteSchdulManage", deptSchdulManageVO);
	}

	public List selectCalendarManageList(ZSchduleVO zSchduleVO) {
		return (List)super.list(sqlMapNs+"selectCalendarManageList", zSchduleVO);
	}

	public Integer selectCalendarManageListCnt(ZSchduleVO zSchduleVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectCalendarManageListCnt", zSchduleVO);
	}

	public ZSchduleVO selectCalendarManage(ZSchduleVO zSchduleVO) throws Exception{
		return (ZSchduleVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectCalendarManage", zSchduleVO);
	}

	public void setCalendarManage(ZSchduleVO zSchduleVO) {
		update(sqlMapNs+"setCalendarManage", zSchduleVO);
	}

	public void insertCalendarManage(ZSchduleVO zSchduleVO) {
		insert(sqlMapNs+"insertCalendarManage", zSchduleVO);
	}

	public ZSchduleVO selectbypk(Map commandMap) {
		return (ZSchduleVO) getSqlMapClientTemplate().queryForObject(sqlMapNs + "selectbypk", commandMap);
	}

	public void deletecalendar(ZSchduleVO zschduleVO) {
		delete(sqlMapNs+"deletecalendar", zschduleVO);
	}

	public void deleteAllSchdul(ZSchduleVO zschduleVO) {
		delete(sqlMapNs+"deleteAllSchdul", zschduleVO);
	}

	public List<ZSchduleVO> calendarnolist(int boardno) {
		return (List<ZSchduleVO>) super.list(sqlMapNs+"calendarnolist", boardno);
	}

	public List<ZSchduleVO> getdateterm(ZSchduleVO zSchduleVO) {
		// TODO Auto-generated method stub
		return (List<ZSchduleVO>) super.list(sqlMapNs+"getdateterm", zSchduleVO);
	}

	public void updateSchdulmanage(ZSchduleVO zSchduleVO) {
		update(sqlMapNs+"updateSchdulmanage", zSchduleVO);
	}

	public void deleteinterdata(ZSchduleVO zSchduleVO) {
		delete(sqlMapNs+"deleteinterdata", zSchduleVO);
	}

	public int schdulcnt(ZSchduleVO zSchduleVO) {
		return (Integer) selectByPk(sqlMapNs + "schdulcnt", zSchduleVO);
	}
 
}
