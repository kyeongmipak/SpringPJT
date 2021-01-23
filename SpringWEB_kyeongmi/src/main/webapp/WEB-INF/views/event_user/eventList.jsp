<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<title>이벤트 목록</title>
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
<style>
#notice{
	width:1000px;
	margin:0 auto;
	margin-top:50px;
}
tr{
height: 30px;
}
a{
text-decoration: none;
}
a:link {
  color: black;
  background-color: transparent;
  text-decoration: none;
}

a:visited {
  color: black;
  background-color: transparent;
  text-decoration: none;
}

a:hover {
  color: #6fa168;
  background-color: transparent;
  text-decoration: none;
}

a:active {
  color: black;
  background-color: transparent;
  text-decoration: none;
}
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
#table1{
margin: auto 0;
width: 100%;
text-align: center;
}
button a {
	color:#fff;
	text-decoration:none;
}

button {
	width:250px;
	height:50px;
	line-height:50px;
	text-align:center;
	border:1px solid #6fa168;
	border-radius:3px;
	font-weight:bold;
	background-color:#6fa168;
}

button:hover {
	color:#000;
	background-color:#fff;
	}
	
	.search1{
		 width: 50%;
	   	 margin: 4px auto;
	     text-align: center;
	     display: inline-block;
	     margin-left: 20%;
	     margin-right: auto;
	     margin-top: 100px;
	  	 border:0px;
		
	}
	
	.search1 #search_select{
		width: 120px;
	     font-size: 16px;
	     height: 40px;
	     margin-right: 0;
	     float: left;
	     box-sizing: border-box;
	     transition: all 0.15s;
	}
	.search1 #search_submit{
		 width: 80px;
	     padding: 0px;
	     font-size: 16px;
	     height: 40px;
	     margin-right: 0;
	     float: left;
	     box-sizing: border-box;
	     transition: all 0.15s;
	     margin-left: 10px;
	     
	}
	.search1 #search_text{
		width: 350px;
	     padding: 15px 0 15px 20px;
	     font-size: 16px;
	     height: 35px;
	     float: left;
	     box-sizing: border-box;
	     transition: all 0.15s;
	     text-align: left;
	     margin-left: 10px;
	}
	
}
</style>
<%@include file="../main/Header.jsp" %>
<body>

<%request.setCharacterEncoding("utf-8"); %>
<div id="notice">
<h2>&nbsp; 이벤트</h2><br>
	<table class="search1" border="0">
		<form action="searchQuery" method="post">
			<tr >
				<td><select id="search_select" name="query">
					<option value="ESEQNO">번호</option>
					<option value="ETITLE" selected="selected">제목</option>
					<option value="ECONTENT">내용</option>
				</select></td>
				<td><input id="search_text" type="text" name="content" placeholder="검색어를 입력해주세요."></td>
				<td><input id="search_submit" type="submit" value="검색"></td>
			</tr>
		</form>
	</table>

		<!-- 	<form action="searchQuery" method="post">
				<select name="query" style="">
					<option value="ESEQNO">번호</option>
					<option value="ETITLE" selected="selected">제목</option>
					<option value="STARTDATE">시작날짜</option>
				</select>&nbsp;&nbsp;&nbsp;
				<input type="text" name="content" size="50" />
				<input type="submit" value="검색">
			</form> -->
	


	<br/><br />

	<table>
		<tr>
			<th width="60px;">번호</th>
			<th width="370px;">제목</th> <!-- 제목 클릭시 수정은 불가능한 이벤트 내용과 당첨자 정보 띄우기  -->
			<th width="100px;">시작 날짜</th>
			<th width="100px;">종료 날짜</th>
		</tr>
		<c:forEach items="${eventList}" var="dto">
			<tr>
			<td align="center">${dto.eSeqno}</td><!-- 번호 -->
				<td><a href = "eventViewUserDetail?eTitle=${dto.eTitle}&eSeqno=${dto.eSeqno}&eFilename=${dto.eFilename}&eContent=${dto.eContent}&startDate=${dto.startDate}&endDate=${dto.endDate}">${dto.eTitle}</a></td><!-- 제목 --> 
				<td align="center">${dto.startDate}</td><!-- 이벤트 시작 날짜 -->
				<td align="center">${dto.endDate}</td><!-- 이벤트 종료 날짜 -->
			</tr>
		</c:forEach>
	</table>
	<br>
	<div id="table1">
	<table>
			<tr>
				<c:if test="${startPage!=1}">
					<a href="./eventList?page=${startPage-1}">[이전]</a>
				</c:if>
				
			   <c:forEach var="i" begin="${startPage}" end="${endPage}" varStatus="cnt">
			       <a href="./eventList?page=${i}">[
			        <!-- <font color="#000000" /> -->
			          <c:if test="${currentPage == i}">
			          <font color="#bbbbbb" />
			        </c:if>
			        ${i}
			       </font>
			        ]
			       </a>
			   </c:forEach> 
				<c:if test="${endPage!=totalPage}">
					<a href="./eventList?page=${endPage+1}">다음 ▶</a>
				</c:if>
			</tr>
		</table>
		</div>
	</div>	
</body>
<%@include file="../main/Footer.jsp" %>
</html>