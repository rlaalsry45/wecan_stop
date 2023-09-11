package com.z5.zcms.admsys.auth.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.auth.dao.AuthDAO;
import com.z5.zcms.admsys.auth.domain.Auth;
import com.z5.zcms.admsys.auth.domain.AuthVo;
import com.z5.zcms.admsys.auth.domain.GAuth;
import com.z5.zcms.admsys.auth.domain.GAuthEmp;
import com.z5.zcms.admsys.auth.domain.GAuthVo;
import com.z5.zcms.admsys.auth.service.AuthService;
import com.z5.zcms.admsys.auth.service.GAuthService;
import com.z5.zcms.admsys.authority.dao.ZAuthorityDAO;
import com.z5.zcms.admsys.authority.domain.ZAuthoritiesVO;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.site.service.ZsiteService;
import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

import egovframework.com.cmm.service.EgovProperties;

import static com.z5.zcms.property.ZCMSProperties.adminPage;

@Controller
@RequestMapping("/admsys/setting/auth/")
public class AuthController {
    @Autowired
    ZUserService zUserService;
    @Autowired
    private ZsiteService zSiteService;
    @Autowired
    AuthService   authService;
    @Autowired
    ZAuthorityDAO zAuthorityDAO;
    @Autowired
    AuthDAO       authDAO;
    @Autowired
    private GAuthService gAuthService;
    @Autowired
    ZUserDAO        zUserDAO;
    @Autowired
    PasswordEncoder passwordEncoder;

    private final Logger log = Logger.getLogger(this.getClass());

    private final String RETURN_URL = "/zcms/admsys/setting/auth/";

    @RequestMapping("list.html")
    public String list(@ModelAttribute("gAuthEmp") GAuthEmp authEmp, Model model, HttpServletRequest req) throws Exception {
        try {
            List<GAuthEmp> hqList = authService.hqList();
            model.addAttribute("hqlist", hqList);
            if (null != req.getParameter("hq_cd") && !req.getParameter("hq_cd").isEmpty()) {
                authEmp.setHq_cd(req.getParameter("hq_cd"));
                List<GAuthEmp> deptlist = authService.deptList(authEmp);
                model.addAttribute("deptlist", deptlist);
            }

            if (null != req.getParameter("hq_cd") && !req.getParameter("hq_cd").isEmpty()) {
                authEmp.setHq_cd(req.getParameter("hq_cd"));
            }
            if (null != req.getParameter("dept_cd") && !req.getParameter("dept_cd").isEmpty()) {
                authEmp.setDept_cd(req.getParameter("dept_cd"));
            }
            if (null != req.getParameter("keyword") && !req.getParameter("keyword").trim().isEmpty()) {
                authEmp.setKeyword(req.getParameter("keyword").trim());
            }

            DataTable input    = new DataTable(req);
            int       pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int pageIndex = input.getInt("pageIndex") - 1;
            authEmp.setM(pageIndex * pageSize);
            authEmp.setN(pageSize);

            int total = authService.listCount(authEmp);
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));
            authEmp.setCond2(EgovProperties.getProperty("Globals.default.groupno"));

