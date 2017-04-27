<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>

<style type="text/css">

table {
	margin-top: 30px;
}

div#box {
	display: inline-block;
	font-size: 11px;
	font-weight: bold;
}

span.success {
	color: #0f0;
}

span.fail {
	color: #f00;
}
</style>

<script type="text/javascript">

	function checkId(){
		
		// 사용자가 입력한 아이디
		var id = document.ff.id.value.trim();
		
		if(id.length >= 4){
			
			//alert(id);
			
			// 요청에 담겨진 파라미터
			var param = "id=" + encodeURIComponent(id);	//한글인코딩
			
			// 서버통신
			sendRequest("checkId.al", param, res, "POST", true);
			//sendRequest(url, param, callback, method, async)			
			
		} else 
			document.getElementById("box").innerHTML = "";
		
			
	}

	
	// 도착함수
	function res(){
		
		// 서버의 응답이 도착했고(4) 정상적으로 처리했다면(200) 
		if(xhr.readyState == 4 && xhr.status == 200){
			
			// 응답결과를 받자!
			var str = xhr.responseText;		// <span class="..."></span> 
			
			// div box에 받은 값을 넣는다
			document.getElementById("box").innerHTML = str;
			
		}
	}
	
	
	function send(ff){
		
		// 값을 입력했는지 확인
		
		ff.action="register.al";
		ff.method="post";
		
		ff.submit();
		
	}
	
	
</script>

<script type="text/javascript" src="js/httpRequest.js" ></script>

</head>
<body>

	<h1>회원가입</h1>
	<strong>* 아이디 중복체크 예시</strong>
	
	<form name="ff">
	
		<table>
			<tr>
				<td><label for="m_id">아이디</label></td>
				<td><input type="text" id="m_id" name="id" onkeyup="checkId()"  />
				<div id="box"></div></td>
			</tr>
			<tr>
				<td><label for="m_pwd">비밀번호</label></td>
				<td><input type="password" id="m_pwd" name="pwd" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:right">
					<input type="button" value="보내기" onclick="send(this.form)" />
				</td>
			</tr>
		</table>
<!-- 		
		
		<label for="m_id">아이디</label>
		<input type="text" id="m_id" name="id" onkeyup="checkId()"  />
		<div id="box"></div><br/>
		
		<label for="m_name">이름</label>
		<input type="text" id="m_name" name="name" /><br/>
		
		<label for="m_pwd">비밀번호</label>
		<input type="password" id="m_pwd" name="pwd" /><br/>
		
		<input type="button" value="보내기" onclick="send(this.form)" /> -->
		
	</form>
	
</body>
</html>