<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
	<a id="move-login-form">LOGIN</a>&nbsp;&nbsp;&nbsp;
	<a id="move-join-form">JOIN</a>
</div>
<script>
/* var moveLoginForm = document.getElementById('move-login-form');
	moveLoginForm.addEventListener('click',function(){
	alert('CLICK EVENT CHECK');
	common.move('member','move','user-login-form')
}); */

document.getElementById('move-login-form')
.addEventListener('click',function(){ //콜백함수 : 연이어서 호출되는 함수
	// var x = ['${context}','member','move','user-login-form'];
	router.move({context:'${context}',
				domain : 'member',
				action : 'move',
				page : 'user-login-form'})
				//JSON으로 넘겨준다. 배열은 loop을 돌릴때에나 쓴다.
});
document.getElementById('move-join-form')
.addEventListener('click',function(){ 
	router.move({context:'${context}',
				domain : 'member',
				action : 'move',
				page : 'join-form'})
});
</script>