<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>우주특공대-합류</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/WoojuProject/layout/styles/layout.css" type="text/css" />
<script type="text/javascript" src="layout/scripts/jquery.min.js"></script>
<!-- Superfish Menu -->
<script type="text/javascript" src="layout/scripts/superfish/jquery.hoverIntent.js"></script>
<script type="text/javascript" src="layout/scripts/superfish/superfish.js"></script>
<script type="text/javascript">
jQuery(function () {
    jQuery('ul.nav').superfish();
});
</script>
<script type="text/javascript" src="/WoojuProject/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#join-form").submit(function(){
		if($("#check-btn").is(":visible") == true){
			alert("아이디 중복여부를 확인해주세요.");
			return false;
		}
		return true;
	});
	
	$("#mid").change(function(){
		$("#check-btn").show();
	})
	
	$("#check-btn").click(function(){
		var mid="mid="+$("#mid").val();
		if(mid == ""){
			alert("아이디를 입력해주세요.");
			return;
		}
		console.log(mid);
		$.ajax({
			url : "/WoojuProject/member/checkmid",
			type : "post",
			data : mid,
			success : function(map){
				if(map.result == true){
					$("#check-btn").hide();
				}else if(map.result == false ){
					alert(map.msg);
				}
			}
		});
			
		
	})
		
})
</script>

<!-- / Superfish Menu -->
</head>
<body>
	<div id="container">
		<div id="header">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		</div>
		<div id="content">
			<div id="user">

				<!--  값 입력후 같은 곳으로 간다면, 액션값을 안써줘도 무방 -->
				<form id="join-form" name="joinForm" method="post" action="/WoojuProject/member/join">
					<label class="block-label" for="mid">아이디</label>
					<input id="mid" name="mid" type="text" value="">
					<input id="check-btn" type="button" value="중복체크">
					
					<label class="block-label">패스워드</label>
					<input name="mpassword" type="password" value="">
										
					<input type="submit" value="가입하기">
					
				</form>
			</div>
		</div>
		
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp" />
		</div>
	</div>
</body>
</html>