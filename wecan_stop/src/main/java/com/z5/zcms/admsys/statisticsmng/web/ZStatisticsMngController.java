package com.z5.zcms.admsys.statisticsmng.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.z5.zcms.admsys.statisticsmng.domain.ZStatisticsMngVo;
import com.z5.zcms.admsys.statisticsmng.service.ZStatisticsMngService;
import com.z5.zcms.util.DataTable;

@RequestMapping("/admsys/statisticsmng/")
@Controller
public class ZStatisticsMngController {
	
	 @Autowired
	 private ZStatisticsMngService zStatisticsMngService;
	 
    /**
     * 상담 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/statisticsmng/index.html"
     * @throws Exception
     */
    @RequestMapping(value = "index.html")
    public String index(@ModelAttribute("ZStatisticsMngVo") ZStatisticsMngVo reqVo, ModelMap model, HttpServletRequest req) throws Exception {

    	DataTable input    = new DataTable(req);
    	
    	if(StringUtils.isEmpty(reqVo.getSdate())) {
    		LocalDate now = LocalDate.now();
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    		String formatedNow = now.format(formatter);
    		reqVo.setSdate(formatedNow);
    		reqVo.setEdate(formatedNow);
    		reqVo.setRange("d");
    	}	
    	model.addAttribute("input", input);
    	model.addAttribute("range", reqVo.getRange());
    	
    	if("d".equals(reqVo.getRange())) {
    		List<ZStatisticsMngVo> dailyList = zStatisticsMngService.getDailyList(reqVo);
        	model.addAttribute("dailyList", dailyList);
    	}else {
    		List<ZStatisticsMngVo> monthlyList = zStatisticsMngService.getMonthlyList(reqVo);
        	model.addAttribute("monthlyList", monthlyList);
    	}
    	
    	List<ZStatisticsMngVo> consultingList = zStatisticsMngService.getConsultingList(reqVo); 	
		model.addAttribute("consultingList", consultingList);
		
    	if(reqVo.getConsultingTypeCbx() != null && reqVo.getConsultingTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> consultingTypeList = zStatisticsMngService.getConsultingTypeList(reqVo); 	
    		model.addAttribute("consultingTypeCbx", reqVo.getConsultingTypeCbx());
    		model.addAttribute("consultingTypeList", consultingTypeList);
    	}
    	
    	if(reqVo.getReceivedTypeCbx() != null && reqVo.getReceivedTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> receivedTypeList = zStatisticsMngService.getReceivedTypeList(reqVo); 	
    		model.addAttribute("receivedTypeCbx", reqVo.getReceivedTypeCbx());
    		model.addAttribute("receivedTypeList", receivedTypeList);
    	}
    	
    	if(reqVo.getConsultingReqTypeCbx() != null && reqVo.getConsultingReqTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> consultingReqTypeList = zStatisticsMngService.getConsultingReqTypeList(reqVo); 	
    		model.addAttribute("consultingReqTypeCbx", reqVo.getConsultingReqTypeCbx());
    		model.addAttribute("consultingReqTypeList", consultingReqTypeList);
    	}
    	
    	if(reqVo.getContactMethodTypeCbx() != null && reqVo.getContactMethodTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> contactMethodTypeList = zStatisticsMngService.geContactMethodTypeList(reqVo); 	
    		model.addAttribute("contactMethodTypeCbx", reqVo.getContactMethodTypeCbx());
    		model.addAttribute("contactMethodTypeList", contactMethodTypeList);
    	}
    	
    	if(reqVo.getClientGenderCbx() != null && reqVo.getClientGenderCbx().size() > 0) {
    		List<ZStatisticsMngVo> clientGenderList = zStatisticsMngService.getClientGenderList(reqVo); 	
    		model.addAttribute("clientGenderCbx", reqVo.getClientGenderCbx());
    		model.addAttribute("clientGenderList", clientGenderList);
    	}
    	
    	if(reqVo.getClientVictimRelTypeCbx() != null && reqVo.getClientVictimRelTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> clientVictimRelTypeList = zStatisticsMngService.getClientVictimRelTypeList(reqVo); 	
    		model.addAttribute("clientVictimRelTypeCbx", reqVo.getClientVictimRelTypeCbx());
    		model.addAttribute("clientVictimRelTypeList", clientVictimRelTypeList);
    	}
    	
    	if(reqVo.getVictimGenderTypeCbx() != null && reqVo.getVictimGenderTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> victimGenderTypeList = zStatisticsMngService.getVictimGenderTypeList(reqVo); 	
    		model.addAttribute("victimGenderTypeCbx", reqVo.getVictimGenderTypeCbx());
    		model.addAttribute("victimGenderTypeList", victimGenderTypeList);
    	}
    	
    	if(reqVo.getOffenderGenderTypeCbx() != null && reqVo.getOffenderGenderTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> offenderGenderTypeList = zStatisticsMngService.getOffenderGenderTypeList(reqVo); 	
    		model.addAttribute("offenderGenderTypeCbx", reqVo.getOffenderGenderTypeCbx());
    		model.addAttribute("offenderGenderTypeList", offenderGenderTypeList);
    	}
    	
    	if(reqVo.getOffenderVictimRelTypeCbx() != null && reqVo.getOffenderVictimRelTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> offenderVictimRelTypeList = zStatisticsMngService.getOffenderVictimRelTypeList(reqVo); 	
    		model.addAttribute("offenderVictimRelTypeCbx", reqVo.getOffenderVictimRelTypeCbx());
    		model.addAttribute("offenderVictimRelTypeList", offenderVictimRelTypeList);
    	}
    	
    	if(reqVo.getHarmFirstTypeCbx() != null && reqVo.getHarmFirstTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> harmFirstTypeList = zStatisticsMngService.getHarmFirstTypeList(reqVo); 	
    		model.addAttribute("harmFirstTypeCbx", reqVo.getHarmFirstTypeCbx());
    		model.addAttribute("harmFirstTypeList", harmFirstTypeList);
    	}
    	
    	if(reqVo.getHarmSecTypeCbx() != null && reqVo.getHarmSecTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> harmSecTypeList = zStatisticsMngService.getHarmSecTypeList(reqVo); 	
    		model.addAttribute("harmSecTypeCbx", reqVo.getHarmSecTypeCbx());
    		model.addAttribute("harmSecTypeList", harmSecTypeList);
    	}
    	
    	if(reqVo.getResponseTypeIntroOrgCbx() != null && reqVo.getResponseTypeIntroOrgCbx().size() > 0) {
    		List<ZStatisticsMngVo> responseTypeIntroOrgList = zStatisticsMngService.getResponseTypeIntroOrgList(reqVo); 	
    		model.addAttribute("responseTypeIntroOrgCbx", reqVo.getResponseTypeIntroOrgCbx());
    		model.addAttribute("responseTypeIntroOrgList", responseTypeIntroOrgList);
    	}
    	
    	if(reqVo.getResponseTypeServiceRelCbx() != null && reqVo.getResponseTypeServiceRelCbx().size() > 0) {
    		List<ZStatisticsMngVo> responseTypeServiceRelList = zStatisticsMngService.getResponseTypeServiceRelList(reqVo); 	
    		model.addAttribute("responseTypeServiceRelCbx", reqVo.getResponseTypeServiceRelCbx());
    		model.addAttribute("responseTypeServiceRelList", responseTypeServiceRelList);
    	}
    	
        return "/zcms/admsys/statisticsmng/index";
    }
    
