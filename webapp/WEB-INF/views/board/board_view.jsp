<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../layout/styles/layout.css"
	type="text/css" />
<script type="text/javascript" src="../layout/scripts/jquery.min.js"></script>
<!-- Superfish Menu -->
<!-- <script type="text/javascript"
	src="../layout/scripts/superfish/jquery.hoverIntent.js"></script>
<script type="text/javascript"
	src="../layout/scripts/superfish/superfish.js"></script> -->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['찬성',     ${concnt}],
          ['반대',      ${procnt}],
        ]);

        var options = {
          title: '투표 결과',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
    </script>
<style type="text/css">
#boardContent {
	font-size: 12px;
}
#red{
color:red
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
				<div class="content">
					<h1>${vo.btitle }</h1>
					${vo.bdate.substring(0,10) } | ${vo.mid } <br> <br>
						<img class="img" src="../upload/${vo.bimage }" alt="" width="50%"
							height="50%" />
					<br> <br> <span id="boardContent">${vo.bcontent }</span>
					<br> <br>
					<c:if test="${vo.bstatus=='진행중' }">
					<div>
						<p id="red">게시물의 내용에 찬성/ 반대 투표를 해 주세요</p>
							
								<c:choose>
								<c:when test="${empty memberId }">
									<form action="/WoojuProject/poll/insert?bno=${vo.bno }"
										method="post">
										<label><input type="radio" value="pcon" name="result">찬성</label>
										<label><input type="radio" value="ppro" name="result">반대</label><br>
										<br> <input type="submit" value="투표하기">
									</form>
								</c:when>
							<c:otherwise>
								 투표를 완료한 게시물 입니다.  
								<div id="donutchart" style="width: 900px; height: 500px;"></div>
							</c:otherwise>
						</c:choose>	
					<c:if test="${vo.mid == authMember.mid }">
					<div id="endBtn">
					<form action="/WoojuProject/board/updateBstatus?bno=${vo.bno }" method="post">
					<p id="red">투표 완료를 원하시면 아래 버튼을 눌러주세요.</p>
					<input type="submit" value="투표 완료">
					</form>
					</div>
					</c:if>
					</div>
					</c:if>
					<c:if test="${vo.bstatus=='진행완료' }">
					<p style="color:red;">진행이 완료된 투표입니다.</p>
					<div id="donutchart" style="width: 900px; height: 500px;"></div>
					</c:if>
					<br> <br>
					
					<div id="comments">
						<h2>Comments</h2>
						<ul class="commentlist">

							<c:forEach var="r" items="${list }">
								<li class="comment_odd">
									<div class="author">
										<span class="name">${r.mid }</span> <span class="wrote">wrote:</span>
									</div>
									<div class="submitdate">${r.rdate }</div>
									<p>${r.rcontent }</p>
								</li>
							</c:forEach>
						</ul>
					</div>



					<h2>Write A Comment</h2>
					<div id="respond">
						<form action="/WoojuProject/reply/insertReply" method="post">
							<input type="hidden" name="mid" id="mid"
								value="${authMember.mid }" size="22" /> <input type="hidden"
								name="bno" id="bno" value="${vo.bno }">
							<p>
								<textarea name="rcontent" id="rcontent" cols="100%" rows="10"></textarea>
								<label for="comment" style="display: none;"><small>Comment
										(required)</small></label>
							</p>
							<p>
								<input name="submit" type="submit" id="submit" value="댓글등록" />
								&nbsp; <input name="reset" type="reset" id="reset" tabindex="5"
									value="댓글초기화" />
							</p>
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
		</div>
	</div>

</body>
</html>