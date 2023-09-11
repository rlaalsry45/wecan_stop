package com.z5.zcms.admsys.adminip.dao;

import java.util.List;

import com.z5.zcms.admsys.adminip.domain.AdminIPVO;

public interface AdminIPDAO {
	
	int getIPCount(AdminIPVO adminIPVO);

	Integer IPCount(AdminIPVO adminIPVO);

	List<AdminIPVO> getList(AdminIPVO adminIPVO);

	void delete(List<Integer> arrDeleteNo);

	void update(AdminIPVO adminIPVO);

	void insert(AdminIPVO adminIPVO);

	AdminIPVO selectUP(int no);

	int checkIPDouble(AdminIPVO adminIPVO);

	int getCurrvalSequence(AdminIPVO adminIPVO);


}
