package com.z5.zcms.admsys.module.service;

import com.z5.zcms.admsys.cyberCounsel.domain.WChatOldVo;
import com.z5.zcms.admsys.module.dao.SatisfactionDAO;
import com.z5.zcms.admsys.module.dao.SatisfactionHisDAO;
import com.z5.zcms.admsys.module.dao.SatisfactionResultDAO;
import com.z5.zcms.admsys.module.dao.ZSatisfactionDAO;
import com.z5.zcms.admsys.module.dao.ZSatisfactionHisDAO;
import com.z5.zcms.admsys.module.dao.ZSatisfactionResultDAO;
import com.z5.zcms.admsys.module.domain.SatisfactionHisVo;
import com.z5.zcms.admsys.module.domain.SatisfactionResultVo;
import com.z5.zcms.admsys.module.domain.SatisfactionVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionHisVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionResultVo;
import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;
import com.z5.zcms.util.ZPrint;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

import javax.servlet.http.HttpSession;

import static com.z5.zcms.util.ZPrint.enter;
import static com.z5.zcms.util.ZPrint.print;

@Service
public class SatisfactionServiceImpl extends AbstractServiceImpl implements SatisfactionService {
  
    @Autowired
    private ZSatisfactionDAO zSatisfactionDAO;

    @Autowired
    private ZSatisfactionHisDAO zSatisfactionHisDAO;

    @Autowired
    private ZSatisfactionResultDAO zSatisfactionResultDAO;
    
    @Autowired
    private SatisfactionDAO satisfactionDAO;
    
    @Autowired
    private SatisfactionHisDAO satisfactionHisDAO;

    @Autowired
    private SatisfactionResultDAO satisfactionResultDAO;

    @Transactional
    public void satisfactionWrite(ZSatisfactionVo zSatisfactionVo) {
        this.zSatisfactionDAO.satisfactionWrite(zSatisfactionVo);
    }

    public List<ZSatisfactionVo> getSatisfactionList(ZSatisfactionVo zSatisfactionVo) {
        return this.zSatisfactionDAO.list(zSatisfactionVo);
    }

    public int listCount(ZSatisfactionVo zSatisfactionVo) {
        return this.zSatisfactionDAO.listCount(zSatisfactionVo);
    }

    public List<ZSatisfactionHisVo> getSatisfactionHisList(ZSatisfactionVo zSatisfactionVo) {
        return this.zSatisfactionHisDAO.list(zSatisfactionVo);
    }

    @Transactional
    public void satisfactionHisDelete(ZSatisfactionHisVo zSatisfactionHisVo) {
        this.zSatisfactionHisDAO.delete(zSatisfactionHisVo);
    }

    public Object satisfactionDetail(Object obj) {

        if (obj instanceof ZSatisfactionHisVo) {
            // 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
            return this.zSatisfactionHisDAO.detail((ZSatisfactionHisVo) obj);
        } else {
            return this.zSatisfactionDAO.detail((ZSatisfactionVo) obj);
        }
    }

    @Transactional
    public void satisfactionDelete(List<Integer> arrDeleteNo) {
        // zSatisfaction table 삭제
        this.zSatisfactionDAO.satisfactionDelete(arrDeleteNo);
        // zSatisfactionuse table 삭제
        this.zSatisfactionDAO.satisfactionUseDelete(arrDeleteNo);
        this.zSatisfactionHisDAO.satisfactionHisDelete(arrDeleteNo);
        this.zSatisfactionResultDAO.satisfactionResultDelete(arrDeleteNo);
    }

    @Transactional
    public void satisfactionEdit(ZSatisfactionVo zSatisfactionVo) {
        if ("1".equals(zSatisfactionVo.getHis())) {
            // 새로운 히스토리 입력
            this.zSatisfactionHisDAO.insert(zSatisfactionVo);
        }
        // 수정내용 갱신
        this.zSatisfactionDAO.update(zSatisfactionVo);
    }

    public Integer listCount(ZSatisfactionResultVo zSatisfactionResultVo) {
        return this.zSatisfactionResultDAO.listCount(zSatisfactionResultVo);
    }

