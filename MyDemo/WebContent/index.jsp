<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/in.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<form action="${ctx}/demo/sayHi.do" method="post">
		ID<input name = "id" type = "text"/>
		名字<input name = "name" type = "text"/>
		密码<input name = "password" type = "password"/>
		<button type="submit">提交</button>
	</form>
</body>
</html>