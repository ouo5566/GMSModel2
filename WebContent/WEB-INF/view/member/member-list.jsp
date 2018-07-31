<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>MEMBER_LIST</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body class="align-center">
	<a href="<%=ctx%>/member.do?action=list"><button class="butt">MAIN</button></a>
	<table id="main-tab-Layout"  class="margin-auto">
	<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>SSN</th>
			<th>TEAM</th>
			<th>ROLL</th>
	</tr>
	</table>
</body>
</html>