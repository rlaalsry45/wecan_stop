package com.z5.zcms.frontsys.front.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.z5.zcms.admsys.common.dao.CommonDAO;
import com.z5.zcms.admsys.module.dao.ZMemberDAO;
import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.util.SecuritySessionUtil;


@Controller
@SuppressWarnings("unused")
public class FrontMypageController{


	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	ZMemberDAO zMemberDAO;

	@Autowired
	ZUserDAO zUserDAO;

	@Autowired
	CommonDAO commonDAO;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	//정보수정
	@RequestMapping(value="/mypage/modify.html", method = RequestMethod.GET)
	public String modify(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			Model model
			) throws Exception {

		String serverName = request.getServerName().replaceFirst("www.", "");//서버에 따라서 보이는 jsp를 달리한다. 한글 영문등 skin과 비슷한 느낌으로 가져간다.
		if(serverName.equals("127.0.0.1")) serverName = "kf.or.kr";
		String userid = SecuritySessionUtil.getUserid(request);
		System.out.println("userid get :"+userid+"  :::isempty:"+userid.isEmpty());
		if(userid.isEmpty()){
			return "zcms/frontsys/mypage/"+serverName+"/wrongauth";
		}

		ZUserVo vo = new ZUserVo();
		vo.setUserid(userid);
		vo = zUserDAO.getInfo(vo);

		String newsletter = vo.getNewsletter1();
		if(newsletter != null){
			if(newsletter.contains("1")) vo.setNewsletter1("1");
			if(newsletter.contains("2")) vo.setNewsletter2("2");
			if(newsletter.contains("3")) vo.setNewsletter3("3");
			if(newsletter.contains("4")) vo.setNewsletter4("4");
		}
		model.addAttribute("user", vo);

		return "zcms/frontsys/mypage/"+serverName+"/modify";
	}


	@RequestMapping(value="/mypage/modify.html", method = RequestMethod.POST)
    public String do_modify(
    		@ModelAttribute("zUserVo") ZUserVo zUserVo,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		HttpSession session,
    		Model model
    		) throws Exception {

		String serverName =  request.getServerName().replaceFirst("www.", "");;//서버에 따라서 보이는 jsp를 달리한다. 한글 영문등 skin과 비슷한 느낌으로 가져간다.
		try{

			String userid = SecuritySessionUtil.getUserid(request);
			System.out.println("userid post :"+userid+"  :::isempty:"+userid.isEmpty());
			if(userid.isEmpty()){
				return "zcms/frontsys/mypage/"+serverName+"/wrongauth";
			}

			zUserVo.setUserpasswd(passwordEncoder.encodePassword(zUserVo.getUserpasswd(), null));
			if(zUserVo.getNewsletter1() == null) zUserVo.setNewsletter1("");
			if(zUserVo.getNewsletter2() == null) zUserVo.setNewsletter2("");
			if(zUserVo.getNewsletter3() == null) zUserVo.setNewsletter3("");
			if(zUserVo.getNewsletter4() == null) zUserVo.setNewsletter4("");
			zUserVo.setNewsletter1(zUserVo.getNewsletter1()+","+zUserVo.getNewsletter2()+","+zUserVo.getNewsletter3()+","+zUserVo.getNewsletter4());
			zUserDAO.update(zUserVo);

			model.addAttribute("modifysuccess","true");

		}catch(Exception e){
			e.printStackTrace();
		}
		if(serverName.equals("kf.or.kr")){
			return "redirect:/?menuno=623";
		}else{
			return "redirect:/?menuno=630";
		}
    }

