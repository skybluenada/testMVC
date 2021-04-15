<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.mvc.board.vo.KswBoardVO" %> 
<%@ page import="java.util.ArrayList" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Member Form</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0
      maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">

<style type="text/css">
	div {
			margin: 50px 0px 0px 100px;
		}
	.mem{ text-align: center;}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
	// 비밀번호 체크 
	function pwCheck(){
		console.log("idCheck >>> : ");
		
	}
	
	function boardUpdate(actionUpdate){
		console.log("boardUpdate 진입 >>> : " + boardUpdate);
		if ('U' == actionUpdate){
			document.boardUpdateForm.ISUD_TYPE.value = "U";
			document.boardUpdateForm.action="/testMVC/kswBoardController?ISUD_TYPE=U";
		}
			
		document.boardUpdateForm.method="POST";
		document.boardUpdateForm.enctype="application/x-www-form-urlencoded";
		document.boardUpdateForm.submit();		
	}
	
	function checkAction(actionName){
		console.log("actionName 진입 >>> : " + actionName);
		
		if ('I' == actionName){	
			location.href="/testMVC/model2mvc/board/board.html";
		}
		if ('SALL' == actionName){			
			location.href="/testMVC/KswBoardController?ISUD_TYPE=SALL";
		}
	}	
</script>
</head>
<body onload="compCheck()">
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT ALL
<hr>
<%
	Object obj = request.getAttribute("aListS");
	
	ArrayList<KswBoardVO> aList = (ArrayList)obj;
	int nCnt = aList.size();
	out.println("nCnt >>> : " + nCnt);
	
	String num = "";
	String subject = "";	
	String writer = "";
	String pw = "";
	String memo = "";
	String photo = "";
	String deleteyn = "";
	String insertdate = "";
	String updatedate = "";
	
	
	if (nCnt == 1){
		KswBoardVO kvo = aList.get(0);
		
		num = kvo.getBnum();
		subject = kvo.getBsubject();
		writer = kvo.getBwriter();
		pw = kvo.getBpw();
		memo = kvo.getBmemo();
		photo = kvo.getBphoto();
		deleteyn = kvo.getDeleteyn();
		insertdate = kvo.getInsertdate();
		updatedate = kvo.getUpdatedate();
		
	}
%>
<div>
<form name="boardUpdateForm" id="boardUpdateForm">
<table border=1>
<script>
function compCheck(){
	
}
</script>
<tr>
<td colspan="2" align="center">					
	<font size="4" style="color:Blue;">KOSMO 78기</font>					
	<img src="/testMVC/model2mvc/img/ase.gif" width="25" height="25" alt="image">
</td>
</tr>
<tr>
<td class="mem">글번호</td>
<td><input type="text" name="bnum" id="bnum" value="<%= num %>" readonly/></td>
</tr>

<tr>
<td class="mem">제목</td>
<td>
<input type="text" name="bsubject" id="bsubject" value="<%= subject %>" style="width:100px" />
</td>
</tr>
<tr>
<td class="mem">이름</td>
<td><input type="text" name="bwriter" id="bwriter" value="<%= writer %>"/></td>
</tr>

</tr>	 
<tr>
<td class="mem">소개글</td>
<td>
<textarea name="bmemo" id="bmemo" rows="5" cols="50"><%= memo %>					
</textarea>
</td>
</tr>
<tr>
<td class="mem">사진</td>
<td> 
<img src="/testMVC/model2mvc/imgboardupload/<%= photo %>" border="1" width="40" height="50" alt="image">
</td>
</tr>
<td class="mem">삭제여부</td>
<td> 
<input type="text" name="deleteyn" id="deleteyn" value="<%= deleteyn %>" disabled  />		      
</td>
</tr>
<td class="mem">등록일</td>
<td> 
<input type="text" name="insertdate" id="insertdate" value="<%= insertdate %>" disabled />		      
</td>
</tr>	 
<td class="mem">수정일</td>
<td> 
<input type="text" name="updatedate" id="updatedate" value="<%= updatedate %>" disabled />		      
</td>
</tr>
<tr>
<td class="mem">패스워드</td>
<td>
<input type="text" name="bpw" id="bpw"  />
<input type="button" onclick="pwCheck()" value="비밀번호확인">
</td>	 	 
<tr>
	<td colspan="2"> 
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE">
		<input type="button" value="수정" onclick="boardUpdate('U')"/>
		<input type="button" value="삭제" onclick="boardUpdate('D')"/>
	    <input type="reset" value="취소" />
	    &nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="button" value="입력" onclick="checkAction('I')"/>
		<input type="button" value="목록" onclick="checkAction('SALL');">
	</td>				
</tr>
</table>
</form>
</div>
</body>
</html>
