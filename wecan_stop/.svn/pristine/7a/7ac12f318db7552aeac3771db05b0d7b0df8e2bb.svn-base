package com.z5.zcms.admsys.js.web;

import com.z5.zcms.admsys.js.domain.ZjsHisVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import com.z5.zcms.admsys.js.service.ZjsHisService;
import com.z5.zcms.admsys.js.service.ZjsService;
import com.z5.zcms.admsys.js.service.ZjsUseService;
import com.z5.zcms.admsys.validator.JsValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import egovframework.com.cmm.service.EgovProperties;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admsys/site/js/")
public class ZjsController {

	@Autowired
	private ZjsService zjsService;

	@Autowired
	private ZjsUseService zjsUseService;

	@Autowired
	private ZjsHisService zjsHisService;

	@Autowired
    private JsValidator jsValidator;

	private final Logger log = Logger.getLogger(this.getClass());

	private final String RETURN_URL = "/zcms/admsys/site/js/";

	@RequestMapping(value={"","index.html"})
    public String selectZjsList(
    		@ModelAttribute("zjsVo") ZjsVo zjsVo
    		, Model model, HttpServletRequest req) throws Exception {

		try{
    	DataTable input = new DataTable(req);

    	int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
		if (input.getInt("pageIndex")==0){
			input.put("pageIndex", 1);
		}
		int pageIndex = input.getInt("pageIndex") - 1;
		String sdate = input.get("sdate");
		String edate = input.get("edate");
		String keyword = input.get("keyword");
		int m = pageIndex * pageSize;
		int n = pageSize;

		if(sdate.equals("") && edate.equals("") ){
			zjsVo.setCond1("");
		}else{
			zjsVo.setCond1(input.get("cond1"));
		}
		if(keyword.equals("")){
			zjsVo.setCond2("");
		}else{
			zjsVo.setCond2(input.get("cond2"));
		}

		zjsVo.setSdate(input.get("sdate"));
		zjsVo.setEdate(input.get("edate"));
		zjsVo.setKeyword(input.get("keyword"));
		zjsVo.setM(m);
		zjsVo.setN(n);

		int total = this.zjsService.listCount(zjsVo);
		input.put("pageSize",pageSize);
		input.put("total", total);
		input.put("pageMax", (int)Math.ceil((double)total/pageSize));

		List<ZjsVo> list = this.zjsService.getList(zjsVo);

		model.addAttribute("list", list);
		model.addAttribute("input", input);
		}catch(Exception e){
			log.error(e.getMessage());
		}

    	return RETURN_URL+"index";
    }


    //insert GET
    @RequestMapping(value="insert.html", method=RequestMethod.GET)
    public String insert(HttpSession session, Model model) throws Exception {
    	return RETURN_URL+"insert";
    }


    //insert POST
    @RequestMapping(value="insert.html", method=RequestMethod.POST)
    public String insertSubmit(@ModelAttribute("zjsVo") ZjsVo zjsVo, BindingResult err, HttpServletRequest req,HttpSession session) throws Exception{

    	this.jsValidator.validate(zjsVo, err);

    	DataTable input = new DataTable(req);
    	try{
    	String jsupload = EgovProperties.getPathProperty("Globals.common.js");
    	//System.out.println(jsupload);
    	//System.out.println("input.get(jsconts)"+input.get("jsconts"));
    	//System.out.println("zjsVo.getJsconts()"+zjsVo.getJsconts());
		String jsfilesave = FileUtil.writeFile(jsupload, "js", input.get("jsconts"));

		if (!jsfilesave.equals("")){
			input.put("jsfilesave",jsfilesave);
			zjsVo.setJsfilesave(jsfilesave);
			this.zjsService.insert(zjsVo);
		}

    	}catch(Exception e){
    		log.error(e.getMessage());
    	}


        return "redirect:/admsys/site/js/index.html";

    }

    //Delete
    @RequestMapping("delete.html")
    public String delete(
    		@RequestParam("jsno") int[] jsno,
            @ModelAttribute("zjsVo") ZjsVo zjsVo, BindingResult err, HttpServletRequest req)
            throws Exception {

    	List<Integer> arrDeleteNo = new ArrayList<Integer>(jsno.length);
    	for(int i = 0; i < jsno.length; i++) {
    		arrDeleteNo.add(jsno[i]);
    	}
    	

    	zjsService.delete(arrDeleteNo);
        zjsUseService.delete(arrDeleteNo);

        return "redirect:/admsys/site/js/index.html";
    }

