<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
<!-- <link href="../css/project/index.css" rel="stylesheet">  引用到外部导致图片失效-不能解决的问题-->
<style type="text/css">
/* reset start */
html,body{ overflow:hidden; height:100%;}
body,h1,h2,h3,h4,p,ul,ol{ padding:0; margin:0; font:14px "微软雅黑";}
li{ list-style:none;}
img{ border:none;}
a{ text-decoration:none;}
a:active{ color:#009ee0;}
/* reset end */

/* common start */
.clear{zoom:1;}
.clear:after{ content:""; display:block; clear:both;}
.commonTitle{ color:#009ee0; font-size:80px; line-height:0.8; font-weight:bold; letter-spacing:-5px;}
.commonText{ color:white; line-height:1.5; font-size:15px;}
/* common end */

/* frame start */
#main{ width:100%; height:100%;}
#header{ width:100%; height:80px; background:white;}
#headerMain{ width:1100px; height:100%; margin:0 auto; position:relative;}
#logo{ float:left; margin-top:30px;}
#nav{ float:right; margin-top:50px;}
#nav li{ float:left; position:relative; margin-left:40px;}
#nav li .up{ position:absolute; left:0; top:0; color:black; width:0%; overflow:hidden; transition:.5s width;}
#nav li:hover .up{ width:100%;}
#arrow{ width:21px; height:11px; background:url(${pageContext.request.contextPath}/image/index/menuIndicator.png) no-repeat; position:absolute; left:50%; bottom:-11px; transition:.5s left; z-index:10;}
#content{ width:100%; position:relative; overflow:hidden;}
#list{ width:100%; position:absolute; top:0; left:0; transition:.5s top;}
#list .liList{ width:2000px; position:relative; left:50%; margin-left:-1000px; overflow:hidden;}
#list .divList{ width:1100px; height:520px; margin:0px auto; position:relative;}
#menu{ position:fixed; right:0; top:50%; z-index:20;}
#menu li{ width:10px; height:10px; border-radius:50%; margin:10px; border:1px white solid; cursor:pointer;}
#menu li.active{ background:white; cursor:default;}
/* frame end */

/* home start */
#home{ background:url(${pageContext.request.contextPath}/image/index/bg1.jpg) no-repeat;}
#homeContent .homeContent1{ width:100%; height:100%; position:relative; perspective:800px; transform-style:preserve-3d; -webkit-perspective:800px; -webkit-transform-style:preserve-3d; transition:1s;}
#homeContent .homeContent1 li{  width:100%; height:100%; position:absolute; left:0; top:0; background:black; visibility:hidden;}
#homeContent .homeContent1 li:nth-of-type(1){background:url(${pageContext.request.contextPath}/image/index/action1.jpg) no-repeat; position:absolute;}
#homeContent .homeContent1 li:nth-of-type(2){background:url(${pageContext.request.contextPath}/image/index/action2.jpg) no-repeat; position:absolute;}
#homeContent .homeContent1 li:nth-of-type(3){background:url(${pageContext.request.contextPath}/image/index/action3.jpg) no-repeat; position:absolute;}
#homeContent .homeContent1 li:nth-of-type(4){background:url(${pageContext.request.contextPath}/image/index/action4.jpg) no-repeat; position:absolute;}
#homeContent .homeContent1 li h1{ color:white; text-align:center; padding-top:200px;}
#homeContent .homeContent1 li.active{ z-index:1; visibility:visible;}

#homeContent .homeContent2{ position:absolute; bottom:0; z-index:2; text-align:center; width:100%; transition:1s;}
#homeContent .homeContent2 li{ width:20px; height:20px; border-radius:50%; background:rgba(255,255,255,0.5); display:inline-block; margin:2px; box-shadow:0 0 4px rgba(25,25,25,0.8); cursor:pointer;}
#homeContent .homeContent2 li.active{ background:white; cursor:default;}

#homeContent .homeContent1 .leftShow{ animation:1s homeLeftShow; visibility:visible; z-index:3;-webkit-animation:1s homeLeftShow;}
#homeContent .homeContent1 .rightHide{ animation:1s homeRightHide; visibility:hidden; -webkit-animation:1s homeRightHide;}


#homeContent .homeContent1 .leftHide{ animation:1s homeLeftHide; visibility:hidden; -webkit-animation:1s homeLeftHide;}
#homeContent .homeContent1 .rightShow{ animation:1s homeRightShow; visibility:visible; z-index:3; -webkit-animation:1s homeRightShow;}

@keyframes homeLeftHide{
	0%{ transform:translateZ(0px); visibility:visible;}
	40%{ transform:translate(-40%,0) scale(0.8) rotateY(20deg);}
	100%{ transform:translateZ(-200px);}
}
@keyframes homeRightShow{
	0%{ transform:translateZ(-200px);}
	40%{ transform:translate(40%,0) scale(0.8) rotateY(-20deg);}
	100%{ transform:translateZ(0px);}
}

@-webkit-keyframes homeLeftHide{
	0%{ -webkit-transform:translateZ(0px); visibility:visible;}
	40%{ -webkit-transform:translate(-40%,0) scale(0.8) rotateY(20deg);}
	100%{ -webkit-transform:translateZ(-200px);}
}
@-webkit-keyframes homeRightShow{
	0%{ -webkit-transform:translateZ(-200px);}
	40%{ -webkit-transform:translate(40%,0) scale(0.8) rotateY(-20deg);}
	100%{ -webkit-transform:translateZ(0px);}
}

@keyframes homeLeftShow{
	0%{ transform:translateZ(-200px);}
	40%{ transform:translate(-40%,0) scale(0.8) rotateY(20deg);}
	100%{ transform:translateZ(0px);}
}
@keyframes homeRightHide{
	0%{ transform:translateZ(0px); visibility:visible;}
	40%{ transform:translate(40%,0) scale(0.8) rotateY(-20deg);}
	100%{ transform:translateZ(-200px);}
}
@-webkit-keyframes homeLeftShow{
	0%{ -webkit-transform:translateZ(-200px);}
	40%{ -webkit-transform:translate(-40%,0) scale(0.8) rotateY(20deg);}
	100%{ -webkit-transform:translateZ(0px);}
}
@-webkit-keyframes homeRightHide{
	0%{ -webkit-transform:translateZ(0px); visibility:visible;}
	40%{ -webkit-transform:translate(40%,0) scale(0.8) rotateY(-20deg);}
	100%{ -webkit-transform:translateZ(-200px);}
}

/* home end */

/* course start */
#course{ background:url(${pageContext.request.contextPath}/image/index/bg3.jpg) no-repeat;}
#course .courseContent1{ padding:50px; position:relative; z-index:1;}
#course .courseContent2{ width:400px; padding-left:50px; position:relative; z-index:1;}
#course .courseContent3{ width:480px; position:absolute; right:50px; top:70px; z-index:1;}
#course .courseLine{ width:9px; height:410px; background:url(${pageContext.request.contextPath}/image/index/plus_row.png) no-repeat; position:absolute; left:0; top:0; margin-top:-5px; margin-left:-5px;}
#course .courseLogo{ width:120px; height:132px; float:left; margin-top:1px; position:relative; cursor:pointer; perspective:800px; -webkit-perspective:800px;}
#course .courseBefore{ width:100%; height:100%; position:absolute; left:0; top:0; background-repeat:no-repeat; background-position:center center;  backface-visibility:hidden; -webkit-backface-visibility:hidden; transition:1s;}
#course .courseAfter{ width:100%; height:100%; position:absolute; left:0; top:0; background:#009ee0; color:white; padding:15px; box-sizing:border-box; text-indent:2em; transform:rotateY(-180deg); -webkit-transform:rotateY(-180deg); backface-visibility:hidden;  -webkit-backface-visibility:hidden; transition:1s;}
#course .courseLogo:hover .courseBefore{ transform:rotateY(180deg); -webkit-transform:rotateY(180deg);}
#course .courseLogo:hover .courseAfter{ transform:rotateY(0deg); -webkit-transform:rotateY(0deg);}
#course .plane1{ width:359px; height:283px; background:url(${pageContext.request.contextPath}/image/index/plane1.png) no-repeat; position:absolute; left:300px; top:-100px; transition:1s;}
#course .plane2{ width:309px; height:249px; background:url(${pageContext.request.contextPath}/image/index/plane2.png) no-repeat; position:absolute; left:-100px; top:200px; transition:1s;}
#course .plane3{ width:230px; height:182px; background:url(${pageContext.request.contextPath}/image/index/plane3.png) no-repeat; position:absolute; left:300px; top:400px; transition:1s;}
/* course end */

/* works start */
#works{ background:url(${pageContext.request.contextPath}/image/index/bg4.jpg) no-repeat;}
#worksContent{}
#worksContent .worksContent1{ padding:50px 0 100px 50px; position:relative; z-index:1;}
#worksContent .worksContent2{ padding-left:50px; position:relative; z-index:1;}
#worksContent .worksImgParent{ width:220px; height:133px; float:left; overflow:hidden; margin:0 1px; position:relative;}
#worksContent .worksImgParent:last-of-type{ width:332px;}
#worksContent .worksImgMark{ width:100%; height:100%; position:absolute; left:0; top:0; background:rgba(25,25,25,0.8); color:white; padding:15px; box-sizing:border-box; opacity:0; transition:.5s;}
#worksContent .worksImg{ transition:.5s;}
#worksContent .worksImgMark div{ width:32px; height:34px; background:url(${pageContext.request.contextPath}/image/index/zoomico.png) no-repeat; margin:10px auto; cursor:pointer; transition:.5s;}
#worksContent .worksImgMark div:hover{ background-position:0 -36px;}
#worksContent .worksImgParent:hover .worksImgMark{ opacity:1;}
#worksContent .worksImgParent:hover .worksImg{ transform:scale(1.5) rotate(20deg);}
#worksContent .worksContent3{ width:167px; height:191px; background:url(${pageContext.request.contextPath}/image/index/robot.png) no-repeat; position:absolute; left:900px; top:170px; animation:8s linear infinite worksMove; -webkit-animation:8s linear infinite worksMove; z-index:1;}
@keyframes worksMove{
	0%{}
	49%{transform:rotateY(0deg);}
	50%{ left:450px; transform:rotateY(180deg);}
	100%{ transform:rotateY(180deg);}
}
@-webkit-keyframes worksMove{
	0%{}
	49%{-webkit-transform:rotateY(0deg);}
	50%{ left:450px; -webkit-transform:rotateY(180deg);}
	100%{ -webkit-transform:rotateY(180deg);}
}

/* works end */

/* about start */
#about{ background:url(${pageContext.request.contextPath}/image/index/bg5.jpg) no-repeat;}
#aboutContent .aboutContent1{ padding:50px 0 100px 50px;}
#aboutContent .aboutContent2{ padding-left:50px; width:400px;}
#aboutContent .aboutContent3{}
#about .blueLine{ width:357px; height:998px; background:url(${pageContext.request.contextPath}/image/index/greenLine.png) no-repeat; position:absolute; left:50%; top:0;}
#aboutContent .aboutImg{ position:absolute; width:260px; height:200px; border:5px solid rgba(255,255,255,0.5); border-radius:8px; z-index:3; overflow:hidden; cursor:pointer; transition:1s;}
#aboutContent .aboutImg:nth-of-type(1){ left:750px; top:50px;}
#aboutContent .aboutImg:nth-of-type(2){ left:600px; top:290px;}
#aboutContent .aboutImg ul{ width:100%; height:100%; position:absolute; left:0; top:0; z-index:5;}
#aboutContent .aboutImg ul li{ float:left; position:relative; overflow:hidden;}
#aboutContent .aboutImg ul img{ position:absolute; transition:.5s;}
#aboutContent .aboutImg span{ width:100%; height:100%; position:absolute; left:0; top:0; transform:scale(1.5); -webkit-transform:scale(1.5); transition:.5s;}

/* about end */

/* team start */
#team{ background:url(${pageContext.request.contextPath}/image/index/bg2.jpg) no-repeat;}
#team .teamContent1{ padding:50px; float:left; width:400px; transition:1s;}
#team .teamContent2{ padding:50px; float:right; width:400px; transition:1s;}
#team .teamContent3{ position:absolute; bottom:-150px; left:50%; margin-left:-472px;}
#team .teamContent3 ul{}
#team .teamContent3 li{ width:118px; height:448px; background:url(${pageContext.request.contextPath}/image/index/team.png) no-repeat; float:left; cursor:pointer; transition:1s;}
#canvasBubble{ position:absolute; left:0; bottom:100px; cursor:pointer;}
/* team end */

#music{ width:14px; height:14px; background:url(${pageContext.request.contextPath}/image/index/musicoff.gif) no-repeat; float:left; margin:50px 0 0 5px; cursor:pointer;}
#loading{}
#loading div{ width:100%; height:50%; position:absolute; left:0; background:#009ee0; z-index:50; transition:1s;}
#loading div:nth-of-type(1){ top:0;}
#loading div:nth-of-type(2){ bottom:0;}
#loading span{ width:0%; height:4px; background:white; position:absolute; left:0; top:50%; margin-top:-2px; z-index:60; transition:.5s;}
</style>


<script type="text/javascript" src="../js/project/index.js"></script>
</head>

<body>
<div id="main">
	<div id="loading">
    	<div></div>
        <div></div>
        <span></span>
    </div>
	<div id="header">
    	<div id="headerMain">
        	<a href="#" id="logo">
            	<img src="../image/index/logo.png">
            </a>
            <div id="music">
            	<audio id="audio1" src="../image/index/audio.mp3" preload="auto" loop></audio>
            </div>
            <ul id="nav">
            	<li>
                	<a href="javascript:;">
                    	<div class="up"><img src="../image/index/home_gruen.png"></div>
                        <div><img src="../image/index/home.png"></div>
                    </a>
                </li>
                <li>
                	<a href="javascript:;">
                    	<div class="up">Course</div>
                        <div>Course</div>
                    </a>
                </li>
                <li>
                	<a href="javascript:;">
                    	<div class="up">Works</div>
                        <div>Works</div>
                    </a>
                </li>
                <li>
                	<a href="javascript:;">
                    	<div class="up">About</div>
                        <div>About</div>
                    </a>
                </li>
                <li>
                	<a href="javascript:;">
                    	<div class="up">Team</div>
                        <div>Team</div>
                    </a>
                </li>
            </ul>
            <div id="arrow"></div>
        </div>
    </div>
    <div id="content">
    	<ul id="menu">
        	<li class="active"></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    	<ul id="list">
        	<li id="home" class="liList">
            	<div id="homeContent" class="divList">
                	<ul class="homeContent1">
                    	<!--<li class="active">
                        	<h1 class="commonTitle">one layer</h1>
                        </li>
                        <li>
                        	<h1 class="commonTitle">two layer</h1>
                        </li>
                        <li>
                        	<h1 class="commonTitle">three layer</h1>
                        </li>-->
                    </ul>
                    <ul class="homeContent2">
                    	<!--<li class="active"></li>
                        <li></li>
                        <li></li>-->
                    </ul>
                </div>
            </li>
            <li id="course" class="liList">
            	<div id="courseContent" class="divList">
                	<div class="courseContent1">
                    	<h1 class="commonTitle">
                        	<span>每日</span><br>
                            <span>每个月</span><br>
                            <span>美好的一天</span>
                        </h1>
                    </div>
                    <div class="courseContent2">
                    	<p class="commonText">
                        	让火焰净化一切
                            <br>
                              	用你的双手来来指引天空吧，我的孩子 
                        </p>
                    </div>
                    <div class="courseContent3">
                    	<!--<div class="courseLine"></div>
                        <div class="courseLine" style="left:120px;"></div>
                        <div class="courseLine" style="left:240px;"></div>
                        <div class="courseLine" style="left:360px;"></div>
                        <div class="courseLine" style="left:480px;"></div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1测试文字1测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>
                        <div class="courseLogo">
                        	<div class="courseBefore" style="background-image:url(../image/index/binoli.png);"></div>
                            <div class="courseAfter">测试文字1</div>
                        </div>-->
                    </div>
                    <div class="plane1"></div>
                    <div class="plane2"></div>
                    <div class="plane3"></div>
                </div>
            </li>
            <li id="works" class="liList">
            	<div id="worksContent" class="divList">
                	<div class="worksContent1">
                    	<h1 class="commonTitle">
                        	<span>EINBLICK</span><br>
                            <span>ERKENNTNIS</span><br>
                            <span>ERGEBNIS</span>
                        </h1>
                    </div>
                    <div class="worksContent2">
                    	<!--<div class="worksImgParent">
                        	<img class="worksImg" src="../image/index/worksimg1.jpg">
                            <div class="worksImgMark">
                            	<span>测试文字，哈哈哈啊司法所地方测试文字，哈哈哈啊司法所地方</span>
                                <div></div>
                            </div>
                        </div>
                        <div class="worksImgParent">
                        	<img class="worksImg" src="../image/index/worksimg2.jpg">
                            <div class="worksImgMark">
                            	<span>测试文字，哈哈哈啊司法所地方</span>
                                <div></div>
                            </div>
                        </div>
                        <div class="worksImgParent">
                        	<img class="worksImg" src="../image/index/worksimg3.jpg">
                            <div class="worksImgMark">
                            	<span>测试文字，哈哈哈啊司法所地方</span>
                                <div></div>
                            </div>
                        </div>
                        <div class="worksImgParent">
                        	<img class="worksImg" src="../image/index/worksimg4.jpg">
                            <div class="worksImgMark">
                            	<span>测试文字，哈哈哈啊司法所地方</span>
                                <div></div>
                            </div>
                        </div>-->
                    </div>
                    <div class="worksContent3"></div>
                    <div class=""></div>
                    <div class=""></div>
                    <div class=""></div>
                </div>
            </li>
            <li id="about" class="liList">
            	<div id="aboutContent" class="divList">
                	<div class="aboutContent1">
                    	<h1 class="commonTitle">
                        	<span>DIE</span><br>
                            <span>SPEZIELLE</span><br>
                            <span>VIELFALT</span>
                        </h1>
                    </div>
                    <div class="aboutContent2">
                    	<p class="commonText">
                        	Der bunte Medienmix ist die Faszination die uns antreibt und das, was man an uns schätzt. Von A bis Z und von vorne bis hinten nehmen wir Ihr Projekt unter unsere Fittiche und lassen es zu etwas Großartigem heranwachsen. 
                        </p>
                    </div>
                    <div class="aboutContent3">
                    	<div class="aboutImg">
                        	<ul data-src="../image/index/about1.jpg">
                            </ul>
                            <span style="background:url(../image/index/about2.jpg) no-repeat;"></span>
                        </div>
                        <div class="aboutImg">
                        	<ul data-src="../image/index/about3.jpg">
                            </ul>
                            <span style="background:url(../image/index/about4.jpg) no-repeat;"></span>
                        </div>
                    </div>
                </div>
                <div class="blueLine"></div>
            </li>
            <li id="team" class="liList">
            	<div id="teamContent" class="divList">	
                	<div class="teamContent1">
                    	<h1 class="commonTitle">
                        	<span>WIR SIND</span><br>
                            <span>VOXELAIR</span>
                        </h1>
                    </div>
                    <div class="teamContent2">
                    	<p class="commonText">
                        	Wir sind seit 2002 eine Full-Service-Werbeagentur mit Stammsitz in Heimsheim, zwischen Stuttgart und Karlsruhe. 
                            <br>
                            Über 60 Jahre Erfahrung vereinen das gesamte VoxelAir-Team. Dabei hat jedes Voxel neben professionellem Allroundwissen auch sein ganz spezielles Gebiet, um selbst die individuellsten Kundenwünsche schnell und kompetent umzusetzen. 
                        </p>
                    </div>
                    <div class="teamContent3"></div>
                </div>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
