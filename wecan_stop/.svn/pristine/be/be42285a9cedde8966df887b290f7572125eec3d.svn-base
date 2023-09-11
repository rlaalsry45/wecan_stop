package com.z5.zcms.util;

import java.util.ArrayList;
import java.util.List;

import com.z5.zcms.admsys.auth.domain.MenuAuthVo;

public class TreeUtil {

    private static List<MenuAuthVo> authMenuList = null;

    public static List<MenuAuthVo> getAuthMenuTree(List<MenuAuthVo> authMenu){

        try {
            for(MenuAuthVo node1 : authMenu) {
                for(MenuAuthVo node2 : authMenu) {
                    if (node2.getUrltopno() == node1.getUrltopno()) {
                        if (node2.getUrlstep() > node1.getUrlstep()) {
                            if (node1.getUrllink() != null && node1.getUrllink().indexOf(".") == -1) {
                                authMenu.get(authMenu.indexOf(node1)).setUrllink(node2.getUrllink());
                            }
                        }
                    }
                }
            }

            authMenuList = new ArrayList<MenuAuthVo>();

            for(MenuAuthVo node1 : authMenu){
                boolean flag = false;
                for(MenuAuthVo node2 : authMenu){
                    if(node1.getUrlparentno()==node2.getUrlno()){
                        flag = true;
                        if(null==node2.getChildren()) node2.setChildren(new ArrayList<MenuAuthVo>());
                        node2.getChildren().add(node1);
                        break;
                    }
                }
                if(!flag){
                    authMenuList.add(node1);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return authMenuList;
    }
}
