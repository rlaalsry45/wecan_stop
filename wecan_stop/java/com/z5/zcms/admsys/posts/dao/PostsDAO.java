package com.z5.zcms.admsys.posts.dao;

import java.util.List;

import com.z5.zcms.admsys.posts.domain.PostsVo;

public interface PostsDAO {

	public String tblName(PostsVo postsVo);
	public int listCount(PostsVo postsVo);
	public List<PostsVo> list(PostsVo postsVo);
	public List<PostsVo> view(PostsVo postsVo);
	public PostsVo attach(PostsVo postsVo);
	public int save(PostsVo postsVo);
	public String deleteAttach(PostsVo postsVo);
	public List<PostsVo> delete(PostsVo postsVo);
	public List<PostsVo> lnbList(PostsVo postsVo);
	public int type(PostsVo postsVo);
	public String replyyn(PostsVo postsVo);
	public String getaprovyn(PostsVo postsVo);
	public String getusername(PostsVo postsVo);
	public String getuserno(PostsVo postsVo);
	public String getmenuno(PostsVo postsVo);
	public String getskin(PostsVo postsVo);
	public String gettbltitle(PostsVo postsVo);
	public List<PostsVo> aprovinfo(int bbsno);
}