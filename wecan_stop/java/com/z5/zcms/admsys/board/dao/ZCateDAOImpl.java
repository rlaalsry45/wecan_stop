package com.z5.zcms.admsys.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.board.domain.ZCateVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZCateDAOImpl extends EgovComAbstractDAO implements ZCateDAO {

    private final String sqlMapNs = "ZCate.";

    @SuppressWarnings("unchecked")
    public List<ZCateVo> boardCateList(int boardno) throws Exception {
        return (List<ZCateVo>) list(sqlMapNs + "boardCateList", boardno);
    }

    @Transactional
    public int boardCateWrite(ZCateVo zCateVo) throws Exception {

        //getSqlMapClient().queryForObject(sqlMapNs + "boardCateWrite", zCateVo);
    	
    	ZCateVo vo = (ZCateVo)selectByPk(sqlMapNs+"boardCateWrite1", zCateVo);
		if(vo != null){
			zCateVo.setClevel(vo.getClevel());
			zCateVo.setCtopno(vo.getCtopno());
			zCateVo.setCstep(vo.getCstep());
		}
		
		if(zCateVo.getCtopno() > 0){
			ZCateVo vo2 = (ZCateVo)selectByPk(sqlMapNs+"boardCateWrite2", zCateVo);
			zCateVo.setCstep(vo2.getCstep());
			update(sqlMapNs + "boardCateWrite3", zCateVo);
		}
		zCateVo.setCstatus("1");
		int maxno = (Integer)insert(sqlMapNs + "boardCateWrite4", zCateVo);
		
		if(zCateVo.getCtopno() == 0){
			zCateVo.setMaxno(maxno);
			update(sqlMapNs + "boardCateWrite6", zCateVo);
		}

        return (Integer) zCateVo.getMaxno();
    }

    @Transactional
    public void boardCateUpdate(ZCateVo zCateVoForcate) throws Exception {

        update(sqlMapNs + "boardCateUpdate", zCateVoForcate);
    }

    @Transactional
    public void boardCateDelete(ZCateVo vo) throws Exception {

//        getSqlMapClient().queryForObject(sqlMapNs + "boardCateDelete", map);
        
        List<ZCateVo> cnoList = (List<ZCateVo>) list(sqlMapNs + "boardCateDelete1", vo);
		
		List<Integer> arrDeleteNo = new ArrayList<Integer>(cnoList.size());
    	for(int i = 0; i < cnoList.size(); i++) {
    		arrDeleteNo.add(cnoList.get(i).getCno());
    	}
    	
		delete(sqlMapNs + "boardCateDelete2", arrDeleteNo);
        
    }

    @Transactional
    public void boardCateClear(int boardno) throws Exception {

        delete(sqlMapNs + "boardCateClear", boardno);
    }

    @Transactional
    public void boardCateORder(Map<String, String> map) throws Exception {
    	
    	
    	String act = map.get("act");
		
		ZCateVo zcateVo = new ZCateVo();
		ZCateVo vo = new ZCateVo();
		zcateVo.setCno(Integer.parseInt(map.get("cno")));
//		zcateVo.setCtopno(0);
//		zcateVo.setClevel(0);
//		zcateVo.setCstep(0);
//		zcateVo.setCparentno(0);
		
		zcateVo = (ZCateVo)selectByPk(sqlMapNs+"adminCOrder1", zcateVo);
		
//		zcateVo.setCtopno(vo.getCtopno());
//		zcateVo.setClevel(vo.getClevel());
//		zcateVo.setCstep(vo.getCstep());
//		zcateVo.setCparentno(vo.getCparentno());
		
		System.out.println("zcateVo1111=====>"+zcateVo.getCno());
		System.out.println("zcateVo1111=====>"+zcateVo.getCtopno());
		
		
		if(zcateVo.getClevel() > 0){
			
			zcateVo.setCsteporg(zcateVo.getCstep());
			
			if(act.equals("d")){
				
				vo = (ZCateVo)selectByPk(sqlMapNs+"adminCOrder2", zcateVo);
				
				zcateVo.setCstepmax1(vo.getCstepmax1());
				
				System.out.println("zcateVo2222=====>"+zcateVo.getCno());
				System.out.println("zcateVo2222=====>"+zcateVo.getCtopno());
				
				if(zcateVo.getCstepmax1() > 0){
					
					vo = (ZCateVo)selectByPk(sqlMapNs+"adminCOrder3", zcateVo);
					zcateVo.setCstepmax2(vo.getCstepmax2());
					
					List<ZCateVo> authList2 = (List<ZCateVo>) list(sqlMapNs+"adminCOrder4", zcateVo);
					
					List<ZCateVo> authList = new ArrayList<ZCateVo>();
					if(zcateVo.getCstepmax2() > 0){
						authList = (List<ZCateVo>) list(sqlMapNs+"adminCOrder15", zcateVo);
					}else{
						authList = (List<ZCateVo>) list(sqlMapNs+"adminCOrder5", zcateVo);
					}
					
					for (int i = 0; i < authList.size(); i++) {
						
						if(zcateVo.getStep() == 0){
							zcateVo.setStep(zcateVo.getCsteporg());
						}else{
							zcateVo.setStep(zcateVo.getStep()+1);
						}
						
						zcateVo.setMno(authList.get(i).getCno());
						
						update(sqlMapNs+"adminCOrder6", zcateVo);
						
						
					}
					
					for (int i = 0; i < authList2.size(); i++) {
						zcateVo.setStep(zcateVo.getStep()+1);
						zcateVo.setMno(authList2.get(i).getCno());
						
						update(sqlMapNs+"adminCOrder6", zcateVo);
					}
					
				}
				
				
			}else if(act.equals("u")){
				
				vo = (ZCateVo)selectByPk(sqlMapNs+"adminCOrder7", zcateVo);
				
				zcateVo.setCstepmin1(vo.getCstepmin1());
				
				if(zcateVo.getCstepmin1() > 0){
					vo = (ZCateVo)selectByPk(sqlMapNs+"adminCOrder8", zcateVo);
					
					zcateVo.setCstepmin2(vo.getCstepmin2());
					
					List<ZCateVo> authList2 = (List<ZCateVo>) list(sqlMapNs+"adminCOrder9", zcateVo);
					
					List<ZCateVo> authList = new ArrayList<ZCateVo>();
					if(zcateVo.getCstepmin2() > 0){
						authList = (List<ZCateVo>) list(sqlMapNs+"adminCOrder16", zcateVo);
					}else{
						authList = (List<ZCateVo>) list(sqlMapNs+"adminCOrder10", zcateVo);
					}
					
					
					for (int i = 0; i < authList.size(); i++) {
						
						if(zcateVo.getStep() == 0){
							zcateVo.setStep(zcateVo.getCstepmin1());
						}else{
							zcateVo.setStep(zcateVo.getStep()+1);
						}
						
						zcateVo.setMno(authList.get(i).getCno());
						
						update(sqlMapNs+"adminCOrder6", zcateVo);
						
						
					}
					
					for (int i = 0; i < authList2.size(); i++) {
						zcateVo.setStep(zcateVo.getStep()+1);
						zcateVo.setMno(authList2.get(i).getCno());
						
						update(sqlMapNs+"adminCOrder6", zcateVo);
					}
					
				}
				
			}
			
			
			
		}else{
			
			zcateVo.setCnoorg(zcateVo.getCtopno());
			
			if(act.equals("d")){
				zcateVo.setType("MIN");
				zcateVo.setMark(">");
			}else{
				zcateVo.setType("MAX");
				zcateVo.setMark("<");
				
			}
			
			vo = (ZCateVo)selectByPk(sqlMapNs+"adminCOrder11", zcateVo);
			zcateVo.setCnonew(vo.getCnonew());
			
			if(zcateVo.getCnonew() > 0){
				
				update(sqlMapNs+"adminCOrder12", zcateVo);
				update(sqlMapNs+"adminCOrder13", zcateVo);
				update(sqlMapNs+"adminCOrder14", zcateVo);
				
			}
			
		}
		
    	
//        getSqlMapClient().queryForObject(sqlMapNs + "boardCateOrder", map);
    }
/*
	@Transactional
	public void boardCateUseyn(Map<String, String> map) throws Exception{
		update(sqlMapNs + "boardCateUseyn", map);
	}
*/
}
