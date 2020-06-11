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
			
			<h1 class="mt-3">${mode eq 'insert' ? '입력화면' : '수정화면' } </h1>			
			<form:form modelAttribute="searchVO" action="insertOK.do" method="POST" enctype="multipart/form-data">
			<div class="form-group">
				<label for="title">제목</label> 
				<input type="text" class="form-control" id="title" name="title"	placeholder="제목" maxlength="100" value="${searchVO.title }">
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="name">이름</label> 
					<input type="text" 	class="form-control" name="name" id="name" placeholder="이름입력" maxlength="10" value="${searchVO.name }">
				</div>
				<div class="form-group col-md-6">
					<label for="tel">등록일</label> 
					<input type="text" 	class="form-control" name="regDate" id="regDate" placeholder="전화번호입력"  value="2020.06.11" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" rows="3" name="content">${searchVO.content }</textarea>
			</div>
			<div class="form-group">
				<label for="multipartFile">파일 업로드</label> 
				<input type="file" class="form-control-file" id="multipartFile" name="multipartFile" value="${searchVO.fileName }">
				<c:if test="${!empty searchVO.fileName }">
				${searchVO.fileName }
				</c:if>
				<div class="img_wrap">
					<img id="img">
				</div>
			</div>
			<div class="text-center mt-3">
				<input type="submit" value="등록" class="btn btn-primary"> 
				<a href="/selectAll.do" class="btn btn-secondary">목록</a>
			</div>			
			</form:form>			
		</div>
</body>
</html>
