package com.z5.zcms.util;

import java.sql.*;

public class PrintMgr {

	/**
	 * PrintMgr 생성자 주석.
	 */
	public PrintMgr() {
		super();
	}

	/**
	 * 해당 에러를 화면에 출력
	 * 작성 날짜: (2003-07-27 오전 3:37:37)
	 * @return java.lang.String
	 * @param e java.lang.Exception
	 * @exception java.lang.Exception 예외 설명.
	 */
	public static void ePrint(Exception e, String method) throws Exception {
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ printStackTrace - "+method+" ]");
		e.printStackTrace();
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ getMessage - "+method+" ]");
		System.out.println(e.getMessage());
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ toString - "+method+" ]");
		System.out.println(e.toString());
		System.out.println("-----------------------------------------------------------");
	}



	/**
	 * 해당 에러를 화면에 출력
	 * 작성 날짜: (2003-07-27 오전 3:37:37)
	 * @return java.lang.String
	 * @param e java.lang.Exception
	 * @exception java.lang.Exception 예외 설명.
	 */
	public static void ePrint(SQLException e, String method) throws Exception {
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ printStackTrace - "+method+" ]");
		e.printStackTrace();
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ getMessage - "+method+" ]");
		System.out.println(e.getMessage());
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ toString - "+method+" ]");
		System.out.println(e.toString());
		System.out.println("-----------------------------------------------------------");
	}



	/**
	 * 해당 쿼리문을 화면에 출력
	 * 작성 날짜: (2003-07-27 오전 3:43:02)
	 * @param query java.lang.String
	 * @param method java.lang.String
	 * @exception java.lang.Exception 예외 설명.
	 */
	public static void sqlPrint(String query, String method) throws Exception {
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ query - "+method+" ]");
		System.out.println(query);
		System.out.println("-----------------------------------------------------------");
	}



	


	/**
	 * 해당 에러를 화면에 출력
	 * 작성 날짜: (2003-07-27 오전 3:37:37)
	 * @return java.lang.String
	 * @param e java.lang.Exception
	 * @exception java.lang.Exception 예외 설명.
	 */
	public static void ePrint(Exception e, Object obj, String method) throws Exception {
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ printStackTrace - "+ obj.getClass() +":" + method+" ]");
		e.printStackTrace();
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ getMessage - "+ obj.getClass() +":"+method+" ]");
		System.out.println(e.getMessage());
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ toString - "+ obj.getClass() +":"+method+" ]");
		System.out.println(e.toString());
		System.out.println("-----------------------------------------------------------");
	}


	/**
	 * 해당 에러를 화면에 출력
	 * 작성 날짜: (2003-07-27 오전 3:37:37)
	 * @return java.lang.String
	 * @param e java.lang.Exception
	 * @exception java.lang.Exception 예외 설명.
	 */
	public static void ePrint(SQLException e, Object obj, String method) throws Exception {
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ printStackTrace - "+ obj.getClass() +":"+method+" ]");
		e.printStackTrace();
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ getMessage - "+ obj.getClass() +":"+method+" ]");
		System.out.println(e.getMessage());
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ toString - "+ obj.getClass() +":"+method+" ]");
		System.out.println(e.toString());
		System.out.println("-----------------------------------------------------------");
	}	
	
	
	/**
	 * 해당 쿼리문을 화면에 출력
	 * 작성 날짜: (2003-07-27 오전 3:43:02)
	 * @param query java.lang.String
	 * @param method java.lang.String
	 * @exception java.lang.Exception 예외 설명.
	 */
	public static void sqlPrint(String query, Object obj, String method) throws Exception {
		System.out.println("-----------------------------------------------------------");
		System.out.println("[ query - "+ obj.getClass() +":"+method+" ]");
		System.out.println(query);
		System.out.println("-----------------------------------------------------------");
	}
	
	}
