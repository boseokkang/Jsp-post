<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 페이지</title>
<link rel="stylesheet" href="/post/static/css/style.css" />
</head>
<body>
			<header>
				<h1>게시글 작성 페이지</h1>
			</header>
			<hr />
				
			<%@include file="../include/nav.jsp"%>

			<section>
					<form action="/post/post?cmd=saveProc" method="post">
					<input type="hidden" value="${sessionScope.principal.id}" name="memberId" />
						<table border="1">
							<tr>
									<th>제목</th>
									<td><input type="text" name="title" /></td>
							</tr>
							<tr>
									<th>내용</th>
									<td><textarea rows="3" cols="22" name="content"></textarea></td>
							</tr>
						</table>
									<button>저장</button>
					</form>
			</section>
	<footer>
			<p>Created By Post.</p>
			<p>김해시 김해대로</p>
	</footer>
</body>
</html> 