    //Update GET
    @RequestMapping(value="update.html", method=RequestMethod.GET)
    public String updateView(
            @ModelAttribute("zjsVo") ZjsVo zjsVo, HttpServletRequest req, Model model)
            throws Exception {

    	DataTable dreq = new DataTable(req);
    	int jsno = dreq.getInt("jsno");
		int jshisno = dreq.getInt("jshisno");
		String mode = dreq.get("mode");

    	try{

		if(mode.equals("restore")){
			//System.out.println("restore 들어옴");
			//System.out.println("jshisno"+jshisno);
			ZjsHisVo zjsHisVo = new ZjsHisVo();
			zjsHisVo.setJshisno(jshisno);
			ZjsVo detail = zjsHisService.selectbypk(zjsHisVo); //jshisVo를 jsVo로 변환시켜서 가지고 옮
			model.addAttribute("detail",detail);
		}else if (mode.equals("delete")){
			//jsHis 삭제
			//System.out.println("delete 들어옴");
			ZjsHisVo zjsHisVo = new ZjsHisVo();
			zjsHisVo.setJshisno(jshisno);
			zjsHisService.delete(zjsHisVo);

			//jsno에 해당하는 정보를 가지고 와서 다시 뿌려줌
			zjsVo.setJsno(jsno);
	    	ZjsVo detail = this.zjsService.selectbypk(zjsVo);
	    	model.addAttribute("detail",detail);
		}else{

	    	zjsVo.setJsno(jsno);
	    	ZjsVo detail = this.zjsService.selectbypk(zjsVo);
	    	model.addAttribute("detail",detail);

		}

    	model.addAttribute("jsno",jsno);

		ZjsHisVo zjsHisVo = new ZjsHisVo();
    	zjsHisVo.setJsno(jsno);
    	List<ZjsHisVo> hislist = this.zjsHisService.getList(zjsHisVo);
    	model.addAttribute("hislist", hislist);

    	}catch(Exception e){
    		log.error(e.getMessage());
    	}

        return RETURN_URL+"update";
    }

    //Update Post
    @RequestMapping(value="update.html", method=RequestMethod.POST)
    public String updateSubmit(@ModelAttribute("zjsVo") ZjsVo zjsVo, BindingResult err, HttpServletRequest req, HttpSession session,Model model) throws Exception{

    	try{
		DataTable input = new DataTable(req);
		boolean yn = false;

    	String jsupload = EgovProperties.getPathProperty("Globals.common.js");
		if (input.get("jsfilesave").equals("")){

			String jsfilesave = FileUtil.writeFile(jsupload, "js", input.get("jsconts"));
			input.put("jsfilesave", jsfilesave);
		}
		else{
			yn = FileUtil.editFile(jsupload, input.get("jsfilesave"), input.get("jsconts"));
		}

		if (!input.get("jsfilesave").equals("")||yn){

			//history 저장
			//System.out.println("input.get(userid) : "+input.get("userid"));
			//System.out.println("input.get(jsno) : "+input.get("jsno"));
			if(input.get("jshis").equals("1")){
				ZjsHisVo zjsHisVo = new ZjsHisVo();
				zjsHisVo.setUserid(input.get("userid"));
				zjsHisVo.setJsno(input.getInt("jsno"));
				zjsHisService.insert(zjsHisVo);
			}

			//zjs update
			zjsVo.setJstitle(input.get("jstitle"));
			zjsVo.setJstype(input.get("jstype"));
			zjsVo.setJsfileorg(input.get("jsfileorg"));
			zjsVo.setJsfilesave(input.get("jsfilesave"));
			zjsVo.setJsconts(input.get("jsconts"));
			zjsVo.setJsmemo(input.get("jsmemo"));
			zjsVo.setJshis(input.get("jshis"));
			zjsVo.setUserid(input.get("userid"));
			zjsVo.setJsno(input.getInt("jsno"));

			zjsService.update(zjsVo);

			model.addAttribute("jsno", zjsVo.getJsno());
			model.addAttribute("updatesuccess", "true");
		}
    	}catch(Exception e){
    		log.error(e.getMessage());
    	}


    	return "redirect:/admsys/site/js/update.html";
    }
}
