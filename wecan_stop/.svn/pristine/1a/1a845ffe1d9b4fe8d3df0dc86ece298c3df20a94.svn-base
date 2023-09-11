package com.z5.zcms.admsys.zmainbanner.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.main.domain.ZmainVo;
import com.z5.zcms.admsys.zmainbanner.domain.ZmainbannerVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZmainbannerDAOImpl extends EgovComAbstractDAO implements ZmainbannerDAO {

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zmainbannerDAO.";
	
	//private final String sqlMapNsS = "zmainbannerfont."
	
	public ZmainbannerVO selectbysiteno(int no) {
		return (ZmainbannerVO) getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbysiteno", no);
	}

	public void write(ZmainbannerVO zmainbannervo) {
		insert (sqlMapNs+"write", zmainbannervo);
	}

	@Override
	public void insert(ZmainbannerVO zmainbannerVO) {
		insert (sqlMapNs+"insert", zmainbannerVO);
		
	}
	
	/*public ZmainbannerVO getMaxno(ZmainbannerVO zmainbannerVO){
		return (ZmainbannerVO) getSqlMapClientTemplate().queryForObject(sqlMapNs+"getMaxno", zmainbannerVO);
		
	}*/

	@Override
	public Integer listCount(ZmainbannerVO zmainbannerVO) {
		return (Integer) super.selectByPk(sqlMapNs+"listCount", zmainbannerVO);
	}

	@SuppressWarnings("unchecked")
	public List<ZmainbannerVO> getList(ZmainbannerVO zmainbannerVO) {
		return (List<ZmainbannerVO>) super.list(sqlMapNs+"list", zmainbannerVO);
	}

	@SuppressWarnings("unchecked")
	public List<ZmainbannerVO> getListAll(ZmainbannerVO zmainbannerVO) {
		return (List<ZmainbannerVO>) super.list(sqlMapNs+"listAll", zmainbannerVO);
	}

	@Override
	public void update(ZmainbannerVO zmainbannerVO) {
		update(sqlMapNs+"update", zmainbannerVO);
	}
	@Override
	public void updateUpRank(ZmainbannerVO zmainbannerVO) {
		update(sqlMapNs+"updateUpRank", zmainbannerVO);
	}
	@Override
	public void updateDownRank(ZmainbannerVO zmainbannerVO) {
		update(sqlMapNs+"updateDownRank", zmainbannerVO);
	}
 
	@Override
	public void delete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs+"delete", arrDeleteNo);
	}

	@Override
	public void updatemainbanner(ZmainbannerVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ZmainbannerVO selectbypk(int no) {
		 return (ZmainbannerVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", no);
	}

	
	@SuppressWarnings("unchecked")
	public List<ZmainbannerVO> list(ZmainbannerVO zmainbannerVO){
		return (List<ZmainbannerVO>) list(sqlMapNs + "list", zmainbannerVO);
	}

	@SuppressWarnings("unchecked")
	public List<ZmainbannerVO> getlistCfg(ZmainbannerVO zmainbannerVO) {
		return (List<ZmainbannerVO>) super.list(sqlMapNs+"listCfg", zmainbannerVO);
	}

	@SuppressWarnings("unchecked")
	public List<ZmainbannerVO> getzmainbannerfront(ZmainbannerVO zmainbannerVO) {
		return (List<ZmainbannerVO>) list(sqlMapNs+"zmainbannerfront", zmainbannerVO);
	}

	@Override
	public void mobileinsert(ZmainbannerVO zmainbannerVO) {
		insert (sqlMapNs+"mobileinsert", zmainbannerVO);
		
	}

	@Override
	public void mobileupdateView(ZmainbannerVO zmainbannerVO) {
		update(sqlMapNs+"update", zmainbannerVO);
		
	}


}
