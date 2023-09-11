package com.z5.zcms.admsys.schdule.service;

import com.z5.zcms.admsys.schdule.dao.ZSchduleDAOImpl;
import com.z5.zcms.admsys.schdule.domain.ZSchduleVO;
import egovframework.com.cmm.ComDefaultVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZSchduleServiceImpl extends AbstractServiceImpl implements ZSchduleService {

    @Autowired
    private ZSchduleDAOImpl zSchduleDAO;


    /**
     * 부서일정관리조회
     *
     * @param Map(map) - 조회할 정보가 담긴 VO
     * @return List
     */
    public List selectSchdulManageMainList(Map map) throws Exception {
        return (List) zSchduleDAO.selectSchdulManageMainList(map);
    }


    /**
     * 부서일정 목록을 VO(model)형식으로 조회한다.
     *
     * @param deptSchdulManageVO - 조회할 정보가 담긴 VO
     * @return List
     */
    public ZSchduleVO selectSchdulManageDetailVO(ZSchduleVO deptSchdulManageVO) throws Exception {
        return (ZSchduleVO) zSchduleDAO.selectSchdulManageDetailVO(deptSchdulManageVO);
    }

    /**
     * 부서일정 목록을 조회한다.
     *
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return List
     */
    public List selectSchdulManageList(ComDefaultVO searchVO) throws Exception {

        return (List) zSchduleDAO.selectSchdulManageList(searchVO);
    }

    /**
     * 부서일정를(을) 상세조회 한다.
     *
     * @param SchdulManage - 회정정보가 담김 VO
     * @return List
     */
    public List selectSchdulManageDetail(ZSchduleVO deptSchdulManageVO) throws Exception {

        return (List) zSchduleDAO.selectSchdulManageDetail(deptSchdulManageVO);
    }

    /**
     * 부서일정를(을) 목록 전체 건수를(을) 조회한다.
     *
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return int
     */
    public int selectSchdulManageListCnt(ComDefaultVO searchVO) throws Exception {

        return (Integer) zSchduleDAO.selectSchdulManageListCnt(searchVO);
    }

    /**
     * 부서일정를(을) 등록한다.
     *
     * @param searchVO - 조회할 정보가 담긴 VO
     */
    public void insertSchdulManage(ZSchduleVO deptSchdulManageVO) throws Exception {
        //  		String sMakeId = idgenService.getNextStringId();
        //  		deptSchdulManageVO.setSchdulId(sMakeId);

        zSchduleDAO.insertSchdulManage(deptSchdulManageVO);
    }

    /**
     * 부서일정를(을) 수정한다.
     *
     * @param searchVO - 조회할 정보가 담긴 VO
     */
    public void updateSchdulManage(ZSchduleVO deptSchdulManageVO) throws Exception {
        zSchduleDAO.updateSchdulManage(deptSchdulManageVO);
    }

    /**
     * 부서일정를(을) 삭제한다.
     *
     * @param searchVO - 조회할 정보가 담긴 VO
     */
    public void deleteSchdulManage(ZSchduleVO deptSchdulManageVO) throws Exception {
        zSchduleDAO.deleteSchdulManage(deptSchdulManageVO);

    }

    @Override
    public List selectSchdulManageRetrieve(Map map) throws Exception {
        return (List) zSchduleDAO.selectSchdulManageRetrieve(map);

    }


    public List selectCalendarManageList(ZSchduleVO zSchduleVO) {
        // TODO Auto-generated method stub
        return (List) zSchduleDAO.selectCalendarManageList(zSchduleVO);
    }


    public Integer selectCalendarManageListCnt(ZSchduleVO zSchduleVO) {
        return (Integer) zSchduleDAO.selectCalendarManageListCnt(zSchduleVO);
    }


    public ZSchduleVO selectCalendarManage(ZSchduleVO zSchduleVO) throws Exception {
        return (ZSchduleVO) zSchduleDAO.selectCalendarManage(zSchduleVO);
    }


    public void setCalendarManage(ZSchduleVO zSchduleVO) {
        zSchduleDAO.setCalendarManage(zSchduleVO);
    }


    public void insertCalendarManage(ZSchduleVO zSchduleVO) {
        zSchduleDAO.insertCalendarManage(zSchduleVO);
    }


    public ZSchduleVO selectbypk(Map commandMap) {
        return zSchduleDAO.selectbypk(commandMap);
    }


    public void deletecalendar(ZSchduleVO zschduleVO) {
        zSchduleDAO.deletecalendar(zschduleVO);
    }


    public void deleteAllSchdul(ZSchduleVO zschduleVO) {
        zSchduleDAO.deleteAllSchdul(zschduleVO);
    }


    public List<ZSchduleVO> calendarnolist(int boardno) {
        return zSchduleDAO.calendarnolist(boardno);
    }


    public List<ZSchduleVO> getdateterm(ZSchduleVO zSchduleVO) {
        // TODO Auto-generated method stub
        return (List<ZSchduleVO>) zSchduleDAO.getdateterm(zSchduleVO);
    }


    public void updateSchdulmanage(ZSchduleVO zSchduleVO) {
        zSchduleDAO.updateSchdulmanage(zSchduleVO);
    }


    public void deleteinterdata(ZSchduleVO zSchduleVO) {
        zSchduleDAO.deleteinterdata(zSchduleVO);
    }


    public int schdulcnt(ZSchduleVO zSchduleVO) {
        return zSchduleDAO.schdulcnt(zSchduleVO);
    }

}
