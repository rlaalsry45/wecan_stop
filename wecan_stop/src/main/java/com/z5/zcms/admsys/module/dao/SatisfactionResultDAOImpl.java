package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.SatisfactionResultVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionResultVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class SatisfactionResultDAOImpl extends EgovComAbstractDAO implements SatisfactionResultDAO {

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "SatisfactionResult.";

	public int listCount(SatisfactionResultVo satisfactionResultVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", satisfactionResultVo);
	}
	
	@SuppressWarnings("unchecked")
	public List<SatisfactionResultVo> listSubject(SatisfactionResultVo satisfactionResultVo) {
		return (List<SatisfactionResultVo>) super.list(sqlMapNs + "listSubject", satisfactionResultVo);
	}

	public void satisfactionResultDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "satisfactionResultDelete", arrDeleteNo);
	}
	
	public void satisfactionResultWrite(SatisfactionResultVo satisfactionResultVo) {
		delete(sqlMapNs + "satisfactionResultWrite", satisfactionResultVo);
	}
	
	public void satisfactionResultTotalUpdate(SatisfactionResultVo satisfactionResultVo) {
		delete(sqlMapNs + "satisfactionResultTotalUpdate", satisfactionResultVo);
	}
	
	public void satisfactionResultChangeDelete(SatisfactionResultVo satisfactionResultVo) {
		delete(sqlMapNs + "satisfactionResultChangeDelete", satisfactionResultVo);
	}
	public void satisfactionResultUpdate(SatisfactionResultVo satisfactionResultVo) {
		update(sqlMapNs + "satisfactionResultUpdate", satisfactionResultVo);
	}
	

}