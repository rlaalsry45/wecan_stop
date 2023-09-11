package com.z5.zcms.admsys.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.board.dao.ZBoardGroupDAO;
import com.z5.zcms.admsys.board.dao.ZCateDAO;
import com.z5.zcms.admsys.board.domain.ZCateVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;


@Service
public class CateServiceImpl implements CateService {

    @Autowired
    MessageSource messageSource;
    @Autowired
    private ZCateDAO zCateDAO;
    @Autowired
    private ZBoardGroupDAO zBoardGroupDAO;

    public DataTable boardCateList(DataTable dt) throws Exception {

        dt.put("cateList", zCateDAO.boardCateList(dt.getInt("boardno")));

        return dt;
    }

public DataTable boardCateSet(DataTable dt) throws Exception{

		ZCateVo zCateVo = (ZCateVo)dt.getObject("zCateVo");

		zCateVo.setUserid(((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());

		if (dt.get("act").equals("insert")||dt.get("act").equals("update")){

			String[] cnos = dt.getValues("hcno");
			if (null!=cnos){

				try {

					//List<ZCateVo> cateList = new ArrayList<ZCateVo>();
					for (int i=0; i<cnos.length; i++) {

						zCateVo = new ZCateVo();
						zCateVo.setBoardno(dt.getInt("boardno"));
						zCateVo.setCno(Integer.valueOf(cnos[i]));
						zCateVo.setCname(dt.getValues("cname")[i].trim());
						zCateVo.setCstatus(dt.get("cstatus"+i));
						zCateVo.setUserid(((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());
						//cateList.add(zCateVo);

						zCateDAO.boardCateUpdate(zCateVo);

					}
//					ZCateVo zCateVoForcate = new ZCateVo();
//					zCateVoForcate.setBoardno(zCateVo.getBoardno());
//					zCateVoForcate.setzCatevoList(cateList);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}



			if (dt.get("act").equals("insert")){
				zCateVo.setCno(dt.getInt("cno",0));
				zCateVo.setCname(null);
				zCateDAO.boardCateWrite(zCateVo);
			}
			if(dt.get("act").equals("update")) dt.put("flag", "1");
		}
		else if (dt.get("act").equals("delete")){
			String[] cnos = dt.getValues("cno");

			List<String> arrDeleteNo = new ArrayList<String>(cnos.length);
	    	for(int i = 0; i < cnos.length; i++) {
	    		arrDeleteNo.add(cnos[i]);
	    	}

			ZCateVo vo = new ZCateVo();
			vo.setCnos(arrDeleteNo);
			vo.setBoardno(dt.getInt("boardno"));

			zCateDAO.boardCateDelete(vo);
		}
		else if (dt.get("act").equals("clear")){

			zCateDAO.boardCateClear(dt.getInt("boardno"));
		}
		else if (dt.get("act").equals("u")||dt.get("act").equals("d")){

			Map<String, String> map = new HashMap<String, String>();
			map.put("cno", dt.get("cno"));
			map.put("boardno", dt.get("boardno"));
			map.put("act", dt.get("act"));

			zCateDAO.boardCateORder(map);
		}
/*		else if (dt.get("act").equals("y")||dt.get("act").equals("n")){

			Map<String, String> map = new HashMap<String, String>();
			map.put("cno", dt.get("cno"));
			map.put("boardno", dt.get("boardno"));
			map.put("userid", ((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserNo());
			map.put("cstatus", dt.get("act").equals("y") ? "1" : "0");

			zCateDAO.boardCateUseyn(map);
		}
*/

		return dt;
	}
}
