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
			<form id="delete-form">
				비밀번호 확인 <input type="password" name="confirm"/>
				<input type="button" id="delete-butt" value="DELETE"/>
			</form>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</div>
<script>
// id를 준다는 것은 객체로 만들어 identifier로 호출할 수 있게 하는 것 > DOM객체
// id를 주지 않으면 property 속성값으로 쓰겠다는 것
	document.getElementById('delete-butt').addEventListener('click', function(){
		var form = document.getElementById('delete-form');
		if(form.confirm.value === '${user.password}'){
			form.action = '${context}/member.do';
			form.method = 'post';
			
			var node = document.createElement("input"); // 없던 속성을 만든다.
			node.innerHTML = '<input type="hidden" name="action" value="delete"/>'; // input 속성에 html 코드를 추가한다.
			form.appendChild(node); // form 에 node를 자식속성으로 추가한다.
			
			alert(form.action.value); // form에서 추가한 node의 action을 출력하면 value값인 delete가 출력된다.
			
			form.submit();
		}else{
			alert('비밀번호 불일치');
		}
	});
</script>
</body>
</html>
