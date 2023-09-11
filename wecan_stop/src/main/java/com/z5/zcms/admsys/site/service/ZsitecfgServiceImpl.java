package com.z5.zcms.admsys.site.service;

import com.z5.zcms.admsys.site.dao.ZsitecfgDAO;
import com.z5.zcms.admsys.site.domain.ZsitecfgVo;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZsitecfgServiceImpl extends AbstractServiceImpl implements ZsitecfgService {

    @Autowired
    private ZsitecfgDAO zsitecfgDAO;

    public ZsitecfgVo selectbysiteno(int no) {
        return zsitecfgDAO.selectbysiteno(no);
    }

    public void write(ZsitecfgVo zsitecfgVo) {
        zsitecfgDAO.write(zsitecfgVo);
    }

}
