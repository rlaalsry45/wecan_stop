package com.z5.zcms.admsys.site.dao;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import org.apache.log4j.Logger;
import egovframework.rte.psl.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class ZsiteDAOImpl extends EgovComAbstractDAO implements ZsiteDAO {

    private final String sqlMapNs = "zsiteDAO.";
    Logger log = Logger.getLogger(this.getClass());

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void batchDelete(final List<ZsiteVo> dataList) {
        try {
            getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
                public Object doInSqlMapClient(SqlMapExecutor executor)
                    throws SQLException {
                    executor.startBatch();
                    final Iterator<ZsiteVo> iter = dataList.iterator();
                    while (iter.hasNext())
                        // executor.insert(sqlMapNs+"delete", iter.next());
                        // executor.update(sqlMapNs+"delete", iter.next());
                        executor.delete(sqlMapNs + "batchdelete", iter.next());
                    return new Integer(executor.executeBatch());
                }
            });
        } catch (final Exception e) {
            System.out.print(e);
        }
    }

    public int copy(ZsiteVo vo) {
        int maxno        = (Integer) getSqlMapClientTemplate().queryForObject(sqlMapNs + "selectmaxno");
        int maxno_origin = maxno;

        vo.setMaxno(maxno);
        insert(sqlMapNs + "copysite", vo);

        maxno = (Integer) insert(sqlMapNs + "copymain", vo);

        vo.setM(maxno);
        vo.setMaxno(maxno_origin);
        insert(sqlMapNs + "copysitecfg", vo);

        insert(sqlMapNs + "copymenu", vo);

        return maxno_origin;
    }

    public void del(String no) {
        delete(sqlMapNs + "delete", no);
    }

    @SuppressWarnings("unchecked")
    public List<ZsiteVo> getlist(ZsiteVo vo) {
        return (List<ZsiteVo>) super.list(sqlMapNs + "list", vo);
    }

    @SuppressWarnings("unchecked")
    public List<ZsiteVo> getlistAll() {
        return (List<ZsiteVo>) super.list(sqlMapNs + "listAll", null);
    }

    public int dupCheck(String sitedomain) {
        return (Integer) super.selectByPk(sqlMapNs + "dupCheck", sitedomain);
    }

    public Integer insert(ZsiteVo vo) {
        return (Integer) insert(sqlMapNs + "write", vo);
    }

    public Integer listCount(ZsiteVo vo) {
        return (Integer) super.selectByPk(sqlMapNs + "listCount", vo);
    }

    public ZsiteVo selectbypk(ZsiteVo vo) {
        return (ZsiteVo) getSqlMapClientTemplate().queryForObject(
            sqlMapNs + "selectbypk", vo);
    }

    public void update(ZsiteVo vo) {
        update(sqlMapNs + "update", vo);
        update(sqlMapNs + "updatemain", vo);
    }

    public void updatedate(ZsiteVo vo) {
        update(sqlMapNs + "updatedate", vo);
    }

    public int siteSwapNum(Map<String, String> map) {
        return (Integer) selectByPk(sqlMapNs + "swapNum", map);
    }

    public void siteOrder(Map<String, String> map) {
        update(sqlMapNs + "siteOrder", map);
    }
}
