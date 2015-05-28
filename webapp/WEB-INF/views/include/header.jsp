<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

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
<div class="wrapper">
  <div id="header">
    <h1><a href="/WoojuProject/main">☆ 우 주 특 공 대 ★<img src=""/></a></h1>
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper">
  <div id="topbar">
  	<div class="fl_right">${authMember.mid }님 환영합니당 ^o^</div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper">
  <div id="topnav">
    <ul class="nav">
      <li class="active"><a href="/WoojuProject/main">Homepage</a></li>
      <li><a href="/WoojuProject/board/board_list">Poll board</a></li>
      <li><a href="/WoojuProject/aboutus">About Us</a></li>
      <li><a href="/WoojuProject/member/uinfo">MyPage</a></li>
      <li><a href="/WoojuProject/member/logout">Logout</a></li>
      
    </ul>
    <div class="clear"></div>
  </div>
</div>
</body>
</html>