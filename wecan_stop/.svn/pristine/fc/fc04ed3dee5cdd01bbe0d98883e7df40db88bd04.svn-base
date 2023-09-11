package com.z5.zcms.admsys.menu.service;

import com.z5.zcms.admsys.common.dao.CommonDAO;
import com.z5.zcms.admsys.common.domain.CommonUseVo;
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
import com.z5.zcms.admsys.module.dao.ZLayerPopupDAO;
import com.z5.zcms.admsys.module.dao.ZPopupDAO;
import com.z5.zcms.admsys.module.domain.ZLayerPopupVo;
import com.z5.zcms.admsys.module.domain.ZPopupVo;
import com.z5.zcms.admsys.site.dao.ZsiteDAO;
import com.z5.zcms.admsys.site.dao.ZsitecfgDAO;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.site.domain.ZsitecfgVo;
import com.z5.zcms.admsys.tpl.dao.ZtplDAO;
import com.z5.zcms.admsys.tpl.dao.ZtplUseDAO;
import com.z5.zcms.admsys.tpl.domain.ZtplUseVo;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.frontsys.archv.dao.ArchvDAO;
import com.z5.zcms.frontsys.archv.domain.ArchvRltd;
import com.z5.zcms.frontsys.archv.domain.ArchvRltdVO;
import com.z5.zcms.frontsys.archv.service.ArchvFrontService;
import com.z5.zcms.frontsys.front.dao.FrontDAO;
import com.z5.zcms.util.*;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Oracle DB를 적용할 경우 아래의 @Service를 풀고 ZmenuServiceImplMysql의 @Service를 주석처리할것
@Service
public class ZmenuServiceImplOracle extends AbstractServiceImpl implements ZmenuService {

    @Autowired
    ArchvDAO archvDAO;
    @Autowired
    ArchvFrontService archvFrontService;
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
    private FrontDAO zserviceDAO;
    @Autowired
    private ZPopupDAO zpopupDAO;
    @Autowired
    private ZLayerPopupDAO zlayerpopupDAO;


   /* public void insert(ZmenuVo vo) throws Exception {
        log.debug(vo.toString());
    	zmenuDAO.insert(vo);
    }

    public void update(ZmenuVo vo) throws Exception {
    	zmenuDAO.update(vo);
    }
    public void updateMenuStep(ZmenuVo vo) throws Exception {
    	zmenuDAO.updateMenuStep(vo);
    }

    public void updateApply1(ZmenuVo vo) throws Exception {
    	zmenuDAO.updateApply1(vo);
    }

    public void updateApply2(ZmenuVo vo) throws Exception {
    	zmenuDAO.updateApply2(vo);
    }

    public void delete(List<Integer> arrDeleteNo) throws Exception {
    	zmenuDAO.delete(arrDeleteNo);
    }

	public void deleteMenuWithSiteno(ZmenuVo vo) {
		zmenuDAO.deleteMenuWithSiteno(vo);
	}

    public ZmenuVo selectbypk(ZmenuVo vo) throws Exception {
    	ZmenuVo resultVO = zmenuDAO.selectbypk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }



    public ZmenuVo selectbySitenoAndMenuno(ZmenuVo vo) throws Exception {
    	ZmenuVo resultVO = zmenuDAO.selectbySitenoAndMenuno(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    public Integer getMenulevel(ZmenuVo vo) throws Exception {
    	Integer resultInt = this.zmenuDAO.getMenulevel(vo);
    	if(resultInt == null){
    		return -1;
    	}else{
    		return resultInt;
    	}
    }

	public Integer listCount(ZmenuVo vo) {
		return this.zmenuDAO.listCount(vo);
	}

	public Integer getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(ZmenuVo vo) {
		return this.zmenuDAO.getCountIsUsingOtherMenuByMenuno_siteno_cond1_cond2(vo);
	}

	public Integer getMenuparentno(ZmenuVo vo) {
		if(this.zmenuDAO.getMenulevel(vo)==null){
    		return -1;
    	}else{
    		return this.zmenuDAO.getMenuparentno(vo);
    	}

	}

	public Integer getMaxmenunoBySiteno(int siteno) {
		return this.zmenuDAO.getMaxmenunoBySiteno(siteno);
	}

    public List<ZmenuVo> selectbysiteno(ZmenuVo vo) {
    	return this.zmenuDAO.selectbysiteno(vo);
    }

	public List<ZmenuVo> getList(ZmenuVo vo) {
		return this.zmenuDAO.getlist(vo);
	}
	public List<ZmenuVo> getListdepth(ZmenuVo vo) {
		return this.zmenuDAO.getlistdepth(vo);
	}

	public List<ZmenuVo> getListAll(ZmenuVo vo) {
		return this.zmenuDAO.getlistAll(vo);
	}*/

