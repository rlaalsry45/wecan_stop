package com.z5.zcms.admsys.common.service;

import com.z5.zcms.admsys.common.dao.CommonDAO;
import com.z5.zcms.admsys.common.domain.CommonUseVo;
import com.z5.zcms.admsys.common.domain.EditHistoryVo;
import com.z5.zcms.admsys.common.domain.PostVo;
import com.z5.zcms.admsys.menu.dao.ZmenuDAO;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CommonServiceImpl extends AbstractServiceImpl implements CommonService {

    @Autowired
    private CommonDAO commonDAO;
    
    @Autowired
    private ZmenuDAO zmenuDAO;
    
	public Integer getCountUseTable(CommonUseVo vo) {
		return this.commonDAO.getCountUseTable(vo);
	}
	
	public void insert(CommonUseVo vo) throws Exception {
    	//log.debug(vo.toString());
    	commonDAO.insert(vo);
    }
	
	public void batchInsert(List<CommonUseVo> dataList) throws Exception{
		commonDAO.batchInsert(dataList);
	}
	
	public void batchUpdate(List<CommonUseVo> dataList) throws Exception{
		commonDAO.batchUpdate(dataList);
	}

	public void deleteUse(CommonUseVo vo) throws Exception {
		commonDAO.deleteUse(vo);
	}
	
	public List<ZmenuVo> getListParentsTree(int menuno, int siteno) throws Exception{
		
			
		List<ZmenuVo> returnlist = new ArrayList<ZmenuVo>();
		ZmenuVo vo = new ZmenuVo();
		vo.setSiteno(siteno);
		vo.setMenuno(menuno);
		ZmenuVo basisVo = zmenuDAO.selectbySitenoAndMenuno(vo);
		List<ZmenuVo> list = zmenuDAO.selectSublistFromZmenuBySiteno(vo);
		
		returnlist.add(basisVo);//처음에 집어넣고
		int tmpparentsno = basisVo.getMenuparentno();
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.size();j++){
				if(list.get(j).getMenuno() == tmpparentsno){
					returnlist.add(list.get(j));
					tmpparentsno = list.get(j).getMenuparentno(); 
				}
			}
		}
		
		//순서를 역으로 돌려서 돌려준다
		Collections.reverse(returnlist);
		
		return returnlist;
		
	}

    public List<Integer> getListChildrenTree(int menuno, int siteno) throws Exception {
		
		List<Integer> returnlist = new ArrayList<Integer>();
		ZmenuVo vo = new ZmenuVo();
		vo.setMenuno(menuno);
		vo.setSiteno(siteno);
		returnlist = commonDAO.getListChildrenTree(vo);

		return returnlist;
	}
	
    public List<String> getUseTbl() throws Exception {
		return commonDAO.getUseTbl();
	}
	
	public List<PostVo> getListPost(PostVo vo) throws Exception {
		return commonDAO.getListPost(vo);
	}

	@Override
	public void registrationEditHistory(EditHistoryVo ehVo) throws Exception {
		commonDAO.registrationEditHistory(ehVo);
	}

	@Override
	public List<EditHistoryVo> retrieveEditHistory(EditHistoryVo ehVo) throws Exception {
		return commonDAO.retrieveEditHistory(ehVo);
	}
	
}
