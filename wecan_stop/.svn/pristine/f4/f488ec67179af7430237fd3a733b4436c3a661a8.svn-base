package com.z5.zcms.util;

import com.oreilly.servlet.MultipartRequest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;


/**
 * 유형 설명을 삽입하십시오.
 * 작성 날짜: (2002-08-26 오전 11:31:05)
 *
 * @author: Administrator
 */
public class DataTable extends Hashtable<Object, Object> {

    /**
     *
     */
    private static final long                                  serialVersionUID = 1L;
    private              Enumeration<?>                        _enum            = null;
    private              javax.servlet.http.HttpServletRequest request          = null;
    private              MultipartRequest                      multirequest     = null;
    private              org.w3c.dom.Document                  doc              = null;

    /**
     * DataTable 생성자 주석.
     */
    public DataTable() {
        super();
    }

    /**
     * ResultSet 을 받아 super class를 초기화 하는 생성자
     *
     * @param rs ResultSet
     */
    public DataTable(ResultSet rs) {
        super();
        initResultSet(rs);
    }

    /**
     * ResultSet 을 받아 super class를 초기화 하는 생성자
     *
     * @param doc Document
     */
    public DataTable(Document doc) {
        super();
        this.doc = doc;
        initDocument(doc);
    }

    /**
     * Hashtable 을 받아 super class를 초기화 하는 생성자
     *
     * @param Hashtable hash
     */
    public DataTable(Hashtable<?, ?> hash) {
        super();
        initHashtable(hash);
    }

    /**
     * request 받아 super class를 초기화 하는 생성자
     *
     * @param request HttpServletRequest
     */
    public DataTable(HttpServletRequest request) {
        super();
        this.request = request;
        init(request);
    }

    /**
     * COS의 MultipartRequest 받아 super class를 초기화 하는 생성자
     *
     * @param request MultipartRequest
     */
    public DataTable(MultipartRequest request) {
        super();
        this.multirequest = request;
        init(multirequest);
    }

    /**
     * 공백을 체크하는 private method
     * 작성 날짜: (2002-08-26 오전 11:35:52)
     *
     * @param v java.lang.Object
     * @return java.lang.String
     */
    private static String nvl(Object v) {
        if (v == null) return "";
        else return (v.toString());
    }

    /**
     * String key를 인자로 받아 String을 return 한다. null 이면 ""을 return
     * 작성 날짜: (2002-08-26 오전 11:33:27)
     *
     * @param key java.lang.String
     * @return java.lang.String
     */
    public String get(String key) {
        if (super.get(key) == null || nvl(super.get(key)).equals("")) return "";
        else return nvl(super.get(key));
    }

    /**
     * String key와 int default value을 인자로 받아 String을 return 한다. null 이면 기본 value를 return
     * 작성 날짜: (2002-08-26 오전 11:33:27)
     *
     * @param key   java.lang.String
     * @param value int
     * @return java.lang.String
     */
    public String get(String key, int value) {
        if (super.get(key) == null || nvl(super.get(key)).equals("")) return Integer.toString(value);
        else return nvl(super.get(key));
    }

    /**
     * String key와 String default value을 인자로 받아 String을 return 한다. null 이면 기본 value를 return
     * 작성 날짜: (2002-08-26 오전 11:33:27)
     *
     * @param key   java.lang.String
     * @param value java.lang.String
     * @return java.lang.String
     */
    public String get(String key, String value) {

        if (super.get(key) == null || nvl(super.get(key)).equals("")) return value;
        else return nvl(super.get(key));
    }

    /**
     * String key를 인자로 받아 boolean value를 return 한다.
     *
     * @param key java.lang.String
     * @return boolean
     */
    public boolean getBool(String key) {
        if (super.get(key) == null || nvl(super.get(key)).equals("")) return false;
        else return Integer.parseInt(nvl(super.get(key))) > 0;
    }

    /**
     * String key를 인자로 받아 int value를 return 한다.
     * 작성 날짜: (2002-11-12 오후 2:25:38)
     *
     * @param key java.lang.String
     * @return int
     */
    public int getInt(String key) {
        if (super.get(key) == null || nvl(super.get(key)).equals("")) return 0;
        else return Integer.parseInt(nvl(super.get(key)));
    }

    /**
     * String key와 int default value을 인자로 받아 int value을 return 한다. null 이면 기본 value를 return
     * 작성 날짜: (2002-11-12 오후 2:25:38)
     *
     * @param key   java.lang.String
     * @param value int
     * @return int
     */
    public int getInt(String key, int value) {
        if (super.get(key) == null || nvl(super.get(key)).equals("")) return value;
        else return Integer.parseInt(nvl(super.get(key)));
    }

