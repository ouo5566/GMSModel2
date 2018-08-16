<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="content-box">
	<h2>◆Update◆</h2>
		<form id="update-form">
		<table id="mypage-table">
			<tr>
				<td id="mypage-img" rowspan="3" colspan="2">
					<img src="${img}${profile}" alt="" />
				</td>
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
					<select name="teamid" id="team" class="${user.teamId}">
						<option class="team-opt" value="null">NONE</option>
						<option class="team-opt" value="NOLJA">NOLJA</option>
						<option class="team-opt" value="JIEUN_HOUSE">JIEUN-HOUSE</option>
						<option class="team-opt" value="TURTLE_KING">TURTLE-KING</option>
						<option class="team-opt" value="CODDING_ZZANG">CODDING-ZZANG</option>
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
					<select name="roll" id="roll" class="${user.roll}">
						<option class="roll-opt" value="leader">팀장</option>
						<option class="roll-opt" value="front">프론트개발</option>
						<option class="roll-opt" value="back">백단개발</option>
						<option class="roll-opt" value="android">안드로이드개발</option>
						<option class="roll-opt" value="minfe">민폐</option>
					</select>
				</td>
			</tr>
		</table>
		<input type="button" class="form-butt" id="update-btn" value="UPDATE" />
		</form>
</div>
<form id="file-upload-form">
	  파일 업로드: <input type="file" name="upfile"><br/>
	  <input class="form-butt" id="file-upload-btn" type="button" value="업로드">
</form>
