package com.z5.zcms.admsys.lastestboard.web;

import com.z5.zcms.admsys.lastestboard.domain.ZLastestBoardVo;
import com.z5.zcms.admsys.lastestboard.service.ZLastestBoardService;
import com.z5.zcms.util.StringUtil;
import java.net.URLEncoder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ZLastestBoardController {

    @Autowired
    private ZLastestBoardService zlastestBoardService;

    @RequestMapping(value = {"/Board/lastestBoard/lastestlist1.html"})
    public String getListlastestBoard1(
        @ModelAttribute("ZlastestBoardVo") ZLastestBoardVo zLastestBoardVo,
        @RequestParam(value = "cnt", required = false, defaultValue = "4") int cnt,
        Model model) {
        try {
            zLastestBoardVo.setCnt(cnt);
            zLastestBoardVo.setTabno(1);

            List<ZLastestBoardVo> lastestlist = zlastestBoardService.getListLastestBoard(zLastestBoardVo);

            for (ZLastestBoardVo vo : lastestlist) {
                zLastestBoardVo.setSiteno2(vo.getSiteno());
                //System.out.println("getSiteno!!!!!!!!!!!!!!!!!=============>"+vo.getSiteno());
                zLastestBoardVo.setBoardno2(vo.getBoardno());
                //System.out.println("getBoardno!!!!!!!!!!!!!!!!!=============>"+vo.getBoardno());

                int    menuno = zlastestBoardService.selectMenuno(zLastestBoardVo);
                String skin   = zlastestBoardService.selectSkin(zLastestBoardVo);

                String ztag = URLEncoder.encode(StringUtil.makeElementAndBase64(Integer.toString(vo.getBoardno()), "board", skin), "utf-8");
                String url  = "/index.html?menuno=" + menuno + "&bbsno=" + vo.getBbsno() + "&boardno=" + vo.getBoardno() + "&ztag=" + ztag + "&siteno=" + vo.getSiteno() + "&act=view";
                //System.out.println("url!!!!!!!!!!!!!!!!!=============>"+url);

                vo.setUrl(url);

                //lastestlist.set(a-1, url).setUrl();
            }

            //System.out.println("!!!!!!!!!!!!!!!!!=============>"+lastestlist.get(0).getBbstitle());

            model.addAttribute("tabno", "1");
            model.addAttribute("list", lastestlist);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/lastestboard/list/lastestlist";
    }
}
