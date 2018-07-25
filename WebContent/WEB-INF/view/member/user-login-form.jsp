<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<jsp:include page="../common/head-function.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title-box.jsp"/>
		<jsp:include page="../common/login-box.jsp"/>
		<jsp:include page="../common/menu-box.jsp"/>
	</div>
	<div id="content">
		<div id="content-box">
			<h3>LOGIN PAGE</h3>
			<form id="login-form">
				<input type="hidden" name="action" value="login"/>
				<input type="hidden" name="page" value="mypage"/>
				ID &nbsp;<input type="text" name="userid"/> <br>
				PW <input type="text" name="password"/>
				<input id="login-form-btn" type="button" value="LOGIN"/>
			</form>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</div>
<script>
document.getElementById('login-form-btn').addEventListener('click',
		function(){
	var form = document.getElementById('login-form');
/* 	var userid = form.userid.value;
	alert('입력한 아이디 : ' + userid); */
	form.action = "${context}/member.do";
	form.method = "post";
	member.setMemberId(form.userid.value);
	member.setPassword(form.password.value);
	if(member.loginValidation()){
		form.submit();
	}
});
</script>
</body>
</html>