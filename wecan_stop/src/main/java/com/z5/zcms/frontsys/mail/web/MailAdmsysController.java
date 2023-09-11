package com.z5.zcms.frontsys.mail.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.z5.zcms.admsys.events.service.EventsService;
import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.frontsys.mail.dao.MailDAO;
import com.z5.zcms.frontsys.mail.domain.Mail;
import com.z5.zcms.frontsys.mail.domain.MailParticipant;
import com.z5.zcms.frontsys.mail.service.MailParticipantService;
import com.z5.zcms.frontsys.mail.service.MailService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FormMail;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;

@Controller
@RequestMapping("/admsys/mail/")
public class MailAdmsysController {
    @Autowired
    private MailService                  mailService;
    @Autowired
    private MailDAO                      mailDAO;
    @Autowired
    private MailParticipantService       mailParticipantService;
    @Autowired
    private ZUserService                 zUserService;
    @Autowired
    private EventsService                eventsService;
    @Autowired
    private ZUserDAO                     zuserDAO;
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;


    private String viewPath = "/zcms/admsys/mail/";

    @RequestMapping(value = "index.html")
    public String selectMailList(
        @ModelAttribute("mail") Mail mail
        , Model model
        , HttpServletRequest request
        , HttpSession session) throws Exception {

        DataTable input = new DataTable(request);

        try {
            int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));

	    	/*if(session.getAttribute("admsys_con_page") != "" && session.getAttribute("admsys_con_page") != null){
                session.removeAttribute("admsys_pro_page");
				input.put("pageIndex", (Integer) session.getAttribute("admsys_con_page"));
			}*/
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int pageIndex = input.getInt("pageIndex") - 1;

            int m = pageIndex * pageSize;
            int n = pageSize;

            mail.setM(m);
            mail.setN(n);


            int total = this.mailService.getMailListCount(mail);
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<Mail> list = this.mailService.getMailList(mail);

            model.addAttribute("list", list);
            model.addAttribute("input", input);