    /**
     * String key와 String default value을 인자로 받아 int value을 return 한다. null 이면 기본 value를 int 로 return
     * 작성 날짜: (2002-11-12 오후 2:25:38)
     *
     * @param key   java.lang.String
     * @param value java.lang.String
     * @return int
     */
    public int getInt(String key, String value) {
        if (super.get(key) == null || nvl(super.get(key)).equals("")) return Integer.parseInt(value);
        else return Integer.parseInt(nvl(super.get(key)));
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-27 오후 5:53:55)
     *
     * @return boolean
     */
    public boolean hasMoreElements() {
        return _enum.hasMoreElements();
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-26 오후 11:25:34)
     *
     * @param request HttpServletRequest
     */
    private void init(HttpServletRequest request) {

        try {
            _enum = null;
            _enum = request.getParameterNames();
            while (_enum.hasMoreElements()) {

                String key = (String) _enum.nextElement();

                //일반적인 파라미터를 셋팅
                //this.put(key, new String(nvl(request.getParameter(key)).getBytes("ISO-8859-1"), "utf-8"));
                this.put(key, nvl(request.getParameter(key)));

                //checkbox 같은 배열 파라미터 셋팅
                String[] pv = null;
                if (request.getParameterValues(key) != null) {
                    pv = request.getParameterValues(key);
                    if (pv.length > 1) this.put(key, pv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init(MultipartRequest request) {

        try {
            _enum = null;
            _enum = request.getParameterNames();
            while (_enum.hasMoreElements()) {

                String key = (String) _enum.nextElement();

                //일반적인 파라미터를 셋팅
                //this.put(key, new String(nvl(request.getParameter(key)).getBytes("ISO-8859-1"), "utf-8"));
                this.put(key, nvl(request.getParameter(key)));

                //checkbox 같은 배열 파라미터 셋팅
                String[] pv = null;
                if (request.getParameterValues(key) != null) {
                    pv = request.getParameterValues(key);
                    if (pv.length > 1) this.put(key, pv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-27 오후 5:51:29)
     */
    public void initKeys() {
        _enum = null;
        _enum = super.keys();
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-26 오후 11:25:34)
     *
     * @param rs ResultSet
     */
    private void initResultSet(ResultSet rs) {

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            if (rs.isBeforeFirst()) rs.next();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                this.put(rsmd.getColumnName(i).toLowerCase(), rs.getString(i));
                //this.put(rsmd.getColumnName(i), rs.getString(i));
                //String val = new String(rs.getString(i).getBytes("UTF-8"), "ISO-8859-1");
                //this.put(rsmd.getColumnName(i), val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-26 오후 11:25:34)
     *
     * @param Hashtable hash
     */
    private void initHashtable(Hashtable<?, ?> hash) {

        try {

            _enum = null;
            _enum = hash.keys();
            while (_enum.hasMoreElements()) {

                String key = (String) _enum.nextElement();

                //일반적인 파라미터를 셋팅
                this.put(key, nvl(hash.get(key)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
	private void initDocument(Document doc) {

		try {
			Node node = doc.getDocumentElement();
			this.put("xmlStr", node.getNodeName());
			NamedNodeMap map = node.getAttributes();
			for (int i = 0 ; i < map.getLength() ; i++) {
				Node attributeNode = map.item(i);
				this.put("xmlAtr_" + attributeNode.getNodeName(), attributeNode.getNodeValue());
			}

			NodeList dataList = node.getChildNodes();
			for (int i = 0 ; i < dataList.getLength() ; i++) {
				Node dataNode = dataList.item(i);
				this.put(dataNode.getNodeName(), ((Element) dataNode).getAttribute("value"));
				NamedNodeMap dataMap = dataNode.getAttributes();
				for (int j = 0 ; j < dataMap.getLength() ; j++) {
					Node dataAttributeNode = dataMap.item(j);
					if (!dataAttributeNode.getNodeName().equals("value") && !dataAttributeNode.getNodeName().equals("pk") && !dataAttributeNode.getNodeName().equals("type") && !dataAttributeNode.getNodeName().equals("valueType") && !dataAttributeNode.getNodeName().equals("length"))
					{
						this.put(dataNode.getNodeName() + "_Atr_" + dataAttributeNode.getNodeName(), dataAttributeNode.getNodeValue());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-26 오후 11:25:34)
     *
     * @param doc Document
     */
    private void initDocument(Document doc) {
        try {
            Vector<DataTable> resultList = new Vector<DataTable>();
            Element           root       = doc.getDocumentElement();

            NodeList item = root.getElementsByTagName("item");
            for (int i = 0; i < item.getLength(); i++) {
                DataTable dt       = new DataTable();
                NodeList  nodelist = item.item(i).getChildNodes();

                for (int j = 0; j < nodelist.getLength(); j++) {
                    Node   n         = nodelist.item(j);
                    String tagName   = n.getNodeName();
                    String nodeValue = "";
                    if (tagName.equals("point")) {
                        NodeList nodelist2 = nodelist.item(j).getChildNodes();
                        for (int k = 0; k < nodelist2.getLength(); k++) {
                            Node n2 = nodelist2.item(k);
                            try {
                                dt.put(n2.getNodeName(), n2.getFirstChild().getNodeValue());
                            } catch (NullPointerException ne) {
                            }
                        }
                    } else {
                        try {
                            nodeValue = n.getFirstChild().getNodeValue();
                        } catch (NullPointerException ne) {
                        }
                        dt.put(tagName, nodeValue);
                    }
                }
                resultList.add(dt);
            }
            this.put("item", resultList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-27 오후 5:55:25)
     *
     * @return java.lang.Object
     */
    public Object nextObject() {
        return _enum.nextElement();
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-27 오후 5:55:25)
     *
     * @return java.lang.String
     */
    public String nextString() {
        return (String) _enum.nextElement();
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-28 오전 4:54:41)
     *
     * @param key   int
     * @param value int
     */
    public void put(int key, int value) {
        super.put(Integer.toString(key), Integer.toString(value));
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-28 오전 4:53:46)
     *
     * @param key   int
     * @param value java.lang.String
     */
    public void put(int key, String value) {
        super.put(Integer.toString(key), nvl(value));
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-28 오전 4:49:50)
     *
     * @param key   java.lang.String
     * @param value int
     */
    public void put(String key, int value) {
        super.put(key, Integer.toString(value));
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-10-22 오후 5:25:14)
     *
     * @param key   java.lang.String
     * @param value java.lang.Object
     */
    public void put(String key, Object value) {
        super.put(key, value);
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-26 오전 11:33:06)
     *
     * @param key   java.lang.String
     * @param value java.lang.String
     */
    public void put(String key, String value) {
        super.put(key, nvl(value));
    }

    /**
     * String key를 인자로 받아 object를 return 한다.
     * 작성 날짜: (2002-08-26 오전 11:33:27)
     *
     * @param key java.lang.String
     * @return java.lang.Object
     */
    public Object getObject(String key) {
        return super.get(key);
    }

    /**
     * String key를 인자로 받아 String[] value를 return 한다.
     * 만약 값이 하나일경우 배열 size는 1로 하여 String[] 를 return 한다.
     * 작성 날짜: (2003-02-05 오후 1:55:11)
     *
     * @param key java.lang.String
     * @return java.lang.String[]
     */
    public String[] getValues(String key) {

        if (super.get(key) != null) {
            try {
                return (String[]) super.get(key);
            } catch (java.lang.ClassCastException e) {
                String[] rv = {(String) super.get(key)};
                return rv;
            }
        } else {
            return null;
        }
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2003-02-06 오전 10:08:01)
     *
     * @param rs java.sql.ResultSet
     * @throws java.lang.Exception 예외 설명.
     */
    public void setResultSet(ResultSet rs) {
        initResultSet(rs);
    }

    /**
     * String key를 인자로 받아 long value를 return 한다.
     * 작성 날짜: (2002-11-12 오후 2:25:38)
     *
     * @param key java.lang.String
     * @return long
     */
    public long getLong(String key) {
        return new Long(nvl(super.get(key))).longValue();
    }

    /**
     * String key와 long default value을 인자로 받아 long value을 return 한다. null 이면 기본 value를 return
     * 작성 날짜: (2002-11-12 오후 2:25:38)
     *
     * @param key   java.lang.String
     * @param value long
     * @return long
     */
    public long getLong(String key, long value) {
        if (super.get(key) == null || nvl(super.get(key)).equals("")) return value;
        else return new Long(nvl(super.get(key))).longValue();
    }

    /**
     * String key와 String default value을 인자로 받아 long value을 return 한다. null 이면 기본 value를 long 로 return
     * 작성 날짜: (2002-11-12 오후 2:25:38)
     *
     * @param key   java.lang.String
     * @param value java.lang.String
     * @return long
     */
    public long getLong(String key, String value) {
        if (super.get(key) == null || nvl(super.get(key)).equals("")) return new Long(value).longValue();
        else return new Long(nvl(super.get(key))).longValue();
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2003-07-19 오후 11:05:56)
     *
     * @return javax.servlet.http.HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        return this.request;
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2003-02-06 오전 10:06:35)
     *
     * @param request javax.servlet.http.HttpServletRequest
     */
    public void setRequest(HttpServletRequest request) {
        init(request);
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2003-07-19 오후 11:05:56)
     *
     * @return javax.servlet.http.HttpServletRequest
     */
    public Document getDocument() {
        return this.doc;
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2003-02-06 오전 10:08:01)
     *
     * @param doc org.w3c.Document
     * @throws java.lang.Exception 예외 설명.
     */
    public void setDocument(Document doc) {
        initDocument(doc);
    }

    /**
     * 메소드 설명을 삽입하십시오.
     * 작성 날짜: (2002-08-28 오전 4:49:50)
     *
     * @param key   java.lang.String
     * @param value int
     */
    public void put(String key, long value) {
        super.put(key, Long.toString(value));
    }

}
