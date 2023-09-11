package com.z5.zcms.admsys.tpl.web;

import com.z5.zcms.admsys.tpl.domain.ZtplHisVo;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.admsys.tpl.service.ZtplHisService;
import com.z5.zcms.admsys.tpl.service.ZtplService;
import com.z5.zcms.admsys.tpl.service.ZtplUseService;
import com.z5.zcms.admsys.validator.TplValidator;
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
@RequestMapping("/admsys/site/tpl/")
public class ZtplController {

    @Autowired
    private ZtplService ztplService;

    @Autowired
    private ZtplUseService ztplUseService;

    @Autowired
    private ZtplHisService ztplHisService;

    @Autowired
    private TplValidator tplValidator;

	private final Logger log = Logger.getLogger(this.getClass());

	private final String RETURN_URL = "/zcms/admsys/site/tpl/";

    @RequestMapping(value={"", "index.html"})
    public String selectZtplList(@ModelAttribute("zTplVo") ZtplVo ztplVo, Model model, HttpServletRequest req) throws Exception {
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
			ztplVo.setCond1("");
		}else{
			ztplVo.setCond1(input.get("cond1"));
		}
		if(keyword.equals("")){
			ztplVo.setCond2("");
		}else{
			ztplVo.setCond2(input.get("cond2"));
		}

		ztplVo.setSdate(input.get("sdate"));
		ztplVo.setEdate(input.get("edate"));
		ztplVo.setKeyword(input.get("keyword"));
		ztplVo.setPageSize(pageSize);
		ztplVo.setM(m);
		ztplVo.setN(n);

		int total = this.ztplService.listCount(ztplVo);
		input.put("pageSize",pageSize);
		input.put("total", total);
		input.put("pageMax", (int)Math.ceil((double)total/pageSize));

		List<ZtplVo> list = this.ztplService.getList(ztplVo);

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
    public String insertSubmit(@ModelAttribute("zTplVo") ZtplVo ztplVo, BindingResult err, HttpServletRequest req) throws Exception{
    	try{
    	this.tplValidator.validate(ztplVo, err);

    	DataTable input = new DataTable(req);

        ztplVo.setTplconts(input.get("tplcontstype").equals("1") ? input.get("tplconts") : input.get("ckeditorConts"));
        ztplVo.setTplpositionword(input.get("tplposition").equals("1") ? "Top" : input.get("tplposition").equals("2") ? "Left" : input.get("tplposition").equals("3") ? "Right" : "Bottom");
        this.ztplService.insert(ztplVo);


        //template jsp 생성
        ztplVo = this.ztplService.selectbyTitleAndPosition(ztplVo);//tpltile과 tplposition으로 방금 입력한 tpl의 no를 가지고 온다.
        if(FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.tpl"),Integer.toString(ztplVo.getTplno()), ztplVo.getTplconts())){
        	//System.out.println("tpl template making successed");
        }else{
        	//System.out.println("tpl template making failed");
        }


    	}catch(Exception e){
    		log.error(e.getMessage());
    	}
        return "redirect:/admsys/site/tpl/index.html";

    }

    //Delete
    @RequestMapping("delete.html")
    public String delete(
    		@RequestParam("tplno") int[] tplno,
            @ModelAttribute("zTplVo") ZtplVo ztplVo, BindingResult err, HttpServletRequest req)
            throws Exception {

    	List<Integer> arrDeleteNo = new ArrayList<Integer>(tplno.length);
    	for(int i = 0; i < tplno.length; i++) {
    		arrDeleteNo.add(tplno[i]);
    	}

    	ztplService.delete(arrDeleteNo);
        ztplUseService.delete(arrDeleteNo);

        return "redirect:/admsys/site/tpl/index.html";
    }




