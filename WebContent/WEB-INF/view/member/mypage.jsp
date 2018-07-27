<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.*" %>
<%
	MemberBean user = (MemberBean)request.getAttribute("user");
	String ctx = application.getContextPath();
%>
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
				<h4><%=user.getMemberId() %></h4>
				<h4><%=user.getPassword() %></h4>
				<h4><%=user.getTeamId() %></h4>
				<h4><%=user.getRoll() %></h4>
				<h4><%=user.getName() %></h4>
				<h4><%=user.getSsn() %></h4>
				<h4><%=user.getGender()%></h4>
				<h4><%=user.getAge() %></h4>
				<a onclick="common.move('common','','')">
					<button>LOGOUT</button>
				</a>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</div>
</body>
</html>

