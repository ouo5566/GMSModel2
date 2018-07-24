<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<jsp:include page="../common/functions.jsp"/>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title-box.jsp"/>
		<jsp:include page="../common/login-box.jsp"/>
		<jsp:include page="../common/menu-box.jsp"/>
	</div>
	<div id="content">
		<div id="content-box">
			<h3>LOGIN PAGE</h3>
			<form action="${context}/member.do" onsubmit="return sendForm()" method="get">
				<input type="hidden" name="action" value="login"/>
				<input type="hidden" name="page" value="mypage"/>
				ID &nbsp;<input type="text" name="userid"/> <br>
				PW <input type="text" name="password"/>
					<input type="submit" value="LOGIN"/>
			</form>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</div>
</body>
</html>