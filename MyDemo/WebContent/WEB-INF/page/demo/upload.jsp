<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/in.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ctx}/demo/doUpload.do" method="post" enctype="multipart/form-data">
		<div>
			<label>文件域：</label>
			<input type="file" name="myFile" />
		</div>
		<input type="submit" value="上传"/>
	</form>
</body>
</html>