package com.z5.zcms.admsys.user.web;

import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


@Component
public class UserScheduler {
    @Autowired
    private ZUserService zUserService;

    //@Scheduled(cron = "0 0 21 * * ?") //매일 9시
    public void checkUser() throws Exception {

        try {
            System.out.println("[User Approve Check START] ------------------");

            ZUserVo zUserVo = new ZUserVo();

            zUserVo.setCond7("0"); //승인대기(미납회원)

            //한달전 날짜 구하기
            Calendar cal = new GregorianCalendar();
            cal.add(Calendar.MONTH, -1);
            String preMonth = Integer.toString(cal.get(Calendar.YEAR)) + Integer.toString((cal.get(Calendar.MONTH) + 1)) + Integer.toString(cal.get(Calendar.DAY_OF_MONTH)) + "000000";
            zUserVo.setApprove(preMonth); //한달전 날짜를 설정하여 가입만 하고 한달이 지난 사람을 찾는다.

            List<ZUserVo> searchList = this.zUserService.searchListUser(zUserVo); //검색일경우 전체 리스트 정보 가져오기(메일및 엑셀다운위해)


            System.out.println("[User Approve Check END] ------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }
}
