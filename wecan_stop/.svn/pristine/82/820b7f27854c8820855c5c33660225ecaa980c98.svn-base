package com.z5.zcms.frontsys.front.web;

import com.z5.zcms.admsys.board.service.FrontBoardService;
import com.z5.zcms.admsys.module.domain.ZBannerVo;
import com.z5.zcms.admsys.module.service.BannerService;
import egovframework.com.cmm.service.EgovProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class FrontBannerController {

	@Autowired
	FrontBoardService frontBoardService;

	@Autowired
	BannerService bannerService;

	private final String RETURN_URL = "/skin/banner/";

	@RequestMapping(value = "/skin/banner/{skin}/banner.html")
	public String list(
			@PathVariable("skin") String skin, Model model,
			HttpServletRequest req) throws Exception {

		String bannerno = ((String) req.getAttribute("no"))!=null ? (String) req.getAttribute("no"):req.getParameter("no");
		Integer siteno = (Integer) req.getAttribute("siteno");

		try {
			ZBannerVo zBannerVo = new ZBannerVo();
			zBannerVo.setBannerno(Integer.parseInt(bannerno));
			zBannerVo.setSkin(skin);
			zBannerVo = (ZBannerVo) bannerService.bannerDetail(zBannerVo);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date current = sdf.parse(sdf.format(new Date()));
			
			ArrayList<String> list = new ArrayList<String>();
			if(zBannerVo.getConts() != null){
				String[] conts = zBannerVo.getConts().split("Œ");
				for(int i=0;i<conts.length;i++) {
					String[] temp = conts[i].split("Æ");
					for (int j=5;j<temp.length;j=j+5) {
						if (temp[j].equals("Y")) {
							list.add(conts[i]);
						}
						else if (temp[j].equals("D")) {
							Date sdate = sdf.parse(temp[j+2]);
							Date edate = sdf.parse(temp[j+3]);
							if (sdate.before(current) && edate.after(current)) {
								list.add(conts[i]);
							}
						}
					}
				}
			}
			
			zBannerVo.setConts(StringUtils.join(list.toArray(new String[list.size()]),"Œ"));

			if(zBannerVo.getRandom().equals("Y")){

				if(zBannerVo.getConts() != null){
					String[] conts = zBannerVo.getConts().split("Œ");
					String[] newconts = new String[conts.length];
					int a[] = new int[conts.length]; //int형 배열 선언
			        Random r = new Random(); //객체생성
			        for(int i=0;i<conts.length;i++)    //숫자 6개를 뽑기위한 for문
			        {
			            a[i] = r.nextInt(conts.length); //1~10숫자중 랜덤으로 하나를 뽑아 a[0]~a[5]에 저장
			            for(int j=0;j<i;j++) //중복제거를 위한 for문
			            {
			                /*현재 a[]에 저장된 랜덤숫자와 이전에 a[]에 들어간 숫자 비교
			                 ※예를 들어
			                 배열 a[3]에 숫자 6이 들어갔을때 이전에 완성된 배열 a[0],a[1],a[2]와 비교하여
			                 숫자 6이 중복되지 않을시 다음 a[4]으로 넘어가고, 중복된다면 다시 a[3]에 중복되지
			                 않는 숫자를 넣기 위하여 i를 한번 감소한후 처음 for문으로 돌아가 다시 a[3]을 채운다
			                 */
			                if(a[i]==a[j])
			                {
			                    i--;
			                }
			            }
			        }

			        for(int k=0;k<conts.length;k++) //채워진 배열을 출력하기 위한 for문
			        {
			        	newconts[k] = conts[a[k]];

			        }

			        zBannerVo.setConts(StringUtils.join(newconts,"Œ"));
				}
			}
			
			model.addAttribute("detail",zBannerVo);
			model.addAttribute("uploadurl",EgovProperties.getProperty("Globals.upload.banner"));
			model.addAttribute("skin", skin);
			model.addAttribute("siteno", siteno);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return RETURN_URL + skin + "/banner";
	}


}
