<%@page import="com.mycompany.biz.board.impl.BoardDAOSpring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.biz.board.BoardVO" %>    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	th{background-color: lightgaray}	
	div{text-align: center;}
	table{ margin:50px auto; text-align:center; border: 1px solid black}
	input{border-width: 0}
	.ast{background-color:#eee; padding:3px; color:#333; font-size:16px; font-weight:500; text-decoration:none; border:1px solid #333; border-radius:2px;}
</style>
</head>
<body>
	<div>
		<h1>글 상세</h1>
		<a href="logout.do" class="ast">로그아웃</a>
		<hr>
		<form action="updateBoard.do" method="post">
			<input type="hidden" name="seq" value="${board.seq }">
			<table border="1">
				<tr>
					<tr>
					<td bgcolor="skyblue" width="70px">제목</td>
					<td align="left"><input type="text" name="title"
					                  value="${board.title }"></td>
				</tr>
				<tr>
					<td bgcolor="skyblue" >작성자</td>
					<td align="left">${board.writer }</td>
				</tr>
				<tr>
					<td bgcolor="skyblue" >내용</td>
					<td align="left"><textarea name="content" cols="40" row="10">
									  ${board.content }
									</textarea></td>
				</tr>
				<tr>
					<td bgcolor="skyblue" >등록일</td>
					<td align="left">${board.regDate }</td>
				</tr>
				<tr>
					<td bgcolor="skyblue" >조회수</td>
					<td align="left">${board.cnt }</td>
				</tr>
				<tr>
					<td colspan="2" align="center" >
						<input type="submit" value="글 수정">
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp" class="ast">글 등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=${board.seq }" class="ast">글 삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do" class="ast">글 목록</a>		
	</div>
</body>
</html>
















