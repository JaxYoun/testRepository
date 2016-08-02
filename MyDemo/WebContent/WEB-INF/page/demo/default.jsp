<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/in.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>defalt</title>
<script type="text/javascript">
	$().ready(function(){
		$.ajax({
			url : "${ctx}/demo/sayHi1.do",
			type : 'post',
			data : {'id' : 1},
			dataType : 'json',
			success : function(data){
				data.list.forEach(function (it) {
					alert(it.name);
				});
				/* for(var it in data.list){
					alert(data.list[it].name);
				} */
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
				alert('err');
			}
		});
	});
</script>
</head>
<body>
	<h1>${ctx}</h1>
</body>
</html>