package com.z5.zcms.admsys.zmainbanner.web;

import com.z5.zcms.admsys.zmainbanner.domain.ZmainbannerVO;
import com.z5.zcms.admsys.zmainbanner.service.ZmainbannerService;
import com.z5.zcms.util.DataTable;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Controller
public class ZmainbannerController {

    @Autowired
    private ZmainbannerService zmainbannerService;


    @SuppressWarnings("unused")
    @RequestMapping(value = {"/admsys/site/zmainbanner/", "/admsys/site/zmainbanner/index.html"})
    public String selectZmainbannerList(
        @ModelAttribute("ZmainbannerVO") ZmainbannerVO zmainbannerVO
        , Model model, HttpServletRequest req) throws Exception {

        DataTable input = new DataTable(req);

        try {
            int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            pageSize = 10;
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex  = input.getInt("pageIndex") - 1;
            String sdate      = input.get("sdate");
            String edate      = input.get("edate");
            String mainstatus = input.get("mainstatus");
            String keyword    = input.get("keyword");
            int    m          = pageIndex * pageSize;
            int    n          = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                zmainbannerVO.setCond1("");
            } else {
                zmainbannerVO.setCond1(input.get("cond1"));
            }

            if (keyword.equals("")) {
                zmainbannerVO.setCond2("");
            } else {
                zmainbannerVO.setCond2(input.get("cond2"));
            }
            if (mainstatus.equals("")) {
                zmainbannerVO.setMainstatus("");
            } else {
                zmainbannerVO.setMainstatus(input.get("mainstatus"));
            }

            zmainbannerVO.setSdate(input.get("sdate"));
            zmainbannerVO.setEdate(input.get("edate"));
            zmainbannerVO.setKeyword(input.get("edate"));
            zmainbannerVO.setM(m);
            zmainbannerVO.setN(n);

            int total = this.zmainbannerService.listCount(zmainbannerVO);

            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<ZmainbannerVO> list = this.zmainbannerService.getList(zmainbannerVO);
            model.addAttribute("type", zmainbannerVO.getType());
            model.addAttribute("list", list);
            model.addAttribute("input", input);
            model.addAttribute("zmainbanner_url", EgovProperties.getProperty("Globals.upload.main.banner"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/site/zmainbanner/index";
    }

    //insert GET
    @RequestMapping(value = "/admsys/site/zmainbanner/insert.html", method = RequestMethod.GET)
    public String insert(HttpSession session, Model model,
                         @ModelAttribute("zmainbannerVO") ZmainbannerVO zmainbannerVO) throws Exception {

        int total = this.zmainbannerService.listCount(zmainbannerVO);
        model.addAttribute("total", total);
        model.addAttribute("type", zmainbannerVO.getType());
        if (zmainbannerVO.getType() < 100) return "/zcms/admsys/site/zmainbanner/mobile_insert";
        else return "/zcms/admsys/site/zmainbanner/insert";
    }

    //insert POST
    @RequestMapping(value = "/admsys/site/zmainbanner/insert.html", method = RequestMethod.POST)
    public String insertSubmit(HttpServletRequest req, HttpServletResponse rsp,
                               @ModelAttribute("zmainbannerVO") ZmainbannerVO zmainbannerVO) throws Exception {


        try {

            MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest) req;
            Iterator<String>            fileIter   = mptRequest.getFileNames();
            HashMap<?, ?>               map        = null;
            String                      filename   = null;
            String                      ext        = null;
            while (fileIter.hasNext()) {
                MultipartFile mFile = mptRequest.getFile((String) fileIter.next());

                if (mFile.getSize() > 0) {
                    map = EgovFileMngUtil.uploadFileIMG(mFile, "Globals.upload.main.banner");
                    filename = (String) map.get(Globals.UPLOAD_FILE_NM);
                    ext = (String) map.get(Globals.FILE_EXT);
                }
            }
            String tmpupload = EgovProperties.getPathProperty("Globals.upload.board");
            zmainbannerVO.setimg_name(filename + "." + ext);
            this.zmainbannerService.insert(zmainbannerVO);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/admsys/site/zmainbanner/index.html?type=" + zmainbannerVO.getType();

    }


    //Delete
    @RequestMapping("/admsys/site/zmainbanner/delete.html")
    public String delete(
        @RequestParam("no") int[] no,
        @ModelAttribute("zmainbannerVO") ZmainbannerVO zmainbannerVO, BindingResult err, HttpServletRequest req)
        throws Exception {

        List<Integer> arrDeleteNo = new ArrayList<Integer>(no.length);
        for (int i = 0; i < no.length; i++) {
            arrDeleteNo.add(no[i]);
        }

        for (int i = 0; i < no.length; i++) {
            zmainbannerVO.setNo(no[i]);
            zmainbannerService.updaterank(zmainbannerVO);
        }

        zmainbannerService.delete(arrDeleteNo);

        return "redirect:/admsys/site/zmainbanner/index.html?type=" + zmainbannerVO.getType();

    }

    //Update GET
    @RequestMapping(value = "/admsys/site/zmainbanner/update.html", method = RequestMethod.GET)
    public String updateView(
        @RequestParam("no") int no,
        @ModelAttribute("zmainbannerVO") ZmainbannerVO zmainbannerVO, HttpServletRequest req, Model model)
        throws Exception {


        try {
            int total = this.zmainbannerService.listCount(zmainbannerVO);
            model.addAttribute("total", total);
            model.addAttribute("zmainbanner_url", EgovProperties.getProperty("Globals.upload.main.banner"));
            ZmainbannerVO detail = (ZmainbannerVO) zmainbannerService.selectbypk(no);
            model.addAttribute("type", zmainbannerVO.getType());
            model.addAttribute("detail", detail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (zmainbannerVO.getType() < 100) return "/zcms/admsys/site/zmainbanner/mobile_update";
        else return "/zcms/admsys/site/zmainbanner/update";


    }


    //Update Post
    @Transactional
    @RequestMapping(value = "/admsys/site/zmainbanner/update.html", method = RequestMethod.POST)
    public String updateSubmit(HttpServletResponse rep,
                               @ModelAttribute("zmainbannerVO")
                                   ZmainbannerVO zmainbannerVO, BindingResult err, HttpServletRequest req, HttpSession session) throws Exception {

        try {
            MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest) req;
            Iterator<String>            fileIter   = mptRequest.getFileNames();
            HashMap<?, ?>               map        = null;
            String                      filename   = null;
            String                      ext        = null;
            while (fileIter.hasNext()) {
                MultipartFile mFile = mptRequest.getFile(fileIter.next());

                if (mFile.getSize() > 0) {
                    map = EgovFileMngUtil.uploadFileIMG(mFile, "Globals.upload.main.banner");
                    filename = (String) map.get(Globals.UPLOAD_FILE_NM);
                    ext = (String) map.get(Globals.FILE_EXT);
                }
            }
            String tempupload = EgovProperties.getPathProperty("Globals.upload.board");
            if (filename != null) zmainbannerVO.setimg_name(filename + "." + ext);
            //this.zmainbannerService.insert(zmainbannerVO);

            //zmainbannerService.insert(zmainbannerVO);
            this.zmainbannerService.update(zmainbannerVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/site/zmainbanner/index.html?type=" + zmainbannerVO.getType();

    }


    //mobile_insert POST
    @RequestMapping(value = "/admsys/site/zmainbanner/mobile_insert.html", method = RequestMethod.POST)
    public String mobileinsertSumbit(HttpServletRequest req, HttpServletResponse rsp,
                                     @ModelAttribute("zmainbannerVO") ZmainbannerVO zmainbannerVO) throws Exception {

        try {
            MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest) req;
            Iterator<String>            fileIter   = mptRequest.getFileNames();
            HashMap<?, ?>               map        = null;
            String                      filename   = null;
            String                      ext        = null;
            while (fileIter.hasNext()) {
                MultipartFile mFile = mptRequest.getFile((String) fileIter.next());

                if (mFile.getSize() > 0) {
                    map = EgovFileMngUtil.uploadFileIMG(mFile, "Globals.upload.main.banner");
                    filename = (String) map.get(Globals.UPLOAD_FILE_NM);
                    ext = (String) map.get(Globals.FILE_EXT);
                }
            }
            String tmpupload = EgovProperties.getPathProperty("Globals.upload.board");
            zmainbannerVO.setimg_name(filename + "." + ext);
            this.zmainbannerService.mobileinsert(zmainbannerVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/site/zmainbanner/index.html?type=0";

    }


    //mobileUpdate Post
    @Transactional
    @RequestMapping(value = "/admsys/site/zmainbanner/mobile_update.html", method = RequestMethod.POST)
    public String mobileupdateSubmit(HttpServletResponse rep,
                                     @ModelAttribute("zmainbannerVO")
                                         ZmainbannerVO zmainbannerVO, BindingResult err, HttpServletRequest req, HttpSession session) throws Exception {

        try {
            MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest) req;
            Iterator<String>            fileIter   = mptRequest.getFileNames();
            HashMap<?, ?>               map        = null;
            String                      filename   = null;
            String                      ext        = null;
            while (fileIter.hasNext()) {
                MultipartFile mFile = mptRequest.getFile(fileIter.next());

                if (mFile.getSize() > 0) {
                    map = EgovFileMngUtil.uploadFileIMG(mFile, "Globals.upload.main.banner");
                    filename = (String) map.get(Globals.UPLOAD_FILE_NM);
                    ext = (String) map.get(Globals.FILE_EXT);
                }
            }
            String tempupload = EgovProperties.getPathProperty("Globals.upload.board");
            if (filename != null) zmainbannerVO.setimg_name(filename + "." + ext);
            //this.zmainbannerService.insert(zmainbannerVO);

            //zmainbannerService.insert(zmainbannerVO);
            this.zmainbannerService.update(zmainbannerVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/site/zmainbanner/index.html?type=0";

    }
}







