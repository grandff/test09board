<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="cmmn/commonLib.jsp" %>
	<body>
		<div class="container">
			<%@ include file="cmmn/header.jsp" %>

			<h1 class="mt-3">기본 게시판</h1>	
			<P>The time on the server is ${serverTime}.</P>	
			
			<h2 class="mt-5">기능 목록</h2>
			<ul class="list-group">
			  <li class="list-group-item">CRUD 게시판</li>
			  <li class="list-group-item">AOP 기능 구현</li>
			  <li class="list-group-item">파일 업로드, 수정, 미리보기, 썸네일 등 기본 기능</li>			  
			</ul>
		</div>
</body>
</html>
