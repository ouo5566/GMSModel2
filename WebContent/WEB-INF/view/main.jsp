<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="common/head.jsp"/>
<jsp:include page="common/head-function.jsp"/>
<body>
<!-- 최상위의 div -->
<div id="wrapper">
	<div id="header">
		<jsp:include page="common/title-box.jsp"/>
		<jsp:include page="common/login-box.jsp"/>
		<jsp:include page="common/menu-box.jsp"/>
	</div>
	<div id="content">
		<jsp:include page="common/content-box.jsp"/>
	</div>
	<div id="footer">
		<jsp:include page="common/footer.jsp"/> 
	</div>
</div>
</body>
</html>