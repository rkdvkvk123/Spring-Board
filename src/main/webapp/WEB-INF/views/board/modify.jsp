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
					<input type="text" id="bno" name="bno" value="${modify.bno }" readonly="readonly"/>
				</p>
				
				<p>
					<label for="title">글 제목</label>
					<input type="text" id="title" name="title" value="${modify.title }" />
				</p>
				<p>
					<label for="content">글 내용</label>
					<textarea id="content" name="content" >${modify.title } </textarea>
				</p>
				<p>
					<label for="writer">작성자</label><input type="text" id="writer" name="writer" value="${modify.writer }" readonly="readonly" /> <br>
					<label>작성 날짜<fmt:formatDate value="${modify.regDate}" pattern="yyyy-MM-dd" /></label>
				</p>
				<p>
					 <button id="modity_btn">수정</button>
					 <button id="clear_btn">취소</button>
					 
					 
					 <script>
					 	var formObj = $("form[role='form']");
					 
					 	$("#modity_btn").click(function() {
					 		var tmp = confirm("수정하시겠습니까?");
					 		
					 		if(tmp == true) {
					 			alert(tmp);
					 			formObj.attr("action","/board/modify");
						 		formObj.attr("method","post");
						 		formObj.submit();
					 		} else if(tmp == false) {
					 			alert(tmp);
					 			alert("취소하셨습니다.");
					 		}
					 	});
					 	
					 	$("#clear_btn").click(function() {
					 		formObj.attr("action","/board/read?bno=" + $("#bno").val());
					 		formObj.attr("method","get");
					 		formObj.submit();
					 	})	
					 	
					 </script>
				</p>
			</form>

		</section>

		<hr />

		<footer>
			<%@include file="include/footer.jsp" %>
		</footer>

	</div>

</body>
</html>