<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
	<h1>◆ADMIN PAGE◆</h1><br>
	
	<table id="list-table">
		<tr id="content-box-mata">
			<th>ID</th>
			<th>NAME</th>
			<th>GENDER</th>
			<th>AGE</th>
			<th>TEAM</th>
			<th>ROLL</th>
		</tr>
		<c:forEach items="${list}" var="member">
		<%-- <c:forEach begin="시작" end="끝" items="" step="증가하는단계" var="" varStatus=""> --%>
			<tr>
				<td>${member.memberId}</td>
				<td><a class="username" id="${member.memberId}">${member.name}</a></td>
				<%-- <td>
					<a	href="${context}/admin.do?action=retrieve&page=member-detail&a=${member.memberId}"
					style="cursor: pointer">${member.name}</a>
				</td>	이렇게 살지말자... 우리 삼촌세대에서 쓰던 방식...--%>
				<td>${member.gender}</td>
				<td>${member.age}</td>
				<td>${member.teamId}</td>
				<td>${member.roll}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script>
	document.getElementById('content-box-mata').className = "bgcolor-yellow"
	var x = document.querySelectorAll('.username');
	for(var i in x){
		x[i].style.color = "blue";
		x[i].style.cursor = 'pointer';
		x[i].addEventListener('click', function(){
			location.href="${context}/admin.do?action=retrieve&page=member-detail&a="+this.getAttribute('id');
			// alert('Click!\n' + this.getAttribute('id')); // callback(어떠한 object의 event에 의해서 호출되는 함수)함수에서의 this.는 그 함수를 호출한 객체를 의미한다.
		});
	}
/* 	var x = ${list};
	alert('Member-list-size : ' + x.length);
	alert('memberId : ' + x[0].memberId + '\n' +
			'password : ' + x[0].password + '\n' +
			'ssn : ' + x[0].ssn + '\n' +
			'name : ' + x[0].name + '\n' +
			'gender : ' + x[0].gender + '\n' +
			'age : ' + x[0].age + '\n' +
			'teamId : ' + x[0].teamId + '\n' +
			'roll : ' + x[0].roll); */
	
	
</script>