    /**
     * 조직문화진단 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/statisticsmng/orgculturedig.html"
     * @throws Exception
     */
    @RequestMapping(value = "orgculturedig.html")
    public String orgculturedig(@ModelAttribute("ZStatisticsMngVo") ZStatisticsMngVo reqVo, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	DataTable input    = new DataTable(req);
    	
    	if(StringUtils.isEmpty(reqVo.getSdate())) {
    		LocalDate now = LocalDate.now();
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    		String formatedNow = now.format(formatter);
    		reqVo.setSdate(formatedNow);
    		reqVo.setEdate(formatedNow);
    		reqVo.setRange("d");
    	}	
    	model.addAttribute("input", input);
    	model.addAttribute("range", reqVo.getRange());
    	
    	if("d".equals(reqVo.getRange())) {
    		List<ZStatisticsMngVo> dailyList = zStatisticsMngService.getDailyList(reqVo);
        	model.addAttribute("dailyList", dailyList);
    	}else {
    		List<ZStatisticsMngVo> monthlyList = zStatisticsMngService.getMonthlyList(reqVo);
        	model.addAttribute("monthlyList", monthlyList);
    	}
    	
    	List<ZStatisticsMngVo> actionList = zStatisticsMngService.getActionList(reqVo); 	
		model.addAttribute("actionList", actionList);
		
    	if(reqVo.getActionTypeCbx() != null && reqVo.getActionTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> actionTypeList = zStatisticsMngService.getActionTypeList(reqVo); 	
    		model.addAttribute("actionTypeCbx", reqVo.getActionTypeCbx());
    		model.addAttribute("actionTypeList", actionTypeList);
    	}
    	
    	if(reqVo.getStepStatusCbx() != null && reqVo.getStepStatusCbx().size() > 0) {
    		List<ZStatisticsMngVo> stepStatusList = zStatisticsMngService.getStepStatusList(reqVo); 	
    		model.addAttribute("stepStatusCbx", reqVo.getStepStatusCbx());
    		model.addAttribute("stepStatusList", stepStatusList);
    	}
    	
    	if(reqVo.getActionConsultingTypeCbx() != null && reqVo.getActionConsultingTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> actionConsultingTypeList = zStatisticsMngService.getActionConsultingTypeList(reqVo); 	
    		model.addAttribute("actionConsultingTypeCbx", reqVo.getActionConsultingTypeCbx());
    		model.addAttribute("actionConsultingTypeList", actionConsultingTypeList);
    	}
    	
    	if(reqVo.getActionReceivedTypeCbx() != null && reqVo.getActionReceivedTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> actionReceivedTypeList = zStatisticsMngService.getActionReceivedTypeList(reqVo); 	
    		model.addAttribute("actionReceivedTypeCbx", reqVo.getActionReceivedTypeCbx());
    		model.addAttribute("actionReceivedTypeList", actionReceivedTypeList);
    	}
    	
    	if(reqVo.getClientGenderCbx() != null && reqVo.getClientGenderCbx().size() > 0) {
    		List<ZStatisticsMngVo> clientGenderList = zStatisticsMngService.getActionClientGenderList(reqVo); 	
    		model.addAttribute("clientGenderCbx", reqVo.getClientGenderCbx());
    		model.addAttribute("clientGenderList", clientGenderList);
    	}
    	
    	if(reqVo.getClientVictimRelTypeCbx() != null && reqVo.getClientVictimRelTypeCbx().size() > 0) {
    		List<ZStatisticsMngVo> clientVictimRelTypeList = zStatisticsMngService.getActionClientVictimRelTypeList(reqVo); 	
    		model.addAttribute("clientVictimRelTypeCbx", reqVo.getClientVictimRelTypeCbx());
    		model.addAttribute("clientVictimRelTypeList", clientVictimRelTypeList);
    	}
    	
    	if(reqVo.getOrgAccidentStepCbx() != null && reqVo.getOrgAccidentStepCbx().size() > 0) {
    		List<ZStatisticsMngVo> orgAccidentStepList = zStatisticsMngService.getOrgAccidentStepList(reqVo); 	
    		model.addAttribute("orgAccidentStepCbx", reqVo.getOrgAccidentStepCbx());
    		model.addAttribute("orgAccidentStepList", orgAccidentStepList);
    	}
    	
    	if(reqVo.getActionTypeOtherOrgCbx() != null && reqVo.getActionTypeOtherOrgCbx().size() > 0) {
    		List<ZStatisticsMngVo> actionTypeOtherOrgList = zStatisticsMngService.getActionTypeOtherOrgList(reqVo); 	
    		model.addAttribute("actionTypeOtherOrgCbx", reqVo.getActionTypeOtherOrgCbx());
    		model.addAttribute("actionTypeOtherOrgList", actionTypeOtherOrgList);
    	}
    	
    	if(reqVo.getActionTypeServiceRelCbx() != null && reqVo.getActionTypeServiceRelCbx().size() > 0) {
    		List<ZStatisticsMngVo> actionTypeServiceRelList = zStatisticsMngService.getActionTypeServiceRelList(reqVo); 	
    		model.addAttribute("actionTypeServiceRelCbx", reqVo.getActionTypeServiceRelCbx());
    		model.addAttribute("actionTypeServiceRelList", actionTypeServiceRelList);
    	}
    	
    	if(reqVo.getActionTypeContCbx() != null && reqVo.getActionTypeContCbx().size() > 0) {
    		List<ZStatisticsMngVo> actionTypeContList = zStatisticsMngService.getActionTypeContList(reqVo); 	
    		model.addAttribute("actionTypeContCbx", reqVo.getActionTypeContCbx());
    		model.addAttribute("actionTypeContList", actionTypeContList);
    	}
    	
        return "/zcms/admsys/statisticsmng/orgculturedig";
    }

