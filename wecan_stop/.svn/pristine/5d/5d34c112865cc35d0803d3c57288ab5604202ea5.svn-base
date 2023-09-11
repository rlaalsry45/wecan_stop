package com.z5.zcms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.z5.zcms.admsys.board.dao.ZBoardDAO;
import com.z5.zcms.admsys.board.dao.ZBoardGroupDAO;
import com.z5.zcms.admsys.board.domain.ZBoardAuthAdminVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

public class BoardAdminAuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private ZBoardDAO zBoardDAO;

	@Autowired
	private ZBoardGroupDAO zBoardGroupDAO;

	@Override
	public boolean preHandle(
		HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		DataTable dt = new DataTable(request);
		boolean pass = false;
		String url = request.getRequestURI();
		HttpSession session = request.getSession(false);

		if (null==session.getAttribute("authPassport")){
			session.setAttribute("authPassport", SecuritySessionUtil.isAuth(dt.getRequest(), "ROLE_SUPER") ? 0 : (zBoardGroupDAO.boardGroupAdminCount(((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno())>0 ? 1 : 99));
		}

		if ((Integer)session.getAttribute("authPassport")!=0){
			session.setAttribute("authPassport", SecuritySessionUtil.isAuth(dt.getRequest(), "ROLE_ADMIN") ? 0 : (zBoardGroupDAO.boardGroupAdminCount(((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno())>0 ? 1 : 99));
		}



		if (url.indexOf("delete")<0){
			ZBoardAuthAdminVo zBoardAuthAdminVo = new ZBoardAuthAdminVo();
			zBoardAuthAdminVo.setBoardno(dt.getInt("boardno"));
			zBoardAuthAdminVo.setUserno(((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());
			if ((Integer)session.getAttribute("authPassport")==99){
				session.setAttribute("authPassport", zBoardDAO.boardAdminBoard(zBoardAuthAdminVo)>0 ? 2 : 99);
			}
		}

		if (url.indexOf("group")>0){
			if((Integer)session.getAttribute("authPassport")<1){
				pass = true;
			}
			else{
				pass = false;
			}
		}
		else if (url.indexOf("posts")>0){
			if((Integer)session.getAttribute("authPassport")<1){
				pass = true;
			}
			else{
				// 그룹관리자일 경우 본인이 속한 그룹의 게시판만 글관리
				// 게시판관리자일 경우 본인이 속한 게시판만 글관리
				ZBoardVo zBoardVo = new ZBoardVo();
				zBoardVo.setBoardno(dt.getInt("boardno"));
				zBoardVo.setAdminno(((ZUserVo)SecuritySessionUtil.getUserVo(dt.getRequest())).getUserno());
				if (zBoardDAO.boardPostsAuthChk(zBoardVo)>0){
					pass = true;
				}
				else{
					pass = false;
				}
			}
		}
		else{
			if (url.indexOf("insert")>0||url.indexOf("boardCopy")>0||url.indexOf("boardCate")>0||url.indexOf("boardAdminSearch")>0||url.indexOf("delete")>0){
				if((Integer)session.getAttribute("authPassport")<2){
					pass = true;
				}
				else{
					pass = false;
				}
			}
			else if (url.indexOf("update")>0){
				if((Integer)session.getAttribute("authPassport")<3){
					pass = true;
				}
				else{
					pass = false;
				}
			}
			else{
				pass = true;
			}
		}

		if (!pass){

			System.out.println("1111111111111111");

			session.getServletContext().getRequestDispatcher("/WEB-INF/jsp/board_noauth.jsp").include(request, response);

			//RequestDispatcher dispatch=request.getRequestDispatcher("/WEB-INF/jsp/board_noauth.jsp");
			//dispatch.forward(request, response);
		}

		return pass;
	}

	@Override
	public void postHandle(
		HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{};

	@Override
	public void afterCompletion(
		HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{};
}
