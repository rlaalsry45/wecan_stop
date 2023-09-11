package com.z5.zcms.admsys.user.service;

import com.z5.zcms.admsys.user.domain.ZUserOrgVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.frontsys.front.domain.MenuStaffVO;

import java.util.List;

//@Service superbolt
public interface ZUserService {

    /* ZUser Line */
    public Integer listCount(ZUserVo zUserVo, String userOrAdmin);

    public List<ZUserVo> searchListUser(ZUserVo zUserVo);

    public List<ZUserOrgVo> orgSearchListUser(ZUserVo zUserVo);

    public List<ZUserVo> getList(ZUserVo zUserVo, String userOrAdmin);

    public List<ZUserVo> getUsers();

    public List<ZUserVo> getAllList(ZUserVo zUserVo);

    public void delete(List<Integer> arrDeleteNo);

    public void delete(List<Integer> arrDeleteNo, String memType);

    public ZUserVo selectbypk(ZUserVo vo);

    public void updateByAdmsys(ZUserVo zUserVo);

    public ZUserVo getInfo(ZUserVo vo);
    
    public void updateUser(ZUserVo zUserVo);
    
    public void insertUser(ZUserVo zUserVo);

    /*
    public void popupWrite(ZUserVo zUserVo);
    public Object popupDetail(Object obj);
    public void popupDelete(List<Integer> arrDeleteNo);
    public void popupEdit(ZUserVo zUserVo);
    public void updateAttach(ZUserVo zUserVo);

    ZPopupHis Line
    public List<ZPopupHisVo> getPopupHisList(ZUserVo zUserVo);
    public void popupHisDelete(ZPopupHisVo zPopupHisVo);
    public Integer attachCount(String popupimg_org);
    */
    public void updateAuthByAdmsys(ZUserVo zUserVo);

    public void add_admin_from_kfuser(String cs_id);

    public void updateUserStatus(ZUserVo zUserVo);

    /*선거권 확인*/
    public Integer selectVote(ZUserVo zUserVo);

    public int listCountKF(MenuStaffVO kfuserVO);

    public List<ZUserVo> getListKF(MenuStaffVO kfuserVO);

    public MenuStaffVO getInfoKFUser(String cs_id);
    
    public List<ZUserVo> getList2(ZUserVo zUserVo);

}

