<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		width: 250px;
		height: 100px;
		margin: 0 auto;
		font-size: 1.4em;
		color: white;
		font-weight: bold;
		 margin-top: 250px; 
	}
	input{
		width: 100%;
		font-size: 0.9em;
	}
	
	#body{
		font-size: 0.6em;
		background-image: url("./images/index.jpg");
		background-repeat: repeat-x;
		background-position: 100%
		opacity: 0.5;
	}
	#top{
	 text-align: center;
	 font-size: 100px;
	 color: white;
	}
	#second{
	 text-align: center;
	 font-size: 60px;
	 color: white;
	}
	a { color: inherit;  text-decoration: none; } 
</style>
<script type="text/javascript"
	src="/WoojuProject/jquery/jquery-1.9.0.js"></script>
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
</head>
<body>
<div id="body">
<form action="/WoojuProject/member/login" method="post">

	
	<!--  값 입력후 같은 곳으로 간다면, 액션값을 안써줘도 무방 -->
	<form id="join-form" name="joinForm" method="post"
		action="/WoojuProject/member/join">
		<p>
			<label class="block-label" for="mid">아이디</label> <input id="mid"
				name="mid" type="text" value=""> <input id="check-btn"
				type="button" value="중복체크">
		</p>

		<p>
			<label class="block-label">패스워드</label> <input name="mpassword"
				type="password" value="">
		</p>
		<input type="submit" value="가입하기">

	</form>
	
	</form>
	</div>
</body>
</html>