            StringBuilder url = new StringBuilder("?keyword=");
            url.append(mail.getKeyword());
            url.append("&con1=");
            url.append(mail.getCond1());
            url.append("&pageIndex=");
            url.append(pageIndex);
            model.addAttribute("url", url);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return viewPath + "index";
    }

    //작성
    @RequestMapping(value = "insert.html", method = RequestMethod.GET)
    public String insert(
        Model model
        , HttpServletRequest request) throws Exception {
        return viewPath + "insert";
    }


    @ResponseBody
    @RequestMapping(value = "searchUser.html")
    public List<ZUserVo> searchUser(
        @ModelAttribute("zUserVo") ZUserVo zUserVo
        , Model model, HttpServletRequest req) throws Exception {

        List<ZUserVo> list = null;
        try {
            DataTable input    = new DataTable(req);
            int       pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex  = input.getInt("pageIndex") - 1;
            String sdate      = input.get("sdate");
            String edate      = input.get("edate");
            String keyword    = input.get("keyword");
            String work_grade = input.get("work_grade");
            int    m          = pageIndex * pageSize;
            int    n          = pageSize;

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
            if (work_grade.equals("")) {
                zUserVo.setCond3("");
            } else {
                zUserVo.setCond3(input.get("work_grade"));
            }

            zUserVo.setSdate(input.get("sdate"));
            zUserVo.setEdate(input.get("edate"));
            zUserVo.setKeyword(input.get("keyword"));

            zUserVo.setM(m);
            zUserVo.setN(n);


            int total = this.mailService.getListCountUserForSearch(zUserVo);
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            list = this.mailService.getListUserForSearch(zUserVo);

            //model.addAttribute("list", list);
            model.addAttribute("input", input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    //작성 insert
    @RequestMapping(value = "insert.html", method = RequestMethod.POST)
    public String insert_confirm(
        HttpServletResponse response
        , @ModelAttribute("mail") Mail mail
        , BindingResult err
        , HttpServletRequest request
        , HttpSession session
    ) throws Exception {

        MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest) request;

        Iterator<String> fileIter = mptRequest.getFileNames();

        //file upload
        while (fileIter.hasNext()) {
            String currentFileName = (String) fileIter.next();
            System.out.println("Name ==== " + currentFileName);
            MultipartFile mFile = mptRequest.getFile(currentFileName);

		     /*if (mFile.getSize() > 0) {
		    	 HashMap map = EgovFileMngUtil.uploadFile(mFile,"Globals.confernce.upload.path");
                 //필드명별로 저장 경로 바꿈
		    	 if(currentFileName.equals("conoutlinefilename")){
		    		 mail.setConoutlinefilename( (String)map.get(Globals.ORIGIN_FILE_NM));
		    		 mail.setConoutlinefilepath( (String)map.get(Globals.UPLOAD_FILE_NM));
		    	 }
		    	 if(currentFileName.equals("conapplicationfilename")){
		    		 mail.setConapplicationfilename( (String)map.get(Globals.ORIGIN_FILE_NM));
		    		 mail.setConapplicationfilepath( (String)map.get(Globals.UPLOAD_FILE_NM));
		    	 }
		    	 if(currentFileName.equals("confinalfilename")){
		    		 mail.setConfinalfilename( (String)map.get(Globals.ORIGIN_FILE_NM));
		    		 mail.setConfinalfilepath( (String)map.get(Globals.UPLOAD_FILE_NM));
		    	 }
		    	 if(currentFileName.equals("consummaryfilename")){
		    		 mail.setConsummaryfilename( (String)map.get(Globals.ORIGIN_FILE_NM));
		    		 mail.setConsummaryfilepath( (String)map.get(Globals.UPLOAD_FILE_NM));
		    	 }
		     }*/
        }
        try {
            String idx     = this.mailService.insertMail(mail);
            String usernos = mail.getUsernos();
            if (!(usernos == null || usernos.equals(""))) {
                String[]     arrUsernos  = usernos.split(",");
                List<String> listUsernos = new ArrayList<String>();
                for (int i = 0; arrUsernos.length > i; i++) {
                    listUsernos.add(arrUsernos[i]);
                }

                if (listUsernos.size() > 0) {
                    mail.setIdx(idx);
                    mail.setListUsernos(listUsernos);
                    mailService.inserMailList(mail);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/mail/index.html";

    }

    //수정
    @RequestMapping(value = "update.html", method = RequestMethod.GET)
    public String update(
        @ModelAttribute("mail") Mail mail
        , Model model
        , HttpServletRequest request) throws Exception {

        StringBuilder url = new StringBuilder("?keyword=");
        url.append(mail.getKeyword());
        url.append("&idx=");
        url.append(mail.getIdx());
        url.append("&pageIndex=");
        url.append(mail.getPageIndex());
        model.addAttribute("url", url);

        List<MailParticipant> mailParticipantList = new ArrayList<MailParticipant>();

        try {
            mail = this.mailService.getMail(mail);
            mailParticipantList = this.mailService.getMailParticipantList(mail);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("mail", mail);
        model.addAttribute("mailParticipantList", mailParticipantList);

        return viewPath + "update";
    }

    //수정 insert
    @RequestMapping(value = "update.html", method = RequestMethod.POST)
    public String update_confirm(
        HttpServletResponse response
        , @ModelAttribute("mail") Mail mail
        , BindingResult err
        , HttpServletRequest request
        , HttpSession session) throws Exception {

        StringBuilder url = new StringBuilder("?keyword=");
        url.append(mail.getKeyword());
        url.append("&idx=");
        url.append(mail.getIdx());
        url.append("&pageIndex=");
        url.append(mail.getPageIndex());



		/* MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest)request;

		 Iterator<String> fileIter = mptRequest.getFileNames();

		 //file upload
		 while (fileIter.hasNext()) {
		     String currentFileName = (String) fileIter.next();
		     System.out.println("Name ==== "+currentFileName);
		     MultipartFile mFile = mptRequest.getFile(currentFileName);
		     if (mFile.getSize() > 0) {
		    	 HashMap map = EgovFileMngUtil.uploadFile(mFile,"Globals.confernce.upload.path");
                //필드명별로 저장 경로 바꿈
		    	 if(currentFileName.equals("conoutlinefilename")){
		    		 mail.setConoutlinefilename( (String)map.get(Globals.ORIGIN_FILE_NM));
		    		 mail.setConoutlinefilepath( (String)map.get(Globals.UPLOAD_FILE_NM));
		    	 }
		    	 if(currentFileName.equals("conapplicationfilename")){
		    		 mail.setConapplicationfilename( (String)map.get(Globals.ORIGIN_FILE_NM));
		    		 mail.setConapplicationfilepath( (String)map.get(Globals.UPLOAD_FILE_NM));
		    	 }
		    	 if(currentFileName.equals("confinalfilename")){
		    		 mail.setConfinalfilename( (String)map.get(Globals.ORIGIN_FILE_NM));
		    		 mail.setConfinalfilepath( (String)map.get(Globals.UPLOAD_FILE_NM));
		    	 }
		    	 if(currentFileName.equals("consummaryfilename")){
		    		 mail.setConsummaryfilename( (String)map.get(Globals.ORIGIN_FILE_NM));
		    		 mail.setConsummaryfilepath( (String)map.get(Globals.UPLOAD_FILE_NM));
		    	 }
		     }
		 }
		 Mail _mail = new Mail();
		 _mail.setConidx(mail.getConidx());
		 _mail = this.mailService.getMail(_mail);
		 //첨부파일 필드 비어있으면 기존것으로 채운다
    	 if(mail.getConoutlinefilename() == null && _mail.getConoutlinefilename() != null){
    		 mail.setConoutlinefilename( _mail.getConoutlinefilename());
    		 mail.setConoutlinefilepath( _mail.getConoutlinefilepath());
    	 }
    	 if(mail.getConoutlinefilename() == null && _mail.getConoutlinefilename() != null){
    		 mail.setConoutlinefilename( _mail.getConoutlinefilename());
    		 mail.setConoutlinefilepath( _mail.getConoutlinefilepath());
    	 }
    	 if(mail.getConfinalfilename() == null && _mail.getConfinalfilename() != null){
    		 mail.setConfinalfilename( _mail.getConfinalfilename());
    		 mail.setConfinalfilepath( _mail.getConfinalfilepath());
    	 }
    	 if(mail.getConsummaryfilename() == null && _mail.getConsummaryfilename() != null){
    		 mail.setConsummaryfilename( _mail.getConsummaryfilename());
    		 mail.setConsummaryfilepath( _mail.getConsummaryfilepath());
    	 }*/
        try {
            //메일기본 정보 업데이트
            this.mailService.updateMail(mail);

            //메일 유저정보 삭제
			/*mailService.deleteMailList(mail);
			String usernos=mail.getUsernos();
			if(!(usernos == null || usernos.equals(""))){
				String[] arrUsernos =  usernos.split(",");
				List<String> listUsernos = new ArrayList<String>();
				for(int i=0;arrUsernos.length > i;i++){
					listUsernos.add(arrUsernos[i]);
				}

				if(listUsernos.size() > 0){
					mail.setListUsernos(listUsernos);
					mailService.inserMailList(mail);
				}
			}*/


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/mail/update.html" + url;
    }

    // 삭제
    @RequestMapping("delete.html")
    public String delete(
        @RequestParam("idx") int[] idx,
        @ModelAttribute("mail") Mail mail, BindingResult err, HttpServletRequest request)
        throws Exception {
        StringBuilder url = new StringBuilder("?keyword=");
        url.append(mail.getKeyword());
        url.append("&idx=");
        url.append(mail.getIdx());
        url.append("&pageIndex=");
        url.append(mail.getPageIndex());

        List<Integer> arrDeleteNo = new ArrayList<Integer>(idx.length);
        for (int i = 0; i < idx.length; i++) {
            arrDeleteNo.add(idx[i]);
        }

        this.mailService.deleteMailAll(arrDeleteNo);//service에서 authoirity도 함께 삭제
//    	this.mailDebateService.deleteMailDebateAllByFk(arrDeleteNo);
//    	this.mailPaperService.deleteMailPaperAllByFk(arrDeleteNo);
        this.mailParticipantService.deleteMailParticipantAllByFk(arrDeleteNo);
        return "redirect:/admsys/mail/index.html" + url;
    }


    @RequestMapping(value = "participant.html")
    public String participant(
        @ModelAttribute("mail") Mail mail
        , Model model
        , HttpServletRequest request
        , HttpSession session) throws Exception {

        try {
            List<MailParticipant> mailParticipantList = new ArrayList<MailParticipant>();

            try {
                mailParticipantList = this.mailService.getMailParticipantList(mail);

            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("mailParticipantList", mailParticipantList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return viewPath + "participant";
    }

    @ResponseBody
    @RequestMapping(value = "/mailSendQuick.html")
    public String selectMailListQuick(
        HttpServletRequest request, HttpServletResponse response
        , @RequestParam(value = "idx", required = true) String idx
        , HttpSession session) throws Exception {

        try {
            System.out.println("[Mail Module START] ------------------");
            Mail mail = new Mail();
            mail.setIdx(idx);
            mail = mailDAO.getMail(mail);

            if (mail != null) {
                //위아래로 이미지 부착
//				mail.setConts("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"
//				+ "<html lang='ko' xml:lang='ko' xmlns='http://www.w3.org/1999/xhtml'>"
//				+ "<head>"
//				+ "<title>대한국토·도시계획학회</title>"
//				+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />"
//				+ "<link rel='stylesheet' href='http://"+EgovProperties.getProperty("Globals.server.name")+"/var/ckeditor/plugins/fontawesome/font-awesome/css/font-awesome.min.css' type='text/css' />"
//				+ "</head>"
//				+ "<body leftmargin='0' marginheight='0' marginwidth='0' topmargin='0'>"
//				+mail.getConts()
//				+ "</body>"
//				+ "</html>");

                mail.setConts(mail.getConts());

                List<MailParticipant> mailParticipantList = new ArrayList<MailParticipant>();
                mailParticipantList = mailDAO.getMailParticipantList(mail);
                System.out.println("MailParticipant List count: " + mailParticipantList.size());

                mail.setSended("2"); //발송중으로 변경
                mailDAO.updateMailToSended(mail);

                if (mailParticipantList.size() > 0) {
                    for (int j = 0; mailParticipantList.size() > j; j++) {
                        MailParticipant mailParticipant = new MailParticipant();
                        mailParticipant = mailParticipantList.get(j);
                        if (mailParticipant.getNewsletter1() == null || !mailParticipant.getNewsletter1().equals("1")) {
                            System.out.println("Not Want Email : " + mailParticipant.getIdx() + " " + mailParticipant.getUsername() + " " + mailParticipant.getUseremail());
                            continue;
                        }
                        if (!(mailParticipant.getUseremail() == null || mailParticipant.getUseremail().equals(""))) {

                            //String to, String from, String fromName,String title, String msg
                            try {
                                FormMail.sendMail(
                                    mailParticipant.getUseremail()
                                    , mail.getFromemail()
                                    , "대한국토·도시계획학회"
                                    , mail.getTitle()
                                    , mail.getConts()
                                );

                                if (mailParticipant.getUserno() == null || mailParticipant.getUserno().equals("")) {    //회원일경우
                                    mailParticipant.setUserno(null);
                                } else { //비회원일경우
                                    mailParticipant.setUseremail(null);
                                }

                                //개별메일에 대한 보냄설정
                                mailDAO.updateMailParticipantToSended(mailParticipant);
                                System.out.println("SENDED : " + mailParticipant.getIdx() + " " + mailParticipant.getUsername() + " " + mailParticipant.getUseremail());
                            } catch (Exception e) {
                                System.out.println("SEND ERROR : " + mailParticipant.getIdx() + " " + mailParticipant.getUsername() + " " + mailParticipant.getUseremail());
                            }

                        }
                    }
                }//개별 메일 발송 끝남
            }
            //해당mail sended로 바꿀것
            mail.setSended("1"); //발송완료로 변경
            mailDAO.updateMailToSended(mail);

            System.out.println("[Mail Module   END] ------------------");

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

        return "1";
    }


    public String quickMail(String idx) throws Exception {

        try {
            System.out.println("[Mail Module START] ------------------");
            Mail mail = new Mail();
            mail.setIdx(idx);
            mail = mailDAO.getMail(mail);

            if (mail != null) {
                //위아래로 이미지 부착
//				mail.setConts("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"
//				+ "<html lang='ko' xml:lang='ko' xmlns='http://www.w3.org/1999/xhtml'>"
//				+ "<head>"
//				+ "<title>대한국토·도시계획학회</title>"
//				+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />"
//				+ "<link rel='stylesheet' href='http://"+EgovProperties.getProperty("Globals.server.name")+"/var/ckeditor/plugins/fontawesome/font-awesome/css/font-awesome.min.css' type='text/css' />"
//				+ "</head>"
//				+ "<body leftmargin='0' marginheight='0' marginwidth='0' topmargin='0'>"
//				+mail.getConts()
//				+ "</body>"
//				+ "</html>");

                mail.setConts(mail.getConts());

                List<MailParticipant> mailParticipantList = new ArrayList<MailParticipant>();
                mailParticipantList = mailDAO.getMailParticipantList(mail);
                System.out.println("MailParticipant List count: " + mailParticipantList.size());

                mail.setSended("2"); //발송중으로 변경
                mailDAO.updateMailToSended(mail);

                if (mailParticipantList.size() > 0) {
                    for (int j = 0; mailParticipantList.size() > j; j++) {
                        MailParticipant mailParticipant = new MailParticipant();
                        mailParticipant = mailParticipantList.get(j);
						/*if(mailParticipant.getNewsletter1() == null || !mailParticipant.getNewsletter1().equals("1")){
							System.out.println("Not Want Email : " + mailParticipant.getIdx()+" "+ mailParticipant.getUsername() + " " + mailParticipant.getUseremail());
							continue;
						}*/
                        if (!(mailParticipant.getUseremail() == null || mailParticipant.getUseremail().equals(""))) {

                            //String to, String from, String fromName,String title, String msg
                            try {
                                FormMail.sendMail(
                                    mailParticipant.getUseremail()
                                    , mail.getFromemail()
                                    , "우수문화상품"
                                    , mail.getTitle()
                                    , mail.getConts()
                                );

								/*if(mailParticipant.getUserNo() == null || mailParticipant.getUserNo().equals("")){	//회원일경우
									mailParticipant.setUserno(null);
								}else{ //비회원일경우
									mailParticipant.setUseremail(null);
								}*/

                                //개별메일에 대한 보냄설정
                                mailDAO.updateMailParticipantToSended(mailParticipant);
                                System.out.println("SENDED : " + mailParticipant.getIdx() + " " + mailParticipant.getUsername() + " " + mailParticipant.getUseremail());
                            } catch (Exception e) {
                                System.out.println("SEND ERROR : " + mailParticipant.getIdx() + " " + mailParticipant.getUsername() + " " + mailParticipant.getUseremail());
                            }

                        }
                    }
                }//개별 메일 발송 끝남
            }
            //해당mail sended로 바꿀것
            mail.setSended("1"); //발송완료로 변경
            mailDAO.updateMailToSended(mail);

            System.out.println("[Mail Module   END] ------------------");

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

        return "1";
    }


}
