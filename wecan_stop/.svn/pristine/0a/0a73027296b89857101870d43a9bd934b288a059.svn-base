package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZRegMngVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZRegMngDAOImpl extends EgovComAbstractDAO implements ZRegMngDAO {
	
	private final String sqlMapNs = "ZRegMng.";
	
	@SuppressWarnings("unchecked")
	public List<ZRegMngVo> list(ZRegMngVo zRegMngVo){
		return (List<ZRegMngVo>) list(sqlMapNs + "list", zRegMngVo);
	};
	public void write(ZRegMngVo zRegMngVo){
		insert(sqlMapNs + "write", zRegMngVo);
	};
	public int listCount(ZRegMngVo zRegMngVo){
		return (Integer) selectByPk(sqlMapNs + "listCount", zRegMngVo);
	};
	public ZRegMngVo detail(ZRegMngVo zRegMngVo){
		return (ZRegMngVo)selectByPk(sqlMapNs + "detail", zRegMngVo);
	};
	public void delete(List<Integer> arrDeleteNo){
		delete(sqlMapNs + "delete", arrDeleteNo);
	};

}
