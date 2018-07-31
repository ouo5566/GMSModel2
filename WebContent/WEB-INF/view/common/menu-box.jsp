<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a id="move-home">HOME</a></li>
		<li><a id="move-about">ABOUT</a></li>
		<li><a id="move-admin">ADMIN</a></li>
	</ul>
</div>
<script>
	document.getElementById('move-home').addEventListener('click',function(){ 
		router.move({context:'${context}',
					domain : 'common',
					action : '',
					page : ''})
	});
	document.getElementById('move-about').addEventListener('click',function(){ 
		router.move({context:'${context}',
					domain : 'member',
					action : 'move',
					page : 'mypage'})
	});
	document.getElementById('move-admin').addEventListener('click',function(){ 
		router.move({context:'${context}',
					domain : 'admin',
					action : 'move',
					page : 'main'})
	});
</script>