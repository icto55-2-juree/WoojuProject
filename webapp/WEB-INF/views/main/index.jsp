<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우주특공대</title>
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
	
	body{
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
</head>
<body>
<form action="/WoojuProject/member/login" method="post">
<div>
<span id ="top"><p>☆ 우 주 특 공 대 ★</p></span>
<span id ="second"><p>당신도 특공대에 참여하세요 ☞ <a href="/WoojuProject/member/join">JOIN US</a></p></span>
</div>
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="mid" autofocus required></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name="mpassword" required></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="login"></td>
		</tr>
		<!-- <tr>
			<td colspan="2"><input type="button" value="join us" onclick="location.href='register.jsp'"></td>
		</tr> -->
	</table>
	</form>
</body>
</html>