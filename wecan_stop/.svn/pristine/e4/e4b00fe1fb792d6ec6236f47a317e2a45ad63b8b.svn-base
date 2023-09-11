package com.z5.zcms.admsys.board.service;

import com.z5.zcms.admsys.board.dao.FrontBoardDAO;
import com.z5.zcms.admsys.board.domain.FrontBoardVo;
import com.z5.zcms.admsys.board.domain.ZBannedVo;
import com.z5.zcms.admsys.board.domain.ZBoardInfoVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.domain.ZCateVo;
import com.z5.zcms.admsys.board.domain.ZFileVo;
import com.z5.zcms.frontsys.front.dao.FrontApplicationDAO;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class FrontBoardServiceImpl extends AbstractServiceImpl implements FrontBoardService {

    @Autowired
    private FrontBoardDAO frontBoardDAO;
    
    @Autowired
    private FrontApplicationDAO frontApplicationDAO;

    @Override
    public int pwprove(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.pwprove(frontBoardVo);
    }

    public ZBoardVo config(ZBoardVo zBoardVo) {
        return frontBoardDAO.config(zBoardVo);
    }

    public List<ZBoardVo> getAllBoard(ZBoardVo zBoardVo) {
        return frontBoardDAO.getAllBoard(zBoardVo);
    }

    public List<FrontBoardVo> listNotice(ZBoardVo zBoardVo) {
        return frontBoardDAO.listNotice(zBoardVo);
    }

    public List<FrontBoardVo> listAll(ZBoardVo zBoardVo) {
        return frontBoardDAO.listAll(zBoardVo);
    }

    public int listCount(ZBoardVo zBoardVo) {
        return frontBoardDAO.listCount(zBoardVo);
    }

    public int noticeCount(ZBoardVo zBoardVo) {
        return frontBoardDAO.noticeCount(zBoardVo);
    }

    public List<FrontBoardVo> list(ZBoardVo zBoardVo) {
        return frontBoardDAO.list(zBoardVo);
    }

    public List<ZCateVo> cateListAll(ZBoardVo zBoardVo) {
        return frontBoardDAO.cateListAll(zBoardVo);
    }

    public FrontBoardVo view(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.view(frontBoardVo);
    }

    public List<FrontBoardVo> comment(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.comment(frontBoardVo);
    }

    public List<ZFileVo> attaches(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.attaches(frontBoardVo);
    }

    public ZBannedVo bandWord() {
        return frontBoardDAO.bandWord();
    }

    public void writeComment(FrontBoardVo frontBoardVo) {
        frontBoardDAO.writeComment(frontBoardVo);
    }

    public FrontBoardVo secrect(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.secrect(frontBoardVo);
    }

    public List<ZFileVo> delete(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.delete(frontBoardVo);
    }

    public ZFileVo attach(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.attach(frontBoardVo);
    }

    public void deleteComment(FrontBoardVo frontBoardVo) {
        frontBoardDAO.deleteComment(frontBoardVo);
    }

    public int saveBoard(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.saveBoard(frontBoardVo);
    }

    public String deleteAttach(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.deleteAttach(frontBoardVo);
    }

    public FrontBoardVo pwComment(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.pwComment(frontBoardVo);
    }

    public List<ZCateVo> cateTopList(ZBoardVo zBoardVo) {
        return frontBoardDAO.cateTopList(zBoardVo);
    }

    public List<ZCateVo> cateSubList(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.cateSubList(frontBoardVo);
    }

    public int cateDepth(ZBoardVo zBoardVo) {
        return frontBoardDAO.cateDepth(zBoardVo);
    }

    public List<ZCateVo> cateList(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.cateList(frontBoardVo);
    }

    public void approve(FrontBoardVo frontBoardVo) {
        frontBoardDAO.approve(frontBoardVo);
    }

    public List<String> getApp(ZBoardVo zBoardVo) {
        return frontBoardDAO.getApp(zBoardVo);
    }

    /**
     * MethodName : getBoardRow ClassName  : FrontBoardService param   : tblname, bbsno 작성자    : 김문석 작성일    : 2014. 1. 20. 오후 4:11:17
     *
     * @see com.z5.zcms.admsys.board.service.FrontBoardService#getBoardRow(com.z5.zcms.admsys.board.domain.FrontBoardVo)
     */
    @Override
    public FrontBoardVo getBoardRow(FrontBoardVo frontBoardVo) {
        return frontBoardDAO.getBoardRow(frontBoardVo);
    }

    //프로시져를 걷어내는 작업 9i 대응 20141222 김문석========================================================/
    public int saveBoardNew(FrontBoardVo frontBoardVo) {
        int bbsno = -1;
        /*1.insert의 경우*/
        if (frontBoardVo.getAct().equals("write")) {
        	bbsno = (Integer)frontBoardDAO.insertBbs(frontBoardVo);
            //bbsno = frontBoardDAO.selectBbsno(frontBoardVo.getTblname()+"_seq.currval");
            //bbsno = frontBoardDAO.selectBbsno(frontBoardVo.getTblname());
            frontBoardVo.setBbsno(bbsno);
            frontBoardDAO.updateBbstopno(frontBoardVo);
            this.saveFile(frontBoardVo, bbsno);
        }
        /*2.update의 경우*/
        else if (frontBoardVo.getAct().equals("edit")) {
            frontBoardDAO.updateBbs(frontBoardVo);
            //alt 값만 바꾸는 로직이라 사용안함
			/*if(!(frontBoardVo.getFnos()==null || frontBoardVo.getFnos().equals(""))){
				if(!(frontBoardVo.getFalts()==null || frontBoardVo.getFalts().equals(""))){

				}

			}*/
            this.saveFile(frontBoardVo, frontBoardVo.getBbsno());
            bbsno = frontBoardVo.getBbsno();
        } else if (frontBoardVo.getAct().equals("reply")) {
            FrontBoardVo boardTmp = new FrontBoardVo();
            boardTmp = frontBoardDAO.getBbsparentVO(frontBoardVo);
            if (boardTmp != null && boardTmp.getBbstopno() > 0) {
                int maxBbsStep = frontBoardDAO.getMaxBbsStep(frontBoardVo);
                boardTmp.setTblname(frontBoardVo.getTblname());
                boardTmp.setBbsstep(maxBbsStep);
                frontBoardDAO.updateBbsstep(boardTmp);

                frontBoardVo.setBbstopno(boardTmp.getBbstopno());
                frontBoardVo.setBbslevel(boardTmp.getBbslevel());
                frontBoardVo.setBbsstep(boardTmp.getBbsstep());

                frontBoardDAO.insertBbsReply(frontBoardVo);
                bbsno = frontBoardDAO.selectBbsno(frontBoardVo.getTblname() + "_seq.currval");
                frontBoardVo.setBbsno(bbsno);
                frontBoardDAO.updateBbstopno(frontBoardVo);
                this.saveFile(frontBoardVo, bbsno);
            }

        }
        return bbsno;//frontBoardDAO.saveBoard(frontBoardVo);
    }

    private void saveFile(FrontBoardVo frontBoardVo, int bbsno) {
        if (!(frontBoardVo.getBbsfile() == null || frontBoardVo.getBbsfile().equals(""))) {
            String[] zfileList = (frontBoardVo.getBbsfile()).split("\\|");
            for (int i = 0; zfileList.length > i; i++) {
                String[] zfile = zfileList[i].split(",");
                ZFileVo  file  = new ZFileVo();

                file.setForg(zfile[0]);
                file.setFsave(zfile[1]);
                file.setFhit(zfile[2]);
                file.setFalt(zfile[4]);
                file.setFtype(zfile[5]);
                file.setBbsno(bbsno);
                file.setBoardno(frontBoardVo.getBoardno());

                frontBoardDAO.insertBbsFile(file);
            }
        }
    }

    @Override
    public List<ZFileVo> deleteNew(FrontBoardVo frontBoardVo) {
        List<ZFileVo> fileList = frontBoardDAO.selectFileList(frontBoardVo);
        //게시글삭제
        frontBoardDAO.deleteBbs(frontBoardVo);
        //파일 삭제
        frontBoardDAO.deletetFileList(frontBoardVo);

        return fileList;
    }

    public void saveBoardInfo(ZBoardInfoVo zBoardInfoVo) {
        frontBoardDAO.saveBoardInfo(zBoardInfoVo);
    }


    public int InfolistCount(ZBoardInfoVo zBoardInfoVo) {
        return frontBoardDAO.InfolistCount(zBoardInfoVo);
    }

    public List<ZBoardInfoVo> InfolistAll(ZBoardInfoVo zBoardInfoVo) {
        return frontBoardDAO.InfolistAll(zBoardInfoVo);
    }

    public List<ZBoardInfoVo> Infolist(ZBoardInfoVo zBoardInfoVo) {
        return frontBoardDAO.Infolist(zBoardInfoVo);
    }

    @Override
    public void deleteBoardInfo(ZBoardInfoVo zBoardInfoVo) {
        frontBoardDAO.deleteBoardInfo(zBoardInfoVo);
    }

	@Override
	public List<FrontApplicationVo> retrieveApplicationList(FrontApplicationVo reqVo) {
		return frontApplicationDAO.retrieveApplicationList(reqVo);
	}
}