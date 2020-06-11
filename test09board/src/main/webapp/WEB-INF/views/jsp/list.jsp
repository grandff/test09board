<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<%@ include file="../cmmn/commonLib.jsp" %>
	<body>
		<div class="container">
			<%@ include file="../cmmn/header.jsp" %>		

			<h1 class="mt-3">목록(이미지 썸네일 버전)</h1>

			<form:form modelAttribute="searchVO" method="post" action="search.do" class="form-inline mt-3" >
			<div class="form-group mb-2">
			    <label for="searchKey" class="sr-only">검색어</label>
			    <select name ="searchKey" class="form-control">
			    	<option value="all">전체</option>
			    	<option value="title">제목</option>	
					<option value="name">이름</option>								
				</select>
				</div>
				<div class="form-group mx-sm-3 mb-2">
					<input type="text" class="form-control-plaintext" name = "searchWord" placeholder="검색어" value="${vo.searchWord }">
				</div>
			  			  
			  <button type="submit" class="btn btn-primary mb-2">검색</button>
			</form:form>
		<table class="table mt-3">
			<thead>
				<tr class="text-center">
					<th>번호</th>
					<th>제목</th>
					<th>등록자</th>
					<th>등록일</th>
					<th>썸네일</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			<!-- 목록 on -->
				<c:choose>
					<c:when test="${fn:length(list) > 0}">
						<c:forEach var="vo" items="${list }" varStatus = "status" >
						<tr onclick="goView(${vo.num});" class="text-center mx-auto" style="cursor:pointer;">
							<td >${status.count }</td>
							<td>${vo.title }</td>
							<td>${vo.name }</td>
							<td>${vo.regDate }</td>
							<td><img src="/resources/uploadimg/thumb_${vo.fileName }" class="img-thumbnail"/></td>
							<td><a href="deleteOK.do?num=${vo.num }" class = "btn btn-danger">삭제</a></td>							
						</tr>
						</c:forEach>	
					</c:when>					
					<c:otherwise>
						<tr>
							<td colspan="6">등록된 글이 없습니다.</td>
						</tr>
					</c:otherwise>
				
				</c:choose>											
			<!-- 목록 off -->
			</tbody>
		</table>
		
		<form:form  modelAttribute="searchVO" method="post" id="viewForm" action="selectOne.do">
			<input type="hidden" name="num" id="searchNum"/>
		</form:form>
			
		</div>
</body>
</html>
