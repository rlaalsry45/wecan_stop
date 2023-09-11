package com.z5.zcms.admsys.board.service;

import com.z5.zcms.admsys.board.dao.BoardDAO;
import com.z5.zcms.admsys.board.dao.ZBoardDAO;
import com.z5.zcms.admsys.board.dao.ZBoardGroupDAO;
import com.z5.zcms.admsys.board.dao.ZBoardRoleDAO;
import com.z5.zcms.admsys.board.domain.*;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.SecuritySessionUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class BoardServiceImpl extends AbstractServiceImpl implements BoardService {

    @Autowired
    MessageSource messageSource;
    @Autowired
    private ZBoardDAO zBoardDAO;
    @Autowired
    private ZBoardGroupDAO zBoardGroupDAO;
    @Autowired
    private ZBoardRoleDAO zBoardRoleDAO;
    @Autowired
    private BoardDAO	boardDAO;

    public ModelAndView boardList(DataTable dt) throws Exception {

        ModelAndView mav      = (ModelAndView) dt.getObject("mav");
        ZBoardVo     zBoardVo = (ZBoardVo) dt.getObject("zBoardVo");

        try {
            if (zBoardVo.getSdate().isEmpty() && zBoardVo.getEdate().isEmpty()) zBoardVo.setCond1("");
            if (zBoardVo.getKeyword().isEmpty()) zBoardVo.setCond2("");

            zBoardVo.setAdminno((Integer) dt.getRequest().getSession(false).getAttribute("authPassport") == null || (Integer) dt.getRequest().getSession(false).getAttribute("authPassport") == 0 ? "" : ((ZUserVo) SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());
            zBoardVo.setPageTotal(zBoardDAO.listCount(zBoardVo));

            mav.addObject("zBoardVo", zBoardVo)
               .addObject("list", zBoardDAO.list(zBoardVo));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }

    public ModelAndView boardCreateView(DataTable dt) throws Exception {

        ModelAndView mav = (ModelAndView) dt.getObject("mav");
        try {

            ZBoardVo zBoardVo = new ZBoardVo();

            zBoardVo.setBoarduseyn("1");
            zBoardVo.setTitlelen("80");
            zBoardVo.setShownew("24");
            zBoardVo.setUploadcnt("2");
            zBoardVo.setUploadbytes("50");
            zBoardVo.setType(dt.get("type", 1));
            zBoardVo.setSkintype(dt.get("skintype", 0));
            zBoardVo.setPagecnt("10");
            if (zBoardVo.getSkintype().equals("1")) {
                zBoardVo.setThumbnailw("40");
                zBoardVo.setThumbnailh("30");
                zBoardVo.setListimgw("200");
                zBoardVo.setListimgh("100");
            }

            List<ZBoardRoleVo> roleList  = zBoardRoleDAO.getRoleList();
            List<String>       role_no   = new ArrayList<String>();
            List<String>       role_l    = new ArrayList<String>();
            List<String>       role_v    = new ArrayList<String>();
            List<String>       role_w    = new ArrayList<String>();
            List<String>       role_m    = new ArrayList<String>();
            List<String>       role_d    = new ArrayList<String>();
            List<String>       role_m_nm = new ArrayList<String>();
            List<String>       role_r    = new ArrayList<String>();
            List<String>       role_c    = new ArrayList<String>();
            List<String>       role_n    = new ArrayList<String>();
            for (ZBoardRoleVo role : roleList) {
                //role_no.add(String.valueOf(role.getNo()));
                role_l.add(String.valueOf(role.getNo()));
                role_v.add(String.valueOf(role.getNo()));
                role_w.add(String.valueOf(role.getNo()));
                role_m.add(String.valueOf(role.getNo()));
                role_d.add(String.valueOf(role.getNo()));
                role_m_nm.add(String.valueOf(role.getNo()));
                role_r.add(String.valueOf(role.getNo()));
                role_c.add(String.valueOf(role.getNo()));
                role_n.add(String.valueOf(role.getNo()));
            }

            //그룹정보 추가 20180320 by 문영걸
            List<ZBoardGroupVo> grouplist = zBoardDAO.getBoardGrouplist(dt.getInt("boardno"));

            mav.addObject("zBoardVo", zBoardVo)
               .addObject("skinList", FileUtil.getSkinByType(EgovProperties.getPathProperty("Globals.skin.board") + (dt.get("skintype").equals("1") ? "photoGallery" : "common")))
               .addObject("boardList", zBoardDAO.listAll())
               .addObject("roleList", zBoardRoleDAO.getRoleList())
               .addObject("role_no", role_no)
               .addObject("role_l", role_l)
               .addObject("role_v", role_v)
               .addObject("role_w", role_w)
               .addObject("role_m", role_m)
               .addObject("role_d", role_d)
               .addObject("role_m_nm", role_m_nm)
               .addObject("role_r", role_r)
               .addObject("role_c", role_c)
               .addObject("role_n", role_n)
               .addObject("groupList", grouplist);


            //.addObject("groupList", zBoardDAO.boardGroupSel((Integer)dt.getRequest().getSession(false).getAttribute("authPassport")==0 ? "" : ((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserNo()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }

    public void boardCreate(DataTable dt) throws Exception {

        ZBoardVo zBoardVo = (ZBoardVo) dt.getObject("zBoardVo");

        try {
            String tblName = zBoardVo.getSkintype().equals("1") ? "ZBOARDPHOTOGALLERY" : "ZBOARDCOMMON";
            if (zBoardVo.getType().equals("1")) {
                HashMap<String, Object> hs = new HashMap<String, Object>();
                hs.put("seqName", tblName + "_SEQ");
                hs.put("skintype", zBoardVo.getSkintype());
                tblName += zBoardDAO.boardTableSeq(hs);
                if (FileUtil.createFolder(EgovProperties.getPathProperty("Globals.upload.board") + tblName.toLowerCase())) zBoardDAO.boardTableCreate(tblName);
            } else {
                tblName = dt.get("tblname");
            }

            zBoardVo.setUploadext(zBoardVo.getUploadext().replaceAll("\\s*", ""));
            zBoardVo.setTblname(tblName.toLowerCase());
            zBoardVo.setUserid(((ZUserVo) SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());
            if (zBoardVo.getSkintype().equals("1")) {
                zBoardVo.setThumbnailw(dt.get("thumbnailw", 40));
                zBoardVo.setThumbnailh(dt.get("thumbnailh", 30));
                zBoardVo.setListimgw(dt.get("listimgw", 200));
                zBoardVo.setListimgh(dt.get("listimgh", 100));
            }

            List<ZBoardAuthVo> authList = new ArrayList<ZBoardAuthVo>();
            for (String r : zBoardVo.getRole_no()) {
                ZBoardAuthVo zBoardAuthVo = new ZBoardAuthVo();
                zBoardAuthVo.setRole_no(Integer.parseInt(r));
                zBoardAuthVo.setRole_l(null == dt.getValues("role_l") ? "0" : (Arrays.binarySearch(dt.getValues("role_l"), r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_v(null == dt.getValues("role_v") ? "0" : (Arrays.binarySearch(dt.getValues("role_v"), r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_w(null == dt.getValues("role_w") ? "0" : (Arrays.binarySearch(dt.getValues("role_w"), r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_m(null == dt.getValues("role_m") ? "0" : (Arrays.binarySearch(dt.getValues("role_m"), r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_d(null == dt.getValues("role_d") ? "0" : (Arrays.binarySearch(dt.getValues("role_d"), r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_m_nm(null == dt.getValues("role_m_nm") ? "0" : (Arrays.binarySearch(dt.getValues("role_m_nm"), r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_r(null == dt.getValues("role_r") ? "0" : (Arrays.binarySearch(dt.getValues("role_r"), r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_c(null == dt.getValues("role_c") ? "0" : (Arrays.binarySearch(dt.getValues("role_c"), r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_n(null == dt.getValues("role_n") ? "0" : (Arrays.binarySearch(dt.getValues("role_n"), r) > -1 ? r : "0"));
                authList.add(zBoardAuthVo);
            }
            if (authList.size() > 0) zBoardVo.setAuthlist(authList);

            if (!dt.get("adminno").isEmpty()) {
                List<ZBoardAuthAdminVo> adminList = new ArrayList<ZBoardAuthAdminVo>();
                String[]                ids       = dt.get("adminno").replaceAll("<(.*?)>", "").split(",");
                for (String id : ids) {
                    ZBoardAuthAdminVo zBoardAuthAdminVo = new ZBoardAuthAdminVo();
                    zBoardAuthAdminVo.setUserno(zBoardDAO.boardUserno(id));
                    adminList.add(zBoardAuthAdminVo);
                }
                zBoardVo.setAdminlist(adminList);
            }
            zBoardVo.setBoardtitle(zBoardVo.getBoardtitle().trim());
            zBoardVo.setUserid(((ZUserVo) SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());
            zBoardVo.setEditoryn(dt.get("editoryn", "0"));
            zBoardVo.setCateyn(dt.get("cateyn", "0"));
            zBoardVo.setSecretyn(dt.get("secretyn", "0"));

            //파일업로드 금지 확장자 버그 수정 (제일앞에나 제일 마지막에 ,를 넣는 경우 이를 제거한다)
            if (!zBoardVo.getUploadext().equals("") && ",".equals((zBoardVo.getUploadext()).substring((zBoardVo.getUploadext()).length() - 1))) {
                zBoardVo.setUploadext((zBoardVo.getUploadext()).substring(0, (zBoardVo.getUploadext()).length() - 1));
            }

            zBoardDAO.boardCreate(zBoardVo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ModelAndView boardUpdateView(DataTable dt) throws Exception {

        ModelAndView mav = (ModelAndView) dt.getObject("mav");

        try {

            ZBoardVo zBoardVo = zBoardDAO.boardDetail(dt.getInt("boardno"));
            if (null != zBoardVo.getAdminlist()) {
                String[] array = new String[zBoardVo.getAdminlist().size()];
                for (ZBoardAuthAdminVo authAdminVo : zBoardVo.getAdminlist()) {
                    array[zBoardVo.getAdminlist().indexOf(authAdminVo)] = zBoardDAO.boardUserid(authAdminVo.getUserno()) + "<" + authAdminVo.getUsername() + ">";
                }
                zBoardVo.setAdminno(StringUtils.arrayToCommaDelimitedString(array));
            }
            zBoardVo.setGroupno_org(zBoardVo.getGroupno());
            if (zBoardVo.getSkintype().equals("1")) {
                zBoardVo.setThumbnailw(zBoardVo.getThumbnail().split("X")[0]);
                zBoardVo.setThumbnailh(zBoardVo.getThumbnail().split("X")[1]);
                zBoardVo.setListimgw(zBoardVo.getListimg().split("X")[0]);
                zBoardVo.setListimgh(zBoardVo.getListimg().split("X")[1]);
            }

            List<ZBoardAuthVo> authList = zBoardVo.getAuthlist();
            if (null != authList) {
                List<String> role_l_val    = new ArrayList<String>();
                List<String> role_v_val    = new ArrayList<String>();
                List<String> role_w_val    = new ArrayList<String>();
                List<String> role_m_val    = new ArrayList<String>();
                List<String> role_d_val    = new ArrayList<String>();
                List<String> role_m_nm_val = new ArrayList<String>();
                List<String> role_r_val    = new ArrayList<String>();
                List<String> role_c_val    = new ArrayList<String>();
                List<String> role_n_val    = new ArrayList<String>();
                for (ZBoardAuthVo authVo : authList) {
                    role_l_val.add(authVo.getRole_l());
                    role_v_val.add(authVo.getRole_v());
                    role_w_val.add(authVo.getRole_w());
                    role_m_val.add(authVo.getRole_m());
                    role_d_val.add(authVo.getRole_d());
                    role_m_nm_val.add(authVo.getRole_m_nm());
                    role_r_val.add(authVo.getRole_r());
                    role_c_val.add(authVo.getRole_c());
                    role_n_val.add(authVo.getRole_n());
                }
                zBoardVo.setRole_l(role_l_val);
                zBoardVo.setRole_v(role_v_val);
                zBoardVo.setRole_w(role_w_val);
                zBoardVo.setRole_m(role_m_val);
                zBoardVo.setRole_d(role_d_val);
                zBoardVo.setRole_m_nm(role_m_nm_val);
                zBoardVo.setRole_r(role_r_val);
                zBoardVo.setRole_c(role_c_val);
                zBoardVo.setRole_n(role_n_val);
            }

            List<ZBoardRoleVo> roleList  = zBoardRoleDAO.getRoleList();
            List<String>       role_l    = new ArrayList<String>();
            List<String>       role_v    = new ArrayList<String>();
            List<String>       role_w    = new ArrayList<String>();
            List<String>       role_m    = new ArrayList<String>();
            List<String>       role_d    = new ArrayList<String>();
            List<String>       role_m_nm = new ArrayList<String>();
            List<String>       role_r    = new ArrayList<String>();
            List<String>       role_c    = new ArrayList<String>();
            List<String>       role_n    = new ArrayList<String>();
            for (ZBoardRoleVo role : roleList) {
                //role_no.add(String.valueOf(role.getNo()));
                role_l.add(String.valueOf(role.getNo()));
                role_v.add(String.valueOf(role.getNo()));
                role_w.add(String.valueOf(role.getNo()));
                role_m.add(String.valueOf(role.getNo()));
                role_d.add(String.valueOf(role.getNo()));
                role_m_nm.add(String.valueOf(role.getNo()));
                role_r.add(String.valueOf(role.getNo()));
                role_c.add(String.valueOf(role.getNo()));
                role_n.add(String.valueOf(role.getNo()));
            }

            //그룹정보 추가 20180320 by 문영걸
            List<ZBoardGroupVo> grouplist = zBoardDAO.getBoardGrouplist(dt.getInt("boardno"));

            mav.addObject("zBoardVo", zBoardVo)
               .addObject("skinList", FileUtil.getSkinByType(EgovProperties.getPathProperty("Globals.skin.board") + (zBoardVo.getSkintype().equals("1") ? "photoGallery" : "common")))
               .addObject("roleList", roleList)
               .addObject("role_l", role_l)
               .addObject("role_v", role_v)
               .addObject("role_w", role_w)
               .addObject("role_m", role_m)
               .addObject("role_d", role_d)
               .addObject("role_m_nm", role_m_nm)
               .addObject("role_r", role_r)
               .addObject("role_c", role_c)
               .addObject("role_n", role_n)
               .addObject("groupList", grouplist);
//			List<ZBoardGroupVo> zBoardGroupList = new ArrayList<ZBoardGroupVo>();
//			if ((Integer)dt.getRequest().getSession(false).getAttribute("authPassport")==2){
//				ZBoardGroupVo zBoardGroupVo = new ZBoardGroupVo();
//				zBoardGroupVo.setGroupno((Integer) mav.getModel().get("groupno"));
//				zBoardGroupVo.setGroupnm(String.valueOf(mav.getModel().get("groupnm")));
//				zBoardGroupList.add(zBoardGroupVo);
//			}
//			else{
//				zBoardGroupList = zBoardDAO.boardGroupSel((Integer)dt.getRequest().getSession(false).getAttribute("authPassport")==0 ? "" : ((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserNo());
//			}
            //mav.addObject("groupList", zBoardGroupList);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


        return mav;
    }

    public void boardUpdate(DataTable dt) throws Exception {

        ZBoardVo zBoardVo = (ZBoardVo) dt.getObject("zBoardVo");

        try {

            zBoardVo.setBoardtitle(zBoardVo.getBoardtitle().trim());

            zBoardVo.setUploadext(zBoardVo.getUploadext().replaceAll("\\s*", ""));
            zBoardVo.setUserid(((ZUserVo) SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());
            zBoardVo.setGroupno(zBoardVo.getGroupno());
            zBoardVo.setGroupno_org(zBoardVo.getGroupno_org());

            List<ZBoardAuthVo> authList = new ArrayList<ZBoardAuthVo>();

            //Arrays.binarySearch 기본 개념(이진검색)에 따른 수정 김문석 20140930
            String[] role_l    = dt.getValues("role_l");
            String[] role_v    = dt.getValues("role_v");
            String[] role_w    = dt.getValues("role_w");
            String[] role_m    = dt.getValues("role_m");
            String[] role_d    = dt.getValues("role_d");
            String[] role_m_nm = dt.getValues("role_m_nm");
            String[] role_r    = dt.getValues("role_r");
            String[] role_c    = dt.getValues("role_c");
            String[] role_n    = dt.getValues("role_n");
            if (role_l != null) {
                Arrays.sort(role_l);
            } else if (role_v != null) {
                Arrays.sort(role_v);
            } else if (role_w != null) {
                Arrays.sort(role_w);
            } else if (role_m != null) {
                Arrays.sort(role_m);
            } else if (role_d != null) {
                Arrays.sort(role_d);
            } else if (role_m_nm != null) {
                Arrays.sort(role_m_nm);
            } else if (role_r != null) {
                Arrays.sort(role_r);
            } else if (role_c != null) {
                Arrays.sort(role_c);
            } else if (role_n != null) {
                Arrays.sort(role_n);
            }
            //Arrays.binarySearch 기본 개념(이진검색)에 따른 수정 김문석 20140930

            for (String r : zBoardVo.getRole_no()) {
                ZBoardAuthVo zBoardAuthVo = new ZBoardAuthVo();
                zBoardAuthVo.setRole_no(Integer.parseInt(r));
                zBoardAuthVo.setRole_l(null == dt.getValues("role_l") ? "0" : (Arrays.binarySearch(role_l, r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_v(null == dt.getValues("role_v") ? "0" : (Arrays.binarySearch(role_v, r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_w(null == dt.getValues("role_w") ? "0" : (Arrays.binarySearch(role_w, r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_m(null == dt.getValues("role_m") ? "0" : (Arrays.binarySearch(role_m, r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_d(null == dt.getValues("role_d") ? "0" : (Arrays.binarySearch(role_d, r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_m_nm(null == dt.getValues("role_m_nm") ? "0" : (Arrays.binarySearch(role_m_nm, r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_r(null == dt.getValues("role_r") ? "0" : (Arrays.binarySearch(role_r, r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_c(null == dt.getValues("role_c") ? "0" : (Arrays.binarySearch(role_c, r) > -1 ? r : "0"));
                zBoardAuthVo.setRole_n(null == dt.getValues("role_n") ? "0" : (Arrays.binarySearch(role_n, r) > -1 ? r : "0"));
                authList.add(zBoardAuthVo);
            }
            if (authList.size() > 0) zBoardVo.setAuthlist(authList);

            List<ZBoardAuthAdminVo> adminList = new ArrayList<ZBoardAuthAdminVo>();
            if (!dt.get("adminno").isEmpty()) {
                String[] ids = dt.get("adminno").replaceAll("<(.*?)>", "").split(",");
                for (String id : ids) {
                    ZBoardAuthAdminVo zBoardAuthAdminVo = new ZBoardAuthAdminVo();
                    zBoardAuthAdminVo.setUserno(zBoardDAO.boardUserno(id));
                    adminList.add(zBoardAuthAdminVo);
                }
            }
            zBoardVo.setAdminlist(adminList);

            if (zBoardVo.getSkintype().equals("1")) {
                zBoardVo.setThumbnailw(dt.get("thumbnailw", 40));
                zBoardVo.setThumbnailh(dt.get("thumbnailh", 30));
                zBoardVo.setListimgw(dt.get("listimgw", 200));
                zBoardVo.setListimgh(dt.get("listimgh", 100));
            }

            zBoardVo.setEditoryn(dt.get("editoryn", "0"));
            zBoardVo.setCateyn(dt.get("cateyn", "0"));
            zBoardVo.setSecretyn(dt.get("secretyn", "0"));
            //파일업로드 금지 확장자 버그 수정 (제일앞에나 제일 마지막에 ,를 넣는 경우 이를 제거한다)
            if (!zBoardVo.getUploadext().equals("") && ",".equals((zBoardVo.getUploadext()).substring((zBoardVo.getUploadext()).length() - 1))) {
                zBoardVo.setUploadext((zBoardVo.getUploadext()).substring(0, (zBoardVo.getUploadext()).length() - 1));
            }

            zBoardVo.setGroupno_dest(dt.getValues("groupno_dest"));

            zBoardDAO.boardUpdate(zBoardVo);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public ModelAndView boardAdminList(DataTable dt) throws Exception {

        ModelAndView mav = (ModelAndView) dt.getObject("mav");

        mav.addObject("adminList", zBoardDAO.boardAdminList());

        return mav;
    }

    public ModelAndView boardDelete(DataTable dt) throws Exception {

        ModelAndView mav = (ModelAndView) dt.getObject("mav");

        String[]      keys        = dt.getValues("boardno");
        List<Integer> arrDeleteNo = new ArrayList<Integer>();

        for (String key : keys) {
            String[] items = key.split("\\^");
            arrDeleteNo.add(Integer.parseInt(items[0]));
            if (zBoardDAO.boardDupCheck(items[1]) == 1) {
                FileUtil.deleteFolder(EgovProperties.getPathProperty("Globals.upload.board") + items[1].toUpperCase());
                zBoardDAO.boardTableDrop(items[1]);
            }
        }

        if (arrDeleteNo.size() > 0) {
            zBoardDAO.boardDelete(arrDeleteNo);
        }

        return mav;
    }

    public ModelAndView boardCopyView(DataTable dt) throws Exception {

        ModelAndView mav      = (ModelAndView) dt.getObject("mav");
        ZBoardVo     zBoardVo = new ZBoardVo();

        zBoardVo.setBoardno(dt.getInt("boardno"));

        mav.addObject("zBoardVo", zBoardVo);

        return mav;
    }

    @Transactional
    public void boardCopy(DataTable dt) throws Exception {

        try {
            ZBoardVo                zBoardVo = (ZBoardVo) dt.getObject("zBoardVo");
            String                  tblName  = zBoardDAO.boardTableName(dt.getInt("boardno")).replaceAll("[0-9]*", "").toUpperCase();
            HashMap<String, Object> hs       = new HashMap<String, Object>();
            hs.put("seqName", tblName + "_SEQ");
            hs.put("skintype", tblName.equals("ZBOARDPHOTOGALLERY") ? "1" : "0");

            tblName += zBoardDAO.boardTableSeq(hs);
            if (FileUtil.createFolder(EgovProperties.getProperty("Globals.upload.board") + tblName)) {
                zBoardDAO.boardTableCreate(tblName);
                zBoardVo.setTblname(tblName.toLowerCase());
                zBoardVo.setBoardno_org(dt.getInt("boardno"));
                zBoardVo.setUserid(((ZUserVo) SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());
                zBoardDAO.boardCopy(zBoardVo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	@Override
	public void insertBoard(BoardVO boardVO) {
		boardDAO.insertBoard(boardVO);
	}

	@Override
	public void insertBoardFile(BoardVO boardVO) {
		boardDAO.insertBoardFile(boardVO);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO boardVO) {
		return boardDAO.getBoardList(boardVO);
	}

	@Override
	public List<BoardVO> getBoardCounselorDay(BoardVO boardVO) {
		return boardDAO.getBoardCounselorDay(boardVO);
	}
}
