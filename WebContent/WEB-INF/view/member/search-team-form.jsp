<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>TEAM_FORM</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body class="align-center">
	<table id="main-tab-Layout" class="width-80per height-650px margin-auto">
		<tr class="height-100px">
			<th colspan="2">★  우 윳 빛 깔 최 소 진 ★ </th>
		</tr>
		<tr>
			<td class="width-70per"><img class="width-60per margin-auto" src="../../img/home/lighthouse.jpg" alt="" /></td>
			<td>
				<form action="<%=ctx%>/member.do">
					SEARCH<br> <input type="text" name="team-id"/> <br>
					<input type="hidden" name="action" value="search" />
					<input type="hidden" name="page" value="search-team-result" />
					<input type="submit" value="NEXT"/>
				</form>
			</td>
		</tr>
		<tr class="height-100px">
			<td colspan="2">ADDRESS</td>
		</tr>
	</table>
	
</body>
</html>