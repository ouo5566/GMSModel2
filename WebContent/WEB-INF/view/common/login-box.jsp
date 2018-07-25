<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
	<a id="move-login-form">LOGIN</a>
	&nbsp;&nbsp;&nbsp;
	<a onclick="common.move('member','move','join-form')">JOIN</a>
</div>
<script>
/* var moveLoginForm = document.getElementById('move-login-form');
	moveLoginForm.addEventListener('click',function(){
	alert('CLICK EVENT CHECK');
	common.move('member','move','user-login-form')
}); */

document.getElementById('move-login-form')
.addEventListener('click',function(){ //콜백함수 : 연이어서 호출되는 함수
	common.move('member','move','user-login-form')
});
</script>