    public List<ZSatisfactionResultVo> listSubject(ZSatisfactionResultVo zSatisfactionResultVo) {
        return this.zSatisfactionResultDAO.listSubject(zSatisfactionResultVo);
    }

    @Transactional
    public Model satisfactionResultWrite(Model model, DataTable input) {
        int             Satisfactionno = input.getInt("Satisfactionno");
        int             len      = input.getInt("question");
        ZSatisfactionResultVo vo       = new ZSatisfactionResultVo();
        ZPrint.enter();
        ZPrint.print("Satisfaction:" + Satisfactionno + " questions:" + len);
        try {
            for (int i = 1; i <= len; i++) {
                if (null == input.getValues("answer" + i)) {
                    input.put("answer" + i, "");
                }
                for (String answer : input.getValues("answer" + i)) {

                    if (answer != null && !answer.equals("")) {
                        vo.setSatisfactionno(Satisfactionno);
                        vo.setAskno(i);
                        vo.setAnswer(answer);
                        zSatisfactionResultDAO.satisfactionResultWrite(vo);
                    }
                }
            }


            zSatisfactionResultDAO.satisfactionResultTotalUpdate(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public ZSatisfactionVo latestSatisfaction(ZSatisfactionVo zSatisfactionVo) {
        return this.zSatisfactionDAO.latestSatisfaction(zSatisfactionVo);
    }

    @Transactional
    public void satisfactionResultChangeDelete(ZSatisfactionResultVo zSatisfactionResultVo) {
        this.zSatisfactionResultDAO.satisfactionResultChangeDelete(zSatisfactionResultVo);
    }

    @Transactional
    public void satisfactionResultUpdate(ZSatisfactionResultVo zSatisfactionResultVo) {
        this.zSatisfactionResultDAO.satisfactionResultUpdate(zSatisfactionResultVo);
    }

	@Override
	public String getSatisfactionIdSeq() {
		return this.zSatisfactionDAO.getSatisfactionIdSeq();
	}
	
	@Transactional
    public void cSatisfactionWrite(SatisfactionVo satisfactionVo) {
        this.satisfactionDAO.satisfactionWrite(satisfactionVo);
    }

    public List<SatisfactionVo> getCSatisfactionList(SatisfactionVo satisfactionVo) {
        return this.satisfactionDAO.list(satisfactionVo);
    }

    public int listCount(SatisfactionVo satisfactionVo) {
        return this.satisfactionDAO.listCount(satisfactionVo);
    }

    public List<SatisfactionHisVo> getCSatisfactionHisList(SatisfactionVo satisfactionVo) {
        return this.satisfactionHisDAO.list(satisfactionVo);
    }

    @Transactional
    public void cSatisfactionHisDelete(SatisfactionHisVo satisfactionHisVo) {
        this.satisfactionHisDAO.delete(satisfactionHisVo);
    }

    public Object cSatisfactionDetail(Object obj) {

        if (obj instanceof ZSatisfactionHisVo) {
            // 히스토리 내용을 확인 또는 복원하기 위해서 해당 히스토리 테이블에서 데이터를 추출
            return this.satisfactionHisDAO.detail((SatisfactionHisVo) obj);
        } else {
            return this.satisfactionDAO.detail((SatisfactionVo) obj);
        }
    }

    @Transactional
    public void cSatisfactionDelete(List<Integer> arrDeleteNo) {
        // Satisfaction table 삭제
        this.satisfactionDAO.satisfactionDelete(arrDeleteNo);
        // Satisfactionuse table 삭제
        this.satisfactionDAO.satisfactionUseDelete(arrDeleteNo);
        this.satisfactionHisDAO.satisfactionHisDelete(arrDeleteNo);
        this.satisfactionResultDAO.satisfactionResultDelete(arrDeleteNo);
    }

    @Transactional
    public void cSatisfactionEdit(SatisfactionVo satisfactionVo) {
        if ("1".equals(satisfactionVo.getHis())) {
            // 새로운 히스토리 입력
            this.satisfactionHisDAO.insert(satisfactionVo);
        }
        // 수정내용 갱신
        this.satisfactionDAO.update(satisfactionVo);
    }

    public Integer listCount(SatisfactionResultVo satisfactionResultVo) {
        return this.satisfactionResultDAO.listCount(satisfactionResultVo);
    }

    public List<SatisfactionResultVo> listSubject(SatisfactionResultVo satisfactionResultVo) {
        return this.satisfactionResultDAO.listSubject(satisfactionResultVo);
    }

    @Transactional
    public Model cSatisfactionResultWrite(Model model, DataTable input) {
        int satisfactionno = input.getInt("satisfactionno");
        int len = input.getInt("question");
        
        HttpSession session = input.getRequest().getSession();
        int counselClassificationnum = (int)session.getAttribute("counselClassificationnum");
        
        SatisfactionResultVo vo       = new SatisfactionResultVo();
        ZPrint.enter();
        ZPrint.print("Satisfaction:" + satisfactionno + " questions:" + len);
        try {
            for (int i = 1; i <= len; i++) {
	        	vo.setCounselclassification(input.get("classification"));
	        	vo.setCounselclassificationnum(counselClassificationnum);
	            vo.setSatisfactionno(satisfactionno);
	            vo.setAskno(input.getInt("askno"+i));
	            vo.setAnswer(input.get("answer"+i));
	            satisfactionResultDAO.satisfactionResultWrite(vo);
            }
            //satisfactionResultDAO.satisfactionResultTotalUpdate(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public SatisfactionVo latestCSatisfaction(SatisfactionVo SatisfactionVo) {
        return this.satisfactionDAO.latestSatisfaction(SatisfactionVo);
    }

    @Transactional
    public void cSatisfactionResultChangeDelete(SatisfactionResultVo satisfactionResultVo) {
        this.satisfactionResultDAO.satisfactionResultChangeDelete(satisfactionResultVo);
    }

    @Transactional
    public void cSatisfactionResultUpdate(SatisfactionResultVo satisfactionResultVo) {
        this.satisfactionResultDAO.satisfactionResultUpdate(satisfactionResultVo);
    }
    
    @Override
	public ZSatisfactionVo getSatisfactionIdList(ZSatisfactionVo zSatisfactionVo) {
		return this.zSatisfactionDAO.getSatisfactionIdList(zSatisfactionVo);
	}

	@Override
	public Integer getResultCnt(SatisfactionResultVo satisfactionResultVo) {
		return this.satisfactionResultDAO.getResultCnt(satisfactionResultVo);
	}

	@Override
	public List<SatisfactionResultVo> getAnswerList(SatisfactionResultVo satisfactionResultVo) {
		return this.satisfactionResultDAO.getAnswerList(satisfactionResultVo);
	}

	@Override
	public SatisfactionResultVo getAsknoCnt(SatisfactionResultVo satisfactionResultVo) {
		return this.satisfactionResultDAO.getAsknoCnt(satisfactionResultVo);
	}

	@Override
	public Model index_satisfaction(SatisfactionResultVo satisfactionResultVo, DataTable input, Model model) throws Exception {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;

        satisfactionResultVo.setM(m);
        satisfactionResultVo.setN(n);
        
        if (!StringUtil.isEmpty(input.get("sdate"))
        		&& !StringUtil.isEmpty(input.get("edate"))) {
        	satisfactionResultVo.setSdate(input.get("sdate").replaceAll("-", ""));
        	satisfactionResultVo.setEdate(input.get("edate").replaceAll("-", ""));
        }
        
        int total = this.satisfactionResultDAO.listCount2(satisfactionResultVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        List<SatisfactionResultVo> list = this.satisfactionResultDAO.getList2(satisfactionResultVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}
		
	@Override
	public List<SatisfactionResultVo> satisfaction_excel(SatisfactionResultVo satisfactionResultVo) {
		satisfactionResultVo.setM(0);
		satisfactionResultVo.setN(99999999);
		
		return this.satisfactionResultDAO.getList2(satisfactionResultVo);
	}

}
