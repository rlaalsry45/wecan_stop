package com.z5.zcms.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;

@Controller
public class CommonCodeUtil {
	
	@Autowired
	private EgovCmmUseService cmmUseService;

	/**
	 * 
	 * @param code를 입력
	 */
	public String getCommonCodeString(String code){
		
		String rtv = "";
		try {
			ComDefaultCodeVO vo = new ComDefaultCodeVO();
			vo.setCodeId(code);
			List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);
			List<CmmnDetailCode> list = (List<CmmnDetailCode>)codeResult;
			if(!(list == null || list.size() < 1)){
				 return "";
			}else{
				rtv = list.get(0).getCode();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rtv;
	}
	public List<CmmnDetailCode> getCommonCodeList(String code){
		
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId(code);
		
		List<CmmnDetailCode> list = null;
		
		try {
			List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);
			
			list = (List<CmmnDetailCode>)codeResult;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
		
}


