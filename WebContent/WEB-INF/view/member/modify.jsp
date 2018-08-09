<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<h2>◆Update◆</h2>
				<form id="update-form">
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
						<td>비밀번호</td>
						<td>
							<input id="password" type="text" name="password" placeholder="${user.password}"/>
						</td>
					</tr>
					<tr>
						<td>성별</td>
						<td>${user.gender}</td>
						<td>팀</td>
						<td>
							<select name="team" id="team">
								<option value="null">NONE</option>
								<option value="AT">NOLJA</option>
								<option value="HT">JIEUN-HOUSE</option>
								<option value="ST">TURTLE-KING</option>
								<option value="CT">CODDING-ZZANG</option>
							</select>
							<!-- <br>
							<input id="teamid_0" type="radio" name="teamid" value=""/>NONE
							<input id="teamid_1" type="radio" name="teamid" value="AT"/>NOLJA
							<input id="teamid_2" type="radio" name="teamid" value="HT"/>JIEUN-HOUSE
							<input id="teamid_3" type="radio" name="teamid" value="ST"/>TURTLE-KING
							<input id="teamid_4" type="radio" name="teamid" value="CT"/>CODDING-ZZANG
							<br> -->
						</td>
					</tr>
					<tr>
						<td>나이</td>
						<td>${user.age}</td>
						<td>역할</td>
						<td>
							<select name="roll" id="roll">
								<option value="leader">팀장</option>
								<option value="front">프론트개발</option>
								<option value="back">백단개발</option>
								<option value="android">안드로이드개발</option>
								<option value="minfe">민폐</option>
							</select>
						</td>
					</tr>
				</table>
				<input type="button" id="update-butt" value="UPDATE" />
				</form>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</div>
<script>
	var form = document.getElementById('update-form'); // DOM 객체
	var team = document.getElementById('team');
	for(var i = 0; i < team.options.length ; i++){
		if(team.options[i].value === '${user.teamId}'){
			team.options[i].setAttribute("selected","selected");
		}
	}
	var roll = document.getElementById('roll');
	for(var i = 0; i < roll.options.length ; i++){
		if(roll.options[i].value === '${user.roll}'){
			roll.options[i].setAttribute("selected","selected");
		}
	}
	document.getElementById('update-butt').addEventListener('click', function(){
		alert('CLICK');
		if(form.password.value === ""){
			form.password.value = '${user.password}';
		}
		
		var node = document.createElement('input');
		node.innerHTML = '<input type="hidden" name="action" value="update"/>'
		form.appendChild(node);
		
		form.action='${context}/member.do';
		form.method='post';
		form.submit();
	});

	/* 	var teamid = document.getElementById('teamid');
	for(var i = 0; i < teamid.options.length ; i++){
		if((teamid.teamid_i.value === '${user.teamId}')){
			document.getElementById('teamid_' + i).checked = true;
		}
	} */

</script>
</body>
</html>
