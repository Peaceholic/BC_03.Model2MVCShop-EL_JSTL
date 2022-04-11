package com.model2.mvc.common.util;

import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpUtil {

	/// Field

	/// Constructor

	/// Method
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {

		System.out.println("\n* [ HttpUtil : forward() ] ");

		System.out.println("\n* ==== START ==========================================================");

		// cookie에 있는 모든 데이터
		Cookie[] cookies = request.getCookies();
		int cookiesCount = 0;

		// cookie 객체의 모든 요소들
		if (cookies == null) {
			for (int i = 0; i < cookies.length; i++) {
				System.out.println("\n * 쿠키 " + "\n name : " + cookies[i].getName() + "\n value : " + cookies[i].getValue() );
				cookiesCount++;
			}
		}

		HttpSession session = request.getSession();

		// session에 있는 모든 데이터의 이름을 가져온다
		Enumeration sessionNames = session.getAttributeNames();
		int sessionCount = 0;

		// sessionNames 객체의 모든 요소들
		while (sessionNames.hasMoreElements()) {
			String key = sessionNames.nextElement().toString();
			String value = session.getAttribute(key).toString();
			String id = session.getId();
			System.out.println("\n * 세션 " + "\n id : " + id + "\n key : " + key + "\n value : " + value + "\n");
			sessionCount++;
		}

		// request에 있는 모든 데이터의 이름을 가져온다
		Enumeration requestNames = request.getAttributeNames();
		int requestCount = 0;

		// requestNames 객체의 모든 요소들
		while (requestNames.hasMoreElements()) {
			String key = requestNames.nextElement().toString();
			String value = request.getAttribute(key).toString();
			System.out.println("\n * request - " + requestCount + 1 + "\n key : " + key + "\n value : " + value + "\n");
			requestCount++;
		}
		
		System.out.println("\n* cookiesCount : " + cookiesCount);
		System.out.println("\n* sessionCount : " + sessionCount);
		System.out.println("\n* requestCount : " + requestCount);

		System.out.println("\n* ==== E N D ==========================================================");

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} catch (Exception ex) {
			System.out.println("forward 오류 : " + ex);
			throw new RuntimeException("forward 오류 : " + ex);
		}
	}

	public static void redirect(HttpServletResponse response, String path) {

		System.out.println("\n* [ HttpUtil : redirect() ] ");

		try {
			response.sendRedirect(path);
		} catch (Exception ex) {
			System.out.println("redirect 오류 : " + ex);
			throw new RuntimeException("redirect 오류  : " + ex);
		}
	}
}