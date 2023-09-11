package com.z5.zcms.admsys.user.service;

import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.ZUserOrgVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.frontsys.front.domain.MenuStaffVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*import com.z5.zcms.admsys.user.dao.ZUserHisDAO;
import com.z5.zcms.admsys.module.domain.ZUserHisVo;*/

@Service
@Transactional
public class ZUserServiceImpl extends AbstractServiceImpl implements ZUserService {

    @Autowired
    private ZUserDAO zUserDAO;

/*	@Autowired
	private ZUserHisDAO zPopupHisDAO;*/

    public Integer listCount(ZUserVo zUserVo, String userOrAdmin) {
        if (userOrAdmin.equals("user")) {
            return this.zUserDAO.listCountUser(zUserVo);
        } else if (userOrAdmin.equals("org")) {
            return this.zUserDAO.getOrgUserListCount(zUserVo);
        } else {
            return this.zUserDAO.listCountAdmin(zUserVo);
        }
    }

    public List<ZUserVo> searchListUser(ZUserVo zUserVo) {
    	System.out.println("Check Select");
        return this.zUserDAO.searchListUser(zUserVo);
    }

    public List<ZUserOrgVo> orgSearchListUser(ZUserVo zUserVo) {
        return this.zUserDAO.orgSearchListUser(zUserVo);
    }

    public List<ZUserVo> getList(ZUserVo zUserVo, String userOrAdmin) {
        if (userOrAdmin.equals("user")) {
            return this.zUserDAO.getListUser(zUserVo);
        } else if (userOrAdmin.equals("org")) {
            return this.zUserDAO.getOrgUserList(zUserVo);
        } else {
            return this.zUserDAO.getListAdmin(zUserVo);
        }
    }

    public List<ZUserVo> getUsers() {
        return this.zUserDAO.getUsers();
    }

    public List<ZUserVo> getAllList(ZUserVo zUserVo) {
        return this.zUserDAO.getAllList(zUserVo);
    }

    @Transactional
    public void delete(List<Integer> arrDeleteNo) {
        // zPopup table 삭제
        this.zUserDAO.deleteAuth(arrDeleteNo);//권한을 먼저 삭제해야함
        this.zUserDAO.delete(arrDeleteNo);

        //해당 사용자에 대해 이전에 저장되어 있던 부가정보를 모두 삭제한다.
//        this.zUserDAO.deleteAlluserplus(arrDeleteNo);
//        this.zUserDAO.deleteAlluserlicens(arrDeleteNo);
//        this.zUserDAO.deleteAllusercareer(arrDeleteNo);
//        this.zUserDAO.deleteAlluseraward(arrDeleteNo);
//        this.zUserDAO.deleteAlluseracademic(arrDeleteNo);
//        this.zUserDAO.deleteAllusersociety(arrDeleteNo);

    }

    @Transactional
    public void delete(List<Integer> arrDeleteNo, String memType) {
        // KPA 단체회원, 기증회원은 Org User Table Record 추가 삭제
        if (memType.equals("org")) {
            this.zUserDAO.deleteAuth(arrDeleteNo);
            this.zUserDAO.delete(arrDeleteNo);
            this.zUserDAO.deleteOrgUser(arrDeleteNo);
        }
    }

    public ZUserVo selectbypk(ZUserVo vo) {
        return (ZUserVo) this.zUserDAO.selectbypk(vo);
    }

    @Transactional
    public void updateByAdmsys(ZUserVo zUserVo) {
        this.zUserDAO.updateByAdmsys(zUserVo);
    }

    public ZUserVo getInfo(ZUserVo vo) {
        return this.zUserDAO.getInfo(vo);
    }

    @Override
    public void updateAuthByAdmsys(ZUserVo zUserVo) {
        this.zUserDAO.updateAuthByAdmsys(zUserVo);

    }

    @Override
    public void add_admin_from_kfuser(String cs_id) {
        this.zUserDAO.add_admin_from_kfuser(cs_id);
    }

    @Override
    public void updateUserStatus(ZUserVo zUserVo) {
        this.zUserDAO.updateUserStatus(zUserVo);
    }

    public Integer selectVote(ZUserVo zUserVo) {
        return (Integer) this.zUserDAO.selectVote(zUserVo);
    }

    @Override
    public int listCountKF(MenuStaffVO MenuStaffVO) {
        return (Integer) this.zUserDAO.listCountKF(MenuStaffVO);
    }

    @Override
    public List<ZUserVo> getListKF(MenuStaffVO MenuStaffVO) {
        return this.zUserDAO.getListKF(MenuStaffVO);
    }

    @Override
    public MenuStaffVO getInfoKFUser(String cs_id) {
        return this.zUserDAO.getInfoKFUser(cs_id);
    }
    
    @Override
    public void updateUser(ZUserVo zUserVo) {
        this.zUserDAO.update(zUserVo);
    }
    
    @Override
    public void insertUser(ZUserVo zUserVo) {
        this.zUserDAO.insert(zUserVo);
    }

	@Override
	public void updateLogincount(String userid) {
		this.zUserDAO.updateLogincount(userid);
	}

	@Override
	public List<ZUserVo> getList2(ZUserVo zUserVo) {
		return this.zUserDAO.getListUser2(zUserVo);
	}
	
	/*@Transactional
	public void Write(ZUserVo zUserVo) {
		this.zPopupDAO.insert(zUserVo);
	}

	@Override
	public void popupWrite(ZUserVo zUserVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object popupDetail(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void popupDelete(List<Integer> arrDeleteNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void popupEdit(ZUserVo zUserVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAttach(ZUserVo zUserVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ZPopupHisVo> getPopupHisList(ZUserVo zUserVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void popupHisDelete(ZPopupHisVo zPopupHisVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer attachCount(String popupimg_org) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer attachCount(String popupimg_org) {
		return this.zPopupHisDAO.attachCount(popupimg_org);
	}
	@Transactional
	public void updateAttach(ZUserVo zUserVo){
		this.zPopupDAO.updateAttach(zUserVo);
	}

	public List<ZUserHisVo> getPopupHisList(ZUserVo zUserVo) {
		return this.zPopupHisDAO.list(zUserVo);
	}
	@Transactional
	public void popupHisDelete(ZUserHisVo zPopupHisVo) {
		this.zPopupHisDAO.delete(zPopupHisVo);
	}

	public Object popupDetail(Object obj) {

		if (obj instanceof ZUserHisVo) {
			// 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
			return this.zPopupHisDAO.detail((ZUserHisVo)obj);
		}
		else {
			return this.zPopupDAO.detail((ZUserVo)obj);
		}
	}
	@Transactional
	public void popupDelete(List<Integer> arrDeleteNo) {
		// zPopup table 삭제
		this.zPopupDAO.popupDelete(arrDeleteNo);
		// zPopupuse table 삭제
		this.zPopupDAO.popupUseDelete(arrDeleteNo);
		// zPopuphis table 삭제
		this.zPopupHisDAO.popupHisDelete(arrDeleteNo);
	}
	@Transactional
	public void popupEdit(ZUserVo zUserVo) {
		if ("1".equals(zUserVo.getHis())){
			// 새로운 히스토리 입력
			this.zPopupHisDAO.insert(zUserVo);
		}
		// 수정내용 갱신
		this.zPopupDAO.update(zUserVo);
	}*/
}
