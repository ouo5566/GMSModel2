<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
function move(domain, action, page){
	//alert("${context}/"+domain+".do?action="+action+"&page="+page");
	//java의 sysout과 같음
	location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
	//href 는 a tag에서 속성값이었다. location은 객체로 볼 수 있다.
}
function sendForm(){
	return true;
}
</script>