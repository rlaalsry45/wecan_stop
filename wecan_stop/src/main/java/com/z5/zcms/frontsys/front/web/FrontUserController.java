package com.z5.zcms.frontsys.front.web;

import com.z5.zcms.admsys.authority.service.ZAuthorityService;
import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserLogService;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.StringUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/front/user/"})
public class FrontUserController {

    @Autowired
    ZUserService zUserService;
    
    @Autowired
    ZUserLogService zUserLogService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ZAuthorityService zAuthorityService;

    @Autowired
    ZUserDAO zUserDAO;


    @RequestMapping("popupUserList.html")
    public String index(
        @ModelAttribute("zUserVo") ZUserVo zUserVo
        , Model model, HttpServletRequest req) throws Exception {

        if (!(SecuritySessionUtil.isAuth(req, "ROLE_USER")
            || SecuritySessionUtil.isAuth(req, "ROLE_ADMIN")
            || SecuritySessionUtil.isAuth(req, "ROLE_SUPER")
            || req.getSession().getAttribute("niceName") != null)

            ) {
            model.addAttribute("noauth", "true");
            return "/zcms/frontsys/user/popupUserList";
        }

        try {
            DataTable input    = new DataTable(req);
            int       pageSize = input.getInt("pageSize", 50);
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex = input.getInt("pageIndex") - 1;
            String sdate     = input.get("sdate");
            String edate     = input.get("edate");
            String keyword   = input.get("keyword");
            int    m         = pageIndex * pageSize;
            int    n         = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                zUserVo.setCond1("");
            } else {
                zUserVo.setCond1(input.get("cond1"));
            }
            if (keyword.equals("")) {
                zUserVo.setCond2("");
            } else {
                zUserVo.setCond2(input.get("cond2"));
            }
            /*if(enabledvalue.equals("")){
				zUserVo.setCond3("");
			}else{
				zUserVo.setCond3("enabled");
			}*/
			/*if(sitedivision.equals("")){
				zUserVo.setCond4("");
			}else{
				zUserVo.setCond4("sitedivision");
			}*/
			/*if(authoritysearch.equals("")){ //관리자일 경우 값을 지정해준다.
				zUserVo.setCond5("");
			}else{
				if(authoritysearch.equals("10")){
					authoritysearch ="ROLE_ADMIN_HOME";
				}else if(authoritysearch.equals("20")){
					authoritysearch ="ROLE_ADMIN_CENTER";
				}
				zUserVo.setCond5("authoritysearch");
			}*/

            zUserVo.setSdate(input.get("sdate"));
            zUserVo.setEdate(input.get("edate"));
            zUserVo.setKeyword(input.get("keyword"));
            zUserVo.setUserstatus(input.get("userstatus"));
			/*zUserVo.setEnabled(enabled);*/
			/*zUserVo.setCond5(authoritysearch);*/
            zUserVo.setM(m);
            zUserVo.setN(n);

            int total = this.zUserService.listCount(zUserVo, "user");//일반유저와 동일한 쿼리를 사용하지만 setAuthority에 ROLE_ADMIN을 넣으면 관리자 목록만 뽑아온다
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<ZUserVo> list = this.zUserService.getList(zUserVo, "user");

            model.addAttribute("list", list);
            model.addAttribute("input", input);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "/zcms/frontsys/popup/popupUserList";
    }

