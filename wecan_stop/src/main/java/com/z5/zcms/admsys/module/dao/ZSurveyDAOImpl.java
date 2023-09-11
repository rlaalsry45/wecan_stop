package com.z5.zcms.admsys.module.dao;

import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class ZSurveyDAOImpl extends EgovComAbstractDAO implements ZSurveyDAO {

    //@Autowired
    //private ZSurveyVo zSurveyVo;

    private final String sqlMapNs = "ZSurvey.";
    Logger log = Logger.getLogger(this.getClass());

    public int surveyWrite(ZSurveyVo zSurveyVo) {
    	return (int)insert(sqlMapNs + "surveyWrite", zSurveyVo);
    }

    @SuppressWarnings("unchecked")
    public List<ZSurveyVo> list(ZSurveyVo zSurveyVo) {
        return (List<ZSurveyVo>) list(sqlMapNs + "list", zSurveyVo);
    }

    public int listCount(ZSurveyVo zSurveyVo) {
        return (Integer) super.selectByPk(sqlMapNs + "listCount", zSurveyVo);
    }

    public ZSurveyVo detail(ZSurveyVo zSurveyVo) {
        return (ZSurveyVo) selectByPk(sqlMapNs + "getDetailInfo", zSurveyVo);
    }

    public void surveyDelete(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "surveyDelete", arrDeleteNo);
    }

    public void surveyUseDelete(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "surveyUseDelete", arrDeleteNo);
    }

    public ZSurveyVo getSurvey() {
        return new ZSurveyVo();
    }

    public void update(ZSurveyVo zSurveyVo) {
        update(sqlMapNs + "update", zSurveyVo);
    }

    @Override
    public ZSurveyVo latestSurvey(ZSurveyVo zSurveyVo) {
        return (ZSurveyVo) selectByPk(sqlMapNs + "getLatestSurvey", zSurveyVo);
    }
    
    public String getSurveyIdSeq() {
		return (String)super.select(sqlMapNs + "getSurveyIdSeq");
	}

    public ZSurveyVo getSurveyOfOrgid(ZSurveyVo zSurveyVo) {
        return (ZSurveyVo) selectByPk(sqlMapNs + "getSurveyOfOrgid", zSurveyVo);
    }
}