    /**
     * 만족도조사 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/statisticsmng/satisfactionrsrch.html"
     * @throws Exception
     */
    @RequestMapping(value = "satisfactionrsrch.html")
    public String satisfactionrsrch(@ModelAttribute("ZStatisticsMngVo") ZStatisticsMngVo reqVo, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	DataTable input = new DataTable(req);
    	
    	if(!StringUtils.isEmpty(reqVo.getSdate())
    			&& !StringUtils.isEmpty(reqVo.getEdate())) {
    		reqVo.setSdate(reqVo.getSdate().replaceAll("-", ""));
    		reqVo.setEdate(reqVo.getEdate().replaceAll("-", ""));
    	}
    	
    	List<String> orgList = new ArrayList<String>();
    	if(StringUtils.isEmpty(reqVo.getOrg1())
    			&& StringUtils.isEmpty(reqVo.getOrg2())) {
    		orgList.add("gov");
    		orgList.add("priv");
    	}
    	
    	if(!StringUtils.isEmpty(reqVo.getOrg1())) {
    		orgList.add(reqVo.getOrg1());
    	}
    	if(!StringUtils.isEmpty(reqVo.getOrg2())) {
    		orgList.add(reqVo.getOrg2());
    	}
    	
    	reqVo.setOrgList(orgList);
    	
    	List<String> typeList = new ArrayList<String>();
    	if(StringUtils.isEmpty(reqVo.getType1())
    			&& StringUtils.isEmpty(reqVo.getType2())
    			&& StringUtils.isEmpty(reqVo.getType3())
    			&& StringUtils.isEmpty(reqVo.getType4())) {
    		typeList.add("A");
    		typeList.add("B");
    		typeList.add("C");
    		typeList.add("D");
    	}
    	
    	if(!StringUtils.isEmpty(reqVo.getType1())) {
    		typeList.add(reqVo.getType1());
    	}
    	if(!StringUtils.isEmpty(reqVo.getType2())) {
    		typeList.add(reqVo.getType2());
    	}
    	if(!StringUtils.isEmpty(reqVo.getType3())) {
    		typeList.add(reqVo.getType3());
    	}
    	if(!StringUtils.isEmpty(reqVo.getType4())) {
    		typeList.add(reqVo.getType4());
    	}
    	
    	reqVo.setTypeList(typeList);
    	
       	ZStatisticsMngVo getSatisfaction = zStatisticsMngService.getSatisfaction(reqVo);
    	
    	List<ZStatisticsMngVo> getSatisfaction1OpinionList = zStatisticsMngService.getSatisfaction1OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSatisfaction2OpinionList = zStatisticsMngService.getSatisfaction2OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSatisfaction3OpinionList = zStatisticsMngService.getSatisfaction3OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSatisfaction4OpinionList = zStatisticsMngService.getSatisfaction4OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSatisfaction5OpinionList = zStatisticsMngService.getSatisfaction5OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSatisfaction6OpinionList = zStatisticsMngService.getSatisfaction6OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSatisfaction7OpinionList = zStatisticsMngService.getSatisfaction7OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSatisfaction8OpinionList = zStatisticsMngService.getSatisfaction8OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSatisfaction9List = zStatisticsMngService.getSatisfaction9List(reqVo);
    	
    	model.addAttribute("getSatisfaction", getSatisfaction);
    	
    	model.addAttribute("getSatisfaction1OpinionList", getSatisfaction1OpinionList);
    	model.addAttribute("getSatisfaction2OpinionList", getSatisfaction2OpinionList);
    	model.addAttribute("getSatisfaction3OpinionList", getSatisfaction3OpinionList);
    	model.addAttribute("getSatisfaction4OpinionList", getSatisfaction4OpinionList);
    	model.addAttribute("getSatisfaction5OpinionList", getSatisfaction5OpinionList);
    	model.addAttribute("getSatisfaction6OpinionList", getSatisfaction6OpinionList);
    	model.addAttribute("getSatisfaction7OpinionList", getSatisfaction7OpinionList);
    	model.addAttribute("getSatisfaction8OpinionList", getSatisfaction8OpinionList);
    	model.addAttribute("getSatisfaction9List", getSatisfaction9List);
    	
    	model.addAttribute("input", input);
    	
        return "/zcms/admsys/statisticsmng/satisfactionrsrch";
    }
    
