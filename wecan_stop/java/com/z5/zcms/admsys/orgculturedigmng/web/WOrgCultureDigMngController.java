package com.z5.zcms.admsys.orgculturedigmng.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.z5.zcms.admsys.administration.domain.PressRelVo;
import com.z5.zcms.admsys.administration.service.WAdministrationService;
import com.z5.zcms.admsys.common.domain.EditHistoryVo;
import com.z5.zcms.admsys.common.domain.FileInfoVo;
import com.z5.zcms.admsys.common.service.CommonFileService;
import com.z5.zcms.admsys.common.service.CommonService;
import com.z5.zcms.admsys.orgculturedigmng.domain.CommInfoVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ConInfoRelActionVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrganizationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WRegOrgCultureDigMngVo;
import com.z5.zcms.admsys.orgculturedigmng.service.WOrgCultureDigMngService;
import com.z5.zcms.admsys.orgculturedigmng.service.ZOrgCultureDigMngService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

import static com.z5.zcms.util.ZPrint.enter;
import static com.z5.zcms.util.ZPrint.print;

@RequestMapping("/admsys/orgculturedigmng/")
@Controller
public class WOrgCultureDigMngController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private WOrgCultureDigMngService wOrgCultureDigMngService;

	@Autowired
	ZOrgCultureDigMngService zOrgCultureDigMngService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private CommonFileService commonFileService;

	@Autowired
	private WAdministrationService wAdministrationService;

	/**
	 * 담당관지정 및 접수 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/index.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "index.html")
	public String index(ModelMap model) throws Exception {
		return "/zcms/admsys/orgculturedigmng/index";
	}

	/**
	 * 담당관 진단 관리 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng.html")
	public String picdigmng(@ModelAttribute("WOrgCultureDigMngVo") WOrgCultureDigMngVo reqVo, Model model,
			HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);

		reqVo.setBbsType("P");

		String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setLoginUserId(userId);

		wOrgCultureDigMngService.index(reqVo, input, model);

		String retUrl = "";

		if (StringUtils.isNotBlank(reqVo.getMode()) && StringUtils.equalsIgnoreCase(reqVo.getMode(), "POP")) {
			retUrl = "/zcms/admsys/administration/linkActionPopup";
		} else {
			retUrl = "/zcms/admsys/orgculturedigmng/picdigmng";
		}

		return retUrl;
	}

	/**
	 * 담당관 진단 관리 등록 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_registration_form.html")
	public String picdigmng_registration_form(ModelMap model) throws Exception {	
		model.addAttribute("mode", "reg");
		Map<String, Object> defValue = new HashMap<String, Object>();
		defValue.put("NO", -1);

		// 위원 목록
		/*
		 * WCounselorVo c = new WCounselorVo(); c.setM(0); c.setN(99999);
		 * List<WCounselorVo> cList = wOrgCultureDigMngService.getCommList(c);
		 * model.addAttribute("cList", cList);
		 */

		model.addAttribute("data", defValue);

		// managrList
		List<ManagerListVo> ml = new ArrayList<ManagerListVo>();
		ml = wOrgCultureDigMngService.managerList();
		model.addAttribute("ml", ml);

		return "/zcms/admsys/orgculturedigmng/picdigmng_info_form";
	}

	/**
	 * 담당관 진단 관리 데이터 등록 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_registration.html")
	@ResponseBody
	public WOrgCultureDigMngVo picdigmng_registration(@RequestBody Map<String, Object> mapVo, ModelMap model, HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		WOrgCultureDigMngVo ret = new WOrgCultureDigMngVo();
			
		//
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		WRegOrgCultureDigMngVo tempVo = mapper.convertValue(mapVo, WRegOrgCultureDigMngVo.class);
		//

		String userId = SecuritySessionUtil.getUserid(req);

		WOrgCultureDigMngVo reqVo = new WOrgCultureDigMngVo();
		BeanUtils.copyProperties(reqVo, tempVo);

		reqVo.setCreate_user(userId);
		reqVo.setManager(userId);

		try {
			
			print("IS IN PROCESS ?"+userId);
			System.out.print("IS IN PROCESS ?");
			
			List<String> tmL = reqVo.getManagerList();

			if (tmL.size() == 1) {
				if (!StringUtils.equalsIgnoreCase(tmL.get(0), userId)) {
					reqVo.setManager(tmL.get(0));
				}
			} else if (tmL.size() > 1) {
				// 본인이 없다면 만들어주자.
				boolean selfExistCheck = false;
				for (int i = 0; i < tmL.size(); i++) {
					if (StringUtils.equalsIgnoreCase(tmL.get(i), userId)) {
						selfExistCheck = true;
						break;
					}
				}
				
				if (!selfExistCheck) {
					reqVo.getManagerList().add(tmL.size(), userId);
				}
				
			}

			int lastInsertNo = wOrgCultureDigMngService.registration(reqVo);
			ret.setNO(lastInsertNo);

			WOrgCultureDigMngVo temp = wOrgCultureDigMngService.view(ret);
			ret.setConsulting_action_no(temp.getConsulting_action_no());

			reqVo.setConsulting_action_no(temp.getConsulting_action_no());
			reqVo.setCreate_user(userId);
			
			// 상담 등록
			if ( reqVo.getConsultingNoList().size() > 0 ) {
				wOrgCultureDigMngService.insertRelAcWithCon(reqVo);
			}
			
			// comissioner insert
			List<CommInfoVo> cL = new ArrayList<CommInfoVo>();
			cL = reqVo.getCmmList();
			if ( cL.size() > 0 ) {
				wOrgCultureDigMngService.insertRelComissioner(reqVo);
			}

			// manager insert
			if (tmL.size() > 0) {
				reqVo.setCon_ac_type("ac");
				wOrgCultureDigMngService.insertRelManager(reqVo);
			}

			// press
			if (reqVo.getPressList().size() > 0) {
				PressRelVo t = new PressRelVo();
				t.setCon_ac_type("ac");
				t.setCon_ac_no(lastInsertNo + "");
				t.setPressNoList(reqVo.getPressList());
				t.setCreate_user(userId);

				wAdministrationService.registrationConAcWithPressNo(t);
			}

			// file
			if (reqVo.getFileList().size() > 0) {
				for (int i = 0; i < reqVo.getFileList().size(); i++) {
					int tempNO = Integer.valueOf(reqVo.getFileList().get(i));
					FileInfoVo tv = new FileInfoVo();
					tv.setUpdate_user(userId);
					tv.setMenu_cate("ac");
					tv.setMenu_no(lastInsertNo);
					tv.setFile_seq(i + 1);
					tv.setNO(tempNO);

					commonFileService.updateFileInfo(tv);
				}
			}

			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("view");

		return ret;
	}
	
	/**
	 * 담당관 진단 관리 상세 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_view.html")
	public String picdigmng_view(@ModelAttribute("WOrgCultureDigMngVo") WOrgCultureDigMngVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		try {
			WOrgCultureDigMngVo view = wOrgCultureDigMngService.view(reqVo);

			// 수정 이력 목록
			EditHistoryVo ehVo = new EditHistoryVo();
			ehVo.setConsulting_action_no(reqVo.getConsulting_action_no());
			List<EditHistoryVo> historyList = commonService.retrieveEditHistory(ehVo);
			model.addAttribute("data", view);
			model.addAttribute("historyList", historyList);

			// 첨부 파일 목록
			FileInfoVo fileVo = new FileInfoVo();
			fileVo.setMenu_no(reqVo.getNO());
			fileVo.setMenu_cate("ac");
			List<FileInfoVo> fileList = commonFileService.retrieveFilListByMenuNo(fileVo);
			model.addAttribute("fileList", fileList);

			// 연관 언론 모니터링 목록
			PressRelVo vo = new PressRelVo();
			vo.setCon_ac_no(reqVo.getNO() + "");
			vo.setCon_ac_type("ac");
			List<PressRelVo> relAcList = wAdministrationService.retrievePressRelListByConAcNo(vo);
			model.addAttribute("acList", relAcList);

			// 위원 목록
			List<CommInfoVo> cList = wOrgCultureDigMngService.retrieveCommissionoerList(view.getConsulting_action_no());
			model.addAttribute("cList", cList);

			// 저장된 담당관 목록
			List<ManagerListVo> sml = wOrgCultureDigMngService
					.retrieveManagerListByConsultIngActionNO(view.getConsulting_action_no());
			model.addAttribute("sml", sml);

			// managrList
			List<ManagerListVo> ml = wOrgCultureDigMngService.managerList();
			model.addAttribute("ml", ml);
			
			// 상담 목록
			List<ConInfoRelActionVo> conList= wOrgCultureDigMngService.retrieveRelConList(view.getConsulting_action_no());
			model.addAttribute("conList", conList);

		} catch (Exception e) {
			log.error(e);
		}

		model.addAttribute("mode", "view");

		return "/zcms/admsys/orgculturedigmng/picdigmng_info_form";
	}

	/**
	 * 담당관 진단 관리 수정 컨트롤러
	 *
	 * @param model
	 * @return WOrgCultureDigMngVo
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_update.html")
	@ResponseBody
	//public WOrgCultureDigMngVo picdigmng_update(@ModelAttribute("WOrgCultureDigMngVo") WOrgCultureDigMngVo reqVo,
	public WOrgCultureDigMngVo picdigmng_update(@RequestBody Map<String, Object> mapVo,
			ModelMap model, HttpServletRequest req) throws Exception {

		String retVal = "FAIL";
		WOrgCultureDigMngVo ret = new WOrgCultureDigMngVo();
		
		//
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		WRegOrgCultureDigMngVo tempVo = mapper.convertValue(mapVo, WRegOrgCultureDigMngVo.class);
		//

		String userId = SecuritySessionUtil.getUserid(req);
		
		WOrgCultureDigMngVo reqVo = new WOrgCultureDigMngVo();
		BeanUtils.copyProperties(reqVo, tempVo);
		
		reqVo.setUpdate_user(userId);

		try {
			List<String> tmL = reqVo.getManagerList();

			if (tmL.size() == 1) {
				if (!StringUtils.equalsIgnoreCase(tmL.get(0), userId)) {
					reqVo.setManager(tmL.get(0));
				}
			} else if (tmL.size() > 1) {
				// 본인이 없다면 만들어주자.
				boolean selfExistCheck = false;
				for (int i = 0; i < tmL.size(); i++) {
					if (StringUtils.equalsIgnoreCase(tmL.get(i), userId)) {
						selfExistCheck = true;
						break;
					}
				}
				if (!selfExistCheck) {
					reqVo.getManagerList().add(tmL.size(), userId);
				}
			}

			wOrgCultureDigMngService.actionUpdate(reqVo);
			//

			reqVo.setConsulting_action_no(reqVo.getConsulting_action_no());
			reqVo.setCreate_user(userId);
			
			// 연결된 상담 수정
			wOrgCultureDigMngService.deleteRelConsultingByConsultingActionNO(reqVo.getConsulting_action_no());
			if ( reqVo.getConsultingNoList().size() > 0 ) {
				wOrgCultureDigMngService.insertRelAcWithCon(reqVo);
			}

			// 위원 수정
			wOrgCultureDigMngService.deleteRelCommissionerByConsultingActionNO(reqVo.getConsulting_action_no());
			if ( reqVo.getCmmList().size() > 0 ) {
				wOrgCultureDigMngService.insertRelComissioner(reqVo);
			}
			
			// manager insert
			wOrgCultureDigMngService.deleteRelManagerByConsultingActionNO(reqVo.getConsulting_action_no());
			if (reqVo.getManagerList().size() > 0) {
				reqVo.setCon_ac_type("ac");
				wOrgCultureDigMngService.insertRelManager(reqVo);
			}

			// 수정 이력
			EditHistoryVo ehVo = new EditHistoryVo();
			ehVo.setCreate_user(userId);
			ehVo.setConsulting_action_no(reqVo.getConsulting_action_no());
			ehVo.setEdit_contents(reqVo.getEdit_reason());
			commonService.registrationEditHistory(ehVo);

			// press
			wAdministrationService.deletePressRelByConAcNo(reqVo.getNO());
			if (reqVo.getPressList().size() > 0) {
				PressRelVo t = new PressRelVo();
				t.setCon_ac_type("ac");
				t.setCon_ac_no(reqVo.getNO() + "");
				t.setPressNoList(reqVo.getPressList());
				t.setCreate_user(userId);

				wAdministrationService.registrationConAcWithPressNo(t);
			}

			// file
			FileInfoVo tc = new FileInfoVo();
			tc.setMenu_cate("ac");
			tc.setMenu_no(reqVo.getNO());
			int fseq = commonFileService.retrieveFileCountByNO(tc);
			if (reqVo.getFileList().size() > 0) {
				for (int i = 0; i < reqVo.getFileList().size(); i++) {
					int tempNO = Integer.valueOf(reqVo.getFileList().get(i));
					FileInfoVo tv = new FileInfoVo();
					tv.setUpdate_user(userId);
					tv.setMenu_cate("ac");
					tv.setMenu_no(reqVo.getNO());
					tv.setFile_seq((fseq) + (i + 1));
					tv.setNO(tempNO);

					commonFileService.updateFileInfo(tv);
				}
			}

			retVal = "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("edit");

		return ret;
	}

	/**
	 * 담당관 진단 관리 삭제 컨트롤러 실제 삭제는 아니며, delete_yn = 'Q' 로 요청, 추후 마리아 이벤트에서 정해진 기간에
	 * delete_yn = 'Q'로 되어 있는걸 일괄 삭제한다.
	 *
	 * @param model
	 * @return WOrgCultureDigMngVo
	 * @throws Exception
	 */
	@RequestMapping(value = "picdigmng_req_delete.html")
	@ResponseBody
	public WOrgCultureDigMngVo picdigmng_req_delete(WOrgCultureDigMngVo reqVo, ModelMap model, HttpServletRequest req)
			throws Exception {
		String retVal = "FAIL";
		WOrgCultureDigMngVo ret = new WOrgCultureDigMngVo();

		String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setDelete_user(userId);

		try {
			wOrgCultureDigMngService.deleteRequestByTeacher(reqVo);
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("delete");

		return ret;
	}

	/**
	 * 담당관 상담관리 삭제 팝업 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/deleteAlramPop.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgculturedigmng_del_alram.html", method = RequestMethod.GET)
	public String orgculturedigmng_del_alram(
			@RequestParam(value = "consulting_action_no", defaultValue = "-") String consulting_action_no,
			ModelMap model) throws Exception {
		model.addAttribute("consulting_action_no", consulting_action_no);
		return "/zcms/admsys/orgculturedigmng/deleteAlramPop";
	}

	/**
	 * 전체 진단 조회 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/alldigsrch.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "alldigsrch.html")
	public String alldigsrch(@ModelAttribute("WOrgCultureDigMngVo") WOrgCultureDigMngVo reqVo, Model model,
			HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);

		reqVo.setBbsType("A");

		wOrgCultureDigMngService.index(reqVo, input, model);

		String retUrl = "";

		if (StringUtils.isNotBlank(reqVo.getMode()) && StringUtils.equalsIgnoreCase(reqVo.getMode(), "POP")) {
			retUrl = "/zcms/admsys/administration/linkActionPopup";
		} else {
			retUrl = "/zcms/admsys/orgculturedigmng/alldigsrch";
		}

		return retUrl;
	}

	/**
	 * 전체 일정 관리 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/allschedmng.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "allschedmng.html")
	public String allschedmng(ModelMap model) throws Exception {
		return "/zcms/admsys/orgculturedigmng/allschedmng";
	}

	/**
	 * 조치일지 삭제함 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/allhisdel.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "allhisdel.html")
	public String allhisdel(@ModelAttribute("WOrgCultureDigMngVo") WOrgCultureDigMngVo reqVo, Model model,
			HttpServletRequest req) throws Exception {

		DataTable input = new DataTable(req);

		wOrgCultureDigMngService.delIndex(reqVo, input, model);

		return "/zcms/admsys/orgculturedigmng/allhisdel";
	}

	/**
	 * 조치일지 삭제함 영구삭제 컨트롤러
	 *
	 * @param model
	 * @return WOrganizationVo
	 * @throws Exception
	 */
	@RequestMapping(value = "allhisdel_req_delPermanent.html")
	@ResponseBody
	public WOrganizationVo allhisdel_req_delPermanent(@ModelAttribute("WOrgCultureDigMngVo") WOrgCultureDigMngVo reqVo,
			Model model, HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		WOrganizationVo ret = new WOrganizationVo();
		try {
			wOrgCultureDigMngService.delPermanent(reqVo);

			retVal = "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("delete");

		return ret;
	}

	/**
	 * 조치일지 삭제함 복원 컨트롤러
	 *
	 * @param model
	 * @return WOrganizationVo
	 * @throws Exception
	 */
	@RequestMapping(value = "allhisdel_req_updDelYn.html")
	@ResponseBody
	public WOrganizationVo allhisdel_req_updDelYn(@ModelAttribute("WOrgCultureDigMngVo") WOrgCultureDigMngVo reqVo,
			Model model, HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		WOrganizationVo ret = new WOrganizationVo();
		String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setUpdate_user(userId);

		try {
			wOrgCultureDigMngService.updDelYn(reqVo);

			retVal = "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("update");

		return ret;
	}

	/**
	 * 기관 관리 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/orgmng.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng.html")
	public String orgmng(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, Model model, HttpServletRequest req)
			throws Exception {

		try {
			DataTable input = new DataTable(req);
			zOrgCultureDigMngService.orgIndex(reqVo, input, model);

		} catch (Exception e) {
			log.error(e);
		}

		return "/zcms/admsys/orgculturedigmng/orgmng";
	}

	/**
	 * 기관 관리 사용/미사용 처리 컨트롤러
	 *
	 * @param model
	 * @return WOrgCultureDigMngVo
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_req_updUse.html")
	@ResponseBody
	public WOrganizationVo orgmng_req_updUse(WOrganizationVo reqVo, ModelMap model, HttpServletRequest req)
			throws Exception {
		String retVal = "FAIL";
		WOrganizationVo ret = new WOrganizationVo();
		try {
			String userId = SecuritySessionUtil.getUserid(req);
			for (String upd : reqVo.getUpdList()) {
				String[] updArray = upd.split("/");
				String useYn = updArray[1];
				reqVo = new WOrganizationVo();
				reqVo.setOrganizationId(updArray[0]);
				if ("Y".equals(useYn)) {
					reqVo.setUseYn("N");
				} else {
					reqVo.setUseYn("Y");
				}
				reqVo.setUpdId(userId);
				zOrgCultureDigMngService.orgUpdUse(reqVo);
			}
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("update");

		return ret;
	}

	/**
	 * 기관 관리 등록 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/orgmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_registration_form.html")
	public String orgmng_info_form(ModelMap model) throws Exception {
		model.addAttribute("mode", "reg");
		return "/zcms/admsys/orgculturedigmng/orgmng_info_form";
	}

	/**
	 * 기관 관리 데이터 등록 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/orgmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_registration.html")
	@ResponseBody
	public WCounselorVo orgmng_registration(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		WCounselorVo ret = new WCounselorVo();
		try {
			String userId = SecuritySessionUtil.getUserid(req);

			LocalDate now = LocalDate.now();
			int year = now.getYear();

			String organizationId = zOrgCultureDigMngService.getOrgIdSeq();

			reqVo.setOrganizationId(organizationId);
			reqVo.setOrganizationTelnum(reqVo.getOrganizationTelnum().replaceAll("-", ""));
			reqVo.setRegId(userId);
			zOrgCultureDigMngService.orgRegistration(reqVo);
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("view");

		return ret;
	}

	/**
	 * 기관 관리 상세 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/orgmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_view.html")
	public String orgmng_view(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		try {
			WOrganizationVo view = zOrgCultureDigMngService.orgView(reqVo);
			model.addAttribute("data", view);

		} catch (Exception e) {
			log.error(e);
		}

		model.addAttribute("mode", "view");

		return "/zcms/admsys/orgculturedigmng/orgmng_info_form";
	}

	/**
	 * 담당관 진단 관리 수정 컨트롤러
	 *
	 * @param model
	 * @return WOrgCultureDigMngVo
	 * @throws Exception
	 */
	@RequestMapping(value = "orgmng_update.html")
	@ResponseBody
	public WOrganizationVo orgmng_update(@ModelAttribute("WOrganizationVo") WOrganizationVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		String retVal = "FAIL";
		WOrganizationVo ret = new WOrganizationVo();

		try {
			String userId = SecuritySessionUtil.getUserid(req);

			reqVo.setOrganizationTelnum(reqVo.getOrganizationTelnum().replaceAll("-", ""));
			reqVo.setUpdId(userId);
			zOrgCultureDigMngService.orgUpdate(reqVo);

			retVal = "SUCCESS";
		} catch (Exception e) {
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("edit");

		return ret;
	}

	/**
	 * 기관 관리 엑셀다운로드 컨트롤러
	 *
	 * @param model
	 * @return WOrgCultureDigMngVo
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value = "orgmng_req_excel.html")
	 * 
	 * @ResponseBody public WOrganizationVo orgmng_req_excel(WOrganizationVo reqVo ,
	 * ModelMap model, HttpServletRequest req) throws Exception { String
	 * retVal="FAIL"; WOrganizationVo ret = new WOrganizationVo(); try { String
	 * filepath = ""; String sheetName = reqVo.getSheetName();
	 * 
	 * createExcelToFile(List<Map<String, Object>> datas, filepath, sheetName);
	 * retVal="SUCCESS";
	 * 
	 * } catch ( Exception e) { e.printStackTrace(); log.error(e); }
	 * 
	 * ret.setRetStatus(retVal); ret.setMode("update");
	 * 
	 * return ret; }
	 */

	/**
	 * 위원 관리 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/commmng.html"
	 * @throws Exception
	 */

	@RequestMapping(value = "commmng.html")
	public String commmng(@ModelAttribute("zCounselorVo") WCounselorVo reqVo, Model model, HttpServletRequest req)
			throws Exception {
		DataTable input = new DataTable(req);

		zOrgCultureDigMngService.index(reqVo, input, model);

		String retUrl = "";

		if (StringUtils.isNotBlank(reqVo.getMode()) && StringUtils.equalsIgnoreCase(reqVo.getMode(), "POP")) {
			retUrl = "/zcms/admsys/orgculturedigmng/linkCommissionerPopup";
		} else {
			retUrl = "/zcms/admsys/orgculturedigmng/commmng";
		}

		return retUrl;
	}

	/**
	 * 위원 관리 등록 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/commmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "commmng_registration_form.html")
	public String commmng_registration_form(ModelMap model) throws Exception {
		Map<String, Object> defValue = new HashMap<String, Object>();
		defValue.put("NO", -1);

		model.addAttribute("data", defValue);
		model.addAttribute("mode", "reg");
		return "/zcms/admsys/orgculturedigmng/commmng_info_form";
	}

	/**
	 * 위원 관리 데이터 등록 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/commmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "commmng_registration.html")
	@ResponseBody
	public WCounselorVo commmng_registration(@ModelAttribute("WCounselorVo") WCounselorVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {
		String retVal = "FAIL";
		WCounselorVo ret = new WCounselorVo();
		String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setRegUser(userId);

		try {
			zOrgCultureDigMngService.registration(reqVo);
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("view");

		return ret;
	}

	/**
	 * 위원 관리 상세 view 컨트롤러
	 *
	 * @param model
	 * @return "/zcms/admsys/orgculturedigmng/picdigmng_info_form.html"
	 * @throws Exception
	 */
	@RequestMapping(value = "commmng_view.html")
	public String commmng_view(@ModelAttribute("WCounselorVo") WCounselorVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		try {
			WCounselorVo view = zOrgCultureDigMngService.view(reqVo);

			model.addAttribute("data", view);

		} catch (Exception e) {
			log.error(e);
		}

		model.addAttribute("mode", "view");

		return "/zcms/admsys/orgculturedigmng/commmng_info_form";
	}

	/**
	 * 위원 관리 수정 컨트롤러
	 *
	 * @param model
	 * @return WCounselorVo
	 * @throws Exception
	 */
	@RequestMapping(value = "commmng_update.html")
	@ResponseBody
	public WCounselorVo picdigmng_update(@ModelAttribute("WCounselorVo") WCounselorVo reqVo, ModelMap model,
			HttpServletRequest req) throws Exception {

		String retVal = "FAIL";
		WCounselorVo ret = new WCounselorVo();

		String userId = SecuritySessionUtil.getUserid(req);
		reqVo.setRegUser(userId);

		try {
			zOrgCultureDigMngService.actionUpdate(reqVo);

			retVal = "SUCCESS";
		} catch (Exception e) {
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("edit");

		return ret;
	}

	/**
	 * 위원 관리 삭제 컨트롤러 실제 삭제는 아니며, delete_yn = 'Q' 로 요청, 추후 마리아 이벤트에서 정해진 기간에
	 * delete_yn = 'Q'로 되어 있는걸 일괄 삭제한다.
	 *
	 * @param model
	 * @return WOrgCultureDigMngVo
	 * @throws Exception
	 */
	@RequestMapping(value = "commmng_req_delete.html")
	@ResponseBody
	public WCounselorVo picdigmng_req_delete(WCounselorVo reqVo, ModelMap model, HttpServletRequest req)
			throws Exception {
		String retVal = "FAIL";
		WCounselorVo ret = new WCounselorVo();

		String userId = SecuritySessionUtil.getUserid(req);

		try {
			zOrgCultureDigMngService.delete(reqVo);
			retVal = "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		ret.setRetStatus(retVal);
		ret.setMode("delete");

		return ret;
	}

}
