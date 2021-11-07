<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>JunYoung 게시판</title>
 <!-- 제이쿼리 -->
 <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>

	<div id="root">
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
				<p>
					<label for="bno">글 번호</label>
					<input type="text" id="bno" name="bno" value="${read.bno }" readonly="readonly"/>
				</p>
				
				<p>
					<label for="title">글 제목</label>
					<input type="text" id="title" name="title" value="${read.title }" readonly="readonly"/>
				</p>
				<p>
					<label for="content">글 내용</label>
					<textarea id="content" name="content" readonly="readonly">${read.title } </textarea>
				</p>
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