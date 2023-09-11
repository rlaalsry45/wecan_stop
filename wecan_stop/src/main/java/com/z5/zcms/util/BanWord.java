package com.z5.zcms.util;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;

public class BanWord {

	private static Pattern ban_pattern = null;

	public static String ChkBanWord(Object input, Object banword){

		String result ="";
		StringTokenizer tokenizer = null;

		if (banword instanceof DataTable){
			tokenizer = new StringTokenizer(((DataTable) banword).get("bannedword"),";");
		}
		else if (banword instanceof String){
			tokenizer = new StringTokenizer((String) banword,";");
		}

		DataTable inputs = null;
		if (input instanceof HttpServletRequest){
			inputs = new DataTable((HttpServletRequest)input);
		}
		else if (input instanceof MultipartRequest){
			inputs = new DataTable((MultipartRequest)input);
		}
		else if (input instanceof DataTable){
			inputs = (DataTable)input;
		}

		try {

			String token = null;
			while (tokenizer != null && tokenizer.hasMoreTokens()) {
				token = tokenizer.nextToken();
				if(token != null && token.length() > 0){
					ban_pattern = Pattern.compile(token);
					Enumeration<?> _enum = inputs.elements();
					while(_enum.hasMoreElements()){
						Object obj =  _enum.nextElement();
						if (obj instanceof String){
							Matcher matcher = ban_pattern.matcher((String)obj);
							if(matcher.find()){
								return matcher.group();
							}
						}
						else if (obj instanceof String[]){
							String[] elements = (String[])obj;
							for(String element : elements){
								Matcher matcher = ban_pattern.matcher(element);
								if(matcher.find()){
									return matcher.group();
								}
							}
						}
					}
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
