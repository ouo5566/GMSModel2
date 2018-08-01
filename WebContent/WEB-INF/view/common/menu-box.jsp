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
	// document.querySelector는 css의 selector를 document에서 쓸 수 있게 해준다. tag, .class, #id
	// 그러나 id를 통해 조회할 때는 getElementById가 더 빠르니 querySelector는 tag와 class로 조회할 때 쓴다.
	document.getElementById('move-admin').addEventListener('click',function(){ 
		admin.check('${context}');
	});
</script>