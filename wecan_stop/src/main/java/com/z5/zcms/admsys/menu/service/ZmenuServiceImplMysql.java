package com.z5.zcms.admsys.menu.service;

import com.z5.zcms.admsys.common.dao.CommonDAO;
import com.z5.zcms.admsys.common.domain.CommonUseVo;
import com.z5.zcms.admsys.common.service.CommonService;
import com.z5.zcms.admsys.css.dao.ZcssDAO;
import com.z5.zcms.admsys.css.dao.ZcssUseDAO;
import com.z5.zcms.admsys.css.domain.ZcssUseVo;
import com.z5.zcms.admsys.css.domain.ZcssVo;
import com.z5.zcms.admsys.js.dao.ZjsDAO;
import com.z5.zcms.admsys.js.dao.ZjsUseDAO;
import com.z5.zcms.admsys.js.domain.ZjsUseVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import com.z5.zcms.admsys.menu.dao.ZmenuDAO;
import com.z5.zcms.admsys.menu.dao.ZmenuHisDAO;
import com.z5.zcms.admsys.menu.domain.ZmenuHisVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.site.dao.ZsiteDAO;
import com.z5.zcms.admsys.site.dao.ZsitecfgDAO;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.site.domain.ZsitecfgVo;
import com.z5.zcms.admsys.tpl.dao.ZtplDAO;
import com.z5.zcms.admsys.tpl.dao.ZtplUseDAO;
import com.z5.zcms.admsys.tpl.domain.ZtplUseVo;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.StringUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*@Service*/
public class ZmenuServiceImplMysql extends AbstractServiceImpl implements ZmenuService {

    @Autowired
    private ZmenuDAO zmenuDAO;

    @Autowired
    private ZcssDAO zcssDAO;

    @Autowired
    private ZjsDAO zjsDAO;

    @Autowired
    private ZtplDAO ztplDAO;

    @Autowired
    private CommonDAO commonDAO;

    @Autowired
    private ZmenuHisDAO zmenuHisDAO;

    @Autowired
    private ZcssUseDAO zcssUseDAO;

    @Autowired
    private ZjsUseDAO zjsUseDAO;

    @Autowired
    private ZtplUseDAO ztplUseDAO;

    @Autowired
    private ZsiteDAO zsiteDAO;

    @Autowired
    private ZsitecfgDAO zsitecfgDAO;

    @Autowired
    private CommonService commonService;

    @Autowired
    private ZUserService zUserService;


    public ZmenuVo selectbySitenoAndMenuno(ZmenuVo vo) throws Exception {
        return zmenuDAO.selectbySitenoAndMenuno(vo);
    }

