<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.*" %>
<%
	MemberBean user = (MemberBean)request.getAttribute("user");
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>MYPAGE</title>
	<link rel="stylesheet" href="../../css/style.css" />
	</style>
</head>
<body>
	<table id="mypage-tab-Layout" class="width-80per height-650px margin-auto">
		<tr class="height-100px">
			<th colspan="2">GMS</th>
		</tr>
		<tr>
			<td class="width-70per font-size-400per">M Y P A G E</td>
			<td><a href="<%=ctx%>/member.do?action=move&page=move">
				<button id="mypage-tab-Layout-logout-butt">LOGOUT</button>
				</a></td>
				<h4><%=user.getName() %>님</h4>
		</tr>
		<tr class="height-100px">
			<td colspan="2">ADDRESS</td>
		</tr>
	</table>
</body>
</html>

