package com.z5.zcms.admsys.user.dao;

import com.z5.zcms.admsys.user.domain.SearchUser;
import com.z5.zcms.admsys.user.domain.ZUser2Vo;
import com.z5.zcms.admsys.user.domain.ZUserOrgVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.frontsys.front.domain.MenuStaffVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZUserDAOImpl extends EgovComAbstractDAO implements ZUserDAO {

    private final String sqlMapNs = "ZUser.";
    Logger log = Logger.getLogger(this.getClass());

    public Integer listCountUser(ZUserVo vo) {
        return (Integer) super.selectByPk(sqlMapNs + "listCountUser", vo);
    }

    @SuppressWarnings("unchecked")
    public List<ZUserVo> searchListUser(ZUserVo vo) {	
        return (List<ZUserVo>) super.list(sqlMapNs + "searchListUser", vo);
    }

    @SuppressWarnings("unchecked")
    public List<ZUserOrgVo> orgSearchListUser(ZUserVo vo) {
        return (List<ZUserOrgVo>) super.list(sqlMapNs + "orgSearchListUser", vo);
    }

    @SuppressWarnings("unchecked")
    public List<ZUserVo> getListUser(ZUserVo vo) {
        return (List<ZUserVo>) super.list(sqlMapNs + "getListUser", vo);
    }

    public List<ZUserVo> getUsers() {
        return (List<ZUserVo>) super.list(sqlMapNs + "getUsers", null);
    }

    public Integer listCountAdmin(ZUserVo vo) {
        return (Integer) super.selectByPk(sqlMapNs + "listCountAdmin", vo);
    }

    @SuppressWarnings("unchecked")
    public List<ZUserVo> getListAdmin(ZUserVo vo) {
        return (List<ZUserVo>) super.list(sqlMapNs + "getListAdmin", vo);
    }

    @SuppressWarnings("unchecked")
    public List<ZUserVo> getAllList(ZUserVo vo) {
        return (List<ZUserVo>) super.list(sqlMapNs + "getAllList", vo);
    }

    public void delete(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "delete", arrDeleteNo);
    }

    public void deleteAuth(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "deleteAuth", arrDeleteNo);
    }

    public void deleteAlluserplus(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "deleteAlluserplus", arrDeleteNo);
    }

    public void deleteAlluserlicens(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "deleteAlluserlicens", arrDeleteNo);
    }

    public void deleteAllusercareer(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "deleteAllusercareer", arrDeleteNo);
    }

    public void deleteAlluseraward(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "deleteAlluseraward", arrDeleteNo);
    }

    public void deleteAlluseracademic(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "deleteAlluseracademic", arrDeleteNo);
    }

    public void deleteAllusersociety(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "deleteAllusersociety", arrDeleteNo);
    }

    public ZUserVo selectbypk(ZUserVo vo) {
        return (ZUserVo) getSqlMapClientTemplate().queryForObject(sqlMapNs + "selectbypk", vo);

    }

    public void updateByAdmsys(ZUserVo vo) {
        update(sqlMapNs + "updateByAdmsys", vo);
    }

    public void updateAuthByAdmsys(ZUserVo vo) {
        update(sqlMapNs + "updateAuthByAdmsys", vo);

    }

    public void updateUserStatus(ZUserVo vo) {
        update(sqlMapNs + "updateUserStatus", vo);

    }


    public String insert(ZUserVo vo) {
        return (String) insert(sqlMapNs + "write", vo);
    }

    @SuppressWarnings("unchecked")
    public List<ZUserVo> getlistAll(ZUserVo vo) {
        return (List<ZUserVo>) super.list(sqlMapNs + "listAll", vo);
    }

    public Integer getSameUserIdCount(String userid) {
        return (Integer) super.selectByPk(sqlMapNs + "getSameUserIdCount", userid);
    }

    public ZUserVo login(ZUserVo vo) {
        return (ZUserVo) getSqlMapClientTemplate().queryForObject(sqlMapNs + "login", vo);
    }

    public void insertAuth(ZUserVo vo) {
        super.insert(sqlMapNs + "insertAuth", vo);

    }

    public ZUserVo getFindId(ZUserVo vo) {
        return (ZUserVo) getSqlMapClientTemplate().queryForObject(sqlMapNs + "getFindId", vo);
    }

    public ZUserVo getFindPw(ZUserVo vo) {
        return (ZUserVo) getSqlMapClientTemplate().queryForObject(sqlMapNs + "getFindPw", vo);
    }

    public void updateTmpPasswd(ZUserVo vo) {
        update(sqlMapNs + "updateTmpPasswd", vo);
    }

    public ZUserVo getInfo(ZUserVo vo) {
        return (ZUserVo) getSqlMapClientTemplate().queryForObject(sqlMapNs + "getInfo", vo);
    }

    public void update(ZUserVo vo) {
        update(sqlMapNs + "update", vo);
    }

    public Integer getSameUseremailCount(String useremail) {
        return (Integer) super.selectByPk(sqlMapNs + "getSameUseremailCount", useremail);
    }

    @SuppressWarnings("unchecked")
    public List<ZUserVo> listAll(ZUserVo vo) {
        return (List<ZUserVo>) super.list(sqlMapNs + "listAll", vo);
    }

    public void setUserPasswdMD5(ZUserVo vo) {
        update(sqlMapNs + "setUserPasswdMD5", vo);

    }

    @Override
    public String isUserInEpms(ZUserVo vo) {
        return (String) super.selectByPk(sqlMapNs + "isUserInEpms", vo);
    }

    @Override
    public void updateEnabledToOne(String userid) {
        update(sqlMapNs + "updateEnabledToOne", userid);
    }

    @Override
    public void updateIsTmpPasswdFlagY(String userid) {
        update(sqlMapNs + "updateIsTmpPasswdFlagY", userid);
    }

    @Override
    public void updateIsTmpPasswdFlagN(String userid) {
        update(sqlMapNs + "updateIsTmpPasswdFlagN", userid);
    }

    @Override
    public void updateUserPasswd(ZUserVo vo) {
        update(sqlMapNs + "updateUserPasswd", vo);
    }

    @Override
    public void deleteOneUser(ZUserVo zUserVo) {
        delete(sqlMapNs + "deleteOneUser", zUserVo);
    }

    @Override
    public void deleteOneAuth(ZUserVo zUserVo) {
        delete(sqlMapNs + "deleteOneAuth", zUserVo);
    }

    @Override
    public void add_admin_from_kfuser(String cs_id) {
        insert(sqlMapNs + "add_admin_from_kfuser", cs_id);

    }

    //kpa추가 회원정보
    @Override
    public String getuserno(String string) {
        return (String) selectByPk(sqlMapNs + "getuserno", string);
    }

    @Override
    public void insertuseraca(ZUser2Vo zUser2Vo2) {
        insert(sqlMapNs + "insertuseraca", zUser2Vo2);
    }

    @Override
    public void insertusercareer(ZUser2Vo zUser2Vo2) {
        insert(sqlMapNs + "insertusercareer", zUser2Vo2);
    }

    @Override
    public void insertuseraward(ZUser2Vo zUser2Vo2) {
        insert(sqlMapNs + "insertuseraward", zUser2Vo2);
    }

    @Override
    public void insertuserlicens(ZUser2Vo zUser2Vo2) {
        insert(sqlMapNs + "insertuserlicens", zUser2Vo2);
    }

    @Override
    public void insertuserplus(ZUser2Vo zUser2Vo) {
        insert(sqlMapNs + "insertuserplus", zUser2Vo);
    }

    @Override
    public void insertusersociety(ZUser2Vo zUser2Vo) {
        insert(sqlMapNs + "insertusersociety", zUser2Vo);
    }

    @Override
    public int getusercount(ZUserVo zUserVo) {
        return (Integer) selectByPk(sqlMapNs + "getusercount", zUserVo);
    }

    @Override
    public ZUser2Vo getuserplus(ZUserVo zUserVo) {
        return (ZUser2Vo) selectByPk(sqlMapNs + "getuserplus", zUserVo);
    }

    @Override
    public List<ZUser2Vo> getuserlicens(ZUserVo zUserVo) {
        return (List<ZUser2Vo>) super.list(sqlMapNs + "getuserlicens", zUserVo);
    }

    @Override
    public List<ZUser2Vo> getusercareer(ZUserVo zUserVo) {
        return (List<ZUser2Vo>) super.list(sqlMapNs + "getusercareer", zUserVo);
    }

    @Override
    public List<ZUser2Vo> getuseraward(ZUserVo zUserVo) {
        return (List<ZUser2Vo>) super.list(sqlMapNs + "getuseraward", zUserVo);
    }

    @Override
    public List<ZUser2Vo> getuseracademic(ZUserVo zUserVo) {
        return (List<ZUser2Vo>) super.list(sqlMapNs + "getuseracademic", zUserVo);
    }

    @Override
    public List<ZUser2Vo> getusersociety(ZUserVo zUserVo) {
        return (List<ZUser2Vo>) super.list(sqlMapNs + "getusersociety", zUserVo);
    }


    @Override
    public void updateuserplus(ZUser2Vo zUser2Vo) {
        update(sqlMapNs + "updateuserplus", zUser2Vo);
    }

    @Override
    public void deleteuserlicens(ZUser2Vo zUser2Vo) {
        delete(sqlMapNs + "deleteuserlicens", zUser2Vo);
    }

    @Override
    public void deleteusercareer(ZUser2Vo zUser2Vo) {
        delete(sqlMapNs + "deleteusercareer", zUser2Vo);
    }

    @Override
    public void deleteuseraward(ZUser2Vo zUser2Vo) {
        delete(sqlMapNs + "deleteuseraward", zUser2Vo);
    }

    @Override
    public void deleteuseracademic(ZUser2Vo zUser2Vo) {
        delete(sqlMapNs + "deleteuseracademic", zUser2Vo);
    }

    @Override
    public void deleteusersociety(ZUser2Vo zUser2Vo) {
        delete(sqlMapNs + "deleteusersociety", zUser2Vo);
    }

    @Override
    public void userCommitForStudent(String userid) {
        update(sqlMapNs + "userCommitForStudent", userid);

    }

    @Override
    public void updateuseroutrequestToZero(ZUserVo zUserVo) {
        update(sqlMapNs + "updateuseroutrequestToZero", zUserVo);
    }

    @Override
    public void updateEnabledToZero(String userno) {
        update(sqlMapNs + "updateEnabledToZero", userno);
    }

    @Override
    public void updateRequestEnabledToNomal(String userno) {
        update(sqlMapNs + "updateRequestEnabledToNomal", userno);
    }

    @Override
    public int listCountSearch(SearchUser searchUser) {
        return (Integer) super.selectByPk(sqlMapNs + "listCountSearch", searchUser);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SearchUser> getListSearch(SearchUser searchUser) {
        return (List<SearchUser>) super.list(sqlMapNs + "getListSearch", searchUser);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SearchUser> getListSearchAll(SearchUser searchUser) {
        return (List<SearchUser>) super.list(sqlMapNs + "getListSearchAll", searchUser);
    }

    // KPA 단체회원, 기증회원
    @Override
    public void insertOrgUser(ZUserOrgVo vo) {
        insert(sqlMapNs + "insertOrgUser", vo);
    }

    @Override
    public Integer getOrgUserListCount(ZUserVo vo) {
        return (Integer) selectByPk(sqlMapNs + "getOrgUserListCount", vo);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ZUserVo> getOrgUserList(ZUserVo vo) {
        return (List<ZUserVo>) super.list(sqlMapNs + "getOrgUserList", vo);
    }

    @Override
    public ZUserOrgVo getOrgUserDataByNo(ZUserOrgVo vo) {
        return (ZUserOrgVo) selectByPk(sqlMapNs + "getOrgUserDataByNo", vo);
    }

    @Override
    public void updateOrgUser(ZUserVo vo) {
        update(sqlMapNs + "updateOrgZUser", vo);
    }

    @Override
    public void updateOrgUser(ZUserOrgVo vo) {
        update(sqlMapNs + "updateOrgUserInfo", vo);
    }

    @Override
    public void deleteOrgUser(List<Integer> arrDeleteNo) {
        delete(sqlMapNs + "deleteOrgUser", arrDeleteNo);
    }

    public Integer selectVote(ZUserVo vo) {
        return (Integer) super.selectByPk(sqlMapNs + "selectVote", vo);
    }

    @Override
    public Integer listCountKF(MenuStaffVO MenuStaffVO) {
        return (Integer) super.selectByPk(sqlMapNs + "listCountKF", MenuStaffVO);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ZUserVo> getListKF(MenuStaffVO MenuStaffVO) {
        return (List<ZUserVo>) super.list(sqlMapNs + "getListKF", MenuStaffVO);
    }

    @Override
    public MenuStaffVO getInfoKFUser(String cs_id) {
        return (MenuStaffVO) getSqlMapClientTemplate().queryForObject(sqlMapNs + "getInfoKFUser", cs_id);
    }

	@Override
	public void updateLogincount(String userid) {
		update(sqlMapNs + "updateLogincount", userid);	
	}
	
	@SuppressWarnings("unchecked")
	public List<ZUserVo> getListUser2(ZUserVo vo) {
    	return (List<ZUserVo>) super.list(sqlMapNs + "getListUser2", vo);
	}

}
