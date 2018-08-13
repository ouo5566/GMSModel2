<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="content-box">
	<h2>◆My Page◆</h2>
		<table id="mypage-table">
			<tr>
				<td id="mypage-img" rowspan="3" colspan="2"></td>
				<td>ID</td>
				<td>${user.memberId}</td>
			</tr>
			<tr>
				<td>이름 </td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>${user.ssn}</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${user.gender}</td>
				<td>팀</td>
				<td>${user.teamId}</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>${user.age}</td>
				<td>역할</td>
				<td>${user.roll}</td>
			</tr>
		</table>
		<br>
		<a class="retrieve-butt" id="logout"><button>LOGOUT</button></a>
		<a class="retrieve-butt" id="update"><button>UPDATE</button></a>
		<a class="retrieve-butt" id="delete"><button>DELETE</button></a>
</div>

