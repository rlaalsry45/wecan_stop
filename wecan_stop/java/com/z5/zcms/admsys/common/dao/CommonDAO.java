package com.z5.zcms.admsys.common.dao;

import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonUseVo;
import com.z5.zcms.admsys.common.domain.EditHistoryVo;
import com.z5.zcms.admsys.common.domain.PostVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;

public interface CommonDAO {
	public Integer getCountUseTable(CommonUseVo vo);
	public String insert(CommonUseVo vo);
	public void deleteUse(CommonUseVo vo);
	public Integer getUseMenuno(CommonUseVo vo);
	public List<Integer> getListChildrenTree(ZmenuVo vo);
	public List<String> getUseTbl();
	public void batchInsert(List<CommonUseVo> dataList);
	public void batchUpdate(List<CommonUseVo> dataList);
	public List<ZUserVo> getUserpasswd(List<ZUserVo> vo) throws Exception;
	public void updateUserpasswd(ZUserVo zUserVo) throws Exception;
	public List<PostVo> getListPost(PostVo vo) throws Exception;
	//2021-11-23 진흥원 common 기능들
    public void registrationEditHistory(EditHistoryVo ehVo) throws Exception;
    public List<EditHistoryVo> retrieveEditHistory(EditHistoryVo ehVo) throws Exception;
}
