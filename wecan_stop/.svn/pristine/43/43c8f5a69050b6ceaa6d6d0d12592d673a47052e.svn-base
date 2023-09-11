package com.z5.zcms.admsys.site.dao;

import com.z5.zcms.admsys.site.domain.ZsitecfgVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import org.springframework.stereotype.Repository;

@Repository
public class ZsitecfgDAOImpl extends EgovComAbstractDAO implements ZsitecfgDAO {

    private final String sqlMapNs = "zsitecfgDAO.";

    public ZsitecfgVo selectbysiteno(Integer no) {
        return (ZsitecfgVo) getSqlMapClientTemplate().queryForObject(sqlMapNs + "selectbysiteno", no);

    }

    public void write(ZsitecfgVo vo) {
        insert(sqlMapNs + "write", vo);
    }


}
