package com.z5.zcms.admsys.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.z5.zcms.admsys.module.domain.ZEvalVo;

@Component
public class EvalValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ZEvalVo.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {

	}
}
