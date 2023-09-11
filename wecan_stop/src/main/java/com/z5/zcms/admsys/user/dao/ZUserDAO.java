package com.z5.zcms.admsys.user.dao;

import com.z5.zcms.admsys.user.domain.SearchUser;
import com.z5.zcms.admsys.user.domain.ZUser2Vo;
import com.z5.zcms.admsys.user.domain.ZUserOrgVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.frontsys.front.domain.MenuStaffVO;

import java.util.List;

public interface ZUserDAO {
    public Integer listCountUser(ZUserVo vo);

    public List<ZUserVo> searchListUser(ZUserVo vo);

    public List<ZUserOrgVo> orgSearchListUser(ZUserVo vo);

    public List<ZUserVo> getListUser(ZUserVo vo);

    public List<ZUserVo> getUsers();

    public Integer listCountAdmin(ZUserVo vo);

    public List<ZUserVo> getListAdmin(ZUserVo vo);

    public List<ZUserVo> getAllList(ZUserVo vo);

    public void delete(List<Integer> arrDeleteNo);

    public void deleteAuth(List<Integer> arrDeleteNo);

    public void deleteAlluserplus(List<Integer> arrDeleteNo);

    public void deleteAlluserlicens(List<Integer> arrDeleteNo);

    public void deleteAllusercareer(List<Integer> arrDeleteNo);

    public void deleteAlluseraward(List<Integer> arrDeleteNo);

    public void deleteAlluseracademic(List<Integer> arrDeleteNo);

    public void deleteAllusersociety(List<Integer> arrDeleteNo);

    public ZUserVo selectbypk(ZUserVo vo);

    public void updateByAdmsys(ZUserVo vo);

    public String insert(ZUserVo vo);

    public List<ZUserVo> getlistAll(ZUserVo vo);

    public Integer getSameUserIdCount(String userId);

    public ZUserVo login(ZUserVo vo);

    public void insertAuth(ZUserVo zUserVo);

    public ZUserVo getFindId(ZUserVo vo);

    public ZUserVo getFindPw(ZUserVo vo);

    public void updateTmpPasswd(ZUserVo vo);

    public ZUserVo getInfo(ZUserVo vo);

    public void update(ZUserVo zUserVo);

    public Integer getSameUseremailCount(String useremail);

    public List<ZUserVo> listAll(ZUserVo vo);

    public void setUserPasswdMD5(ZUserVo zUserVo);

    public void updateAuthByAdmsys(ZUserVo zUserVo);

    public String isUserInEpms(ZUserVo vo);

    public void updateEnabledToOne(String userid);

    public void updateIsTmpPasswdFlagY(String userid);

    public void updateIsTmpPasswdFlagN(String userid);

    public void updateUserPasswd(ZUserVo vo);

    public void deleteOneUser(ZUserVo zUserVo);

    public void deleteOneAuth(ZUserVo zUserVo);

    public void add_admin_from_kfuser(String cs_id);

    //kpa 추가
    public String getuserno(String string);

    public void insertuseraca(ZUser2Vo zUser2Vo2);

    public void insertusercareer(ZUser2Vo zUser2Vo2);

    public void insertuseraward(ZUser2Vo zUser2Vo2);

    public void insertuserlicens(ZUser2Vo zUser2Vo2);

    public void insertuserplus(ZUser2Vo zUser2Vo);

    public void insertusersociety(ZUser2Vo zUser2Vo);

    public int getusercount(ZUserVo zUserVo);

    public ZUser2Vo getuserplus(ZUserVo zUserVo);

    public List<ZUser2Vo> getuserlicens(ZUserVo zUserVo);

    public List<ZUser2Vo> getusercareer(ZUserVo zUserVo);

    public List<ZUser2Vo> getuseraward(ZUserVo zUserVo);

    public List<ZUser2Vo> getuseracademic(ZUserVo zUserVo);

    public List<ZUser2Vo> getusersociety(ZUserVo zUserVo);

    public void updateuserplus(ZUser2Vo zUser2Vo);

    public void deleteuserlicens(ZUser2Vo zUser2Vo);

    public void deleteusercareer(ZUser2Vo zUser2Vo);

    public void deleteuseraward(ZUser2Vo zUser2Vo);

    public void deleteuseracademic(ZUser2Vo zUser2Vo);

    public void deleteusersociety(ZUser2Vo zUser2Vo);

    public void userCommitForStudent(String userid);

    public void updateuseroutrequestToZero(ZUserVo zUserVo);

    public void updateEnabledToZero(String userno);

    public void updateRequestEnabledToNomal(String userno); //정상화(단체회원,기증회원에서 사용하기 위해)

    public void updateUserStatus(ZUserVo zUserVo); //회원 승인 20150520 문영걸

    //searchUser
    public int listCountSearch(SearchUser searchUser);

    public List<SearchUser> getListSearch(SearchUser searchUser);

    public List<SearchUser> getListSearchAll(SearchUser searchUser);


    // KPA 단체회원, 기증회원
    public void insertOrgUser(ZUserOrgVo vo);

    public Integer getOrgUserListCount(ZUserVo vo);

    public List<ZUserVo> getOrgUserList(ZUserVo vo);

    public ZUserOrgVo getOrgUserDataByNo(ZUserOrgVo vo);

    public void updateOrgUser(ZUserVo vo);

    public void updateOrgUser(ZUserOrgVo vo);

    public void deleteOrgUser(List<Integer> arrDeleteNo);

    public Integer selectVote(ZUserVo zUserVo);

    public Integer listCountKF(MenuStaffVO MenuStaffVO);

    public List<ZUserVo> getListKF(MenuStaffVO MenuStaffVO);

    public MenuStaffVO getInfoKFUser(String cs_id);
    
    public void updateLogincount(String userid);
    
    public List<ZUserVo> getListUser2(ZUserVo vo);

}
