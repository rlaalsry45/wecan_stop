package com.z5.zcms.admsys.supervisor.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.z5.zcms.admsys.authority.dao.ZAuthorityDAO;
import com.z5.zcms.admsys.authority.domain.ZAuthHierachy;
import com.z5.zcms.admsys.authority.domain.ZAuthHierachyVO;
import com.z5.zcms.admsys.authority.domain.ZAuthorities;
import com.z5.zcms.admsys.authority.domain.ZAuthoritiesVO;
import com.z5.zcms.admsys.authority.service.ZAuthorityService;
import com.z5.zcms.admsys.common.dao.CommonDAO;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;

@Controller
@RequestMapping("/admsys/admin/supervisor/")
public class SupervisorController
{
	@Autowired
	ZUserService zUserService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ZAuthorityService zAuthorityService; 

	
	@RequestMapping("index.html")
	public String index(
			@ModelAttribute("zUserVo") ZUserVo zUserVo
		, Model model, HttpServletRequest req) throws Exception {

		
		try{
			DataTable input = new DataTable(req);
			int pageSize = input.getInt("pageSize", 50);
			if (input.getInt("pageIndex")==0){
				input.put("pageIndex", 1);
			}
			int pageIndex = input.getInt("pageIndex") - 1;
			String sdate = input.get("sdate");
			String edate = input.get("edate");
			String keyword = input.get("keyword");
			/*String enabledvalue = input.get("enabledvalue");
			String sitedivision = input.get("sitedivision");
			String authoritysearch = input.get("authoritysearch");*/
			
/*			//enabled는 0과 1이기 때문에 int값은 기본값이 0이라 y와 n으로 구분자를 넣어준다.
			int enabled = -9999;
			if(enabledvalue.equals("y")){
				enabled = 1;
			}else{
				enabled = 0;
			}*/
			
			int m = pageIndex * pageSize;
			int n = pageSize;
			
			if(sdate.equals("") && edate.equals("") ){ 
				zUserVo.setCond1("");
			}else{
				zUserVo.setCond1(input.get("cond1"));
			}
			if(keyword.equals("")){
				zUserVo.setCond2("");
			}else{
				zUserVo.setCond2(input.get("cond2"));
			}
			/*if(enabledvalue.equals("")){
				zUserVo.setCond3("");
			}else{
				zUserVo.setCond3("enabled");
			}*/
			/*if(sitedivision.equals("")){
				zUserVo.setCond4("");
			}else{
				zUserVo.setCond4("sitedivision");
			}*/
			/*if(authoritysearch.equals("")){ //관리자일 경우 값을 지정해준다.
				zUserVo.setCond5("");
			}else{
				if(authoritysearch.equals("10")){ 
					authoritysearch ="ROLE_ADMIN_HOME";
				}else if(authoritysearch.equals("20")){
					authoritysearch ="ROLE_ADMIN_CENTER";
				}
				zUserVo.setCond5("authoritysearch");
			}*/
			
			zUserVo.setSdate(input.get("sdate"));
			zUserVo.setEdate(input.get("edate"));
			zUserVo.setKeyword(input.get("keyword"));
			zUserVo.setUserstatus(input.get("userstatus"));
			/*zUserVo.setEnabled(enabled);*/
			/*zUserVo.setCond5(authoritysearch);*/
			zUserVo.setM(m);
			zUserVo.setN(n);
			
			int total = this.zUserService.listCount(zUserVo,"admin");//일반유저와 동일한 쿼리를 사용하지만 setAuthority에 ROLE_ADMIN을 넣으면 관리자 목록만 뽑아온다
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));
		
			List<ZUserVo> list = this.zUserService.getList(zUserVo,"admin");
			
