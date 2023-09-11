package com.z5.zcms.admsys.board.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.board.domain.ZBoardGroupVo;
import com.z5.zcms.admsys.board.service.BoardGroupService;
import com.z5.zcms.util.DataTable;

@Controller
@RequestMapping("/admsys/board/group")
public class BoardGroupController {

	@Autowired
	private BoardGroupService boardGroupService;

	private final Logger log = Logger.getLogger(this.getClass());

	private final String RETURN_URL = "/zcms/admsys/board/group/";

	@RequestMapping(value="index.html")
	public String list(	@ModelAttribute("zBoardGroupVo") ZBoardGroupVo zBoardGroupVo, HttpServletRequest req, Model model) {

		DataTable dt = new DataTable(req);

		try {
			dt.put("zBoardGroupVo", zBoardGroupVo);

			model.addAttribute("dt", boardGroupService.boardGroupList(dt));
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return RETURN_URL + "index";
	}

	@RequestMapping(value="boardGroupCreate.html", method=RequestMethod.GET)
	public String boardGroupCreateView(HttpServletRequest req, Model model) {

		return RETURN_URL + "boardGroupCreate";
	}

	@RequestMapping(value="boardGroupCreate.html", method=RequestMethod.POST)
	public @ResponseBody DataTable boardGroupCreate(HttpServletRequest req) {

		DataTable dt = new DataTable(req);

		try {
			dt = boardGroupService.boardGroupCreate(dt);
		}
		catch(Exception e){
			dt.put("result", "error");
			e.printStackTrace();
		}

		return dt;
	}

	@RequestMapping(value="boardGroupSet.html", method=RequestMethod.GET)
	public String boardGroupSetView(HttpServletRequest req, Model model) {

		DataTable dt = new DataTable(req);

		try {

			model.addAttribute("dt", boardGroupService.boardGroupSetView(dt));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return RETURN_URL + "boardGroupSet";
	}

	@RequestMapping(value="boardGroupSet.html", method=RequestMethod.POST)
	public @ResponseBody DataTable boardGroupSet(HttpServletRequest req) {

		DataTable dt = new DataTable(req);

		try {

			dt = boardGroupService.boardGroupSet(dt);
		} catch (Exception e) {
			dt.put("result", "error");
			e.printStackTrace();
		}

		return dt;
	}

	@RequestMapping("delete.html")
	public String delete(HttpServletRequest req) {

		DataTable dt = new DataTable(req);

		try {

			boardGroupService.boardGroupMutilDelete(dt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admsys/board/group/index.html";
	}
}
