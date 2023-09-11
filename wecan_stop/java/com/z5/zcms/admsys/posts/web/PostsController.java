package com.z5.zcms.admsys.posts.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.z5.zcms.admsys.posts.domain.PostsVo;
import com.z5.zcms.admsys.posts.service.PostsService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.SecuritySessionUtil;

import egovframework.com.cmm.service.EgovProperties;

@Controller
@RequestMapping(value="/admsys/posts")
public class PostsController {

	@Autowired
	private PostsService postsService;

	@Autowired
	ZUserService zUserService;


	private final String RETURN_URL = "/zcms/admsys/posts/";

	@RequestMapping(value={"", "index.html"})
	public String list(
			@ModelAttribute("postsVo") PostsVo postsVo,
			Model model, HttpServletRequest req) throws Exception {
		try {
			postsVo.setUserid(SecuritySessionUtil.getUserid(req));
			int boardno = postsVo.getBoardno();
			/*if (boardno==0) boardno = 1;*/

			postsVo.setBoardno(boardno);
			postsVo.setTblname(postsService.getTblName(postsVo));

			DataTable input = new DataTable(req);
			int pageSize = input.getInt("pageSize", 10);
			if (input.getInt("pageIndex")==0){
				input.put("pageIndex", 1);
			}
			int pageIndex = input.getInt("pageIndex") - 1;
			String sdate = input.get("sdate");
			String edate = input.get("edate");
			String keyword = input.get("keyword");
			int m = pageIndex * pageSize;
			int n = pageSize;

			if(sdate.equals("") && edate.equals("") ){
				postsVo.setCond1("");
			}else{
				postsVo.setCond1(input.get("cond1"));
			}
			if(keyword.equals("")){
				postsVo.setCond2("");
			}else{
				postsVo.setCond2(input.get("cond2"));
			}

			postsVo.setSdate(input.get("sdate"));
			postsVo.setEdate(input.get("edate"));
			postsVo.setKeyword(input.get("keyword"));
			postsVo.setM(m);
			postsVo.setN(n);

			List<PostsVo> list = null;
			String type = null;
			int total = 0;

			if(boardno != 0 && postsVo.getTblname() != null){
				total = postsService.listCount(postsVo);
				list = postsService.getPostsList(postsVo);
				type = postsService.replyyn(postsVo);

				model.addAttribute("list", list);
				model.addAttribute("type", type);
			}else if(boardno != 0 && postsVo.getTblname() == null){
				boardno = -1;
				postsVo.setBoardno(boardno);
			}

			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax", (int)Math.ceil((double)total/pageSize));

			model.addAttribute("input", input);
			model.addAttribute("tblname", postsVo.getTblname());
			model.addAttribute("boardno", boardno);

		}catch(Exception e){
			e.printStackTrace();
		}
		return RETURN_URL + "index";
	}

