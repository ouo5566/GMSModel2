<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<!-- 최상위의 div -->
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title-box.jsp"/>
		<div id="menu-box">
			<jsp:include page="menu-box.jsp"/>
		</div>
	</div>
	<div id="content">
		<jsp:include page="content-box.jsp"/>
	</div>
	<jsp:include page="../common/footer.jsp"/> 
</div>
</body>
</html>