    public ZmenuVo selectbySitenoAndMenuno(ZmenuVo vo) throws Exception {
        ZmenuVo resultVO = zmenuDAO.selectbySitenoAndMenuno(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    @Transactional
    public String delete(int siteno, String[] tmp) {

        List<Integer> listArray = new ArrayList<Integer>();
        for (String idx : tmp) {
        	listArray.add(Integer.parseInt(idx));    //부모번호삽입
            ZmenuVo tmpVo = new ZmenuVo();
            tmpVo.setMenuno(Integer.parseInt(idx));
            tmpVo.setSiteno(siteno);
            List<Integer> menunoDel = zmenuDAO.getMenunoList(tmpVo);
            for (int i = 0; i < menunoDel.size(); i++) {
                listArray.add(menunoDel.get(i));        //하위메뉴삽입
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
                    Document doc = Jsoup.parseBodyFragment(zmenuVo.getMenutags());
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

        //archv_rltd 삭제
        ArchvRltdVO rltdVO = new ArchvRltdVO();
        rltdVO.setSiteno(siteno);
        for (int i = 0; arrDeleteNo.size() > i; i++) {
            rltdVO.setMenuno(arrDeleteNo.get(i));
            archvDAO.delRltdListInMenu(rltdVO);
        }


        return "0000";
    }

    @Transactional
    public Model insert(DataTable input, Model model, HttpServletRequest request) {

        int siteno = input.getInt("siteno");
        int menuno = input.getInt("menuno");
        int menustep = 0;
        String userid = SecuritySessionUtil.getUserid(request);

        ZmenuVo zmenuVo = new ZmenuVo();
        zmenuVo.setMenuno(menuno);
        zmenuVo.setSiteno(siteno);

        ZmenuVo zmenuVoDt = zmenuDAO.selectbySitenoAndMenuno(zmenuVo);

        if (zmenuVoDt == null) {
            zmenuVo = new ZmenuVo();
            zmenuVo.setMenulevel(0);
            zmenuVoDt = new ZmenuVo();
            zmenuVoDt.setMenutopno(-1);
            zmenuVoDt.setMenulevel(-1);
        }

        if (zmenuVoDt.getMenulevel() == 0) {
            zmenuVo.setSiteno(siteno);
            zmenuVo.setMenutopno(zmenuVoDt.getMenutopno());
            Integer maxmenusteptmp = zmenuDAO.getMaxmenustepBySitenoAndMenutopno(zmenuVo);
            if (maxmenusteptmp != null) menustep = maxmenusteptmp + 1;

        } else {
            zmenuVo.setSiteno(siteno);
            zmenuVo.setMenutopno(zmenuVoDt.getMenutopno());
            zmenuVo.setMenuparentno(zmenuVoDt.getMenuno());
            Integer maxmenusteptmp = zmenuDAO.getMaxmenustepBySitenoAndMenutopnoAndParentno(zmenuVo);

            if (maxmenusteptmp != null)
                menustep = maxmenusteptmp + 1;
            else
                menustep = zmenuVoDt.getMenustep() + 1;


            zmenuVo.setSiteno(siteno);
            zmenuVo.setMenutopno(zmenuVoDt.getMenutopno());
            zmenuVo.setMenustep(menustep);
            zmenuDAO.updateMenuStep(zmenuVo);
        }

        String HTML = input.get("menucontstype").equals("1") ? input.get("menuconts") : input.get("ckeditorConts");//다음웹에디터용
        //String HTML = input.get("menuconts");//나모용 나모사용시 풀것
        //System.out.println("HTML : "+HTML);
        Document doc = Jsoup.parse(HTML);
        Elements ztags = doc.select("call");

        menuno = zmenuDAO.getMaxmenunoBySiteno(siteno);
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
        zmenuVo.setMenucontstype(input.get("menucontstype")); //다음 웹에디터용
        zmenuVo.setMenuconts(input.get("menucontstype").equals("1") ? input.get("menuconts") : input.get("ckeditorConts"));//다음 웹에디터용
        //zmenuVo.setMenucontstype("3");//나모사용시 풀것
        //zmenuVo.setMenuconts(HTML);//나모사용시 풀것
        zmenuVo.setMenustaffid(input.get("menustaffid"));
        zmenuVo.setMenustaffsect(input.get("menustaffsect"));
        zmenuVo.setMenustaffname(input.get("menustaffname"));
        zmenuVo.setMenustaffemail(input.get("menustaffemail"));
        zmenuVo.setMenustafftel(input.get("menustafftel"));
        zmenuVo.setMenustafffax(input.get("menustafffax"));
        zmenuVo.setMenuhis(input.get("menuhis"));
        zmenuVo.setSiteno(siteno);
        zmenuVo.setUserid(userid);
        zmenuVo.setMenutopno(zmenuVoDt.getMenutopno() == -1 ? menuno : zmenuVoDt.getMenutopno());
        zmenuVo.setMenulevel(zmenuVoDt.getMenulevel() == -1 ? 0 : zmenuVoDt.getMenulevel() + 1);
        zmenuVo.setMenustep(menustep);
        zmenuVo.setMenuparentno(zmenuVoDt.getMenuno());
        zmenuVo.setMenusubcss(input.get("menusubcss"));
        zmenuVo.setMenusubjs(input.get("menusubjs"));
        zmenuVo.setMenuttpl(input.get("menuttpl"));
        zmenuVo.setMenultpl(input.get("menultpl"));
        zmenuVo.setMenurtpl(input.get("menurtpl"));
        zmenuVo.setMenubtpl(input.get("menubtpl"));
        zmenuVo.setMenutags(ztags.toString());
        zmenuVo.setMenuarchivepath(input.get("menuarchivepath"));//미사용 archv_no로 대체
        zmenuVo.setArchv_no(input.get("menutype").equals("06") ? input.get("archv_no") : null);//아카이브 본문 당겨오기, 아카이브지정이 아니면 archv_no에 null을 집어넣는다

        //System.out.println("====================================================");
        /*NodeTraversor traversor  = new NodeTraversor(new NodeVisitor() {

			@Override
			public void tail(Node node, int depth) {
				if (node instanceof Element) {
					if(node.nodeName().toLowerCase().equals("table")
							||node.nodeName().toLowerCase().equals("tr")
							||node.nodeName().toLowerCase().equals("td"))
					{
						Element e = (Element) node;
						e.removeAttr("style");
					}
				}
			}

			@Override
			public void head(Node node, int depth) {
			}
		});*/

		/*traversor.traverse(doc.body());   //나모사용시 풀것
		//System.out.println(doc.toString());
		Elements body = doc.body().children();//나모사용시 풀것
		HTML = body.toString();*///나모사용시 풀것
        zmenuVo.setMenuconts(HTML);


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
            FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "t", zmenuVo.getMenutop());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //본문 생성
        try {
            FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "c", zmenuVo.getMenuconts());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //본문하단 생성
        try {
            FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "b", zmenuVo.getMenubtm());
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
                commonUseVo.setUserid(userid);
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
                zcssUseVo.setMenuno(menuno);
                zcssUseVo.setUserid(userid);
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
                zjsUseVo.setMenuno(menuno);
                zjsUseVo.setUserid(userid);
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
                ztplUseVo.setMenuno(menuno);
                ztplUseVo.setUserid(userid);
                if (ztplUseDAO.listCount(ztplUseVo) == 0) {
                    ztplUseDAO.insert(ztplUseVo);
                }
            }
        }
        model.addAttribute("menuno", menuno);
        return model;
    }

    @Transactional
    public Model update(DataTable input, Model model, HttpServletRequest request) {
        int menuno = input.getInt("menuno");
        int siteno = input.getInt("siteno");

        String userid = SecuritySessionUtil.getUserid(request);

        String HTML = input.get("menucontstype").equals("1") ? input.get("menuconts") : input.get("ckeditorConts");//ckeditor
        //String HTML = input.get("menuconts");//나모사용시 풀것
        Document doc = Jsoup.parseBodyFragment(HTML);
        Elements ztags = doc.select("call");

        if (input.get("menuhis").equals("1")) {
            ZmenuHisVo zmenuHisVo = new ZmenuHisVo();
            zmenuHisVo.setUserid(userid);
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
        zmenuVo.setMenuintenallinkother(input.get("menuintenallinkother"));
        zmenuVo.setMenuintenallinktarget(input.get("menuintenallinktarget"));
        zmenuVo.setMenuintenallink(input.get("menuintenallink"));
        zmenuVo.setMenutop(input.get("menutop"));
        zmenuVo.setMenubtm(input.get("menubtm"));
        zmenuVo.setMenucontstype(input.get("menucontstype")); //다음웹에디터용 나모사용시 주석처리할것
        zmenuVo.setMenuconts(HTML);
        //zmenuVo.setMenucontstype("3");//나모 웹 에디터용
        //zmenuVo.setMenuconts(HTML);//나모 웹 에디터용
        zmenuVo.setMenustaffid(input.get("menustaffid"));
        zmenuVo.setMenustaffsect(input.get("menustaffsect"));
        zmenuVo.setMenustaffname(input.get("menustaffname"));
        zmenuVo.setMenustaffemail(input.get("menustaffemail"));
        zmenuVo.setMenustafftel(input.get("menustafftel"));
        zmenuVo.setMenustafffax(input.get("menustafffax"));
        zmenuVo.setMenuhis(input.get("menuhis"));
        zmenuVo.setUserid(userid);
        zmenuVo.setMenusubcss(input.get("menusubcss"));
        zmenuVo.setMenusubjs(input.get("menusubjs"));
        zmenuVo.setMenuttpl(input.get("menuttpl"));
        zmenuVo.setMenultpl(input.get("menultpl"));
        zmenuVo.setMenurtpl(input.get("menurtpl"));
        zmenuVo.setMenubtpl(input.get("menubtpl"));
        zmenuVo.setMenutags(ztags.toString());
        zmenuVo.setMenuarchivepath(input.get("menuarchivepath"));//아카이브(미사용)
        zmenuVo.setArchv_no(input.get("menutype").equals("06") ? input.get("archv_no") : null);//아카이브 본문 당겨오기, 아카이브지정이 아니면 archv_no에 null을 집어넣는다
        zmenuVo.setRltd_shw_yn(input.get("rltd_shw_yn"));//관련자료사용여부
        zmenuVo.setMenuscore(input.getInt("menuscore"));
        zmenuVo.setMenustaff_use_yn(input.getInt("menustaff_use_yn"));
        zmenuVo.setMenusns_use_yn(input.getInt("menusns_use_yn"));
        zmenuVo.setLocation_use_yn(input.getInt("location_use_yn"));


        //System.out.println("====================================================");
		/*NodeTraversor traversor  = new NodeTraversor(new NodeVisitor() {

			@Override
			public void tail(Node node, int depth) {
				if (node instanceof Element) {
					if(node.nodeName().toLowerCase().equals("table")
							||node.nodeName().toLowerCase().equals("tr")
							||node.nodeName().toLowerCase().equals("td"))
					{
						Element e = (Element) node;
						e.removeAttr("style");
					}
				}
			}

			@Override
			public void head(Node node, int depth) {
			}
		});*/

		/*traversor.traverse(doc.body());  //나모사용시 풀것
		//System.out.println(doc.toString());
		Elements body = doc.body().children();//나모사용시 풀것
		HTML = body.toString();*/ //나모사용시 풀것
        //zmenuVo.setMenuconts(HTML);//나모사용시 풀것
        zmenuDAO.update(zmenuVo);


        //template jsp 생성
        //상단, 중단 , 하단을 분리하여 새성한다.
        String jspfn = menuno + "_" + siteno;
        //String contents = zmenuVo.getMenutop()+zmenuVo.getMenuconts()+zmenuVo.getMenubtm();

        //상단생성
        try {
            FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "t", zmenuVo.getMenutop());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //본문생성
        try {
            FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "c", zmenuVo.getMenuconts());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //하단생성
        try {
            FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), jspfn + "b", zmenuVo.getMenubtm());
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

        if (input.get("apply1").equals("1")) {
            ZmenuVo zmenuVoApply1 = new ZmenuVo();
            zmenuVoApply1.setMenusubcss(input.get("menusubcss"));
            zmenuVoApply1.setMenusubjs(input.get("menusubjs"));
            zmenuVoApply1.setUserid(userid);
            zmenuVoApply1.setMenuno(menuno);
            zmenuVoApply1.setSiteno(siteno);
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
                commonUseVo.setUserid(userid);
                commonUseVo.setMenuno(menuno);
                commonDAO.insert(commonUseVo);
            }
        }

        //cssuse insert
        ZcssUseVo zcssUseVo = new ZcssUseVo();
        zcssUseVo.setMenuno(menuno);
        zcssUseVo.setSiteno(siteno);
        zcssUseDAO.deleteOfSite(zcssUseVo);
        String css = input.get("menusubcss");
        for (String val : css.split(",")) {
            if (!val.isEmpty()) {
                zcssUseVo = new ZcssUseVo();
                zcssUseVo.setSiteno(siteno);
                zcssUseVo.setCssno(Integer.parseInt(val));
                zcssUseVo.setMenuno(menuno);
                zcssUseVo.setUserid(userid);
                if (zcssUseDAO.listCount(zcssUseVo) == 0) {
                    zcssUseDAO.insert(zcssUseVo);
                }
            } else { //없을경우 use 삭제

            }
        }

        //jsuse insert
        ZjsUseVo zjsUseVo = new ZjsUseVo();
        zjsUseVo.setMenuno(menuno);
        zjsUseVo.setSiteno(siteno);
        zjsUseDAO.deleteOfSite(zjsUseVo);
        String js = input.get("menusubjs");
        for (String val : js.split(",")) {
            if (!val.isEmpty()) {
                zjsUseVo = new ZjsUseVo();
                zjsUseVo.setSiteno(siteno);
                zjsUseVo.setJsno(Integer.parseInt(val));
                zjsUseVo.setMenuno(menuno);
                zjsUseVo.setUserid(userid);
                if (zjsUseDAO.listCount(zjsUseVo) == 0) {
                    zjsUseDAO.insert(zjsUseVo);
                }
            }
        }

        //tpluse insert
        ZtplUseVo ztplUseVo = new ZtplUseVo();
        ztplUseVo.setMenuno(menuno);
        ztplUseVo.setSiteno(siteno);
        ztplUseDAO.deleteOfSite(ztplUseVo);
        String tpl = input.get("menuttpl").concat("," + input.get("menultpl")).concat("," + input.get("menurtpl")).concat("," + input.get("menubtpl"));
        for (String val : tpl.split(",")) {
            if (!val.isEmpty()) {
                ztplUseVo = new ZtplUseVo();
                ztplUseVo.setSiteno(siteno);
                ztplUseVo.setTplno(Integer.parseInt(val));
                ztplUseVo.setMenuno(menuno);
                ztplUseVo.setUserid(userid);
                if (ztplUseDAO.listCount(ztplUseVo) == 0) {
                    ztplUseDAO.insert(ztplUseVo);
                }
            }
        }
        return model;
    }

