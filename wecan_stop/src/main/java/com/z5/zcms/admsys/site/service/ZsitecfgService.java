package com.z5.zcms.admsys.site.service;

import com.z5.zcms.admsys.site.domain.ZsitecfgVo;

public interface ZsitecfgService {

    ZsitecfgVo selectbysiteno(int num) throws Exception;
    void write(ZsitecfgVo zsitecfgVo) throws Exception;

}
