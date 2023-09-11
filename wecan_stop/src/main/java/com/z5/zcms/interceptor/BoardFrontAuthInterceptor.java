package com.z5.zcms.interceptor;

import static com.z5.zcms.util.ZPrint.enter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.z5.zcms.admsys.board.dao.FrontBoardDAO;
import com.z5.zcms.admsys.board.dao.ZBoardRoleDAO;
import com.z5.zcms.admsys.board.domain.FrontBoardVo;
import com.z5.zcms.admsys.board.domain.ZBoardAuthVo;
import com.z5.zcms.admsys.board.domain.ZBoardRoleVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.service.FrontBoardService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.StringUtil;

/**
 * @author cklee E-mail: ykslck@gmail.com
 * @version create：2014年4月1日 上午9:40:00
 *          Class declaration
 */

@Component("frontBoardAuthFilter")
public class BoardFrontAuthInterceptor extends HandlerInterceptorAdapter {
    //private FilterConfig config;

    @Autowired
    MessageSource messageSource;
    @Autowired
    private ZBoardRoleDAO zBoardRoleDAO;
    @Autowired
    private FrontBoardDAO frontBoardDAO;
    @Autowired
    FrontBoardService frontBoardService;
    
    @SuppressWarnings("null")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        boolean      pass                = false;
        String       act                 = "";
        HttpSession  session             = request.getSession(false);
        String       cert_on             = "";

