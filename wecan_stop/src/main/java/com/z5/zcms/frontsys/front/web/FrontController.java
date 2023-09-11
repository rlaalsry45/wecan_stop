package com.z5.zcms.frontsys.front.web;


import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserLogService;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.frontsys.front.dao.FrontDAO;
import com.z5.zcms.frontsys.front.service.FrontMainService;
import com.z5.zcms.frontsys.front.service.FrontService;
import com.z5.zcms.util.CookieUtil;
import com.z5.zcms.util.ZPrint;
import egovframework.com.cmm.service.EgovProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.z5.zcms.util.ZPrint.enter;
import static com.z5.zcms.util.ZPrint.print;


@Controller
@SuppressWarnings("unused")
public class FrontController extends HttpServlet {

    private static final long serialVersionUID = -6186035809545657685L;
    @Autowired
    FrontMainService frontMainService;
    @Autowired
    FrontService     frontService;
    @Autowired
    FrontDAO         zserviceDAO;
    @Autowired
    ZUserService     zUserService;
    private Logger log = Logger.getLogger(this.getClass());

    //Service main
    @RequestMapping(value = "/index.html")
    public String service(
            Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session
    ) throws Exception {
    	String result = null;
        
    	enter();
    	
        //frontsys에 inportal 이 들어오면 login.html 로 보낸다.
        if ( StringUtils.contains(hostname(request), "inportal.stop.or.kr") ) {
            return "redirect:/login.html";
        }

        //서브폴더방식에 대한 고려
        String subname = request.getParameter("subname");
        if (StringUtils.isNotBlank(subname)) {
            result = "redirect:/" + subname + "/";
            print(result);
            return result;
        }


        try {
            //메인과 서브로 나누지 않고 하나로 간다. 메인에서도 콜테그를 사용할수 있도록 변경한다. 20160518 문영걸
            result = frontService.frontView(request, response, subname);
            if (result != null && result.equals("ERROR404")) {
                return "redirect:/Error404";
            }

            //redirect에 대한 정보를 가져와야한다. 여러개의 메인이 있을 경우 소스로 박아 놓을 수가 없다.
            //메인 사이트이고 메뉴번호가 없는 경우 redirect정보를 가져와서 session방식으로 바로 뿌려버린다.
            //메뉴번호가 있다면 별개의 문제이다. 메인과 상관없이 그냥 서브로 넘긴다

            //1.메뉴번호가 없는경우 - 메인의 경우
            //2.메뉴번호가 없는경우 - 일반의 경우
            //3.서브의 경우 고려

        } catch (Exception e) {
            e.printStackTrace();
        }

        print("service [ subname:" + subname + " | result: " + result + " ]");
        return result;
    }

    //sub방식
    @RequestMapping(value = "/{subname}/index.html")
    public String service_sub(
            Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            @PathVariable("subname") String subname
    ) throws Exception {

        enter();
        String result = null;
        try {
//            SecuritySessionUtil.toString(request);
            result = frontService.frontView(request, response, subname);
            if (result != null && result.equals("ERROR404")) {
                ZPrint.error("Could not found page(subname:" + subname + ")");
                return "redirect:/Error404";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    //admin main
    @RequestMapping(value = "/admsys/index.html")
    public String service_admin(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String page = "redirect:/login.html"; //--> 기준으로사용
        return page;
    }

    @RequestMapping(value = "/loginpop.html")
    public String loginpop(
            Model model,
            HttpServletRequest request,
            @RequestHeader(value = "Referer", required = false, defaultValue = "nohead") String from,
            HttpServletResponse response) throws Exception {

        String _from       = (String) (request.getAttribute("_from") == null ? request.getRequestURL().toString() + "?" + request.getQueryString() : request.getAttribute("_from"));
        String returnValue = null;
        try {
            model.addAttribute("act", "terms");
            if (from.equals("nohead")) {
                model.addAttribute("_to", request.getRequestURL().toString());
            } else {
                model.addAttribute("_to", from);
            }
            model.addAttribute("_from", _from);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        model.addAttribute("adminip", "true");
        return "/zcms/admsys/site/adminip/login";
    }
    
    @RequestMapping(value = "/login1.html")
    public String login1( Model model,
            HttpServletRequest request,
            @RequestHeader(value = "Referer", required = false, defaultValue = "nohead") String from,
            HttpServletResponse response) {
    	
    	 model.addAttribute("adminip", "true");
         return "/zcms/admsys/site/adminip/login";
    }
    
    
    
    @RequestMapping(value = "/registration.html")
    public String registration(
            Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "redirect:/?menuno=76";
    }
    
    //sub방식
    @RequestMapping(value = "/{subname}/registration.html")
    public String sub_registration(
            Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            @PathVariable("subname") String subname
    ) throws Exception {
    	
    	return "redirect:/"+subname+"/?menuno=76";
    }
    
    private String hostname(HttpServletRequest request) {
        String hostname = EgovProperties.getProperty("Globals.server.name");
        if (request != null) {
            hostname = StringUtils.removeStart(request.getServerName(), "www.");
            //운영에서는 이렇게 사용(특수한 경우에만 사용)
            if ("localhost".equals(hostname) || "127.0.0.1".equals(hostname)) {
                hostname = EgovProperties.getProperty("Globals.server.name");
            }
        }
        return hostname;
    }
    
}
