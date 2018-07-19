<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>MAIN</title>
	<link rel="stylesheet" href="resources/css/style.css"/>
</head>
<body>
	<table id="main-tab-Layout" class="width-80per height-650px margin-auto">
		<tr class="height-100px">
			<th colspan="2">★  우 윳 빛 깔 최 소 진 ★ </th>
		</tr>
		<tr>
			<td class="width-70per"><img class="width-60per margin-auto" src="resources/img/home/lighthouse.jpg" alt="" /></td>
			<td>
			<a href="<%=ctx %>/member.do?action=move&page=join-form"><button class="butt">JOIN</button></a><br>
			<a href="<%=ctx %>/member.do?action=move&page=user-login-form"><button class="butt">USER</button></a><br>
			<%-- <a href="<%=ctx %>/admin.do?action=move&page=admin-login"><button class="butt">ADMIN</button></a><br> --%>
			<a href="<%=ctx %>/member.do?action=move&page=update-form"><button class="butt">UPDATE</button></a><br>
			<a href="<%=ctx %>/member.do?action=move&page=delete-form"><button class="butt">DELETE</button></a><br>
			<a href="<%=ctx %>/member.do?action=move&page=member-list"><button class="butt">MEMBER</button></a><br>
			<a href="<%=ctx %>/member.do?action=move&page=search-team-form"><button class="butt">TEAM</button></a><br>
			<a href="<%=ctx %>/member.do?action=move&page=search-id-form"><button class="butt">ID</button></a>
			</td>
		</tr>
		<tr class="height-100px">
			<td colspan="2">ADDRESS</td>
		</tr>
	</table>
<h3 class="align-center"> DATE </h3>
<h4 class="align-center"> 현재 회원 수 : <a href="<%=ctx %>/member.do?action=search-member-count&page=member-list">count</a> </h4>
</body>
</html>