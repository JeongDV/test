<%@page import="com.mycompany.biz.board.impl.BoardDAOSpring"%>
<%@page import="java.util.List"%>
<%-- <%@page import="com.mycompany.biz.board.impl.BoardDAO"%> --%>
<%@page import="com.mycompany.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=utf-8"%>

<!-- JSTL활용 -->
<%@taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"  %>

<%
//	List<BoardVO> boardList = (List) session.getAttribute("boardList");	
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>글 목록</title>
<style type="text/css">
	th{background-color: skyblue}	
	div{text-align: center;}
	table{ margin:50px auto; text-align:center; border-collapse: collapse;}
	input{border-width: 0}
	.ast{background-color:#eee; padding:3px; color:#333; font-size:16px; font-weight:500; text-decoration:none; border:1px solid #333; border-radius:2px;}
</style>
</head>
<body>
	<div>
		<h1>글 목록</h1>
		<h3>
			${userName } 님 환영합니다!&nbsp;&nbsp;
			<a href="logout.do" class="ast">로그아웃</a>
		</h3>
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right">
						<select name="searchCondition">
								<option value="TITLE">제목
								<option value="CONTENT">내용
						</select> 
						<input name="searchKeyword" type="text" /> 
						<input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>
		
		<!-- 검색 종료 -->
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="skyblue" width="50">번호</th>
				<th bgcolor="skyblue" width="200">제목</th>
				<th bgcolor="skyblue" width="150">작성자</th>
				<th bgcolor="skyblue" width="250">내용</th>
				<th bgcolor="skyblue" width="150">등록일</th>
				<th bgcolor="skyblue" width="50">조회수</th>
			</tr>

			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.seq}</td>
					<td align="left">
						<a href="getBoard.do?seq=${board.seq}">
							${board.title}
						</a></td>
					<td>${board.writer}</td>
					<td>${board.content }
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>			
			</c:forEach>
			
		</table>
		<br><a href="insertBoard.jsp" class="ast">새글 등록</a>
	</div>
</body>
</html>