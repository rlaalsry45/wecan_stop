package com.z5.zcms.admsys.common.domain;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommonVo implements Serializable {
    private static final long serialVersionUID = -2138150763032958204L;

    private int           pageSize  = 10;
    private int           pageIndex = 0;
    private int           pageTotal = 0;
    private int           total     = 0;
    private String        cond1     = "";
    private String        cond2     = "";
    private String        cond3     = "";
    private String        keyword   = "";
    private String        sdate     = "";
    private String        edate     = "";
    private int           m;
    private int           n;
    private String        sitedomain;
    private String        sitetitle;
    private String        tx_content;
    private String        tblname;
    private int           cnt;
    private int           maxno;
    private List<Integer> arrDeleteNo;
    private List<Integer> arrIntegerNo;
    private String        his;
    private int           prevno;
    private int           nextno;
    private String        ctitle;
    private String        ckeditorConts;
    private String        cateno;

    private String         dateKey;
    private String         dateOne;
    private String         dateTwo;
    private String         compKey;
    private String         compVal;
    private String         isntKey;
    private String         isntVal;
    private String         sortKey;
    private String         sortVal;
    private String         bestKey;
    private String         bestVal;
    private String         joint;
    private List<QueryMap> words;
    private List<QueryMap> likes;
    private List<QueryMap> like2;
    private List<QueryMap> sames;
    private List<QueryMap> nones;
    private List<String>   kinds;
    private List<QueryMap> sorts;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCond1() {
        return cond1;
    }

    public void setCond1(String cond1) {
        this.cond1 = cond1;
    }

    public String getCond2() {
        return cond2;
    }

    public void setCond2(String cond2) {
        this.cond2 = cond2;
    }

    public String getCond3() {
        return cond3;
    }

    public void setCond3(String cond3) {
        this.cond3 = cond3;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getSitedomain() {
        return sitedomain;
    }

    public void setSitedomain(String sitedomain) {
        this.sitedomain = sitedomain;
    }

    public String getSitetitle() {
        return sitetitle;
    }

    public void setSitetitle(String sitetitle) {
        this.sitetitle = sitetitle;
    }

    public String getTx_content() {
        return tx_content;
    }

    public void setTx_content(String tx_content) {
        this.tx_content = tx_content;
    }

    public String getTblname() {
        return tblname;
    }

    public void setTblname(String tblname) {
        this.tblname = tblname;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getMaxno() {
        return maxno;
    }

    public void setMaxno(int maxno) {
        this.maxno = maxno;
    }

    public List<Integer> getArrDeleteNo() {
        return arrDeleteNo;
    }

    public void setArrDeleteNo(List<Integer> arrDeleteNo) {
        this.arrDeleteNo = arrDeleteNo;
    }

    public List<Integer> getArrIntegerNo() {
        return arrIntegerNo;
    }

    public void setArrIntegerNo(List<Integer> arrIntegerNo) {
        this.arrIntegerNo = arrIntegerNo;
    }

    public String getHis() {
        return his;
    }

    public void setHis(String his) {
        this.his = his;
    }

    public int getPrevno() {
        return prevno;
    }

    public void setPrevno(int prevno) {
        this.prevno = prevno;
    }

    public int getNextno() {
        return nextno;
    }

    public void setNextno(int nextno) {
        this.nextno = nextno;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public String getCkeditorConts() {
        return ckeditorConts;
    }

    public void setCkeditorConts(String ckeditorConts) {
        this.ckeditorConts = ckeditorConts;
    }

    public String getCateno() {
        return cateno;
    }

    public void setCateno(String cateno) {
        this.cateno = cateno;
    }

    public String getDateKey() {
        return dateKey;
    }

    public void setDateKey(String dateKey) {
        this.dateKey = dateKey;
    }

    public String getDateOne() {
        return dateOne;
    }

    public void setDateOne(String dateOne) {
        this.dateOne = dateOne;
    }

    public String getDateTwo() {
        return dateTwo;
    }

    public void setDateTwo(String dateTwo) {
        this.dateTwo = dateTwo;
    }

    public String getCompKey() {
        return compKey;
    }

    public void setCompKey(String compKey) {
        this.compKey = compKey;
    }

    public void setCompKV(String key, String value) {
        this.compKey = key;
        this.compVal = value;
    }

    public void setCompKV(String key, int value) {
        this.compKey = key;
        this.compVal = Integer.toString(value);
    }

    public String getCompVal() {
        return compVal;
    }

    public void setCompVal(String compVal) {
        this.compVal = compVal;
    }

    public String getIsntKey() {
        return isntKey;
    }

    public void setIsntKey(String isntKey) {
        this.isntKey = isntKey;
    }

    public void setIsntKV(String key, String value) {
        this.isntKey = key;
        this.isntVal = value;
    }

    public void setIsntKV(String key, int value) {
        this.isntKey = key;
        this.isntVal = Integer.toString(value);
    }

    public String getIsntVal() {
        return isntVal;
    }

    public void setIsntVal(String isntVal) {
        this.isntVal = isntVal;
    }

    public void setSortKV(String key, String value) {
        this.sortKey = key;
        this.sortVal = value;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getSortVal() {
        return sortVal;
    }

    public void setSortVal(String sortVal) {
        this.sortVal = sortVal;
    }

    public String getBestKey() {
        return bestKey;
    }

    public void setBestKey(String bestKey) {
        this.bestKey = bestKey;
    }

    public String getBestVal() {
        return bestVal;
    }

    public void setBestVal(String bestVal) {
        this.bestVal = bestVal;
    }

    public void setBestKV(String key, String value) {
        this.bestKey = key;
        this.bestVal = value;
    }

    public String getJoint() {
        return joint;
    }

    public void setJoint(String joint) {
        this.joint = joint;
    }

    public List<QueryMap> getWords() {
        return words;
    }

    public void setWords(List<QueryMap> words) {
        this.words = words;
    }

    public void setWords(Map<String, String> queries) {
        List<QueryMap> list  = new ArrayList<QueryMap>();
        int            index = 0;
        for (Map.Entry<String, String> entry : queries.entrySet()) {
            QueryMap data = new QueryMap();
            data.setKey(entry.getKey());
            data.setValue(entry.getValue());
            data.setJoint(index == 0 ? "" : "OR");
            list.add(data);
            index++;
        }
        this.words = list;
    }

    public void setWords(String... values) {
        if (values.length >= 2) {
            QueryMap queryMap = new QueryMap();
            queryMap.setKey(values[0]);
            queryMap.setValue(values[1]);
            String joint = values.length >= 3 ? values[2] : "AND";
            queryMap.setJoint(joint);

            if (this.words != null) {
                this.words.add(queryMap);
            } else {
                List<QueryMap> each = new ArrayList<QueryMap>();
                each.add(queryMap);
                this.words = each;
            }

            this.words = queryMapJoint(this.words, joint);
        }
    }

    public List<QueryMap> getLikes() {
        return likes;
    }

    public void setLikes(List<QueryMap> likes) {
        this.likes = likes;
    }

    public void setLikes(Map<String, String> queries) {
        List<QueryMap> list = new ArrayList<QueryMap>();
        for (Map.Entry<String, String> entry : queries.entrySet()) {
            QueryMap data = new QueryMap();
            data.setKey(entry.getKey());
            data.setValue(entry.getValue());
            list.add(data);
        }
        this.likes = list;
    }

    public void setLikes(String... values) {
        if (values.length >= 2) {
            QueryMap queryMap = new QueryMap();
            queryMap.setKey(values[0]);
            queryMap.setValue(values[1]);
            String joint = values.length >= 3 ? values[2] : "OR";
            queryMap.setJoint(joint);

            if (this.likes != null) {
                this.likes.add(queryMap);
            } else {
                List<QueryMap> each = new ArrayList<QueryMap>();
                each.add(queryMap);
                this.likes = each;
            }

            this.likes = queryMapJoint(this.likes, joint);
        }
    }

    public List<QueryMap> getLike2() {
        return like2;
    }

    public void setLike2(List<QueryMap> like2) {
        this.like2 = like2;
    }

    public List<QueryMap> getSames() {
        return sames;
    }

    public void setSames(List<QueryMap> sames) {
        this.sames = sames;
    }

    public void setSames(Map<String, String> sames) {
        List<QueryMap> list = new ArrayList<QueryMap>();
        for (Map.Entry<String, String> entry : sames.entrySet()) {
            QueryMap data = new QueryMap();
            data.setKey(entry.getKey());
            data.setValue(entry.getValue());
            list.add(data);
        }
        this.sames = list;
    }

    public void setSames(String... values) {
        if (values.length >= 2) {
            QueryMap queryMap = new QueryMap();
            queryMap.setKey(values[0]);
            queryMap.setValue(values[1]);
            String joint = values.length >= 3 ? values[2] : "AND";
            queryMap.setJoint(joint);

            if (this.sames != null) {
                this.sames.add(queryMap);
            } else {
                List<QueryMap> each = new ArrayList<QueryMap>();
                each.add(queryMap);
                this.sames = each;
            }

            this.sames = queryMapJoint(this.sames, joint);
        }
    }

    public List<QueryMap> getSorts() {
        return sorts;
    }

    public void setSorts(List<QueryMap> sorts) {
        this.sorts = sorts;
    }

    public void setSorts(Map<String, String> sorts) {
        List<QueryMap> list = new ArrayList<QueryMap>();
        for (Map.Entry<String, String> entry : sorts.entrySet()) {
            QueryMap data = new QueryMap();
            data.setKey(entry.getKey());
            data.setValue(entry.getValue());
            list.add(data);
        }
        this.sorts = list;
    }

    public void setSorts(String... values) {
        if (values.length >= 2) {
            QueryMap queryMap = new QueryMap();
            queryMap.setKey(values[0]);
            queryMap.setValue(values[1]);
            String joint = values.length >= 3 ? values[2] : "AND";
            queryMap.setJoint(joint);

            if (this.sorts != null) {
                this.sorts.add(queryMap);
            } else {
                List<QueryMap> each = new ArrayList<QueryMap>();
                each.add(queryMap);
                this.sorts = each;
            }

            this.sorts = queryMapJoint(this.sorts, joint);
        }
    }

    public List<QueryMap> getNones() {
        return nones;
    }

    public void setNones(List<QueryMap> nones) {
        this.nones = nones;
    }

    public void setNones(String... values) {
        if (values.length >= 2) {
            QueryMap queryMap = new QueryMap();
            queryMap.setKey(values[0]);
            queryMap.setValue(values[1]);
            String joint = values.length >= 3 ? values[2] : "AND";
            queryMap.setJoint(joint);

            if (this.nones != null) {
                this.nones.add(queryMap);
            } else {
                List<QueryMap> each = new ArrayList<QueryMap>();
                each.add(queryMap);
                this.nones = each;
            }

            this.nones = queryMapJoint(this.nones, joint);
        }
    }

    public List<String> getKinds() {
        return kinds;
    }

    public void setKinds(List<String> kinds) {
        this.kinds = kinds;
    }

    public void setKinds(String value) {
        if (this.kinds != null) {
            this.kinds.add(value);
        } else {
            List<String> temp = new ArrayList<String>();
            temp.add(value);
            this.kinds = temp;
        }
    }

    private List<QueryMap> queryMapJoint(List<QueryMap> queryMaps, String joint) {
        if (queryMaps != null && queryMaps.size() > 0) {
            int index = 0;
            for (QueryMap each : queryMaps) {
                if (index == 0) {
                    each.setJoint("");
                } else if (StringUtils.isBlank(each.getJoint())) {
                    each.setJoint(joint);
                }
                index++;
            }
        }
        return queryMaps;
    }

    private String queryMapToString(List<QueryMap> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null && list.size() > 0) {
            stringBuilder.append(list.size()).append("{");
            for (QueryMap each : list) {
                stringBuilder.append("[").append(each.getKey()).append(":").append(each.getValue()).append("]");
            }
            stringBuilder.append("}");
        }
        return stringBuilder.toString();
    }

    public String toComString() {
        return "CommonVo{" +
                "pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", pageTotal=" + pageTotal +
                ", total=" + total +
                ", m=" + m +
                ", n=" + n +
                ", cateno='" + cateno + '\'' +
                ", dateKey='" + dateKey + '\'' +
                ", dateOne='" + dateOne + '\'' +
                ", dateTwo='" + dateTwo + '\'' +
                ", compKey='" + compKey + '\'' +
                ", compVal='" + compVal + '\'' +
                ", isntKey='" + isntKey + '\'' +
                ", isntVal='" + isntVal + '\'' +
                ", sortKey='" + sortKey + '\'' +
                ", sortVal='" + sortVal + '\'' +
                ", bestKey='" + bestKey + '\'' +
                ", bestVal='" + bestVal + '\'' +
                ", words=" + queryMapToString(words) +
                ", likes=" + queryMapToString(likes) +
                ", sames=" + queryMapToString(sames) +
                ", sorts=" + queryMapToString(sorts) +
                '}';
    }
}

