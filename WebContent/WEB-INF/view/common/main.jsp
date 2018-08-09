<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"/>
<jsp:include page="head-function.jsp"/>
<body>
<!-- 최상위의 div -->
<div id="wrapper">
	<div id="header">
		<jsp:include page="title-box.jsp"/>
		<jsp:include page="login-box.jsp"/>
		<jsp:include page="menu-box.jsp"/>
	</div>
	<div id="content">
		<jsp:include page="content-box.jsp"/>
	</div>
	<div id="footer">
		<jsp:include page="footer.jsp"/> 
	</div>
</div>
<script>
	common.main('${context}');
</script>
</body>
</html>