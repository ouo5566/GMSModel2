<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- memberId, name, ssn(800101-1), password -->
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
			<form id="join-form">
				<h3>JOIN PAGE</h3>
				<input type="hidden" name="action" value="join"/>
				<input type="hidden" name="page" value="user-login-form"/>
				ID : <input type="text" name="userid" /><br>
				PW : <input type="text" name="password" /><br>
				NAME : <input type="text" name="username" /><br>
				SSN : <input type="text" name="userssn" /><br>	
				<input id="join-form-btn" type="button" value="JOIN" />
			</form>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</div>
<script>
document.getElementById('join-form-btn').addEventListener('click',
		function(){
	var form = document.getElementById('join-form');
	form.action = "${context}/member.do";
	form.method = "post";
	member.setMemberId(form.userid.value);
	member.setPassword(form.password.value);
	member.setName(form.username.value);
	member.setSsn(form.userssn.value);
	if(member.joinValidation()){
		form.submit();
	}
});
</script>
</body>
</html>