    @Transactional
    public String delete(int siteno, String[] tmp) {

        List<Integer> listArray = new ArrayList<Integer>();
        List<Integer> menunoDel = new ArrayList<Integer>();

        for (String idx : tmp) {
            listArray.add(Integer.parseInt(idx));    //부모번호삽입
            ZmenuVo tmpVo = new ZmenuVo();
            tmpVo.setMenuno(Integer.parseInt(idx));
            tmpVo.setSiteno(siteno);
            tmpVo = zmenuDAO.selectbySitenoAndMenuno(tmpVo);

            if (tmpVo == null) continue;

            int menutopno = tmpVo.getMenutopno();
            int menulevel = tmpVo.getMenulevel();
            int menustep  = tmpVo.getMenustep();

            if (menulevel == 0) { //최상위 메뉴일 경우
                ZmenuVo vo = new ZmenuVo();
                vo.setSiteno(siteno);
                vo.setMenutopno(menutopno);
                vo.setMenulevel(menulevel);
                menunoDel = zmenuDAO.getMenunoListBySitenoAndMenutopnoAndMenulevel(vo);
            }
            else {
                int menustepmax = 0;

                ZmenuVo vo = new ZmenuVo();
                vo.setSiteno(siteno);
                vo.setMenutopno(menutopno);
                vo.setMenulevel(menulevel);
                vo.setMenustep(menustep);

                Integer returnVal = zmenuDAO.getMaxmenuStepBySitenoAndMenutopnoAndMenulevelAndMenustep(vo);
                menustepmax = returnVal == null ? 0 : returnVal;

                if (menustepmax == 0) { // 아래 메뉴의 스탭이 없을 경우
                    ZmenuVo menuVo = new ZmenuVo();
                    menuVo.setSiteno(siteno);
                    menuVo.setMenutopno(menutopno);
                    menuVo.setMenulevel(menulevel);
                    menuVo.setMenustep(menustep);
                    menunoDel = zmenuDAO.getMenunoListBySitenoAndMenutopnoAndMenulevelAndMenustep(menuVo);
                }
                else {
                    ZmenuVo menuVo = new ZmenuVo();
                    menuVo.setSiteno(siteno);
                    menuVo.setMenutopno(menutopno);
                    menuVo.setMenulevel(menulevel);
                    menuVo.setMenustep(menustep);
                    menuVo.setMaxno(menustepmax);
                    menunoDel = zmenuDAO.getMenunoListBySitenoAndMenutopnoAndMenulevelAndMenustepAndMenustepMax(menuVo);
                }
            }

            for (int i = 0; i < menunoDel.size(); i++) {
                listArray.add(menunoDel.get(i));        //하위메뉴삽입
                listArray.add(Integer.parseInt(idx));    //부모번호삽입
            }

        }


        //listArray 중복제거
        List<Integer> arrDeleteNo = new ArrayList<Integer>(new HashSet<Integer>(listArray));

        String menuno = "";
        for (int i = 0; i < arrDeleteNo.size(); i++) {
            if (i > 0) menuno += ",";
            menuno += arrDeleteNo.get(i);
        }

        //Use 삭제시작
        for (String no : menuno.split(",")) {
            ZmenuVo zmenuVo = new ZmenuVo();
            zmenuVo.setSiteno(siteno);
            zmenuVo.setMenuno(Integer.parseInt(no));
            zmenuVo = zmenuDAO.selectbySitenoAndMenuno(zmenuVo);
            if (zmenuVo != null) {
                if (!(zmenuVo.getMenusubcss() == null || zmenuVo.getMenusubcss().equals(""))) {
                    for (String cssno : zmenuVo.getMenusubcss().split(",")) {
                        zmenuVo.setCond1("menusubcss");
                        zmenuVo.setCond2(cssno);
                        if (zmenuDAO.getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(zmenuVo) == 0) {
                            CommonUseVo vo = new CommonUseVo();
                            vo.setTable("zcssuse");
                            vo.setCond1("cssno");
                            vo.setTablenameno(Integer.parseInt(cssno));
                            vo.setSiteno(siteno);
                            commonDAO.deleteUse(vo);
                        }
                    }
                }

                //js
                if (!(zmenuVo.getMenusubjs() == null || zmenuVo.getMenusubjs().equals(""))) {
                    for (String jsno : zmenuVo.getMenusubjs().split(",")) {
                        zmenuVo.setCond1("menusubjs");
                        zmenuVo.setCond2(jsno);
                        if (zmenuDAO.getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(zmenuVo) == 0) {
                            CommonUseVo vo = new CommonUseVo();
                            vo.setTable("zjsuse");
                            vo.setCond1("jsno");
                            vo.setTablenameno(Integer.parseInt(jsno));
                            vo.setSiteno(siteno);
                            commonDAO.deleteUse(vo);
                        }
                    }
                }

                //ttpl
                if (!(zmenuVo.getMenuttpl() == null || zmenuVo.getMenuttpl().equals(""))) {
                    for (String tplno : zmenuVo.getMenuttpl().split(",")) {
                        zmenuVo.setCond1("menuttpl");
                        zmenuVo.setCond2(tplno);
                        if (zmenuDAO.getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(zmenuVo) == 0) {
                            CommonUseVo vo = new CommonUseVo();
                            vo.setTable("ztpluse");
                            vo.setCond1("tplno");
                            vo.setTablenameno(Integer.parseInt(tplno));
                            vo.setSiteno(siteno);
                            commonDAO.deleteUse(vo);
                        }
                    }
                }

                //ltpl
                if (!(zmenuVo.getMenultpl() == null || zmenuVo.getMenultpl().equals(""))) {
                    for (String tplno : zmenuVo.getMenultpl().split(",")) {
                        zmenuVo.setCond1("menultpl");
                        zmenuVo.setCond2(tplno);
                        if (zmenuDAO.getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(zmenuVo) == 0) {
                            CommonUseVo vo = new CommonUseVo();
                            vo.setTable("ztpluse");
                            vo.setCond1("tplno");
                            vo.setTablenameno(Integer.parseInt(tplno));
                            vo.setSiteno(siteno);
                            commonDAO.deleteUse(vo);
                        }
                    }
                }


                //rtpl
                if (!(zmenuVo.getMenurtpl() == null || zmenuVo.getMenurtpl().equals(""))) {
                    for (String tplno : zmenuVo.getMenurtpl().split(",")) {
                        zmenuVo.setCond1("menurtpl");
                        zmenuVo.setCond2(tplno);
                        if (zmenuDAO.getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(zmenuVo) == 0) {
                            CommonUseVo vo = new CommonUseVo();
                            vo.setTable("ztpluse");
                            vo.setCond1("tplno");
                            vo.setTablenameno(Integer.parseInt(tplno));
                            vo.setSiteno(siteno);
                            commonDAO.deleteUse(vo);
                        }
                    }
                }

                //btpl
                if (!(zmenuVo.getMenubtpl() == null || zmenuVo.getMenubtpl().equals(""))) {
                    for (String tplno : zmenuVo.getMenubtpl().split(",")) {
                        zmenuVo.setCond1("menubtpl");
                        zmenuVo.setCond2(tplno);
                        if (zmenuDAO.getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(zmenuVo) == 0) {
                            CommonUseVo vo = new CommonUseVo();
                            vo.setTable("ztpluse");
                            vo.setCond1("tplno");
                            vo.setTablenameno(Integer.parseInt(tplno));
                            vo.setSiteno(siteno);
                            commonDAO.deleteUse(vo);
                        }
                    }
                }

                //ztags
                if (!(zmenuVo.getMenutags() == null || zmenuVo.getMenutags().equals(""))) {
                    Document doc   = Jsoup.parseBodyFragment(zmenuVo.getMenutags());
                    Elements ztags = doc.select("call");
                    for (Element ztag : ztags) {
                        zmenuVo.setCond1("menutags");
                        zmenuVo.setCond2(ztag.toString());
                        if (zmenuDAO.getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(zmenuVo) == 0) {
                            CommonUseVo vo = new CommonUseVo();
                            vo.setTable("z" + ztag.attr("type").toLowerCase() + "use");
                            vo.setCond1(ztag.attr("type") + "no");
                            vo.setTablenameno(Integer.parseInt(ztag.attr("no")));
                            vo.setSiteno(siteno);
                            commonDAO.deleteUse(vo);
                        }
                    }
                }
            }
        }

        //zmenu 삭제
        ZmenuVo zmenuVoDel = new ZmenuVo();
        zmenuVoDel.setArrDeleteNo(arrDeleteNo);
        zmenuVoDel.setSiteno(siteno);
        zmenuDAO.deleteMenuWithSiteno(zmenuVoDel);

        //zmenuHis 삭제
        ZmenuHisVo zmenuHisVo = new ZmenuHisVo();
        zmenuHisVo.setArrDeleteNo(arrDeleteNo);
        zmenuHisVo.setSiteno(siteno);
        zmenuHisDAO.deleteMenuWithSiteno(zmenuHisVo);

        return "0000";
    }

