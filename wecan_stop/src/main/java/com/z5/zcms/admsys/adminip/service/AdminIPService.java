package com.z5.zcms.admsys.adminip.service;

import java.util.List;

import com.z5.zcms.admsys.adminip.domain.AdminIPVO;

public interface AdminIPService {


	Integer IPCount(AdminIPVO adminIPVO) throws Exception;

	List<AdminIPVO> getList(AdminIPVO adminIPVO) throws Exception;

	void delete(List<Integer> arrDeleteNo) throws Exception;

	AdminIPVO selectUP(int no) ;

	void update(AdminIPVO adminIPVO) throws Exception;

	void insert(AdminIPVO adminIPVO) throws Exception;

	int getIPCount(AdminIPVO adminIPVO) throws Exception;

	int checkIPDouble(AdminIPVO adminIPVO) throws Exception;

	int getCurrvalSequence(AdminIPVO adminIPVO);

}
