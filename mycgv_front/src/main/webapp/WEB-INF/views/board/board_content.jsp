<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV</title>
<link rel="stylesheet"  href="http://localhost:9000/css/mycgv.css">
</head>
<body>
	<!-- Header Include -->
	<iframe src="http://localhost:9000/header" width="100%" height="160px" scrolling="no" frameborder=0 ></iframe>
	
	
	<!---------------------------------------------->
	<!--------------- Content ----------------------->
	<!---------------------------------------------->
	<div class="content">
		<h1>게시판-상세보기</h1>
		<table class="boardContent">	
			<tr>				
				<th>등록일자</th>
				<td>${board.bdate}</td>
				<th>조회수</th>
				<td>${board.bhits}</td>
			</tr>		
			<tr>				
				<th>제목</th>
				<td colspan="3">${board.btitle }</td>
			</tr>
			<tr>				
				<th>내용</th>
				<td colspan="3">${board.bcontent }<br><br>
				<c:if test="${board.bsfile != null}">
					<!--  파일업로드 출력 -->
					<img src="http://localhost:9000/upload/${board.bsfile}"
						width="100" height="70">
				</c:if>
				<br><br><br></td>
			</tr>
			<tr>
				<td colspan="4">
					<a href="/board_update/${board.bid }"><button type="button" class="btn_style">수정하기</button></a>
					<a href="/board_delete/${board.bid }/${board.bsfile}"><button type="button" class="btn_style">삭제하기</button></a>
					<a href="/board_list/1">
						<button type="button" class="btn_style">리스트</button>
					</a>
				</td>
			</tr>			
		</table>	
	</div>
	
	<!-- footer Include -->
	<iframe src="http://localhost:9000/footer" width="100%" height="530px" scrolling="no" frameborder=0></iframe>
	
</body>
</html>







