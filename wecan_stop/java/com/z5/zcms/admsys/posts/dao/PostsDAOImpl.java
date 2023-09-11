package com.z5.zcms.admsys.posts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.board.domain.FrontBoardVo;
import com.z5.zcms.admsys.posts.domain.PostsVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class PostsDAOImpl extends EgovComAbstractDAO implements PostsDAO {

	//Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "Posts.";
	
	public String tblName(PostsVo postsVo) {
		return (String) selectByPk(sqlMapNs + "tblName", postsVo);
	}
	
	public int listCount(PostsVo postsVo) {
		return (Integer) selectByPk(sqlMapNs + "listCount", postsVo);
	}

	@SuppressWarnings("unchecked")
	public List<PostsVo> list(PostsVo postsVo) {
		return (List<PostsVo>) list(sqlMapNs + "list", postsVo);
	}
	
	@SuppressWarnings("unchecked")
	public List<PostsVo> view(PostsVo postsVo) {
		return (List<PostsVo>) list(sqlMapNs + "view", postsVo);
	}
	
	public PostsVo attach(PostsVo postsVo) {
		return (PostsVo) selectByPk(sqlMapNs + "attach", postsVo);
	}
	
	public int save(PostsVo postsVo) {
		selectByPk(sqlMapNs+"save", postsVo);
		return postsVo.getMaxno();
	}
	
	public String deleteAttach(PostsVo postsVo) {
		selectByPk(sqlMapNs+"deleteAttach", postsVo);
		return postsVo.getBbsfilesave();
	}
	
	@SuppressWarnings("unchecked")
	public List<PostsVo> delete(PostsVo postsVo) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("bbsno",postsVo.getBbsno());
		paramMap.put("bbsnos",postsVo.getBbsnos());
		paramMap.put("tblname",postsVo.getTblname());

		return (List<PostsVo>) list(sqlMapNs+"delete", paramMap);
	}

	@SuppressWarnings("unchecked")
	public List<PostsVo> lnbList(PostsVo postsVo) {
		return (List<PostsVo>) list(sqlMapNs + "lnbList", postsVo);
	}

	@Override
	public int type(PostsVo postsVo) {
		return (Integer) selectByPk(sqlMapNs + "type", postsVo);
	}

	@Override
	public String replyyn(PostsVo postsVo) {
		return (String) selectByPk(sqlMapNs + "replyyn", postsVo);
	}

	@Override
	public String getaprovyn(PostsVo postsVo) {
		return (String) selectByPk(sqlMapNs + "getaprovyn", postsVo);
	}

	@Override
	public String getusername(PostsVo postsVo) {
		return (String) selectByPk(sqlMapNs + "getusername", postsVo);
	}

	@Override
	public String getuserno(PostsVo postsVo) {
		return (String) selectByPk(sqlMapNs + "getuserno", postsVo);
	}

	@Override
	public String getmenuno(PostsVo postsVo) {
		return (String) selectByPk(sqlMapNs + "getmenuno", postsVo);
	}

	@Override
	public String getskin(PostsVo postsVo) {
		return (String) selectByPk(sqlMapNs + "getskin", postsVo);
	}

	@Override
	public String gettbltitle(PostsVo postsVo) {
		return (String) selectByPk(sqlMapNs + "gettbltitle", postsVo);
	}

	@Override
	public List<PostsVo> aprovinfo(int bbsno) {
		return (List<PostsVo>) list(sqlMapNs + "aprovinfo", bbsno);
	}

}