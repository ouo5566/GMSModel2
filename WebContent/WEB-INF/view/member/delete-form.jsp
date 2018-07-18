<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>DELETE</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<table id="main-tab-Layout" class="width-80per height-650px margin-auto">
		<tr class="height-100px">
			<th colspan="2">★  우 윳 빛 깔 최 소 진 ★ </th>
		</tr>
		<tr>
			<td class="width-70per"><img class="width-60per margin-auto" src="../../img/home/lighthouse.jpg" alt="" /></td>
			<td>
				<h4>회원탈퇴</h4>
				<form action="<%=ctx%>/member.do">
				<input type="hidden" name="action" value="delete-member" />
				<input type="hidden" name="page" value="delete-result" />	
					ID : <input type="text" name="userid"/><br>
					PW : <input type="text" name="userpw"/><br>
					PW확인 : <input type="text" name="confirm-pw"/><br>
					<input type="submit" value="DELETE"/>
				</form>
			</td>
		</tr>
		<tr class="height-100px">
			<td colspan="2">ADDRESS</td>
		</tr>
	</table>
</body>
</html>
