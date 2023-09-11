package com.z5.zcms.admsys.user.web;

import static com.z5.zcms.util.ZPrint.enter;
import static com.z5.zcms.util.ZPrint.error;
import static com.z5.zcms.util.ZPrint.param;
import static com.z5.zcms.util.ZPrint.print;
import static egovframework.com.cmm.service.EgovProperties.getPathProperty;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
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

import com.z5.zcms.admsys.board.service.BoardService;
import com.z5.zcms.admsys.board.service.CateService;
import com.z5.zcms.admsys.events.service.EventsService;
import com.z5.zcms.admsys.menu.service.ZmenuService;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserLogService;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.IpUtil;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.Validator;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngUtil;

@Controller
@RequestMapping("/admsys/user/common/")
public class UserController {
    private final Logger log        = Logger.getLogger(this.getClass());
    private final String RETURN_URL = "/zcms/admsys/user/common/";
    @Autowired
    ZUserService    userService;
    @Autowired
    EventsService   eventsService;
    @Autowired
    ZUserDAO        userDAO;
    @Autowired
    ZUserLogService userLogService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    BoardService    boardService;
    @Autowired
    CateService     cateService;
    @Autowired
    private ZmenuService zmenuService;

    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;

    @RequestMapping("searchIndex.html")
    public String searchIndex(@ModelAttribute("zUserVo") ZUserVo zUserVo, Model model, HttpServletRequest req) {
        try {
            //승인대기
            zUserVo.setCond7("0");
            zUserVo.setUserconfirm("Y"); //결제한 회원
            int semiUserCount = this.userService.listCount(zUserVo, "user");

            //탈퇴대기
            zUserVo.setCond7("3");
            int outUserCount = this.userService.listCount(zUserVo, "user");

            model.addAttribute("semiUserCount", semiUserCount);
            model.addAttribute("outUserCount", outUserCount);
            model.addAttribute("userType", req.getParameter("userType"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RETURN_URL + "searchIndex";
    }

    @RequestMapping("index.html")
    public String index(@ModelAttribute("zUserVo") ZUserVo zUserVo, Model model, HttpServletRequest req) {
        try {
            DataTable data = new DataTable(req);

            String grade = data.get("work_grade");
            if (grade.equals("") || grade.equals("all")) {
                zUserVo.setWork_grade("");
            } else {
                if (grade.equals("3")) {
                    zUserVo.setWork_grade("2");
                    zUserVo.setUserstatus("2"); //지정업체
                } else {
                    zUserVo.setWork_grade(grade);
                    zUserVo.setUserstatus("1"); //지정업체
                }
            }

//          int pageSize = data.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            int pageSize = data.getInt("pageSize", 20);
            if (data.getInt("pageIndex") == 0) {
                data.put("pageIndex", 1);
            }
            int    pageIndex = data.getInt("pageIndex") - 1;
            String keyword   = data.get("keyword");

            int m = pageIndex * pageSize;
            int n = pageSize;

            if (keyword.equals("")) {
                zUserVo.setCond2("");
            } else {
                zUserVo.setCond2(data.get("cond2"));
            }

            zUserVo.setM(m);
            zUserVo.setN(n);

            //Total users
            int total = this.userService.listCount(zUserVo, "user");

            zUserVo.setUsercate("1");
            int users = this.userService.listCount(zUserVo, "user");
            zUserVo.setUsercate("2");
            int firms = this.userService.listCount(zUserVo, "user");

            data.put("total", total);
            data.put("users", users);
            data.put("firms", firms);
            data.put("pageSize", pageSize);
            data.put("pageMax", (int) Math.ceil((double) total / pageSize));

            zUserVo.setUsercate("");
            List<ZUserVo> list = this.userService.getList(zUserVo, "user");
            model.addAttribute("list", list);
            model.addAttribute("data", data);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RETURN_URL + "index";
    }

    // 회원정보수정
    @RequestMapping(value = "update.html", method = RequestMethod.GET)
    public String update(
            @RequestParam(value = "userno", required = false) int userno,
            HttpServletRequest req,
            Model model
    ) throws Exception {
        enter(req);
        try {
            ZUserVo userVo = new ZUserVo();
            userVo.setUserno(Integer.toString(userno));
            userVo = userService.selectbypk(userVo);

            List<ZUserVo> logVos = userLogService.selectLog(userVo);
            if (logVos.size() > 0) {
                userVo.setLogdate(logVos.get(0).getLogdate());
            }

            model.addAttribute("user", userVo);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return RETURN_URL + "update";
    }

    // 회원정보수정
    @RequestMapping(value = "update.html", method = RequestMethod.POST)
    public String updateUser(
            @ModelAttribute("zUserVo") ZUserVo userVo,
            @RequestParam(value = "userno", required = false) String userno,
            HttpServletRequest req, Model model
    ) {
        try {
            ZUserVo saveVo = new ZUserVo();
            saveVo.setUserno(userno);
            saveVo = userDAO.getInfo(saveVo);

            if (StringUtils.isNotBlank(userVo.getUserpasswd())) { //비밀번호를 입력했을 경우 입력된 비밀번호를 암호화한다.
                userVo.setUserpasswd(passwordEncoder.encodePassword(userVo.getUserpasswd(), null));
            }
            print(userVo.toString());
            userDAO.update(userVo);

            if (StringUtils.equals(saveVo.getEnabled(), "0")) {
                userVo.setAuthority("ROLE_USER");
                userDAO.insertAuth(userVo);
            }

            String userid = SecuritySessionUtil.getUserid(req);
            if (StringUtils.isBlank(userid)) { //세션이 아웃되었을 경우 로그인창으로 이동한다.
                model.addAttribute("sessionout", "true");
            } else {
                ZUserVo user = new ZUserVo();
                user.setUserid(userid);//세션에서 아이디를 받아와서 검증한다.
                user = userDAO.getInfo(user);
                model.addAttribute("user", user);
            }

            model.addAttribute("modifysuccess", "true");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/admsys/user/common/update.html?userno=" + userno;
    }

    // 회원정보수정
    @RequestMapping(value = "resign.html", method = RequestMethod.POST)
    public String resignUsers(@RequestParam(value = "userno") String[] userno, HttpServletRequest req, Model model) {
        try {
            print("Resign users :: ", userno);
            for (String no : userno) {
                ZUserVo userVo = new ZUserVo();
                userVo.setUserno(no);
                userVo.setEnabled("0");
                userDAO.update(userVo);

                userDAO.deleteOneAuth(userVo);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/admsys/user/common/index.html";
    }

    // 외부심사위원 추가
    @RequestMapping(value = "insert.html", method = RequestMethod.GET)
    public String insert(HttpServletRequest req, Model model)
            throws Exception {

        try {
            //email domain 공통코드 가져온다.
            ComDefaultCodeVO vo = new ComDefaultCodeVO();
            vo.setCodeId("ZCM001"); //코드를 변경할것
            List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);
            model.addAttribute("emaildomain", codeResult);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return RETURN_URL + "insert";
    }

    // 외부심사위원 추가
    @RequestMapping(value = "insert.html", method = RequestMethod.POST)
    public String insertPost(@ModelAttribute("zUserVo") ZUserVo zUserVo, HttpServletRequest request, Model model, HttpSession session) {
        enter();
        param(request);

        try {
            zUserVo.setUserpasswd(passwordEncoder.encodePassword(zUserVo.getUserpasswd(), null));
            zUserVo.setUserauth("2");

//            zUserVo.setUseremail(data.get("email1") + "@" + data.get("email2"));
//            zUserVo.setUsertel(data.get("tel1") + "-" + data.get("tel2") + "-" + data.get("tel3"));

            zUserVo.setAuthority("ROLE_USER");
            zUserVo.setUsercnt(String.valueOf(0));
//            zUserVo.setUseripreg(IpUtil.getIpAddr(request));
            zUserVo.setSitedomain(request.getServerName().replaceFirst("www.", ""));
            zUserVo.setEnabled(String.valueOf(1));
//            zUserVo.setUserconfirm(String.valueOf(1));

            userDAO.insert(zUserVo);
            userDAO.insertAuth(zUserVo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/admsys/user/common/index.html";
    }

    // 회원정보삭제
    //Delete
    @RequestMapping("delete.html")
    public String delete(
            Model model,
            @RequestParam("userno") int[] userno,
            @ModelAttribute("zUserVo") ZUserVo zUserVo, BindingResult err, HttpServletRequest req)
            throws Exception {

        List<Integer> arrDeleteNo = new ArrayList<Integer>(userno.length);
        for (int no : userno) {
            arrDeleteNo.add(no);
        }

        userService.delete(arrDeleteNo);//service에서 authoirity도 함께 삭제

        model.addAttribute("usertype", zUserVo.getUsertype());
        model.addAttribute("cond6", zUserVo.getCond6());
        model.addAttribute("cond7", zUserVo.getCond7());
        model.addAttribute("keyword", zUserVo.getKeyword());
        model.addAttribute("st_sec1", zUserVo.getSt_sec1());
        model.addAttribute("st_sec2", zUserVo.getSt_sec2());

        return "redirect:/admsys/user/common/index.html";
    }

    //유저강제인증
    @RequestMapping("usercommit.html")
    @ResponseBody
    public int usercommit(@RequestParam("userid") String userid) {
        try {
            this.userDAO.updateEnabledToOne(userid);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return 1;
    }


    //유저비밀번호 초기화
    @RequestMapping("userPassInit.html")
    @ResponseBody
    public int userPassInit(@RequestParam("userno") String userno) {
        try {
            ZUserVo vo = new ZUserVo();
            vo.setUserno(userno);
            vo.setUserpasswd("A6xnQhbz4Vx2HuGl4lXwZ5U2I8iziLRFnhP5eNfIRvQ=");
            userDAO.updateUserPasswd(vo);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return 1;
    }

    //kpa 회원탈퇴 승인
    @RequestMapping(value = "EnabledToZero.html", method = RequestMethod.GET)
    public String EnabledToZero(
            @RequestParam(value = "userno", required = false) String userno,
            HttpServletRequest req, Model model) {

        try {

            String act = req.getParameter("act");

            if (act == null) act = "";

            if (act.equals("c")) { //탈퇴신청 취소
                userDAO.updateRequestEnabledToNomal(userno);
            } else { //탈퇴승인
                userDAO.updateEnabledToZero(userno);
            }


        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "redirect:/admsys/user/common/searchIndex.html";

    }


    @RequestMapping(value = "/excel.html")
    public String excel(
            @ModelAttribute("zUserVo") ZUserVo zUserVo,
            Model model,
            HttpServletRequest request,
            HttpSession session
    ) {
        DataTable args = new DataTable(request);
        try {
            List<ZUserVo> list = this.userService.searchListUser(zUserVo); //검색일경우 전체 리스트 정보 가져오기(메일및 엑셀다운위해)
            model.addAttribute("file", URLEncoder.encode("회원목록", "UTF-8"));
            model.addAttribute("list", list);
            model.addAttribute("args", args);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return "/zcms/admsys/user/common/excel";
    }
    
    @RequestMapping(value = "/visitExcel.html")
    public String visitExcel(
            @ModelAttribute("zUserVo") ZUserVo zUserVo,
            Model model,
            HttpServletRequest req,
            HttpSession session
    ) {
        DataTable input = new DataTable(req);
        try {

            zUserVo.setSiteno(input.getInt("siteno"));
            List<ZUserVo> visitLogList = userLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.

            int todayCount = 0;

            if (visitLogList.size() > 0)
                todayCount = Integer.parseInt(visitLogList.get(0).getCount()); //금일 방문객

            zUserVo.setCond1("todayMonth");
            List<ZUserVo> todayMonthList  = userLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.
            int           todayMonthCount = 0;

            if (todayMonthList.size() > 0)
                todayMonthCount = Integer.parseInt(todayMonthList.get(0).getCount()); //이달 방문객

            zUserVo.setCond1("maxToday");
            List<ZUserVo> maxTodayList  = userLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.
            int           maxTodayCount = 0;

            if (maxTodayList.size() > 0)
                maxTodayCount = Integer.parseInt(maxTodayList.get(0).getCount()); //일일 최고치


            model.addAttribute("todayCount", todayCount);   //금일 방문객
            model.addAttribute("maxTodayCount", maxTodayCount);   //일일 최고치
            model.addAttribute("todayMonthCount", todayMonthCount); //이달 방문객

            
            zUserVo.setCond1("year");
	        List<ZUserVo> yearCountList = userLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.
	        
	        //연도 넣기
	        zUserVo.setYearList(yearCountList);
	        
	        for (int i = 0; i < yearCountList.size(); i++) {
				
	        	
	        	zUserVo.setCond1("month");
                zUserVo.setVisitdate(yearCountList.get(i).getVisitdate());
                List<ZUserVo> monthCountList = userLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.
                
                //월 넣기
                zUserVo.getYearList().get(i).setMonthList(monthCountList);
                
	        	int year  = Integer.parseInt(yearCountList.get(i).getVisitdate());
	            
	            for (int j = 0; j < monthCountList.size(); j++) {
	            	
	            	
	            	String month = monthCountList.get(j).getVisitdate();
	            	Calendar calendar = Calendar.getInstance();
		            calendar.set(year, Integer.parseInt(month) - 1, 1);

		            int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		            zUserVo.setCond1("day");
		            zUserVo.setVisitdate(year + month);
		            List<ZUserVo> dayCountList = userLogService.selectVisitLog(zUserVo); //일별 방문객

		            //일 카운트 넣기
		            zUserVo.getYearList().get(i).getMonthList().get(j).setDayList(dayCountList);
		            zUserVo.getYearList().get(i).getMonthList().get(j).setDayOfMonth(Integer.toString(dayOfMonth));
		            
				}
	            
	            
	        }

	        int total = 0;
	        for (ZUserVo zUserVo2 : yearCountList) {
	        	total += Integer.parseInt(zUserVo2.getCount());
	        }
            model.addAttribute("totalCnt", total); //총년수별 방문객
            model.addAttribute("input", input);
            model.addAttribute("list", zUserVo.getYearList());
        	
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return "/zcms/admsys/user/common/visitExcel";
    }

    @RequestMapping(value = "/batch.html", method = RequestMethod.GET)
    public String batchGetter(Model model, HttpServletRequest request, HttpSession session) {
        enter(request);
        DataTable args = new DataTable(request);
        try {
            args.put("sample", "/usr/file/nime-member-sample.xls");
            model.addAttribute("args", args);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return "/zcms/admsys/user/common/excelUploader";
    }

    @RequestMapping(value = "/batch.html", method = RequestMethod.POST)
    public String batchPoster(Model model, HttpServletRequest request, HttpSession session) {
        DataTable args = new DataTable(request);
        try {
            int success = 0;
            int failure = 0;

            if (request instanceof MultipartHttpServletRequest) {
                MultipartHttpServletRequest part = (MultipartHttpServletRequest) request;
                Iterator<String>            iter = part.getFileNames();

                if (iter.hasNext()) {
                    MultipartFile mpf = part.getFile(iter.next());
                    String        one = mpf.getOriginalFilename();
                    String        two = FileUtil.makeNewFileName(one);
                    String        dir = getPathProperty("Globals.upload.tmp");

                    if (!mpf.isEmpty()) {
                        EgovFileMngUtil.writeUploadedFile(mpf, two, dir);
                        FileUtil.deleteFile(Validator.path(dir + System.getProperty("file.separator") + one));

                        Workbook workbook = WorkbookFactory.create(new File(Validator.path(dir + System.getProperty("file.separator") + two)));
                        Sheet    sheet    = workbook.getSheetAt(0);

                        // Create a DataFormatter to format and get each cell's value as String
                        DataFormatter dataFormatter = new DataFormatter();

                        for (Row row : sheet) {
                            if (row.getRowNum() == 0) {
                                // It's title row
                                continue;
                            }

                            ZUserVo vo = new ZUserVo();
                            for (Cell cell : row) {
                                String value = dataFormatter.formatCellValue(cell);
                                switch (cell.getColumnIndex()) {
                                    case 0:
                                        if (StringUtils.isBlank(value)) {
                                            error("blank user id!");
                                            continue;
                                        }
                                        vo.setUserid(value);
                                        break;
                                    case 1:
                                        if (StringUtils.isBlank(value)) {
                                            error("blank password!");
                                            continue;
                                        }
                                        vo.setUserpasswd(passwordEncoder.encodePassword(value, null));
                                        break;
                                    case 2:
                                        if (StringUtils.isBlank(value)) {
                                            error("blank username!");
                                            continue;
                                        }
                                        vo.setUsername(value);
                                        break;
                                    case 3:
                                        if (value.equals("일반")) {
                                            vo.setUsercate("1");
                                        } else if (value.equals("기관")) {
                                            vo.setUsercate("2");
                                        } else {
                                            vo.setUsercate("1");
                                        }
                                        break;
                                    case 4:
                                        vo.setUsernick(value);
                                        break;
                                    case 5:
                                        vo.setUseraddr(value);
                                        break;
                                }
                            }

                            if (userDAO.getSameUserIdCount(vo.getUserid()) <= 0) {
                                vo.setUserstatus("1");
                                vo.setUserauth("2");
                                vo.setAuthority("ROLE_USER");
                                vo.setUsercnt(String.valueOf(0));
                                vo.setUseripreg(IpUtil.getIpAddr(request));
                                vo.setSitedomain(request.getServerName().replaceFirst("www.", ""));
                                vo.setEnabled(String.valueOf(1));
//                                vo.setUserconfirm(String.valueOf(1));

                                userDAO.insert(vo);
                                userDAO.insertAuth(vo);
                                success++;
                            } else {
                                failure++;
                                error(vo.getUserid() + " already exists.");
                            }
                        }

                        // Closing the workbook
                        workbook.close();
                        FileUtil.deleteFile(Validator.path(dir + System.getProperty("file.separator") + two));
                    } else {
                        error("file is empty");
                    }
                }
            }

            args.put("action", "insert");
            args.put("success", success);
            args.put("failure", failure);
            model.addAttribute("args", args);
            print("args", args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/user/common/excelUploader";
    }

    //메일 카운트 가져오기
    @ResponseBody
    @RequestMapping(value = "getUserCount.html")
    public int getConferenceCount(Model model, HttpServletRequest req) {

        int size = 0;
        try {
            String act        = req.getParameter("act");
            String work_grade = req.getParameter("work_grade");

            if (act.equals("user")) {
                ZUserVo zUserVo = new ZUserVo();
                zUserVo.setWork_grade(work_grade);
                size = this.userService.listCount(zUserVo, "user");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return size;
    }

    //회원통계
    @RequestMapping("userStats.html")
    public String userStats(Model model, HttpServletRequest req) {

        try {

            ZUserVo zUserVo = new ZUserVo();
            zUserVo.setCond7("1");
            int totalCount = this.userService.listCount(zUserVo, "user"); //전체 회원수

            zUserVo.setWorkGrade("1"); //정회원수
            int regularCount = this.userService.listCount(zUserVo, "user"); //전체 회원수

            zUserVo.setWorkGrade("2"); //종신회원수
            int lfeCount = this.userService.listCount(zUserVo, "user"); //전체 회원수

            zUserVo.setWorkGrade("3"); //준회원수
            int associateCount = this.userService.listCount(zUserVo, "user"); //전체 회원수


            model.addAttribute("totalCount", totalCount);
            model.addAttribute("regularCount", regularCount);
            model.addAttribute("lfeCount", lfeCount);
            model.addAttribute("associateCount", associateCount);

            //지회구분 공통코드가져오기
            ComDefaultCodeVO vo = new ComDefaultCodeVO();
            vo.setCodeId("KPA202"); //코드를 변경할것

            List<CmmnDetailCode> cmmList = cmmUseService.selectCmmCodeDetail(vo);

            model.addAttribute("branch", cmmList);

            List<ZUserVo> branchCountList = new ArrayList<ZUserVo>();
            ZUserVo       countVo         = null;

            for (int i = 0; i < cmmList.size(); i++) {

                zUserVo = new ZUserVo();
                zUserVo.setCond7("1");
                zUserVo.setBranch(cmmList.get(i).getCode());

                countVo = new ZUserVo();
                countVo.setCond1(cmmList.get(i).getCodeNm());
                countVo.setCond2(Integer.toString(this.userService.listCount(zUserVo, "user")));

                for (int j = 1; j < 4; j++) {

                    zUserVo.setWorkGrade(Integer.toString(j));
                    zUserVo.setBranch(cmmList.get(i).getCode());

                    if (j == 1) {
                        countVo.setCond3(Integer.toString(this.userService.listCount(zUserVo, "user")));
                    } else if (j == 2) {
                        countVo.setCond4(Integer.toString(this.userService.listCount(zUserVo, "user")));
                    } else if (j == 3) {
                        countVo.setCond5(Integer.toString(this.userService.listCount(zUserVo, "user")));
                    }

                }

                branchCountList.add(countVo);

            }

            model.addAttribute("branchCountList", branchCountList);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return RETURN_URL + "userStats";
    }
    
    @RequestMapping(value = "visitIndex")
    public String selectZmenuList(
            @ModelAttribute("zsiteVo") ZsiteVo zsiteVo
            , Model model, HttpServletRequest req) throws Exception {

        DataTable input = new DataTable(req);

        model = zmenuService.index(zsiteVo, input, model);

        return RETURN_URL + "visitIndex";
    } 

    //방문자통계
    @RequestMapping("visitStats.html")
    public String visitStats(Model model, HttpServletRequest req) {

        try {

            DataTable input = new DataTable(req);

            String totalCnt = req.getParameter("totalCnt");

            ZUserVo       zUserVo      = new ZUserVo();
            zUserVo.setSiteno(input.getInt("siteno"));
            List<ZUserVo> visitLogList = userLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.

            int todayCount = 0;

            if (visitLogList.size() > 0)
                todayCount = Integer.parseInt(visitLogList.get(0).getCount()); //금일 방문객

            zUserVo.setCond1("todayMonth");
            List<ZUserVo> todayMonthList  = userLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.
            int           todayMonthCount = 0;

            if (todayMonthList.size() > 0)
                todayMonthCount = Integer.parseInt(todayMonthList.get(0).getCount()); //이달 방문객

            zUserVo.setCond1("maxToday");
            List<ZUserVo> maxTodayList  = userLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.
            int           maxTodayCount = 0;

            if (maxTodayList.size() > 0)
                maxTodayCount = Integer.parseInt(maxTodayList.get(0).getCount()); //일일 최고치


            model.addAttribute("todayCount", todayCount);   //금일 방문객
            model.addAttribute("maxTodayCount", maxTodayCount);   //일일 최고치
            model.addAttribute("todayMonthCount", todayMonthCount); //이달 방문객

            String act = req.getParameter("act");

            if (act == null)
                act = "year";

            if (act.equals("year")) {
                zUserVo.setCond1("year");
                List<ZUserVo> yearCountList = userLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.


                int total = 0;
                for (ZUserVo zUserVo2 : yearCountList) {
                    total += Integer.parseInt(zUserVo2.getCount());
                }

                totalCnt = Integer.toString(total);

                model.addAttribute("yearCountList", yearCountList); //총년수별 방문객
            } else if (act.equals("month")) {

                zUserVo.setCond1("month");
                zUserVo.setVisitdate(req.getParameter("value"));
                List<ZUserVo> monthCountList = userLogService.selectVisitLog(zUserVo); //로그인 시 로그인 로그를 기록한다.

                model.addAttribute("act", act);
                model.addAttribute("monthCountList", monthCountList);   //월별 방문객
                model.addAttribute("year", req.getParameter("value"));   //년도
                model.addAttribute("yearCount", req.getParameter("yearCount"));   //년도 방문객

            } else if (act.equals("day")) {

                int year  = Integer.parseInt(req.getParameter("year"));
                int month = Integer.parseInt(req.getParameter("month"));

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month - 1, 1);

                int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                model.addAttribute("year", year);   //월의 마지막일
                model.addAttribute("month", month);   //월의 마지막일
                model.addAttribute("dayOfMonth", dayOfMonth);   //월의 마지막일

//              String sMonth = req.getParameter("month");
//              if(month < 10){
//                  sMonth = "0"+sMonth;
//              }

                zUserVo.setCond1("day");
                zUserVo.setVisitdate(req.getParameter("year") + req.getParameter("month"));
                List<ZUserVo> dayCountList = userLogService.selectVisitLog(zUserVo); //일별 방문객

                model.addAttribute("dayCountList", dayCountList);

                zUserVo.setCond1("monthCount");
                zUserVo.setVisitdate(req.getParameter("year") + req.getParameter("month"));
                List<ZUserVo> monthCount = userLogService.selectVisitLog(zUserVo); //월 카운트

                model.addAttribute("monthCount", monthCount.get(0).getCount());

            }

            model.addAttribute("act", act);
            model.addAttribute("totalCnt", totalCnt); //총년수별 방문객

            model.addAttribute("input", input);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RETURN_URL + "visitStats";
    }

    //KPA 회원 승인
    @RequestMapping("changeUserStatus.html")
    @ResponseBody
    public String changeUserStatus(
            @ModelAttribute("zUserVo") ZUserVo zUserVo

    ) {
        try {
            this.userService.updateUserStatus(zUserVo);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

        return "1";
    }
    
    @RequestMapping(value = "chkpassword.html")
    public String chkpassword(HttpServletRequest req,Model model) throws Exception {
    		
    	String val = req.getParameter("chkPassDay"); 	
    	model.addAttribute("chkVal", val);
      
        return "/zcms/admsys/site/adminip/chkpassword";
    } 
    
    @SuppressWarnings("deprecation")
	@RequestMapping(value = "updatepassword.html")
    @ResponseBody
    public Map<String , String> updatePassword(HttpServletRequest req) throws Exception {
    	
    	Map<String , String> map = new HashMap<String , String>();
    	
    	try {
    		String modifiedPass = req.getParameter("newpass");
    		String userId = SecuritySessionUtil.getUserid(req);
    		
    		
    		ZUserVo vo = new ZUserVo(); 
    		
    		vo.setUserid(userId);
    		vo.setUserpasswd(modifiedPass);
    		
            if (StringUtils.isNotBlank(vo.getUserpasswd())) { 
            	vo.setUserpasswd(passwordEncoder.encodePassword(vo.getUserpasswd(), null));
            }
    		
            userLogService.updatepassword(vo);
            
    		map.put("code","success");
    		map.put("message","정상적으로 수행되었습니다.");
    		
    	}catch(Exception e) {
    		map.put("code","error");
    		map.put("message","오류 발생, 담당자한테 문의하세요.");
    		
    	}
    	
    	return map;
    }
    
    

}
