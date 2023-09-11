package com.z5.zcms.admsys.module.dao;

import com.z5.zcms.admsys.module.domain.SatisfactionVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class SatisfactionDAOImpl extends EgovComAbstractDAO implements SatisfactionDAO {

    //@Autowired
    //private SatisfactionVo satisfactionVo;

    private final String sqlMapNs = "Satisfaction.";
    Logger log = Logger.getLogger(this.getClass());

    public void satisfactionWrite(SatisfactionVo satisfactionVo) {
        insert(sqlMapNs + "satisfactionWrite", satisfactionVo);
    }

    @SuppressWarnings("unchecked")
    public List<SatisfactionVo> list(SatisfactionVo satisfactionVo) {
        return (List<SatisfactionVo>) list(sqlMapNs + "list", satisfactionVo);
    }

    public int listCount(SatisfactionVo satisfactionVo) {
        return (Integer) super.selectByPk(sqlMapNs + "listCount", satisfactionVo);
    }

    public SatisfactionVo detail(SatisfactionVo satisfactionVo) {
        return (SatisfactionVo) selectByPk(sqlMapNs + "getDetailInfo", satisfactionVo);
    }

    public void satisfactionDelete(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "satisfactionDelete", arrDeleteNo);
    }

    public void satisfactionUseDelete(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "satisfactionUseDelete", arrDeleteNo);
    }

    public SatisfactionVo getSatisfaction() {
        return new SatisfactionVo();
    }

    public void update(SatisfactionVo satisfactionVo) {
        update(sqlMapNs + "update", satisfactionVo);
    }

    @Override
    public SatisfactionVo latestSatisfaction(SatisfactionVo satisfactionVo) {
        return (SatisfactionVo) selectByPk(sqlMapNs + "getLatestSatisfaction", satisfactionVo);
    }

}
