<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.mvc.board.vo.KswBoardVO" %> 
<%@ page import="java.util.ArrayList" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 목록</title>
<style type="text/css">
	.tt{
		text-align: center;
		font-weight: bold;
	}
</style>
<script type="text/javascript">
	console.log('boardSelectAll');
	
	//체크박스 함수
	//체크박스가 클릭되면 실행된다.
	function checkOnly(chk){
		console.log('checkOnly함수 들어옴'+chk);
		console.log('chk.value>>>'+chk.value);
		//체크박스의 chkInBnum에 해당하는 객체를 가져온다.
        var obj = document.getElementsByName("chkInBnum");	
		console.log('obj>>>>'+obj);
		for(var i=0; i < obj.length; i++){ 
            if(obj[i] != chk){
                obj[i].checked = false;                
            }
            console.log(' if :: obj['+i+'].checked >>> : ' + obj[i].checked);
        }
    }		
	
	//버튼 함수
	function boardFunction(str){
		var strValue=str;
		console.log('boardFunction>>>>'+str);
				
		if ('I' == strValue){		
			document.boradForm.action="/testMVC/model2mvc/board/board.html";	
			
		}		
		if ('SALL' == strValue){	
			document.boradForm.ISUD_TYPE.value = "SALL";
			document.boradForm.action="/testMVC/kswBoardController?isud_type=SALL";				
			console.log('>>>> : ' + document.boradForm.action);		
		}			
		if ('S' == strValue){		
			document.boradForm.ISUD_TYPE.value = "S";	
			
			//체크박스가 체크되어있는지 확인한다.			
			var obj = document.getElementsByName("chkInBnum");
			var nCnt = 0;
			//체크박스길이만큼 반복문을 돌린다.
			for(var i=0; i < obj.length; i++){ 
				//체크박스가 체크되어있으면 실행된다.
	          	if (obj[i].checked == true){
	          		nCnt++;
	          	}		          			            
	        }
			
			console.log('nCnt>>>>'+nCnt);
			
			if (nCnt == 0){	
				alert("체크박스를 체크하세요");				
			}else{				
				document.boradForm.action="/testMVC/kswBoardController?isud_type=S";				
			}				
		}
			
		if ('D' == strValue){	
	
			document.boradForm.ISUD_TYPE.value = "U";
			console.log('ISUD_TYPE.value>>>'+document.boradForm.ISUD_TYPE.value);
			document.boradForm.action="/testServlet/mvcBoardController?isud_type=D";										
		}
		
		document.boradForm.method = "POST";
		document.boradForm.enctype = "application/x-www-form-urlencoded";
		document.boradForm.submit();
		
	}
</script>
	
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
<%

	Object obj = request.getAttribute("aListAll");
	if (obj == null) return;
	
	ArrayList<KswBoardVO> aList = (ArrayList)obj;
	
	int nCnt = aList.size();
	System.out.println("nCnt >>> : " + nCnt);
	
	
%>
<form name="boradForm">
<table border="1" align="center">
	<thead>
		<tr>
			<td colspan="10" align="center">
				<h2>게시판</h2>
			</td>
		</tr>
		<tr>
			<td colspan="10" align="right">
				<input type="button" value="글쓰기" onclick="boardFunction('I')">
				<input type="button" value="글목록" onclick="boardFunction('SALL')">
				<input type="button" value="글수정" onclick="boardFunction('S')">
				<input type="button" value="글삭제" onclick="boardFunction('D')">	
			</td>						
		</tr>
		<tr>
			<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
			<td class="tt">글번호</td>
			<td class="tt">제목</td>
			<td class="tt">이름</td>
			<td class="tt">비밀번호</td>
			<td class="tt">내용</td>
			<td class="tt">삭제여부</td>
			<td class="tt">입력일</td>
			<td class="tt">수정일</td>
			<td class="tt">사진</td>
		</tr>
	</thead>
<%
	for(int i=0; i<nCnt; i++){		
		KswBoardVO kvo = aList.get(i);	
%>					
	<tbody>
	<tr>
		<td align="center">
			<input type="checkbox" name="chkInBnum" id="chkInBnum" value=<%= kvo.getBnum() %> onclick="checkOnly(this)">
		</td>		
		<td class="tt"><%= kvo.getBnum() %> </td>
		<td class="tt"><%= kvo.getBsubject() %> </td>
		<td class="tt"><%= kvo.getBwriter() %> </td>
		<td class="tt"><%= kvo.getBpw() %> </td>
		<td class="tt"><%= kvo.getBmemo() %> </td>
		<td class="tt"><%= kvo.getDeleteyn() %> </td>
		<td class="tt"><%= kvo.getInsertdate() %> </td>
		<td class="tt"><%= kvo.getUpdatedate() %> </td>	
		<td class="tt"><img src="/testMVC/model2mvc/imgboardupload/<%= kvo.getBphoto() %>"> </td>	
	</tr>	
<%
	}//end of for
%>						
	<tr>
		<td colspan="10" align="right">
			<input type="hidden" name="ISUD_TYPE">			
			<input type="button" value="글쓰기" onclick="boardFunction('I')">
			<input type="button" value="글목록" onclick="boardFunction('SALL')">
			<input type="button" value="글수정" onclick="boardFunction('S')">
			<input type="button" value="글삭제" onclick="boardFunction('D')">									
		</td>
	</tr>
	</tbody>			
</table>
</form>			
</body>
</html>