            List<GAuthEmp> list = authService.authEmpList(authEmp);
            model.addAttribute("input", input);
            model.addAttribute("hq_cd", req.getParameter("hq_cd"));
            model.addAttribute("dept_cd", req.getParameter("dept_cd"));
            model.addAttribute("keyword", req.getParameter("keyword"));
            model.addAttribute("list", list);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return adminPage(req);
    }

    @RequestMapping("index.html")
    public String index(@ModelAttribute("authVo") AuthVo authVo, Model model, HttpServletRequest req) throws Exception {
        try {
            List<ZsiteVo> sitelist = zSiteService.getListAll();
            if (null != sitelist) {
                authVo.setSiteno(authVo.getSiteno() == 0 ? sitelist.get(0).getSiteno() : authVo.getSiteno());
                List<AuthVo> list = authService.authList(authVo);

                model.addAttribute("siteno", authVo.getSiteno());
                model.addAttribute("sitelist", sitelist);
                model.addAttribute("list", list);
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return adminPage(req);
    }

    @RequestMapping(value = "update.html", method = RequestMethod.GET)
    public String updateGetter(@RequestParam int userno, HttpServletRequest req, Model model) throws Exception {
        try {
            log.debug("update-get");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return adminPage(req);
    }

    @RequestMapping(value = "update.html", method = RequestMethod.POST)
    public String updatePoster(@ModelAttribute("authVo") AuthVo authVo, HttpServletRequest req, Model model) throws Exception {
        try {
            log.debug("update-post");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "redirect:/admsys/setting/auth/index.html";
    }

    @RequestMapping("authDelete.html")
    public String delete(HttpServletRequest req) throws Exception {

        try {
            Auth   auth   = new Auth();
            int    siteno = Integer.parseInt(req.getParameter("siteno"));
            String no     = req.getParameter("no");
            if (null != req.getParameter("flag")) {
                auth.setSiteno(siteno);
                auth.setMenuno(Integer.parseInt(req.getParameter("menuno")));
                String       flag        = req.getParameter("flag");
                List<String> subMenuList = authService.authSubMenuList(auth);
                for (int j = 0; j < subMenuList.size(); j++) {
                    auth.setMenuno(Integer.parseInt(subMenuList.get(j)));
                    auth.setSiteno(siteno);
                    if (flag.equals("G")) auth.setGroupno(Integer.parseInt(no));
                    else auth.setAuth_no(no);
                    authService.authMutiDelete(auth);
                }
            } else {
                auth.setNo(Integer.parseInt(no));
                authService.authDelete(auth);
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "redirect:/admsys/setting/auth/index.html?menunos=" + req.getParameter("menunos") + "&opens=" + req.getParameter("opens") + "&siteno=" + req.getParameter("siteno");
    }

    @RequestMapping(value = "searchGroup.html", method = RequestMethod.GET)
    public String searchGroup(@ModelAttribute("gAuthVo") GAuthVo gAuthVo, Model model, HttpServletRequest req) throws Exception {
        try {
            gAuthVo.setCond2(EgovProperties.getProperty("Globals.default.groupno"));
            List<GAuthVo> list = gAuthService.gAuthList(gAuthVo);
            model.addAttribute("list", list);
            model.addAttribute("menunos", req.getParameter("menunos"));
            model.addAttribute("siteno", req.getParameter("siteno"));
            model.addAttribute("opens", req.getParameter("opens"));
            model.addAttribute("urlnos", req.getParameter("urlnos"));
            model.addAttribute("defaultGroupno", EgovProperties.getProperty("Globals.default.groupno"));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return adminPage(req);
    }

    @RequestMapping(value = "selGroup.html", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> selGroup(HttpServletRequest req) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            GAuth gAuth = new GAuth();
            if (null != req.getParameter("menunos") && !req.getParameter("menunos").isEmpty()) {
                int      siteno   = Integer.parseInt(req.getParameter("siteno"));
                String[] groupnos = req.getParameter("groupnos").split(",");
                String[] menunos  = req.getParameter("menunos").split(",");
                for (int i = 0; i < menunos.length; i++) {
                    gAuth.setMenuno(Integer.parseInt(menunos[i].split("_")[1]));
                    gAuth.setSiteno(siteno);
                    gAuth.setUserid(SecuritySessionUtil.getUserid(req));
                    for (int k = 0; k < groupnos.length; k++) {
                        gAuth.setGroupno(Integer.parseInt(groupnos[k]));
                        gAuthService.gAuthSetGroup(gAuth);
                    }
                }
            }
            if (null != req.getParameter("urlnos") && !req.getParameter("urlnos").isEmpty()) {
                String[] groupnos = req.getParameter("groupnos").split(",");
                String[] urlnos   = req.getParameter("urlnos").split(",");
                for (int i = 0; i < urlnos.length; i++) {
                    gAuth.setUrlno(Integer.parseInt(urlnos[i].split("_")[1]));
                    gAuth.setUserid(SecuritySessionUtil.getUserid(req));
                    for (int k = 0; k < groupnos.length; k++) {
                        gAuth.setGroupno(Integer.parseInt(groupnos[k]));
                        gAuthService.gAuthAdminSetGroup(gAuth);
                    }
                }
            }

            map.put("result", "success");

        } catch (Exception e) {
            map.put("result", "failed");
            log.error(e.getMessage());
        }
        return map;
    }

    @RequestMapping("selAuth.html")
    public @ResponseBody
    Map<String, Object> selAuth(HttpServletRequest req) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Auth auth = new Auth();

            if (null != req.getParameter("menunos") && !req.getParameter("menunos").isEmpty()) {
                int      siteno   = Integer.parseInt(req.getParameter("siteno"));
                String[] auth_nos = req.getParameter("auth_nos").split(",");
                String[] menunos  = req.getParameter("menunos").split(",");
                for (int i = 0; i < menunos.length; i++) {
                    auth.setMenuno(Integer.parseInt(menunos[i].split("_")[1]));
                    auth.setSiteno(siteno);
                    auth.setUserid(SecuritySessionUtil.getUserid(req));
                    for (int k = 0; k < auth_nos.length; k++) {
                        auth.setAuth_no(auth_nos[k]);
                        authService.authListSel(auth);
                    }
                }
            }
            if (null != req.getParameter("urlnos") && !req.getParameter("urlnos").isEmpty()) {
                String[] auth_nos = req.getParameter("auth_nos").split(",");
                String[] urlnos   = req.getParameter("urlnos").split(",");
                for (int i = 0; i < urlnos.length; i++) {
                    auth.setUrlno(Integer.parseInt(urlnos[i].split("_")[1]));
                    auth.setUserid(SecuritySessionUtil.getUserid(req));
                    for (int k = 0; k < auth_nos.length; k++) {
                        auth.setAuth_no(auth_nos[k]);
                        authService.authAdminListSel(auth);
                    }
                }
            }

            map.put("result", "success");

        } catch (Exception e) {
            map.put("result", "failed");
            log.error(e.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "getDept.html", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getDept(HttpServletRequest req) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            GAuthEmp gAuthEmp = new GAuthEmp();
            gAuthEmp.setHq_cd(req.getParameter("hq_cd"));

            List<GAuthEmp> deptlist = authService.deptList(gAuthEmp);

            map.put("deptlist", deptlist);
            map.put("result", "success");

        } catch (Exception e) {
            map.put("result", "failed");
            log.error(e.getMessage());
        }
        return map;
    }

    @Transactional
    @RequestMapping("delete.html")
    public String delete(
            Model model,
            @RequestParam("userno") int[] userno,
            @ModelAttribute("zUserVo") ZUserVo zUserVo, BindingResult err, HttpServletRequest req
    ) throws Exception {

        List<Integer> arrDeleteNo = new ArrayList<Integer>(userno.length);
        for (int value : userno) {
            arrDeleteNo.add(value);
        }

        zUserService.delete(arrDeleteNo);//service에서 authoirity도 함께 삭제
        zAuthorityDAO.deleteAuth_emp(arrDeleteNo);

        return "redirect:/admsys/setting/auth/list.html";
    }


    @RequestMapping(value = "regAuth.html", method = RequestMethod.GET)
    public String createGroupGetter() throws Exception {
        return RETURN_URL + "regAuth";
    }

    @RequestMapping(value = "regAuth.html", method = RequestMethod.POST)
    public String createGroupPoster(@ModelAttribute("gAuthEmp") GAuthEmp gAuthEmp, Model model, HttpServletRequest req) throws Exception {
        DataTable input = new DataTable(req);

        try {
            authDAO.insertEmp(gAuthEmp);

            ZAuthoritiesVO vo = new ZAuthoritiesVO();
            vo.setUserid(gAuthEmp.getEmp_id());
            vo.setAuthority("ROLE_ADMIN");
            zAuthorityDAO.addAuthories(vo);

            model.addAttribute("insert", "true");
            model.addAttribute("input", input);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return adminPage(req);
    }

    @RequestMapping("userList.html")
    public String index(@ModelAttribute("zUserVo") ZUserVo zUserVo, Model model, HttpServletRequest req) throws Exception {

        if (!(SecuritySessionUtil.isAuth(req, "ROLE_USER")
                || SecuritySessionUtil.isAuth(req, "ROLE_ADMIN")
                || SecuritySessionUtil.isAuth(req, "ROLE_SUPER")
                || req.getSession().getAttribute("niceName") != null)) {
            model.addAttribute("noauth", "true");
            return "/zcms/frontsys/user/popupUserList";
        }

        try {
            DataTable input = new DataTable(req);

            if (input.get("cond10").equals("admin")) {
                zUserVo.setAuthority("ROLE_ADMIN");
                input.put("authority", "관리자");
            } else if (input.get("cond10").equals("reporter")) {
                zUserVo.setAuthority("ROLE_REPORTER");
                input.put("authority", "리포터");
            }


            int pageSize = input.getInt("pageSize", 50);
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

        return adminPage(req);
    }

    @RequestMapping(value = "regadmin_pop.html", method = RequestMethod.GET)
    public String regadmin_pop(@ModelAttribute("gAuthVo") GAuthVo gAuthVo, Model model, HttpServletRequest request) throws Exception {

        DataTable input = new DataTable(request);

        try {

            if (!input.get("userid").equals("")) {
                ZUserVo zUserVo = new ZUserVo();
                zUserVo.setUserid(input.get("userid"));
                zUserVo = zUserDAO.getInfo(zUserVo);
                model.addAttribute("vo", zUserVo);
            }

            model.addAttribute("input", input);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminPage(request);
    }

    @RequestMapping(value = "regadmin_pop.html", method = RequestMethod.POST)
    public String regAdminPoster(@ModelAttribute("zUserVo") ZUserVo zUserVo, Model model, HttpServletRequest request) {
        try {
            DataTable input = new DataTable(request);

            zUserVo.setUserpasswd(passwordEncoder.encodePassword(zUserVo.getUserpasswd(), null));
            zUserVo.setUserstatus("1");
            zUserVo.setUsercate("0");
            zUserVo.setEnabled("1");
            zUserVo.setWork_grade("2");
            zUserVo.setUserauth("1");

            if (input.get("act").equals("update")) {
                zUserDAO.update(zUserVo);
                model.addAttribute("update", true);
            } else {
                zUserDAO.insert(zUserVo);
                // 2. zauth_emp에 관리자로 정보등록
                zAuthorityDAO.addZuth_emp(zUserVo);
                // 3. zauthorities에 권한등록(ROLE_ADMIN으로 등록해준다)
                zAuthorityDAO.addZauthorities(zUserVo);
            }

            model.addAttribute("flag", true);
            model.addAttribute("input", input);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/setting/auth/regadmin_pop";
    }
    
    @RequestMapping(value = "regadmin_pop1.html", method = RequestMethod.POST)
    public String regAdminPoster(@ModelAttribute("zUserVo") ZUserVo zUserVo, Model model, HttpServletRequest request) {
    	
    	
    	return "/zcms/admsys/setting/auth/regadmin_pop1";
    }

}
