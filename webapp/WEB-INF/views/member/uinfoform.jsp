<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>우주특공대-비밀번호수정</title>

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
<!-- / Superfish Menu -->
<style type="text/css">

@import url(http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css);
p{
	margin-top: 100px;
	font-size: 3.0em;
	font-family: 'Nanum Brush Script';
	text-align: center;
}
#woo{
	font-size: 1.4em;
	text-align: center;
	margin-bottom: 180px;
}
</style>
</head>
<body>
	<div id="container">
		<div id="header">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		</div>
		<div id="content">
			<div id="user">

				<form id="uinfo" name="uinfo" method="post" action="/WoojuProject/member/uinfo">
					<input type="hidden" name="mid" value="${authMember.mid}">
					<p> 비밀번호 수정하기 </p>
					<div id="woo2ree">
					<label class="block-label">패스워드</label>
					<input name="mpassword" type="password" value="">
										
					<input type="submit" value="수정하기">
					</div>
					
					
				</form>
			</div>
		</div>
		
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp" />
		</div>
	</div>
</body>
</html>