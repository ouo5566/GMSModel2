<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
<ul id="menu">
	<li><a id="move-home" >HOME</a></li>
	<li><a id="move-member-list">MEMBER</a></li>
	<li><a id="move-search">SEARCH</a></li>
	<li><a id="move-main">LOGOUT</a></li>
</ul>
<script>
document.getElementById('move-home').addEventListener('click',function(){ 
	router.move({
		context : '${context}',
		domain : 'admin',
		action : 'list',
		page : 'main'})
});
document.getElementById('move-member-list').addEventListener('click',function(){ 
	router.move({context:'${context}',
				domain : 'member',
				action : 'move',
				page : 'member-list'})
});
document.getElementById('move-search').addEventListener('click',function(){ 
	router.move({context:'${context}',
				domain : 'member',
				action : 'move',
				page : 'search-form'})
});
document.getElementById('move-main').addEventListener('click',function(){ 
	router.move({context:'${context}',
				domain : 'common',
				action : '',
				page : ''})
});
</script>
</div>
