<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.wookook.spring.vo.BookVO"%>
<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>rwp
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	result <br><br>
	<% ArrayList<BookVO> list = (ArrayList<BookVO>)request.getAttribute("getlist"); %>
	<% for(int i = 0; i < list.size(); i++ ) {
		out.println(list.get(i).getBookid());
		out.println(list.get(i).getBookname());
		out.println(list.get(i).getPublisher());
		out.println(list.get(i).getPrice());
		out.println("<input type = 'button' value = '삭제' onclick=" + "location.href='bookdelete?bookid="+ list.get(i).getBookid() +"'>");
		out.println("<br>");
	} %>
	
</body>
</html>