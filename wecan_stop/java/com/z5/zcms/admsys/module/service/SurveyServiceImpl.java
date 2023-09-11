package com.z5.zcms.admsys.module.service;

import com.z5.zcms.admsys.module.dao.ZSurveyDAO;
import com.z5.zcms.admsys.module.dao.ZSurveyHisDAO;
import com.z5.zcms.admsys.module.dao.ZSurveyResultDAO;
import com.z5.zcms.admsys.module.domain.ZSurveyHisVo;
import com.z5.zcms.admsys.module.domain.ZSurveyResultVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.ZPrint;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

import static com.z5.zcms.util.ZPrint.enter;
import static com.z5.zcms.util.ZPrint.print;

@Service
public class SurveyServiceImpl extends AbstractServiceImpl implements SurveyService {

    @Autowired
    private ZSurveyDAO zSurveyDAO;

    @Autowired
    private ZSurveyHisDAO zSurveyHisDAO;

    @Autowired
    private ZSurveyResultDAO zSurveyResultDAO;

    @Transactional
    public void surveyWrite(ZSurveyVo zSurveyVo) {
        this.zSurveyDAO.surveyWrite(zSurveyVo);
    }

    public List<ZSurveyVo> getSurveyList(ZSurveyVo zSurveyVo) {
        return this.zSurveyDAO.list(zSurveyVo);
    }

    public int listCount(ZSurveyVo zSurveyVo) {
        return this.zSurveyDAO.listCount(zSurveyVo);
    }

    public List<ZSurveyHisVo> getSurveyHisList(ZSurveyVo zSurveyVo) {
        return this.zSurveyHisDAO.list(zSurveyVo);
    }

    @Transactional
    public void surveyHisDelete(ZSurveyHisVo zSurveyHisVo) {
        this.zSurveyHisDAO.delete(zSurveyHisVo);
    }

    public Object surveyDetail(Object obj) {

        if (obj instanceof ZSurveyHisVo) {
            // 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
            return this.zSurveyHisDAO.detail((ZSurveyHisVo) obj);
        } else {
            return this.zSurveyDAO.detail((ZSurveyVo) obj);
        }
    }

    @Transactional
    public void surveyDelete(List<Integer> arrDeleteNo) {
        // zSurvey table 삭제
        this.zSurveyDAO.surveyDelete(arrDeleteNo);
        // zSurveyuse table 삭제
        this.zSurveyDAO.surveyUseDelete(arrDeleteNo);
        this.zSurveyHisDAO.surveyHisDelete(arrDeleteNo);
        this.zSurveyResultDAO.surveyResultDelete(arrDeleteNo);
    }

    @Transactional
    public void surveyEdit(ZSurveyVo zSurveyVo) {
        if ("1".equals(zSurveyVo.getHis())) {
            // 새로운 히스토리 입력
            this.zSurveyHisDAO.insert(zSurveyVo);
        }
        // 수정내용 갱신
        this.zSurveyDAO.update(zSurveyVo);
    }

    public Integer listCount(ZSurveyResultVo zSurveyResultVo) {
        return this.zSurveyResultDAO.listCount(zSurveyResultVo);
    }

    public List<ZSurveyResultVo> listSubject(ZSurveyResultVo zSurveyResultVo) {
        return this.zSurveyResultDAO.listSubject(zSurveyResultVo);
    }

    @Transactional
    public Model surveyResultWrite(Model model, DataTable input) {
        System.out.println("들어옴");
        int             surveyno = input.getInt("surveyno");
        int             len      = input.getInt("question");
        ZSurveyResultVo vo       = new ZSurveyResultVo();
        ZPrint.enter();
        ZPrint.print("survey:" + surveyno + " questions:" + len);
        try {
            for (int i = 1; i <= len; i++) {
                if (null == input.getValues("answer" + i)) {
                    input.put("answer" + i, "");
                }
                for (String answer : input.getValues("answer" + i)) {

                    if (answer != null && !answer.equals("")) {
                        vo.setSurveyno(surveyno);
                        vo.setAskno(i);
                        vo.setAnswer(answer);
                        zSurveyResultDAO.surveyResultWrite(vo);
                    }
                }
            }


            zSurveyResultDAO.surveyResultTotalUpdate(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public ZSurveyVo latestSurvey(ZSurveyVo zSurveyVo) {
        return this.zSurveyDAO.latestSurvey(zSurveyVo);
    }

    @Transactional
    public void surveyResultChangeDelete(ZSurveyResultVo zSurveyResultVo) {
        this.zSurveyResultDAO.surveyResultChangeDelete(zSurveyResultVo);
    }

    @Transactional
    public void surveyResultUpdate(ZSurveyResultVo zSurveyResultVo) {
        this.zSurveyResultDAO.surveyResultUpdate(zSurveyResultVo);
    }

	@Override
	public String getSurveyIdSeq() {
		return this.zSurveyDAO.getSurveyIdSeq();
	}

	@Override
	public ZSurveyVo getSurveyIdList(ZSurveyVo zSurveyVo) {
		return this.zSurveyDAO.getSurveyIdList(zSurveyVo);
	}
}