			model.addAttribute("list", list);
			model.addAttribute("input", input);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return "/zcms/admsys/admin/supervisor/index";
	}
	
	
	
	
	// 관리자정보수정
	@RequestMapping(value="update.html", method=RequestMethod.GET)
	public String update(
			@RequestParam int userno,
			HttpServletRequest req, Model model)
		            throws Exception{
		
		try{
			ZUserVo zUserVo = new ZUserVo();
			zUserVo.setUserno(String.valueOf(userno));
			zUserVo = zUserService.selectbypk(zUserVo);
			model.addAttribute("user",zUserVo);
			
			//권한종류가져오기
			ZAuthHierachyVO zAuthHierachyVO =new ZAuthHierachyVO();
			List<ZAuthHierachyVO> listZAuthHierachy= zAuthorityService.getList(zAuthHierachyVO);
			
			//개인권한가져오기
			ZAuthoritiesVO zAuthoritiesVO = new ZAuthoritiesVO();
			zAuthoritiesVO.setUserid(zUserVo.getUserid());
			List<ZAuthoritiesVO> listZAuthorities= zAuthorityService.getAuthoritiesByUserid(zAuthoritiesVO);
			
			//해당권한check
			for(int i=0; listZAuthHierachy.size() > i;i++){
				for(int j=0; listZAuthorities.size() > j;j++ ){
					if(listZAuthHierachy.get(i).getRole().equals(listZAuthorities.get(j).getAuthority())){
						listZAuthHierachy.get(i).setIsRole("y");
					}
				}
			}
			model.addAttribute("authorities",listZAuthHierachy);

			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/zcms/admsys/admin/supervisor/update";
		
	}
	
	
	// 관리자정보수정
	@RequestMapping(value="update.html", method=RequestMethod.POST)
	public String update_confirm(
			  @RequestParam(value="authno",required=false) String[] authno 
			, @RequestParam("userid") String userid 
			, @RequestParam("userno") String userno 
			, HttpServletRequest request
			, Model model)
		            throws Exception{
		
		try{
			
			this.zAuthorityService.setAuthorities(userid,authno,true);//기존의 관리자인가? -> true
			
			
		    model.addAttribute("modifysuccess",true);
		}catch(Exception e){
			model.addAttribute("modifyfail",false);
			e.printStackTrace();
		}
		
		model.addAttribute("userno",userno);
		
		return "redirect:/admsys/admin/supervisor/update.html";
		
	}
	
	
	// 관리자삭제
    @RequestMapping("delete.html")
    public String delete(
    		@RequestParam("userno") int[] userno,
            @ModelAttribute("zUserVo") ZUserVo zUserVo, BindingResult err, HttpServletRequest req)
            throws Exception {
    	try{
	    	List<Integer> arrDeleteNo = new ArrayList<Integer>(userno.length);
	    	for(int i = 0; i < userno.length; i++) {
	    		arrDeleteNo.add(userno[i]);
	    	}
	
	    	zUserService.delete(arrDeleteNo);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        
        return "redirect:/admsys/admin/supervisor/index.html";
    }
    
    
    //  관리자 최초등록시 권한과 함께 부여
    @RequestMapping(value="/kf_popup/add_admin.html" , method=RequestMethod.GET)
    public String add_admin(
    		@RequestParam("cs_id") String cs_id,
    		Model model
    		)
    	throws Exception {
    	try{
	    	//권한종류가져오기
			ZAuthHierachyVO zAuthHierachyVO =new ZAuthHierachyVO();
			List<ZAuthHierachyVO> listZAuthHierachy= zAuthorityService.getList(zAuthHierachyVO);
	    	
	    	model.addAttribute("cs_id",cs_id);
	    	model.addAttribute("authorities",listZAuthHierachy);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return "/zcms/admsys/admin/supervisor/add_admin";
    }
    
    // 관리자 최초등록시 권한과 함께 부여
    @RequestMapping(value="/kf_popup/add_admin.html" , method=RequestMethod.POST)
    public String add_admin_submit(
    		@RequestParam("cs_id") String cs_id
    		,@RequestParam("authno") String[] authno 
    		,Model model
    		)
    	throws Exception {
    	
    	//시스템에서 관리자 정보를 가져와서 kfhome에 정보를 삽입한다.
    	try{
    		//유저등록
    		this.zUserService.add_admin_from_kfuser(cs_id);
    		
    		//권한등록
    		this.zAuthorityService.setAuthorities(cs_id, authno,false);// false->신규 등록시 기존권한삭제로직을 실시하지 않는다.
    		model.addAttribute("addsuccess","true");
    		model.addAttribute("cs_id",cs_id);
    	}catch(Exception e){
    		e.printStackTrace();
    		model.addAttribute("addsuccess","false");
    	}
    	
    	
    	return "redirect:/admsys/admin/supervisor/kf_popup/add_admin.html";
    }
    
    
}