    @RequestMapping("popupUserListForJoin.html")
    public String popupUserListForJoin(
        @ModelAttribute("zUserVo") ZUserVo zUserVo
        , Model model, HttpServletRequest req) throws Exception {

        if (!(SecuritySessionUtil.isAuth(req, "ROLE_USER")
            || SecuritySessionUtil.isAuth(req, "ROLE_ADMIN")
            || SecuritySessionUtil.isAuth(req, "ROLE_SUPER")
            || req.getSession().getAttribute("niceName") != null)

            ) {
            model.addAttribute("noauth", "true");
            return "/zcms/frontsys/user/popupUserListForJoin";
        }

        try {
            DataTable input    = new DataTable(req);
            int       pageSize = input.getInt("pageSize", 50);
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex = input.getInt("pageIndex") - 1;
            String sdate     = input.get("sdate");
            String edate     = input.get("edate");
            String keyword   = input.get("keyword");
            int    m         = pageIndex * pageSize;
            int    n         = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                zUserVo.setCond1("");
            } else {
                zUserVo.setCond1(input.get("cond1"));
            }
            if (keyword.equals("")) {
                zUserVo.setCond2("");
            } else {
                zUserVo.setCond2(input.get("cond2"));
            }
			/*if(enabledvalue.equals("")){
				zUserVo.setCond3("");
			}else{
				zUserVo.setCond3("enabled");
			}*/
			/*if(sitedivision.equals("")){
				zUserVo.setCond4("");
			}else{
				zUserVo.setCond4("sitedivision");
			}*/
			/*if(authoritysearch.equals("")){ //관리자일 경우 값을 지정해준다.
				zUserVo.setCond5("");
			}else{
				if(authoritysearch.equals("10")){
					authoritysearch ="ROLE_ADMIN_HOME";
				}else if(authoritysearch.equals("20")){
					authoritysearch ="ROLE_ADMIN_CENTER";
				}
				zUserVo.setCond5("authoritysearch");
			}*/

            zUserVo.setSdate(input.get("sdate"));
            zUserVo.setEdate(input.get("edate"));
            zUserVo.setKeyword(input.get("keyword"));
            zUserVo.setUserstatus(input.get("userstatus"));
			/*zUserVo.setEnabled(enabled);*/
			/*zUserVo.setCond5(authoritysearch);*/
            zUserVo.setM(m);
            zUserVo.setN(n);

            int total = this.zUserService.listCount(zUserVo, "user");//일반유저와 동일한 쿼리를 사용하지만 setAuthority에 ROLE_ADMIN을 넣으면 관리자 목록만 뽑아온다
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<ZUserVo> list = this.zUserService.getList(zUserVo, "user");
            for (int i = 0; list.size() > i; i++) {
                String hiddenUsername = list.get(i).getUsername();
                hiddenUsername = hiddenUsername.substring(0, 1) + "*" + hiddenUsername.substring(2, hiddenUsername.length());
                list.get(i).setUsername(hiddenUsername);
            }

            model.addAttribute("list", list);
            model.addAttribute("input", input);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "/zcms/frontsys/popup/popupUserListForJoin";
    }

