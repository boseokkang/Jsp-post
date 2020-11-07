<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 페이지</title>
<link rel="stylesheet" href="/post/static/css/style.css" />
</head>
<body>
	<header>
		<h1>게시글 수정 페이지</h1>
	</header>
	<hr />
		
		<%@include file="../include/nav.jsp"%>

		<section>
				<form action="/post/post?cmd=saveProc" method="post">
						<table border="1">
							<tr>
									<th>제목</th>
									<td><input value="제목입니다. 넣기" type="text" name="title" /></td>
							</tr>
							<tr>
									<th>내용</th>
									<td><textarea rows="3" cols="22" name="content">내용입니다.</textarea></td>
							</tr>
						</table>
						<button>저장</button>
				</form>
		</section>
		<footer>
			<p>Created By Post.</p>
			<p>김해시 김해 708</p>
		</footer>
</body>
</html> 