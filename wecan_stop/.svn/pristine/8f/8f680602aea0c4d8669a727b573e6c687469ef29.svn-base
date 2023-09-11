package com.z5.zcms.frontsys.search.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.frontsys.search.domain.FrontSearchVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class FrontSearchDAOImpl extends EgovComAbstractDAO implements FrontSearchDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "frontSearch.";
	
	
	@Override
	public int getSearchListCount(FrontSearchVO vo) throws Exception{
		return (Integer) super.selectByPk(sqlMapNs+"listCount",vo);	
	}
	
	@SuppressWarnings("unchecked")
	public List<FrontSearchVO> selectSearchList(FrontSearchVO vo)  throws Exception{
		return (List<FrontSearchVO>) super.list(sqlMapNs+"searchList", vo);
	}
	
	
	/*public FrontPaperVO getPaperInfo(FrontPaperVO vo) {
		return (FrontPaperVO) selectByPk(sqlMapNs + "getPaperInfo", vo);
	}
	
	public FrontAuthorVO getAuthorInfo(FrontAuthorVO vo) {
		return (FrontAuthorVO) selectByPk(sqlMapNs + "getAuthorInfo", vo);
	}
	
	public String insertPaperSubmit(FrontPaperVO vo) throws Exception{
		return (String)insert (sqlMapNs+"insertPaperSubmit", vo);
	}
	
	public String insertAuthor(FrontAuthorVO vo) throws Exception{
		return (String)insert (sqlMapNs+"insertAuthor", vo);
	}
	
	public void updateAuthor(FrontAuthorVO vo) throws Exception{
		update (sqlMapNs+"updateAuthor", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<FrontPaperVO> selectPaperSubmitList(FrontPaperVO vo) {
		return super.list(sqlMapNs+"selectPaperSubmitList", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<PaperExamVO> selectExamList(PaperExamVO vo) {
		return super.list(sqlMapNs+"selectExamList", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<FrontAuthorVO> selectAuthorList(FrontAuthorVO vo) {
		return super.list(sqlMapNs+"selectAuthorList", vo);
	}
	
	public String getJoinNo(FrontPaperVO vo) {
		return  (String)selectByPk(sqlMapNs + "getJoinNo", vo);
	}
	
	public void updateSubmit(FrontPaperVO vo) throws Exception{
		update (sqlMapNs+"updateSubmit", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<PaperExamVO> selectExamInfo(PaperExamVO vo) {
		return super.list(sqlMapNs+"selectExamInfo", vo);
	}
	
	public void updateExam(PaperExamVO vo) throws Exception{
		update (sqlMapNs+"updateExam", vo);
	}
	
	public void insertExamInfo(PaperExamVO vo) throws Exception{
		insert (sqlMapNs+"insertExamInfo", vo);
	}*/
}
