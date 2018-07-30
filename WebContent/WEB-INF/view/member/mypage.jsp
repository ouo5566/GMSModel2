<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.*" %>
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
			<h2>◆My Page◆</h2>
				<table id="mypage-table">
					<tr>
						<td id="mypage-img" rowspan="3" colspan="2"></td>
						<td><h5>ID</h5></td>
						<td><h5>${user.memberId}</h5></td>
					</tr>
					<tr>
						<td><h5>이름 </h5></td>
						<td><h5>${user.name}</h5></td>
					</tr>
					<tr>
						<td><h5>생년월일</h5></td>
						<td><h5>${user.ssn}</h5></td>
					</tr>
					<tr>
						<td><h5>성별</h5></td>
						<td><h5>${user.gender}</h5></td>
						<td><h5>팀</h5></td>
						<td><h5>${user.teamId}</h5></td>
					</tr>
					<tr>
						<td><h5>나이</h5></td>
						<td><h5>${user.age}</h5></td>
						<td><h5>역할</h5></td>
						<td><h5>${user.roll}</h5></td>
					</tr>
				</table>
				<a id="logout-butt"><button>LOGOUT</button></a>
				<a id="update-butt"><button>UPDATE</button></a>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</div>
<script>
	document.getElementById('logout-butt').addEventListener('click',function(){
		router.move({context : '${context}',
			domain : 'common',
			action : '',
			page : ''})
	});
	document.getElementById('update-butt').addEventListener('click',function(){
		router.move({context:'${context}',
			domain : 'member',
			action : 'move',
			page : 'update-form'})
	});
</script>
</body>
</html>

