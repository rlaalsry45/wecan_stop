package com.z5.zcms.frontsys.front.web;

import static com.z5.zcms.util.ZPrint.enter;
import static com.z5.zcms.util.ZPrint.error;
import static com.z5.zcms.util.ZPrint.param;
import static com.z5.zcms.util.ZPrint.print;

import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.common.dao.CommonDAO;
import com.z5.zcms.admsys.common.domain.CommonUseVo;
import com.z5.zcms.admsys.module.dao.ZMemberDAO;
import com.z5.zcms.admsys.module.domain.ZMemberVo;
import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.ZUser2Vo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserLogService;
import com.z5.zcms.frontsys.front.dao.FrontMemberDAOImpl;
import com.z5.zcms.frontsys.front.domain.FrontMemberVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FormMail;
import com.z5.zcms.util.IpUtil;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import tm.automail.sendapi.ThunderAutoMail;
import tm.automail.sendapi.ThunderAutoMailSender;


@Controller
@SuppressWarnings("unused")
public class FrontMemberController {

    @Autowired
    ZMemberDAO            zMemberDAO;
    @Autowired
    ZUserDAO              zUserDAO;
    @Autowired
    CommonDAO             commonDAO;
    @Autowired
    PasswordEncoder       passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    FrontMemberDAOImpl    frontMemberDAOImpl;