    public Model updateView(DataTable input, Model model) {
        int menuno = input.getInt("menuno");
        int siteno = input.getInt("siteno");
        int menuhisno = input.getInt("menuhisno");
        String mode = input.get("mode");
        String act = input.get("act");
        int menuno_r = input.getInt("menuno_r");

        model.addAttribute("act", act);
        model.addAttribute("siteno", siteno);
        model.addAttribute("menuno", menuno);

        //menulevel 가져옴
        ZmenuVo zmenuVo = new ZmenuVo();
        zmenuVo.setMenuno(menuno);
        zmenuVo.setSiteno(siteno);
        int menulevel = zmenuDAO.getMenulevel(zmenuVo);
        //System.out.println("menulevel : " + menulevel);
        model.addAttribute("menulevel", menulevel);

        //sitetitle, sitedomain 가져옴
        ZsiteVo zsiteVo = new ZsiteVo();
        zsiteVo.setSiteno(siteno);
        zsiteVo = zsiteDAO.selectbypk(zsiteVo);

        model.addAttribute("sitetitle", zsiteVo.getSitetitle());
        model.addAttribute("sitedomain", zsiteVo.getSitedomain());
        //링크시 포트에 대한 대응을 위해 추가 20141111 김문석
        //superbolt
        model.addAttribute("port", input.getRequest().getLocalPort() == 80 ? null : ":" + input.getRequest().getLocalPort());

        //zmenu데이타 가져옴
        List<ZmenuVo> list = null;
        zmenuVo.setSiteno(siteno);
        list = this.zmenuDAO.selectbysiteno(zmenuVo);
        model.addAttribute("list", list);

        if (menuno > 0) {
            List<ZmenuVo> depth = null;
            zmenuVo.setMenuno(menuno);
            zmenuVo.setSiteno(siteno);
            depth = this.zmenuDAO.getlistdepth(zmenuVo);
            model.addAttribute("depth", depth);
        }


        //menuHis
        ZmenuHisVo zmenuHisVoL = new ZmenuHisVo();
        zmenuHisVoL.setMenuno(menuno);
        zmenuHisVoL.setSiteno(siteno);

        int pageSize = input.getInt("pageSize", 50);
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int pageIndex = input.getInt("pageIndex") - 1;
        String sdate = input.get("sdate");
        String edate = input.get("edate");
        String keyword = input.get("keyword");

        int m = pageIndex * pageSize;
        int n = pageSize;

        if (sdate.equals("") && edate.equals("")) {
            zmenuHisVoL.setCond1("");
        } else {
            zmenuHisVoL.setCond1(input.get("cond1"));
        }
        if (keyword.equals("")) {
            zmenuHisVoL.setCond2("");
        } else {
            zmenuHisVoL.setCond2(input.get("cond2"));
        }

        zmenuHisVoL.setSdate(input.get("sdate"));
        zmenuHisVoL.setEdate(input.get("edate"));
        zmenuHisVoL.setKeyword(input.get("keyword"));
        zmenuHisVoL.setM(m);
        zmenuHisVoL.setN(n);

        int total = this.zmenuHisDAO.historylistCount(zmenuHisVoL);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        List<ZmenuHisVo> hislist = this.zmenuHisDAO.historylist(zmenuHisVoL);

        model.addAttribute("hislist", hislist);
        model.addAttribute("input", input);

        ZcssVo zcssVo = new ZcssVo();
        List<ZcssVo> cssList = this.zcssDAO.getlistAll(zcssVo);
        model.addAttribute("cssList", cssList);

        ZjsVo zjsVo = new ZjsVo();
        List<ZjsVo> jsList = this.zjsDAO.getlistAll(zjsVo);
        model.addAttribute("jsList", jsList);

        ZtplVo ztplVo = new ZtplVo();
        List<ZtplVo> tList = this.ztplDAO.getlistAll(ztplVo);
        model.addAttribute("tList", tList);


        //zsitecfg 선택시작
        zmenuVo = new ZmenuVo();

        if (mode.equals("restore")) {
            ZmenuHisVo zmenuHisVo = new ZmenuHisVo();
            zmenuHisVo.setMenuhisno(menuhisno);
            zmenuVo = zmenuHisDAO.selectbypk(zmenuHisVo);
        } else {
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
            //System.out.println("refer 탑니다.");
            zmenuVo.setMenuno_r(menuno_r);
            zmenuVo.setMenutitle(input.get("menutitle"));
            zmenuVo.setMenustatus(input.get("menustatus"));
        }


        //detail
        model.addAttribute("detail", zmenuVo);

        //css등의 목록을 어디서 가지고 올지 판단한다.refer가 아니고 menuno가 0일경우 sitecfg의것을 사용한다.
        ZsitecfgVo sitecfg = new ZsitecfgVo();
        ZmenuVo menucfgtmp = new ZmenuVo();
        menucfgtmp = zmenuVo;
        sitecfg.setSitecfgsubcss(menucfgtmp.getMenusubcss());
        sitecfg.setSitecfgsubjs(menucfgtmp.getMenusubjs());
        sitecfg.setSitecfgtoptpl(menucfgtmp.getMenuttpl());
        sitecfg.setSitecfglefttpl(menucfgtmp.getMenultpl());
        sitecfg.setSitecfgrighttpl(menucfgtmp.getMenurtpl());
        sitecfg.setSitecfgbottomtpl(menucfgtmp.getMenubtpl());


        List<ZcssVo> subcss = new ArrayList<ZcssVo>();
        if (null != sitecfg.getSitecfgsubcss()) {
            String[] csstmp = sitecfg.getSitecfgsubcss().split(",");
            for (int i = 0; i < csstmp.length; i++) {
                Iterator<ZcssVo> itersubcss = cssList.iterator();
                while (itersubcss.hasNext()) {
                    ZcssVo tmp = itersubcss.next();
                    if (csstmp[i].equals(String.valueOf(tmp.getCssno()))) {
                        subcss.add(tmp);
                        break;
                    }
                }
            }

        }
        model.addAttribute("menusubcss", subcss);


        List<ZjsVo> subjs = new ArrayList<ZjsVo>();
        if (null != sitecfg.getSitecfgsubjs()) {
            String[] jstmp = sitecfg.getSitecfgsubjs().split(",");
            for (int i = 0; i < jstmp.length; i++) {
                Iterator<ZjsVo> itersubjs = jsList.iterator();
                while (itersubjs.hasNext()) {
                    ZjsVo tmp = itersubjs.next();
                    if (jstmp[i].equals(String.valueOf(tmp.getJsno()))) {
                        subjs.add(tmp);
                        break;
                    }
                }
            }
        }
        model.addAttribute("menusubjs", subjs);

        List<ZtplVo> toptpl = new ArrayList<ZtplVo>();
        List<ZtplVo> lefttpl = new ArrayList<ZtplVo>();
        List<ZtplVo> righttpl = new ArrayList<ZtplVo>();
        List<ZtplVo> bottomtpl = new ArrayList<ZtplVo>();

        if (null != sitecfg.getSitecfgtoptpl()) {
            String[] toptpltmp = sitecfg.getSitecfgtoptpl().split(",");
            for (int i = 0; i < toptpltmp.length; i++) {
                Iterator<ZtplVo> itertpl = tList.iterator();
                while (itertpl.hasNext()) {
                    ZtplVo tmp = itertpl.next();
                    if (tmp.getTplposition().equals("1")) {
                        if (toptpltmp[i].equals(String.valueOf(tmp.getTplno()))) {
                            toptpl.add(tmp);
                            break;
                        }
                    }
                }
            }
        }

        if (null != sitecfg.getSitecfglefttpl()) {
            String[] lefttpltmp = sitecfg.getSitecfglefttpl().split(",");
            for (int i = 0; i < lefttpltmp.length; i++) {
                Iterator<ZtplVo> itertpl = tList.iterator();
                while (itertpl.hasNext()) {
                    ZtplVo tmp = itertpl.next();
                    if (tmp.getTplposition().equals("2")) {
                        if (lefttpltmp[i].equals(String.valueOf(tmp.getTplno()))) {
                            lefttpl.add(tmp);
                            break;
                        }
                    }
                }
            }
        }

        if (null != sitecfg.getSitecfgrighttpl()) {
            String[] righttpltmp = sitecfg.getSitecfgrighttpl().split(",");
            for (int i = 0; i < righttpltmp.length; i++) {
                Iterator<ZtplVo> itertpl = tList.iterator();
                while (itertpl.hasNext()) {
                    ZtplVo tmp = itertpl.next();
                    if (tmp.getTplposition().equals("3")) {
                        if (righttpltmp[i].equals(String.valueOf(tmp.getTplno()))) {
                            righttpl.add(tmp);
                            break;
                        }
                    }
                }
            }
        }

        if (null != sitecfg.getSitecfgbottomtpl()) {
            String[] bottomtpltmp = sitecfg.getSitecfgbottomtpl().split(",");
            for (int i = 0; i < bottomtpltmp.length; i++) {
                Iterator<ZtplVo> itertpl = tList.iterator();
                while (itertpl.hasNext()) {
                    ZtplVo tmp = itertpl.next();
                    if (tmp.getTplposition().equals("4")) {
                        if (bottomtpltmp[i].equals(String.valueOf(tmp.getTplno()))) {
                            bottomtpl.add(tmp);
                            break;
                        }
                    }
                }
            }
        }

        model.addAttribute("menuttpl", toptpl);
        model.addAttribute("menultpl", lefttpl);
        model.addAttribute("menurtpl", righttpl);
        model.addAttribute("menubtpl", bottomtpl);

        //아카이브 관련자료를 가지고 온다.
        List<ArchvRltd> rltdEvent = new ArrayList<ArchvRltd>();
        List<ArchvRltd> rltdDocument = new ArrayList<ArchvRltd>();
        List<ArchvRltd> rltdPhoto = new ArrayList<ArchvRltd>();
        List<ArchvRltd> rltdVod = new ArrayList<ArchvRltd>();

        List<ArchvRltdVO> rltdVOList = new ArrayList<ArchvRltdVO>();
        ArchvRltdVO archvRltdVO = new ArchvRltdVO();
        archvRltdVO.setMenuno(menuno);
        archvRltdVO.setSiteno(siteno);
        try {
            rltdVOList = archvDAO.getRltdByMenunoAndSiteno(archvRltdVO);
            for (int i = 0; rltdVOList.size() > i; i++) {
                if (rltdVOList.get(i).getOpt_no() == 1 || rltdVOList.get(i).getOpt_no() == 2 || rltdVOList.get(i).getOpt_no() == 3
                        || rltdVOList.get(i).getOpt_no() == 4 || rltdVOList.get(i).getOpt_no() == 8) {
                    rltdEvent.add(rltdVOList.get(i));
                } else if (rltdVOList.get(i).getOpt_no() == 5) {
                    rltdDocument.add(rltdVOList.get(i));
                } else if (rltdVOList.get(i).getOpt_no() == 6) {
                    rltdPhoto.add(rltdVOList.get(i));
                } else if (rltdVOList.get(i).getOpt_no() == 7) {
                    rltdVod.add(rltdVOList.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("rltdEvent", rltdEvent);
        model.addAttribute("rltdDocument", rltdDocument);
        model.addAttribute("rltdPhoto", rltdPhoto);
        model.addAttribute("rltdVod", rltdVod);


        return model;
    }


    //미리보기 추가
    public String preview(DataTable input, Model model, HttpServletRequest request, HttpServletResponse response) {
        ZPrint.enter();
        int menuno = input.getInt("menuno");
        int siteno = input.getInt("siteno");

        String userid = SecuritySessionUtil.getUserid(request);

        String HTML = input.get("menucontstype").equals("1") ? input.get("menuconts") : input.get("ckeditorConts");//ckeditor
        //String HTML = input.get("menuconts");//나모사용시 풀것
        Document doc = Jsoup.parseBodyFragment(HTML);
        Elements ztags = doc.select("call");

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
        zmenuVo.setMenuintenallinkother(input.get("menuintenallinkother"));
        zmenuVo.setMenuintenallinktarget(input.get("menuintenallinktarget"));
        zmenuVo.setMenuintenallink(input.get("menuintenallink"));
        zmenuVo.setMenutop(input.get("menutop"));
        zmenuVo.setMenubtm(input.get("menubtm"));
        zmenuVo.setMenucontstype(input.get("menucontstype")); //다음웹에디터용 나모사용시 주석처리할것
        zmenuVo.setMenuconts(HTML);
        //zmenuVo.setMenucontstype("3");//나모 웹 에디터용
        //zmenuVo.setMenuconts(HTML);//나모 웹 에디터용
        zmenuVo.setMenustaffid(input.get("menustaffid"));
        zmenuVo.setMenustaffsect(input.get("menustaffsect"));
        zmenuVo.setMenustaffname(input.get("menustaffname"));
        zmenuVo.setMenustaffemail(input.get("menustaffemail"));
        zmenuVo.setMenustafftel(input.get("menustafftel"));
        zmenuVo.setMenustafffax(input.get("menustafffax"));
        zmenuVo.setMenuhis(input.get("menuhis"));
        zmenuVo.setUserid(userid);
        zmenuVo.setMenusubcss(input.get("menusubcss"));
        zmenuVo.setMenusubjs(input.get("menusubjs"));
        zmenuVo.setMenuttpl(input.get("menuttpl"));
        zmenuVo.setMenultpl(input.get("menultpl"));
        zmenuVo.setMenurtpl(input.get("menurtpl"));
        zmenuVo.setMenubtpl(input.get("menubtpl"));
        zmenuVo.setMenutags(ztags.toString());
        zmenuVo.setMenuarchivepath(input.get("menuarchivepath"));//아카이브(미사용)
        zmenuVo.setArchv_no(input.get("menutype").equals("06") ? input.get("archv_no") : null);//아카이브 본문 당겨오기, 아카이브지정이 아니면 archv_no에 null을 집어넣는다
        zmenuVo.setRltd_shw_yn(input.get("rltd_shw_yn"));//관련자료사용여부
        zmenuVo.setMenuscore(input.getInt("menuscore"));
        zmenuVo.setMenustaff_use_yn(input.getInt("menustaff_use_yn"));
        zmenuVo.setMenusns_use_yn(input.getInt("menusns_use_yn"));
        zmenuVo.setLocation_use_yn(input.getInt("location_use_yn"));

        //zmenuDAO.update(zmenuVo);

        //template jsp 생성
        //상단, 중단 , 하단을 분리하여 새성한다.
        String jspfn = menuno + "_" + siteno;
        //String contents = zmenuVo.getMenutop()+zmenuVo.getMenuconts()+zmenuVo.getMenubtm();

        try {

            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            HttpSession session = request.getSession();
            DataTable r = new DataTable(request);
            PrintWriter out = response.getWriter();
            StringBuffer stringBuffer = new StringBuffer();

            //개발에서는 이렇게 사용 80포트에 대한 www alias가 정의되어 있다면 이대로 사용 아니면 아래와 같은 사용하고 DB상에서는 www를 붙여서 생성한다.
            String serverName = request.getServerName().replaceFirst("www.", "");
            //운영에서는 이렇게 사용(특수한 경우에만 사용)
            //String serverName = request.getServerName();
            if ("localhost".equals(serverName) || "127.0.0.1".equals(serverName) || "115.71.232.2".equals(serverName)) {
                serverName = EgovProperties.getProperty("Globals.server.name");
            }
            String org_serverName = serverName;
            String port = Integer.toString(request.getServerPort());
            serverName = (port == null || port.isEmpty() || "80".equals(port) || "99".equals(port)) ? serverName : org_serverName + ":" + port;

            String remoteServerName = request.getServerName() + ":" + (port.isEmpty() ? "" : port);

            ZsitecfgVo sitecfg = new ZsitecfgVo();
            sitecfg = zsitecfgDAO.selectbysiteno(siteno);
            if (sitecfg == null) {
                out.println("sitecfg에 해당데이타가 없습니다. 홈페이지 관리 > 홈페이지 목록 > 해당사이트의 환경설정을 설정 바랍니다. ");
                out.flush();
                return null;
            }

            session.getServletContext().getRequestDispatcher("/WEB-INF/jsp/zcms/include.jsp").include(request, response);

            stringBuffer.append(sitecfg.getSitecfgdtd() + "\n");
            stringBuffer.append(sitecfg.getSitecfghtm() + "\n");
            stringBuffer.append("<head>\n");
            stringBuffer.append("<title>미리보기</title>\n");

            if (!(sitecfg.getSitecfgmeta() == null || sitecfg.getSitecfgmeta().equals(""))) {
                stringBuffer.append(sitecfg.getSitecfgmeta() + "\n");
            }

            if (zmenuVo.getMenustatus().equals("2")) {
                out.println("사용 중지 된 페이지 입니다.");
                out.flush();
                return null;
            }
            // 링크타입일경우 바로 링크로 보내버린다.
            else if (zmenuVo.getMenutype().equals("04")) {
                if (request.isSecure()) {
                    return "redirect:https://" + zmenuVo.getMenulink();
                } else {
                    return "redirect:http://" + zmenuVo.getMenulink();
                }
            }


            List<ZcssVo> sc = new ArrayList<ZcssVo>();
            List<ZjsVo> sj = new ArrayList<ZjsVo>();

            // sc
            String zsubcss = null;
            if (!(zmenuVo.getMenusubcss() == null || zmenuVo.getMenusubcss().equals(""))) {
                zsubcss = zmenuVo.getMenusubcss();
                List<Integer> arrIntegerNo = new ArrayList<Integer>();
                for (String no : zmenuVo.getMenusubcss().split(",")) {
                    arrIntegerNo.add(Integer.parseInt(no));
                }
                ZcssVo vo = new ZcssVo();
                vo.setArrIntegerNo(arrIntegerNo);
                vo.setCond1(zmenuVo.getMenusubcss());
                sc = zserviceDAO.getListZcssByCssno(vo);
            }

            if (zsubcss != null) {
                String[] maincsstmp = zsubcss.split(",");
                for (int i = 0; i < maincsstmp.length; i++) {
                    Iterator<ZcssVo> itermaincss = sc.iterator();
                    while (itermaincss.hasNext()) {
                        ZcssVo tmp = itermaincss.next();
                        if (maincsstmp[i].equals(String.valueOf(tmp.getCssno()))) {
                            stringBuffer.append("<link rel=\"stylesheet\" href=\"/cms/gen/css/" + tmp.getCssfilesave() + "\" type=\"text/css\" />\n");
                            break;
                        }
                    }
                }
            }

            // sj
            String zsubsj = null;
            if (!(zmenuVo.getMenusubjs() == null || zmenuVo.getMenusubjs().equals(""))) {
                zsubsj = zmenuVo.getMenusubjs();
                List<Integer> arrIntegerNo = new ArrayList<Integer>();
                for (String no : zmenuVo.getMenusubjs().split(",")) {
                    arrIntegerNo.add(Integer.parseInt(no));
                }
                ZjsVo vo = new ZjsVo();
                vo.setArrIntegerNo(arrIntegerNo);
                vo.setCond1(zmenuVo.getMenusubjs());
                sj = zserviceDAO.getListZjsByJsno(vo);
            }


            DataTable ztagResult = null;
            String menuconts = "";

            // tt
            String[] tt = zmenuVo.getMenuttpl() != null && zmenuVo.getMenuttpl() != "" ? zmenuVo.getMenuttpl().split(",") : null;
            // lt
            String[] lt = zmenuVo.getMenultpl() != null && zmenuVo.getMenultpl() != "" ? zmenuVo.getMenultpl().split(",") : null;
            // rt
            String[] rt = zmenuVo.getMenurtpl() != null && zmenuVo.getMenurtpl() != "" ? zmenuVo.getMenurtpl().split(",") : null;
            // bt
            String[] bt = zmenuVo.getMenubtpl() != null && zmenuVo.getMenubtpl() != "" ? zmenuVo.getMenubtpl().split(",") : null;

            stringBuffer.append("</head>\n<body>\n");
            out.println(stringBuffer.toString());// html 순서조정을 위해 상단을 먼저 찍어주고 tpl을 찍어준다.
            stringBuffer.setLength(0);

//            menuconts += zmenuVo.getMenutop(); //상단부

            String menuJspFilePath = "";

            // 본문상단가져오기 ==================================================================================================
            this.writeFileIfNotExist("preview_t", zmenuVo.getSiteno(), zmenuVo.getMenuno(), zmenuVo.getMenutop());// 파일을 검증하여 파일이 없을 경우 만든다.
            remoteServerName = request.getServerName() + ":" + (port.isEmpty() ? "" : port);
            menuJspFilePath = remoteServerName + "/front/parse/template/menu/preview_t.html"; //폴더방식에 대한 대응;
            menuconts += this.getHttpURLConnectionContents(menuJspFilePath, session, request);


            // 본문 파라미터 세팅
            String param = null;
            String calParam = "?menuno=" + menuno + "&_to=" + request.getRequestURL().toString()
                    + "&section=" + zmenuVo.getMenuintenallinkother() //메뉴별 일정관리 구분을 위해 사용 - 예)행사일정, 순회일정, 사이트번호등
                    + "&evnt_opt_cd=" + zmenuVo.getMenuintenallinkother() //행사신청의 메뉴번호(내부링크에서의 번호로 사용)
//                                    +"&subname="+subname //폴더방식에 대한 대응
                    ;
            @SuppressWarnings("rawtypes")
            Enumeration enu = request.getParameterNames();
            while (enu.hasMoreElements()) {
                param = (String) enu.nextElement();
                if (param != null && !("menuno".equals(param) || "siteDivision".equals(param) || "bbsconts".equals(param))) {
                    calParam += "&" + param + "=" + URLEncoder.encode(request.getParameter(param), "UTF-8");
                }
            }
            // 1. 내부링크 ##################
            if (zmenuVo.getMenutype().equals("05")) {
                menuJspFilePath = remoteServerName + "/" + zmenuVo.getMenuintenallink();
                menuconts += this.getHttpURLConnectionContents(menuJspFilePath + calParam, session, request);

                // 2. 아카이브 ##################
            } else if (zmenuVo.getMenutype().equals("06")) {
                String archvBody = archvFrontService.getContsByArchv_no(zmenuVo.getArchv_no());
                if (archvBody == null || archvBody.equals("") || archvBody.equals("null")) {
                    menuconts += "아카이브가 지정되지 않았거나, 아카이브 본문의 내용이 없습니다.<br/>" + "콘텐츠종류를 직접 작성하시거나 아카이브 본문을 지정해 주십시오";
                } else {
                    menuconts += archvBody;
                }

                // 3. 일반 페이지 ################
            } else {
//            	menuconts += zmenuVo.getMenuconts(); //중간부

                this.writeFileIfNotExist("preview_c", zmenuVo.getSiteno(), zmenuVo.getMenuno(), zmenuVo.getMenuconts());// 파일을 검증하여 파일이 없을 경우
                menuJspFilePath = remoteServerName + "/front/parse/template/menu/preview_c.html";
                menuconts += this.getHttpURLConnectionContents(menuJspFilePath, session, request);

            }


            // 하단가져오기 =============================================================================================
            this.writeFileIfNotExist("preview_b", zmenuVo.getSiteno(), zmenuVo.getMenuno(), zmenuVo.getMenubtm());// 파일을 검증하여 파일이 없을 경우 만든다.
            /*menuJspFilePath = "http://" + remoteServerName+ "/front/parse/template/menu/" + scs.getMenuno()+ "_" + scs.getSiteno() + "b" + ".html";*/
            menuJspFilePath = remoteServerName + "/front/parse/template/menu/preview_b.html"; //폴더방식에 대한 대응;;
            menuconts += this.getHttpURLConnectionContents(menuJspFilePath, session, request);

//            menuconts += zmenuVo.getMenubtm(); //하단부


            // 아카이브 관련자료가져오기.컨트롤러에서 자료를 view로 넘겨주기위해 파일스트림 형태로 가지고 온다.
            // 링크주소는 /front/archv/rltd/{menuno}/{siteno}
            if (zmenuVo.getRltd_shw_yn() != null) {
                if (zmenuVo.getRltd_shw_yn().equals("1")) {
                    menuJspFilePath = remoteServerName + "/front/archv/rltd/" + zmenuVo.getMenuno() + "/" + zmenuVo.getSiteno() + ".html";
                    menuconts += this.getHttpURLConnectionContents(menuJspFilePath, session, request);
                }

            }
            // 담당자정보가져오기
            if (zmenuVo.getMenustaff_use_yn() == 1) {

                if (request.isSecure()) {
                    menuJspFilePath = "https://" + remoteServerName + "/front/menustaff/index.html?menustafftel=" + zmenuVo.getMenustafftel() + "&menustafffax=" + zmenuVo.getMenustafffax() + "&menustaffemail=" + zmenuVo.getMenustaffemail();
                } else {
                    menuJspFilePath = "http://" + remoteServerName + "/front/menustaff/index.html?menustafftel=" + zmenuVo.getMenustafftel() + "&menustafffax=" + zmenuVo.getMenustafffax() + "&menustaffemail=" + zmenuVo.getMenustaffemail();
                }

                String menustaffname = zmenuVo.getMenustaffname() == null ? "null" : zmenuVo.getMenustaffname();
                String menustaffsect = zmenuVo.getMenustaffsect() == null ? "null" : zmenuVo.getMenustaffsect();

                String data = URLEncoder.encode("menustaffsect", "utf-8") + "=" + URLEncoder.encode(menustaffsect, "utf-8")+"&"+URLEncoder.encode("menustaffname", "utf-8") + "=" + URLEncoder.encode(menustaffname, "utf-8");
                URLConnection connection = new URL(menuJspFilePath).openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());//세션을 함께 넘겨준다
                OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
                wr.write(data);
                wr.flush();

                InputStream s = connection.getInputStream();//파일스트림으로 읽어온다
                menuconts += StringUtil.getStringFromInputStream(s);//메뉴본문의 내용을 읽어와서 파싱...
                s.close();
            }
            // sns링크화면 가져오기
            if (zmenuVo.getMenusns_use_yn() == 1) {

                if (request.isSecure()) {
                    menuJspFilePath = "https://" + remoteServerName + "/front/menusns/" + zmenuVo.getMenuno() + "/" + zmenuVo.getSiteno() + ".html";
                } else {
                    menuJspFilePath = "http://" + remoteServerName + "/front/menusns/" + zmenuVo.getMenuno() + "/" + zmenuVo.getSiteno() + ".html";
                }

                String data = URLEncoder.encode("menutitle", "utf-8") + "=" + URLEncoder.encode(zmenuVo.getMenutitle(), "utf-8");
                HttpURLConnection connection = (HttpURLConnection) new URL(menuJspFilePath).openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());//세션을 함께 넘겨준다
                OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
                wr.write(data);
                wr.flush();

                menuconts += StringUtil.getStringFromInputStream(connection.getInputStream());//메뉴본문의 내용을 읽어와서 파싱...
                connection.disconnect();
            }
            // 만족도 화면 가져오기
            if (zmenuVo.getMenuscore() == 1) {
                menuJspFilePath = remoteServerName + "/front/menuscore/" + zmenuVo.getMenuno() + "/" + zmenuVo.getSiteno() + ".html";
                menuconts += this.getHttpURLConnectionContents(menuJspFilePath, session, request);
            }

            if (r.get("act").equals("update")) r.put("act", "list");

            ztagResult = HtmlParser.ztagsParser(menuconts, r);
            ztags = (Elements) ztagResult.getObject("ztags");

            if (ztags.size() > 0) {
                stringBuffer.append((StringBuffer) ztagResult.getObject("cssfile"));
                stringBuffer.append((StringBuffer) ztagResult.getObject("jsfile"));
            }

            if (sj != null) {
                String[] mainjstmp = zsubsj.split(",");
                for (int i = 0; i < mainjstmp.length; i++) {
                    Iterator<ZjsVo> itermainjs = sj.iterator();
                    while (itermainjs.hasNext()) {
                        ZjsVo tmp = itermainjs.next();
                        if (mainjstmp[i].equals(String.valueOf(tmp.getJsno()))) {
                            stringBuffer.append("<script type=\"text/javascript\" src=\"/cms/gen/js/" + tmp.getJsfilesave() + "\"></script>\n");
                            break;
                        }
                    }
                }
            }


            ZtplVo vo = new ZtplVo();

            // tpl 상단 삽입부

        	/*for (int i = 0; tt != null && i < tt.length; i++) {
            	vo = new ZtplVo();
                vo.setTplno(Integer.parseInt(tt[i]));
                vo = ztplDAO.selectbypk(vo);
                stringBuffer.append(vo.getTplconts());
            }*/


            // tpl 상단 삽입부
            for (int i = 0; tt != null && i < tt.length; i++) {
                // jsp parsing을 위해 jsp를 불러오는것으로 대체
                request.setAttribute("siteno", siteno);
                //request.setAttribute("loginMenuno",   Integer.toString(zmvo.getMenuno()));// header에서 사용되는 사용하기 위해서 현재 사이트에서 사용하고 있는 member skin의 no를 미리 알고 있어야한다.
                //request.setAttribute("memberno",Integer.toString(zmvo.getMemberno()));// 하나의 사이트에는 반드시 하나의 member가사용되어야한다.
                //request.setAttribute("zmenutitlepath",    head.getSitewebtitle() + scs.getZmenutitlepath());// tpl head의 nav title을 표시
//                request.setAttribute("subname",subname);
                request.setAttribute("menuno", menuno);
                session.getServletContext().getRequestDispatcher("/front/parse/template/tpl/" + tt[i] + ".html").include(request, response);
                /* stringBuffer.append(data.getTplconts()+"\n"); */
            }




           /* stringBuffer.append("<div class='location'><img src='/usr/image/common/icon/icon_home.gif' alt='HOME' /> &gt; "+zmenuVo.getMenutitle()+"</div>");
            ZUserVo zUserVoName = (ZUserVo)SecuritySessionUtil.getUserVo(request);
            String username = zUserVoName == null?null:zUserVoName.getUsername() ;
            if(!(username==null || username.equals(""))){
                stringBuffer.append("<div class='sub-login'>");
                stringBuffer.append("   <span class='member'><strong>"+username+"</strong> 님</span>");
                stringBuffer.append("       <span class='info'><a href='/?menuno=2431'>My Page</a></span>");
                stringBuffer.append("   <a href='/j_spring_security_logout' class='btn'><img src='/usr/image/common/btn/btn_logout02.gif' alt='로그아웃' /></a>");
                stringBuffer.append("</div>");
            }
            out.println(stringBuffer.toString());
            stringBuffer.setLength(0);*/


            // tpl left삽입부

    	 /*for (int i = 0; lt != null && i < lt.length; i++) {
         	vo = new ZtplVo();
             vo.setTplno(Integer.parseInt(lt[i]));
             vo = ztplDAO.selectbypk(vo);
             stringBuffer.append(vo.getTplconts());
         }*/

            // tpl left삽입부
            for (int i = 0; lt != null && i < lt.length; i++) {
                //ZtplVo data = lt.get(i);
                request.setAttribute("siteno", siteno);
                //request.setAttribute("loginMenuno", Integer.toString(zmvo.getMenuno()));// header에서 사용되는 로그인/회원가입등을 사용하기 위해서 현재 사이트에서 사용하고 있는 member skin의 no를 미리 알고 있어야한다.
                //request.setAttribute("memberno", Integer.toString(zmvo.getMemberno()));// 하나의 사이트에는 반드시 하나의 member가사용되어야한다.
//                request.setAttribute("subname",subname);
                session.getServletContext().getRequestDispatcher("/front/parse/template/tpl/" + lt[i] + ".html").include(request, response);
                /* stringBuffer.append(data.getTplconts()+"\n"); */
            }


            if (ztags.size() > 0) {

                out.println(stringBuffer.toString());

                stringBuffer.setLength(0);

                String[] parthtml = null == ztagResult.getObject("parthtml") ? null : (String[]) ztagResult.getObject("parthtml");
                @SuppressWarnings("unchecked")
                ArrayList<String> htmlfile = (ArrayList<String>) ztagResult.getObject("htmlfile");

                //layerpopup 위치지정 계산값.
                int layerpopupcount = 0;//해당 카운트로 각 layerpopup의 위치를 지정한다.
                int layerpopupmcount = 0;//레이어 팝업이 몇개 적용되었은지 표시한다.
                for (Element ztag : ztags) {
                    if ("layerpopup".equals(ztag.attr("type"))) {
                        layerpopupmcount += 1;
                    }
                }

                for (Element ztag : ztags) {

                    if (null != parthtml) {
                        out.println(parthtml[ztags.indexOf(ztag)].replace("</call>", ""));
                    }

                    System.out.println("ztag(type)=========>" + ztag.attr("type"));


                    if ("popup".equals(ztag.attr("type"))) {
                        int popupno = Integer.parseInt(ztag.attr("no"));

                        // 쿠키의 값에 오늘 값이 저장되어 있는가? 있다면 표시하지 않고 다음팝업체크
                        if (!isClickNoMoreToday(request, popupno)) {

                            ZPopupVo popdata = new ZPopupVo();
                            popdata.setPopupno(popupno);
                            popdata = (ZPopupVo) zpopupDAO.detail(popdata);

                            // 데이타가 없을시 다음으로
                            if (popdata != null) {

                                // 미사용일 경우 다음으로
                                if (popdata.getPopupstatus().equals("1")) {

                                    Date currentDate = new Date();
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    Date start = format.parse(StringUtil.replaceNull(popdata.getSdate(), "0"));
                                    Date end = format.parse(StringUtil.replaceNull(popdata.getEdate(), "0"));

                                    if (currentDate.getTime() > start.getTime() && currentDate.getTime() < end.getTime()) {
                                        String popupsize = StringUtil.replaceNull(popdata.getPopupsize(), "0");
                                        String popupposition = StringUtil.replaceNull(popdata.getPopupposition(), "0");

                                        String windowWidth = popupsize != null ? popupsize.split(":")[0] : "0";
                                        String windowHeight = popupsize != null ? popupsize.split(":")[1] : "0";
                                        String windowTop = popupposition != null ? popupposition.split(":")[0] : "0";
                                        String windowLeft = popupposition != null ? popupposition.split(":")[1] : "0";

                                        stringBuffer.append("<script type=\"text/javascript\">\n");
                                        stringBuffer.append("var windowWidth = " + windowWidth + ";\n");
                                        stringBuffer.append("var windowHeight = " + windowHeight + ";\n");
                                        // stringBuffer.append("var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));\n");
                                        // stringBuffer.append("var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));\n");
                                        stringBuffer.append("var windowLeft = " + windowLeft + ";\n");
                                        stringBuffer.append("var windowTop = " + windowTop + ";\n");
                                        stringBuffer.append("var windowSize = \"width=\" + windowWidth + \",height=\" + windowHeight + \",left=\" + windowLeft + \",top=\" + windowTop + \",screenX=\" + windowLeft + \",screenY=\" + windowTop;\n");
                                        stringBuffer.append("var win = window.open(\"" + htmlfile.get(ztags.indexOf(ztag)) + "?popupno=" + popupno + "\", \"popup_" + popupno + "\", windowSize);\n");
                                        stringBuffer.append("win.focus();\n");
                                        stringBuffer.append("</script>\n");
                                    } else {
                                        System.out.println("시간이 안됨");
                                    }

                                }

                            }

                        }


                    } else if ("layerpopup".equals(ztag.attr("type"))) {
                        layerpopupcount += 1;
                        int layerpopupno = Integer.parseInt(ztag.attr("no"));

                        // 쿠키의 값에 오늘 값이 저장되어 있는가? 있다면 표시하지 않고 다음팝업체크
                        if (!isLayerClickNoMoreToday(request, layerpopupno)) {

                            ZLayerPopupVo popdata = new ZLayerPopupVo();
                            popdata.setLayerpopupno(layerpopupno);
                            popdata = (ZLayerPopupVo) zlayerpopupDAO.detail(popdata);

                            // 데이타가 없을시 다음으로
                            if (popdata != null) {

                                // 미사용일 경우 다음으로
                                if (popdata.getPopupstatus().equals("1")) {

                                    Date currentDate = new Date();
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    Date start = format.parse(StringUtil.replaceNull(popdata.getSdate(), "0"));
                                    Date end = format.parse(StringUtil.replaceNull(popdata.getEdate(), "0"));

                                    if (currentDate.getTime() > start.getTime() && currentDate.getTime() < end.getTime()) {
                                        String popupsize = StringUtil.replaceNull(popdata.getPopupsize(), "0");
                                        String popupposition = StringUtil.replaceNull(popdata.getPopupposition(), "0");

                                        String windowWidth = popupsize != null ? popupsize.split(":")[0] : "0";
                                        String windowHeight = popupsize != null ? popupsize.split(":")[1] : "0";
                                        String windowTop = popupposition != null ? popupposition.split(":")[0] : "0";
                                        String windowLeft = popupposition != null ? popupposition.split(":")[1] : "0";

                                        request.setAttribute("layerpopupcount", layerpopupcount);
                                        request.setAttribute("layerpopupmcount", layerpopupmcount);
                                        request.setAttribute("layerpopupno", layerpopupno);
                                        request.setAttribute("windowWidth", windowWidth);
                                        request.setAttribute("windowHeight", windowHeight);
                                        request.setAttribute("windowTop", windowTop);
                                        request.setAttribute("windowLeft", windowLeft);
                                        request.setAttribute("type", ztag.attr("type"));
                                        request.setAttribute("skin", ztag.attr("skin"));
                                        request.setAttribute("act", r.get("act", "write"));
                                        session.getServletContext().getRequestDispatcher(htmlfile.get(ztags.indexOf(ztag))).include(request, response);
                                    } else {
                                        System.out.println("시간이 안됨");
                                    }

                                }

                            }

                        }
                    } else {


                        System.out.println("htmlfile.get(ztags.indexOf(ztag))===>" + htmlfile.get(ztags.indexOf(ztag)));

                        request.setAttribute("siteno", siteno);
                        request.setAttribute("menuno", menuno);
                        request.setAttribute("userid", session.getAttribute("userid"));
                        request.setAttribute("no", ztag.attr("no"));
                        request.setAttribute("type", ztag.attr("type"));
                        request.setAttribute("skin", ztag.attr("skin"));
                        request.setAttribute("act", r.get("act", "list"));
                        request.setAttribute("bbshit", r.getInt("bbshit", 1));
                        request.setAttribute("usertype", r.get("usertype"));// 14세이상,미만,외국인
                        request.setAttribute("username", r.get("username"));
//                       request.setAttribute("subname",subname);
                        session.getServletContext().getRequestDispatcher(htmlfile.get(ztags.indexOf(ztag))).include(request, response);
                    }

                    if (null != parthtml) {
                        if (ztag == ztags.last())
                            out.println(parthtml[parthtml.length - 1].replace("</call>", "") + "\n");
                    }
                }
            } else { //ztag가 본문에 포함되어 있지 않을 경우 그냥 위에서 파싱한 본문을 찍어준다.
                stringBuffer.append(menuconts);
            }

            // 여기까지는모두찍고 우측과 하단 template jsp를 불러들인다.
            out.println(stringBuffer.toString());
            stringBuffer.setLength(0);


            //tpl right 삽입부
        /* for (int i = 0; rt != null && i < rt.length; i++) {
          	vo = new ZtplVo();
              vo.setTplno(Integer.parseInt(rt[i]));
              vo = ztplDAO.selectbypk(vo);
              stringBuffer.append(vo.getTplconts());
          }

         //tpl bottom 삽입부

    	   for (int i = 0; bt != null && i < bt.length; i++) {
          		vo = new ZtplVo();
              vo.setTplno(Integer.parseInt(bt[i]));
              vo = ztplDAO.selectbypk(vo);
              stringBuffer.append(vo.getTplconts());
          }*/

            //tpl right 삽입부
            for (int i = 0; rt != null && i < rt.length; i++) {
                //ZtplVo data = rt.get(i);
//               request.setAttribute("subname",subname);
                session.getServletContext().getRequestDispatcher("/front/parse/template/tpl/" + rt[i] + ".html").include(request, response);
               /* stringBuffer.append(data.getTplconts()+"\n"); */
            }

            //tpl bottom 삽입부
            for (int i = 0; bt != null && i < bt.length; i++) {
                //ZtplVo data = bt.get(i);
//               request.setAttribute("subname",subname);
                session.getServletContext().getRequestDispatcher("/front/parse/template/tpl/" + bt[i] + ".html").include(request, response);
               /* stringBuffer.append(data.getTplconts()+"\n"); */
            }


            stringBuffer.append("\n</body>\n");
            stringBuffer.append("</html>\n");
            out.println(stringBuffer.toString());
            stringBuffer.setLength(0);
            out.flush();


        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        return null;
    }


    public Model insertView(DataTable input, Model model) {

        String act = input.get("act");
        int siteno = input.getInt("siteno");
        int menuno = input.getInt("menuno");
        int menuno_r = input.getInt("menuno_r");

        model.addAttribute("siteno", siteno);
        model.addAttribute("menuno", menuno);
        model.addAttribute("act", act);

        ZsiteVo zsiteVo = new ZsiteVo();
        ZmenuVo zmenuVo = new ZmenuVo();

        //menulevel 가져옴
        zmenuVo.setMenuno(menuno);
        zmenuVo.setSiteno(siteno);
        Integer menuleveltmp = zmenuDAO.getMenulevel(zmenuVo);
        int menulevel = menuleveltmp == null ? 0 : menuleveltmp;
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
            List<ZmenuVo> depth = null;
            zmenuVo.setMenuno(menuno);
            zmenuVo.setSiteno(siteno);
            depth = this.zmenuDAO.getlistdepth(zmenuVo);
            model.addAttribute("depth", depth);
        }

        ZcssVo zcssVo = new ZcssVo();
        List<ZcssVo> cssList = this.zcssDAO.getlistAll(zcssVo);
        model.addAttribute("cssList", cssList);

        ZjsVo zjsVo = new ZjsVo();
        List<ZjsVo> jsList = this.zjsDAO.getlistAll(zjsVo);
        model.addAttribute("jsList", jsList);

        ZtplVo ztplVo = new ZtplVo();
        List<ZtplVo> tList = this.ztplDAO.getlistAll(ztplVo);
        model.addAttribute("tList", tList);


        //zsitecfg 선택시작
        ZsitecfgVo zsitecfgVo = new ZsitecfgVo();
        ZmenuVo zmenuVo2 = new ZmenuVo();
        zmenuVo = new ZmenuVo();

        if (act.equals("refer")) {
            zmenuVo.setMenuno(menuno_r);
            zmenuVo.setSiteno(siteno);
            zmenuVo = zmenuDAO.selectbySitenoAndMenuno(zmenuVo);

            zmenuVo.setMenuno(menuno_r);
            zmenuVo.setMenutitle(input.get("menutitle"));
            zmenuVo.setMenustatus(input.get("menustatus"));
            model.addAttribute("siteCfg", zmenuVo);


        } else {
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

                } else {
                    ZmenuVo sitecfgnull = new ZmenuVo();
                    sitecfgnull.setMenutype("01");
                    model.addAttribute("siteCfg", sitecfgnull);
                    return model;
                }
            } else {
                zmenuVo.setMenuno(menuno);
                zmenuVo.setSiteno(siteno);
                int menuparentno = zmenuDAO.getMenuparentno(zmenuVo);
                if (menuparentno > 0) {
                    zmenuVo.setMenuno(menuparentno);
                    zmenuVo.setSiteno(siteno);
                    zmenuVo2 = zmenuDAO.selectbySitenoAndMenuno(zmenuVo);
                } else {
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
        ZsitecfgVo sitecfg = new ZsitecfgVo();
        ZmenuVo menucfgtmp = new ZmenuVo();
        if (!act.equals("refer") && menuno == 0) {
            sitecfg = zsitecfgVo;
        } else {

            if (act.equals("refer")) {
                menucfgtmp = zmenuVo;
            } else {
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
            String[] csstmp = sitecfg.getSitecfgmaincss().split(",");
            for (int i = 0; i < csstmp.length; i++) {
                Iterator<ZcssVo> itermaincss = cssList.iterator();
                while (itermaincss.hasNext()) {
                    ZcssVo tmp = itermaincss.next();
                    if (csstmp[i].equals(String.valueOf(tmp.getCssno()))) {
                        maincss.add(tmp);
                        break;
                    }
                }
            }

        }
        model.addAttribute("mainCss", maincss);


        List<ZcssVo> subcss = new ArrayList<ZcssVo>();
        if (null != sitecfg.getSitecfgsubcss()) {
            String[] csstmp = sitecfg.getSitecfgsubcss().split(",");
            for (int i = 0; i < csstmp.length; i++) {
                Iterator<ZcssVo> itersubcss = cssList.iterator();
                while (itersubcss.hasNext()) {
                    ZcssVo tmp = itersubcss.next();
                    if (csstmp[i].equals(String.valueOf(tmp.getCssno()))) {
                        subcss.add(tmp);
                        break;
                    }
                }
            }

        }
        model.addAttribute("subCss", subcss);

        List<ZjsVo> mainjs = new ArrayList<ZjsVo>();
        if (null != sitecfg.getSitecfgmainjs()) {
            String[] jstmp = sitecfg.getSitecfgmainjs().split(",");
            for (int i = 0; i < jstmp.length; i++) {
                Iterator<ZjsVo> itermainjs = jsList.iterator();
                while (itermainjs.hasNext()) {
                    ZjsVo tmp = itermainjs.next();
                    if (jstmp[i].equals(String.valueOf(tmp.getJsno()))) {
                        mainjs.add(tmp);
                        break;
                    }
                }
            }

        }
        model.addAttribute("mainJs", mainjs);


        List<ZjsVo> subjs = new ArrayList<ZjsVo>();
        if (null != sitecfg.getSitecfgsubjs()) {
            String[] jstmp = sitecfg.getSitecfgsubjs().split(",");
            for (int i = 0; i < jstmp.length; i++) {
                Iterator<ZjsVo> itersubjs = jsList.iterator();
                while (itersubjs.hasNext()) {
                    ZjsVo tmp = itersubjs.next();
                    if (jstmp[i].equals(String.valueOf(tmp.getJsno()))) {
                        subjs.add(tmp);
                        break;
                    }
                }
            }

        }
        model.addAttribute("subJs", subjs);


//   		List<ZcssVo> maincss = new ArrayList<ZcssVo>();
//		if (null!=sitecfg.getSitecfgmaincss()){
//			Iterator<ZcssVo> itermaincss = cssList.iterator();
//			while (itermaincss.hasNext()){
//				ZcssVo tmp = itermaincss.next();
//				if (Arrays.asList(sitecfg.getSitecfgmaincss().split(",")).contains(String.valueOf(tmp.getCssno()))){
//					maincss.add(tmp);
//				}
//			}
//		}
//		model.addAttribute("mainCss", maincss);
//
//		List<ZcssVo> subcss = new ArrayList<ZcssVo>();
//		if (null!=sitecfg.getSitecfgsubcss()){
//			Iterator<ZcssVo> itersubcss = cssList.iterator();
//			while (itersubcss.hasNext()){
//				ZcssVo tmp = itersubcss.next();
//				if (Arrays.asList(sitecfg.getSitecfgsubcss().split(",")).contains(String.valueOf(tmp.getCssno()))){
//					subcss.add(tmp);
//				}
//			}
//		}
//		model.addAttribute("subCss", subcss);
//
//		List<ZjsVo> mainjs = new ArrayList<ZjsVo>();
//		if (null!=sitecfg.getSitecfgmainjs()){
//			Iterator<ZjsVo> itermainjs = jsList.iterator();
//			while (itermainjs.hasNext()){
//				ZjsVo tmp = itermainjs.next();
//				if (Arrays.asList(sitecfg.getSitecfgmainjs().split(",")).contains(String.valueOf(tmp.getJsno()))){
//					mainjs.add(tmp);
//				}
//			}
//		}
//		model.addAttribute("mainJs", mainjs);
//
//		List<ZjsVo> subjs = new ArrayList<ZjsVo>();
//		if (null!=sitecfg.getSitecfgsubjs()){
//			Iterator<ZjsVo> itersubjs = jsList.iterator();
//			while (itersubjs.hasNext()){
//				ZjsVo tmp = itersubjs.next();
//				if (Arrays.asList(sitecfg.getSitecfgsubjs().split(",")).contains(String.valueOf(tmp.getJsno()))){
//					subjs.add(tmp);
//				}
//			}
//		}
//		model.addAttribute("subJs", subjs);

        List<ZtplVo> toptpl = new ArrayList<ZtplVo>();
        List<ZtplVo> lefttpl = new ArrayList<ZtplVo>();
        List<ZtplVo> righttpl = new ArrayList<ZtplVo>();
        List<ZtplVo> bottomtpl = new ArrayList<ZtplVo>();

        if (null != sitecfg.getSitecfgtoptpl()) {
            String[] toptpltmp = sitecfg.getSitecfgtoptpl().split(",");
            for (int i = 0; i < toptpltmp.length; i++) {
                Iterator<ZtplVo> itertpl = tList.iterator();
                while (itertpl.hasNext()) {
                    ZtplVo tmp = itertpl.next();
                    if (tmp.getTplposition().equals("1")) {
                        if (toptpltmp[i].equals(String.valueOf(tmp.getTplno()))) {
                            toptpl.add(tmp);
                            break;
                        }
                    }
                }
            }
        }

        if (null != sitecfg.getSitecfglefttpl()) {
            String[] lefttpltmp = sitecfg.getSitecfglefttpl().split(",");
            for (int i = 0; i < lefttpltmp.length; i++) {
                Iterator<ZtplVo> itertpl = tList.iterator();
                while (itertpl.hasNext()) {
                    ZtplVo tmp = itertpl.next();
                    if (tmp.getTplposition().equals("2")) {
                        if (lefttpltmp[i].equals(String.valueOf(tmp.getTplno()))) {
                            lefttpl.add(tmp);
                            break;
                        }
                    }
                }
            }
        }

        if (null != sitecfg.getSitecfgrighttpl()) {
            String[] righttpltmp = sitecfg.getSitecfgrighttpl().split(",");
            for (int i = 0; i < righttpltmp.length; i++) {
                Iterator<ZtplVo> itertpl = tList.iterator();
                while (itertpl.hasNext()) {
                    ZtplVo tmp = itertpl.next();
                    if (tmp.getTplposition().equals("3")) {
                        if (righttpltmp[i].equals(String.valueOf(tmp.getTplno()))) {
                            righttpl.add(tmp);
                            break;
                        }
                    }
                }
            }
        }

        if (null != sitecfg.getSitecfgbottomtpl()) {
            String[] bottomtpltmp = sitecfg.getSitecfgbottomtpl().split(",");
            for (int i = 0; i < bottomtpltmp.length; i++) {
                Iterator<ZtplVo> itertpl = tList.iterator();
                while (itertpl.hasNext()) {
                    ZtplVo tmp = itertpl.next();
                    if (tmp.getTplposition().equals("4")) {
                        if (bottomtpltmp[i].equals(String.valueOf(tmp.getTplno()))) {
                            bottomtpl.add(tmp);
                            break;
                        }
                    }
                }
            }
        }

////		Iterator<ZtplVo> itertpl = tList.iterator();
//		while (itertpl.hasNext()){
//			ZtplVo tmp = itertpl.next();
//			if (tmp.getTplposition().equals("1")){
//				if (null!=sitecfg.getSitecfgtoptpl()){
//					if (Arrays.asList(sitecfg.getSitecfgtoptpl().split(",")).contains(String.valueOf(tmp.getTplno()))){
//						toptpl.add(tmp);
//					}
//				}
//			}
//			if (tmp.getTplposition().equals("2")){
//				if (null!=sitecfg.getSitecfglefttpl()){
//					if (Arrays.asList(sitecfg.getSitecfglefttpl().split(",")).contains(String.valueOf(tmp.getTplno()))){
//						lefttpl.add(tmp);
//					}
//				}
//			}
//			if (tmp.getTplposition().equals("3")){
//				if (null!=sitecfg.getSitecfgrighttpl()){
//					if (Arrays.asList(sitecfg.getSitecfgrighttpl().split(",")).contains(String.valueOf(tmp.getTplno()))){
//						righttpl.add(tmp);
//					}
//				}
//			}
//			if (tmp.getTplposition().equals("4")){
//				if (null!=sitecfg.getSitecfgbottomtpl()){
//					if (Arrays.asList(sitecfg.getSitecfgbottomtpl().split(",")).contains(String.valueOf(tmp.getTplno()))){
//						bottomtpl.add(tmp);
//					}
//				}
//			}
//		}
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
        int pageIndex = input.getInt("pageIndex") - 1;
        String sdate = input.get("sdate");
        String edate = input.get("edate");
        String keyword = input.get("keyword");
        String sitestatus = input.get("sitestatus");
        int m = pageIndex * pageSize;
        int n = m + pageSize;

        if (sdate.equals("") && edate.equals("")) {
            zsiteVo.setCond1("");
        } else {
            zsiteVo.setCond1(input.get("cond1"));
        }
        if (keyword.equals("")) {
            zsiteVo.setCond2("");
        } else {
            zsiteVo.setCond2(input.get("cond2"));
        }
        if (sitestatus.equals("")) {
            zsiteVo.setSitestatus("");
        } else {
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

    public void orderChange(DataTable dt, ZmenuVo zmenuVo) {
        //미완성 완성시킬것
        int menutopno = 0;
        int menustep = 0;
        int menulevel = 0;
        int menuparentno = 0;

        int siteno = dt.getInt("siteno");
        int menuno = dt.getInt("menuno");
        String act = dt.get("act");

        zmenuVo = zmenuDAO.menuInfo(zmenuVo);

        menutopno = zmenuVo.getMenutopno();
        menustep = zmenuVo.getMenustep();
        menulevel = zmenuVo.getMenulevel();
        menuparentno = zmenuVo.getMenuparentno();

        int menusteporg = 0;
        int menutopnoorg = 0;

        if (menulevel > 0) {

            menusteporg = menustep;

            zmenuVo.setSiteno(siteno);
            zmenuVo.setMenutopno(menutopno);
            zmenuVo.setMenuparentno(menuparentno);
            zmenuVo.setMenulevel(menulevel);
            zmenuVo.setMenustep(menusteporg);


            if (act.equals("d")) {

                zmenuVo.setNvlType("MIN");
                zmenuVo.setCond2("3");
                zmenuVo.setSelType("menustep");
                zmenuVo = zmenuDAO.getMenuStep(zmenuVo);

                int menustepmax1 = zmenuVo.getMenustep();

                if (menustepmax1 > 0) {

                    zmenuVo = new ZmenuVo();
                    zmenuVo.setSiteno(siteno);
                    zmenuVo.setMenutopno(menutopno);
                    zmenuVo.setMenuparentno(-1);
                    zmenuVo.setMenulevel(menulevel);
                    zmenuVo.setMenustep(menustepmax1);
                    zmenuVo.setNvlType("MIN");
                    zmenuVo.setCond2("3");
                    zmenuVo.setSelType("menustep");

                    zmenuVo = zmenuDAO.getMenuStep(zmenuVo);

                    int menustepmax2 = zmenuVo.getMenustep();

                    zmenuVo.setSiteno(siteno);
                    zmenuVo.setMenutopno(menutopno);
                    zmenuVo.setMenulevel(menulevel);
                    zmenuVo.setMenustep(menustepmax1);
                    zmenuVo.setMenustep2(menustepmax2);
                    if (menustepmax2 > 0) {
                        zmenuVo.setCond1("1");
                    } else {
                        zmenuVo.setCond1("2");
                    }

                    List<ZmenuVo> vo = zmenuDAO.menuNoList(zmenuVo);

                    zmenuVo.setSiteno(siteno);
                    zmenuVo.setMenutopno(menutopno);
                    zmenuVo.setMenulevel(menulevel);
                    zmenuVo.setMenustep(menusteporg);
                    zmenuVo.setMenustep2(menustepmax1);
                    zmenuVo.setCond1("1");
                    List<ZmenuVo> vo2 = zmenuDAO.menuNoList(zmenuVo);

                    int step = 0;

                    for (ZmenuVo aavo : vo) {

                        if (step == 0) {
                            step = menusteporg;
                        } else {
                            step = step + 1;
                        }

                        zmenuVo.setMenustep(step);
                        zmenuVo.setMenuno(aavo.getMenuno());
                        zmenuDAO.updateMenu(zmenuVo);
                    }

                    for (ZmenuVo aavo : vo2) {

                        step = step + 1;

                        zmenuVo.setMenustep(step);
                        zmenuVo.setMenuno(aavo.getMenuno());
                        zmenuDAO.updateMenu(zmenuVo);
                    }

                }

            } else if (act.equals("u")) {

                zmenuVo.setNvlType("MAX");
                zmenuVo.setCond2("2");
                zmenuVo.setSelType("menustep");

                zmenuVo = zmenuDAO.getMenuStep(zmenuVo);

                int menustepmin1 = zmenuVo.getMenustep();

                if (menustepmin1 > 0) {

                    zmenuVo = new ZmenuVo();
                    zmenuVo.setSiteno(siteno);

                    zmenuVo.setMenutopno(menutopno);
                    zmenuVo.setMenuparentno(-1);
                    zmenuVo.setMenulevel(menulevel);
                    zmenuVo.setMenustep(menusteporg);
                    zmenuVo.setNvlType("MIN");
                    zmenuVo.setCond2("3");
                    zmenuVo.setSelType("menustep");

                    zmenuVo = zmenuDAO.getMenuStep(zmenuVo);

                    int menustepmin2 = zmenuVo.getMenustep();

                    zmenuVo.setSiteno(siteno);
                    zmenuVo.setMenutopno(menutopno);
                    zmenuVo.setMenulevel(menulevel);
                    zmenuVo.setMenustep(menusteporg);
                    zmenuVo.setMenustep2(menustepmin2);
                    if (menustepmin2 > 0) {
                        zmenuVo.setCond1("1");
                    } else {
                        zmenuVo.setCond1("2");
                    }

                    List<ZmenuVo> vo = zmenuDAO.menuNoList(zmenuVo);

                    zmenuVo.setSiteno(siteno);
                    zmenuVo.setMenutopno(menutopno);
                    zmenuVo.setMenulevel(menulevel);
                    zmenuVo.setMenustep(menustepmin1);
                    zmenuVo.setMenustep2(menusteporg);
                    zmenuVo.setCond1("1");
                    List<ZmenuVo> vo2 = zmenuDAO.menuNoList(zmenuVo);

                    int step = 0;

                    for (ZmenuVo aavo : vo) {

                        if (step == 0) {
                            step = menustepmin1;
                        } else {
                            step = step + 1;
                        }

                        zmenuVo.setMenustep(step);
                        zmenuVo.setMenuno(aavo.getMenuno());
                        zmenuDAO.updateMenu(zmenuVo);
                    }

                    for (ZmenuVo aavo : vo2) {

                        step = step + 1;

                        zmenuVo.setMenustep(step);
                        zmenuVo.setMenuno(aavo.getMenuno());
                        zmenuDAO.updateMenu(zmenuVo);
                    }

                }

            }

        } else {

            menutopnoorg = menutopno;

            zmenuVo.setSiteno(siteno);
            zmenuVo.setMenuno(menutopnoorg);
            zmenuVo.setMenutopno(-1);
            zmenuVo.setMenuparentno(-1);
            zmenuVo.setMenulevel(0);
            zmenuVo.setMenustep(1);
            zmenuVo.setCond2("1");
            zmenuVo.setSelType("menuno");

            if (act.equals("d")) {

                zmenuVo.setCond1("1");
                zmenuVo.setNvlType("MIN");

            } else if (act.equals("u")) {
                zmenuVo.setCond1("2");
                zmenuVo.setNvlType("MAX");

            }

            int menunonew = 0;

            zmenuVo = zmenuDAO.getMenuStep(zmenuVo);

            menunonew = zmenuVo.getMenuno();

            if (menunonew > 0) {

                zmenuVo.setSiteno(siteno);

                zmenuVo.setCond1("1");
                zmenuVo.setMenutopno(menutopnoorg);
                zmenuDAO.updateMenuTopno(zmenuVo);

                zmenuVo.setCond1("2");
                zmenuVo.setMenutopno(menutopnoorg);
                zmenuVo.setMenutopno2(menunonew);
                zmenuDAO.updateMenuTopno(zmenuVo);

                zmenuVo.setCond1("3");
                zmenuVo.setMenutopno(menunonew);
                zmenuDAO.updateMenuTopno(zmenuVo);

            }
        }

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
            Document doc = Jsoup.parseBodyFragment(list.get(i).getMenutags());
            Elements ztags = doc.select("call");
            list.get(i).setMenutags("");
            for (Element ztag : ztags) {
                if (list.get(i).getMenutags().contains(ztag.attr("type"))) {
                    Pattern p = Pattern.compile("\\d+");
                    Matcher m = p.matcher(list.get(i).getMenutags());
                    while (m.find()) {
                        String cntStr = m.group(0);
                        int cnt = Integer.parseInt(cntStr);
                        cnt++;
                        String cntPlus = String.valueOf(cnt);
                        list.get(i).setMenutags(list.get(i).getMenutags().replace(cntStr, cntPlus));
                    }
                } else {
                    list.get(i).setMenutags(list.get(i).getMenutags() + "," + ztag.attr("type") + "(1)");
                }
            }
        }
        model.addAttribute("list", list);
        //링크시 포트에 대한 대응을 위해 추가 20141111 김문석
        model.addAttribute("port", input.getRequest().getLocalPort() == 80 ? null : ":" + input.getRequest().getLocalPort());

        return model;
    }

    @Override
    public Model menuPopup(int siteno, Model model) throws Exception {

        ZsiteVo zsiteVo = new ZsiteVo();
        ZmenuVo zmenuVo = new ZmenuVo();

        //sitetitle, sitedomain 가져옴
        zsiteVo.setSiteno(siteno);
        zsiteVo = zsiteDAO.selectbypk(zsiteVo);
        model.addAttribute("sitetitle", zsiteVo.getSitetitle());

        //zmenu데이타 가져옴
        List<ZmenuVo> list = null;
        zmenuVo.setSiteno(siteno);
        list = this.zmenuDAO.selectbysiteno(zmenuVo);
        model.addAttribute("list", list);

        return model;
    }

    @Override
    public String getTitlePath(int menuno) throws Exception {
        return this.zmenuDAO.getTitlePath(menuno);
    }

    private String getHttpURLConnectionContents(String menuJspFilePath, HttpSession session, HttpServletRequest request) {
        HttpURLConnection connection = null;
        String menuconts = "";
        if (request.isSecure()) {
            menuJspFilePath = "https://" + menuJspFilePath;
        } else {
            menuJspFilePath = "http://" + menuJspFilePath;
        }

        try {
            connection = (HttpURLConnection) new URL(menuJspFilePath).openConnection();
            HttpURLConnection.setFollowRedirects(false);
            connection.setRequestProperty("Cookie", "JSESSIONID=" + session.getId());// 세션을 함께 넘겨준다
            connection.setConnectTimeout(15 * 000);
            connection.setReadTimeout(15 * 000);
            connection.connect();
            menuconts += StringUtil.getStringFromInputStream(connection.getInputStream());// 메뉴본문의 내용을 읽어와서 파싱...
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                connection.disconnect();
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return menuconts.equals("null") ? "" : menuconts;
    }

    /**
     * 내용 : 쿠키에 오늘 더이상 보지 않음이 적용되어 있는지 확인
     * 작성자 : 김문석
     * 작성시간  : 2013. 3. 28.
     * method_name : isClickNoMoreToday
     *
     * @param request
     * @param popupno
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private boolean isClickNoMoreToday(HttpServletRequest request, int popupno) throws ClassNotFoundException, IOException {
        boolean returnValue = false;

        HashMap<?, ?> map = (HashMap<?, ?>) CookieUtil.getObject(request, "popup_cookie");
        if (map == null) {
            return returnValue;
        }

        if (map.containsKey(popupno)) {
            returnValue = true;
        }
        return returnValue;
    }

    /**
     * 내용 : 쿠키에 오늘 더이상 보지 않음이 적용되어 있는지 확인
     * 작성자 : 이철순
     * 작성시간  : 2014. 6. 27.
     * method_name : isLayerClickNoMoreToday
     *
     * @param request
     * @param popupno
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private boolean isLayerClickNoMoreToday(HttpServletRequest request, int layerpopupno) throws ClassNotFoundException, IOException {
        boolean returnValue = false;

        HashMap<?, ?> map = (HashMap<?, ?>) CookieUtil.getObject(request, "layerpopup_cookie");
        if (map == null) {
            return returnValue;
        }

        if (map.containsKey(layerpopupno)) {
            returnValue = true;
        }
        return returnValue;
    }

    /************************************************************************************************
     * 기생성된 템플릿 파일이 없을 경우 다시 생성을 함.
     ************************************************************************************************/
    private void writeFileIfNotExist(String name, int siteno, int menuno, String contents) {

        File f = new File(EgovProperties.getPathProperty("Globals.template.menu") + File.separator + name + ".jsp");
        try {
            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.menu"), name, contents)) {
                System.out.println("menu template making successed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
