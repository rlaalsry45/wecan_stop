package com.z5.zcms.admsys.authority.web;

import com.z5.zcms.admsys.authority.domain.ZAuthHierachyVO;
import com.z5.zcms.admsys.authority.service.ZAuthHierachyServiec;
import com.z5.zcms.util.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ZAuthHierachyController {

	@Autowired
	private ZAuthHierachyServiec zAuthHierachyServiec;

	@RequestMapping(value="/admsys/admin/supervisorauth/authlist.html")
	public String authList(
			@ModelAttribute("zAuthHierachyVO") ZAuthHierachyVO zAuthHierachyVO
			, Model model
			, HttpServletRequest request
			, HttpServletResponse response) throws Exception {

		DataTable input = new DataTable(request);

		try {
			int pageSize = input.getInt("pageSize", 20);
			if (input.getInt("pageIndex")==0){
				input.put("pageIndex", 1);
			}
			int pageIndex = input.getInt("pageIndex") - 1;

			int m = pageIndex * pageSize;
			int n = pageSize;
			int total = this.zAuthHierachyServiec.authListCount(zAuthHierachyVO);
			input.put("target", input.get("target"));
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));
			zAuthHierachyVO.setM(m);
			zAuthHierachyVO.setN(n);

			List<ZAuthHierachyVO> list = this.zAuthHierachyServiec.getAuthList(zAuthHierachyVO);

			model.addAttribute("list", list);
			model.addAttribute("input", input);
		} catch (Exception e) {
    		e.printStackTrace();
		}
		return "/zcms/admsys/admin/supervisor/authlist";
	}

    @RequestMapping(value="/admsys/admin/supervisorauth/authinsert.html", method=RequestMethod.GET)
    public String insert(
    		HttpSession session
    		, Model model
    		) throws Exception {
    	return "/zcms/admsys/admin/supervisor/authinsert";
    }


    @RequestMapping(value="/admsys/admin/supervisorauth/authinsert.html", method=RequestMethod.POST)
    public String insertSubmit(
			@ModelAttribute("zAuthHierachyVO") ZAuthHierachyVO zAuthHierachyVO
    		,Model model
    		) throws Exception{
    	try{
    		String roleTrim=zAuthHierachyVO.getRole().trim();
    		zAuthHierachyVO.setRole(roleTrim);
    		zAuthHierachyServiec.authInsert(zAuthHierachyVO);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return "redirect:/admsys/admin/supervisorauth/authlist.html";
    }

    @RequestMapping(value="/admsys/admin/supervisorauth/delete.html")
    public String deleteAuth(
			@ModelAttribute("zAuthHierachyVO") ZAuthHierachyVO zAuthHierachyVO
			, @RequestParam("authno") List<Integer> authno
    		, Model model
    		) throws Exception{
    	try{
    		zAuthHierachyServiec.deleteAuth(authno);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return "redirect:/admsys/admin/supervisorauth/authlist.html";
    }

    @RequestMapping(value="/admsys/admin/supervisorauth/delcheck.html")
    @ResponseBody
    public Map<String, Object> delCheck(
			@ModelAttribute("zAuthHierachyVO") ZAuthHierachyVO zAuthHierachyVO
			, @RequestParam("authno") List<Integer> authno
    		, Model model
    		) throws Exception{

    	Map<String, Object> map = new HashMap<String, Object>();
    	String authoritys = "";
    	try{
    		List<ZAuthHierachyVO> uselist = this.zAuthHierachyServiec.delCheck(authno);
    		for(ZAuthHierachyVO chList: uselist){
    			if(chList.getCou().equals("0")){

    			}else{
    				authoritys = authoritys + "'"+ chList.getRole() + "'";
    			}
    		}
    		map.put("authoritys", authoritys);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return map;
    }

    @RequestMapping(value="/admsys/admin/supervisorauth/authduplicationch.html")
    @ResponseBody
    public Map<String, Object> authduplicationch(
			@ModelAttribute("zAuthHierachyVO") ZAuthHierachyVO zAuthHierachyVO
    		, Model model
    		) throws Exception{
    	Map<String, Object> map = new HashMap<String, Object>();
    	try{
    		String roleTrim = zAuthHierachyVO.getRole().trim();
    		zAuthHierachyVO.setRole(roleTrim);
    		int authcou = this.zAuthHierachyServiec.authduplicationch(zAuthHierachyVO);
    		map.put("authcou", authcou);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return map;
    }
}
