package com.z5.zcms.admsys.board.web;

import com.z5.zcms.admsys.board.dao.ZBoardDAO;
import com.z5.zcms.admsys.board.domain.BoardVO;
import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo.BoardCopy;
import com.z5.zcms.admsys.board.domain.ZCateVo;
import com.z5.zcms.admsys.board.service.BoardGroupService;
import com.z5.zcms.admsys.board.service.BoardRoleService;
import com.z5.zcms.admsys.board.service.BoardService;
import com.z5.zcms.admsys.board.service.CateService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import com.z5.zcms.util.StringUtil;
import com.z5.zcms.util.ZPrint;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"zBoardVo", "skinList", "boardList", "roleList", "groupList", "role_l", "role_v", "role_w", "role_m", "role_d", "role_m", "role_d",
                    "role_m_nm", "role_r", "role_c", "role_n"})
@RequestMapping(value = {"/admsys/board/", "/admsys/board/run/"})
public class BoardController {

    private final Logger log = Logger.getLogger(this.getClass());
    private final String RETURN_URL = "/zcms/admsys/board/run/";
    @Autowired
    MessageSource messageSource;
    @Autowired
    private BoardService boardService;
    @Autowired
    private CateService cateService;
    @Autowired
    private BoardRoleService boardRoleService;
    @Autowired
    private BoardGroupService boardGroupService;
    @Autowired
    private ZBoardDAO zBoardDAO;
    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "index.html")
    public ModelAndView list(@ModelAttribute ZBoardVo zBoardVo, HttpServletRequest req, ModelAndView mav) throws Exception {

        mav.setViewName(RETURN_URL + "index");

        DataTable dt = new DataTable(req);
        dt.put("mav", mav);
        dt.put("zBoardVo", zBoardVo);

        return boardService.boardList(dt);
    }

    @RequestMapping(value = "insert.html", method = RequestMethod.GET)
    public ModelAndView boardCreateView(HttpServletRequest req, ModelAndView mav) throws Exception {

        mav.setViewName(RETURN_URL + "insert");

        DataTable dt = new DataTable(req);
        dt.put("mav", mav);

        return boardService.boardCreateView(dt);
    }

    @RequestMapping(value = "insert.html", method = RequestMethod.POST)
    public ModelAndView boardCreate(@Valid @ModelAttribute("zBoardVo") ZBoardVo zBoardVo, BindingResult result, HttpServletRequest req, ModelAndView mav,
        SessionStatus status) throws Exception {

        mav.setViewName(RETURN_URL + "insert");

        if (!result.hasErrors()) {
            DataTable dt = new DataTable(req);
            dt.put("zBoardVo", zBoardVo);
            boardService.boardCreate(dt);
            status.isComplete();
            mav.setViewName("redirect:/admsys/board/run/index.html");
        }

        return mav;
    }

    @RequestMapping(value = "update.html", method = RequestMethod.GET)
    public ModelAndView updateView(HttpServletRequest req, ModelAndView mav) throws Exception {

        mav.setViewName(RETURN_URL + "update");
        DataTable dt = new DataTable(req);
        dt.put("mav", mav);

        return boardService.boardUpdateView(dt);
    }

    @RequestMapping(value = "update.html", method = RequestMethod.POST)
    public ModelAndView update(@Valid @ModelAttribute("zBoardVo") ZBoardVo zBoardVo, BindingResult result, HttpServletRequest req, ModelAndView mav,
        SessionStatus status) throws Exception {

        mav.setViewName(RETURN_URL + "update");

        if (!result.hasErrors()) {
            DataTable dt = new DataTable(req);
            dt.put("zBoardVo", zBoardVo);
            boardService.boardUpdate(dt);
            status.isComplete();
            mav.setViewName("redirect:/admsys/board/run/index.html?pageIndex=" + zBoardVo.getPageIndex());
        }

        return mav;
    }

    @RequestMapping(value = "boardAdminSearch.html", method = RequestMethod.GET)
    public ModelAndView boardAdminSearch(HttpServletRequest req, ModelAndView mav) throws Exception {

        mav.setViewName(RETURN_URL + "boardAdminSearch");

        DataTable dt = new DataTable(req);
        dt.put("mav", mav);

        return boardService.boardAdminList(dt);
    }

    @RequestMapping(value = "delete.html")
    public ModelAndView delete(HttpServletRequest req, ModelAndView mav) throws Exception {

        mav.setViewName("redirect:/admsys/board/run/index.html");

        DataTable dt = new DataTable(req);
        dt.put("mav", mav);

        return boardService.boardDelete(dt);
    }

    @RequestMapping(value = "boardCopy.html", method = RequestMethod.GET)
    public ModelAndView boardCopyView(HttpServletRequest req, ModelAndView mav) throws Exception {

        mav.setViewName(RETURN_URL + "boardCopy");

        DataTable dt = new DataTable(req);
        dt.put("mav", mav);

        return boardService.boardCopyView(dt);
    }

    @RequestMapping(value = "boardCopy.html", method = RequestMethod.POST)
    public ModelAndView boardCopy(@ModelAttribute("zBoardVo") ZBoardVo zBoardVo, BindingResult result, HttpServletRequest req, ModelAndView mav,
        SessionStatus status) throws Exception {

        mav.setViewName(RETURN_URL + "boardCopy");

        Validator                          validator  = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<ZBoardVo>> violations = validator.validate(zBoardVo, BoardCopy.class);
        for (ConstraintViolation<ZBoardVo> violation : violations) {
            result.rejectValue(violation.getPropertyPath().toString(), "board.boardtitle");
        }
        zBoardVo.setBoardno(0);
        if (zBoardDAO.boardTitleDupChk(zBoardVo) > 0) {
            result.rejectValue("boardtitle", "board.dupchk");
        }

        if (!result.hasErrors()) {
            DataTable dt = new DataTable(req);
            dt.put("zBoardVo", zBoardVo);
            boardService.boardCopy(dt);
            status.isComplete();
            mav.addObject("flag", "1");
        }

        return mav;
    }

    @RequestMapping(value = "boardCate.html", method = RequestMethod.GET)
    public String boadCateView(@ModelAttribute("zCateVo") ZCateVo zCateVo, HttpServletRequest req, Model model) throws Exception {

        DataTable dt = new DataTable(req);

        try {
            dt.put("zCateVo", zCateVo);

            model.addAttribute("detail", cateService.boardCateList(dt));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RETURN_URL + "boardCate";
    }

    @RequestMapping(value = "boardCate.html", method = RequestMethod.POST)
    public String boardCateSet(@ModelAttribute("zCateVo") ZCateVo zCateVo, HttpServletRequest req, Model model) throws Exception {

        DataTable dt = new DataTable(req);

        try {
            dt.put("zCateVo", zCateVo);
            dt = cateService.boardCateSet(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/board/run/boardCate.html?boardno=" + dt.getInt("boardno") + "&flag=" + dt.get("flag");
    }
   
}