        enter();
        try {       	

            DataTable dt = new DataTable(request);

            session.setAttribute("frontAuthPassport", null);
            if (!dt.get("ztag").isEmpty()) {
                Document doc   = Jsoup.parseBodyFragment(StringUtil.getObjectFromBase64(dt.get("ztag")));
                Elements ztags = doc.select("call");
                dt.put("no", ztags.get(0).attr("no"));
            } else {
                dt.put("no", String.valueOf(request.getAttribute("no")));
                dt.put("act", String.valueOf(request.getAttribute("act")));
            }
        	
            ZBoardAuthVo zBoardAuthVo = new ZBoardAuthVo();
            zBoardAuthVo.setBoardno(dt.getInt("no"));
             
            List<ZBoardAuthVo> authList = new ArrayList<ZBoardAuthVo>();
            act = dt.get("act", "list");
            
    		Class<ZBoardAuthVo> Class = ZBoardAuthVo.class;
        	
        	act = ((String) act.subSequence(0, 1)).toLowerCase();
        	act = "p".equals(act) || "n".equals(act) ? "v" : ("e".equals(act) ? "m" : act);
        	
        	Method method = Class.getMethod("getRole_" + act);
           
        	List<ZBoardRoleVo> zboardRoleList = zBoardRoleDAO.getRoleList();
        	
        	List<String> securityAuths = SecuritySessionUtil.getAuths(request);
            
        	if (securityAuths.isEmpty()) {//비로그인일 경우 게시판 각 화면을 진입할수 있는지 체크
            	
            	List<String> roles = new ArrayList<String>();
            	
            	for (ZBoardRoleVo roleVo : zboardRoleList) {
            		if ("GINUE_NONE".equals(roleVo.getRole()) || "GINUE_CERT".equals(roleVo.getRole())) roles.add(roleVo.getRole());
            	}
            	if (!roles.isEmpty()) {
                	            		
            		if (2==roles.size()) {//비회원 본인인증 둘다 있는 경우
                    	zBoardAuthVo.setRoles(roles);
                    	authList = zBoardRoleDAO.getMixedAuthListByBoardnoAndRoleNew(zBoardAuthVo);
                    	                   	
                    	ZBoardAuthVo GNVo = new ZBoardAuthVo();
                    	ZBoardAuthVo GCVo = new ZBoardAuthVo();
                    	
                    	for (ZBoardAuthVo authVo : authList) {
                    		if ("GINUE_NONE".equals(authVo.getRole())) GNVo = authVo;
                    		if ("GINUE_CERT".equals(authVo.getRole())) GCVo = authVo;
                    	}
                    	
                    	String gnResult = (String) method.invoke(GNVo);
                    	String gcResult = (String) method.invoke(GCVo);
                    	if ("0".equals(gnResult) && "0".equals(gcResult)) {//권한없음
                            //request.setAttribute("cert_on", cert_on);
                            //request.setAttribute("url", request.getRequestURL());
                            //session.getServletContext().getRequestDispatcher("/WEB-INF/jsp/board_noauth.jsp").include(request, response);
                    		
                    		pass = false;
                    	}
                    	else if ("0".equals(gnResult)&&!"0".equals(gcResult)) {//본인인증만 체크시
            				if (null==session.getAttribute("sDupInfo")) {
            		            //ZBoardVo zBoardVo = new ZBoardVo();
            		            //zBoardVo.setBoardno(Integer.parseInt(dt.get("no")));
            		            //zBoardVo = frontBoardService.config(zBoardVo);//인증화면 메뉴번호를 가져온다.
            		            //session.getServletContext().getRequestDispatcher("/WEB-INF/jsp/board_noauth.jsp").include(request, response);
            					
            		            pass = false;
            				}
            				else {
             		        	session.setAttribute("frontAuthPassport", GCVo);
             					pass = true;
            				}
                    	}
                    	else if (!"0".equals(gnResult)&&"0".equals(gcResult)) {//비회원만 체크시
                    		session.setAttribute("frontAuthPassport", GNVo);
                    		pass = true;
                    	}
                    	else if (!"0".equals(gnResult)&&!"0".equals(gcResult)) {
                    		//비회원과 본인인증 둘다 체크시 본인인증해도 권한이 가지고 인증하지 않아도 권한을 가진다. 
                    		//둘다 체크 했다는 의미는 같은 권한을 가지고 있다는것이다.
                    		//때문에 GNVo권한을 주나 GCVo권한을 주나 같은 것이다. 단 인증했을 경우 이름이 있기때문에 이름이 표시될것이다. 쓰기시에도 sDupInfo가 insert될것임
            				
                    		session.setAttribute("frontAuthPassport", GNVo);
                    		pass = true;
                    	}

            		}
            		else if (1==roles.size()) {//비회원 혹은 본인인증 중 하나만 있는 경우
                    	zBoardAuthVo.setRoles(roles);
                    	authList = zBoardRoleDAO.getMixedAuthListByBoardnoAndRoleNew(zBoardAuthVo);

                    	ZBoardAuthVo GVo = authList.get(0);
            			
                    	if ("GINUE_NONE".equals(GVo.getRole())) {//비회원만 있는 경우
                        	String gnResult = (String) method.invoke(GVo);
                        	if ("0".equals(gnResult)) {//권한없음
                                //request.setAttribute("cert_on", cert_on);
                                //request.setAttribute("url", request.getRequestURL());
                                //session.getServletContext().getRequestDispatcher("/WEB-INF/jsp/board_noauth.jsp").include(request, response);
                        		
                        		pass = false;
                        	}
                        	else if (!"0".equals(gnResult)) {//권한있음
                        		
                        		session.setAttribute("frontAuthPassport", GVo);
                        		pass = true;
                         	}
            			}
            			else if ("GINUE_CERT".equals(GVo.getRole())) {//본인인증만 있는 경우
                        	String gcResult = (String) method.invoke(GVo);
                        	if ("0".equals(gcResult)) {//권한없음
                                //request.setAttribute("cert_on", cert_on);
                                //request.setAttribute("url", request.getRequestURL());
                                //session.getServletContext().getRequestDispatcher("/WEB-INF/jsp/board_noauth.jsp").include(request, response);
                        		
                        		pass = false;
                        	}
                        	else if (!"0".equals(gcResult)) {//권한있음
                				if (null==session.getAttribute("sDupInfo")) {
                					
                					pass = false;//본인 인증화면으로 보냄
                				}
                				else {
                					
                					if ("v".equals(act)) {//뷰페이지에서 수정 삭제 권한이 있다 하더라고 자기 글만 수정 삭제함
                						//내가 쓴 글인지 체크를 하는 부분
                						ZBoardVo zBoardVo = new ZBoardVo();
                						zBoardVo.setBoardno(dt.getInt("no"));
	                					zBoardVo = frontBoardDAO.config(zBoardVo);
	                					
	                					FrontBoardVo frontBoardVo = new FrontBoardVo();
	                					
	                					frontBoardVo.setTblname(zBoardVo.getTblname());
	                					frontBoardVo.setBbsno(dt.getInt("bbsno"));
	                					
	                					frontBoardVo = frontBoardDAO.getBoardRow(frontBoardVo);
	                					
	                					if (!frontBoardVo.getUserid().equals((String)session.getAttribute("sDupInfo"))) {// 본인 글이 아니면 수정 삭제 박탈
	                						GVo.setRole_d("0"); 
	                						GVo.setRole_m("0");
	                					}
                					}
                					session.setAttribute("frontAuthPassport", GVo);
                					pass = true;
                				}
                         	}
            			}
            		}
            		else {
                		//비회원 룰이 없음
                		pass = false;
            		}
                }
            	else {
            		//비회원 룰이 없음
            		pass = false;
            	}
            }
            else { //로그인일 경우 게시판 각 화면을 진입할수 있는지 체크
            	zBoardAuthVo.setRoles(securityAuths);//로그인시 원래는 슈퍼/어드민/사용자 세개 권한 동시에 들어옴.(현재 수정하여 한개만 들어옴)
            	authList = zBoardRoleDAO.getMixedAuthListByBoardnoAndRoleNew(zBoardAuthVo);

            	if (1==authList.size()) {
            		
            		ZBoardAuthVo RVo = authList.get(0);
            		
                	String rResult = (String) method.invoke(RVo);
                	
                	if ("0".equals(rResult)) {
                        //request.setAttribute("cert_on", cert_on);
                        //request.setAttribute("url", request.getRequestURL());
                        //session.getServletContext().getRequestDispatcher("/WEB-INF/jsp/board_noauth.jsp").include(request, response);
                		
                		pass = false;
                	}
                	else {
    					if ("v".equals(act)) {//뷰페이지에서 수정 삭제 권한이 있다 하더라고 자기 글만 수정 삭제함
    						if (SecuritySessionUtil.isAdmin(request) || SecuritySessionUtil.isSuper(request)) {
    							//슈퍼 혹은 관리자 일 경우
    						}
    						else {
	    						if (!SecuritySessionUtil.getUserid(request).isEmpty() && SecuritySessionUtil.isUser(request, SecuritySessionUtil.getUserid(request))) {//보통 회원일 경우
		    						//내가 쓴 글인지 체크를 하는 부분
		    						ZBoardVo zBoardVo = new ZBoardVo();
		    						zBoardVo.setBoardno(dt.getInt("no"));
		        					zBoardVo = frontBoardDAO.config(zBoardVo);
		        					
		        					FrontBoardVo frontBoardVo = new FrontBoardVo();
		        					
		        					frontBoardVo.setTblname(zBoardVo.getTblname());
		        					frontBoardVo.setBbsno(dt.getInt("bbsno"));
		        					
		        					frontBoardVo = frontBoardDAO.getBoardRow(frontBoardVo);
		        					
		        					if (!frontBoardVo.getUserid().equals(SecuritySessionUtil.getUserid(request))) {// 본인 글이 아니면 수정 삭제 박탈
		        						RVo.setRole_d("0"); 
		        						RVo.setRole_m("0");
		        					}
	    						}
    						}
    					}
        				session.setAttribute("frontAuthPassport", RVo);
        				pass = true;
                	}
                	
                	
            	}
            	else {//로그인한 누구나 권한 없음
            		pass = false;
            	}
            }        	
        	
        	
        	

//                //모든 권한을 가져오기 위해 담는다.
//                ZBoardAuthVo zBoardAuthVo = new ZBoardAuthVo();
//                zBoardAuthVo.setBoardno(dt.getInt("no"));
//                zBoardAuthVo.setRoles(securityAuths);
//
//                //통합된 권한을 가져온다. 메트릭스 형태의 권한이다. 자신의 권한과 게시판 권한을 합하여 각 권한의 종류를 모두가져온다.
//                zBoardAuthVo = zBoardRoleDAO.getMixedAuthListByBoardnoAndRole(zBoardAuthVo);
//
//                //통합정보를 가져와서 권한 분별 세션 frontAuthPassport에 담는다.
//                if (null != zBoardAuthVo) {
//                    //role_no = String.valueOf(zBoardAuthVo.getRole_no());
//                    session.setAttribute("frontAuthPassport", zBoardAuthVo);
//                }
//
//                //본인인증체크를 위해 GINUE_CERT에 해당하는 권한 요소를 가져온다.
//                zBoardAuthVoForCert = new ZBoardAuthVo();
//                zBoardAuthVoForCert.setBoardno(dt.getInt("no"));
//                zBoardAuthVoForCert.setRole("GINUE_CERT");
//                zBoardAuthVoForCert = zBoardRoleDAO.getAuthListByBoardnoAndRole(zBoardAuthVoForCert);
//
//                //각 게시판의 권한을 실재로 체크하는 부분
//                if (null != session.getAttribute("frontAuthPassport")) {
//                    zBoardAuthVo = (ZBoardAuthVo) session.getAttribute("frontAuthPassport");
//
//                    act = dt.get("act", "list");
//                    if (act=="list") {
//                            if (!zBoardAuthVo.getRole_l().equals("0")) { // 0은 해당 권한에 대한 접근 권한이 없음을 의미한다. 즉 리스트 보기 권한이 있다면
//                                pass = true;
//                            } else {
//                                //본인인증 role_l이 체크되어 있는 경우 권한없음을 나타내는 메시지에 본인인증을 하면 볼수 있다는 메시지를 추가한다.
//                                /*if(!zBoardAuthVoForCert.getRole_l().equals("0")){
//                                    cert_on = "cert_on";
//								}*/
//                                pass = false;
//                            }
//                    }
//                    else if (act=="view"||act=="prev"||act=="next") {
//                            session.setAttribute("mode2", "0"); //mode2가 1이면  view화면에서 수정과 삭제를 표시한다.
//
//                            ZBoardVo zBoardVo = new ZBoardVo();
//                            zBoardVo.setBoardno(dt.getInt("no"));
//                            zBoardVo = frontBoardDAO.config(zBoardVo);
//                            FrontBoardVo frontBoardVo = new FrontBoardVo();
//                            frontBoardVo.setTblname(zBoardVo.getTblname());
//                            if (act.equals("prev")) frontBoardVo.setBbsno(dt.getInt("prevno"));
//                            else if (act.equals("next")) frontBoardVo.setBbsno(dt.getInt("nextno"));
//                            else frontBoardVo.setBbsno(dt.getInt("bbsno"));
//
//                            frontBoardVo = frontBoardDAO.getBoardRow(frontBoardVo);
//
//                            if (SecuritySessionUtil.getUserid(request).equals(frontBoardVo.getUserid())) {//내가 쓴 글이거나
//                                session.setAttribute("mode2", "1"); //mode2가 1이면  view화면에서 수정과 삭제를 표시한다.
//                                pass = true;
//                            } else if (!zBoardAuthVo.getRole_v().equals("0")) { //게시판의 view화면에 접근할 권한이 있는가
//                                //수정 및 삭제 버튼을 표시 할지 말지를 판단 mode2가 1이면 권한이 있는 것이다.
//                                if (SecuritySessionUtil.getUserid(request).equals(frontBoardVo.getUserid())) {//내가 쓴 글이거나
//                                    session.setAttribute("mode2", "1"); //mode2가 1이면  view화면에서 수정과 삭제를 표시한다.
//                                    pass = true;
//                                } else if (!zBoardAuthVo.getRole_d().equals("0")) { //해당 게시판의 권한을 가지고 있는 경우
//                                    session.setAttribute("mode2", "1");
//                                    pass = true;
//                                } else if (SecuritySessionUtil.getUserid(request).equals(frontBoardVo.getPuserid())) {//내가 쓴 글의 답글이면 볼수만 있음.
//                                    pass = true;
//                                } else {
//                                    if (null != zBoardVo.getSecretyn() && zBoardVo.getSecretyn().equals("1")) {//비밀게시판
//                                        pass = false;
//                                    } else pass = true;
//                                }
//                            } else {
//                                //본인인증 role_v이 체크되어 있는 경우 권한없음을 나타내는 메시지에 본인인증을 하면 볼수 있다는 메시지를 추가한다.
//                                /*if(!zBoardAuthVoForCert.getRole_v().equals("0")){
//									cert_on = "cert_on";
//								}*/
//                                pass = false;
//                            }
//                        }
//                    	else if (act=="write") {
//                            session.setAttribute("mode", zBoardAuthVo.getRole_w());
//                            if (!zBoardAuthVo.getRole_w().equals("0")) pass = true;
//                    	}
//                    	else if (act=="edit") {
//                            session.setAttribute("mode", zBoardAuthVo.getRole_m());
//                            session.setAttribute("modeEdt", "0");
//
//                            //내가 쓴 글인지 체크를 하는 부분
//                            ZBoardVo zBoardVo = new ZBoardVo();
//                            zBoardVo.setBoardno(dt.getInt("no"));
//                            zBoardVo = frontBoardDAO.config(zBoardVo);
//                            FrontBoardVo frontBoardVo = new FrontBoardVo();
//                            frontBoardVo.setTblname(zBoardVo.getTblname());
//                            frontBoardVo.setBbsno(dt.getInt("bbsno"));
//
//                            frontBoardVo = frontBoardDAO.getBoardRow(frontBoardVo);
//
//                            if (SecuritySessionUtil.isAuth(request, "ROLE_SUPER") ||
//                                    SecuritySessionUtil.isAuth(request, "ROLE_ADMIN") ||
//                                    SecuritySessionUtil.isUser(request, frontBoardVo.getUserid())) {//내가 쓴 글이면
//                                session.setAttribute("mode", "1"); //mode가 1이면  modify화면에서 수정과 삭제를 표시한다.
//                                pass = true;
//                            } else if (!zBoardAuthVo.getRole_m().equals("0")) {//또는 해당테이블에 대한 수정권한이 있다면
//                                session.setAttribute("mode", "1"); //mode가 1이면  modify화면에서 수정과 삭제를 표시한다.
//                                pass = true;
//                            }
//                        }
//                    	else if (act=="reply") {
//                            session.setAttribute("mode", zBoardAuthVo.getRole_r());
//
//                            ZBoardVo zBoardVo = new ZBoardVo();
//                            zBoardVo.setBoardno(dt.getInt("no"));
//                            zBoardVo = frontBoardDAO.config(zBoardVo);
//                            FrontBoardVo frontBoardVo = new FrontBoardVo();
//                            frontBoardVo.setTblname(zBoardVo.getTblname());
//                            frontBoardVo.setBbsno(dt.getInt("bbsno"));
//
//                            frontBoardVo = frontBoardDAO.getBoardRow(frontBoardVo);
//
//                            if (SecuritySessionUtil.getUserid(request).equals(frontBoardVo.getUserid())) {//내가 쓴 글이면
//                                pass = true;
//                            } else if (!zBoardAuthVo.getRole_r().equals("0")) { //게시판 답글 권한이 있으면
//                                pass = true;
//                            }
//
//                            //globals.properties에 설정된 disregard를 가저와 특정 ID와 boardno일 경우 해당 ID를 가진 사용자가 해당 게시판 게시글에 답변을 작성할 수 있도록 함.
//                            String disregard[] = EgovProperties.getProperty("Globals.auth.disregard").split("\\|");
//                            for (String s : disregard) {
//                                String disregard2[] = s.split("\\^");
//                                //System.out.println("interceptor => disregard2[0] ::: " + disregard2[0] + " ::: disregard2[1] ::: "+ disregard2[1]);
//                                if (SecuritySessionUtil.getUserid(request).equals(disregard2[0]) && dt.getInt("no") == Integer.parseInt(disregard2[1])) {
//                                    pass = true;
//                                }
//                            }
//                        }
//                    	else if (act=="delete") {
//                            ZBoardVo zBoardVo = new ZBoardVo();
//                            zBoardVo.setBoardno(dt.getInt("no"));
//                            ZPrint.print("board = " + dt.getInt("no"));
//                            zBoardVo = frontBoardDAO.config(zBoardVo);
//                            FrontBoardVo frontBoardVo = new FrontBoardVo();
//                            frontBoardVo.setTblname(zBoardVo.getTblname());
//                            ZPrint.print("table = " + zBoardVo.getTblname());
//                            frontBoardVo.setBbsno(dt.getInt("bbsno"));
//                            ZPrint.print("bbsno = " + dt.getInt("bbsno"));
//
//                            frontBoardVo = frontBoardDAO.getBoardRow(frontBoardVo);
//
//                            if (SecuritySessionUtil.getUserid(request).equals(frontBoardVo.getUserid())) { //내가 쓴글이면
//                                pass = true;
//                            } else if (!zBoardAuthVo.getRole_d().equals("0")) { //삭제권한이 있거나 슈퍼의 경우가 대부분... 삭제권한을 함부로 주면안된다.
//                                pass = true;
//                            }
//                            ZPrint.print("pass " + pass);
//                        }
//                    	else {//act.equals("comment")||act.equals("commentdel")||act.equals("attachdel")
//                            pass = true;
//                    	}
//                    }
//
//                //globals.properties에 설정된 disregard를 가저와 특정 ID와 boardno일 경우 해당 ID를 가진 사용자가 해당 게시판 게시글의 내용을 볼 수 있도록 함.
//                String disregard[] = EgovProperties.getProperty("Globals.auth.disregard").split("\\|");
//                for (String s : disregard) {
//                    String[] disregard2 = s.split("\\^");
//                    if (SecuritySessionUtil.getUserid(request).equals(disregard2[0]) && dt.getInt("no") == Integer.parseInt(disregard2[1])) {
//                        pass = true;
//                        zBoardAuthVo.setRole_r("10");
//                        session.setAttribute("frontAuthPassport", zBoardAuthVo);
//                    }
//                }
//            }
//
//            if (!pass) {
//                if (url.indexOf("Valid") > 0) {
//                    response.setCharacterEncoding("utf-8");
//                    response.setContentType("text/html;charset=UTF-8");
//                    PrintWriter out = response.getWriter();
//
//                    HashMap<String, String> msg = new HashMap<String, String>();
//                    msg.put("msg", messageSource.getMessage("board." + act, null, Locale.getDefault()));
//                    msg.put("flag", "auth");
//                    String json = new Gson().toJson(msg);
//                    out.print(json);
//                    out.flush();
//                } else {
//                    request.setAttribute("cert_on", cert_on);
//                    request.setAttribute("url", request.getRequestURL());
//                    session.getServletContext().getRequestDispatcher("/WEB-INF/jsp/board_noauth.jsp").include(request, response);
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pass;
    }

    @Override
    public void postHandle(
        HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(
        HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
