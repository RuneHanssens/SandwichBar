<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="nl">
<head>
    <meta charset="utf-8">
    <%@include file="header.jspf"%>

<link rel="stylesheet" href="/css/stylesheet.css">
</head>
<header>
    <nav>
        <img src="${pageContext.request.contextPath}/images/ucllLogo.png" class="logo">
        <a href="${pageContext.request.contextPath}/sandwich.htm">Broodjes</a>
        <a href="${pageContext.request.contextPath}/graph.htm">Statistieken</a>
    </nav>
</header>
<body>
<div class="container">
<div id="graphMoist">
    <h3>Vochtigheid</h3>
    <div id="doughnut">
    <canvas id="myChart1"></canvas>
    <div id="donut-inner">
    <h5>80%</h5>
</div>
    </div>
    
</div>
<div id="graphTemp">
    <h3>Temperatuur</h3>
    <div><canvas id="myChart2"></canvas></div>
</div>
<div id="graphBread">
    <h3>Populaire broodjes</h3>
    <div><canvas id="myChart3"></canvas></div>
</div>
</div>

</body>
</html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/graph.js"></script>