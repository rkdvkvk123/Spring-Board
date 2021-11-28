<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>JunYoung 게시판</title>
 <!-- 제이쿼리 -->
 <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
 <!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<header>
			<%@include file="include/header.jsp" %>
		</header>

		<hr />

		<nav>
			<%@include file="include/nav.jsp" %>
		</nav>

		<hr />

		<section id="container">

			<form role="form" method="post" autocomplete="off">
			
				<div class="form-group">
					<label for="bno" class="col-sm-2 control-label">글 번호</label>
					<div class="col-sm-10">
						<input type="text" id="bno" class="form-control" name="bno" value="${read.bno }" readonly="readonly"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">글 제목</label>
					<div class="col-sm-10">
						<input type="text" id="title" class="form-control" name="title" value="${read.title }" readonly="readonly"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="content" class="col-sm-2 control-label">글 내용</label>
					<div class="col-sm-10">
						<textarea id="content" name="content" class="form-control" readonly="readonly">${read.content } </textarea>
					</div>
				</div>

				<p>
					<label for="writer">작성자</label><input type="text" id="writer" name="writer" value="${read.writer }" readonly="readonly" /> <br>
					<label>작성 날짜<fmt:formatDate value="${read.regDate}" pattern="yyyy-MM-dd" /></label>
				</p>
				<p>
					 <button id="modity_btn">수정</button>
					 <button id="delete_btn">삭제</button>
					 <button id="clear_btn">취소</button>
					 
					 
					 <script>
					 	var formObj = $("form[role='form']");
					 
					 	$("#modity_btn").click(function() {
					 		formObj.attr("action","/board/modify");
					 		formObj.attr("method","get");
					 		formObj.submit();
					 	});
					 	
					 	$("#delete_btn").click(function() {
					 		formObj.attr("action","/board/delete");
					 		formObj.attr("method","get");
					 		formObj.submit();
					 	});
					 	
					 	$("#clear_btn").click(function() {
					 		history.go(1);
					 	})	
					 	
					 </script>
				</p>
			</form>
				<div>
			<ol>
				<c:forEach items="${repList }" var="repList">
					<li>
						<p>
							작성자 : ${repList.writer }<br />
							작성날짜 : <fmt:formatDate value="${repList.regDate }" pattern="yyyy-MM-dd"/>
						</p>
						
						<p>${repList.content }</p>
					</li>
				</c:forEach>
			</ol>
		</div>
		</section>

		<hr />
		


		<footer>
			<%@include file="include/footer.jsp" %>
		</footer>

	</div>

</body>
</html>