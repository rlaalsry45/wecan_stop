package com.z5.zcms.util;

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.net.URL;
import org.xml.sax.*;

public final class MapUtil {

	private MapUtil() {}

	public static DataTable GetGeocode(String query) {

		DataTable result = new DataTable();

		try {
			String szUrl = "http://map.naver.com/api/geocode.php?key=3dd873909883330c0acf2ff89e9b7984&query=" + query;

			InputStream is = null;
			InputStreamReader isr = null;

			is = new URL(szUrl).openStream();

			isr = new InputStreamReader(is, "euc-kr");

			StringBuffer sb = new StringBuffer(); int c;
			while ((c = isr.read()) != -1) {sb.append((char) c);}

			isr.close(); is.close();

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(false);
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document xmldoc = db.parse(new InputSource(new StringReader(sb.toString())));
			result = new DataTable(xmldoc);

		} catch(Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

}
