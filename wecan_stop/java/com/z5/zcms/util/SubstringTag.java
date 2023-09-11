package com.z5.zcms.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SubstringTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    private String str;
    private int    length;
    private String endChar;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getEndChar() {
        return endChar;
    }

    public void setEndChar(String endChar) {
        this.endChar = endChar;
    }

    @Override
    public int doStartTag() throws JspException {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(subStringBytes(this.str, this.length, this.endChar));
        try {
            pageContext.getOut().write(stringBuffer.toString());
        } catch (Exception e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }

    public String subStringBytes(String str, int byteLength, String endChar) {
        int retLength = 0;
        int tempSize  = 0;
        int asc;
        str = str.trim();
        if (str == null || "".equals(str) || "null".equals(str)) {
            //return "Startup StringTag message:스트링값을 입력해주세요";
            return "";
        }
        if (byteLength < 1) {
            return "Startup StringTag message:잘라낼 글자의 수는 0 이상이 되어야합니다.";
        }
        if (endChar == null || endChar.equals("") || endChar.equals("null")) {
            endChar = "...";
        }

        int length = str.length();

        for (int i = 1; i <= length; i++) {
            asc = (int) str.charAt(i - 1);
            if (asc > 127) {
                if (byteLength >= tempSize + 2) {
                    tempSize += 2;
                    retLength++;
                } else {
                    return str.substring(0, retLength) + endChar;
                }
            } else {
                if (byteLength > tempSize) {
                    tempSize++;
                    retLength++;
                } else {
                    return str.substring(0, retLength) + endChar;
                }
            }
        }

        return str.substring(0, retLength);
    }
}
