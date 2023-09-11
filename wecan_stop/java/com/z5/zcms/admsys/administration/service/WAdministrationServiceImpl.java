package com.z5.zcms.admsys.administration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.z5.zcms.admsys.administration.dao.WAdministrationDAO;
import com.z5.zcms.admsys.administration.domain.PressRelVo;
import com.z5.zcms.admsys.administration.domain.PressVo;
import com.z5.zcms.util.DataTable;

import egovframework.com.cmm.service.EgovProperties;

@Service
public class WAdministrationServiceImpl implements WAdministrationService {

	@Autowired
	private WAdministrationDAO wAdministrationDAO;

	@Override
	public int press_registration(PressVo reqVo) throws Exception {
		return wAdministrationDAO.press_registration(reqVo);
	}

	@Override
	public PressVo press_view(int no) throws Exception {
		return wAdministrationDAO.press_view(no);
	}

	@Override
	public Model index(PressVo reqVo, DataTable input, Model model) throws Exception {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        int total = this.wAdministrationDAO.listCount(reqVo);
        input.put("target", input.get("target"));
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<PressVo> list = this.wAdministrationDAO.getlist(reqVo);
        
        if ( list.size() > 0 ) {
            for ( int i = 0; i < list.size(); i++ ) {
                PressRelVo vo = new PressRelVo();
                vo.setPress_no(list.get(i).getNO());
                //연관 상담 번호 목록
                vo.setCon_ac_type("con");
                List<PressRelVo> conRelList = this.wAdministrationDAO.retrievePressRelListByPressNo(vo);
                if ( conRelList.size() > 0 ) {
                	list.get(i).setConRelList(conRelList);
                }
                
                //연관 조치 번호 목록
                vo.setCon_ac_type("ac");
                List<PressRelVo> acRelList = this.wAdministrationDAO.retrievePressRelListByPressNo(vo);
                if ( acRelList.size() > 0 ) {
                	list.get(i).setAcRelList(acRelList);
                }
            }
        }

        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public int press_update(PressVo reqVo) throws Exception {
		//
		this.wAdministrationDAO.deletePressRelByPressNo(reqVo.getNO());
		//
		if ( reqVo.getActionNoList().size() > 0 ) {
			PressVo ta = reqVo;
			ta.setCon_ac_type("ac");
			ta.setConAcPressNoList(reqVo.getActionNoList());
			
			this.wAdministrationDAO.registrationPressConAc(reqVo);
		}
		
		if ( reqVo.getConsultingNoList().size() > 0 ) {
			PressVo ta = reqVo;
			ta.setCon_ac_type("con");
			ta.setConAcPressNoList(reqVo.getConsultingNoList());
			
			this.wAdministrationDAO.registrationPressConAc(reqVo);
		}
		//
		return this.wAdministrationDAO.press_update(reqVo);
	}

	@Override
	public int deleteRequestByTeacher(PressVo reqVo) throws Exception {
		return this.wAdministrationDAO.deleteRequestByTeacher(reqVo);
	}

	@Override
	public void registrationPressConAc(PressVo reqVo) throws Exception {
		if ( reqVo.getActionNoList().size() > 0 ) {
			PressVo ta = reqVo;
			ta.setCon_ac_type("ac");
			ta.setConAcPressNoList(reqVo.getActionNoList());
			
			this.wAdministrationDAO.registrationPressConAc(reqVo);
		}
		
		if ( reqVo.getConsultingNoList().size() > 0 ) {
			PressVo ta = reqVo;
			ta.setCon_ac_type("con");
			ta.setConAcPressNoList(reqVo.getConsultingNoList());
			
			this.wAdministrationDAO.registrationPressConAc(reqVo);
		}
	}

	@Override
	public List<PressRelVo> retrievePressRelListByPressNo(PressRelVo vo) throws Exception {
		return this.wAdministrationDAO.retrievePressRelListByPressNo(vo);
	}

	@Override
	public void registrationConAcWithPressNo(PressRelVo vo) throws Exception {
		this.wAdministrationDAO.registrationConAcWithPressNo(vo);
	}

	@Override
	public List<PressRelVo> retrievePressRelListByConAcNo(PressRelVo vo) throws Exception {
		return wAdministrationDAO.retrievePressRelListByConAcNo(vo);
	}

	@Override
	public void deletePressRelByConAcNo(int con_ac_no) throws Exception {
		wAdministrationDAO.deletePressRelByConAcNo(con_ac_no);
	}
}