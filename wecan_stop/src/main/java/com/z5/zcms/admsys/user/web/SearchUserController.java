package com.z5.zcms.admsys.user.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.z5.zcms.admsys.user.dao.ZUserDAO;
import com.z5.zcms.admsys.user.domain.SearchUser;
import com.z5.zcms.util.DataTable;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;

@Controller

@RequestMapping("/admsys/user/search/")
public class SearchUserController {

	@Autowired
	ZUserDAO zuserDAO;
	
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	@RequestMapping(value="index.html")
	public String index(
			Model model
			){
		
		return "/zcms/admsys/user/common/searchUser";
	}
	
	@RequestMapping(value="p_user_srch_field.html") 
	public String p_user_srch_field(
			Model model
			,@RequestParam(value="code",required=false,defaultValue="" )String code
			,@RequestParam(value="codename",required=false,defaultValue="" )String codename
			,@RequestParam(value="fieldname",required=false,defaultValue="" )String fieldname
			){
		
		if(code==null || code.equals("")){
			model.addAttribute("error","true" );
		}
		//회원구분 공통코드
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		List<?> codeResult = null;
		vo.setCodeId(code); //회원구분
		try {
			codeResult = cmmUseService.selectCmmCodeDetail(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("list", codeResult);
		model.addAttribute("codename", codename);
		model.addAttribute("fieldname", fieldname);
		model.addAttribute("error","false");
		
		
		return "/zcms/admsys/user/common/p_user_srch_field";
	}
	
	@RequestMapping(value="result.html")
	public String result(
			@ModelAttribute("searchUser")SearchUser searchUser
			,Model model
			,HttpServletRequest request
			){
		
		try{
			DataTable input = new DataTable(request);
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
				searchUser.setCond1("");
			}else{
				searchUser.setCond1(input.get("cond1"));
			}
			if(keyword.equals("")){
				searchUser.setCond2("");
			}else{
				searchUser.setCond2(input.get("cond2"));
				
				if(input.get("cond2").equals("userdatereg")){
					keyword = keyword.replace("-", "");
				}
				
			}
			
			//승인여부에 탈퇴여부가 함께 들어 있어서 semimemberconfirm 이 outrequest의 값으로 변경한다. 
			if(searchUser.getSemimemberconfirm()!= null && searchUser.getSemimemberconfirm().equals("2")){
				searchUser.setSemimemberconfirm(null);
				searchUser.setUseroutrequest("0");
			}
			
			String[] nos1;
			List<String> listnos1 = new ArrayList<String>();
			//임원의 경우 다중의 다중 검색인 관계로 배열 검색을 실시한다.
			if(!(searchUser.getSc_sec5_val() == null || searchUser.getSc_sec5_val().equals(""))){
				nos1 = searchUser.getSc_sec5_val().split(",");
				for(int i=0;nos1.length > i;i++){
					listnos1.add(nos1[i]);
				}
				searchUser.setExecutiveArr(listnos1);
			}
			
			String[] nos2;
			List<String> listnos2 = new ArrayList<String>();
			//위원회의 경우 다중의 다중 검색인 관계로 배열의 배열 검색을 실시한다.
			if(!(searchUser.getSc_sec11_val() == null || searchUser.getSc_sec11_val().equals(""))){
				nos2 = searchUser.getSc_sec11_val().split(",");
				for(int i=0;nos2.length > i;i++){
					listnos2.add(nos2[i]);
				}
				searchUser.setExecutiveArr(listnos2);
			}
			
			String[] nos3;
			List<String> listnos3 = new ArrayList<String>();
			//대학의 경우 다중의 다중 검색인 관계로 배열의 배열 검색을 실시한다.
			if(!(searchUser.getUniversity() == null || searchUser.getUniversity().equals(""))){
				nos3 = searchUser.getUniversity().split(",");
				for(int i=0;nos3.length > i;i++){
					listnos3.add(nos3[i]);
				}
				searchUser.setUniversityArr(listnos3);
			}
			

			//추가 학력 최종학력 -->  학력유무로 변경
			String[] nos4;
			List<String> listnos4 = new ArrayList<String>();
			//학력의 경우 다중의 다중 검색인 관계로 배열의 배열 검색을 실시한다.
			if(!(searchUser.getSc_sec12_val() == null || searchUser.getSc_sec12_val().equals(""))){
				nos4 = searchUser.getSc_sec12_val().split(",");
				for(int i=0;nos4.length > i;i++){
					listnos4.add(nos4[i]);
				}
				searchUser.setLasteducationArr(listnos4);
			}
			
			//연회비, 임원회비 관련 로직 추가
			if (searchUser.getDuetype().equals("1") || searchUser.getDuetype().equals("2")){ //1:연회비 2: 임원회비
				if(searchUser.getDuepaytype().equals("1")){ //1:납부 0:미납
					searchUser.setDuepayquery(" is not null");
				}else{
					searchUser.setDuepayquery(" is null");
				}
				
				List<String> listnos5 = new ArrayList<String>();
				String dueyearall = "";
				for(int i=Integer.parseInt(searchUser.getDuestart());i <= Integer.parseInt(searchUser.getDueend() );i++){
					if(searchUser.getDuetype().equals("1")){
						listnos5.add("d"+Integer.toString(i));
						dueyearall +="d"+Integer.toString(i);
					}else{
						listnos5.add("e"+Integer.toString(i));
						dueyearall +="e"+Integer.toString(i);
					}
				}
				searchUser.setDueYearArr(listnos5);
				searchUser.setDueyear(dueyearall);
			}
			
			
			
			searchUser.setSdate(sdate);
			searchUser.setEdate(edate);
			searchUser.setKeyword(keyword);
	
			searchUser.setM(m);
			searchUser.setN(n);
	
			model.addAttribute("searchUser",searchUser);
			
			int total = this.zuserDAO.listCountSearch(searchUser);
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));
	
			List<SearchUser> list = this.zuserDAO.getListSearch(searchUser);
	
			model.addAttribute("list", list);
			model.addAttribute("input", input);
			model.addAttribute("column", searchUser.getColumn());
			model.addAttribute("pageIndex", pageIndex+1);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/zcms/admsys/user/common/searchUserResult";
	}
	
}
