package com.z5.zcms.admsys.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.z5.zcms.admsys.board.dao.ZBoardDAO;
import com.z5.zcms.admsys.board.domain.ZBoardVo;

public class BoardCheckValidator implements ConstraintValidator<BoardCheck, ZBoardVo>{

	@Autowired
	private ZBoardDAO zBoardDAO;

	public void initialize(BoardCheck constraintAnnotation) {
	}
	public boolean isValid(ZBoardVo zBoardVo, ConstraintValidatorContext context) {
		try {
			if (!zBoardVo.getBoardtitle().trim().isEmpty()){
				if (zBoardDAO.boardTitleDupChk(zBoardVo)>0){
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate("{board.dupchk}")
							.addNode("boardtitle")
							.addConstraintViolation();
					return false;
				}
			}
			
			if (null!=zBoardVo.getType()){
				if (zBoardVo.getType().equals("2")){
					if (zBoardVo.getTblname().isEmpty()){
						context.disableDefaultConstraintViolation();
						context.buildConstraintViolationWithTemplate("{board.tblname}")
								.addNode("tblname")
								.addConstraintViolation();
						return false;
					}
				}
			}
			
			if (zBoardVo.getSkintype().equals("1")){
				if (!StringUtils.isNumeric(zBoardVo.getThumbnailw())){
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate("{board.thumbnailw}")
							.addNode("thumbnailw")
							.addConstraintViolation();
					return false;
				}
				if (!StringUtils.isNumeric(zBoardVo.getThumbnailh())){
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate("{board.thumbnailh}")
							.addNode("thumbnailh")
							.addConstraintViolation();
					return false;
				}
				if (!StringUtils.isNumeric(zBoardVo.getListimgw())){
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate("{board.listimgw}")
							.addNode("listimgw")
							.addConstraintViolation();
					return false;
				}
				if (!StringUtils.isNumeric(zBoardVo.getListimgh())){
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate("{board.listimgh}")
							.addNode("listimgh")
							.addConstraintViolation();
					return false;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	} 
}
