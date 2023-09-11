package com.z5.zcms.admsys.common.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.z5.zcms.admsys.common.domain.CommonUseVo;
import com.z5.zcms.admsys.common.domain.EditHistoryVo;
import com.z5.zcms.admsys.common.domain.PostVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.orm.ibatis.SqlMapClientCallback;

@Repository
public class CommonDAOImpl extends EgovComAbstractDAO implements CommonDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "commonDAO.";
	
	public Integer getCountUseTable(CommonUseVo vo) {
		return (Integer) super.selectByPk(sqlMapNs+"getCountUseTable",vo);
	}
	
	public String insert(CommonUseVo vo) {
        return (String)insert(sqlMapNs+"write", vo);
    }
	
	public void deleteUse(CommonUseVo vo){
		delete(sqlMapNs+"deleteUse", vo);
	}
	
	public Integer getUseMenuno(CommonUseVo vo) {
		Object ret = super.selectByPk(sqlMapNs+"getUseMenuno",vo);
		if (ret == null) return -9999;
		else return (Integer) ret;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getListChildrenTree(ZmenuVo vo){
		return (List<Integer>) super.list(sqlMapNs+"getListChildrenTree", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getUseTbl(){
		return (List<String>) list(sqlMapNs+"getUseTbl",null);
	}
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void batchInsert(final List<CommonUseVo> dataList){
		try {
			getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor)
						throws SQLException {
					executor.startBatch();
					final Iterator<CommonUseVo> iter = dataList.iterator();
					while (iter.hasNext())
						// executor.delete(sqlMapNs+"delete", iter.next());
						// executor.update(sqlMapNs+"delete", iter.next());
						executor.insert(sqlMapNs + "batchInsert", iter.next());
					return new Integer(executor.executeBatch());
				}
			});
		} catch (final Exception e) {
			System.out.print(e);
		}
	}
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void batchUpdate(final List<CommonUseVo> dataList){
		try {
			getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor)
						throws SQLException {
					executor.startBatch();
					final Iterator<CommonUseVo> iter = dataList.iterator();
					while (iter.hasNext())
						// executor.delete(sqlMapNs+"delete", iter.next());
						// executor.update(sqlMapNs+"delete", iter.next());
						executor.insert(sqlMapNs + "batchUpdate", iter.next());
					return new Integer(executor.executeBatch());
				}
			});
		} catch (final Exception e) {
			System.out.print(e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ZUserVo> getUserpasswd(List<ZUserVo> vo) throws Exception {
		return (List<ZUserVo>) super.list(sqlMapNs+"getUserpasswd", vo);
	}

	@Override
	public void updateUserpasswd(ZUserVo zUserVo) throws Exception {
	        update(sqlMapNs+"updateUserpasswd", zUserVo);
	}
	
	@SuppressWarnings("unchecked")
	public List<PostVo> getListPost(PostVo vo){
		return (List<PostVo>) super.list("Post.getListPost", vo);
	}

	@Override
	public void registrationEditHistory(EditHistoryVo ehVo) throws Exception {
		super.insert(sqlMapNs+"registrationEditHistory", ehVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EditHistoryVo> retrieveEditHistory(EditHistoryVo ehVo) throws Exception {
		return (List<EditHistoryVo>) super.list(sqlMapNs+"retrieveEditHistory", ehVo);
	}
}
