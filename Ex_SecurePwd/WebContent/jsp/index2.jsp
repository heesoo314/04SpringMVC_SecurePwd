<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<script type="text/javascript">

	function send(ff){
		
		// 입력한 값 확인...
		
		ff.action="login.al";
		ff.method="post";
		
		ff.submit();
		
	}
	
</script>

</head>
<body>

	<h1>로그인</h1>
	<strong>* 비밀번호 암호화 예시</strong>
	
	<form name="ff">
	
		<table>
			<tr>
				<td><label for="m_id">아이디</label></td>
				<td><input type="text" id="m_id" name="id"  /></td>
			</tr>
			<tr>
				<td><label for="m_pwd">비밀번호</label></td>
				<td><input type="password" id="m_pwd" name="pwd" /></td>
			</tr>
			<tr><td colspan="2" style="text-align:right"><input type="button" value="보내기" onclick="send(this.form)" /></td></tr>
		</table>
		
<!-- 		
		<label for="m_id">아이디</label>
		<input type="text" id="m_id" name="id"  /><br/>
	
		<label for="m_pwd">비밀번호</label>
		<input type="password" id="m_pwd" name="pwd" /><br/>
		
		<input type="button" value="보내기" onclick="send(this.form)" /> -->
		
	</form>
	
</body>
</html>