	@RequestMapping(value="view.html", method=RequestMethod.GET)
	public String view(
			@ModelAttribute("postsVo") PostsVo postsVo,
			Model model, HttpServletRequest req) throws Exception {
		try {

			List<PostsVo> list = postsService.getPostsView(postsVo);

			//결제자 정보 가져오기
			/*String aprovyn = postsService.getaprovyn(postsVo);
			postsVo.setAprovyn(aprovyn);
			if(aprovyn.equals("1")){
				int bbsno = list.get(1).getBbsno();
				List<PostsVo> aprovinfo = postsService.aprovinfo(bbsno);
				if(!(aprovinfo.isEmpty())){
					model.addAttribute("aprov_name", aprovinfo.get(0).getUsername());
					model.addAttribute("dept_nm", aprovinfo.get(0).getDept_nm());
					model.addAttribute("work_title", aprovinfo.get(0).getWork_title());
					model.addAttribute("work_grade", aprovinfo.get(0).getWork_grade());
				}
			}*/

			if (list.size()==1){
				postsVo.setUserid(SecuritySessionUtil.getUserid(req));
				ZUserVo zUserVo = new ZUserVo();
				zUserVo.setUserid(postsVo.getUserid());
				zUserVo = zUserService.getInfo(zUserVo);
				postsVo.setBbsusername(zUserVo.getUsername());
				postsVo.setBbsuseremail(zUserVo.getUseremail());
				postsVo.setBbsuserhomepage(zUserVo.getUserhomepage());
				postsVo.setBbsusertel(zUserVo.getUsertel());
				postsVo.setBbsusermobile(zUserVo.getUsermobile());
				postsVo.setBbsuseraddr(zUserVo.getUseraddrno()+"Æ"+zUserVo.getUseraddr()+"Æ"+zUserVo.getUseraddr2());
				postsVo.setDept_nm(zUserVo.getDept_nm());
				list.add(postsVo);
				model.addAttribute("act", "reply");
			}
			else if (list.size()==2){
				ZUserVo zUserVo = new ZUserVo();
				zUserVo.setUserid(list.get(1).getUserid());
				zUserVo = zUserService.getInfo(zUserVo);
				list.get(1).setDept_nm(zUserVo.getDept_nm());
				model.addAttribute("act", "edit");
			}

			model.addAttribute("list", list);
			model.addAttribute("aprovyn", postsVo.getAprovyn());
			model.addAttribute("tblname", postsVo.getTblname());
			model.addAttribute("boardno", postsVo.getBoardno());

		}catch(Exception e){
			e.printStackTrace();
		}
		return RETURN_URL + "view";
	}

