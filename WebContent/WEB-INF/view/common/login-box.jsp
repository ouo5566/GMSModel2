<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="login-box">
	<c:choose>
		<c:when test="${match eq 'TRUE'}">
			<a class="login-box" id="logout">LOGOUT</a>&nbsp;&nbsp;&nbsp;
		</c:when>
		<c:otherwise>
			<a class="login-box" id="move-login">LOGIN</a>&nbsp;&nbsp;&nbsp;
			<a class="login-box" id="move-add">JOIN</a>
		</c:otherwise>
	</c:choose>
</div>