    private Logger            log = Logger.getLogger(this.getClass());
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/findUserid.html", method = RequestMethod.POST)
    public String findUseridByEmail(
            @RequestParam String email
    ) throws Exception {
        enter();
        print("find userid by '" + email + "'");
        String userid = "";
        try {
            int userno = zUserDAO.getSameUseremailCount(email);
            if (userno == 1) {
                ZUserVo uservo = new ZUserVo();
                uservo.setUseremail(email);
                uservo = zUserDAO.getInfo(uservo);

                userid = uservo.getUserid();
                userid = userid.substring(0, userid.length() - 2) + "**";
                print(uservo.getUserid() + " --> " + userid);
            } else {
                error(userno + " users have same email!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userid;
    }

    private boolean sendThunderMail(int tmid, String name, String email, String param, String content) {
        boolean done = false;

        try {
            ThunderAutoMailSender tms = new ThunderAutoMailSender();
            ThunderAutoMail       tm  = new ThunderAutoMail();

            tm.setThunderMailURL("218.239.228.11");
            tm.setAutomailID(Integer.toString(tmid));
            if (content != null) {
                tm.setMailContent(content);
            }
            if (name != null) {
                tm.setSenderName(name);
            }
            tm.setEmail(email);
            tm.setOnetooneInfo(param);
            tm.setCustomerID("CRCKOREA");

            String result = tms.send(tm);
            if (result.equals("-100")) {
                done = true;
            } else {
                error("Fail to send thunder mail of " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return done;
    }

    private String getTempPassword(String userid) {
        String password = RandomStringUtils.randomAlphanumeric(12);
        print("Generated temp password '" + password + "' for '" + userid + "'");
        return password;
    }

    private void setTempPassword(String userid, String passwd) {
        try {
            ZUserVo vo = new ZUserVo();
            vo.setUserid(userid);
            vo.setUserpasswd(passwordEncoder.encodePassword(passwd, null));
            zUserDAO.updateUserPasswd(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/sendUserid.html", method = RequestMethod.POST)
    public String sendUseridToEmail(
            @RequestParam String email
    ) throws Exception {
        enter();
        print("find userid by '" + email + "'");
        String done = "success";
        try {
            int userno = zUserDAO.getSameUseremailCount(email);
            if (userno == 1) {
                ZUserVo uservo = new ZUserVo();
                uservo.setUseremail(email);
                uservo = zUserDAO.getInfo(uservo);
                print(uservo.getUserid());

                String param = "[$NAME]Ð" + uservo.getUsername() + "æ[$ID]Ð" + uservo.getUserid();
                if (!sendThunderMail(39, null, uservo.getUseremail(), param, null)) {
                    done = "메일서버 문제";
                }
            } else {
                error(userno + " users have same email!");
                done = "중복된 이메일";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return done;
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/sendUserpw.html", method = RequestMethod.POST)
    public String sendUserpwToEmail(
            @RequestParam String userid
    ) throws Exception {
        enter();
        print("userid is '" + userid + "'");
        String done = "";

        try {
            ZUserVo uservo = new ZUserVo();
            uservo.setUserid(userid);
            uservo = zUserDAO.getInfo(uservo);
            if (uservo != null) {
                String passwd = getTempPassword(userid);
                String params = "[$NAME]Ð" + uservo.getUsername() + "æ[$PW]Ð" + passwd;
                if (sendThunderMail(40, null, uservo.getUseremail(), params, null)) {
                    done = "success";
                    setTempPassword(userid, passwd);
                } else {
                    done = "메일서버에 문제가 발생하였습니다!";
                }
            } else {
                error(userid + " is not found!");
                done = "아이디가 존재하지 않습니다!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return done;
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/getUserhint.html", method = RequestMethod.POST)
    public String getUserhint(
            @RequestParam String userid
    ) throws Exception {
        enter();
        print("userid is '" + userid + "'");
        String done = "";

        try {
            ZUserVo uservo = new ZUserVo();
            uservo.setUserid(userid);
            uservo = zUserDAO.getInfo(uservo);
            if (uservo != null) {
                //done = uservo.getUserhint();
                done = URLEncoder.encode(uservo.getUserhint(), "utf-8");
                print("hint:" + done);
            } else {
                error(userid + " is not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return done;
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/putUseranswer.html", method = RequestMethod.POST)
    public String putUseranswer(
            @RequestParam String userid,
            @RequestParam String answer
    ) throws Exception {
        enter();
        String done = "";
        try {
            ZUserVo uservo = new ZUserVo();
            uservo.setUserid(userid);
            uservo = zUserDAO.getInfo(uservo);
            if (uservo != null && answer.equals(uservo.getUseranswer())) {
                done = getTempPassword(userid);
                setTempPassword(userid, done);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return done;
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/sendAdvise.html", method = RequestMethod.POST)
    public String sendAdviseToEmail(
            @RequestParam String userid
    ) throws Exception {
        enter();
        print("userid:" + userid);
        String done = "";
        try {
            ZUserVo uservo = new ZUserVo();
            uservo.setUserid(userid);
            uservo = zUserDAO.getInfo(uservo);
            if (uservo != null) {
                String params = "[$NAME]Ð" + uservo.getUsername() + "æ[$EMAIL]Ð" + uservo.getUseremail() + "æ[$PHONE]Ð" + uservo.getUsertel();
                if (sendThunderMail(41, uservo.getUsername(), "webmaster@crckorea.kr", params, null)) {
                    done = "success";
                } else {
                    done = "메일서버에 문제가 발생하였습니다!";
                }
            } else {
                done = "로그인 후 사용 가능합니다!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        done = URLEncoder.encode(done, "utf-8");
        print(done);
        return done;
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/sendReport.html", method = RequestMethod.POST)
    public String sendReportToEmail(
            @RequestParam String userid,
            @RequestParam String mailme
    ) throws Exception {
        enter();
        print("userid:" + userid);
        String done = "";
        try {
            ZUserVo uservo = new ZUserVo();
            uservo.setUserid(userid);
            uservo = zUserDAO.getInfo(uservo);
            if (uservo != null) {
                String params = "[$NAME]Ð" + uservo.getUsername();
                if (sendThunderMail(42, null, uservo.getUseremail(), params, mailme)) {
                    done = "success";
                } else {
                    done = "메일서버에 문제가 발생하였습니다!";
                }
            } else {
                done = "로그인 후 사용 가능합니다!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        done = URLEncoder.encode(done, "utf-8");
        print(done);
        return done;
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/dupchk.html", method = RequestMethod.POST)
    public String check_duplicated_userid(
            @RequestParam String userid
    ) throws Exception {

        String ret = "false";
        try {
            int count = zUserDAO.getSameUserIdCount(userid);
            //System.out.println(count);
            if (count == 0) ret = "true";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/passchk.html", method = RequestMethod.POST)
    public String passchk(
            @RequestParam(value = "inputpass", required = false) String inputpass, HttpSession session
    ) throws Exception {

        enter();
        try {
            ZUserVo zUserVo     = (ZUserVo) session.getAttribute("zUserVo");
            String  userpass    = zUserVo.getUserpasswd();
            String  inputpasswd = passwordEncoder.encodePassword(inputpass, null);

            if (userpass.equals(inputpasswd)) {
                session.setAttribute("usermodify_chk", "true");
                return "true";
            } else {
                return "nopass";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/change_pass.html", method = RequestMethod.POST)
    public String change_pass(
            @RequestParam("userpasswd") String userpasswd,
            @RequestParam(value = "changetype", required = false) String changetype,
            HttpSession session,
            HttpServletRequest request
    ) throws Exception {

        enter();
        String userid = null;
        //System.out.println("change_pass들어옴");
        if ("find".equals(changetype)) {
            userid = (String) session.getAttribute("useridForPasswdChange");
            //System.out.println("useridForPasswdChange:"+userid);
        } else {
            userid = SecuritySessionUtil.getUserid(request);
        }

        try {

            ZUserVo vo = new ZUserVo();
            vo.setUserid(userid);
            vo.setUserpasswd(passwordEncoder.encodePassword(request.getParameter("oldpasswd"), null));
            ZUserVo infoVo = zUserDAO.login(vo);

            if (infoVo == null) { //이전 비밀번호 틀릴경우
                return "oldfail";
            } else {

                vo.setUserid(userid);
                vo.setUserpasswd(passwordEncoder.encodePassword(userpasswd, null));
                zUserDAO.updateUserPasswd(vo);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/battery/emaildupchk.html", method = RequestMethod.POST)
    public String service_emailpost(
            @RequestParam String useremail
    ) throws Exception {

        enter();
        //System.out.println("emaildupchk들어옴");
        //System.out.println(useremail);
        String ret = "false";
        try {

            int count = zUserDAO.getSameUseremailCount(useremail);
            //System.out.println(count);

            if (count == 0) ret = "true";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/pwcheck.html", method = RequestMethod.POST)
    public String service_pwcheck(
            @RequestParam String userid,
            @RequestParam String userpasswd
    ) throws Exception {

        enter();
        //System.out.println("pwcheck들어옴");
        //System.out.println(userid);
        String ret = "false";
        try {
            ZUserVo zUserVo = new ZUserVo();
            zUserVo.setUserid(userid);
            zUserVo.setUserpasswd(passwordEncoder.encodePassword(userpasswd, null));
            zUserVo = zUserDAO.login(zUserVo);

            if (zUserVo != null) {
                ret = "true";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    //kpa 회원정보입력
//    @RequestMapping(value = "/skin/member/{skin}/do_join.html", method = RequestMethod.POST)
//    public String serviceDoJoin(
//        @ModelAttribute("zUserVo") ZUserVo zUserVo,
//        @RequestParam int menuno,
//        HttpServletRequest request,
//        HttpServletResponse response,
//        HttpSession session,
//        Model model
//    ) throws Exception {
//
//        enter();
//        param(request);
//        DataTable input = new DataTable(request);
//
//        try {
//
//            //zUserVo.setUserauth("2");
//
//            // update survey institution host info.
//            SdsInstitutionVo sdsInstitutionVo = sdsInstitutionService.value(Integer.parseInt(input.get("instndex")));
//            if (sdsInstitutionVo.getHost() == null) {
//                zUserVo.setUsertype("M"); // master user
//                sdsInstitutionVo.setHost(input.get("name"));
//            } else {
//                zUserVo.setUsertype("N"); // normal user
//            }
//
//            sdsInstitutionVo.setClan(sdsInstitutionVo.getClan() + 1);
//            print(sdsInstitutionVo.toString());
//            sdsInstitutionService.update(sdsInstitutionVo);
//
//            zUserVo.setLicenseeno(input.get("instndex"));
//            zUserVo.setComname(input.get("instname").replace("'", ""));
//            zUserVo.setComtype(sdsInstitutionVo.getType());
//            zUserVo.setUserpasswd(passwordEncoder.encodePassword(input.get("userpw"), null));
//            zUserVo.setUserhint(input.get("question"));
//            zUserVo.setUseranswer(input.get("answer"));
//            zUserVo.setUsername(input.get("name"));
//            zUserVo.setWork_title(input.get("sect"));
//            zUserVo.setWork_grade(input.get("rank"));
//            zUserVo.setUseraddrno(input.get("post"));
//            zUserVo.setUseraddr(input.get("addr1"));
//            zUserVo.setUseraddr2(input.get("addr2"));
//            zUserVo.setUsertel(input.get("tel1") + "-" + input.get("tel2") + "-" + input.get("tel3"));
//            zUserVo.setUserfax(input.get("fax1") + "-" + input.get("fax2") + "-" + input.get("fax3"));
//            zUserVo.setUseremail(input.get("email1") + "@" + input.get("email2"));
//
//            zUserVo.setAuthority("ROLE_USER");
//            zUserVo.setUsercnt(String.valueOf(0));
//            zUserVo.setUseripreg(IpUtil.getIpAddr(request));
//            zUserVo.setSitedomain(request.getServerName().replaceFirst("www.", ""));
//            zUserVo.setEnabled(String.valueOf(1));
//
//            zUserDAO.insert(zUserVo);
//            zUserDAO.insertAuth(zUserVo);
//
//            request.getSession().invalidate();
//
//            model.addAttribute("act", "complete");
//            if (zUserVo.getForeigner() != null && zUserVo.getForeigner().equals("1")) {
//                model.addAttribute("foreigner", "true");
//            }
//
//            //입회비,연회비 주문 KPA에서만 사용 TODO
//            //userno와 이름만 세팅해서 넘기로 pk와 상품명 등은 회비 컨트롤러에서 세팅한다.
//            //정회원의 경우에만 바로 입력하며, 준회원은 관리자가 승인을 해주면 그제서야 결제 정보를 입력한다.20140222
//            //정회원 준회원 모두 가입시에 결제정보를 추가하는 것으로 변경한다. 20150314 김문석
//            //관리자에서 입력할 경우를 대비하여 1:정회원 2:종신회원 3: 준회회읜 경우에만 입력이 되도록 수정한다. 201503142345
////			if(zUserVo.getWork_grade().equals("1") || zUserVo.getWork_grade().equals("2") || zUserVo.getWork_grade().equals("3")){
////				this.insertOrder(nowuserno,zUserVo.getUsername(), zUserVo.getUseremail(),zUserVo.getWork_grade());
////			}
//
//            //회원가입 메일
////			String joinType = "0"; //0: 한국인, 1:외국인
////			if(zUserVo.getForeigner() !=null && zUserVo.getForeigner().equals("1")){
////				joinType = "1";
////			}
////
////			Scheduler.mailContent("9", zUserVo.getUsername(), joinType, zUserVo.getUseremail(), "kpa@demo.zsol.co.kr", "", "");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //폴더방식에 대한 고려
//        String newpage;
//        String subname = request.getParameter("subname");
//        print("subname " + subname);
//        if (subname != null && !subname.isEmpty()) {
//            newpage = "redirect:/" + subname + "/?menuno=" + menuno;
//        } else {
//            newpage = "redirect:/?menuno=" + menuno;
//        }
//
//        print("goto " + newpage);
//        return newpage;
//    }


    private String getEmailMessage(String useremail, String certURL, int lang) {

        String msg = "";
        if (lang == 1) {
            msg += "<body style=\"margin:0;padding:0;\">" +
                    "	<div class=\"mail-wrap\" style=\"width:482px;\">" +
                    "	<div class=\"password\">" +
                    "		<img style=\"border:0;\"src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/img_mail02.gif\" alt=\"이메일 인증 개인정보 보호를 위해서 이메일 인증을 진행합니다. 안녕하세요? 한국국제교류재단 회원가입완료를 위해 이메일 인증을 진행합니다. 아래의 “이메일 인증” 버튼을 클릭하시면 회원가입이 완료됩니다.\" />" +
                    "	</div>" +
                    "	<div class=\"btn-c\" style=\"margin-top:15px;text-align:center;\">" +
                    "		<a href=\"" + certURL + "\"><img style=\"border:0;\" src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/btn_cert.gif\" alt=\"이메일 인증\" /></a>" +
                    "	</div>" +
                    "	<ul class=\"clist\" style=\"margin:14px 0 0 0;padding:0;list-style:none;\">" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ “이메일 인증” 버튼을 클릭하여도 연결이 되지 않으면,  아래의 주소를 복사하여 브라우저의 주소창에 입력하여 주세요.</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">" + certURL + "</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ 이 메일은 발신전용 메일이므로 회신이 불가능합니다.</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">잘못 수신된 메일이라면 본 메일을 무시해 주십시오.</li>" +
                    "	</ul>" +
                    "	<p class=\"text\">감사합니다.</p>" +
                    "	</div>" +
                    "</body>";
        } else if (lang == 2) {
            msg += "<body style=\"margin:0;padding:0;\">" +
                    "	<div class=\"mail-wrap\" style=\"width:482px;\">" +
                    "	<div class=\"password\">" +
                    "		<img style=\"border:0;\"src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/img_mail02_en.gif\" alt=\"이메일 인증 개인정보 보호를 위해서 이메일 인증을 진행합니다. 안녕하세요? 한국국제교류재단 회원가입완료를 위해 이메일 인증을 진행합니다. 아래의 “이메일 인증” 버튼을 클릭하시면 회원가입이 완료됩니다.\" />" +
                    "	</div>" +
                    "	<div class=\"btn-c\" style=\"margin-top:15px;text-align:center;\">" +
                    "		<a href=\"" + certURL + "\"><img style=\"border:0;\" src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/btn_cert_en.gif\" alt=\"이메일 인증\" /></a>" +
                    "	</div>" +
                    "	<ul class=\"clist\" style=\"margin:14px 0 0 0;padding:0;list-style:none;\">" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ If ‘Verify E-mail’ does not work, copy the following address in your browser.</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">" + certURL + "</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ This is an automated e-mail. Pleas do not reply directly to this e-mail.</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ If you received this by error, please ignore this e-mail.</li>" +
                    "	</ul>" +
                    "	<p class=\"text\">Thank you.</p>" +
                    "	</div>" +
                    "</body>";
        }
        return msg;
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/do_find.html", method = RequestMethod.POST)
    public String do_find(
            @RequestParam("userid") String userid,
            @RequestParam int menuno,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            Model model
    ) throws Exception {

        enter();
        param(request);

        //System.out.println("do_find들어옴");
        DataTable input = new DataTable(request);
        try {
            String title       = "";
            String masterName  = "";
            String serverName  = "";
            String certURL     = "";
            String masterEmail = EgovProperties.getProperty("Globals.mail.admin");

            //해당id가 있는지 먼저 확인 해서 없을 경우 해당아이디가 없다는 메일을 보낸다.
            ZUserVo vo = new ZUserVo();
            vo.setUserid(userid);
            if (zUserDAO.getInfo(vo) == null) {
                if (request.getServerName().replaceFirst("www.", "").equals("kf.or.kr")) {
                    title = "한국국제교류재단 비밀번호 재설정 메일입니다.";
                    masterName = "한국국제교류재단";
                    String msg = this.getFailMessage(1);
                    FormMail.sendMail(userid, masterEmail, masterName, title, msg);
                } else {
                    title = "Korea Foundation Email to reset your password.";
                    masterName = "Korea Foundation";
                    String msg = this.getFailMessage(2);
                    FormMail.sendMail(userid, masterEmail, masterName, title, msg);
                }

            } else {

                //메일 발송========================================================

                String ztag            = URLEncoder.encode(input.get("ztag"), "utf-8");
                String userEmailBase64 = URLEncoder.encode(StringUtil.makeBase64ForObject(userid), "utf-8");


                if (request.getServerName().replaceFirst("www.", "").equals("kf.or.kr")) {
                    title = "한국국제교류재단 비밀번호 재설정 메일입니다.";
                    masterName = "한국국제교류재단";
                    serverName = URLEncoder.encode(StringUtil.makeBase64ForObject("https://www." + request.getServerName().replaceFirst("www.", "")), "utf-8");
                    certURL = "https://www.kf.or.kr/findpass/index.html?ztag=" + ztag + "&account=" + userEmailBase64 + "&menuno=" + menuno + "&serverName=" + serverName;
                } else if (request.getServerName().replaceFirst("www.", "").equals("en.kf.or.kr")) {
                    title = "Korea Foundation Email to reset your password.";
                    masterName = "Korea Foundation";
                    serverName = URLEncoder.encode(StringUtil.makeBase64ForObject("https://" + request.getServerName().replaceFirst("www.", "")), "utf-8");
                    certURL = "https://en.kf.or.kr/findpass/index.html?ztag=" + ztag + "&account=" + userEmailBase64 + "&menuno=" + menuno + "&serverName=" + serverName;
                }

                //메시지 가져오기==================================================
                String msg = this.getFindPassEmailMessage(userid, certURL, request.getServerName().replaceFirst("www.", "").equals("kf.or.kr") ? 1 : 2);

                //폼메일 발송
                FormMail.sendMail(userid, masterEmail, masterName, title, msg);

                //임시비밀번호 메일이 발송되었음을 istmppasswd를 Y로 바꾸어 놓는다.
                zUserDAO.updateIsTmpPasswdFlagY(userid);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

        return "success";
    }


    private String getFailMessage(int site) {
        String returnVal = null;
        if (site == 1) {
            returnVal = "<body style=\"margin:0;padding:0;\">" +
                    "	<div class=\"mail-wrap\" style=\"width:482px;\">" +
                    "		<div class=\"password\">" +
                    "			<img style=\"border:0;\"src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/img_mail_fail.gif\" alt=\"비밀번호 찾기 실패.\" />" +
                    "		</div>" +
                    "			<div class=\"btn-c\" style=\"margin-top:15px;text-align:center;\">" +
                    "			<a href=\"https://www.kf.or.kr\"><img style=\"border:0;\" src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/btn_move_home.gif\" alt=\"비밀번호 재설정\" /></a>" +
                    "		</div>" +
                    "	</div>" +
                    "</body>";
        } else if (site == 2) {
            returnVal = "<body style=\"margin:0;padding:0;\">" +
                    "	<div class=\"mail-wrap\" style=\"width:482px;\">" +
                    "		<div class=\"password\">" +
                    "			<img style=\"border:0;\"src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/img_mail_fail_en.gif\" alt=\"비밀번호 찾기 실패.\" />" +
                    "		</div>" +
                    "			<div class=\"btn-c\" style=\"margin-top:15px;text-align:center;\">" +
                    "			<a href=\"https://en.kf.or.kr\"><img style=\"border:0;\" src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/btn_move_home_en.gif\" alt=\"비밀번호 재설정\" /></a>" +
                    "		</div>" +
                    "	</div>" +
                    "</body>";
        }
        return returnVal;

    }

    private String getFindPassEmailMessage(String useremail, String certURL, int lang) {

        String msg = "";
        if (lang == 1) {
            msg += "<body style=\"margin:0;padding:0;\">" +
                    "	<div class=\"mail-wrap\" style=\"width:482px;\">" +
                    "	<div class=\"password\">" +
                    "		<img style=\"border:0;\"src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/img_mail.gif\" alt=\"이메일 인증 개인정보 보호를 위해서 이메일 인증을 진행합니다. 안녕하세요? 한국국제교류재단 회원가입완료를 위해 이메일 인증을 진행합니다. 아래의 “이메일 인증” 버튼을 클릭하시면 회원가입이 완료됩니다.\" />" +
                    "	</div>" +
                    "	<div class=\"btn-c\" style=\"margin-top:15px;text-align:center;\">" +
                    "		<a href=\"" + certURL + "\"><img style=\"border:0;\" src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/btn_setting.gif\" alt=\"비밀번호 재설정\" /></a>" +
                    "	</div>" +
                    "	<ul class=\"clist\" style=\"margin:14px 0 0 0;padding:0;list-style:none;\">" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ “비밀번호 재설정” 버튼을 클릭하여도 연결이 되지 않으면,  아래의 주소를 복사하여 브라우저의 주소창에 입력하여 주세요.</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">" + certURL + "</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ 이 메일은 발신전용 메일이므로 회신이 불가능합니다.</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">잘못 수신된 메일이라면 본 메일을 무시해 주십시오.</li>" +
                    "	</ul>" +
                    "	<p class=\"text\">감사합니다.</p>" +
                    "	</div>" +
                    "</body>";
        } else if (lang == 2) {
            msg += "<body style=\"margin:0;padding:0;\">" +
                    "	<div class=\"mail-wrap\" style=\"width:482px;\">" +
                    "	<div class=\"password\">" +
                    "		<img style=\"border:0;\"src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/img_mail_en.gif\" alt=\"이메일 인증 개인정보 보호를 위해서 이메일 인증을 진행합니다. 안녕하세요? 한국국제교류재단 회원가입완료를 위해 이메일 인증을 진행합니다. 아래의 “이메일 인증” 버튼을 클릭하시면 회원가입이 완료됩니다.\" />" +
                    "	</div>" +
                    "	<div class=\"btn-c\" style=\"margin-top:15px;text-align:center;\">" +
                    "		<a href=\"" + certURL + "\"><img style=\"border:0;\" src=\"https://www.kf.or.kr/skin/member/kf/emailskin/images/btn_setting_en.gif\" alt=\"비밀번호 재설정\" /></a>" +
                    "	</div>" +
                    "	<ul class=\"clist\" style=\"margin:14px 0 0 0;padding:0;list-style:none;\">" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ If ‘Reset My Password’ does not work, copy the following address in your browser.</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">" + certURL + "</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ This is an automated e-mail. Pleas do not reply directly.</li>" +
                    "		<li style=\"font-size:12px;line-height:18px;list-style:none;\">※ If you received this by error, please ignore this e-mail.</li>" +
                    "	</ul>" +
                    "	<p class=\"text\">Thank you.</p>" +
                    "	</div>" +
                    "</body>";
        }

        return msg;
    }

    @RequestMapping(value = "/findpass/index.html")
    public String findpass(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            Model model
    ) throws Exception {

        enter();
        param(request);
        //System.out.println("findpass들어옴");
        DataTable input      = new DataTable(request);
        String    menuno     = input.get("menuno");
        String    userid     = StringUtil.getObjectFromBase64(input.get("account"));
        String    serverName = StringUtil.getObjectFromBase64(input.get("serverName"));
        String    ztag       = URLEncoder.encode(input.get("ztag"), "utf-8");
        if (serverName.equals("https://www.kf.or.kr")) {
            ztag = "rO0ABXQALDxjYWxsIHR5cGU9Im1lbWJlciIgbm89IjEiIHNraW49ImtmIj48L2NhbGw3d3d";
        } else if (serverName.equals("https://en.kf.or.kr")) {
            ztag = "rO0ABXQALTxjYWxsIHR5cGU9Im1lbWJlciIgbm89IjIiIHNraW49ImtmZSI%2bPC9jYWxsPg%3d%3d";
        }

        String rtv = null;
        try {

            //System.out.println(":::::::::::::::::"+menuno);
            //System.out.println(":::::::::::::::::"+input.get("ztag"));
            //System.out.println(":::::::::::::::::"+userid);
            //System.out.println(":::::::::::::::::"+serverName);

            //isTmpPasswd가 Y인지를 확인한다.
            ZUserVo vo = new ZUserVo();
            vo.setUserid(userid);
            vo = zUserDAO.getInfo(vo);
            //System.out.println("vo.getIstmppasswd():"+vo.getIstmppasswd());
            if (vo.getIstmppasswd().equals("Y")) {
                session.setAttribute("useridForPasswdChange", userid);
                rtv = "redirect:" + serverName + "?menuno=" + menuno + "&act=find_pass&ztag=" + ztag;
            } else {
                rtv = "redirect:" + serverName + "?menuno=" + menuno + "&act=wrongauth&ztag=" + ztag;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtv;
    }

    @RequestMapping(value = "/account/index.html")
    public String account(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            Model model
    ) throws Exception {

        enter();
        param(request);
        //System.out.println("account들어옴");
        DataTable input      = new DataTable(request);
        String    menuno     = input.get("menuno");
        String    userid     = StringUtil.getObjectFromBase64(input.get("account"));
        String    serverName = StringUtil.getObjectFromBase64(input.get("serverName"));
        String    ztag       = URLEncoder.encode(input.get("ztag"), "utf-8");
        try {

            //System.out.println(":::::::::::::::::"+menuno);
            //System.out.println(":::::::::::::::::"+input.get("ztag"));
            //System.out.println(":::::::::::::::::"+userid);
            //System.out.println(":::::::::::::::::"+serverName);

            this.zUserDAO.updateEnabledToOne(userid);


            //enabled =1 으로 처리
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*model.addAttribute("ztag",input.get("ztag"));
        model.addAttribute("act","finish");
		model.addAttribute("menuno",menuno);*/
        //System.out.println("redirect:"+serverName+"?menuno="+menuno+"&act=finish&ztag="+ztag);
        return "redirect:" + serverName + "?menuno=" + menuno + "&act=finish&ztag=" + ztag;
    }

    @RequestMapping(value = "/skin/member/{skin}/epmsUserCheck.html")
    public String epmsUserCheck(
            @PathVariable("skin") String skin
    ) throws Exception {
        enter();
        return "/skin/member/" + skin + "/epmsUserCheck";
    }

    @ResponseBody
    @RequestMapping(value = "/skin/member/{skin}/epmsUserCheck_do.html", method = RequestMethod.POST)
    public String epmsUserCheck_do(
            @RequestParam("userid") String userid,
            @RequestParam("userpasswd") String userpasswd
    ) throws Exception {

        enter();
        ZUserVo vo = new ZUserVo();
        //System.out.println("epmsUserCheck_do in");
        //System.out.println(userid);
        String ret = "N";
        try {
            userpasswd = passwordEncoder.encodePassword(userpasswd, null);

            vo.setUserid(userid);
            vo.setUserpasswd(userpasswd);

            ret = zUserDAO.isUserInEpms(vo);
            //System.out.println(ret);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    //kpa 회원정보수정
    @RequestMapping(value = "/skin/member/showsemimemberdocu.html")
    public String showsemimemberdocu(
            Model model
            , @RequestParam(value = "path", required = true) String path
    ) {
        enter();
        model.addAttribute("path", path);
        return "/skin/member/kpa/showsemimemberdocu";
    }

    //kpa 회원정보수정
    @RequestMapping(value = "/skin/member/{skin}/do_modify.html", method = RequestMethod.POST)
    public String serviceDoModify(
            @ModelAttribute("zUserVo") ZUserVo zUserVo,
            @PathVariable String skin,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response,
            Model model
    ) throws Exception {

        enter();
        param(request);
        String act = "login";
//		int no = Integer.parseInt(request.getParameter("no"));
        String type   = request.getParameter("type");
        int    menuno = Integer.parseInt(request.getParameter("menuno"));
//		int siteno = Integer.parseInt(request.getParameter("siteno"));

        try {
            DataTable input = new DataTable(request);

            zUserVo.setUserauth("2");
            zUserVo.setUserauth("2");

            if (zUserVo.getNewsletter1() == null) zUserVo.setNewsletter1("");
            if (zUserVo.getNewsletter2() == null) zUserVo.setNewsletter2("");
            if (zUserVo.getNewsletter3() == null) zUserVo.setNewsletter3("");
            if (zUserVo.getNewsletter4() == null) zUserVo.setNewsletter4("");

//            zUserVo.setLicenseeno(input.get("instndex"));
//            zUserVo.setComname(input.get("instname").replace("'", ""));
            zUserVo.setUserpasswd(passwordEncoder.encodePassword(input.get("userpw"), null));
//            zUserVo.setUserhint(input.get("question"));
//            zUserVo.setUseranswer(input.get("answer"));
            zUserVo.setUsername(input.get("name"));
            zUserVo.setWork_title(input.get("sect"));
            zUserVo.setWork_grade(input.get("rank"));
            zUserVo.setUseraddrno(input.get("post"));
            zUserVo.setUseraddr(input.get("addr1"));
            zUserVo.setUseraddr2(input.get("addr2"));
            zUserVo.setUsertel(input.get("tel1") + "-" + input.get("tel2") + "-" + input.get("tel3"));
            zUserVo.setUserfax(input.get("fax1") + "-" + input.get("fax2") + "-" + input.get("fax3"));
            zUserVo.setUseremail(input.get("email1") + "@" + input.get("email2"));

            zUserVo.setUsercnt(String.valueOf(0));
            zUserVo.setUseripreg(IpUtil.getIpAddr(request));
            zUserVo.setSitedomain(request.getServerName().replaceFirst("www.", ""));
            zUserVo.setEnabled(String.valueOf(1));

            ZUserVo userchvo = (ZUserVo) session.getAttribute("zUserVo");
            zUserVo.setUserno(userchvo.getUserno());

            zUserDAO.update(zUserVo);

            String sessionid = SecuritySessionUtil.getUserid(request);
            if (sessionid == null || sessionid.equals("")) {//세션이 아웃되었을 경우 로그인창으로 이동한다.
                model.addAttribute("sessionout", "true");
            }
            model.addAttribute("act", "usermodify");
            model.addAttribute("modifysuccess", "true");
//			model.addAttribute("ztag",URLEncoder.encode(StringUtil.makeElementAndBase64(Integer.toString(no), type, skin),"utf-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //폴더방식에 대한 고려
        String subname = request.getParameter("subname");

        if (!(subname == null || subname.equals(""))) {
            print("redirect:/" + subname + "/?menuno=" + menuno);
            return "redirect:/" + subname + "/?menuno=" + menuno;
        } else {
            print("redirect:/?menuno=" + menuno);
            return "redirect:/?menuno=" + menuno;
        }
    }

    @RequestMapping(value = "/skin/member/{skin}/{act}.html")
    public String service(
            @PathVariable("act") String act,
            @PathVariable("skin") String skin,
            @RequestHeader(value = "Referer", required = false, defaultValue = "") String referer,
            @RequestParam(value = "foreigner", required = false, defaultValue = "0") String foreigner,
            Model model,
            HttpServletRequest request,
            HttpSession session,
            HttpServletResponse response) throws Exception {

        int    no       = Integer.parseInt((String) request.getAttribute("no"));
        int    menuno   = (Integer) request.getAttribute("menuno");
        int    siteno   = (Integer) request.getAttribute("siteno");
        String type     = (String) request.getAttribute("type");
        String usertype = (String) request.getAttribute("usertype");
        String username = (String) request.getAttribute("username");
        String subname  = (String) request.getAttribute("subname");
        String _from    = (String) request.getAttribute("_from");
        String _to      = (String) request.getAttribute("_to");
        
        DataTable input = new DataTable(request);

        if (StringUtils.isBlank(_from)) {
            _from  = request.getRequestURL().toString() + "?" + request.getQueryString();
        }
        if (StringUtils.isBlank(_to)) {
        	_to = input.get("_to");
        	if (StringUtils.isBlank(_to)) {
        		_to = referer;
        	}
        }

        print("referer = " + referer + " | _from = " + request.getAttribute("_from") + " _to = " + request.getAttribute("_to"));
        print(act + " => menu:" + menuno + " skin:" + skin + " from:" + _from + " to:" + _to);

        //기본값 세팅
        model.addAttribute("subname", subname);

        try {
        	//다음에 가야할 위치를 지정
        	if(act.equals("login")) {
        		model.addAttribute("act", "terms");
	            model.addAttribute("_to", _to);
	            model.addAttribute("_from", _from);
        	}else if(act.equals("post")) {
        		//System.out.println("post 들어옴");
        		type = "member";
        	}else if(act.equals("do_login")) {
        		//System.out.println("post 들어옴");
        	}else if(act.equals("find")) {
        		//System.out.println("member - find 들어옴");
        	}else if(act.equals("modify")) {
        		//System.out.println("member - modify 들어옴");
                ZUserVo vo = new ZUserVo();
                String sessionid = SecuritySessionUtil.getUserid(request);
                if (sessionid == null || sessionid.equals("")) {//세션이 아웃되었을 경우 로그인창으로 이동한다.
                    model.addAttribute("sessionout", "true");
                    act = "login";
                } else {
                    vo.setUserid(sessionid);//세션에서 아이디를 받아와서 검증한다.
                    //System.out.println("vo.getUserid()"+vo.getUserid());
                    vo.setUserid(sessionid);
                    vo = zUserDAO.getInfo(vo);
                    model.addAttribute("user", vo);
                }
        	}else if(act.equals("join_email")) {
        	}else if(act.equals("finish")) {
        	}else if(act.equals("find_id")) {
        	}else if(act.equals("find_pw")) {
        		//System.out.println("finish들어옴");
                ZUserVo uservo = new ZUserVo();
                String tabtype = request.getParameter("tabtype");
                if (tabtype == null) tabtype = "";

                if (tabtype.equals("2")) { //기업회원

                    String licenseeno = request.getParameter("licenseeno");

                    if (licenseeno != null) {

                        String chargeremail = request.getParameter("useremail");

                        if (act.equals("find_pw")) {
                            uservo.setUserid(request.getParameter("userid"));
                        }
                        uservo.setLicenseeno(licenseeno);
                        uservo.setChargeremail(chargeremail);
                        uservo = zUserDAO.getInfo(uservo);

                        if (uservo != null) {
                            model.addAttribute("success", true);
                            model.addAttribute("user", uservo);
                        } else {
                            model.addAttribute("success", false);
                        }
                    }
                } else { //일반회원
                    if ((String) session.getAttribute("sDupInfo") != null) {
                        uservo.setDuesjoin((String) session.getAttribute("sDupInfo"));
                        if (act.equals("find_pw")) {
                            String pw_type = request.getParameter("pw_type");
                            if (pw_type.equals("1")) {
                                uservo.setUserid(request.getParameter("userid"));
                            } else {
                                uservo.setUserid(request.getParameter("userid2"));
                            }
                        }

                        session.setAttribute("sDupInfo", null);
                        uservo = zUserDAO.getInfo(uservo);
                        if (uservo != null) {
                            model.addAttribute("success", true);
                            model.addAttribute("user", uservo);
                        } else {
                            model.addAttribute("success", false);
                        }
                    }
                }
        	}
            
            ZMemberVo zMemberVo = new ZMemberVo();
            zMemberVo.setMemberno(no);
            zMemberVo = zMemberDAO.detail(zMemberVo);
            model.addAttribute("result", zMemberVo);

            if (siteno > 0) {//preview -1
                if (menuno < 1) {
                    CommonUseVo vo = new CommonUseVo();
                    vo.setSiteno(siteno);
                    vo.setTable("zmemberuse");
                    vo.setCond1("memberno");
                    vo.setTablenameno(no);
                    menuno = commonDAO.getUseMenuno(vo);
                }
                if (menuno == -9999) {//로그인 스킨의 경우 기본적으로 메뉴가 생성되어 있지 않으면 메인화면에서 사용할수 없다.
                    act = act + "_tagfail";
                } else {
                    model.addAttribute("menuno", menuno);
                }
            }
            model.addAttribute("no", no);
            model.addAttribute("type", type);
            model.addAttribute("skin", skin);
            model.addAttribute("menuno", menuno);
            model.addAttribute("siteno", siteno);

            model.addAttribute("userid", SecuritySessionUtil.getUserid(request));
            model.addAttribute("ztag", StringUtil.makeElementAndBase64(Integer.toString(no), type, skin));

            //email domain 공통코드 가져온다.
            ComDefaultCodeVO vo = new ComDefaultCodeVO();
            vo.setCodeId("ZCM001"); //코드를 변경할것

            List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);
            model.addAttribute("emaildomain", codeResult);

            if (act.equals("usermodify")) {
//				//지회구분 공통코드가져오기
//				vo = new ComDefaultCodeVO();
//				vo.setCodeId("KPA202"); //코드를 변경할것
//				model.addAttribute("branch", cmmUseService.selectCmmCodeDetail(vo));
//
//				//학력 공통코드가져오기
//				vo = new ComDefaultCodeVO();
//				vo.setCodeId("KPA207"); //코드를 변경할것
//				model.addAttribute("education", cmmUseService.selectCmmCodeDetail(vo));
//
//				//수료 공통코드가져오기
//				vo = new ComDefaultCodeVO();
//				vo.setCodeId("KPA208"); //코드를 변경할것
//				model.addAttribute("degrees", cmmUseService.selectCmmCodeDetail(vo));

                ZUserVo uservo    = new ZUserVo();
                String  sessionid = SecuritySessionUtil.getUserid(request);
                if (sessionid == null || sessionid.equals("")) {//세션이 아웃되었을 경우 로그인창으로 이동한다.
                    model.addAttribute("sessionout", "true");
                    act = "login";
                } else {
                    uservo.setUserid(sessionid);//세션에서 아이디를 받아와서 검증한다.
                    //System.out.println("vo.getUserid()"+vo.getUserid());
                    uservo.setUserid(sessionid);
                    uservo = zUserDAO.getInfo(uservo);
                    model.addAttribute("user", uservo);
                }
            }

            //외국인가입의 경우 인증을 하지 않는다.
            //이미 가입되어 있는 경우 로그인화면으로 리다이렉트
            ZUserVo zUserVo = new ZUserVo();
//			zUserVo.setUsername((String)session.getAttribute("niceName"));
//			zUserVo.setUserbirth((String)session.getAttribute("sBirthDate"));
            zUserVo.setDuesjoin((String) session.getAttribute("sDupInfo"));
            int useryn = zUserDAO.getusercount(zUserVo);
            if ((act.equals("join") || act.equals("join_chk")) && useryn > 0) {
                request.getSession().invalidate();
                model.addAttribute("su", "true");
                model.addAttribute("act", "login");
            }

            if ((act.equals("usermodify") || act.equals("usermodify_foreigner")) &&
                    (session.getAttribute("zUserVo") != null && session.getAttribute("zUserVo") != "")) {
                zUserVo = (ZUserVo) session.getAttribute("zUserVo");
                ZUser2Vo       userpluslist     = zUserDAO.getuserplus(zUserVo);
                List<ZUser2Vo> userlicenslist   = zUserDAO.getuserlicens(zUserVo);
                List<ZUser2Vo> usercreerlist    = zUserDAO.getusercareer(zUserVo);
                List<ZUser2Vo> userawardlist    = zUserDAO.getuseraward(zUserVo);
                List<ZUser2Vo> useracademiclist = zUserDAO.getuseracademic(zUserVo);

                session.setAttribute("usermodify_chk", null);

                model.addAttribute("userdata", zUserVo);
                model.addAttribute("userdata2", userpluslist);
                model.addAttribute("userlicenslist", userlicenslist);
                model.addAttribute("usercreerlist", usercreerlist);
                model.addAttribute("userawardlist", userawardlist);
                model.addAttribute("useracademiclist", useracademiclist);
            }

            if ((session.getAttribute("zUserVo") != null && session.getAttribute("zUserVo") != "")) {
                zUserVo = (ZUserVo) session.getAttribute("zUserVo");
                model.addAttribute("userdata", zUserVo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String page = "skin/" + type + "/" + skin + "/" + act;
        print("page is '" + page + "'");
        return page;
    }

    

}
