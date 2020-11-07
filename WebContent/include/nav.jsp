<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav>
	<c:choose>
		<c:when test="${empty sessionScope.principal}">
			<a href="/post/member?cmd=loginForm">로그인</a>
			<a href="/post/member?cmd=joinForm">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="/post/member?cmd=updateForm">회원정보</a>
			<a href="/post/member?cmd=logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
</nav> 
