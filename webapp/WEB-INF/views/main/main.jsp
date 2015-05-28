<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Template Name: Realistic
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>우주특공대</title>
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
</head>
<body id="top">
	<div id="header">
		<c:import url="/WEB-INF/views/include/header.jsp">
		</c:import>
	</div>
<!-- ####################################################################################################### -->
<div class="wrapper">
  <div class="container">
    <!-- ####################################################################################################### -->
    <div id="hpage_latest">
      <ul>
        <li>
    	<p><strong>최신 등록 게시글</strong></p>
          <div class="imgholder"><a href="/WoojuProject/board/getBoard?bno=${vo.bno }"><img src="../upload/${vo.bimage }" width="260" height="180" alt="" /></a></div>
          <p><a href="/WoojuProject/board/getBoard?bno=${vo.bno }">${vo.btitle }</a></p>
        </li>
        <li class="last">
        <p><strong>인기 게시글</strong></p>
          <div class="imgholder"><a href="/WoojuProject/board/getBoard?bno=${vo2.bno }"><img src="../upload/${vo2.bimage }" width="260" height="180" alt="" /></a></div>
          <p><a href="/WoojuProject/board/getBoard?bno=${vo2.bno }">${vo2.btitle }</a></p>
        </li>
      </ul>
      <br class="clear" />
    </div>
  </div>
</div>
<!-- ####################################################################################################### -->
	<div id="footer">
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>