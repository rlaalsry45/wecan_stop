package com.z5.zcms.frontsys.front.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.z5.zcms.admsys.menu.service.ZmenuService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.StringUtil;


@Controller
@SuppressWarnings("unused")
public class FrontTemplateJspParser{

	@Autowired
	ZmenuService zmenuService;

	private Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value="/front/parse/template/{type}/{no}.html")
    public String service(
    		@PathVariable("type") String type,
    		@PathVariable("no") String no,
    		Model model,
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception {

		//String loginMenuno = null;
		//String memberno = null;
		//String zmenutitlepath = null;

		//폴더방식에 대한 고려
    	HttpSession session = request.getSession();
        String subname = "";
        if(!(request.getAttribute("subname") == null
        		|| request.getAttribute("subname").equals("")
        		|| request.getAttribute("subname").equals("null"))){ //WAS 내부적으로 화면을 가져오는 경우 attribute에 값을 담아 보낸다.
        	subname =(String) request.getAttribute("subname");
        	model.addAttribute("subname",subname);
        }else if(!(request.getParameter("subname") == null
        		|| request.getParameter("subname").equals("")
        		|| request.getParameter("subname").equals("null")) ){//상중하단의 경우 httpurlconnection을 이용하기 때문에 parameter로 받아야한다.
        	subname =(String) request.getParameter("subname");
        	model.addAttribute("subname",subname);
        }else{
        	model.addAttribute("subname",null);
        }

		try{
			//System.out.println("parser 들어옴");

			//다음에 가야할 위치를 지정
			if(type.equals("tpl")){
				//System.out.println("tpl tempalte in");
				//loginMenuno = (String) request.getAttribute("loginMenuno");
				//memberno = (String) request.getAttribute("memberno");
				//zmenutitlepath = (String) request.getAttribute("zmenutitlepath");
				//model.addAttribute("loginMenuno",loginMenuno);
				/*if(request.getServerName().replaceFirst("www.", "").equals("kf.or.kr")){
					model.addAttribute("ztagHeader",StringUtil.makeElementAndBase64(memberno, "member", "kf"));
				}else{
					model.addAttribute("ztagHeader",StringUtil.makeElementAndBase64(memberno, "member", "kfe"));
				}*/

				//model.addAttribute("zmenutitlepath",zmenutitlepath);
				model.addAttribute("tplmenuno",request.getAttribute("menuno"));

			}else if(type.equals("main")){
				//System.out.println("main tempalte in");
				//loginMenuno = (String) request.getAttribute("loginMenuno");
				//memberno = (String) request.getAttribute("memberno");
				//model.addAttribute("loginMenuno",loginMenuno);
				//main에서 로그인 skin을 사용한다면 아래의 주석을 풀고 frontserviceImpl에서 attribute를 던져줄것(memberno)
				/*if(request.getServerName().equals("kf.or.kr")){
					model.addAttribute("ztagHeader",StringUtil.makeElementAndBase64(memberno, "member", "kf"));
					model.addAttribute("zmenutitlepath","한국국제교류재단"+zmenutitlepath);
				}else{
					model.addAttribute("ztagHeader",StringUtil.makeElementAndBase64(memberno, "member", "kfe"));
					model.addAttribute("zmenutitlepath","Korea Foundation"+zmenutitlepath);
				}*/
			}else if(type.equals("menu")){
				//System.out.println("menu tempalte in.");
				//loginMenuno = (String) request.getParameter("loginMenuno");
				//memberno = (String) request.getParameter("memberno");
			}

			model.addAttribute("usersession",SecuritySessionUtil.getUserid(request));
			model.addAttribute("serverNameWithPortNumber",StringUtil.getServerNameWithPortNumber(request));
			ZUserVo userVo = new ZUserVo();
			userVo = (ZUserVo)SecuritySessionUtil.getUserVo(request);
			if(userVo != null){
				model.addAttribute("username",userVo.getUsername());
				if(userVo.getWork_grade()!=null){
					String userauthname = "";
					if(userVo.getWork_grade().equals("1")){
						userauthname ="정회원";
					}else if(userVo.getWork_grade().equals("2")){
						userauthname ="종신회원";
					}else if(userVo.getWork_grade().equals("3")){
						userauthname ="준회원";
					}else if(userVo.getWork_grade().equals("4")){
						userauthname ="용역담당";
					}else if(userVo.getWork_grade().equals("6")){
						userauthname ="외부심사위원";
					}else{
						userauthname ="미권한상태";
					}
					model.addAttribute("userauthname",userauthname);
				}
				if(userVo.getUseroutrequest()!=null&&userVo.getUseroutrequest().equals("0")){
					model.addAttribute("outrequest", "true");
				}
			}
			userVo = null;
			//System.out.println("SecuritySessionUtil.getUserid(request)"+SecuritySessionUtil.getUserid(request));
		}catch(Exception e){
			this.log.debug(e.getMessage());
			e.printStackTrace();
		}


		return "template/"+type+"/"+no;
    }
	@RequestMapping(value="/skin/freeorder/default/freeorder.html")
	public String freeorder(
			Model model
			,HttpServletRequest request
			,HttpServletResponse response
			,HttpSession session
			) throws Exception {

		String type = (String)request.getAttribute("type");
		String no = (String)request.getAttribute("no");

		String type1 = (String)request.getParameter("type");
		String no1 = (String)request.getParameter("no");

		model.addAttribute("type", type);
		model.addAttribute("no", no);

		return "skin/freeorder/default/freeorder";
	}



}
