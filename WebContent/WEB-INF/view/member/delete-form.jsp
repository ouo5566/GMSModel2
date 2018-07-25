<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String ctx = application.getContextPath(); %>
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
		<h4>회원탈퇴</h4>
		<form action="${context}/member.do" onsubmit="return sendForm()" method="get">
		<input type="hidden" name="action" value="delete" />
		<input type="hidden" name="page" value="delete-result" />	
			ID : <input type="text" name="userid"/><br>
			PW : <input type="text" name="userpw"/><br>
			PW확인 : <input type="text" name="confirm-pw"/><br>
			<input type="submit" value="DELETE"/>
		</form>
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</div>
</body>
</html>
