package com.z5.zcms.admsys.common.service;

import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonUseVo;
import com.z5.zcms.admsys.common.domain.EditHistoryVo;
import com.z5.zcms.admsys.common.domain.PostVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;

public interface CommonService {

    public Integer getCountUseTable(CommonUseVo vo);
    void insert(CommonUseVo vo) throws Exception;
    void deleteUse(CommonUseVo vo) throws Exception;
    List<ZmenuVo> getListParentsTree(int menuno,int siteno) throws Exception;
    List<Integer> getListChildrenTree(int menuno,int siteno) throws Exception;
    public List<String> getUseTbl() throws Exception;
    public void batchInsert(List<CommonUseVo> dataList) throws Exception;
    public void batchUpdate(List<CommonUseVo> dataList) throws Exception;
    List<PostVo> getListPost(PostVo vo) throws Exception; //새우편번호가져오기
    //2021-11-23 진흥원 common 기능들
    public void registrationEditHistory(EditHistoryVo ehVo) throws Exception;
    public List<EditHistoryVo> retrieveEditHistory(EditHistoryVo ehVo) throws Exception;
}