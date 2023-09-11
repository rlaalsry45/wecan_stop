package com.z5.zcms.admsys.evnt.web;

import com.google.gson.Gson;
import com.z5.zcms.admsys.evnt.domain.EvntPartcptHistVO;
import com.z5.zcms.admsys.evnt.domain.EvntReqInputCfgVO;
import com.z5.zcms.admsys.evnt.domain.EvntVO;
import com.z5.zcms.admsys.evnt.service.EvntService;
import com.z5.zcms.frontsys.archv.domain.ArchvFile;
import com.z5.zcms.frontsys.archv.domain.ArchvVO;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;
import com.z5.zcms.view.AjaxJsonView;
import egovframework.com.cmm.service.EgovProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EvntController {

    @Autowired
    private EvntService evntService;

    @RequestMapping(value={"/admsys/evnt/","/admsys/evnt/index.html"})
    public String selectEvntList(
            @ModelAttribute("evntVO") EvntVO evntVO
            , Model model
            , @RequestParam(value="evnt_opt_cd", required=false, defaultValue="1") String evnt_opt_cd
            ,HttpServletRequest req) throws Exception {

        model.addAttribute("evnt_opt_cd",evnt_opt_cd);
        model.addAttribute("image_path_org",EgovProperties.getProperty("Globals.archive.image.org"));
        model.addAttribute("image_path_thbnail",EgovProperties.getProperty("Globals.archive.image.thumbnail"));
        model.addAttribute("image_path_detail",EgovProperties.getProperty("Globals.archive.image.detail"));
        model.addAttribute("image_path_watermark",EgovProperties.getProperty("Globals.archive.image.watermark"));

        try{
            DataTable input = new DataTable(req);

            /*int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));*/
            int pageSize = input.getInt("pageSize", 20);
            if (input.getInt("pageIndex")==0){
                input.put("pageIndex", 1);
            }
            int pageIndex = input.getInt("pageIndex") - 1;
            String sdate = input.get("sdate");
            String edate = input.get("edate");
            String keyword = input.get("keyword");
            String sdate2 = input.get("sdate2");
            String edate2 = input.get("edate2");
            String keyword2 = input.get("keyword2");
            int m = pageIndex * pageSize;
            int n = pageSize;

            if(sdate.equals("") && edate.equals("") ){
                evntVO.setCond1("");
            }else{
                evntVO.setCond1(input.get("cond1"));
            }
            if(keyword.equals("")){
                evntVO.setCond2("");
            }else{
                evntVO.setCond2(input.get("cond2"));
            }

            if(sdate2.equals("") && edate2.equals("") ){
                evntVO.setCond3("");
            }else{
                evntVO.setCond3(input.get("cond3"));
            }
            if(keyword2.equals("")){
                evntVO.setCond4("");
            }else{
                evntVO.setCond4(input.get("cond4"));
            }

            evntVO.setSdate(input.get("sdate"));
            evntVO.setEdate(input.get("edate"));
            evntVO.setKeyword(input.get("keyword"));
            evntVO.setM(m);
            evntVO.setN(n);

            evntVO.setEvnt_opt_cd(evnt_opt_cd);
            evntVO.setIsadmin("true");//관리자에서 리스트를 뽑을 경우 true 값을 넣어준다.

            int total = this.evntService.listCount(evntVO);
            int total2 = this.evntService.lnbListCount(evntVO);
            input.put("pageSize",pageSize);
            input.put("total", total);
            input.put("total2", total2);
            input.put("pageMax", (int)Math.ceil((double)total/pageSize));

            List<EvntVO> list = this.evntService.getList(evntVO);
            List<EvntVO> lnbList = evntService.lnbList(evntVO);
            List<EvntVO> lnbList2 = evntService.lnbList2(evntVO);

            model.addAttribute("list", list);
            model.addAttribute("lnbList", lnbList);
            model.addAttribute("lnbList2", lnbList2);
            model.addAttribute("input", input);

        }catch(Exception e){
            e.printStackTrace();
        }

        return "/zcms/admsys/evnt/index";
    }


    @RequestMapping(value="/admsys/evnt/insert.html", method=RequestMethod.GET)
    public String insert(
            HttpSession session
            , @ModelAttribute("evntVO") EvntVO evntVO
            , Model model
            , @RequestParam (value="evnt_opt_cd", required=false, defaultValue="1") String evnt_opt_cd
            ) throws Exception {
        try {
            List<EvntVO> lnbList = evntService.lnbList(evntVO);
            model.addAttribute("lnbList", lnbList);
            model.addAttribute("evnt_opt_cd",evnt_opt_cd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/evnt/insert";
    }


    @RequestMapping(value="/admsys/evnt/insert.html", method=RequestMethod.POST)
    public String insertSubmit(
            @ModelAttribute("evntVO") EvntVO evntVO
            ,Model model
            ) throws Exception{
        String evnt_no= null;
        try{
            evnt_no = evntService.insert(evntVO);
        }catch(Exception e){
            e.printStackTrace();
        }

        model.addAttribute("insertsuccess","true");
        model.addAttribute("evnt_no",evnt_no);
        model.addAttribute("evnt_opt_cd",evntVO.getEvnt_opt_cd());
        return "redirect:/admsys/evnt/update.html";

    }

    @RequestMapping("/admsys/evnt/delete.html")
    public String delete(
            @RequestParam("evnt_no") int[] evnt_no,
            @ModelAttribute("evntVO") EvntVO evntVO,
            Model model
            )
            throws Exception {

        List<Integer> arrDeleteNo = new ArrayList<Integer>(evnt_no.length);
        for(int i = 0; i < evnt_no.length; i++) {
            arrDeleteNo.add(evnt_no[i]);
        }

        evntService.delete(arrDeleteNo);
        model.addAttribute("evnt_opt_cd",evntVO.getEvnt_opt_cd());
        return "redirect:/admsys/evnt/index.html";
    }

    //Update GET
    @RequestMapping(value="/admsys/evnt/update.html")
    public String updateView(
            @ModelAttribute("evntVO") EvntVO evntVO, HttpServletRequest req, Model model)
            throws Exception {

        try{
            evntVO.setIsadmin("true");
            EvntVO evnt = this.evntService.getEvnt(evntVO,false);
            List<EvntVO> lnbList = evntService.lnbList(evntVO);
            model.addAttribute("evnt",evnt);
            model.addAttribute("lnbList", lnbList);
            model.addAttribute("evnt_opt_cd",evntVO.getEvnt_opt_cd());
            model.addAttribute("evnt_req_not_list",evnt.getNotlist());
            model.addAttribute("evnt_req_input",evnt.getEvntReqInputCfgVO());
        }catch(Exception e){
            e.printStackTrace();
        }

        return "/zcms/admsys/evnt/update";
    }

    //Update Post
//    @RequestMapping(value="/admsys/evnt/update.dex", method=RequestMethod.POST)
    @RequestMapping(value="/admsys/evnt/update2.html", method=RequestMethod.POST)
    public @ResponseBody Map<String, String> updateSubmit(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

            EvntVO evntVO = new EvntVO();
            //EvntReqNotCfgVO evntReqNotCfgVO = new EvntReqNotCfgVO();
            EvntReqInputCfgVO evntReqInputCfgVO = new EvntReqInputCfgVO();
            List<ArchvFile> filelist    = new ArrayList<ArchvFile>();
            Map<String, String> map     = new HashMap<String, String>();
//          FileUpload fileUpload       = new FileUpload(request, response);
            String subDir = null; // 세부디렉터리


        try{

            String strPath = request.getSession().getServletContext().getRealPath("/upload/archv");
            System.out.println(strPath);
/*
            fileUpload.setLicenseFilePath(request.getSession().getServletContext().getRealPath("/upload/archv") + File.separator + "dextuploadj.config");
            fileUpload.UploadStart(strPath);
            evntVO.setEvnt_title(fileUpload.getParameter("evnt_title"));
            evntVO.setEvnt_sumup(fileUpload.getParameter("evnt_sumup"));
            evntVO.setEvnt_use_yn(Integer.parseInt(fileUpload.getParameter("evnt_use_yn")));
            evntVO.setCaution(fileUpload.getParameter("caution"));
            evntVO.setArchv_no(fileUpload.getParameter("archv_no"));
            evntVO.setEvnt_start_date(fileUpload.getParameter("evnt_start_date"));
            evntVO.setEvnt_start_date_h(fileUpload.getParameter("evnt_start_date_h"));
            evntVO.setEvnt_start_date_i(fileUpload.getParameter("evnt_start_date_i"));
            evntVO.setEvnt_end_date(fileUpload.getParameter("evnt_end_date"));
            evntVO.setEvnt_end_date_h(fileUpload.getParameter("evnt_end_date_h"));
            evntVO.setEvnt_end_date_i(fileUpload.getParameter("evnt_end_date_i"));
            evntVO.setPrwin_date(fileUpload.getParameter("prwin_date"));
            evntVO.setPrwin_date_h(fileUpload.getParameter("prwin_date_h"));
            evntVO.setPrwin_date_i(fileUpload.getParameter("prwin_date_i"));
            evntVO.setEvnt_no(fileUpload.getParameter("evnt_no"));
            evntVO.setUser_list_show_yn(fileUpload.getParameter("user_list_show_yn").equals("1")?1:0);
            evntVO.setOnly_member_yn(fileUpload.getParameter("only_member_yn").equals("1")?1:0);
*/
            //not date get and make list to insert
/*
            String[] not_cfg_no = (String[])fileUpload.getParameterValues("not_cfg_no");
            String[] not_date = (String[])fileUpload.getParameterValues("not_date");
            String[] not_date_h = (String[])fileUpload.getParameterValues("not_date_h");
            String[] not_date_i = (String[])fileUpload.getParameterValues("not_date_i");
            String[] not_applicant_limit = (String[])fileUpload.getParameterValues("not_applicant_limit");
            List<EvntReqNotCfgVO> evntReqNotCfgVOList = new ArrayList<EvntReqNotCfgVO>();
            for(int i=0;not_date.length > i;i++){
                EvntReqNotCfgVO evntReqNotCfgVOInsert = new EvntReqNotCfgVO();
                not_date[i] = not_date[i]+" "+not_date_h[i]+":"+not_date_i[i];
                evntReqNotCfgVOInsert.setNot_cfg_no(not_cfg_no[i]);
                //evntReqNotCfgVOInsert.setEvnt_no(evntReqNotCfgVO.getEvnt_no());
                evntReqNotCfgVOInsert.setNot_date(not_date[i]);
                evntReqNotCfgVOInsert.setEvnt_no(fileUpload.getParameter("evnt_no"));
                evntReqNotCfgVOInsert.setNot_applicant_limit(not_applicant_limit[i]);
                evntReqNotCfgVOList.add(evntReqNotCfgVOInsert);
            }
            evntVO.setNotlist(evntReqNotCfgVOList);
            //reqInput value set
            //evntVO.setEvntReqInputCfgVO(evntReqInputCfgVO);
            evntReqInputCfgVO.setReq_no(fileUpload.getParameter("req_no"));
            evntReqInputCfgVO.setContact_yn(fileUpload.getParameter("contact_yn"));
            evntReqInputCfgVO.setAddr_yn(fileUpload.getParameter("addr_yn"));
            evntReqInputCfgVO.setAdditional_yn(fileUpload.getParameter("additional_yn"));
            evntReqInputCfgVO.setAdditional_conts(fileUpload.getParameter("additional_conts"));
            evntReqInputCfgVO.setExtra_yn(fileUpload.getParameter("extra_yn"));
            evntReqInputCfgVO.setAttach_yn(fileUpload.getParameter("attach_yn"));
            evntReqInputCfgVO.setEvnt_no(fileUpload.getParameter("evnt_no"));
            evntVO.setEvntReqInputCfgVO(evntReqInputCfgVO);
            //file 처리
            String tempPath = null;
            String fileName = null;
            String newFileName = null;
//          ResizeImages resizeImages = new ResizeImages();
            FileItem[] value = (FileItem[]) fileUpload.getFileItemValues("evntfile");
            if (value != null) { // 첨부파일이 있을 경우에만.
                System.out.println("here upload");
                for (int i = 0; i < value.length; i++) {
                    if (value[i] != null) {
                        if (value[i].IsUploaded()) {
                            fileName = value[i].getFileName();
                            newFileName = FileUtil.makeNewFileName(fileName);
                            ArchvFile archvfile = new ArchvFile();
                            archvfile.setName(fileName);
                            archvfile.setRealname(newFileName);
                            archvfile.setFilesz(String.valueOf(value[i].length()));
                            archvfile.setEvnt_no(fileUpload.getParameter("evnt_no"));
                            filelist.add(archvfile);
                            subDir = File.separator + "docs";       // 문서
                            tempPath = strPath + subDir;
                            value[i].SaveAs(tempPath, newFileName, false);  // true: 파일명 중복시 덮어쓴다

                        }
                        else {
                            System.out.println("파일이 업로드되지 않았습니다.");
                        }
                    }
                }
            }
 */
            evntVO.setFilelist(filelist);
            //update
            evntService.update(evntVO);//evnt, input, not를 service에서 한번에 입력
            map.put("result", "저장되었습니다.");
//          map.put("evnt_no", fileUpload.getParameter("evnt_no"));
//          map.put("evnt_opt_cd", fileUpload.getParameter("evnt_opt_cd"));
            model.addAttribute("updatesuccess","true");
            model.addAttribute("evnt_no",evntVO.getEvnt_no());
            model.addAttribute("evnt_opt_cd",evntVO.getEvnt_opt_cd());
        }catch(Exception ex){
            map.put("result", ex.getMessage());
            System.out.println(ex.getMessage());
        }finally {
            // 종료 시에 반드시 자원을 해제해야 한다.
            // 그렇지 않으면 임시 파일이 삭제되지 않고 남을 수 있다.
            try {
//              fileUpload.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//      return "redirect:/admsys/evnt/update.html";
        return map;
    }


    @RequestMapping(value="/admsys/evnt/addNot.html", method = RequestMethod.POST)
    public ModelAndView addRltd(
            HttpServletRequest request,
            HttpServletResponse response
            ) throws Exception {


        //바뀐내용을 반영하기 위해 데이타를 넣은 jsp를 가지고 온다
        HttpSession session = request.getSession();
        String menuJspFilePath =  "http://"+request.getServerName()+"/admsys/evnt/getNotHtml.html";
        URLConnection connection = new URL(menuJspFilePath).openConnection();
        connection.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());//세션을 함께 넘겨준다
        InputStream s = connection.getInputStream();//파일스트림으로 읽어온다
        String rtv = StringUtil.getStringFromInputStream(s);//메뉴본문의 내용을 읽어와서 파싱...
        s.close();
        System.out.println(rtv);

        HashMap<String,String> data = new HashMap<String,String>();
        data.put("body",rtv);

        response.setCharacterEncoding("utf-8");
        String json = new Gson().toJson(data);

        ModelAndView mav = new ModelAndView(new AjaxJsonView());
        mav.addObject("ajaxJson",json);
        return mav;
    }

    @RequestMapping(value="/admsys/evnt/getNotHtml.html")
    public String getRltd(
            ) throws Exception {
        return "/zcms/admsys/evnt/notHtml";
    }

    @RequestMapping("/admsys/evnt/get_file.html")
    public @ResponseBody Map<String, Object> getFileList(@RequestParam String evnt_no) {

        ArchvVO archvVO = new ArchvVO();
        archvVO.setArchv_no(evnt_no);
        List<ArchvFile> files = null;
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            files = this.evntService.getFilelist(evnt_no);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (files != null && files.size() == 0) {
            map.put("result", null);
        }
        else {
            map.put("result", files);
        }
        return map;
    }

    @RequestMapping(value="/admsys/evnt/del_file.html", method=RequestMethod.POST)
    public @ResponseBody Map<String, String> delArchvFile(@RequestParam int file_no) {

        Map<String, String> map = new HashMap<String, String>();

        int a = 0;
        try {
            a = this.evntService.delEvntFile(file_no);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        map.put("result", "삭제되었습니다.");
        map.put("cnt", a + "");
        return map;
    }

    @RequestMapping(value="/admsys/evnt/partcptlist.html")
    public String reqlist(
            @RequestParam String evnt_no
            ,Model model
            ) throws Exception{
        List<EvntPartcptHistVO> evntPartcptHistVO = new ArrayList<EvntPartcptHistVO>();
        try{
             evntPartcptHistVO = evntService.getPartcptlist(evnt_no);
        }catch(Exception e){
            e.printStackTrace();
        }
        List<List<EvntPartcptHistVO>> evnt = new ArrayList<List<EvntPartcptHistVO>>();

        if(evntPartcptHistVO.size() != 0){
            try{
                List<EvntPartcptHistVO> evntPartcptHistVOtmp = new ArrayList<EvntPartcptHistVO>();
                evntPartcptHistVOtmp.add(evntPartcptHistVO.get(0));
                model.addAttribute("evnt_title",evntPartcptHistVO.get(0).getEvnt_title());
                String not_cfg_no_tmp = evntPartcptHistVO.get(0).getNot_cfg_no();
                for(int i=1;evntPartcptHistVO.size() >i;i++){
                    if(not_cfg_no_tmp.equals(evntPartcptHistVO.get(i).getNot_cfg_no())){
                        evntPartcptHistVOtmp.add(evntPartcptHistVO.get(i));
                    }else{
                        evnt.add(evntPartcptHistVOtmp);
                        not_cfg_no_tmp = evntPartcptHistVO.get(i).getNot_cfg_no();
                        evntPartcptHistVOtmp = new ArrayList<EvntPartcptHistVO>();
                        evntPartcptHistVOtmp.add(evntPartcptHistVO.get(i));
                    }
                }
                evnt.add(evntPartcptHistVOtmp);
            }catch(Exception e){
                e.printStackTrace();
            }
            model.addAttribute("evnt",evnt);
        }else{
            model.addAttribute("noreq","true");
        }

        return "/zcms/admsys/evnt/partcptlist";

    }

    @RequestMapping(value="/admsys/evnt/prwinnerlist.html")
    public String prwinnerlist(
            @RequestParam String evnt_no
            ,Model model
            ) throws Exception{
        List<EvntPartcptHistVO> evntPartcptHistVO = new ArrayList<EvntPartcptHistVO>();
        try{
            evntPartcptHistVO = evntService.getPrwinnerlist(evnt_no);
        }catch(Exception e){
            e.printStackTrace();
        }

        model.addAttribute("evntPartcptHistVO",evntPartcptHistVO);
        return "/zcms/admsys/evnt/prwinnerlist";

    }
    @RequestMapping(value="/admsys/evnt/del_not.html")
    @ResponseBody
    public String del_not(
            @RequestParam String not_cfg_no
            ,Model model
            ) throws Exception{

        try{
            evntService.delNotCfgByPk(not_cfg_no);
            return "del";
        }catch(Exception e){
            e.printStackTrace();
        }

        return "error";

    }

    @RequestMapping(value="/admsys/evnt/lnb.html")
    public String lnblist(
            @ModelAttribute("evntVO") EvntVO evntVO
            ,Model model
            ) throws Exception{
        try{
            List<EvntVO> lnbList = evntService.lnbList(evntVO);
            model.addAttribute("lnbList",lnbList);
        }catch(Exception e){
            e.printStackTrace();
        }

        return "/zcms/admsys/evnt/lnb";

    }

    //Update GET
    @RequestMapping(value="/admsys/evnt/updateg.html",method=RequestMethod.GET)
    public String updateGView(
            @ModelAttribute("evntVO") EvntVO evntVO, HttpServletRequest req, Model model)
            throws Exception {

        try{
            evntVO.setIsadmin("true");
            EvntVO evntG = this.evntService.getEvntG(evntVO);
            List<EvntVO> lnbList = evntService.lnbList(evntVO);
            model.addAttribute("evntG",evntG);
            model.addAttribute("lnbList", lnbList);
        }catch(Exception e){
            e.printStackTrace();
        }

        return "/zcms/admsys/evnt/update_g";
    }

    //Update Post
    @RequestMapping(value="/admsys/evnt/updateg.html", method=RequestMethod.POST)
    public String updateGSubmit(
            @ModelAttribute("evntVO") EvntVO evntVO
        ) throws Exception{

        try{
            evntService.updateG(evntVO);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/admsys/evnt/index.html?evnt_opt_cd=0";
    }

    @RequestMapping(value="/admsys/evnt/insertg.html", method=RequestMethod.GET)
    public String insertG(
            HttpSession session
            , @ModelAttribute("evntVO") EvntVO evntVO
            , Model model
            ) throws Exception {
        try {
            List<EvntVO> lnbList = evntService.lnbList(evntVO);
            model.addAttribute("lnbList", lnbList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/evnt/insert_g";
    }


    @RequestMapping(value="/admsys/evnt/insertg.html", method=RequestMethod.POST)
    public String insertGSubmit(
            @ModelAttribute("evntVO") EvntVO evntVO
            ,Model model
            ) throws Exception{
        try{
            evntService.insertG(evntVO);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/admsys/evnt/index.html?evnt_opt_cd=0";
    }

    @RequestMapping("/admsys/evnt/deleteg.html")
    public String deleteg(
            @RequestParam("evnt_opt_cd") int[] evnt_opt_cd,
            @ModelAttribute("evntVO") EvntVO evntVO,
            Model model
            ) throws Exception {
        try {
            List<Integer> arrDeleteNo = new ArrayList<Integer>(evnt_opt_cd.length);
            for(int i = 0; i < evnt_opt_cd.length; i++) {
                arrDeleteNo.add(evnt_opt_cd[i]);
            }

            evntService.deleteg(arrDeleteNo);
            //model.addAttribute("evnt_opt_cd",evntVO.getEvnt_opt_cd());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/evnt/index.html?evnt_opt_cd=0";
    }
}
