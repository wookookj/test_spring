<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="bookinput" method="post">
		bookid : <input type ="text" name ="bookid" placeholder = "bookid"><br>
		bookname : <input type ="text" name ="bookname" placeholder = "bookname"><br>
		publisher : <input type ="text" name ="publisher" placeholder = "publisher"><br>
		price : <input type ="text" name ="price" placeholder = "price"><br><br>
		<input type="submit" value = "전송">
	</form>
</body>
</html>