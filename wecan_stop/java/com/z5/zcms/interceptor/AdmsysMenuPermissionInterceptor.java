package com.z5.zcms.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.z5.zcms.admsys.auth.domain.FunctionPerMenuPermissionInfoListVo;
import com.z5.zcms.admsys.auth.service.MenuAuthService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.util.SecuritySessionUtil;

public class AdmsysMenuPermissionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private MenuAuthService menuAuthService; 
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		try {
			String userid = SecuritySessionUtil.getUserid(request);
			
			String url = (String) request.getAttribute("javax.servlet.forward.request_uri");
			if ( StringUtils.isBlank(url)) {
				url = request.getRequestURI();
			}
			
			FunctionPerMenuPermissionInfoListVo vo = new FunctionPerMenuPermissionInfoListVo();
			vo.setURLLINK(url);
			vo.setUserId(userid);
				
			List<FunctionPerMenuPermissionInfoListVo> perList =  menuAuthService.retrievePerList(vo);
			if ( perList.size() > 0 ) {
				modelAndView.addObject("perm", perList);					
			}
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		super.postHandle(request, response, handler, modelAndView);
	}
}
