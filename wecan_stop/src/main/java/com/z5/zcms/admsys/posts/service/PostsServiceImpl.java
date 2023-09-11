package com.z5.zcms.admsys.posts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.posts.dao.PostsDAO;
import com.z5.zcms.admsys.posts.domain.PostsVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class PostsServiceImpl extends AbstractServiceImpl implements PostsService {

	@Autowired
	private PostsDAO postsDAO;
	
	public String getTblName(PostsVo postsVo) {
		return postsDAO.tblName(postsVo);
	}
	
	public int listCount(PostsVo postsVo) {
		return postsDAO.listCount(postsVo);
	}

	public List<PostsVo> getPostsList(PostsVo postsVo) {
		return postsDAO.list(postsVo);
	}
	
	public List<PostsVo> getPostsView(PostsVo postsVo) {
		return postsDAO.view(postsVo);
	}
	
	public PostsVo attach(PostsVo postsVo) {
		return postsDAO.attach(postsVo);
	}
	
	public int save(PostsVo postsVo) {
		return postsDAO.save(postsVo);
	}
	
	public String deleteAttach(PostsVo postsVo) {
		return postsDAO.deleteAttach(postsVo);
	}
	
	public List<PostsVo> delete(PostsVo postsVo) {
		return postsDAO.delete(postsVo);
	}

	@Override
	public List<PostsVo> lnbList(PostsVo postsVo) {
		// TODO Auto-generated method stub
		return postsDAO.lnbList(postsVo);
	}

	@Override
	public int type(PostsVo postsVo) {
		return postsDAO.type(postsVo);
	}

	@Override
	public String replyyn(PostsVo postsVo) {
		return postsDAO.replyyn(postsVo);
	}

	@Override
	public String getaprovyn(PostsVo postsVo) {
		return postsDAO.getaprovyn(postsVo);
	}

	@Override
	public String getusername(PostsVo postsVo) {
		return postsDAO.getusername(postsVo);
	}

	@Override
	public String getuserno(PostsVo postsVo) {
		return postsDAO.getuserno(postsVo);
	}

	@Override
	public String getmenuno(PostsVo postsVo) {
		return postsDAO.getmenuno(postsVo);
	}

	@Override
	public String getskin(PostsVo postsVo) {
		return postsDAO.getskin(postsVo);
	}

	@Override
	public String gettbltitle(PostsVo postsVo) {
		return postsDAO.gettbltitle(postsVo);
	}

	@Override
	public List<PostsVo> aprovinfo(int bbsno) {
		return postsDAO.aprovinfo(bbsno);
	}
}