	//회원탈퇴
	@RequestMapping(value="/mypage/memberout.html", method = RequestMethod.GET)
	public String memberout(
			HttpServletRequest request
			,HttpServletResponse response
			,HttpSession session
			,Model model
			,@RequestParam (value="memberoutsuccess", required=false) String memberoutsuccess
			) throws Exception {

		String serverName =  request.getServerName().replaceFirst("www.", "");;//서버에 따라서 보이는 jsp를 달리한다. 한글 영문등 skin과 비슷한 느낌으로 가져간다.
		if(serverName.equals("127.0.0.1")) serverName = "kf.or.kr";
		String userid = SecuritySessionUtil.getUserid(request);

		if(memberoutsuccess.equals("true")){
			model.addAttribute("memberoutsuccess","true");
			return "zcms/frontsys/mypage/"+serverName+"/memberout";
		}

		if( userid ==null || userid.isEmpty()){
			return "zcms/frontsys/mypage/"+serverName+"/wrongauth";
		}

		ZUserVo vo = new ZUserVo();
		vo.setUserid(userid);
		vo = zUserDAO.getInfo(vo);
		model.addAttribute("user", vo);

		return "zcms/frontsys/mypage/"+serverName+"/memberout";
	}


	@RequestMapping(value="/mypage/memberout.html", method = RequestMethod.POST)
    public String do_memberout(
    		@ModelAttribute("zUserVo") ZUserVo zUserVo,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		HttpSession session,
    		Model model
    		) throws Exception {

		String serverName =  request.getServerName().replaceFirst("www.", "");//서버에 따라서 보이는 jsp를 달리한다. 한글 영문등 skin과 비슷한 느낌으로 가져간다.
		try{

			String userid = SecuritySessionUtil.getUserid(request);
			if( userid == null || userid.isEmpty()){
				return "zcms/frontsys/mypage/"+serverName+"/wrongauth";
			}
			zUserVo.setUserid(userid);
			zUserVo.setUserpasswd(passwordEncoder.encodePassword(zUserVo.getUserpasswd(), null));
			//zUserDAO.update(zUserVo);
			zUserDAO.deleteOneUser(zUserVo);
			zUserDAO.deleteOneAuth(zUserVo);

			model.addAttribute("memberoutsuccess","true");

		}catch(Exception e){

			e.printStackTrace();
		}

		session.invalidate();

		if(serverName.equals("kf.or.kr")){
			return "redirect:/?menuno=634";
		}else{
			return "redirect:/?menuno=635";
		}
    }



/*	private String getEmailMessage(String useremail, String certURL) {

		String msg= "";
		msg +=  "<body style=\"margin:0;padding:0;\">" +
				"	<div class=\"mail-wrap\" style=\"width:482px;\">" +
				"	<div class=\"password\">" +
				"		<img style=\"border:0;\"src=\"http://kf.or.kr/skin/member/kf/emailskin/images/img_mail02.gif\" alt=\"이메일 인증 개인정보 보호를 위해서 이메일 인증을 진행합니다. 안녕하세요? 한국국제교류재단 회원가입완료를 위해 이메일 인증을 진행합니다. 아래의 “이메일 인증” 버튼을 클릭하시면 회원가입이 완료됩니다.\" />" +
				"	</div>" +
				"	<div class=\"btn-c\" style=\"margin-top:15px;text-align:center;\">" +
				"		<a href=\""+certURL+"\"><img style=\"border:0;\" src=\"http://kf.or.kr/skin/member/kf/emailskin/images/btn_cert.gif\" alt=\"이메일 인증\" /></a>" +
				"	</div>" +
				"	<ul class=\"clist\" style=\"margin:14px 0 0 0;padding:0;list-style:none;\">" +
				"		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ “이메일 인증” 버튼을 클릭하여도 연결이 되지 않으면,  아래의 주소를 복사하여 브라우저의 주소창에 입력하여 주세요.</li>" +
				"		<li style=\"font-size:12px;line-height:18px;list-style:none;\">"+certURL+"</li>"+
				"		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ 이 메일은 발신전용 메일이므로 회신이 불가능합니다.</li>"+
				"		<li style=\"font-size:12px;line-height:18px;list-style:none;\">잘못 수신된 메일이라면 본 메일을 무시해 주십시오.</li>"+
				"	</ul>" +
				"	<p class=\"text\">감사합니다.</p>" +
				"	</div>" +
				"</body>";

		return msg;
	}

	@ResponseBody
	@RequestMapping(value="/skin/member/{skin}/do_find.html", method = RequestMethod.POST)
	public String do_find(
			@RequestParam("userid") String userid,
			@RequestParam int menuno,
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			Model model
			) throws Exception {

		System.out.println("do_find들어옴");
		DataTable input = new DataTable(request);
		try{

			//메일 발송========================================================
			String title ="한국국제교류재단 비밀번호 재설정 메일입니다.";

			String masterName="한국국제교류재단";
			String masterEmail = EgovProperties.getProperty("Globals.mail.admin");

			String ztag = URLEncoder.encode(input.get("ztag"),"utf-8");
			String userEmailBase64 = URLEncoder.encode(StringUtil.makeBase64ForObject(userid),"utf-8");
			String serverName =URLEncoder.encode(StringUtil.makeBase64ForObject("http://"+request.getServerName()),"utf-8");

			//메시지 가져오기==================================================
			String certURL = "http://kf.or.kr/findpass/index.html?ztag="+ztag+"&account="+userEmailBase64+"&menuno="+menuno+"&serverName="+serverName;
			String msg = this.getFindPassEmailMessage(userid,certURL);

			//폼메일 발송
			FormMailUtil.sendMail(userid, masterEmail, masterName, title, msg);

			//임시비밀번호 메일이 발송되었음을 istmppasswd를 Y로 바꾸어 놓는다.
			zUserDAO.updateIsTmpPasswdFlagY(userid);

		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}

		return "success";
	}




	private String getFindPassEmailMessage(String useremail, String certURL) {

		String msg= "";
		msg +=  "<body style=\"margin:0;padding:0;\">" +
				"	<div class=\"mail-wrap\" style=\"width:482px;\">" +
				"	<div class=\"password\">" +
				"		<img style=\"border:0;\"src=\"http://kf.or.kr/skin/member/kf/emailskin/images/img_mail.gif\" alt=\"이메일 인증 개인정보 보호를 위해서 이메일 인증을 진행합니다. 안녕하세요? 한국국제교류재단 회원가입완료를 위해 이메일 인증을 진행합니다. 아래의 “이메일 인증” 버튼을 클릭하시면 회원가입이 완료됩니다.\" />" +
				"	</div>" +
				"	<div class=\"btn-c\" style=\"margin-top:15px;text-align:center;\">" +
				"		<a href=\""+certURL+"\"><img style=\"border:0;\" src=\"http://kf.or.kr/skin/member/kf/emailskin/images/btn_setting.gif\" alt=\"비밀번호 재설정\" /></a>" +
				"	</div>" +
				"	<ul class=\"clist\" style=\"margin:14px 0 0 0;padding:0;list-style:none;\">" +
				"		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ “비밀번호 재설정” 버튼을 클릭하여도 연결이 되지 않으면,  아래의 주소를 복사하여 브라우저의 주소창에 입력하여 주세요.</li>" +
				"		<li style=\"font-size:12px;line-height:18px;list-style:none;\">"+certURL+"</li>"+
				"		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ 이 메일은 발신전용 메일이므로 회신이 불가능합니다.</li>"+
				"		<li style=\"font-size:12px;line-height:18px;list-style:none;\">잘못 수신된 메일이라면 본 메일을 무시해 주십시오.</li>"+
				"	</ul>" +
				"	<p class=\"text\">감사합니다.</p>" +
				"	</div>" +
				"</body>";

		return msg;
	}

	@RequestMapping(value="/findpass/index.html")
	public String findpass(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			Model model
			) throws Exception {

		System.out.println("findpass들어옴");
		DataTable input = new DataTable(request);
		String menuno = input.get("menuno");
		String userid = StringUtil.getObjectFromBase64(input.get("account"));
		String serverName = StringUtil.getObjectFromBase64(input.get("serverName"));
		String ztag = URLEncoder.encode(input.get("ztag"),"utf-8");

		String rtv = null;
		try{

			System.out.println(":::::::::::::::::"+menuno);
			System.out.println(":::::::::::::::::"+input.get("ztag"));
			System.out.println(":::::::::::::::::"+userid);
			System.out.println(":::::::::::::::::"+serverName);

			//isTmpPasswd가 Y인지를 확인한다.
			ZUserVo vo = new ZUserVo();
			vo.setUserid(userid);
			vo = zUserDAO.getInfo(vo);
			System.out.println("vo.getIstmppasswd():"+vo.getIstmppasswd());
			if(vo.getIstmppasswd().equals("Y")){
				session.setAttribute("useridForPasswdChange", userid);
				rtv = "redirect:"+serverName+"?menuno="+menuno+"&act=find_pass&ztag="+ztag;
			}else{
				rtv = "redirect:"+serverName+"?menuno="+menuno+"&act=wrongauth&ztag="+ztag;
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return rtv;
	}

	@RequestMapping(value="/account/index.html")
	public String account(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			Model model
			) throws Exception {

		System.out.println("account들어옴");
		DataTable input = new DataTable(request);
		String menuno = input.get("menuno");
		String userid = StringUtil.getObjectFromBase64(input.get("account"));
		String serverName = StringUtil.getObjectFromBase64(input.get("serverName"));
		String ztag = URLEncoder.encode(input.get("ztag"),"utf-8");
		try{

			System.out.println(":::::::::::::::::"+menuno);
			System.out.println(":::::::::::::::::"+input.get("ztag"));
			System.out.println(":::::::::::::::::"+userid);
			System.out.println(":::::::::::::::::"+serverName);

			this.zUserDAO.updateEnabledToOne(userid);


			//enabled =1 으로 처리
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("ztag",input.get("ztag"));
		model.addAttribute("act","finish");
		model.addAttribute("menuno",menuno);
		System.out.println("redirect:"+serverName+"?menuno="+menuno+"&act=finish&ztag="+ztag);
		return "redirect:"+serverName+"?menuno="+menuno+"&act=finish&ztag="+ztag;
	}

	@RequestMapping(value="/skin/member/{skin}/epmsUserCheck.html")
	public String epmsUserCheck(
			@PathVariable("skin") String skin
			) throws Exception {
		return "/skin/member/"+skin+"/epmsUserCheck";
	}

	@ResponseBody
	@RequestMapping(value="/skin/member/{skin}/epmsUserCheck_do.html", method = RequestMethod.POST)
    public String epmsUserCheck_do(
    		@RequestParam("userid") String userid,
    		@RequestParam("userpasswd") String userpasswd
    		) throws Exception {

		ZUserVo vo = new ZUserVo();
		System.out.println("epmsUserCheck_do in");
		System.out.println(userid);
		String ret = "N";
		try{
			userpasswd = passwordEncoder.encodePassword(userpasswd, null);

			vo.setUserid(userid);
			vo.setUserpasswd(userpasswd);

			ret = zUserDAO.isUserInEpms(vo);
			System.out.println(ret);


		}catch(Exception e){
			e.printStackTrace();
		}
		return ret;
    }


	@RequestMapping(value="/skin/member/{skin}/do_modify.html", method = RequestMethod.POST)
	public String serviceDoModify(
			@ModelAttribute("zUserVo") ZUserVo zUserVo,
			@PathVariable String skin,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model
			) throws Exception {

		System.out.println("do_modify들어옴");
		String act="login";
		int no = Integer.parseInt(request.getParameter("no"));
		String type = request.getParameter("type");
		int menuno = Integer.parseInt(request.getParameter("menuno"));
		int siteno = Integer.parseInt(request.getParameter("siteno"));

		try{
			DataTable input = new DataTable(request);
			if(!(zUserVo.getUserpasswd().equals("") || zUserVo.getUserpasswd()==null)){
				zUserVo.setUserpasswd(passwordEncoder.encodePassword(zUserVo.getUserpasswd(), null));
			}
			zUserVo.setUserauth("2");
			zUserVo.setUseremail(input.get("useremailid")+"@"+input.get("useremaildomain"));
			zUserVo.setUsertel(input.get("usertel1")+"-"+input.get("usertel2")+"-"+input.get("usertel3"));
			zUserVo.setUsermobile(input.get("usermobile1")+"-"+input.get("usermobile2")+"-"+input.get("usermobile3"));
			zUserVo.setUseraddrno(input.get("useraddrno1")+""+input.get("useraddrno2"));
			//zUserVo.setUseraddr(input.get("useraddr1")+" "+input.get("useraddr2"));
			zUserVo.setUseraddr(input.get("useraddr"));
			zUserVo.setUseraddr2(input.get("useraddr2"));
			zUserVo.setUsertype(input.get("usertype"));
			zUserVo.setUsercnt(String.valueOf(0));
			zUserVo.setUseripreg(IpUtil.getIpAddr(request));
			zUserVo.setSitedomain(request.getServerName());
			zUserDAO.update(zUserVo);

			ZUserVo vo = new ZUserVo();
			String sessionid = SecuritySessionUtil.getUserid(request);
			if(sessionid == null || sessionid.equals("")){//세션이 아웃되었을 경우 로그인창으로 이동한다.
				model.addAttribute("sessionout","true");

			}else{
				vo.setUserid(sessionid);//세션에서 아이디를 받아와서 검증한다.
				System.out.println("vo.getUserid()"+vo.getUserid());
				vo.setUserid(sessionid);
				vo = zUserDAO.getInfo(vo);
				model.addAttribute("user", vo);
			}
			ZMemberVo zMemberVo = new ZMemberVo();
			zMemberVo.setMemberno(no);
			zMemberVo = zMemberDAO.detail(zMemberVo);
			model.addAttribute("result",zMemberVo);

			if(siteno > 0){//preview -1
				if(menuno < 1){
					CommonUseVo cvo = new CommonUseVo();
					cvo.setSiteno(siteno);
					cvo.setTable("zmemberuse");
					cvo.setCond1("memberno");
					cvo.setTablenameno(no);
					menuno = commonDAO.getUseMenuno(cvo);
				}
				if(menuno == -9999){//로그인 스킨의 경우 기본적으로 메뉴가 생성되어 있지 않으면 메인화면에서 사용할수 없다.
					act = act + "_tagfail";
				}else{
					model.addAttribute("menuno",menuno);
				}
			}
			model.addAttribute("act","modify");
			model.addAttribute("modifysuccess","true");
			model.addAttribute("ztag",URLEncoder.encode(StringUtil.makeElementAndBase64(Integer.toString(no), type, skin),"utf-8"));


		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/";
	}



	@RequestMapping(value="/skin/member/{skin}/{act}.html")
    public String service(
    		@PathVariable("act") String act,
    		@PathVariable("skin") String skin,
    		@RequestHeader(value="Referer", required=false, defaultValue="nohead") String from,
    		Model model,
    		HttpServletRequest request,
    		HttpSession session,
    		HttpServletResponse response) throws Exception {

		int no = Integer.parseInt((String) request.getAttribute("no"));
		String type = (String)request.getAttribute("type");
		int menuno = (Integer) request.getAttribute("menuno");
		int siteno = (Integer) request.getAttribute("siteno");
		String usertype =(String)request.getAttribute("usertype");
		String username =(String)request.getAttribute("username");

		String _from = (String) (request.getAttribute("_from")==null?request.getRequestURL().toString() + "?" + request.getQueryString():request.getAttribute("_from"));

		try{
			System.out.println("member 들어옴");

			//다음에 가야할 위치를 지정
			if(act.equals("login")){
				model.addAttribute("act","terms");
				if(from.equals("nohead")){
					model.addAttribute("_to", request.getRequestURL().toString() );
				}else{
					model.addAttribute("_to", from );
				}
				model.addAttribute("_from",_from );

			}else if(act.equals("join_front")){
				model.addAttribute("act","join_name");
			}

			else if(act.equals("join_name")){
				if(usertype.equals("a")){
					model.addAttribute("usertype","a");
				}else if(usertype.equals("b")){
					model.addAttribute("usertype","b");
				}else if(usertype.equals("c")){
					model.addAttribute("usertype","c");
					act="terms";
				}
				model.addAttribute("act","terms");
			}

			else if(act.equals("terms")){
				ZMemberVo result = new ZMemberVo();
				result.setMemberno(no);
				model.addAttribute("result",zMemberDAO.detail(result));
				model.addAttribute("act","join");
				model.addAttribute("usertype",usertype);
				model.addAttribute("username",username);


				//비정상접근 막음(세션유무로 판단)
				String niceName = (String) session.getAttribute("niceName");
				if(!usertype.equals("c")){
					if (niceName==null || niceName.equals("")){
						model.addAttribute("sessionout","true");
						//act="join_front";

					}
				}
				//System.out.println(niceName);

			}else if(act.equals("join")){
				//비정상접근 막은(세션유무로 판단)

				if(!usertype.equals("c")){
					String niceName = (String) session.getAttribute("niceName");
					if (niceName==null || niceName.equals("")){
						model.addAttribute("sessionout","true");
						//act="join_front";
					}
				}
				model.addAttribute("usertype",usertype);
				model.addAttribute("niceName",niceName);
				model.addAttribute("username",username);
				session.setAttribute("niceName", null);

			}


			else if(act.equals("post")){
				System.out.println("post 들어옴");
				type ="member";
			}else if(act.equals("do_login")){
				System.out.println("post 들어옴");
			}else if(act.equals("find")){

				System.out.println("member - find 들어옴");
			}else if(act.equals("modify")){
				System.out.println("member - modify 들어옴");
				ZUserVo vo = new ZUserVo();
				String sessionid = SecuritySessionUtil.getUserid(request);
				if(sessionid == null || sessionid.equals("")){//세션이 아웃되었을 경우 로그인창으로 이동한다.
					model.addAttribute("sessionout","true");
					act="login";
				}else{
					vo.setUserid(sessionid);//세션에서 아이디를 받아와서 검증한다.
					System.out.println("vo.getUserid()"+vo.getUserid());
					vo.setUserid(sessionid);
					vo = zUserDAO.getInfo(vo);
					model.addAttribute("user", vo);
				}


			}else if(act.equals("join_email")){
				System.out.println("finish들어옴");
			}
			else if(act.equals("finish")){
				System.out.println("finish들어옴");
			}


			ZMemberVo zMemberVo = new ZMemberVo();
			zMemberVo.setMemberno(no);
			zMemberVo = zMemberDAO.detail(zMemberVo);
			model.addAttribute("result",zMemberVo);

			if(siteno > 0){//preview -1
				if(menuno < 1){
					CommonUseVo vo = new CommonUseVo();
					vo.setSiteno(siteno);
					vo.setTable("zmemberuse");
					vo.setCond1("memberno");
					vo.setTablenameno(no);
					menuno = commonDAO.getUseMenuno(vo);
				}
				if(menuno == -9999){//로그인 스킨의 경우 기본적으로 메뉴가 생성되어 있지 않으면 메인화면에서 사용할수 없다.
					act = act + "_tagfail";
				}else{
					model.addAttribute("menuno",menuno);
				}
			}
			model.addAttribute("no",no);
			model.addAttribute("type",type);
			model.addAttribute("skin",skin);
			model.addAttribute("menuno",menuno);
			model.addAttribute("siteno",siteno);

			model.addAttribute("userid", SecuritySessionUtil.getUserid(request));
			model.addAttribute("ztag",URLEncoder.encode(StringUtil.makeElementAndBase64(Integer.toString(no), type, skin),"utf-8"));

		}catch(Exception e){
			e.printStackTrace();
		}

		return "skin/"+type+"/"+skin+"/"+act;
    }*/



}
