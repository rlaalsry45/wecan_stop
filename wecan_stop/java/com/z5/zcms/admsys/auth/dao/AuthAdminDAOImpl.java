package com.z5.zcms.admsys.auth.dao;

import com.z5.zcms.admsys.auth.domain.Auth;
import com.z5.zcms.admsys.auth.domain.AuthAdminVo;
import com.z5.zcms.admsys.auth.domain.UserOtpVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.ZPrint;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.z5.zcms.util.ZPrint.print;

@Repository
public class AuthAdminDAOImpl extends EgovComAbstractDAO implements AuthAdminDAO {

    private final String sqlMapNs = "Auth.";

    @SuppressWarnings("unchecked")
    public List<AuthAdminVo> authAdminUrlList() {
        return (List<AuthAdminVo>) list(sqlMapNs + "authAdminUrlList", null);
    }

    @SuppressWarnings("unchecked")
    public List<AuthAdminVo> authAdminList(AuthAdminVo authAdminVo) {
        return (List<AuthAdminVo>) list(sqlMapNs + "authAdminList", authAdminVo);
    }

    public void authAdminEdit(final List<AuthAdminVo> authAdminList) {
        try {
            getSqlMapClient().startTransaction();
            getSqlMapClient().startBatch();

            for (AuthAdminVo adminVo : authAdminList) {
                getSqlMapClient().update(sqlMapNs + "authAdminEdit", adminVo);
            }

            getSqlMapClient().executeBatch();
            getSqlMapClient().endTransaction();
        } catch (final Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void authAdminWrite(AuthAdminVo authAdminVo) {

        ZPrint.print(authAdminVo.toString());
        AuthAdminVo vo = (AuthAdminVo) selectByPk(sqlMapNs + "authAdminWrite1", authAdminVo);

        int level = 0;
        int topno = 0;
        int step  = 0;

        if (vo != null) {

            ZPrint.print(vo.toString());
            level = vo.getUrllevel();
            topno = vo.getUrltopno();
            step = vo.getUrlstep();

            authAdminVo.setUrllevel(level);
            authAdminVo.setUrltopno(topno);
            authAdminVo.setUrlstep(step);
            authAdminVo.setUrlparentno(authAdminVo.getUrlno());

            if (topno > 0) {
                authAdminVo.setUrlstep(step);
                vo = (AuthAdminVo) selectByPk(sqlMapNs + "authAdminWrite2", authAdminVo);
                step = vo.getUrlstep();
                authAdminVo.setUrlstep(step);
                ZPrint.print(authAdminVo.toString());
                update(sqlMapNs + "authAdminWrite3", authAdminVo);

            }
        }

        int urlnonew = (Integer) insert(sqlMapNs + "authAdminWrite4", authAdminVo);

        if (topno == 0) {
            authAdminVo.setUrlnonew(urlnonew);
            ZPrint.print(authAdminVo.toString());
            update(sqlMapNs + "authAdminWrite5", authAdminVo);
        }
    }

    public void authAdminUrlDelete(List<String> map) {

        List<Auth> list = (List<Auth>) list(sqlMapNs + "authAdminUrlDelete1", map);

        List<Integer> arrDeleteNo = new ArrayList<Integer>(list.size());
        for (int i = 0; i < list.size(); i++) {
            arrDeleteNo.add(list.get(i).getUrlno());
        }

        if (list != null) {
            delete(sqlMapNs + "authAdminUrlDelete2", arrDeleteNo);
            delete(sqlMapNs + "authAdminUrlDelete3", arrDeleteNo);
        }

    }

    public void authAdminDel() {
        delete(sqlMapNs + "authAdminDel", null);
    }

    public void authAdminDelete(Auth auth) {
        delete(sqlMapNs + "authAdminDelete", auth);
    }

    @SuppressWarnings("unchecked")
    public List<String> authSubUrlList(Auth auth) {
        return (List<String>) list(sqlMapNs + "authSubUrlList", auth);
    }

    public void authAdminMutiDelete(Auth auth) {
        delete(sqlMapNs + "authAdminMutiDelete", auth);
    }

    public void orderChange(DataTable input) {
        String act = input.get("act");
        print("input", input);

        AuthAdminVo authAdminVo = new AuthAdminVo();
        AuthAdminVo vo          = new AuthAdminVo();

        authAdminVo.setUrlno(input.getInt("urlno"));
        authAdminVo = (AuthAdminVo) selectByPk(sqlMapNs + "adminUrlOrder1", authAdminVo);
        ZPrint.print(authAdminVo.toString());

        if (authAdminVo.getUrllevel() > 0) {
            authAdminVo.setUrlsteporg(authAdminVo.getUrlstep());

            if (act.equals("d")) {
                vo = (AuthAdminVo) selectByPk(sqlMapNs + "adminUrlOrder2", authAdminVo);

                authAdminVo.setUrlstepmax1(vo.getUrlstepmax1());
                ZPrint.print(authAdminVo.toString());

                if (authAdminVo.getUrlstepmax1() > 0) {

                    vo = (AuthAdminVo) selectByPk(sqlMapNs + "adminUrlOrder3", authAdminVo);
                    authAdminVo.setUrlstepmax2(vo.getUrlstepmax2());

                    List<AuthAdminVo> authList2 = (List<AuthAdminVo>) list(sqlMapNs + "adminUrlOrder4", authAdminVo);

                    List<AuthAdminVo> authList = new ArrayList<AuthAdminVo>();
                    if (authAdminVo.getUrlstepmax2() > 0) {
                        authList = (List<AuthAdminVo>) list(sqlMapNs + "adminUrlOrder15", authAdminVo);
                    } else {
                        authList = (List<AuthAdminVo>) list(sqlMapNs + "adminUrlOrder5", authAdminVo);
                    }

                    for (int i = 0; i < authList.size(); i++) {

                        if (authAdminVo.getStep() == 0) {
                            authAdminVo.setStep(authAdminVo.getUrlsteporg());
                        } else {
                            authAdminVo.setStep(authAdminVo.getStep() + 1);
                        }

                        authAdminVo.setMno(authList.get(i).getUrlno());

                        update(sqlMapNs + "adminUrlOrder6", authAdminVo);


                    }

                    for (int i = 0; i < authList2.size(); i++) {
                        authAdminVo.setStep(authAdminVo.getStep() + 1);
                        authAdminVo.setMno(authList2.get(i).getUrlno());

                        update(sqlMapNs + "adminUrlOrder6", authAdminVo);
                    }

                }

            } else if (act.equals("u")) {

                vo = (AuthAdminVo) selectByPk(sqlMapNs + "adminUrlOrder7", authAdminVo);

                authAdminVo.setUrlstepmin1(vo.getUrlstepmin1());

                if (authAdminVo.getUrlstepmin1() > 0) {
                    vo = (AuthAdminVo) selectByPk(sqlMapNs + "adminUrlOrder8", authAdminVo);

                    authAdminVo.setUrlstepmin2(vo.getUrlstepmin2());

                    List<AuthAdminVo> authList2 = (List<AuthAdminVo>) list(sqlMapNs + "adminUrlOrder9", authAdminVo);

                    List<AuthAdminVo> authList = new ArrayList<AuthAdminVo>();
                    if (authAdminVo.getUrlstepmin2() > 0) {
                        authList = (List<AuthAdminVo>) list(sqlMapNs + "adminUrlOrder16", authAdminVo);
                    } else {
                        authList = (List<AuthAdminVo>) list(sqlMapNs + "adminUrlOrder10", authAdminVo);
                    }


                    for (int i = 0; i < authList.size(); i++) {

                        if (authAdminVo.getStep() == 0) {
                            authAdminVo.setStep(authAdminVo.getUrlstepmin1());
                        } else {
                            authAdminVo.setStep(authAdminVo.getStep() + 1);
                        }

                        authAdminVo.setMno(authList.get(i).getUrlno());

                        update(sqlMapNs + "adminUrlOrder6", authAdminVo);


                    }

                    for (int i = 0; i < authList2.size(); i++) {
                        authAdminVo.setStep(authAdminVo.getStep() + 1);
                        authAdminVo.setMno(authList2.get(i).getUrlno());

                        update(sqlMapNs + "adminUrlOrder6", authAdminVo);
                    }
                }
            }

        } else {

            authAdminVo.setUrlnoorg(authAdminVo.getUrltopno());

            if (act.equals("d")) {
                authAdminVo.setType("MIN");
                authAdminVo.setMark(">");
            } else {
                authAdminVo.setType("MAX");
                authAdminVo.setMark("<");
            }

            vo = (AuthAdminVo) selectByPk(sqlMapNs + "adminUrlOrder11", authAdminVo);
            ZPrint.print(authAdminVo.toString());
            authAdminVo.setUrlnonew(vo.getUrlnonew());

            if (authAdminVo.getUrlnonew() > 0) {
                ZPrint.print("new urlno = " + authAdminVo.getUrlnonew());
                update(sqlMapNs + "adminUrlOrder12", authAdminVo);
                update(sqlMapNs + "adminUrlOrder13", authAdminVo);
                update(sqlMapNs + "adminUrlOrder14", authAdminVo);
            }
        }
    }

	public String findOneUserOtpKey(String userId) {
		return (String)select(sqlMapNs + "findOneUserOtpKey", userId);
	}

	public void insertUserOtpKey(UserOtpVo userOtpVo) {
		insert(sqlMapNs + "insertUserOtpKey", userOtpVo);	
	}
}