    /**
     * 설문조사 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/statisticsmng/surveyrsrch.html"
     * @throws Exception
     */
    @RequestMapping(value = "surveyrsrch.html")
    public String surveyrsrch(@ModelAttribute("ZStatisticsMngVo") ZStatisticsMngVo reqVo, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	DataTable input = new DataTable(req);
    	
    	if(!StringUtils.isEmpty(reqVo.getSdate())
    			&& !StringUtils.isEmpty(reqVo.getEdate())) {
    		reqVo.setSdate(reqVo.getSdate().replaceAll("-", ""));
    		reqVo.setEdate(reqVo.getEdate().replaceAll("-", ""));
    	}
    	
    	List<String> orgList = new ArrayList<String>();
    	if(StringUtils.isEmpty(reqVo.getOrg1())
    			&& StringUtils.isEmpty(reqVo.getOrg2())) {
    		orgList.add("gov");
    		orgList.add("priv");
    	}
    	
    	if(!StringUtils.isEmpty(reqVo.getOrg1())) {
    		orgList.add(reqVo.getOrg1());
    	}
    	if(!StringUtils.isEmpty(reqVo.getOrg2())) {
    		orgList.add(reqVo.getOrg2());
    	}
    	
    	reqVo.setOrgList(orgList);
    	
    	List<String> typeList = new ArrayList<String>();
    	if(StringUtils.isEmpty(reqVo.getType1())
    			&& StringUtils.isEmpty(reqVo.getType2())
    			&& StringUtils.isEmpty(reqVo.getType3())
    			&& StringUtils.isEmpty(reqVo.getType4())) {
    		typeList.add("A");
    		typeList.add("B");
    		typeList.add("C");
    		typeList.add("D");
    	}
    	
    	if(!StringUtils.isEmpty(reqVo.getType1())) {
    		typeList.add(reqVo.getType1());
    	}
    	if(!StringUtils.isEmpty(reqVo.getType2())) {
    		typeList.add(reqVo.getType2());
    	}
    	if(!StringUtils.isEmpty(reqVo.getType3())) {
    		typeList.add(reqVo.getType3());
    	}
    	if(!StringUtils.isEmpty(reqVo.getType4())) {
    		typeList.add(reqVo.getType4());
    	}
    	
    	reqVo.setTypeList(typeList);
    	
       	ZStatisticsMngVo getSurvey = zStatisticsMngService.getSurvey(reqVo);

    	List<ZStatisticsMngVo> getSurvey7OpinionList = zStatisticsMngService.getSurvey7OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSurvey7_1_1OpinionList = zStatisticsMngService.getSurvey7_1_1OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSurvey7_2_1OpinionList = zStatisticsMngService.getSurvey7_2_1OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSurvey10OpinionList = zStatisticsMngService.getSurvey10OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSurvey11OpinionList = zStatisticsMngService.getSurvey11OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSurvey12OpinionList = zStatisticsMngService.getSurvey12OpinionList(reqVo);
    	List<ZStatisticsMngVo> getSurvey13OpinionList = zStatisticsMngService.getSurvey13OpinionList(reqVo);

    	model.addAttribute("getSurvey", getSurvey);
    	
    	model.addAttribute("getSurvey7OpinionList", getSurvey7OpinionList);
    	model.addAttribute("getSurvey7_1_1OpinionList", getSurvey7_1_1OpinionList);
    	model.addAttribute("getSurvey7_2_1OpinionList", getSurvey7_2_1OpinionList);
    	model.addAttribute("getSurvey10OpinionList", getSurvey10OpinionList);
    	model.addAttribute("getSurvey11OpinionList", getSurvey11OpinionList);
    	model.addAttribute("getSurvey12OpinionList", getSurvey12OpinionList);
    	model.addAttribute("getSurvey13OpinionList", getSurvey13OpinionList);
    	
    	model.addAttribute("input", input);
    	
        return "/zcms/admsys/statisticsmng/surveyrsrch";
    }
    