    //Update GET
    @RequestMapping(value="update.html", method=RequestMethod.GET)
    public String updateView(
            @ModelAttribute("zTplVo") ZtplVo ztplVo, HttpServletRequest req, Model model)
            throws Exception {

    	DataTable dreq = new DataTable(req);
    	int tplno = dreq.getInt("tplno");
		int tplhisno = dreq.getInt("tplhisno");
		String mode = dreq.get("mode");

    	try{

		if(mode.equals("restore")){
			ZtplHisVo zTplHisVo = new ZtplHisVo();
			zTplHisVo.setTplhisno(tplhisno);
			ZtplVo detail = ztplHisService.selectbypk(zTplHisVo); //tplhisVo를 tplvo로 변환시켜서 가지고 옮
			model.addAttribute("detail",detail);
		}else if (mode.equals("delete")){
			//tplHis 삭제
			ZtplHisVo zTplHisVo = new ZtplHisVo();
			zTplHisVo.setTplhisno(tplhisno);
			ztplHisService.delete(zTplHisVo);

			//tplno에 해당하는 정보를 가지고 와서 다시 뿌려줌
			ztplVo.setTplno(tplno);
	    	ZtplVo detail = this.ztplService.selectbypk(ztplVo);
	    	model.addAttribute("detail",detail);
		}else{
	    	ztplVo.setTplno(tplno);
	    	ZtplVo detail = this.ztplService.selectbypk(ztplVo);
	    	model.addAttribute("detail",detail);

		}

		ZtplHisVo zTplHisVo = new ZtplHisVo();
    	zTplHisVo.setTplno(tplno);
    	List<ZtplHisVo> hislist = this.ztplHisService.getList(zTplHisVo);
    	model.addAttribute("hislist", hislist);

    	}catch(Exception e){
    		log.error(e.getMessage());
    	}

        return RETURN_URL+"update";
    }

    //Update Post
    @RequestMapping(value="update.html", method=RequestMethod.POST)
    public String updateSubmit(@ModelAttribute("zTplVo") ZtplVo ztplVo, BindingResult err, HttpServletRequest req) throws Exception{

    	try{

		DataTable input = new DataTable(req);

		//history 저장
		if(input.get("tplhis").equals("1")){
			ZtplHisVo ztplHisVo = new ZtplHisVo();
			ztplHisVo.setUserid(input.get("userid"));
			ztplHisVo.setTplno(input.getInt("tplno"));
			ztplHisService.insert(ztplHisVo);
		}

		//ztpl update
		ztplVo.setTpltitle(input.get("tpltitle"));
		ztplVo.setTplposition(input.get("tplposition"));
		ztplVo.setTpltype(input.get("tpltype"));
		if(!input.get("tplfileorg").equals("")){
			ztplVo.setTplfileorg(input.get("tplfileorg"));
			ztplVo.setTplfilesave(input.get("tplfilesave"));
		}else{
			ztplVo.setTplfileorg("");
			ztplVo.setTplfilesave(input.get(""));
		}
		ztplVo.setTplcontstype(input.get("tplcontstype"));
		ztplVo.setTplconts(input.get("tplcontstype").equals("1") ? input.get("tplconts") : input.get("ckeditorConts"));
		ztplVo.setTplmemo(input.get("tplmemo"));
		ztplVo.setTplhis(input.get("tplhis"));
		ztplVo.setUserid(input.get("userid"));
		ztplVo.setTplpositionword(input.get("tplposition").equals("1") ? "Top" : input.get("tplposition").equals("2") ? "Left" : input.get("tplposition").equals("3") ? "Right" : "Bottom");
		ztplVo.setTplno(input.getInt("tplno"));

		ztplService.update(ztplVo);

		//template jsp 생성
        if(FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.tpl"),Integer.toString(ztplVo.getTplno()), ztplVo.getTplconts())){
        	//System.out.println("tpl template update successed");
        }else{
        	//System.out.println("tpl template update failed");
        }

    	}catch(Exception e){
    		log.error(e.getMessage());
    	}
    	return "redirect:/admsys/site/tpl/index.html";
    }

}