    @Transactional
    public Model insert(DataTable input, Model model, HttpServletRequest request) {

        int siteno = input.getInt("siteno");
        int menuno = input.getInt("menuno");

        ZmenuVo zmenuVo = new ZmenuVo();
        zmenuVo.setMenuno(menuno);
        zmenuVo.setSiteno(siteno);
		/*ZmenuVo zmenuVoDt = zmenuDAO.selectbySitenoAndMenuno(zmenuVo);

		if(zmenuVoDt == null){
			zmenuVo = new ZmenuVo();
			zmenuVo.setMenulevel(0);
			zmenuVoDt = new ZmenuVo();
			zmenuVoDt.setMenutopno(-1);
			zmenuVoDt.setMenulevel(-1);
		}

		if(zmenuVoDt.getMenulevel() == 0){
			zmenuVo.setSiteno(siteno);
			zmenuVo.setMenutopno(zmenuVoDt.getMenutopno());
			Integer maxmenusteptmp = zmenuDAO.getMaxmenustepBySitenoAndMenutopno(zmenuVo);
			if(maxmenusteptmp != null ) menustep = maxmenusteptmp + 1;

		}else{
			zmenuVo.setSiteno(siteno);
			zmenuVo.setMenutopno(zmenuVoDt.getMenutopno());
			zmenuVo.setMenuparentno(zmenuVoDt.getMenuno());
			Integer maxmenusteptmp = zmenuDAO.getMaxmenustepBySitenoAndMenutopnoAndParentno(zmenuVo);

			if(maxmenusteptmp != null)
				menustep = maxmenusteptmp + 1;
			else
				menustep = zmenuVoDt.getMenustep() +1;


			zmenuVo.setSiteno(siteno);
			zmenuVo.setMenutopno(zmenuVoDt.getMenutopno());
			zmenuVo.setMenustep(menustep);
			zmenuDAO.updateMenuStep(zmenuVo);
		}*/

        //procedure를 사용하는 것으로 변경
        ZmenuVo zmenuVoDt = zmenuDAO.getMenuValue(zmenuVo);


        //String HTML = input.get("menucontstype").equals("1") ? input.get("menuconts") : input.get("tx_content");
        String HTML = input.get("menuconts");
        System.out.println("HTML : " + HTML);
        Document doc   = Jsoup.parseBodyFragment(HTML);
        Elements ztags = doc.select("call");

        menuno = zmenuVoDt.getMaxno();
        zmenuVo.setMenuno(menuno);
        zmenuVo.setMenutitle(input.get("menutitle"));
        zmenuVo.setMenustatus(input.get("menustatus"));
        zmenuVo.setMenutype(input.get("menutype"));
        zmenuVo.setMenusubno(input.getInt("menusubno"));
        zmenuVo.setMenulinktarget(input.get("menulinktarget"));
        zmenuVo.setMenulink(input.get("menulink"));
        zmenuVo.setMenulinkother(input.get("menulinkother"));
        zmenuVo.setMenuintenallinktarget(input.get("menuintenallinktarget"));
        zmenuVo.setMenuintenallink(input.get("menuintenallink"));
        zmenuVo.setMenuintenallinkother(input.get("menuintenallinkother"));
        zmenuVo.setMenutop(input.get("menutop"));
        zmenuVo.setMenubtm(input.get("menubtm"));
        zmenuVo.setMenucontstype("3");
        zmenuVo.setMenuconts(HTML);
        zmenuVo.setMenustaffid(input.get("menustaffid"));
        zmenuVo.setMenustaffsect(input.get("menustaffsect"));
        zmenuVo.setMenustaffname(input.get("menustaffname"));
        zmenuVo.setMenustaffemail(input.get("menustaffemail"));
        zmenuVo.setMenustafftel(input.get("menustafftel"));
        zmenuVo.setMenustafffax(input.get("menustafffax"));
        zmenuVo.setMenuhis(input.get("menuhis"));
        zmenuVo.setSiteno(siteno);
        zmenuVo.setUserid(input.get("userid"));
/*		zmenuVo.setMenutopno(zmenuVoDt.getMenutopno()== -1?menuno:zmenuVoDt.getMenutopno());
		zmenuVo.setMenulevel(zmenuVoDt.getMenulevel()== -1?0:zmenuVoDt.getMenulevel()+1);
 		zmenuVo.setMenustep(menustep);
 		zmenuVo.setMenuparentno(zmenuVoDt.getMenuno()); */
        zmenuVo.setMenutopno(zmenuVoDt.getMenutopno() == 0 ? menuno : zmenuVoDt.getMenutopno());
        zmenuVo.setMenulevel(zmenuVoDt.getMenulevel() == 0 ? 0 : zmenuVoDt.getMenulevel());
        zmenuVo.setMenustep(zmenuVoDt.getMenustep());
        zmenuVo.setMenuparentno(zmenuVoDt.getMenuparentno());
        zmenuVo.setMenusubcss(input.get("menusubcss"));
        zmenuVo.setMenusubjs(input.get("menusubjs"));
        zmenuVo.setMenuttpl(input.get("menuttpl"));
        zmenuVo.setMenultpl(input.get("menultpl"));
        zmenuVo.setMenurtpl(input.get("menurtpl"));
        zmenuVo.setMenubtpl(input.get("menubtpl"));
        zmenuVo.setMenutags(ztags.toString());
        zmenuDAO.insert(zmenuVo);

        //template jsp 생성
        //menu의 경우 상단에서 max menuo를 가지고 왔기 때문에 별도로 가져올 필요가 없다.
        //ZmainVo vo = this.zmainService.getMaxno(zmainVo);//tpltile과 tplposition으로 방금 입력한 tpl의 no를 가지고 온다.

        //jsp 파일의 이름은 siteno_menuno.jsp로 작성
        //내부링크의 경우 바디만을 직접링크하는 관계로 상하 div를 인위적으로 넣을 방법이 없는관계로
        //상단, 본문 하단을 합치던 것을 각각 분리하여 jsp파일로 다시 생성한다.
        String jspfn = menuno + "_" + siteno;
        //상단, 바디, 하단을 합친다.
        //String contents = zmenuVo.getMenutop()+zmenuVo.getMenuconts()+zmenuVo.getMenubtm();

        //본문상단 생성
        try {
            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "t", zmenuVo.getMenutop())) {
                System.out.println("menu top template making successed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //본문 생성
        try {
            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "c", zmenuVo.getMenuconts())) {
                System.out.println("menu cont template making successed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //본문하단 생성
        try {
            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "b", zmenuVo.getMenubtm())) {
                System.out.println("menu btm template making successed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //ztag insert
        for (Element ztag : ztags) {
            CommonUseVo commonUseVo = new CommonUseVo();
            commonUseVo.setTable("z" + ztag.attr("type").toLowerCase() + "use");
            commonUseVo.setCond1(ztag.attr("type") + "no");
            commonUseVo.setTablenameno(Integer.parseInt(ztag.attr("no")));
            commonUseVo.setSiteno(siteno);

            if (commonDAO.getCountUseTable(commonUseVo) == 0) {
                commonUseVo.setTable("z" + ztag.attr("type").toLowerCase() + "use");
                commonUseVo.setCond1(ztag.attr("type") + "no");
                commonUseVo.setTablenameno(Integer.parseInt(ztag.attr("no")));
                commonUseVo.setSiteno(siteno);
                commonUseVo.setUserid(input.get("userid"));
                commonUseVo.setMenuno(menuno);
                commonDAO.insert(commonUseVo);
            }
        }

        //cssuse insert
        String css = input.get("menusubcss");
        for (String val : css.split(",")) {
            if (!val.isEmpty()) {
                ZcssUseVo zcssUseVo = new ZcssUseVo();
                zcssUseVo.setCssno(Integer.parseInt(val));
                zcssUseVo.setSiteno(siteno);
                zcssUseVo.setUserid(input.get("userid"));
                if (zcssUseDAO.listCount(zcssUseVo) == 0) {
                    zcssUseDAO.insert(zcssUseVo);
                }
            }
        }

        //jsuse insert
        String js = input.get("menusubjs");
        for (String val : js.split(",")) {
            if (!val.isEmpty()) {
                ZjsUseVo zjsUseVo = new ZjsUseVo();
                zjsUseVo.setJsno(Integer.parseInt(val));
                zjsUseVo.setSiteno(siteno);
                zjsUseVo.setUserid(input.get("userid"));
                if (zjsUseDAO.listCount(zjsUseVo) == 0) {
                    zjsUseDAO.insert(zjsUseVo);
                }
            }
        }

        //tpluse insert
        String tpl = input.get("menuttpl").concat("," + input.get("menultpl")).concat("," + input.get("menurtpl")).concat("," + input.get("menubtpl"));
        for (String val : tpl.split(",")) {
            if (!val.isEmpty()) {
                ZtplUseVo ztplUseVo = new ZtplUseVo();
                ztplUseVo.setTplno(Integer.parseInt(val));
                ztplUseVo.setSiteno(siteno);
                ztplUseVo.setUserid(input.get("userid"));
                if (ztplUseDAO.listCount(ztplUseVo) == 0) {
                    ztplUseDAO.insert(ztplUseVo);
                }
            }
        }
        return model;
    }

    @Transactional
    public Model update(DataTable input, Model model, HttpServletRequest request) {
        int menuno = input.getInt("menuno");
        int siteno = input.getInt("siteno");

        //String HTML = input.get("menucontstype").equals("1") ? input.get("menuconts") : input.get("tx_content");
        String   HTML  = input.get("menuconts");
        Document doc   = Jsoup.parseBodyFragment(HTML);
        Elements ztags = doc.select("call");

        if (input.get("menuhis").equals("1")) {
            ZmenuHisVo zmenuHisVo = new ZmenuHisVo();
            zmenuHisVo.setSiteno(siteno);
            zmenuHisVo.setMenuno(menuno);
            zmenuHisDAO.insert(zmenuHisVo);
        }

        //zmenu update
        ZmenuVo zmenuVo = new ZmenuVo();
        zmenuVo.setSiteno(siteno);
        zmenuVo.setMenuno(menuno);
        zmenuVo.setMenutitle(input.get("menutitle"));
        zmenuVo.setMenustatus(input.get("menustatus"));
        zmenuVo.setMenutype(input.get("menutype"));
        zmenuVo.setMenusubno(input.getInt("menusubno"));
        zmenuVo.setMenulinktarget(input.get("menulinktarget"));
        zmenuVo.setMenulink(input.get("menulink"));
        zmenuVo.setMenulinkother(input.get("menulinkother"));
        zmenuVo.setMenulinktarget(input.get("menulinktarget"));
        zmenuVo.setMenulink(input.get("menulink"));
        zmenuVo.setMenulinkother(input.get("menulinkother"));
        zmenuVo.setMenuintenallinkother(input.get("menuintenallinkother"));
        zmenuVo.setMenuintenallinktarget(input.get("menuintenallinktarget"));
        zmenuVo.setMenuintenallink(input.get("menuintenallink"));
        zmenuVo.setMenutop(input.get("menutop"));
        zmenuVo.setMenubtm(input.get("menubtm"));
        zmenuVo.setMenucontstype("3");
        zmenuVo.setMenuconts(HTML);
        zmenuVo.setMenustaffid(input.get("menustaffid"));
        zmenuVo.setMenustaffsect(input.get("menustaffsect"));
        zmenuVo.setMenustaffname(input.get("menustaffname"));
        zmenuVo.setMenustaffemail(input.get("menustaffemail"));
        zmenuVo.setMenustafftel(input.get("menustafftel"));
        zmenuVo.setMenustafffax(input.get("menustafffax"));
        zmenuVo.setMenuhis(input.get("menuhis"));
        zmenuVo.setUserid(input.get("userid"));
        zmenuVo.setMenusubcss(input.get("menusubcss"));
        zmenuVo.setMenusubjs(input.get("menusubjs"));
        zmenuVo.setMenuttpl(input.get("menuttpl"));
        zmenuVo.setMenultpl(input.get("menultpl"));
        zmenuVo.setMenurtpl(input.get("menurtpl"));
        zmenuVo.setMenubtpl(input.get("menubtpl"));
        zmenuVo.setMenutags(ztags.toString());
        zmenuDAO.update(zmenuVo);

        //template jsp 생성
        //상단, 중단 , 하단을 분리하여 새성한다.
        String jspfn = menuno + "_" + siteno;
        //String contents = zmenuVo.getMenutop()+zmenuVo.getMenuconts()+zmenuVo.getMenubtm();

        //상단생성
        try {
            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "t", zmenuVo.getMenutop())) {
                System.out.println("menu top template making successed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //본문생성
        try {
            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "c", zmenuVo.getMenuconts())) {
                System.out.println("menu conts template making successed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //하단생성
        try {
            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "b", zmenuVo.getMenubtm())) {
                System.out.println("menu btm template making successed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ZmenuVo zmenuVoUpdate = new ZmenuVo();
        zmenuVoUpdate.setMenuno(menuno);
        zmenuVoUpdate.setSiteno(siteno);
        zmenuVoUpdate = zmenuDAO.selectbySitenoAndMenuno(zmenuVoUpdate);
        model.addAttribute("menutopno", zmenuVoUpdate.getMenutopno());
        model.addAttribute("menuno", zmenuVoUpdate.getMenuno());
        model.addAttribute("menustep", zmenuVoUpdate.getMenustep());
        model.addAttribute("menulevel", zmenuVoUpdate.getMenulevel());
        model.addAttribute("siteno", zmenuVoUpdate.getSiteno());

        List<Integer> menunos = new ArrayList<Integer>();
        if (input.get("apply1").equals("1")) {
            ZmenuVo zmenuVoApply1 = new ZmenuVo();
            zmenuVoApply1.setMenusubcss(input.get("menusubcss"));
            zmenuVoApply1.setMenusubjs(input.get("menusubjs"));
            zmenuVoApply1.setUserid(input.get("userid"));
            zmenuVoApply1.setMenuno(menuno);
            zmenuVoApply1.setSiteno(siteno);
            try {
                menunos = commonService.getListChildrenTree(menuno, siteno);
                zmenuVoApply1.setArrIntegerNo(menunos);
            } catch (Exception e) {
                e.printStackTrace();
                e.printStackTrace();
            }
            zmenuDAO.updateApply1(zmenuVoApply1);
        }

        if (input.get("apply2").equals("2")) {
            ZmenuVo zmenuVoApply2 = new ZmenuVo();
            zmenuVoApply2.setMenuttpl(input.get("menuttpl"));
            zmenuVoApply2.setMenultpl(input.get("menultpl"));
            zmenuVoApply2.setMenurtpl(input.get("menurtpl"));
            zmenuVoApply2.setMenubtpl(input.get("menubtpl"));
            zmenuVoApply2.setMenuno(menuno);
            zmenuVoApply2.setSiteno(siteno);
            try {
                menunos = commonService.getListChildrenTree(menuno, siteno);
                zmenuVoApply2.setArrIntegerNo(menunos);
            } catch (Exception e) {
                e.printStackTrace();
                e.printStackTrace();
            }
            zmenuDAO.updateApply2(zmenuVoApply2);
        }

        //ztag insert
        for (Element ztag : ztags) {
            CommonUseVo commonUseVo = new CommonUseVo();
            commonUseVo.setTable("z" + ztag.attr("type").toLowerCase() + "use");
            commonUseVo.setCond1(ztag.attr("type") + "no");
            commonUseVo.setTablenameno(Integer.parseInt(ztag.attr("no")));
            commonUseVo.setSiteno(siteno);

            if (commonDAO.getCountUseTable(commonUseVo) == 0) {
                commonUseVo.setTable("z" + ztag.attr("type").toLowerCase() + "use");
                commonUseVo.setCond1(ztag.attr("type") + "no");
                commonUseVo.setTablenameno(Integer.parseInt(ztag.attr("no")));
                commonUseVo.setSiteno(siteno);
                commonUseVo.setUserid(input.get("userid"));
                commonUseVo.setMenuno(menuno);
                commonDAO.insert(commonUseVo);
            }
        }

        //cssuse insert
        String css = input.get("menusubcss");
        for (String val : css.split(",")) {
            if (!val.isEmpty()) {
                ZcssUseVo zcssUseVo = new ZcssUseVo();
                zcssUseVo.setCssno(Integer.parseInt(val));
                zcssUseVo.setSiteno(siteno);
                zcssUseVo.setUserid(input.get("userid"));
                if (zcssUseDAO.listCount(zcssUseVo) == 0) {
                    zcssUseDAO.insert(zcssUseVo);
                }
            }
        }

        //jsuse insert
        String js = input.get("menusubjs");
        for (String val : js.split(",")) {
            if (!val.isEmpty()) {
                ZjsUseVo zjsUseVo = new ZjsUseVo();
                zjsUseVo.setJsno(Integer.parseInt(val));
                zjsUseVo.setSiteno(siteno);
                zjsUseVo.setUserid(input.get("userid"));
                if (zjsUseDAO.listCount(zjsUseVo) == 0) {
                    zjsUseDAO.insert(zjsUseVo);
                }
            }
        }

        //tpluse insert
        String tpl = input.get("menuttpl").concat("," + input.get("menultpl")).concat("," + input.get("menurtpl")).concat("," + input.get("menubtpl"));
        for (String val : tpl.split(",")) {
            if (!val.isEmpty()) {
                ZtplUseVo ztplUseVo = new ZtplUseVo();
                ztplUseVo.setTplno(Integer.parseInt(val));
                ztplUseVo.setSiteno(siteno);
                ztplUseVo.setUserid(input.get("userid"));
                if (ztplUseDAO.listCount(ztplUseVo) == 0) {
                    ztplUseDAO.insert(ztplUseVo);
                }
            }
        }
        return model;
    }

    public Model updateView(DataTable input, Model model) {
        int    menuno    = input.getInt("menuno");
        int    siteno    = input.getInt("siteno");
        int    menuhisno = input.getInt("menuhisno");
        String mode      = input.get("mode");
        String act       = input.get("act");
        int    menuno_r  = input.getInt("menuno_r");

        model.addAttribute("act", act);
        model.addAttribute("siteno", siteno);
        model.addAttribute("menuno", menuno);

        ZsiteVo zsiteVo = new ZsiteVo();

        //menulevel 가져옴
        ZmenuVo zmenuVo = new ZmenuVo();
        zmenuVo.setMenuno(menuno);
        zmenuVo.setSiteno(siteno);
        int menulevel = zmenuDAO.getMenulevel(zmenuVo);
        System.out.println("menulevel : " + menulevel);
        model.addAttribute("menulevel", menulevel);

        //sitetitle, sitedomain 가져옴
        zsiteVo.setSiteno(siteno);
        zsiteVo = zsiteDAO.selectbypk(zsiteVo);

        model.addAttribute("sitetitle", zsiteVo.getSitetitle());
        model.addAttribute("sitedomain", zsiteVo.getSitedomain());

        //zmenu데이타 가져옴
        List<ZmenuVo> list = null;
        zmenuVo.setSiteno(siteno);
        list = this.zmenuDAO.selectbysiteno(zmenuVo);
        model.addAttribute("list", list);


        if (menuno > 0) {
   			/*List<ZmenuVo> depth = null;
   			zmenuVo.setMenuno(menuno);
   			zmenuVo.setSiteno(siteno);
   			zmenuVo.setMenutopno(list.get(0).getMenutopno());
   			zmenuVo.setMenulevel(menulevel);
   			depth = this.zmenuDAO.getlistdepth(zmenuVo);
   			model.addAttribute("depth", depth);*/
            List<ZmenuVo> depth = new ArrayList<ZmenuVo>();
            try {
                depth = commonService.getListParentsTree(menuno, siteno);
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("depth", depth);
        }


        //menuHis
        ZmenuHisVo zmenuHisVoL = new ZmenuHisVo();
        zmenuHisVoL.setMenuno(menuno);
        zmenuHisVoL.setSiteno(siteno);
        List<ZmenuHisVo> hislist = zmenuHisDAO.getHisListbySitenoAndMenuno(zmenuHisVoL);
        model.addAttribute("hislist", hislist);

        ZcssVo       zcssVo  = new ZcssVo();
        List<ZcssVo> cssList = this.zcssDAO.getlistAll(zcssVo);
        model.addAttribute("cssList", cssList);

        ZjsVo       zjsVo  = new ZjsVo();
        List<ZjsVo> jsList = this.zjsDAO.getlistAll(zjsVo);
        model.addAttribute("jsList", jsList);

        ZtplVo       ztplVo = new ZtplVo();
        List<ZtplVo> tList  = this.ztplDAO.getlistAll(ztplVo);
        model.addAttribute("tList", tList);


        //zsitecfg 선택시작
        zmenuVo = new ZmenuVo();

        if (mode.equals("restore")) {
            ZmenuHisVo zmenuHisVo = new ZmenuHisVo();
            zmenuHisVo.setMenuhisno(menuhisno);
            zmenuVo = zmenuHisDAO.selectbypk(zmenuHisVo);
        }
        else {
            zmenuVo.setSiteno(siteno);
            if (act.equals("refer"))
                zmenuVo.setMenuno(menuno_r);
            else
                zmenuVo.setMenuno(menuno);
            zmenuVo = zmenuDAO.selectbySitenoAndMenuno(zmenuVo);
        }

        if (zmenuVo == null) {
            return model;
        }

        if (act.equals("refer")) {
            System.out.println("refer 탑니다.");
            zmenuVo.setMenuno_r(menuno_r);
            zmenuVo.setMenutitle(input.get("menutitle"));
            zmenuVo.setMenustatus(input.get("menustatus"));
        }
        model.addAttribute("detail", zmenuVo);

        //css등의 목록을 어디서 가지고 올지 판단한다.refer가 아니고 menuno가 0일경우 sitecfg의것을 사용한다.
        ZsitecfgVo sitecfg    = new ZsitecfgVo();
        ZmenuVo    menucfgtmp = new ZmenuVo();
        menucfgtmp = zmenuVo;
        sitecfg.setSitecfgsubcss(menucfgtmp.getMenusubcss());
        sitecfg.setSitecfgsubjs(menucfgtmp.getMenusubjs());
        sitecfg.setSitecfgtoptpl(menucfgtmp.getMenuttpl());
        sitecfg.setSitecfglefttpl(menucfgtmp.getMenultpl());
        sitecfg.setSitecfgrighttpl(menucfgtmp.getMenurtpl());
        sitecfg.setSitecfgbottomtpl(menucfgtmp.getMenubtpl());


        List<ZcssVo> subcss = new ArrayList<ZcssVo>();
        if (null != sitecfg.getSitecfgsubcss()) {
            Iterator<ZcssVo> itersubcss = cssList.iterator();
            while (itersubcss.hasNext()) {
                ZcssVo tmp = itersubcss.next();
                if (Arrays.asList(sitecfg.getSitecfgsubcss().split(",")).contains(String.valueOf(tmp.getCssno()))) {
                    subcss.add(tmp);
                }
            }
        }
        model.addAttribute("menusubcss", subcss);


        List<ZjsVo> subjs = new ArrayList<ZjsVo>();
        if (null != sitecfg.getSitecfgsubjs()) {
            Iterator<ZjsVo> itersubjs = jsList.iterator();
            while (itersubjs.hasNext()) {
                ZjsVo tmp = itersubjs.next();
                if (Arrays.asList(sitecfg.getSitecfgsubjs().split(",")).contains(String.valueOf(tmp.getJsno()))) {
                    subjs.add(tmp);
                }
            }
        }
        model.addAttribute("menusubjs", subjs);

        List<ZtplVo>     toptpl    = new ArrayList<ZtplVo>();
        List<ZtplVo>     lefttpl   = new ArrayList<ZtplVo>();
        List<ZtplVo>     righttpl  = new ArrayList<ZtplVo>();
        List<ZtplVo>     bottomtpl = new ArrayList<ZtplVo>();
        Iterator<ZtplVo> itertpl   = tList.iterator();
        while (itertpl.hasNext()) {
            ZtplVo tmp = itertpl.next();
            if (tmp.getTplposition().equals("1")) {
                if (null != sitecfg.getSitecfgtoptpl()) {
                    if (Arrays.asList(sitecfg.getSitecfgtoptpl().split(",")).contains(String.valueOf(tmp.getTplno()))) {
                        toptpl.add(tmp);
                    }
                }
            }
            if (tmp.getTplposition().equals("2")) {
                if (null != sitecfg.getSitecfglefttpl()) {
                    if (Arrays.asList(sitecfg.getSitecfglefttpl().split(",")).contains(String.valueOf(tmp.getTplno()))) {
                        lefttpl.add(tmp);
                    }
                }
            }
            if (tmp.getTplposition().equals("3")) {
                if (null != sitecfg.getSitecfgrighttpl()) {
                    if (Arrays.asList(sitecfg.getSitecfgrighttpl().split(",")).contains(String.valueOf(tmp.getTplno()))) {
                        righttpl.add(tmp);
                    }
                }
            }
            if (tmp.getTplposition().equals("4")) {
                if (null != sitecfg.getSitecfgbottomtpl()) {
                    System.out.println("sitecfg.getSitecfgbottomtpl() : " + sitecfg.getSitecfgbottomtpl());
                    System.out.println("tmp.getTplno() : " + tmp.getTplno());
                    if (Arrays.asList(sitecfg.getSitecfgbottomtpl().split(",")).contains(String.valueOf(tmp.getTplno()))) {
                        bottomtpl.add(tmp);
                    }
                }
            }
        }
        model.addAttribute("menuttpl", toptpl);
        model.addAttribute("menultpl", lefttpl);
        model.addAttribute("menurtpl", righttpl);
        model.addAttribute("menubtpl", bottomtpl);

        return model;
    }

    /**
     * 해당 menuno로 부터 부모TREE를 찾아서 돌려줍니다.
     * Oracle의 Start With 의 상단과 동일합니다.
     *
     * @param (int menuno,int siteno)
     * @return List<ZmenuVo>
     */
	/*public List<ZmenuVo> getListParentsTree(int menuno, int siteno){

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
	}*/
    public Model insertView(DataTable input, Model model) {

        String act      = input.get("act");
        int    siteno   = input.getInt("siteno");
        int    menuno   = input.getInt("menuno");
        int    menuno_r = input.getInt("menuno_r");

        model.addAttribute("siteno", siteno);
        model.addAttribute("menuno", menuno);
        model.addAttribute("act", act);


        ZmenuVo zmenuVo = new ZmenuVo();

        //menulevel 가져옴
        zmenuVo.setMenuno(menuno);
        zmenuVo.setSiteno(siteno);
        Integer menuleveltmp = zmenuDAO.getMenulevel(zmenuVo);
        int     menulevel    = menuleveltmp == null ? 0 : menuleveltmp;
        model.addAttribute("menulevel", menulevel);

        //sitetitle, sitedomain 가져옴
        ZsiteVo zsiteVo = new ZsiteVo();
        zsiteVo.setSiteno(siteno);
        zsiteVo = zsiteDAO.selectbypk(zsiteVo);
        model.addAttribute("sitetitle", zsiteVo.getSitetitle());
        model.addAttribute("sitedomain", zsiteVo.getSitedomain());

   		/*//list
   		zmenuVo.setSiteno(siteno);
   		ZmenuVo siteinfo = this.zmenuDAO.selectListFromZsiteBySiteno(zmenuVo);
   		model.addAttribute("list", siteinfo);*/

        //list
        List<ZmenuVo> list = null;
        zmenuVo.setSiteno(siteno);
        list = this.zmenuDAO.selectSublistFromZmenuBySiteno(zmenuVo);
        if (list != null) {
            model.addAttribute("list", list);
        }

        if (menuno > 0) {
   			/*List<ZmenuVo> depth = null;
   			zmenuVo.setMenuno(menuno);
   			zmenuVo.setSiteno(siteno);
   			zmenuVo.setMenutopno(list.get(0).getMenutopno());
   			zmenuVo.setMenulevel(menulevel);
   			depth = this.zmenuDAO.getlistdepth(zmenuVo);
   			model.addAttribute("depth", depth);*/
            List<ZmenuVo> depth = new ArrayList<ZmenuVo>();
            try {
                depth = commonService.getListParentsTree(menuno, siteno);
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("depth", depth);

        }

        ZcssVo       zcssVo  = new ZcssVo();
        List<ZcssVo> cssList = this.zcssDAO.getlistAll(zcssVo);
        model.addAttribute("cssList", cssList);

        ZjsVo       zjsVo  = new ZjsVo();
        List<ZjsVo> jsList = this.zjsDAO.getlistAll(zjsVo);
        model.addAttribute("jsList", jsList);

        ZtplVo       ztplVo = new ZtplVo();
        List<ZtplVo> tList  = this.ztplDAO.getlistAll(ztplVo);
        model.addAttribute("tList", tList);


        //zsitecfg 선택시작
        ZsitecfgVo zsitecfgVo = new ZsitecfgVo();
        ZmenuVo    zmenuVo2   = new ZmenuVo();
        zmenuVo = new ZmenuVo();

        if (act.equals("refer")) {
            zmenuVo.setMenuno(menuno_r);
            zmenuVo.setSiteno(siteno);
            zmenuVo = zmenuDAO.selectbySitenoAndMenuno(zmenuVo);

            zmenuVo.setMenuno(menuno_r);
            zmenuVo.setMenutitle(input.get("menutitle"));
            zmenuVo.setMenustatus(input.get("menustatus"));
            model.addAttribute("siteCfg", zmenuVo);


        }
        else {
            //refer가 아니고 menuno가 없을경우 sitecfg에서 데이타를 가지고 온다.
            if (menuno == 0) {
                zsitecfgVo = zsitecfgDAO.selectbysiteno(siteno);

                if (zsitecfgVo != null) {
                    zmenuVo = new ZmenuVo();
                    zmenuVo.setMenusubcss(zsitecfgVo.getSitecfgsubcss());
                    zmenuVo.setMenusubjs(zsitecfgVo.getSitecfgsubjs());
                    zmenuVo.setMenuttpl(zsitecfgVo.getSitecfgtoptpl());
                    zmenuVo.setMenultpl(zsitecfgVo.getSitecfglefttpl());
                    zmenuVo.setMenurtpl(zsitecfgVo.getSitecfgrighttpl());
                    zmenuVo.setMenubtpl(zsitecfgVo.getSitecfgbottomtpl());

                    zmenuVo.setMenutype("01");
                    model.addAttribute("siteCfg", zmenuVo);

                }
                else {
                    ZmenuVo sitecfgnull = new ZmenuVo();
                    sitecfgnull.setMenutype("01");
                    model.addAttribute("siteCfg", sitecfgnull);
                    return model;
                }
            }
            else {
                zmenuVo.setMenuno(menuno);
                zmenuVo.setSiteno(siteno);
                int menuparentno = zmenuDAO.getMenuparentno(zmenuVo);
                if (menuparentno > 0) {
                    zmenuVo.setMenuno(menuparentno);
                    zmenuVo.setSiteno(siteno);
                    zmenuVo2 = zmenuDAO.selectbySitenoAndMenuno(zmenuVo);
                }
                else {
                    zmenuVo.setMenuno(menuno);
                    zmenuVo.setSiteno(siteno);
                    zmenuVo2 = zmenuDAO.selectbySitenoAndMenuno(zmenuVo);
                }

                if (zmenuVo2 == null) {
                    ZmenuVo sitecfgnull = new ZmenuVo();
                    sitecfgnull.setMenutype("01");
                    model.addAttribute("siteCfg", sitecfgnull);
                    return model;
                }
                model.addAttribute("siteCfg", zmenuVo2);

            }
        }

        //css등의 목록을 어디서 가지고 올지 판단한다.refer가 아니고 menuno가 0일경우 sitecfg의것을 사용한다.
        ZsitecfgVo sitecfg    = new ZsitecfgVo();
        ZmenuVo    menucfgtmp = new ZmenuVo();
        if (!act.equals("refer") && menuno == 0) {
            sitecfg = zsitecfgVo;
        }
        else {

            if (act.equals("refer")) {
                menucfgtmp = zmenuVo;
            }
            else {
                menucfgtmp = zmenuVo2;
            }
            sitecfg.setSitecfgsubcss(menucfgtmp.getMenusubcss());
            sitecfg.setSitecfgsubjs(menucfgtmp.getMenusubjs());
            sitecfg.setSitecfgtoptpl(menucfgtmp.getMenuttpl());
            sitecfg.setSitecfglefttpl(menucfgtmp.getMenultpl());
            sitecfg.setSitecfgrighttpl(menucfgtmp.getMenurtpl());
            sitecfg.setSitecfgbottomtpl(menucfgtmp.getMenubtpl());
        }

        List<ZcssVo> maincss = new ArrayList<ZcssVo>();
        if (null != sitecfg.getSitecfgmaincss()) {
            Iterator<ZcssVo> itermaincss = cssList.iterator();
            while (itermaincss.hasNext()) {
                ZcssVo tmp = itermaincss.next();
                if (Arrays.asList(sitecfg.getSitecfgmaincss().split(",")).contains(String.valueOf(tmp.getCssno()))) {
                    maincss.add(tmp);
                }
            }
        }
        model.addAttribute("mainCss", maincss);

        List<ZcssVo> subcss = new ArrayList<ZcssVo>();
        if (null != sitecfg.getSitecfgsubcss()) {
            Iterator<ZcssVo> itersubcss = cssList.iterator();
            while (itersubcss.hasNext()) {
                ZcssVo tmp = itersubcss.next();
                if (Arrays.asList(sitecfg.getSitecfgsubcss().split(",")).contains(String.valueOf(tmp.getCssno()))) {
                    subcss.add(tmp);
                }
            }
        }
        model.addAttribute("subCss", subcss);

        List<ZjsVo> mainjs = new ArrayList<ZjsVo>();
        if (null != sitecfg.getSitecfgmainjs()) {
            Iterator<ZjsVo> itermainjs = jsList.iterator();
            while (itermainjs.hasNext()) {
                ZjsVo tmp = itermainjs.next();
                if (Arrays.asList(sitecfg.getSitecfgmainjs().split(",")).contains(String.valueOf(tmp.getJsno()))) {
                    mainjs.add(tmp);
                }
            }
        }
        model.addAttribute("mainJs", mainjs);

        List<ZjsVo> subjs = new ArrayList<ZjsVo>();
        if (null != sitecfg.getSitecfgsubjs()) {
            Iterator<ZjsVo> itersubjs = jsList.iterator();
            while (itersubjs.hasNext()) {
                ZjsVo tmp = itersubjs.next();
                if (Arrays.asList(sitecfg.getSitecfgsubjs().split(",")).contains(String.valueOf(tmp.getJsno()))) {
                    subjs.add(tmp);
                }
            }
        }
        model.addAttribute("subJs", subjs);

        List<ZtplVo>     toptpl    = new ArrayList<ZtplVo>();
        List<ZtplVo>     lefttpl   = new ArrayList<ZtplVo>();
        List<ZtplVo>     righttpl  = new ArrayList<ZtplVo>();
        List<ZtplVo>     bottomtpl = new ArrayList<ZtplVo>();
        Iterator<ZtplVo> itertpl   = tList.iterator();
        while (itertpl.hasNext()) {
            ZtplVo tmp = itertpl.next();
            if (tmp.getTplposition().equals("1")) {
                if (null != sitecfg.getSitecfgtoptpl()) {
                    if (Arrays.asList(sitecfg.getSitecfgtoptpl().split(",")).contains(String.valueOf(tmp.getTplno()))) {
                        toptpl.add(tmp);
                    }
                }
            }
            if (tmp.getTplposition().equals("2")) {
                if (null != sitecfg.getSitecfglefttpl()) {
                    if (Arrays.asList(sitecfg.getSitecfglefttpl().split(",")).contains(String.valueOf(tmp.getTplno()))) {
                        lefttpl.add(tmp);
                    }
                }
            }
            if (tmp.getTplposition().equals("3")) {
                if (null != sitecfg.getSitecfgrighttpl()) {
                    if (Arrays.asList(sitecfg.getSitecfgrighttpl().split(",")).contains(String.valueOf(tmp.getTplno()))) {
                        righttpl.add(tmp);
                    }
                }
            }
            if (tmp.getTplposition().equals("4")) {
                if (null != sitecfg.getSitecfgbottomtpl()) {
                    if (Arrays.asList(sitecfg.getSitecfgbottomtpl().split(",")).contains(String.valueOf(tmp.getTplno()))) {
                        bottomtpl.add(tmp);
                    }
                }
            }
        }
        model.addAttribute("topTpl", toptpl);
        model.addAttribute("leftTpl", lefttpl);
        model.addAttribute("rightTpl", righttpl);
        model.addAttribute("bottomTpl", bottomtpl);

        return model;
    }

    public Model index(ZsiteVo zsiteVo, DataTable input, Model model) {
        int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        String sdate      = input.get("sdate");
        String edate      = input.get("edate");
        String keyword    = input.get("keyword");
        String sitestatus = input.get("sitestatus");
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;

        if (sdate.equals("") && edate.equals("")) {
            zsiteVo.setCond1("");
        }
        else {
            zsiteVo.setCond1(input.get("cond1"));
        }
        if (keyword.equals("")) {
            zsiteVo.setCond2("");
        }
        else {
            zsiteVo.setCond2(input.get("cond2"));
        }
        if (sitestatus.equals("")) {
            zsiteVo.setSitestatus("");
        }
        else {
            zsiteVo.setSitestatus(input.get("sitestatus"));
        }

        zsiteVo.setSdate(input.get("sdate"));
        zsiteVo.setEdate(input.get("edate"));
        zsiteVo.setKeyword(input.get("keyword"));
        zsiteVo.setM(m);
        zsiteVo.setN(n);

        int total = this.zsiteDAO.listCount(zsiteVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        List<ZsiteVo> list = this.zsiteDAO.getlist(zsiteVo);

        model.addAttribute("list", list);
        model.addAttribute("input", input);

        return model;
    }

    public Model orderChange(DataTable input, Model model) {
        //미완성 완성시킬것
        int siteno = input.getInt("siteno");
        int menuno = input.getInt("menuno");
        if (input.get("act").equals("down")) {

        }
        else {

        }

        ZmenuVo zmenuorderVo = new ZmenuVo();
        zmenuorderVo.setSiteno(siteno);
        zmenuorderVo.setMenuno(menuno);
        zmenuorderVo = zmenuDAO.selectbySitenoAndMenuno(zmenuorderVo);

        if (zmenuorderVo.getMenulevel() == 0) {

        }

        model.addAttribute("siteno", siteno);
        return model;
    }

    public Model listView(DataTable input, Model model) {

        int siteno = input.getInt("siteno");

        ZsiteVo zsiteVo = new ZsiteVo();
        ZmenuVo zmenuVo = new ZmenuVo();

        if (siteno > 0) {
            zsiteVo.setSiteno(siteno);
            zsiteVo = zsiteDAO.selectbypk(zsiteVo);
        }

        model.addAttribute("input", input);
        model.addAttribute("siteno", siteno);
        model.addAttribute("sitetitle", zsiteVo.getSitetitle());
        model.addAttribute("sitedomain", zsiteVo.getSitedomain());

        zmenuVo.setSiteno(siteno);
        List<ZmenuVo> list = this.zmenuDAO.getlist(zmenuVo);


        for (int i = 0; i < list.size(); i++) {
            list.get(i).setMenutags(StringUtil.replaceNull(list.get(i).getMenutags()));
            Document doc   = Jsoup.parseBodyFragment(list.get(i).getMenutags());
            Elements ztags = doc.select("call");
            list.get(i).setMenutags("");
            for (Element ztag : ztags) {
                if (list.get(i).getMenutags().contains(ztag.attr("type"))) {
                    Pattern p = Pattern.compile("\\d+");
                    Matcher m = p.matcher(list.get(i).getMenutags());
                    while (m.find()) {
                        String cntStr = m.group(0);
                        int    cnt    = Integer.parseInt(cntStr);
                        cnt++;
                        String cntPlus = String.valueOf(cnt);
                        list.get(i).setMenutags(list.get(i).getMenutags().replace(cntStr, cntPlus));
                    }
                }
                else {
                    list.get(i).setMenutags(list.get(i).getMenutags() + "," + ztag.attr("type") + "(1)");
                }
            }
        }
        model.addAttribute("list", list);

        return model;
    }


    @Override
    public Model menuPopup(int siteno, Model model) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String getTitlePath(int menuno) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String preview(DataTable input, Model model,
                          HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void orderChange(DataTable input, ZmenuVo zmenuVo) {
        // TODO Auto-generated method stub

    }

}
