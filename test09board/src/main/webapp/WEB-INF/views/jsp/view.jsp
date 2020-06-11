<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<%@ include file="../cmmn/commonLib.jsp" %>
	<body>
		<div class="container">
			<%@ include file="../cmmn/header.jsp" %>		
			<h1 class="mt-3">상세화면</h1>						
			<div class="form-group">
				<label for="title">제목</label> 
				<div class="form-control"><p class="text-justify">${model.title }</p></div>						
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="name">이름</label>
					<div class="form-control"><p class="text-justify">${model.name }</p></div> 					
				</div>
				<div class="form-group col-md-6">
					<label for="tel">등록일</label>
					<div class="form-control"><p class="text-justify">${model.regDate }</p></div> 					
				</div>
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<div class="form-control"><p class="text-justify">${model.content }</p></div>				
			</div>
			<div class="form-group">
				<label for="multipartFile">첨부이미지</label>
				<img src="/resources/uploadimg/${model.fileName }" class="rounded mx-auto d-block"/>				
			</div>
			<div class="text-center mt-3">
				<a href="/insert.do?num=${model.num }" class="btn btn-primary">수정</a>			
				<a href="/deleteOk.do?num=${model.num }" class="btn btn-danger">삭제</a>
				<a href="/selectAll.do" class="btn btn-secondary">목록</a>
			</div>
		</div>
</body>
</html>
