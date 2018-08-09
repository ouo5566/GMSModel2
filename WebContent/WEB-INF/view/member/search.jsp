<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
	<div id="content-box-search">
		<select id="search-option">
				<option value="none">검색조건</option>
				<option value="userid">ID</option>
				<option value="name">NAME</option>
				<option value="team_id">TEAM</option>
		</select>&ensp;&ensp;
		<input type="text" id="search-word" placeholder="search word"/>
		<input id="search-butt" type="button" value="SEARCH" />
	</div><br>
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
		<%-- <c:forEach begin="시작" end="끝" items="" step="증가하는단계" var="" varStatus="인덱스"> --%>
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
		<tr>
			<td colspan="6">
				<ul class="page-box">
					<c:if test="${page.prevPage}">
						<li><a class="order" id="${page.prevBlock}">◀이전</a></li>
					</c:if>
					
					<c:forEach begin="${page.beginPage}" end="${page.endPage}" step="1" varStatus="i">
						<!-- 내가 인덱스값으로 반복해야하니 for loop , 객체를 이용해 반복할 때는 for each -->
						<!-- ListCommand에서 list값을 담았으니 count도 ListCommand에서 담아야한다 -->
						<li>
							<a class="pagenum" id="${i.index}">${i.index}</a>				
						</li>
					</c:forEach>
					
					<!-- JAVA에서는 if else = JSP choose + when + other -->
					<!-- 비교연산자는 tag와 겹쳐 에러를 일으킬 수 있다.
						 gt(크면) ge(같거나 크면) lt(작으면) le(같거나 작으면) eq(같으면) ne(not equal) 을 사용하여 비교 -->
					<c:if test="${page.nextPage}">
						<li><a class="order" id="${page.nextBlock}">다음▶</a></li>
					</c:if>
				</ul>
			</td>
		</tr>
	</table>
</div>
<script>
	admin.main('${context}'); // 이 한 줄로 연결시켜놨기 때문에 밑으로 더 추가하면 안된다.
	/*
	class - document.querySelector(.class) -> return Array
	id - document.getElementById(id) -> return Object
		-> document.getElementById(id).value -> return Value // JS에서 Value를 가져오는 방법
	name - request.getParameter(name) -> return Value // Java에서 Value를 가져오는 방법
	어떤 객체를 쓰냐에 따라 주어지는 타입이 다르다. 객체를 쓰지도 않는데 타입을 주는 것은 헛수고.
	
	var x = ${list};
	alert('Member-list-size : ' + x.length);
	alert('memberId : ' + x[0].memberId + '\n' +
			'password : ' + x[0].password + '\n' +
			'ssn : ' + x[0].ssn + '\n' +
			'name : ' + x[0].name + '\n' +
			'gender : ' + x[0].gender + '\n' +
			'age : ' + x[0].age + '\n' +
			'teamId : ' + x[0].teamId + '\n' +
			'roll : ' + x[0].roll); 
	*/
	
</script>