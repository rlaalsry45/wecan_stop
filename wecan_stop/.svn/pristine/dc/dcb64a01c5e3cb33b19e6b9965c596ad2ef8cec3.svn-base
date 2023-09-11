package com.z5.zcms.admsys.module.dao;

import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class ZSatisfactionDAOImpl extends EgovComAbstractDAO implements ZSatisfactionDAO {

    //@Autowired
    //private ZSatisfactionVo zSatisfactionVo;

    private final String sqlMapNs = "ZSatisfaction.";
    Logger log = Logger.getLogger(this.getClass());

    public void satisfactionWrite(ZSatisfactionVo zSatisfactionVo) {
        insert(sqlMapNs + "satisfactionWrite", zSatisfactionVo);
    }

    @SuppressWarnings("unchecked")
    public List<ZSatisfactionVo> list(ZSatisfactionVo zSatisfactionVo) {
        return (List<ZSatisfactionVo>) list(sqlMapNs + "list", zSatisfactionVo);
    }

    public int listCount(ZSatisfactionVo zSatisfactionVo) {
        return (Integer) super.selectByPk(sqlMapNs + "listCount", zSatisfactionVo);
    }

    public ZSatisfactionVo detail(ZSatisfactionVo zSatisfactionVo) {
        return (ZSatisfactionVo) selectByPk(sqlMapNs + "getDetailInfo", zSatisfactionVo);
    }

    public void satisfactionDelete(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "satisfactionDelete", arrDeleteNo);
    }

    public void satisfactionUseDelete(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "satisfactionUseDelete", arrDeleteNo);
    }

    public ZSatisfactionVo getSatisfaction() {
        return new ZSatisfactionVo();
    }

    public void update(ZSatisfactionVo zSatisfactionVo) {
        update(sqlMapNs + "update", zSatisfactionVo);
    }

    @Override
    public ZSatisfactionVo latestSatisfaction(ZSatisfactionVo zSatisfactionVo) {
        return (ZSatisfactionVo) selectByPk(sqlMapNs + "getLatestSatisfaction", zSatisfactionVo);
    }
    
    public String getSatisfactionIdSeq() {
		return (String)super.select(sqlMapNs + "getSatisfactionIdSeq");
	}
    
    public ZSatisfactionVo getSatisfactionIdList(ZSatisfactionVo zSatisfactionVo) {
        return (ZSatisfactionVo) selectByPk(sqlMapNs + "getSatisfactionIdList", zSatisfactionVo);
    }

}
