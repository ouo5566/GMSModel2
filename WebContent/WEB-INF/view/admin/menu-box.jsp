<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath()%>"/>
<ul id="menu">
	<li><a href="${context}/admin.do?action=move&page=admin-index">HOME</a></li>
	<li><a href="">ABOUT</a></li>
	<li><a href="${context}/member.do?action=move&page=member-list">MEMBER</a></li>
	<li><a href="${context}/member.do?action=move&page=search-id-form">SEARCH</a></li>
	<li><a href="${context}/common.do">LOGOUT</a></li>
</ul>