    // 회원탈퇴
    @RequestMapping(value = "memberout.html", method = RequestMethod.GET)
    public String memberout(
        HttpServletRequest req, Model model,
        HttpSession session)
        throws Exception {

        try {
            ZUserVo vo = new ZUserVo();
            vo = (ZUserVo) session.getAttribute("zUserVo");

            if (vo == null || vo.equals("")) {
                model.addAttribute("nologin", "nologin");
            }

            model.addAttribute("user", vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/user/common/memberout";
    }

    // 영문사이트 회원탈퇴
    @RequestMapping(value = "memberout_foreigner.html", method = RequestMethod.GET)
    public String memberout_foreigner(
        HttpServletRequest req, Model model,
        HttpSession session)
        throws Exception {

        try {
            ZUserVo vo = new ZUserVo();
            vo = (ZUserVo) session.getAttribute("zUserVo");

            if (vo == null || vo.equals("")) {
                model.addAttribute("nologin", "nologin");
            }

            model.addAttribute("user", vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/user/common/memberout_foreigner";
    }

    @ResponseBody
    @RequestMapping("memberoutchk.html")
    public String memberout_confirm(
        @RequestParam(value = "pass", required = false) String pass,
        HttpServletRequest req,
        HttpSession session) throws Exception {

        try {
            ZUserVo zUserVo = new ZUserVo();
            zUserVo = (ZUserVo) session.getAttribute("zUserVo");
            String userpass    = zUserVo.getUserpasswd();
            String inputpasswd = passwordEncoder.encodePassword(pass, null);

            if (userpass.equals(inputpasswd)) {
                zUserVo.setUseroutreason(req.getParameter("cancelreason"));
                zUserDAO.updateuseroutrequestToZero(zUserVo);
                session.invalidate();
                return "success";
            } else {
                return "nopass";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";

    }

    @RequestMapping(value = "checkpage.html", method = RequestMethod.GET)
    public String checkpage(
        HttpServletRequest req, Model model,
        HttpSession session)
        throws Exception {

        try {
            session.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/user/common/checkpage";
    }
    
    @RequestMapping(value = "joinUserResult.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> joinUserResult(HttpServletRequest req, HttpSession session, Model model) throws Exception {

    	Map<String,Object> map = new HashMap<String,Object>();
        try {
    		ZUserVo zUserVO = new ZUserVo();
    		zUserVO.setUserid(req.getParameter("userid"));
    		zUserVO.setUserpasswd(passwordEncoder.encodePassword(req.getParameter("passwd"), null));
    		zUserVO.setUserstatus("1");
    		if("1".equals(req.getParameter("userGubun"))) {
    			zUserVO.setUserauth("1");	// 1:담당관
    		}else {
    			zUserVO.setUserauth("5");	// 5:담당자
    		}
    		zUserVO.setUsername(req.getParameter("username"));
    		zUserVO.setUseremail(req.getParameter("email"));
    		zUserVO.setUsermobile(req.getParameter("mobile").replaceAll("-", ""));
    		zUserVO.setEnabled("1");
    		zUserVO.setChargeorgid(session.getAttribute("ORGANIZATION_ID").toString());
    		zUserVO.setAgreeyn(req.getParameter("agree_check"));
    		zUserService.insertUser(zUserVO);
    		
    		if("1".equals(req.getParameter("userGubun"))) {
    			zAuthorityService.addZauthorities(zUserVO);
    		}
    		
    		map.put("userid", zUserVO.getUserid());
    		map.put("resultCode", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
    
    @RequestMapping(value = "findUseridResult.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findUseridResult(HttpServletRequest req, HttpSession session, Model model) throws Exception {

    	Map<String,Object> map = new HashMap<String,Object>();
        try {

    		ZUserVo zUserVo = new ZUserVo();
    		zUserVo.setUsername(req.getParameter("username"));
    		zUserVo.setUseremail(req.getParameter("email"));
    		zUserVo.setUserauth(req.getParameter("userauth"));
    		ZUserVo zUserVORes = zUserService.getInfo(zUserVo);

			if(zUserVORes != null && !StringUtil.isEmpty(zUserVORes.getUserid())) {
				map.put("userid", zUserVORes.getUserid());
				map.put("resultCode", "success");
			}else {
				map.put("resultCode", "error");
    			map.put("resultMsg", "아이디를 찾을 수 없습니다.");
			}
    		
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
    
    @RequestMapping(value = "duplicationConfirm.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> duplicationConfirm(HttpServletRequest req, HttpSession session, Model model) throws Exception {

    	Map<String,Object> map = new HashMap<String,Object>();
        try {

    		ZUserVo zUserVOReq = new ZUserVo();
    		zUserVOReq.setUserid(req.getParameter("userid"));
    		zUserVOReq.setUserauth(req.getParameter("userauth"));
    		ZUserVo zUserVORes = zUserService.getInfo(zUserVOReq);

    		if(zUserVORes != null && !StringUtil.isEmpty(zUserVORes.getUserid())) {
    			map.put("resultCode", "error");
    			map.put("resultMsg", "사용할 수 없는 아이디입니다.");
    		}else {
    			map.put("resultCode", "success");
    			map.put("resultMsg", "사용할 수 있는 아이디입니다.");
    		}
    		
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
    
    @RequestMapping(value = "findPasswdResult.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findPasswdResult(HttpServletRequest req, HttpSession session, Model model) throws Exception {

    	Map<String,Object> map = new HashMap<String,Object>();
        try {

    		ZUserVo zUserVo = new ZUserVo();
    		zUserVo.setUserid(req.getParameter("userid"));
    		zUserVo.setUserauth(req.getParameter("userauth"));
    		ZUserVo zUserVORes = zUserService.getInfo(zUserVo);

    		if(zUserVORes != null && !StringUtil.isEmpty(zUserVORes.getUserid())) {	
    			zUserVo.setUserpasswd(passwordEncoder.encodePassword(req.getParameter("passwd"), null));
        		zUserService.updateUser(zUserVo);
        		
        		zUserVo.setCnt(0);
             	zUserLogService.updateCnt(zUserVo);
        		
        		map.put("resultCode", "success");
    		}else {
    			map.put("resultCode", "error");
    			map.put("resultMsg", "등록되지 않은 아이디입니다. 회원가입을 해주세요.");
    		}
    		
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
    
    @RequestMapping(value = "modUserResult.html", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modUserResult(HttpServletRequest req, HttpSession session, Model model) throws Exception {

    	Map<String,Object> map = new HashMap<String,Object>();
        try {
    		ZUserVo zUserVO = new ZUserVo();
    		zUserVO.setUserid(req.getParameter("userid"));
    		if(!StringUtils.isEmpty(req.getParameter("passwd"))) {
    			zUserVO.setUserpasswd(passwordEncoder.encodePassword(req.getParameter("passwd"), null));
    		}
    		zUserVO.setUsername(req.getParameter("username"));
    		zUserVO.setUseremail(req.getParameter("email"));
    		zUserVO.setUsermobile(req.getParameter("mobile").replaceAll("-", ""));
    		zUserService.updateUser(zUserVO);
    		
    		map.put("userid", zUserVO.getUserid());
    		map.put("resultCode", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
    
    
}

