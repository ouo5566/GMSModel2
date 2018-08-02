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
		<jsp:include page="menu-box.jsp"/>
	</div>
	<div id="content">
		<div id="content-box">
			<h2>◆MemberDetailPage◆</h2>
				<table id="mypage-table">
					<tr>
						<td id="mypage-img" rowspan="3" colspan="2"></td>
						<td>ID</td>
						<td>${retrieve.memberId}</td>
					</tr>
					<tr>
						<td>이름 </td>
						<td>${retrieve.name}</td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td>${retrieve.ssn}</td>
					</tr>
					<tr>
						<td>성별</td>
						<td>${retrieve.gender}</td>
						<td>팀</td>
						<td>${retrieve.teamId}</td>
					</tr>
					<tr>
						<td>나이</td>
						<td>${retrieve.age}</td>
						<td>역할</td>
						<td>${retrieve.roll}</td>
					</tr>
				</table>
				<br>
				<a id="list-butt"><button>LIST</button></a>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</div>
<script>
	document.getElementById('list-butt').addEventListener('click',function(){
		router.move({context:'${context}',
			domain : 'admin',
			action : 'list',
			page : 'main'})
	});
</script>
</body>
</html>

