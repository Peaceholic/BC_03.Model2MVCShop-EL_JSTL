<%@ page contentType="text/html; charset=EUC-KR" %>

<%@ page import="com.model2.mvc.service.domain.Product" %>

<html>
<head>
<title>열어본 상품 보기</title>
</head>

<body>
	고객님 께서 열어본 상품 입니다.
<br>
<br>
<%
	request.setCharacterEncoding("euc-kr");
	response.setCharacterEncoding("euc-kr");
	
	String history = null;
	
	Cookie[] cookies = request.getCookies();
	Product	product = null;
	
	if (cookies!=null && cookies.length > 0) {
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("history")) {
				history = cookie.getValue();
			}
		}
		if (history != null) {
			String[] h = history.split(",");
			for (int i = 0; i < h.length; i++) {
					if (!h[i].equals("null")) {	
						
  					
 %>					
	<a href="/getProduct.do?prodNo=<%=h[i]%>&menu=search"	target="rightFrame"><%=h[i]%></a>
	<br>
<%
				}
			}
		}
	}
%>

</body>
</html>