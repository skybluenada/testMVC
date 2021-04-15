<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<% request.setCharacterEncoding("EUC-KR");%>   
<%
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>INSERT</title>
</head>
<body>
INSERT
<hr>
<%
	Object obj = request.getAttribute("bool");
	if (obj == null) return;
	
	boolean bool = ((Boolean)obj).booleanValue();
	
	if (bool){
		System.out.println("bool >>> : " + bool);
%>
		<script>
			location.href="/testMVC/kswBoardController?ISUD_TYPE=SALL";
		</script>
<%		
	}else{
		
	}
%>
</body>
</html>
