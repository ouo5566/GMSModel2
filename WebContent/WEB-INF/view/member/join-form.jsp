<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!-- memberId, name, ssn(800101-1), password -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입화면</title>
	<link rel="stylesheet" href="../../css/style.css"/>
</head>
<body>
<table id="main-tab-Layout" class="width-80per height-650px margin-auto">
		<tr class="height-100px">
			<th colspan="2">GMS</th>
		</tr>
		<tr>
			<td class="width-70per"><img class="width-60per margin-auto" src="../../img/home/lighthouse.jpg" alt="" /></td>
			<td>
			<form id="user-join-layout" action="<%=ctx %>/member.do" class="align-left">
			<input type="hidden" name="action" value="join" />
			<input type="hidden" name="page" value="join-result" />
				회원가입<br>
				ID : <input type="text" name="userid" /><br>
				PW : <input type="text" name="password" /><br>
				NAME : <input type="text" name="username" /><br>
				SSN : <input type="text" name="userssn" /><br>	
				<input type="submit" value="JOIN" />
			</form>
			</td>
		</tr>
		<tr class="height-100px">
			<td colspan="2">ADDRESS</td>
		</tr>
	</table>
	
</body>
</html>