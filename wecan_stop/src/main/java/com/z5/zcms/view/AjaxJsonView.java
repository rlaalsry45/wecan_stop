package com.z5.zcms.view;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class AjaxJsonView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(@SuppressWarnings("rawtypes") Map model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();
		writer.write((String) model.get("ajaxJson"));  //Model Attribute 이름은 공통으로 사용하는 것으로...
		writer.close();
	}
}
