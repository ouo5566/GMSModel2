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
						<td><h5>ID</h5></td>
						<td><h5>${user.memberId}</h5></td>
					</tr>
					<tr>
						<td><h5>이름 </h5></td>
						<td><h5>${user.name}</h5></td>
					</tr>
					<tr>
						<td><h5>비밀번호</h5></td>
						<td>
							<input id="password" type="text" name="password" placeholder="${user.password}"/>
						</td>
					</tr>
					<tr>
						<td><h5>성별</h5></td>
						<td><h5>${user.gender}</h5></td>
						<td><h5>팀</h5></td>
						<td>
							<select name="team" id="team">
								<option value="null">NONE</option>
								<option value="AT">NOLJA</option>
								<option value="HT">JIEUN-HOUSE</option>
								<option value="ST">TURTLE-KING</option>
								<option value="CT">CODDING-ZZANG</option>
							</select><br>
							<input type="radio" name="teamid" value=""/>NONE
							<input id="AT" type="radio" name="teamid" value="AT"/>NOLJA
							<input id="HT" type="radio" name="teamid" value="HT"/>JIEUN-HOUSE
							<input id="ST" type="radio" name="teamid" value="ST"/>TURTLE-KING
							<input id="CT" type="radio" name="teamid" value="CT"/>CODDING-ZZANG<br>
						</td>
					</tr>
					<tr>
						<td><h5>나이</h5></td>
						<td><h5>${user.age}</h5></td>
						<td><h5>역할</h5></td>
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
				<input type="hidden" name="action" value="update" />
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
	document.getElementById('${user.teamId}').checked = true;
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
		form.action='${context}/member.do';
		form.method='post';
		form.submit();
	});
</script>
</body>
</html>
