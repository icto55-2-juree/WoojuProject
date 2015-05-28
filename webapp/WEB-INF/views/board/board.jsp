<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../layout/styles/layout.css" type="text/css" />
<script type="text/javascript" src="../layout/scripts/jquery.min.js"></script>
<!-- Superfish Menu -->
<script type="text/javascript" src="../layout/scripts/superfish/jquery.hoverIntent.js"></script>
<script type="text/javascript" src="../layout/scripts/superfish/superfish.js"></script>
<script type="text/javascript">
jQuery(function () {
    jQuery('ul.nav').superfish();
});
</script>
<style type="text/css">
.wrapper{
width: 100%
}
input{
float: right;
margin: 10px;
}
.content{
width: 800px;
}

 .myButton {
	-moz-box-shadow:inset 0px 1px 0px 0px #ffffff;
	-webkit-box-shadow:inset 0px 1px 0px 0px #ffffff;
	box-shadow:inset 0px 1px 0px 0px #ffffff;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ededed), color-stop(1, #dfdfdf));
	background:-moz-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
	background:-webkit-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
	background:-o-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
	background:-ms-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
	background:linear-gradient(to bottom, #ededed 5%, #dfdfdf 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#dfdfdf',GradientType=0);
	background-color:#ededed;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:1px solid #dcdcdc;
	display:inline-block;
	cursor:pointer;
	color:#777777;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:6px 24px;
	text-decoration:none;
	text-shadow:0px 1px 0px #ffffff;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #dfdfdf), color-stop(1, #ededed));
	background:-moz-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
	background:-webkit-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
	background:-o-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
	background:-ms-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
	background:linear-gradient(to bottom, #dfdfdf 5%, #ededed 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dfdfdf', endColorstr='#ededed',GradientType=0);
	background-color:#dfdfdf;
}
.myButton:active {
	position:relative;
	top:1px;
} 

</style>
</head>
<body>
<div id="header">
		<c:import url="/WEB-INF/views/include/header.jsp">
		</c:import>
	</div>
<div class="wrapper">
  <div class="container">
    <div class="whitebox">
      <div class="content" style="width: 900px; margin: 0 auto;" >
        <form action="/WoojuProject/board/insert" method="get">
        <input class="myButton" type="submit" value="글쓰기"/>
        </form>
        <table summary="Summary Here" cellpadding="0" cellspacing="0" style="margin: auto;" >
          <thead>
            <tr>
              <th></th>
              <th width="500px">제목</th>
              <th width="80px">날짜</th>
              <th width="80px">글쓴이</th>
              <th width="80px">진행상태</th>
              <th width="40px">조회수</th>
            </tr>
          </thead>
          <tbody>
       <c:forEach var="g" items="${list }">
            <tr class="light">
              <td style="text-align: center;">${g.bno }</td>
              <td><a href="/WoojuProject/board/getBoard?bno=${g.bno }">${g.btitle }  <span>[${g.rno_cnt }]</span></a></td>
              <td style="text-align: center;">${g.bdate }</td>
              <td style="text-align: center;">${g.mid }</td>
              <c:if test="${g.bstatus=='진행중' }">
              <td style="color: red; text-align: center;">${g.bstatus }</td>
              </c:if>
              <c:if test="${g.bstatus=='진행완료' }">
              <td style="color: green; text-align: center;">${g.bstatus }</td>
              </c:if>
              <td style="text-align: center;">${g.bview_cnt }</td>
            </tr>
        </c:forEach>    
            
          </tbody>
        </table>
       
      </div>
      
      <div class="clear"></div>
    </div>
  </div>
</div>

</body>
</html>