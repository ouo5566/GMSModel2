<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath() %>"/>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>ID_FORM</title>
	<link rel="stylesheet" href="${context}/resources/css/style.css" />
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="title-box">
			<h1>★  초 코 우 유 빛 깔 최 소 진 ★</h1>
			<h1> SEARCH BY ID </h1>		
		</div>
		<div id="menu-box">
			<ul id="menu">
				<li><a href="${context}/admin.do?action=move&page=admin-index">HOME</a></li>
				<li><a href="">ABOUT</a></li>
				<li><a href="${context}/member.do?action=move&page=member-list">MEMBER</a></li>
				<li>SEARCH</li>
				<li><a href="${context}/member.do?action=move&page=move">LOGOUT</a></li>
			</ul>
		</div>
	</div> <!-- header end -->
	<div id="content">
		<div id="content-box">
			<form action="">
				<h1>SEARCH</h1>
				<input type="text" name="member-id"/> <br>
				<input type="hidden" name="action" value="retrieve" />
				<input type="hidden" name="page" value="search-id-result" />
				<input type="submit" value="NEXT"/>
			</form>
		</div>
	</div>
	<div id="footer">
		<h3> DATE </h3>
	</div> 
</div>
</body>
</html>