	@RequestMapping(value="delete.html")
	public String delete(
			@RequestParam("bbsno") String[] bbsno,
			@ModelAttribute("postsVo") PostsVo postsVo) throws Exception {
		try {
			String bbsnos = StringUtils.join(bbsno,",");
			String upload = EgovProperties.getPathProperty("Globals.upload.board");
			postsVo.setBbsnos(bbsnos);
			List<PostsVo> fileList = postsService.delete(postsVo);
			String[] filePath = new String[fileList.size()];
			for(int i=0; i<fileList.size();i++){
				PostsVo vo = fileList.get(i);
				filePath[i] = upload + postsVo.getTblname() + File.separator + vo.getBbsfilesave();
			}
			FileUtil.deleteFile(StringUtils.join(filePath,","));

		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:index.html?boardno="+postsVo.getBoardno();
	}

//	@RequestMapping(value="{page}.html", method=RequestMethod.POST)
//	public String write(
//			@PathVariable("page") String page,
//			@ModelAttribute("postsVo") PostsVo postsVo,
//			Model model, HttpServletRequest req) throws Exception {
//
//		String flag = "0";
//		int bbsno = postsVo.getBbsno();
//		int boardno = postsVo.getBoardno();
//		String replyyn = postsService.replyyn(postsVo);
//		String aprovyn = postsService.getaprovyn(postsVo);
//		postsVo.setReplyyn(replyyn);
//		postsVo.setAprovyn(aprovyn);
//		try {
//			MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
//
//			//수정시 thumb의 내용이 사라지는 것을 막기위해 기존의 것을 받아와서 미리 값을 넣어놓는다. 20140522 김문석
//			postsVo.setSponsor(req.getParameter("thumb_ori_h"));
//			postsVo.setPlace(req.getParameter("thumb_save_h"));
//			//수정시 thumb의 내용이 사라지는 것을 막기위해 기존의 것을 받아와서 미리 값을 넣어놓는다. 20140522 김문석
//
///*			if ("delete".equals(postsVo.getAct())){
//				postsVo.setBbsno(Integer.parseInt(req.getParameter("rbbsno")));
//				String upload = EgovProperties.getPathProperty("Globals.upload.board");
//				List<PostsVo> fileList = postsService.delete(postsVo);
//				String[] filePath = new String[fileList.size()];
//				for(int i=0; i<fileList.size();i++){
//					PostsVo vo = fileList.get(i);
//					filePath[i] = upload + postsVo.getTblname() + File.separator + vo.getBbsfilesave();
//				}
//				FileUtil.deleteFile(StringUtils.join(filePath,","));
//			}
//			else{
//*/				ArrayList<String> fileorg = new ArrayList<String>();
//				ArrayList<String> filesave = new ArrayList<String>();
//				ArrayList<String> filetyp = new ArrayList<String>();
//				Iterator<String> fileIter = multi.getFileNames();
//				while (fileIter.hasNext()){
//					MultipartFile mFile = multi.getFile((String)fileIter.next());
//					String thumbname = mFile.getName();
//					if (mFile.getSize()>0){
//						String upload = EgovProperties.getPathProperty("Globals.upload.board");
//						HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile,"Globals.upload.board");
//						String bbsfilesave = map.get(Globals.UPLOAD_FILE_NM) +"."+ map.get(Globals.FILE_EXT);
//						//new File(upload+map.get(Globals.UPLOAD_FILE_NM)).renameTo(new File(upload+bbsfilesave));
//						EgovFileMngUtil.writeUploadedFile(mFile,bbsfilesave,upload+postsVo.getTblname());
//						FileUtil.deleteFile(upload+map.get(Globals.UPLOAD_FILE_NM));
//
//						String bbsfileorg = map.get(Globals.ORIGIN_FILE_NM);
//
//
//						if(thumbname.equals("thumb")){
//							postsVo.setPlace(bbsfilesave);//썸네일 저장이름을 place에 넣는 걸로 수정한다. 김문석 20140521
//							postsVo.setSponsor(bbsfileorg);//썸네일 원래이름을 sponsor에 넣는 걸로 수정한다. 김문석 20140521
//						}else{
//							fileorg.add(bbsfileorg);
//							filesave.add(bbsfilesave);
//							filetyp.add(mFile.getContentType());
//						}
//
//					}
//				}
//
//				//postsVo.setAct(postsVo.getAct());
//				//postsVo.setTblname(postsVo.getTblname());
//				//postsVo.setUserid(SecuritySessionUtil.getUserid(req));
//
//				postsVo.setBbsip(IpUtil.getIpAddr(req));
//				//postsVo.setBoardno(postsVo.getBoardno());
//				postsVo.setBbssecret("0");
//
//				String[] filealt = req.getParameterValues("attachFileAlt");
//				String[] fileno = req.getParameterValues("hbbsfileno");
//				ArrayList<String> filelist = new ArrayList<String>();
//				ArrayList<String> altlist = new ArrayList<String>();
//				for(int i = 0; filealt !=null && i < filealt.length; i++) {
//					if (fileno!=null){
//						if(i<fileno.length){
//							altlist.add(filealt[i].trim().equals("")?null:filealt[i].trim());
//						}
//						else{
//							if (fileorg.size() > 0){
//								if (i-fileno.length < fileorg.size()){
//									String alt = filealt[i].isEmpty() ? null : filealt[i].trim();
//									filelist.add("('" + fileorg.get(i-fileno.length) + "','" + filesave.get(i-fileno.length) + "',0,null,'" + alt + "','" + filetyp.get(i-fileno.length) + "',0)");
//								}
//							}
//						}
//					}
//					else{
//						if (fileorg.size()>i){
//							String alt = filealt[i].isEmpty() ? null : filealt[i].trim();
//							filelist.add("('" + fileorg.get(i) + "','" + filesave.get(i) + "',0,null,'" + alt + "','" + filetyp.get(i) + "',0)");
//						}
//					}
//				}
//
//				postsVo.setUserid(SecuritySessionUtil.getUserid(req));
//				postsVo.setUsername(postsService.getusername(postsVo));
//				postsVo.setUserno(postsService.getuserno(postsVo));
//				ZUserVo zUserVo = new ZUserVo();
//
//				String ztag = StringUtil.makeElementAndBase64(Integer.toString(boardno), "board", postsService.getskin(postsVo));
//
//				if (!postsVo.getUserid().isEmpty()){
//					zUserVo.setUserid(postsVo.getUserid());
//					zUserVo = zUserService.getInfo(zUserVo);
//
//					postsVo.setBbsusername(zUserVo.getUsername());
//					postsVo.setBbsuseremail(null!=postsVo.getBbsuseremail() ? postsVo.getBbsuseremail().trim() : zUserVo.getUseremail());
//					postsVo.setBbsuserhomepage(zUserVo.getUserhomepage());
//					postsVo.setBbsusertel(null!=postsVo.getBbsusertel() ? postsVo.getBbsusertel().trim() : zUserVo.getUsertel());
//					postsVo.setBbsusermobile(zUserVo.getUsermobile());
//					postsVo.setBbsuseraddr(null!=zUserVo.getUseraddrno() ? zUserVo.getUseraddrno()+"Æ"+zUserVo.getUseraddr()+"Æ"+zUserVo.getUseraddr2() : null);
//				}
//
//				if (postsVo.getAct().equals("edit")){
//					if (postsVo.getReplyyn().equals("1")){
//						postsVo.setBbsno(Integer.parseInt(req.getParameter("rbbsno")));
//					}
//				}
//
//				postsVo.setBbsnotice(multi.getParameter("bbsnotice"));
//				postsVo.setBbsopen(multi.getParameter("bbsopen"));
//
//				//if (SecuritySessionUtil.isAuth(req, "ROLE_ADMIN")||SecuritySessionUtil.isAuth(req, "ROLE_SUPER")) postsVo.setAdminyn("1");
//				//else postsVo.setAdminyn("0");
//				postsVo.setAdminyn("0");
//
//				postsVo.setBbsfile(filelist.size() > 0 ? StringUtils.join(filelist.toArray(),"Æ") : null);
//				postsVo.setBbsfilealts(null);
//				postsVo.setBbsfilenos(fileno!=null && fileno.length > 0 ? StringUtils.join(fileno,",") : null);
//				postsVo.setBbscontstype("3");
//				if (postsVo.getAct().equals("reply")) postsVo.setBbstitle("[RE]:"+postsVo.getBbstitle());
//				postsVo.setBbsconts(postsVo.getBbsconts().trim().equals("") ? null : postsVo.getBbsconts().trim());
//				postsVo.setSiteno(0);
//
//				int no = postsService.save(postsVo);
//
//				if(postsVo.getAprovyn().equals("1")){
//
//					ZAprovVO zAprovVO = new ZAprovVO();
//					zAprovVO.setReg_psn(Integer.parseInt(postsVo.getUserno()));
//					zAprovVO.setReg_nm(postsVo.getUsername());
//					zAprovVO.setAprov_type(1);//1:게시판,2:아카이브,3:행사
//					if (postsVo.getReplyyn().equals("1")){
//						zAprovVO.setBbsno(Integer.toString(no));
//						zAprovVO.setBoardno(Integer.parseInt(req.getParameter("rboardno")));
//						zAprovVO.setOribbsno(bbsno);//원글 bbsno
//						zAprovVO.setOriboardno(boardno);//원글 boardno
//					}else{
//						zAprovVO.setBbsno(Integer.toString(no));
//						zAprovVO.setBoardno(boardno);
//					}
//					zAprovVO.setTblname(postsVo.getTblname());
//					zAprovVO.setTbltitle(postsService.gettbltitle(postsVo));
//					zAprovVO.setTitle(postsVo.getBbstitle().trim());
//					zAprovVO.setSiteno(Integer.toString(postsVo.getSiteno()));
//					zAprovVO.setMenuno(postsService.getmenuno(postsVo));
//					zAprovVO.setZtag(ztag);
//					zAprovVO.setAprov_psn(Integer.parseInt(req.getParameter("aprov_psn")));//결제자 userno
//
//					String act = "write";
//
//					/*if(postsVo.getAct().equals("edit")){
//						act = "modify";
//					}else{
//						act = "write";
//					}*/
//
//					zAprovService.insert(zAprovVO,act);
//
//					//결제를 이용하면 shw_yn을 0으로 수정
//					//결제모듈을 타면 그때 값을 바꿔주기 때문에 여기에는 shw_yn값이 들어있지 않기 때문에
//					//강제로 지정을 해준다.
//					//frontBoardVo.setShw_yn(0);
//				}
//
//				if ("write".equals(postsVo.getAct())) bbsno = no;
//
//				if (no>0) flag = "1";
////			}
//
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//		return "redirect:"+page+".html?boardno="+boardno+"&bbsno="+bbsno+"&tblname="+postsVo.getTblname()+"&flag="+flag;
//	}

	@RequestMapping(value="write.html", method=RequestMethod.GET)
	public String notice(
			@ModelAttribute("postsVo") PostsVo postsVo,
			Model model, HttpServletRequest req) throws Exception {

		try {

			List<PostsVo> list = new ArrayList<PostsVo>();
			String aprovyn = postsService.getaprovyn(postsVo);
			postsVo.setAprovyn(aprovyn);

			postsVo.setUserid(SecuritySessionUtil.getUserid(req));
			if (postsVo.getBbsno() > 0) {
				list = postsService.getPostsView(postsVo);

				if(aprovyn.equals("1")){
					int bbsno = list.get(0).getBbsno();
					List<PostsVo> aprovinfo = postsService.aprovinfo(bbsno);
					if(!(aprovinfo.isEmpty())){
						model.addAttribute("aprov_name", aprovinfo.get(0).getUsername());
						model.addAttribute("dept_nm", aprovinfo.get(0).getDept_nm());
						model.addAttribute("work_title", aprovinfo.get(0).getWork_title());
						model.addAttribute("work_grade", aprovinfo.get(0).getWork_grade());
					}
				}
			}
			else{
				ZUserVo zUserVo = new ZUserVo();
				zUserVo.setUserid(postsVo.getUserid());
				zUserVo = zUserService.getInfo(zUserVo);
				postsVo.setBbsusername(zUserVo.getUsername());
				list.add(postsVo);
			}

			model.addAttribute("act", postsVo.getBbsno() > 0 ? "edit" : "write");

			model.addAttribute("detail", list.get(0));
			model.addAttribute("tblname", postsVo.getTblname());
			model.addAttribute("boardno", postsVo.getBoardno());
			model.addAttribute("aprovyn", postsVo.getAprovyn());

		}catch(Exception e){
			e.printStackTrace();
		}
		return RETURN_URL + "write";
	}

	@RequestMapping(value="down.html")
	public ModelAndView down(
			@ModelAttribute("postsVo") PostsVo postsVo,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		try {
			String upload = EgovProperties.getPathProperty("Globals.upload.board");
			String tblname = postsVo.getTblname();
			postsVo = postsService.attach(postsVo);
			postsVo.setBbsfilesave(upload + tblname + File.separator + postsVo.getBbsfilesave());
			req.setAttribute("fileorg", postsVo.getBbsfileorg());
			req.setAttribute("filesave", postsVo.getBbsfilesave());
			req.setAttribute("filetype", "application/octet-stream");
			FileUtil.downFile(req,res);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value="delattach.html")
	public ModelAndView delattach(
			@ModelAttribute("postsVo") PostsVo postsVo) throws Exception {
		try {
			String bbsfilesave = postsService.deleteAttach(postsVo);
			FileUtil.deleteFile(EgovProperties.getPathProperty("Globals.upload.board")+postsVo.getTblname()+File.separator+bbsfilesave);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value="lnb.html")
	public String lnb(
			@ModelAttribute("postsVo") PostsVo postsVo,
			HttpServletRequest req,
			Model model) throws Exception {

		try{
			postsVo.setUserid(SecuritySessionUtil.getUserid(req));
			List<PostsVo> lnbList = postsService.lnbList(postsVo);

			model.addAttribute("lnbList", lnbList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return RETURN_URL + "lnb";
	}

}
