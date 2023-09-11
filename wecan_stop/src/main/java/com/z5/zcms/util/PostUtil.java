package com.z5.zcms.util;

import egovframework.com.cmm.service.EgovProperties;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Vector;

import static com.z5.zcms.util.ZPrint.error;
import static com.z5.zcms.util.ZPrint.print;

public class PostUtil {

    private static Vector<DataTable> vt = new Vector<DataTable>();

    public static Vector<DataTable> getPost(DataTable input) throws Exception {
        try {
//			String IPADDR = "http://biz.epost.go.kr/KpostPortal/";
            String IPADDR = "http://biz.epost.go.kr/KpostPortal/openapi"; //5자리 우편번호

//			IPADDR += input.get("IE");
//			String REGKEY = "a813b4c2bdd447fe91354781065698";//zsol
//			String REGKEY = "5a14b249c83e87f5f1429199558719";//z5
            String REGKEY = EgovProperties.getProperty("Globals.post.key");
            String TARGET = "postNew";
            String query = input.get("query");
            String pageno = input.get("pageno");
            ZPrint.print("query : '" + query + "'");
            ZPrint.print("pageno: '" + pageno + "'");

            URL url = new URL(IPADDR +
                "?regkey=" + REGKEY +
                "&target=" + TARGET +
                "&query=" + URLEncoder.encode(query, "EUC-KR") +
                "&countPerPage=50&currentPage=" + pageno);
            ZPrint.print("epost : '" + url + "'");

            //URL 연결
            URLConnection conn = url.openConnection();
            //언어설정 :: 이부분 중요합니다. (이부분을 설정하지 않으면 한글 데이터가 들어오질 않습니다!!)
            conn.setRequestProperty("accept-language", "ko");

            //XML 자료 가져오기
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(conn.getInputStream());

            vt = new Vector<DataTable>();
            Element itemlist = doc.getRootElement().getChild("pageinfo");
            if (itemlist != null) {
                DataTable dt = new DataTable();
                dt.put("totalCount", itemlist.getChild("totalCount").getText());
                dt.put("totalPage", itemlist.getChild("totalPage").getText());
                dt.put("countPerPage", itemlist.getChild("countPerPage").getText());
                dt.put("currentPage", itemlist.getChild("currentPage").getText());
                vt.add(dt);

                itemlist = doc.getRootElement().getChild("itemlist");

                List<Element> list = itemlist.getChildren();
                for (Element item : list) {
                    dt = new DataTable();
                    dt.put("postcd", item.getChildText("postcd"));
                    dt.put("address", item.getChildText("address"));
                    dt.put("addrjibun", item.getChildText("addrjibun"));
                    vt.add(dt);
                }
            } else {
                error("Could not get epost for '" + input.get("query") + "'");
            }

            //itemlist 하위에 우편번호와 주소값을 가지고 있다.
//			itemlist = doc.getRootElement().getChild("itemlist");
//			if(itemlist == null){
//				return vt;
//			}else{
//
//				DataTable dt = null;
//
//				itemlist = doc.getRootElement().getChild("pageinfo");
//				dt.put("totalCount", itemlist.getChild("totalCount"));
//				dt.put("totalPage", itemlist.getChild("totalPage"));
//				dt.put("countPerPage", itemlist.getChild("countPerPage"));
//				dt.put("currentPage", itemlist.getChild("currentPage"));
//
//				vt.add(dt);
//
//				List<Element> list = itemlist.getChildren();
//				for (Element item : list){
//					dt = new DataTable();
//					dt.put("postcd", item.getChildText("postcd"));
//					dt.put("address", item.getChildText("address"));
//					dt.put("addrjibun", item.getChildText("addrjibun"));
//					vt.add(dt);
//				}
//			}

//			if(TARGET.equals("postNew")){
//				for (Element item : list){
//					dt = new DataTable();
//					dt.put(item.getChildText("postcd"), item.getChildText("address"));
//					vt.add(dt);
//				}
//			}
//
//			else{
//				for (Element item : list){
//					dt = new DataTable();
//					dt.put(item.getChildText("postCd"), item.getChildText("lnmAddress"));
//					vt.add(dt);
//				}
//			}

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vt;

/*		//검색결과가 여러개인 경우 반복하며 우편번호와 주소값을 뽑아낸다
        for(int i=0; i<list.size();i++){
			Element item = (Element)list.get(i);
			String address = item.getChildText("address");
			String postcd = item.getChildText("postcd");

			//address와 postcd 변수를 이용하여 자신에게 알맞는 형태로 사용하기
			//this.cbAddr.addItem(postcd+" | "+address);
		}
*/
    }
}
