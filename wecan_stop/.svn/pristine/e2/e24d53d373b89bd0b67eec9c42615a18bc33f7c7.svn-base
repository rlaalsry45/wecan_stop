package com.z5.zcms.admsys.board.dao;

import com.z5.zcms.admsys.board.domain.*;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FrontBoardDAOImpl extends EgovComAbstractDAO implements FrontBoardDAO {

    private final String sqlMapNs = "FrontBoard.";
    Logger log = Logger.getLogger(this.getClass());

    @Override
    public int pwprove(FrontBoardVo frontBoardVo) {
        return (Integer) selectByPk(sqlMapNs + "pwprove", frontBoardVo);
    }

    public ZBoardVo config(ZBoardVo zBoardVo) {
        return (ZBoardVo) selectByPk(sqlMapNs + "config", zBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<ZBoardVo> getAllBoard(ZBoardVo zBoardVo) {
        return (List<ZBoardVo>) list(sqlMapNs + "getAllBoard", zBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<FrontBoardVo> listNotice(ZBoardVo zBoardVo) {
        return (List<FrontBoardVo>) list(sqlMapNs + "listNotice", zBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<FrontBoardVo> listAll(ZBoardVo zBoardVo) {
        return (List<FrontBoardVo>) list(sqlMapNs + "listAll", zBoardVo);
    }

    public int noticeCount(ZBoardVo zBoardVo) {
        return (Integer) selectByPk(sqlMapNs + "noticeCount", zBoardVo);
    }

    public int listCount(ZBoardVo zBoardVo) {
        return (Integer) selectByPk(sqlMapNs + "listCount", zBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<FrontBoardVo> list(ZBoardVo zBoardVo) {
        return (List<FrontBoardVo>) list(sqlMapNs + "list", zBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<ZCateVo> cateListAll(ZBoardVo zBoardVo) {
        return (List<ZCateVo>) list(sqlMapNs + "cateListAll", zBoardVo);
    }

    public FrontBoardVo secrect(FrontBoardVo frontBoardVo) {
        return (FrontBoardVo) selectByPk(sqlMapNs + "secrect", frontBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<ZCateVo> cateTopList(ZBoardVo zBoardVo) {
        return (List<ZCateVo>) list(sqlMapNs + "cateTopList", zBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<ZCateVo> cateSubList(FrontBoardVo frontBoardVo) {
        return (List<ZCateVo>) list(sqlMapNs + "cateSubList", frontBoardVo);
    }

    public int cateDepth(ZBoardVo zBoardVo) {
        return (Integer) selectByPk(sqlMapNs + "cateDepth", zBoardVo);
    }

    public FrontBoardVo view(FrontBoardVo frontBoardVo) {
        update(sqlMapNs + "updatehit", frontBoardVo); // by superbolt for mysql

        return (FrontBoardVo) selectByPk(sqlMapNs + "view", frontBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<FrontBoardVo> comment(FrontBoardVo frontBoardVo) {
        return (List<FrontBoardVo>) list(sqlMapNs + "comment", frontBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<ZFileVo> attaches(FrontBoardVo frontBoardVo) {
        return (List<ZFileVo>) list(sqlMapNs + "attaches", frontBoardVo);
    }
    

    public ZBannedVo bandWord() {
        return (ZBannedVo) selectByPk(sqlMapNs + "bandWord", "");
    }

    public void writeComment(FrontBoardVo frontBoardVo) {
        insert(sqlMapNs + "writeComment", frontBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<ZFileVo> delete(FrontBoardVo frontBoardVo) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bbsno", frontBoardVo.getBbsno());
        paramMap.put("boardno", frontBoardVo.getBoardno());
        paramMap.put("tblname", frontBoardVo.getTblname());

        return (List<ZFileVo>) list(sqlMapNs + "delete", paramMap);
    }

    public ZFileVo attach(FrontBoardVo frontBoardVo) {

        update(sqlMapNs + "attach1", frontBoardVo);

        return (ZFileVo) selectByPk(sqlMapNs + "attach2", frontBoardVo);
    }

    public void deleteComment(FrontBoardVo frontBoardVo) {
        delete(sqlMapNs + "deleteComment", frontBoardVo);
    }

    public FrontBoardVo pwComment(FrontBoardVo frontBoardVo) {
        return (FrontBoardVo) selectByPk(sqlMapNs + "pwComment", frontBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<ZCateVo> cateList(FrontBoardVo frontBoardVo) {
        return (List<ZCateVo>) list(sqlMapNs + "cateList", frontBoardVo);
    }

    public int saveBoard(FrontBoardVo frontBoardVo) {
        selectByPk(sqlMapNs + "saveBoard", frontBoardVo);
        return frontBoardVo.getMaxno();
    }

    public String deleteAttach(FrontBoardVo frontBoardVo) {
        delete(sqlMapNs + "deleteAttach", frontBoardVo);
        return frontBoardVo.getFsave();
    }

    public void approve(FrontBoardVo frontBoardVo) {
        update(sqlMapNs + "approve", frontBoardVo);
    }

    @SuppressWarnings("unchecked")
    public List<String> getApp(ZBoardVo zBoardVo) {
        return (List<String>) list(sqlMapNs + "getApp", zBoardVo);
    }

    /**
     * MethodName : getBoardRow ClassName  : FrontBoardDAO Comment   : 작성자    : 김문석 작성일    : 2014. 1. 20. 오후 4:12:15
     *
     * @see com.z5.zcms.admsys.board.dao.FrontBoardDAO#getBoardRow(com.z5.zcms.admsys.board.domain.FrontBoardVo)
     */
    @Override
    public FrontBoardVo getBoardRow(FrontBoardVo frontBoardVo) {
        return (FrontBoardVo) selectByPk(sqlMapNs + "getBoardRow", frontBoardVo);
    }

    /*프로시져 걷어내는 작업=================================================================*/
    @Override
    public Integer insertBbs(FrontBoardVo frontBoardVo) {
        return (Integer) insert(sqlMapNs + "insertBbs", frontBoardVo);
    }

    @Override
    public Integer selectBbsno(String seqname) {
        return (Integer) selectByPk(sqlMapNs + "selectBbsno", seqname);
    }

    @Override
    public void updateBbstopno(FrontBoardVo frontBoardVo) {
        update(sqlMapNs + "updateBbstopno", frontBoardVo);
    }

    @Override
    public void insertBbsFile(ZFileVo file) {
        insert(sqlMapNs + "insertBbsFile", file);
    }

    @Override
    public void updateBbs(FrontBoardVo frontBoardVo) {
        update(sqlMapNs + "updateBbs", frontBoardVo);
    }

    @Override
    public void updateBbsFile(ZFileVo file) {
        update(sqlMapNs + "updateBbsFile", file);
    }

    @Override
    public FrontBoardVo getBbsparentVO(FrontBoardVo frontBoardVo) {
        return (FrontBoardVo) selectByPk(sqlMapNs + "getBbsparentVO", frontBoardVo);
    }

    @Override
    public void updateBbsstep(FrontBoardVo boardTmp) {
        update(sqlMapNs + "updateBbsstep", boardTmp);

    }

    @Override
    public void insertBbsReply(FrontBoardVo frontBoardVo) {
        insert(sqlMapNs + "insertBbsReply", frontBoardVo);
    }

    @Override
    public Integer getMaxBbsStep(FrontBoardVo frontBoardVo) {
        return (Integer) selectByPk(sqlMapNs + "getMaxBbsStep", frontBoardVo);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ZFileVo> selectFileList(FrontBoardVo frontBoardVo) {
        return (List<ZFileVo>) list(sqlMapNs + "selectFileList", frontBoardVo);
    }

    @Override
    public void deleteBbs(FrontBoardVo frontBoardVo) {
        delete(sqlMapNs + "deleteBbs", frontBoardVo);
    }

    @Override
    public void deletetFileList(FrontBoardVo frontBoardVo) {
        delete(sqlMapNs + "deletetFileList", frontBoardVo);
    }

    /*프로시져 걷어내는 작업=================================================================*/

    public void saveBoardInfo(ZBoardInfoVo zBoardInfoVo) {
        insert(sqlMapNs + "saveBoardInfo", zBoardInfoVo);
    }

    public int InfolistCount(ZBoardInfoVo zBoardInfoVo) {
        return (Integer) selectByPk(sqlMapNs + "InfolistCount", zBoardInfoVo);
    }

    public List<ZBoardInfoVo> InfolistAll(ZBoardInfoVo zBoardInfoVo) {
        return (List<ZBoardInfoVo>) list(sqlMapNs + "InfolistAll", zBoardInfoVo);
    }

    @SuppressWarnings("unchecked")
    public List<ZBoardInfoVo> Infolist(ZBoardInfoVo zBoardInfoVo) {
        return (List<ZBoardInfoVo>) list(sqlMapNs + "Infolist", zBoardInfoVo);
    }

    @Override
    public void deleteBoardInfo(ZBoardInfoVo zBoardInfoVo) {
        delete(sqlMapNs + "deleteBoardInfo", zBoardInfoVo);
    }


}