    /**
     * 사전질의 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/statisticsmng/prequeryrsrch.html"
     * @throws Exception
     */
    @RequestMapping(value = "prequeryrsrch.html")
    public String prequeryrsrch(@ModelAttribute("ZStatisticsMngVo") ZStatisticsMngVo reqVo, ModelMap model, HttpServletRequest req) throws Exception {
    	
    	DataTable input = new DataTable(req);
    	
    	if(!StringUtils.isEmpty(reqVo.getSdate())
    			&& !StringUtils.isEmpty(reqVo.getEdate())) {
    		reqVo.setSdate(reqVo.getSdate().replaceAll("-", ""));
    		reqVo.setEdate(reqVo.getEdate().replaceAll("-", ""));
    	}
    	
    	List<String> orgList = new ArrayList<String>();
    	if(StringUtils.isEmpty(reqVo.getOrg1())
    			&& StringUtils.isEmpty(reqVo.getOrg2())) {
    		orgList.add("gov");
    		orgList.add("priv");
    	}
    	
    	if(!StringUtils.isEmpty(reqVo.getOrg1())) {
    		orgList.add(reqVo.getOrg1());
    	}
    	if(!StringUtils.isEmpty(reqVo.getOrg2())) {
    		orgList.add(reqVo.getOrg2());
    	}

    	reqVo.setOrgList(orgList);
    	
    	List<String> typeList = new ArrayList<String>();
    	if(StringUtils.isEmpty(reqVo.getType1())
    			&& StringUtils.isEmpty(reqVo.getType2())
    			&& StringUtils.isEmpty(reqVo.getType3())
    			&& StringUtils.isEmpty(reqVo.getType4())) {
    		typeList.add("A");
    		typeList.add("B");
    		typeList.add("C");
    		typeList.add("D");
    	}
    	
    	if(!StringUtils.isEmpty(reqVo.getType1())) {
    		typeList.add(reqVo.getType1());
    	}
    	if(!StringUtils.isEmpty(reqVo.getType2())) {
    		typeList.add(reqVo.getType2());
    	}
    	if(!StringUtils.isEmpty(reqVo.getType3())) {
    		typeList.add(reqVo.getType3());
    	}
    	if(!StringUtils.isEmpty(reqVo.getType4())) {
    		typeList.add(reqVo.getType4());
    	}
    	
    	reqVo.setTypeList(typeList);
    	
       	ZStatisticsMngVo getPrequery = zStatisticsMngService.getPrequery(reqVo);
   
    	List<ZStatisticsMngVo> getPrequery2_8OpinionList = zStatisticsMngService.getPrequery2_8OpinionList(reqVo);
    	List<ZStatisticsMngVo> getPrequery4List = zStatisticsMngService.getPrequery4List(reqVo);
    	List<ZStatisticsMngVo> getPrequery5_8OpinionList = zStatisticsMngService.getPrequery5_8OpinionList(reqVo);
    	List<ZStatisticsMngVo> getPrequery6_1_7OpinionList = zStatisticsMngService.getPrequery6_1_7OpinionList(reqVo);
    	List<ZStatisticsMngVo> getPrequery6_2_6OpinionList = zStatisticsMngService.getPrequery6_2_6OpinionList(reqVo);
    	List<ZStatisticsMngVo> getPrequery6_2_1_6OpinionList = zStatisticsMngService.getPrequery6_2_1_6OpinionList(reqVo);
    	List<ZStatisticsMngVo> getPrequery6_3_3OpinionList = zStatisticsMngService.getPrequery6_3_3OpinionList(reqVo);
    	List<ZStatisticsMngVo> getPrequery7_4OpinionList = zStatisticsMngService.getPrequery7_4OpinionList(reqVo);
    	List<ZStatisticsMngVo> getPrequery9List = zStatisticsMngService.getPrequery9List(reqVo);
    	List<ZStatisticsMngVo> getPrequery10List = zStatisticsMngService.getPrequery10List(reqVo);
    	List<ZStatisticsMngVo> getPrequery11List = zStatisticsMngService.getPrequery11List(reqVo);
    	List<ZStatisticsMngVo> getPrequery13List = zStatisticsMngService.getPrequery13List(reqVo);
    	
    	
    	model.addAttribute("getPrequery", getPrequery);
    	
    	model.addAttribute("getPrequery2_8OpinionList", getPrequery2_8OpinionList);
    	model.addAttribute("getPrequery4List", getPrequery4List);
    	model.addAttribute("getPrequery5_8OpinionList", getPrequery5_8OpinionList);
    	model.addAttribute("getPrequery6_1_7OpinionList", getPrequery6_1_7OpinionList);
    	model.addAttribute("getPrequery6_2_6OpinionList", getPrequery6_2_6OpinionList);
    	model.addAttribute("getPrequery6_2_1_6OpinionList", getPrequery6_2_1_6OpinionList);
    	model.addAttribute("getPrequery6_3_3OpinionList", getPrequery6_3_3OpinionList);
    	model.addAttribute("getPrequery7_4OpinionList", getPrequery7_4OpinionList);
    	model.addAttribute("getPrequery9List", getPrequery9List);
    	model.addAttribute("getPrequery10List", getPrequery10List);
    	model.addAttribute("getPrequery11List", getPrequery11List);
    	model.addAttribute("getPrequery13List", getPrequery13List);
    	
    	model.addAttribute("input", input);
    	
        return "/zcms/admsys/statisticsmng/prequeryrsrch";
    }
}
