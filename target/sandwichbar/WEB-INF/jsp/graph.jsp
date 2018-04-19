<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="nl">
<head>
    <meta charset="utf-8">
    <%@include file="header.jspf"%>
</head>
<body>
<header>
    <nav>
        <img src="${pageContext.request.contextPath}/images/ucllLogo.png" class="logo">
        <a href="${pageContext.request.contextPath}/sandwich.htm">Broodjes</a>
        <a href="${pageContext.request.contextPath}/graph.htm">Geschiedenis</a>
    </nav>
</header>
<main>
<div class="sandwichDiv">
    <canvas id ="myChart"></canvas>
</div>
</main>
<footer><p>Gemaakt door Rune, Bjorn, Remi en Maarten</p></footer>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/graph.js"></script>
</html>

