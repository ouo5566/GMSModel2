<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="menu-box">
	<ul id="menu">
		<li><a class="menu-li" id="home">HOME</a></li>
		<c:choose>
			<c:when test="${match eq 'TRUE'}">
				<li><a class="menu-li" id="about">ABOUT</a></li>
			</c:when>
		</c:choose>
		<li><a class="menu-li" id="admin">ADMIN</a></li>
	</ul>
</div>
<script>
	
</script>